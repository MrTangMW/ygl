<template>
	<view class="container">
		<!-- 聊天内容区域 -->
		<scroll-view class="chat-container" scroll-y :scroll-top="scrollTop" scroll-with-animation>
			<view v-for="(msg, index) in messages" :key="index" class="message-row" :class="msg.role">
				<!-- AI头像 -->
				<image v-if="msg.role === 'assistant'" src="/static/image/deepseek.png" class="avatar" />

				<!-- 消息内容 -->
				<view class="message-bubble">
					<text class="message-text">{{ msg.content }}</text>
					<text class="message-time">{{ msg.time }}</text>
				</view>

				<!-- 用户头像 -->
				<image v-if="msg.role === 'user'" src="/static/image/head.png" class="avatar" />
			</view>

			<!-- 加载状态 -->
			<view v-if="isLoading" class="loading">
				<text class="loading-text">AI正在思考中</text>
				<view class="loading-dots">
					<text>.</text><text>.</text><text>.</text>
				</view>
			</view>
		</scroll-view>

		<!-- 输入区域 -->
		<view class="input-area">
			<input v-model="inputText" placeholder="输入你的问题" class="input" placeholder-class="placeholder"
				@confirm="sendMessage" :disabled="isLoading" />
			<button class="send-btn" @click="sendMessage" :disabled="isLoading || !inputText.trim()">
				<uni-icons type="paperplane" size="20" color="#fff"></uni-icons>
			</button>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				messages: [], // 聊天记录
				inputText: "", // 输入内容
				isLoading: false, // 加载状态
				scrollTop: 0, // 滚动条位置
				ws: null // WebSocket 实例
			};
		},
		mounted() {
			this.loadHistory(); // 加载历史记录
			this.initWebSocket();
		},
		methods: {
			initWebSocket() {
				var websocket = new WebSocket("ws://127.0.0.1:8086/ygl/webSocket");
				websocket.onmessage=function (event){
					const response = event.data;
					console.log('收到消息:', response);
					this.isLoading = false;
					
					// 添加AI回复
					this.messages = [...this.messages, {
						role: "assistant",
						content: response,
						time: this.getCurrentTime()
					}];
					this.saveHistory();
					this.scrollToBottom();
				}
				websocket.onerror=function(err){
					console.error('WebSocket 错误:', err);
					uni.showToast({
						title: '连接异常',
						icon: 'none'
					});
				}
			},
			// 加载历史记录（示例）
			loadHistory() {
				const history = uni.getStorageSync('chatHistory') || [];
				this.messages = history;
			},

			async sendMessage() {
				if (!this.inputText.trim()) return;

				const userMsg = {
					role: "user",
					content: this.inputText,
					time: this.getCurrentTime()
				};

				// 添加用户消息
				this.messages = [...this.messages, userMsg];
				this.saveHistory();
				this.scrollToBottom();

				this.isLoading = true;

				// 发送消息到 WebSocket 服务器
				try {
					await new Promise(resolve => this.ws.send({
						data: this.inputText
					}, resolve));
				} catch (err) {
					uni.showToast({
						title: '发送失败',
						icon: 'none'
					});
					this.isLoading = false;
				}

				this.inputText = "";
			},
			// 发送消息
			//  async sendMessage() {
			//    if (!this.inputText.trim()) return;

			//    const userMsg = {
			//      role: "user",
			//      content: this.inputText,
			//      time: this.getCurrentTime()
			//    };

			//    // 添加用户消息
			//    this.messages = [...this.messages, userMsg];
			//    this.saveHistory();
			//    this.scrollToBottom();
			//    // 模拟流式响应（实际替换为WebSocket或SSE）
			//    this.isLoading = true;
			//    const aiResponse =await this.$request.apiRequest('/deepseek/chat',{
			//  prompt:this.inputText
			// },'POST',true);
			// console.log('ai:' + aiResponse)
			//    this.isLoading = false;

			//    // 添加AI消息
			//    this.messages = [...this.messages, {
			//      role: "assistant",
			//      content: aiResponse,
			//      time: this.getCurrentTime()
			//    }];
			//    this.saveHistory();
			//    this.inputText = "";
			//  },

			// 模拟流式响应（实际对接API）
			mockStreamResponse() {
				return new Promise((resolve) => {
					let response = "";
					const sampleText = "这是一个模拟的流式响应示例，演示逐字显示效果。";

					const timer = setInterval(() => {
						if (response.length >= sampleText.length) {
							clearInterval(timer);
							resolve(response);
							return;
						}
						response += sampleText[response.length];
						this.updateLastMessage(response); // 更新最后一条消息
					}, 50);
				});
			},

			// 更新最后一条消息（用于流式显示）
			updateLastMessage(content) {
				const lastMsgIndex = this.messages.length - 1;
				if (lastMsgIndex >= 0) {
					this.messages[lastMsgIndex].content = content;
					this.messages = [...this.messages]; // 触发视图更新
					this.scrollToBottom();
				}
			},

			// 保存到本地存储
			saveHistory() {
				uni.setStorageSync('chatHistory', this.messages);
			},

			// 获取当前时间
			getCurrentTime() {
				return new Date().toLocaleTimeString([], {
					hour: '2-digit',
					minute: '2-digit'
				});
			},

			// 滚动到底部
			scrollToBottom() {
				setTimeout(() => {
					this.scrollTop = 99999; // 设置足够大的值触发滚动
				}, 100);
			}
		}
	};
</script>

<style lang="scss" scoped>
	/* 沿用注册页的渐变背景 */
	.container {
		background: linear-gradient(135deg, #ff6b6b, #4ecdc4);
		height: 100vh;
		display: flex;
		flex-direction: column;
	}

	.chat-container {
		flex: 1;
		padding: 30rpx 20rpx 0;
	}

	/* 消息行布局 */
	.message-row {
		display: flex;
		margin-bottom: 40rpx;

		&.user {
			justify-content: flex-end;

			.message-bubble {
				background: #fff;
				border-radius: 20rpx 20rpx 0 20rpx;
			}
		}

		&.assistant {
			justify-content: flex-start;

			.message-bubble {
				background: rgba(255, 255, 255, 0.9);
				border-radius: 20rpx 20rpx 20rpx 0;
			}
		}
	}

	.avatar {
		width: 80rpx;
		height: 80rpx;
		border-radius: 50%;
		margin: 0 20rpx;
	}

	.message-bubble {
		max-width: 70%;
		padding: 20rpx;
		position: relative;
		box-shadow: 0 5rpx 15rpx rgba(0, 0, 0, 0.1);
	}

	.message-text {
		font-size: 28rpx;
		color: #333;
		line-height: 1.5;
	}

	.message-time {
		display: block;
		font-size: 20rpx;
		color: #666;
		text-align: right;
		margin-top: 10rpx;
	}

	/* 输入区域 */
	.input-area {
		display: flex;
		align-items: center;
		padding: 20rpx;
		background: rgba(255, 255, 255, 0.9);
		margin: 20rpx;
		border-radius: 50rpx;
	}

	.input {
		flex: 1;
		padding: 20rpx;
		font-size: 28rpx;
	}

	.send-btn {
		width: 80rpx;
		height: 80rpx;
		border-radius: 50%;
		background: #4ecdc4;
		display: flex;
		align-items: center;
		justify-content: center;
		margin-left: 20rpx;

		&[disabled] {
			background: #cccccc;
		}
	}

	/* 加载动画 */
	.loading {
		display: flex;
		align-items: center;
		justify-content: center;
		padding: 20rpx;

		.loading-text {
			color: #fff;
			font-size: 28rpx;
		}

		.loading-dots text {
			color: #fff;
			animation: dotBlink 1.4s infinite;

			&:nth-child(2) {
				animation-delay: 0.2s;
			}

			&:nth-child(3) {
				animation-delay: 0.4s;
			}
		}
	}

	@keyframes dotBlink {

		0%,
		100% {
			opacity: 0.2;
		}

		50% {
			opacity: 1;
		}
	}
</style>