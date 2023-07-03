<template>

        <!-- 登录界面 -->
        <div class="zbx">
        <div class="leftbox"></div>
        <div class="rightbox">
                <h1>书酷网管理系统</h1>
                <div class="zibx"><i class="fa fa-user"></i><input type="text" name="user" v-model="form.usercode" placeholder="账号"></div>
                <div class="zibx"><i class="fa fa-lock"></i><input type="password" name="pwd" v-model="form.userpassword" placeholder="密码"></div>
                <input class="zsumst" type="submit" id="submitbt" @click="login" value="登录">
        </div>
    </div>


</template>

<script>
import request from '../../utils/requestff'
import { User,Lock,Key } from "@element-plus/icons-vue";
import Varcode from '@/components/Varcode.vue';
export default {

    name: 'Login',
    components: {
      Varcode  
    },
    data() {
        return {
            form: {
                usercode: '',
                userpassword: ''
                
            },
            User,
            Lock,
            Key
        }
    },
    methods: {
        //登录
        login() {
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
            request({
                url: 'user/login',
                method: 'post',
                data: this.form,
            }).then(res => {
                if (res.code == 200) {
                    var str=res.data.username;
                    if (str=="管理员") {
                        this.$message({
                            message: '登录成功',
                            type: 'success'
                        });
                        this.$router.push('/user?user'+'='+str);
                     }
                    else{
                        this.$message({
                            message: '未授权账户！',
                            type: 'error'
                        });
                    }
                    
                } else {
                    this.$message({
                        message: res.msg,
                        type: 'error'
                    });

                }
            })
        },
        register() {
            this.$router.push('/register')
        },
    },

}
</script>

<style>

.zbx{
    display: flex;
    width: 45%;
    height: 450px;
    background: rgba(255, 255, 255, 0.661);
    border-radius: 10px;
    margin: 10% auto;
    box-shadow:  0 0 10px 2px rgb(0 0 0 / 10% ) ;
}
/* 左边盒子 */
.leftbox{
    position: relative;
    width: 35%;
    height: 100%;
    background-color: skyblue;
    border-radius: 10px;

}
.zbx .leftbox::before{
    content: '';
    position: absolute;
    width: 100%;
    height: 100%;
    background: url(../images/zctp.jpg) 35%;
    background-size: cover;
    opacity: 80%;
    border-radius:10px 0 0 10px;
}
/* 右边盒子 */
.rightbox{
    display: flex;
    width: 65%;
    flex-direction: column;
    align-items: center;
}
.rightbox  h1{
    width: 50%;
    color: rgba(135, 207, 235, 0.895);
    font-size: 30px;
    margin: 50px 0 0 0%;
}
.rightbox {
    width: 90%;
    height: 96%;
}
.rightbox .zibx{
    width: 100%;
    height: 70px;
    margin: 10px 0 0 10%;
}
.rightbox  .zibx input{
    outline: none;
    width: 80%;
    height: 50px;
    font-size: 16px;
    /* margin-top: 50px; */
    padding: 10px 0 0 16px;
    border: none;
    border-bottom: 1px solid rgb(144,129,242);
    color: rgb(144,129,242);
    background-color: rgba(0, 0, 0 ,0);
}
.rightbox  .zibx input{
    outline: none;
    color: rgb(144,129,242);
    padding: 10px 0 0 16px;

}
.zsumst{
    width: 60%;
    height: 40px;
    color: #f6f6f6;
    background-image: linear-gradient(120deg, #e0c3fc 0%,#8ec5fc 100%);
    font-size: 14px;
    border: none;
    border-radius: 5px;
    margin: 30px 0 0 0%;
    /* transform: translateX(-5%); */
}
.zsumst:hover{
    box-shadow:  0 0 20px -5px rgb(0 0 0 / 15% ) ;
}
/* 去登录 */
.zz{
    margin: 12px;
    /* text-decoration: none; */
}
.zz a{
    text-decoration: none;
}
</style>