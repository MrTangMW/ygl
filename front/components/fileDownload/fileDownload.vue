<template>
	<view class="uni-flex uni-column">
		<view class="uni-flex uni-row">
			<text class="title" style="width: 40%;">{{title}}</text>
			<text>{{extra}}</text>
		</view>
		<view class="fileText">
			<view v-if="showDownLoad">
				<text>无附件</text>
			</view>
			<view v-else v-for="(item,index) in fileList" :key="index">
				<text class="hrefText" @click="openTips(item.fileUrl)">{{item.fileName}}</text>
			</view>
		</view>
	</view>
</template>

<script>
	export default {
		name: "tmnl-fileDownload",
		props: {
			fileList: {
				type: Array,
				default: []
			},
			isHaveData: {
				type: Boolean,
				default: true
			},
			title: {
				type: String,
				default: ''
			},
			extra: {
				type: String,
				default: ''
			}
		},
		watch: {
			isHaveData(newVal) {
				this.showDownLoad = newVal
			}
		},
		data() {
			return {
				showDownLoad: true,
			}
		},
		methods: {
			openTips(fileUrl) {
				let _that=this
                 uni.showModal({
					 content:'微信内不支持文件下载，如需查看附件，可复制附件链接去浏览器下载查看。',
                 	cancelText:"取消",
					cancelColor:'#0f59a4',
					confirmText:'复制',
					confirmColor:'#5e616d',
					success(res){
						if(res.confirm){
						   uni.setClipboardData({
						   	data: _that.$config.appConfig.baseUrl+'/api/demo/downloadFile?articleId='+fileUrl
						   })	
						}
					}
                 })
			}
		}
	}
</script>

<style>
	.title {
		padding: 20rpx 20rpx;
		line-height: 50rpx;
		font-size: 30rpx;
		font-weight: bold;
		margin-top: 10rpx;
		margin-left: 10rpx;

	}

	,
	.fileText {
		padding: 0 20rpx;
		line-height: 40rpx;
		font-size: 25rpx;
		margin-top: 10rpx;
		margin-left: 10rpx;
		margin-bottom: 20rpx;
	}

	,
	.hrefText {
		color: #007BFF ;
		text-decoration: underline;
	}
</style>
