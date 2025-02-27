
// #ifndef VUE3
import Vue from 'vue'
import App from './App'
import config from './static/config/config.js'
import request from './common/js/request.js'
import store from './store'

Vue.config.productionTip = false
Vue.prototype.$config=config
Vue.prototype.$request=request

App.mpType = 'app'

const app = new Vue({
    ...App,
	store
	
})
app.$mount()
// #endif

// #ifdef VUE3
import { createSSRApp } from 'vue'
import App from './App.vue'
export function createApp() {
  const app = createSSRApp(App)
  return {
    app
  }
}
// #endif