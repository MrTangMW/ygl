import Vue from 'vue'
import Vuex from 'vuex'
import common from './moudules/common.js'
Vue.use(Vuex)
const store = new Vuex.Store({
	state:{},
	getters:{},
	mutations:{},
	modules:{
		common
	},
})
export default store