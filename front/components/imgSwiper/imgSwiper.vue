<template>
	<view class="imgSrc" @click="clickTitle()">
		<image class="img" :src="imgSrc" />
		<text class="text">{{title}}</text>
	</view>
</template>

<script>
	export default {
		name:"imgSwiper",
		props:{
			imgSrc:{
				type:String,
				default:'../../static/加载中.png'
			},
			title:{
				type:String,
				default:'标题'
			}
		},
		data() {
			return {
				
			};
		},
		methods:{
			clickTitle(){
				uni.navigateTo({
					url: 'pages/video/video'
				});
			}
		}
	}
</script>

<style>
   .imgSrc{
	   display: flex;
	   flex-direction: column;
	   height: inherit;
	   border: 1px;
   },
   .img{
	   height:80%;
	   width: 100%;
   },
   .text{
	    height:20%;
	    width: 100%;
		text-align: center;
		font-size: 30px;
		margin-top: 10px;
   }
</style>