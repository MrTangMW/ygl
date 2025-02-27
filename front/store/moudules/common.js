import request from '../../common/js/request.js'
export default {
	state: {
		userId: uni.getStorageSync('userId'), // 用户id
		userInfo: uni.getStorageSync('userInfo') // 用户信息
	},
	getters: {
		// 用户id
		userId: state => state.userId,
		//用户信息
		userInfo: state => state.userInfo
	},
	mutations: {
		// 设置用户id
		setUserId(state, data) {
			state.userId = data
			uni.setStorageSync('userId', data)
		},
		// 设置用户信息
		setUserInfo(state, data) {
			state.userInfo = data
			uni.setStorageSync('userInfo', data)
		}
	},
	actions: {
		/**
		 * 用户注册
		 */
		async register(context, data) {
			return new Promise((resolve, reject) => {
				let param = {
					 avatar: "",          // 头像临时路径
					 nickname: "",        // 昵称
					 username: "",        // 用户名
					 email: "",           // 邮箱
					 password: "",        // 密码
					 captchaInput: "",    // 用户输入的验证码
					 captcha: ""          ,// 生成的验证码
					 confirmPassword:""// 确认密码
				};
				
				console.log('注册入参：' + JSON.stringify(param));
				request.apiRequest('/register', param).then(resultData => {
					console.log('注册响应：' + JSON.stringify(resultData));
					resolve(resultData)
				})
			})
		},
		/**
		 * 用户登录
		 */
		async login(context, data) {
			
		},
		// 菜单跳转：校验登录状态
		async handleMenuClick( context, param) {
			console.log(context)
			// 跳转菜单
			uni.navigateTo({
				url: param.url
			})
		},
		
		// 清缓存
		clearStorage({
			commit,
			dispatch
		}, param) {
			// 清除公共缓存
			commit('clearStorageCommon', [])
			// 清除用户和就诊人相关缓存
			commit('clearStoragePatient', ['userInfo', 'defaultPatient', 'patInfoList', 'openid']);
			// 清除医院信息
			commit('clearStorageHospital', ['globalHospitalInfo'])
		},
	}
}
