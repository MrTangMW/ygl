<template>
	<view>
		<view  class="swiper">
			<swiper style="height: 500px;" :autoplay="autoPlay" :interval="interVal" :duration="duration">
				<swiper-item class="swiper-item" >
					 <imgSwiper imgSrc="../../static/7.jpg" title="测试1"></imgSwiper>
				</swiper-item>
				<swiper-item class="swiper-item" style="background-color: green;">
					 <imgSwiper></imgSwiper>
				</swiper-item>
				<swiper-item class="swiper-item" style="background-color: red;">c</swiper-item>
			</swiper>
		</view>
	</view>
</template>
<script>
	export default {
		data() {
			return {
				autoPlay:true,
				interVal:3000,
				duration:400,
			}
		},
		beforeMount() {
			uni.navigateTo({
				url:"/pages/home/login"
			})
		},
		methods: {
		    queryData(){
				
			},
		}
	}
</script>

<style>
  .top{
	 font-size: 30px;
     text-align: center;
	 color: crimson;
	 margin-top: 10px;
	 height: 50px;
  },
  .swiper{
	  height: 500px;
	  margin-top: 10px;
  }
  .swiper-item{
	  display: block;
	  		height: 500px;
	  		text-align: center;
  }
  .img{
	  height: 480px;
	  
  }
</style>
