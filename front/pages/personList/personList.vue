<template>
	<view class="container">	
	<dataQuery class="top" ref="dataQuery" @getData="getData" @getNextData="getNextData"></dataQuery>
		<view style="top:40px;position: absolute;">
			<uni-list v-for="(item,index) in dataList" :key="index" >
				<articleInfo :creatTime="item.creatTime" :title="item.title" :articleId="item.articleId"
					:source="item.source" />
			</uni-list>
			<uni-load-more :status="showMoreStatus"></uni-load-more>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				dataList: [],
				showMoreStatus: '',
				canShowMore: true,
			}
		},
		onLoad() {
			this.refreshData()
		},
		onReachBottom() {
			this.canShowMore && this.$refs.dataQuery.queryNextData();
		},
		methods: {
			getData(data) {
				this.canShowMore = data.canShowMore
				this.dataList = data.dataList
			},
			getNextData(data) {
				console.log("新增的数据: ", data);
				this.canShowMore = data.canShowMore
				if (data.dataList.length > 0) {
					data.dataList.forEach(item => {
						this.dataList.push(item)
					})
				}
				console.log(this.dataList)
			},
			refreshData() {
				let _that = this
				uni.request({
					url: this.$config.appConfig.baseUrl + '/api/demo/queryData',
					method: 'POST',
					data: {
						pageParam: {
							pageSize: 20,
							pageNumber: 1
						},
						queryString: ''
					},
					success(res) {
					 _that.dataList = res.data.data.data.dataList
						_that.canShowMore = res.data.data.data.canShowMore
					},
					fail(res) {

					}
				})
			},
			openInfo() {
				uni.navigateTo({
					url: "/pages/psonInfo/psonInfo"
				})
			}
		}
	}
</script>

<style>
	.container {
		height: 100%;
	},
	.top{
	    position: fixed;
		z-index: 1001;
        top: 0;
		left: 0;
		height: 30px;
		width: 100%;
	}
</style>
