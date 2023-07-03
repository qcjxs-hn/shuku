<template>
<div style="width:100%;height:100vh; background-color:darkslateblue; overflow:hidden;">
    <div style="width:400px;margin:150px auto;">
        <!-- 登录界面 -->
        <div style="color:#cccccc;font-size:30px;text-align:center;">欢迎注册</div>
        <div style="margin:20px 0;">
            <el-input  :prefix-icon="User" circle v-model="form.user" size="large" placeholder="请输入用户名" clearable />
        </div>
        <div style="margin:20px 0;">
            <el-input :prefix-icon="Lock" v-model="form.pwd" size="large" type="password" placeholder="请输入密码" clearable />
        </div>
        <div style="margin:20px 0;">
            <el-input :prefix-icon="Lock" v-model="form.confirm" size="large" type="password" placeholder="确认密码" clearable />
        </div>
        <div style="margin:20px 0; width:100%;">
            <el-button type="primary" @click="register" style="width:100%;">登录</el-button>
        </div>
    </div>
</div>
</template>

<script>
import request from '../../utils/requestff'

import {
  UserFilled,
  Lock,
  User
} from '@element-plus/icons-vue'

export default {

    name: 'Register',
    data() {
        return {
            form: {
                user: '',
                pwd: '',
                confirm: ''
            },
            UserFilled,
            Lock,
            User
        }
    },
    methods: {
        register() {
            var kt=this.form.pwd.substring(0,1);
            //验证
            if(this.form.user == ''){
                this.$message({
                    message: '用户名不能为空',
                    type: 'error'
                });
                return;
            }
            else if(this.form.pwd == ''){
                this.$message({
                    message: '密码不能为空',
                    type: 'error'
                });
                return;
            }
            else if(this.form.pwd.length<6){
                   this.$message({
                    message: '密码不能小于6位',
                    type: 'error'
                });
                return;
            }
            else if(kt!=this.form.pwd.substring(0,1).toUpperCase()){
                   this.$message({
                    message: '密码首字母必须大写',
                    type: 'error'
                });
                return;
                    
            }
            else if(this.form.confirm == ''){
                this.$message({
                    message: '确认密码不能为空',
                    type: 'error'
                });
                return;
            }
            else if(this.form.pwd != this.form.confirm){
                this.$message({
                    message: '两次密码不一致',
                    type: 'error'
                });
                return;
            }
            //发送请求
            request({
                url: 'user/register',
                method: 'post',
                data: this.form,
            }).then(res => {
                if (res.code == 200) {
                    this.$message({
                        message: '注册成功',
                        type: 'success'
                    });
                    this.$router.push('/login')
                } else {
                    this.$message({
                        message: res.msg,
                        type: 'error'
                    });

                }
            })
    
        }
    },
}

</script>

<style>
</style>