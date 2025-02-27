<template>
  <view class="container">
    <!-- 登录表单 -->
    <view class="login-box">
      <text class="title">欢迎登录</text>

      <!-- 用户名输入 -->
      <view class="input-group">
        <uni-icons type="person" size="20" color="#666" class="icon"></uni-icons>
        <input 
          v-model="username"
          placeholder="请输入用户名"
          class="input"
          placeholder-class="placeholder"
        />
      </view>

      <!-- 密码输入 -->
      <view class="input-group">
        <uni-icons type="locked" size="20" color="#666" class="icon"></uni-icons>
        <input 
          v-model="password"
          placeholder="请输入密码"
          password
          class="input"
          placeholder-class="placeholder"
        />
      </view>

      <!-- 验证码输入 -->
      <view class="input-group">
        <uni-icons type="paperclip" size="20" color="#666" class="icon"></uni-icons>
        <input 
          v-model="captchaInput"
          placeholder="请输入验证码"
          class="input captcha-input"
          placeholder-class="placeholder"
        />
        <view class="captcha-code" @click="generateCaptcha">
          {{ captcha }}
        </view>
      </view>

      <!-- 登录按钮 -->
      <button class="login-btn" @click="handleLogin">登录</button>

      <!-- 注册跳转 -->
      <view class="register-link">
        <text>没有账号？</text>
        <text class="link" @click="navigateToRegister">立即注册</text>
      </view>
    </view>
  </view>
</template>

<script>
export default {
  data() {
    return {
      username: "",
      password: "",
      captchaInput: "",     // 用户输入的验证码
      captcha: ""           // 生成的验证码
    };
  },
  mounted() {
    this.generateCaptcha(); // 初始化生成验证码
  },
  methods: {
    // 生成4位随机验证码（数字+字母）
    generateCaptcha() {
      const chars = "ABCDEFGHJKMNPQRSTUVWXYZ23456789";
      let code = "";
      for (let i = 0; i < 4; i++) {
        code += chars.charAt(Math.floor(Math.random() * chars.length));
      }
      this.captcha = code;
    },

    // 登录逻辑
    handleLogin() {
		uni.navigateTo({
			url:"/pages/chat/chat"
		})
      if (!this.username || !this.password || !this.captchaInput) {
        uni.showToast({ title: "请填写完整信息", icon: "none" });
        return;
      }
      if (this.captchaInput.toUpperCase() !== this.captcha.toUpperCase()) {
        uni.showToast({ title: "验证码错误", icon: "none" });
        return;
      }
      // 实际开发中此处调用登录接口
      uni.showToast({ title: "登录成功！" });
	 
      // 跳转到首页（示例）
      // uni.reLaunch({ url: "/pages/home/home" });
    },

    // 跳转到注册页面
    navigateToRegister() {
      uni.navigateTo({ url: "/pages/home/register" });
    }
  }
};
</script>

<style lang="scss" scoped>
.container {
  height: 100vh;
  background: linear-gradient(135deg, #ff6b6b, #4ecdc4);
  display: flex;
  justify-content: center;
  align-items: center;
  padding: 20rpx;
}

.login-box {
  background: rgba(255, 255, 255, 0.95);
  width: 90%;
  padding: 40rpx;
  border-radius: 20rpx;
  box-shadow: 0 10rpx 30rpx rgba(0, 0, 0, 0.1);
}

.title {
  font-size: 40rpx;
  color: #333;
  text-align: center;
  display: block;
  margin-bottom: 50rpx;
  font-weight: bold;
}

.input-group {
  position: relative;
  margin-bottom: 30rpx;
  display: flex;
  align-items: center;
  border: 2rpx solid #eee;
  border-radius: 50rpx;
  padding: 0 20rpx;
  transition: border-color 0.3s;

  &:focus-within {
    border-color: #4ecdc4;
  }
}

.icon {
  margin-right: 15rpx;
}

.input {
  flex: 1;
  height: 80rpx;
  font-size: 28rpx;
  color: #333;
}

.captcha-input {
  flex: 0.6;
}

.captcha-code {
  flex: 0.4;
  height: 80rpx;
  background: #f0f0f0;
  border-radius: 40rpx;
  display: flex;
  align-items: center;
  justify-content: center;
  font-weight: bold;
  color: #ff6b6b;
  cursor: pointer;
  transition: transform 0.2s;

  &:active {
    transform: scale(0.95);
  }
}

.login-btn {
  background: linear-gradient(90deg, #ff6b6b, #ff8e53);
  color: white;
  border: none;
  height: 90rpx;
  line-height: 90rpx;
  border-radius: 50rpx;
  font-size: 32rpx;
  margin-top: 40rpx;
  box-shadow: 0 5rpx 15rpx rgba(255, 107, 107, 0.3);
}

.register-link {
  text-align: center;
  margin-top: 30rpx;
  font-size: 28rpx;
  color: #666;

  .link {
    color: #4ecdc4;
    margin-left: 10rpx;
    font-weight: bold;
  }
}

.placeholder {
  color: #999;
}
</style>s