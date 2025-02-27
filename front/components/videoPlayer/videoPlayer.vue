<template>
	<view>
			<view class="page-body">
				<view class="page-section">
					<view>
						<text style="text-align: center; font-size: 20px;">{{videoName}}</text>
					</view>
					<video id="myVideo" :src="viderSrc" @error="videoErrorCallback" :danmu-list="danmuList"
					    enable-danmu danmu-btn controls>
	                                </video>
					<view class="uni-list">
						<view class="uni-list-cell">
							<view class="uni-list-cell-db">
								<input @blur="bindInputBlur" class="uni-input" type="text" placeholder="在此处输入弹幕内容" />
							</view>
							<view class="btn-area">
								<button @tap="bindSendDanmu" class="page-body-button" formType="submit">发送弹幕</button>
							</view>
						</view>
					</view>
				</view>
			</view>
		</view>
</template>

<script>
	export default {
		name: "videoPlayer",
		props: {
			viderSrc: {
				type: String,
				default: '../../static/video1.mp4'
			},
			videoName:{
				type:String,
				default:'视频名称'
			}
		},
		data() {
			return {
				title: 'video',
				src: '',
				inputValue: '',
				danmuList: [{
						text: '第 1s 出现的弹幕',
						color: '#ff0000',
						time: 1
					},
					{
						text: '第 3s 出现的弹幕',
						color: '#ff00ff',
						time: 3
					}
				]
			}
		},
		onReady: function(res) {
			this.videoContext = uni.createVideoContext('myVideo')
		},
		methods: {
			bindInputBlur: function(e) {
				this.inputValue = e.target.value
			},
			bindButtonTap: function() {
				var that = this
				uni.chooseVideo({
					sourceType: ['album', 'camera'],
					maxDuration: 60,
					camera: ['front', 'back'],
					success: function(res) {
						this.src = res.tempFilePath
					}
				})
			},
			bindSendDanmu: function() {
				this.videoContext.sendDanmu({
					text: this.inputValue,
					color: this.getRandomColor()
				})
			},
			videoErrorCallback: function(e) {
				console.log('视频错误信息:')
				console.log(e.target.errMsg)
			},
			getRandomColor: function() {
				const rgb = []
				for (let i = 0; i < 3; ++i) {
					let color = Math.floor(Math.random() * 256).toString(16)
					color = color.length == 1 ? '0' + color : color
					rgb.push(color)
				}
				return '#' + rgb.join('')
			}
		}
	}
</script>

<style>

</style>
