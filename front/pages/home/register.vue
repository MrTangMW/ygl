<template>
  <view class="container">
    <view class="register-box">
      <text class="title">用户注册</text>

      <!-- 头像上传 -->
      <view class="avatar-section" @click="chooseAvatar">
        <image :src="avatar || '/static/image/head.png'" class="avatar" ></image>
        <text class="avatar-tip">点击上传头像</text>
      </view>

      <!-- 昵称 -->
      <view class="input-group">
        <uni-icons type="person" size="20" color="#666" class="icon"></uni-icons>
        <input 
          v-model="nickname"
          placeholder="请输入昵称"
          class="input"
          placeholder-class="placeholder"
        />
      </view>

      <!-- 用户名 -->
      <view class="input-group">
        <uni-icons type="contact" size="20" color="#666" class="icon"></uni-icons>
        <input 
          v-model="username"
          placeholder="请输入用户名"
          class="input"
          placeholder-class="placeholder"
        />
      </view>

      <!-- 密码 -->
      <view class="input-group">
        <uni-icons type="locked" size="20" color="#666" class="icon"></uni-icons>
        <input
          v-model="password"
          placeholder="请输入密码（6-12位字符,包含大小写）"
          password
          class="input"
          placeholder-class="placeholder"
        />
      </view>
	  <!-- 确认密码 -->
	  <view class="input-group">
	    <uni-icons type="locked" size="20" color="#666" class="icon"></uni-icons>
	    <input 
	      v-model="confirmPassword"
	      placeholder="请确认密码"
	      password
	      class="input"
	      placeholder-class="placeholder"
	    />
	  </view>
      <!-- 邮箱 -->
      <view class="input-group">
        <uni-icons type="email" size="20" color="#666" class="icon"></uni-icons>
        <input 
          v-model="email"
		  inputmode="email"
          placeholder="请输入邮箱"
          class="input"
          placeholder-class="placeholder"
        />
      </view>
      <!-- 验证码 -->
      <view class="input-group">
        <uni-icons type="paperclip" size="20" color="#666" class="icon"></uni-icons>
        <input 
          v-model="captchaInput"
          placeholder="请输入验证码"
          class="input captcha-input"
          placeholder-class="placeholder"
        />
        <button class="uni-btn " @click="getCode">
           获取验证码
        </button>
      </view>

      <!-- 注册按钮 -->
      <button class="register-btn" @click="handleRegister">立即注册</button>

      <!-- 跳转登录 -->
      <view class="login-link">
        <text>已有账号？</text>
        <text class="link" @click="navigateToLogin">立即登录</text>
      </view>
    </view>
  </view>
</template>

<script>
export default {
  data() {
    return {
      avatar: "",          // 头像临时路径
      nickname: "",        // 昵称
      username: "",        // 用户名
      email: "",           // 邮箱
      password: "",        // 密码
      captchaInput: "",    // 用户输入的验证码
      captcha: ""          ,// 生成的验证码
	  confirmPassword:""// 确认密码
    };
  },
  mounted() {
    
  },
  methods: {
    // 选择头像
    chooseAvatar() {
      uni.chooseImage({
        count: 1,
        success: (res) => {
          this.avatar = res.tempFilePaths[0];
        }
      });
    },

    // 后端发送邮箱验证码
    getCode() {
      const chars = "ABCDEFGHJKMNPQRSTUVWXYZ23456789";
      this.captcha = Array.from({length:4}, () => 
        chars[Math.floor(Math.random() * chars.length)]
      ).join('');
    },

    // 注册提交
    handleRegister() {
      if (!this.validateForm()) return;

      // 实际开发中调用注册接口
      uni.showToast({ title: "注册成功！" });
      setTimeout(() => {
        uni.navigateBack();
      }, 1500);
    },

    // 表单验证
    validateForm() {
      const emailRegex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
      
      if (!this.avatar) {
        uni.showToast({ title: "请上传头像", icon: "none" });
        return false;
      }
      if (!this.nickname || !this.username || !this.email || !this.password) {
        uni.showToast({ title: "请填写完整信息", icon: "none" });
        return false;
      }
      if (!emailRegex.test(this.email)) {
        uni.showToast({ title: "邮箱格式不正确", icon: "none" });
        return false;
      }
      if (this.password.length < 6 || this.password.length > 12) {
        uni.showToast({ title: "密码需6-12位", icon: "none" });
        return false;
      }
      if (this.captchaInput.toUpperCase() !== this.captcha.toUpperCase()) {
        uni.showToast({ title: "验证码错误", icon: "none" });
        return false;
      }
	  if(this.password !== this.confirmPassword){
		  uni.showToast({ title: "密码不一致，请检查", icon: "none" });
		  return false;
	  }
      return true;
    },

    // 跳转登录页
    navigateToLogin() {
      uni.navigateTo({ url: "/pages/home/login" });
    }
  }
};
</script>

<style lang="scss" scoped>
.container {
  background: linear-gradient(135deg, #ff9a9e, #fad0c4);
  min-height: 100vh;
  padding: 30rpx;
  display: flex;
  justify-content: center;
}

.register-box {
  background: rgba(255, 255, 255, 0.96);
  width: 100%;
  max-width: 600rpx;
  padding: 40rpx;
  border-radius: 30rpx;
  box-shadow: 0 10rpx 30rpx rgba(0, 0, 0, 0.1);
}

.title {
  font-size: 44rpx;
  color: #ff6b6b;
  text-align: center;
  display: block;
  margin: 30rpx 0;
  font-weight: bold;
}

.avatar-section {
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-bottom: 40rpx;
  .avatar {
    width: 150rpx;
    height: 150rpx;
    border-radius: 50%;
    border: 4rpx solid #ff9a9e;
  }
  .avatar-tip {
    color: #666;
    font-size: 24rpx;
    margin-top: 15rpx;
  }
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

.register-btn {
  background: linear-gradient(90deg, #ff9a9e, #fad0c4);
  color: white;
  border: none;
  height: 90rpx;
  line-height: 90rpx;
  border-radius: 50rpx;
  font-size: 32rpx;
  margin: 50rpx 0 30rpx;
  box-shadow: 0 5rpx 15rpx rgba(255, 154, 158, 0.3);
}

.login-link {
  text-align: center;
  font-size: 28rpx;
  color: #666;
  .link {
    color: #ff6b6b;
    margin-left: 10rpx;
    font-weight: bold;
  }
}
.input{
	  flex: 1;
	  height: 80rpx;
	  font-size: 28rpx;
	  color: #333;
}
</style>