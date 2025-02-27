<template>
	<view class="container">
		<view class="title">
			<text>{{title}}</text>
		</view>
		<view class="description" >
			<text>描述：</text>
			<text style="color:cornflowerblue">{{description}}</text>
		</view>
		<view class="content">
			<text style="text-indent: 2em;">  {{content}}</text>
		</view>
		<view class="file" >
			<fileDownload title="附件下载" :isHaveData="isHaveData"  :fileList="fileList" :extra="extra"></fileDownload>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				title: '',
				description: '',
				content: '',
				articleId: '',
				fileName: '',
				fileUrl: '',
				height: '',
				width: '',
				fileList:[],
				subTitle:'',
				extra:'',
				isHaveData:true,
			}
		},
		onLoad: function(option) {
			console.log(option.articleId);
			this.articleId = option.articleId
			this.getTitleInfo()
		},

		methods: {
			getTitleInfo() {
				if (this.articleId === '') {
					return
				}
				let _that = this
				uni.request({
					url: this.$config.appConfig.baseUrl + '/api/demo/getTitle',
					data: {
						articleId: this.articleId
					},
					success(res) {
						console.log(res);
						_that.title = res.data.data.data.title
						_that.content = res.data.data.data.content
						_that.description = res.data.data.data.description
						if(res.data.data.data.fileList!== undefined && res.data.data.data.fileList.length>1){
							_that.fileList = res.data.data.data.fileList
							_that.isHaveData=false
						}else{
							_that.fileList = []
							_that.isHaveData=true
						}
					},
					fail() {

					}
				})
			}
		}
	}
</script>

<style>
	.description {
		flex: 0;
		font-size: 30rpx;
		line-height: 40rpx;
		margin-top: 10rpx;
		margin-left: 30rpx;
		margin-bottom: 10rpx;
	},
	.content {
		flex: 1;
		font-size: 30rpx;
		overflow: scroll;
		border:2rpx solid black;
		margin: 10rpx 10rpx;
		padding: 10rpx,10rpx;
	},
	.file {
		width: 100%;
		bottom: 0;
	},
	page {
		width: 100%;
		height: 100%;
	},
	.container {
		width: 100%;
		height: 100%;
		display: flex;
		flex-direction: column;
	},
	.title{
			font-size: 50rpx;
			line-height: 70rpx;
			font-weight: bold;
			text-align: center;
	}
</style>
