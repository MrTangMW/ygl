<template>
	<view style="background-color: white;">
		<uni-search-bar  v-model="queryString" placeholder="请输入文件名查询" cancelButton="none">	</uni-search-bar>
	</view>
</template>

<script>
	export default {
		name:"dataQuery",
		data() {
			return {
				queryString:'',
				pageSize:20,
				pageNumber:1,
			};
		},
		watch:{
			queryString(newVal){
				this.queryData()
			}
		},
		methods:{
			queryData(){
				let _that=this
				uni.request({
					url:this.$config.appConfig.baseUrl+'/api/demo/queryData',
					method:'POST',
					data:{
						queryString:this.queryString,
						pageParam:{
							pageSize:this.pageSize,
							pageNumber:this.pageNumber
						}
					},
					success(res){
						_that.$emit("getData",res.data.data.data)
					},
					fail(res){
						
					}
				})
			},
			queryNextData(){
				this.pageNumber+=1;
				let _that=this
				uni.request({
					url:this.$config.appConfig.baseUrl+'/api/demo/queryData',
					method:'POST',
					data:{
						queryString:this.queryString,
						pageParam:{
							pageSize:this.pageSize,
							pageNumber:this.pageNumber
						}
					},
					success(res){
						_that.$emit("getNextData",res.data.data.data)
					},
					fail(res){
						
					}
				})
			}
		}
	}
</script>

<style>

</style>