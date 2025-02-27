<template>
	<view>
		<match-media :min-width="400"></match-media>
		<view class="videoView">
			<videoPlayer class="videoItem" viderSrc="../../static/video1.mp4" videoName="视频1" ></videoPlayer>
			<videoPlayer class="videoItem" viderSrc="../../static/video2.mp4" videoName="视频2" ></videoPlayer>
		</view>
		<view class="videoView">
	       <videoPlayer class="videoItem" viderSrc="../../static/video3.mp4" videoName="视频3" ></videoPlayer>
	       <videoPlayer class="videoItem" viderSrc="../../static/video4.mp4" videoName="视频4" ></videoPlayer>
		</view>
		<view class="videoView">
			<videoPlayer class="videoItem" viderSrc="../../static/video5.mp4" videoName="视频5" ></videoPlayer>
			<videoPlayer class="videoItem" viderSrc="../../static/video6.mp4" videoName="视频6" ></videoPlayer>
		</view>
		<view class="videoView">
			<videoPlayer class="videoItem" viderSrc="../../static/video7.mp4" videoName="视频7" ></videoPlayer>
			<videoPlayer class="videoItem" viderSrc="../../static/video8.mp4" videoName="视频8" ></videoPlayer>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				
			}
		},
		methods: {
			
		}
	}
</script>

<style>
  .videoView{
	  height: 40%;
	  display: flex;
	  margin-top: 10%;
  }
  .videoItem{
	  width: 40%;
	  height: 50%;
	  margin-left: 10%;
  }
</style>
