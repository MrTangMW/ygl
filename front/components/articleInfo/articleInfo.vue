<template>
	<view >
		<view@click="getDetails" >
			<view class="title">{{title}}</view>
			<view class="uni-flex uni-row">
				<view class="text" style="width: 50%;">发布日期：{{creatTime}}</view>
				<view class="text" >来源：{{source}}</view>
			</view>
		</view>
	</view>
</template>

<script>
	export default {
		name:"tmnl-articleInfo", //文章信息展示
		props:{
			articleId:{
				type:String,
				default:'',
			},
			title:{
				type:String,
				default:'',
			},
			source:{
				type:String,
				defaule:'',
			},
			creatTime:{
				type:String,
				default:'',
			}
		},
		data() {
			return {
				
			};
		},
		onLoad() {
		   console.log(this.articleId);
		},
		methods:{
			getDetails(){
				uni.navigateTo({
					url:'/pages/psonInfo/psonInfo?articleId='+this.articleId,	
				})
			}
		}
	}
</script>

<style >
	.uni-flex {
		display: flex;
		flex-direction: row;
	},
	.uni-row {
		flex-direction: row;
	},
  .text {
		padding: 0 25rpx;
		height: 50rpx;
		line-height: 50rpx;
		color: #777;
		font-size: 25rpx;
	},
	.title{
		padding: 0 20rpx;
		line-height: 60rpx;
		font-size: 35rpx;
		margin-top: 10rpx;
		margin-left: 10rpx;
	}
</style>