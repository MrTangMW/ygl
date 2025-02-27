/**
 * @description: 异步请求返回Promise
 * @param {string} url  请求url
 * @param {Object} param   请求参数
 * @param {string} method  请求方法
 * @param {string} mask  显示加载遮罩层消息, 空串或不传表示不显示遮罩层
 */

function apiRequest(url, param, method, mask) {
	return new Promise((resolve, reject) => {
		// 显示加载提示
		if (mask) {
			uni.showLoading({
				title: mask,
				mask: true
			})
		}
		// 默认post 请求
		method = method || 'POST'
		uni.request({
			url:"http://localhost:8086/ygl"+url, // 请求路径
			method: method, // 请求方式
			data: param,
			header: {
				'content-type': 'application/json',
			},
			success: result => {
				if (mask) {
					uni.hideLoading()
				}
				console.log(result);
				if (result.data) {
					const resultData = result.data
					console.log(resultData);
					// 非加密模式直接返回
					resolve(resultData)
				} else {
					uni.showModal({
						title: '提示',
						content: result.data.errors[0].msg,
						showCancel: false,
						success: function (res) {
							if (res.confirm) {
								console.log('用户点击确定');
								if (mask) {
									uni.hideLoading()
								}
							} else if (res.cancel) {
								console.log('用户点击取消');
								if (mask) {
									uni.hideLoading()
								}
							}
						}
					});
					reject(result.data.errors[0])
				}
			},
			fail: err => {
				if (mask) {
					uni.hideLoading()
				}
				uni.showToast({
					icon: 'none',
					title: '请求失败，请稍后再试'
				})
				reject({
					errorCode: '1',
					msg: err.errMsg
				})
			}
		})
	})
}

export default {
	apiRequest
}