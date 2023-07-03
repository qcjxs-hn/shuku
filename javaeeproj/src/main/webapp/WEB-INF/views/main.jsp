<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta><meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link type="text/css" rel="stylesheet"
          href="${pageContext.request.contextPath }/resources/css/bootstrap.min.css" />
    <link type="text/css" rel="stylesheet"
          href="${pageContext.request.contextPath }/resources/css/main.css" />
    <script src="${pageContext.request.contextPath }/resources/js/vue.global.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/axios.js"></script>

    <!-- import CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/index.css">
    <link href="${pageContext.request.contextPath }/resources/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <!-- import JavaScript -->
    <script src="${pageContext.request.contextPath }/resources/js/index.full.js"></script>
    <style>
        .btdivst{
            width: 100%;
            height: 100px;
            margin: 0 0 0 0;

        }
        .btst{
            width: 100px;
            height: 100px;
            margin: 0 0 0 0;
            color: rgba(0, 0, 0, 0);
            background: rgba(0, 0, 0, 0);
            border-color: rgba(0, 0, 0, 0);

        }
        .image {
            width: 50px;
            height: 50px;
            border-radius: 50%;
        }
        .imagelogo {
            width: 50px;
            height: 50px;
            margin: 10px 0 0 0;
        }
        .input-group{
            width: 250px;
            height: 50px;
        }
        .sc{
            margin-left: 90%;
            margin-top: 1%;
        }
        .selectDiv{
            margin: 0 0 0 -30%;
        }
        .form-control{
            margin: -1% 0 0 0;
        }
        .form-control1{
            width: 241px;
            margin: -15% 0 0 0;
            height: 30px;
        }
        .grdiv{
            width: 100%;
            text-align: center;
        }
        .zbx{
            display: flex;
            width: 45%;
            height: 630px;
            background: rgba(255, 255, 255, 0.661);
            border-radius: 10px;
            margin: 10% auto;
            box-shadow:  0 0 10px 2px rgb(0 0 0 / 10% ) ;
        }
    /*    注册*/

        .zbx{
            display: flex;
            width: 40%;
            height: 240px;
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
            background: url(../../images/zctp.jpg) 35%;
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
        .rightbox form h1{
            width: 20%;
            color: rgba(135, 207, 235, 0.895);
            font-size: 30px;
            margin: 50px 0 0 45%;
        }
        .rightbox form{
            width: 90%;
            height: 96%;
        }
        .rightbox form .zibx{
            width: 100%;
            height: 70px;
            margin: 10px 10%;
        }
        .rightbox form .zibx input{
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
        .rightbox form .zibx input{
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
            margin: 0 0 0 20%;
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
        .divlinecd{
            width: 100%;
        }
        .dlbu{
            margin: 5% 10% 0 30%;
        }
        .zcbu{
            margin: 5% 10% 0 -15%;
        }
        .qx{
            margin: 5% 0 0 0;
        }
        .sousuo{
            width: 90px;
            margin: -55px 0px 0 100px;
            float: right;
        }
        .selectbox{
            height: 30px;
        }
        /*弹出框*/
        .tck{
            background-color: #add8e6a8;
            border-radius:10px 10px 10px 10px;
        }

        .el-carousel__item h3 {
            color: #475669;
            opacity: 0.75;
            line-height: 200px;
            margin: 0;
            text-align: center;
        }

        .el-carousel__item:nth-child(2n) {
            background-color: #99a9bf;
        }

        .el-carousel__item:nth-child(2n + 1) {
            background-color: #d3dce6;
        }

        .zcanddl{
            text-align: center;
            margin: 0;
        }
    /*    跑马灯样式*/
        .pmdys{
            margin: -1% 0 0 0;
            z-index: 0;
        }
        /* 跑马灯图片样式 */
        .imgst {
            width: 110%;
            height: 300px;
        }
        .imgst2 {
            width: 35%;
            height: 250px;
        }
    /*    主体*/
        .ztys{
            margin: 11% 0 0 14%;
        }
    </style>
    <title>书酷 - 首页</title>
</head>
<body>
<div id="app" style="height: 60px;">
        <el-menu
                :default-active="path"
                router
                class="el-menu-demo"
                mode="horizontal"
                :ellipsis="false"
                @select="handleSelect"

        >
            <el-menu-item index="0" style="margin-left: 15%"><img
                    :src="this.logourl"
                    class="imagelogo"
                    />
            </el-menu-item>
            <el-menu-item  style="margin-left: 30%;width: 500px;height: 50px">
            <form class="search col-md-4 col-sm-6" action="bookSearch" method="get">
                <div class="input-group">
                    <div class="selectDiv">
                        <select name="searchBy" class="select selectbox">
                            <option class="option" value="book_title" selected="selected">书名</option>
                            <option class="option" value="book_author">作者</option>
                        </select>
                        <input name="searchTxt" class="form-control1" type="text">
                        <div class="input-group-btn sousuo">
                            <button class="btn btn-success" type="submit">搜索</button>
                        </div>
                    </div>

                </div>
            </form>
            </el-menu-item>

            <el-popover :visible="visible" placement="top" :width="240">
                <p>            <%--登录后用用户头像替换登录按钮组--%><!--用户头像信息-->
                <div class="text-center"><span>等&nbsp;级：<img id="levelImg" :src="this.djtxurl+dj[0].levelimg" alt="" style="width: 72px; height: 15px">{{dj[0].leveltxt}}</span></div>       <div class="text-success text-center">贡献值：<span id="contribution" class="badge badge-important">{{user[0].contribution}}</span></div><div class="grdiv" :style="this.zxys"><a href="#" id="exit" class="btn btn-link" @click="zx" >注销</a></div></p>
                <div  class="zcanddl" :style="this.ycys">
                    <el-button size="small" text  @click="dialogVisible = true">登录</el-button>
                    <el-button size="small" type="primary" @click="dialogVisible2 = true">注册</el-button
                    >
                </div>
                <template #reference>
                    <div @click="tzgrxx">
                    <img
                            :src="this.url+tx[0].avatartxt+'.jpg'"
                            class="image"
                            @click="visible = true"
                    />
                    </div>
                </template>
            </el-popover>
            <el-text class="mx-1" style="margin: 50px 0 0 -2.5%" id="txid" type="primary">{{user[0].username}}</el-text>

        </el-menu>

    <%@include file="common/loginHead.jsp"%>

    <%--走马灯    --%>
    <el-carousel :interval="4000" type="card" height="250px" class="pmdys">
        <el-carousel-item v-for="item in pmd" :key="item">
            <div v-if="item.url != 'https://cdn.qimao.com/bookimg/zww/backendstatic/images/other/202306/1h25fo8quxiyEWhhb4zdSEJDrH2d7.jpg'">
                <h3 text="2xl" justify="center">
                <img class="imgst2" :src="item.url" alt="" />
                </h3>
            </div>
            <div v-else>
                <img class="imgst" :src="item.url" alt="" />
            </div>
        </el-carousel-item>
    </el-carousel>
    <%--登录框--%>
    <el-dialog v-model="dialogVisible" class="tck"  title="登录" width="30%"draggable center>
        <div style="width: 100%;height: 100%">
        <span>
        <div style="margin:20px 0;">
            <el-input class="zibx" id="userCode"  :prefix-icon="User" v-model="form.usercode" size="large" placeholder="请输入用户名" clearable />
        </div>
        <div style="margin:20px 0;">
            <el-input class="zibx" id="userPassword" :prefix-icon="Lock" v-model="form.userpassword" size="large" type="password" placeholder="请输入密码" clearable />
        </div>

            <div class="checkbox col-md-6 " style="width: 100%;text-align: center;">
                          <!--触发注册模态框-->
              <label><input type="checkbox">记住密码</label>
              <a href="#" class="btn btn-link">找回密码</a>
                <button type="button" class="btn btn-link"  @click="dialogVisible2 = true,dialogVisible = false" >还没账号？</button>
            </div>
            <div class="divlinecd">
              <div class=" ">
                <button id="loginSubmit" type="button" class="btn btn-success dlbu" @click="onLogin">登录</button>
                <button type="button" class="btn btn-info qx" data-dismiss="modal">取消</button>
              </div>
              <div id="errorTxt" class="col-md-3 text-danger hide">*用户名或密码错误</div>
            </div>
        </span>
        </div>
    </el-dialog>
    <%--注册框--%>
    <el-dialog v-model="dialogVisible2" id="loginModal" title="注册" width="30%" class="tck" draggable center>
        <span>
<%--        <div class="modal-body">--%>
          <form id="regForm" class="form-horizontal" role="form">
            <div class="form-group">
              <label for="uCode" class="control-label col-md-4">用户名：</label>
              <div class="col-md-5">
                <input type="text" class="form-control zibx" id="uCode" v-model="form.usercode" name="uCode"
                       placeholder="请输入用户名">
              </div>
              <span id="uCodeTip" style="padding-top: 7px"></span>
            </div>
            <div class="form-group">
              <label for="uName" class="control-label col-md-4">昵称：</label>
              <div class="col-md-5">
                <input type="text" class="form-control zibx" v-model="form.username" id="uName" name="uName"
                       placeholder="请输入昵称（可修改）">
              </div>
              <span id="uNameTip" style="padding-top: 7px"></span>
            </div>
            <div class="form-group">
              <label for="uPwd" class="control-label col-md-4">密码：</label>
              <div class="col-md-5">
                <input type="password" class="form-control zibx" v-model="form.userpassword" id="uPwd" name="uPwd"
                       placeholder="请输入密码">
              </div>
              <span id="uPwdTip" style="padding-top: 7px"></span>
            </div>
            <div class="form-group">
              <label for="uPwd2" class="control-label col-md-4">重复密码：</label>
              <div id="input" class="col-md-5">
                <input type="password" class="form-control zibx" v-model="form2.userpassword2" id="uPwd2" name="uPwd2"
                       placeholder="请再次输入密码">
              </div>
              <span id="uPwd2Tip" style="padding-top: 7px"></span>
            </div>
            <div class="form-group">
              <label for="uEmail" class="control-label col-md-4">邮箱：</label>
              <div class="col-md-5">
                <input type="text" class="form-control zibx" v-model="form.email" id="uEmail" name="uEmail"
                       placeholder="请输入邮箱">
              </div>
            </div>
              <!--触发注册模态框-->
                        <button type="button" class="btn btn-link col-md-6" data-toggle="modal"
                                data-target="#regModal" data-dismiss="modal" @click="dialogVisible2 = false,dialogVisible = true">已有账号？去登录</button>
            <br>
            <div class="divlinecd">
              <div class=" ">
                <button id="regSubmit" type="button" class="btn btn-success zcbu" @click="onRegister">注册</button>
                <button id="regQuit" type="button" class="btn btn-info qx" data-dismiss="modal">取消</button>
              </div>
            </div>
          </form>



</div>
<%--        </div>--%>
</span>

</el-dialog>

    <%@include file="common/userHead.jsp"%>

    <div id="main" class="container ztys">
        <div class="leaderboard">
        </div>

        <br>

        <div class="row">
            <div class="col-md-4">
                <div class="panel panel-info">
                    <div class="panel-heading"><h4>热门下载</h4></div>
                    <ul class="list-group">

                        <c:forEach items="${rankingBooks1}" var="rankingBook">
                            <li class="list-group-item">
                                <a href="bookDetail?bookID=${rankingBook.id}">${rankingBook.bookName}</a>
                                <span class="pull-right">${rankingBook.download_times}</span>
                            </li>
                        </c:forEach>

                    </ul>

                </div>
            </div>

            <div class="col-md-4">
                <div class="panel panel-success">
                    <div class="panel-heading"><h4>最新上传</h4></div>
                    <ul class="list-group">

                        <c:forEach items="${rankingBooks}" var="rankingBook">
                            <li class="list-group-item">
                                <a href="bookDetail?bookID=${rankingBook.id}">${rankingBook.bookName}</a>
                                <span class="pull-right">[${rankingBook.uploadDate}]</span>
                            </li>
                        </c:forEach>

                    </ul>
                </div>
            </div>

            <div class="col-md-4">
                <div class="panel panel-danger">
                    <div class="panel-heading"><h4>站内数据</h4></div>
                    <ul class="list-group">
                        <li class="list-group-item">电子图书总数
                            <span class="badge pull-right">${sumOfBooks}</span> </li>
                        <li class="list-group-item">经典文学总数
                            <span class="badge pull-right">${sumOfTypeBooks.get(0)}</span> </li>
                        <li class="list-group-item">通俗小说总数
                            <span class="badge pull-right">${sumOfTypeBooks.get(1)}</span> </li>
                        <li class="list-group-item">计算机类总数
                            <span class="badge pull-right">${sumOfTypeBooks.get(2)}</span> </li>
                        <li class="list-group-item">杂志期刊总数
                            <span class="badge pull-right">${sumOfTypeBooks.get(3)}</span> </li>
                        <li class="list-group-item">最后更新日期
                            <span class="badge pull-right">${maxUploadDate}</span> </li>
                    </ul>
                </div>
            </div>

        </div>

    </div>




</div>

<hr>

<footer>
    <p class="text-center">
        &copy; 2023
    </p>
</footer>

<script src="${pageContext.request.contextPath}/resources/js/jquery-3.1.1.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.cookie.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script
<script src="${pageContext.request.contextPath}/resources/js/userLogin.js"></script>>
<script src="${pageContext.request.contextPath}/resources/js/userRegister.js"></script>

<script>


    const request = axios.create({
        // baseURL: 'http://localhost:8084', // 设置请求的基本 URL
        headers: {
            'Content-Type': 'application/json', // 设置请求头
            'Access-Control-Allow-Origin':'*'
        },
        timeout: 5000
    })
    // request 拦截器
    // 可以自请求发送前对请求做一些处理
    // 比如统一加token，对请求参数统一加密
    request.interceptors.request.use(config => {
        config.headers['Content-Type'] = 'application/json;charset=utf-8';
        config.headers['Access-Control-Allow-Origin']='*';
        // config.headers['token'] = user.token;  // 设置请求头
        return config
    }, error => {
        return Promise.reject(error)
    });

    // response 拦截器
    // 可以在接口响应后统一处理结果
    request.interceptors.response.use(
        response => {
            let res = response.data;
            // 如果是返回的文件
            if (response.config.responseType === 'blob') {
                return res
            }
            // 兼容服务端返回的字符串数据
            if (typeof res === 'string') {
                res = res ? JSON.parse(res) : res
            }
            return res;
        },
        error => {
            console.log('err' + error) // for debug
            return Promise.reject(error)
        }
    );

    const App = {
        data() {
            return {
                message: "Hello Element Plus",
                dialogVisible:false,
                dialogVisible2:false,
                ycys:'',
                zxys:'display:none;',
                logourl:'http://shukuqt.viphk.91tunnel.com/javaeeproj_war_exploded/resources/images/书酷 SO COOL.gif',
                url:'http://shukuqt.viphk.91tunnel.com/javaeeproj_war_exploded/resources/images/avatars/',
                txurl:'https://3e151428q8.goho.co/tx?PageNum=1&PageSize=1&search=',
                djurl:'https://3e151428q8.goho.co/contribution?PageNum=1&PageSize=5&search=',
                jkurl:'https://3e151428q8.goho.co/user',
                djtxurl:'http://shukuqt.viphk.91tunnel.com/javaeeproj_war_exploded/',
                form:{
                    id:'',
                    usercode: '',
                    userpassword:'',
                    username:'',
                    email:'',
                    avatarnum:'',
                    contribution:'',
                    creationdate:'',
                },
                form2:{
                    userpassword2:'',
                },
                user:[
                    {
                        id:'',
                        usercode: '',
                        userpassword:'',
                        username:'游客',
                        email:'',
                        avatarnum:'',
                        contribution:'0',
                        creationdate:'',
                    },
                ],
                userhelper:[{
                    id:'',
                    usercode: '',
                    username:'',
                    email:'',
                    avatar:'',
                    contributionValue:'',
                    contribution:'',
                    creationdate:'',
                }],
                tx:[
                    {
                        id:'',
                        avatartxt:'skvw48kv',
                        avatarimg:'',
                    }
                ],
                dj:[{
                    id:'',
                    leveltxt:'没有等级',
                    lowerlimit:'',
                    upperlimit:'',
                    levelimg:'',
                }],
                pmd:[
                    {url:"https://cdn.qimao.com/bookimg/zww/backendstatic/images/other/202306/1h25fo8quxiyEWhhb4zdSEJDrH2d7.jpg"},
                    {url:"http://shukuqt.viphk.91tunnel.com/javaeeproj_war_exploded/resources/images/xyj.jpg"},
                    {url:"http://shukuqt.viphk.91tunnel.com/javaeeproj_war_exploded/resources/images/hlm.jpg"},
                    {url:"http://shukuqt.viphk.91tunnel.com/javaeeproj_war_exploded/resources/images/shz.jpg"},
                    {url:"http://shukuqt.viphk.91tunnel.com/javaeeproj_war_exploded/resources/images/sgyy.jpg"},
                ],
            };
        },
        methods: {
            //登录
            onLogin() {
                console.log('登录!');
                //验证
                if (this.form.usercode == '') {
                    this.$message({
                        message: '用户名不能为空',
                        type: 'error'
                    });
                    return;
                } else if (this.form.userpassword == '') {
                    this.$message({
                        message: '密码不能为空',
                        type: 'error'
                    });
                    return;
                }
                request({
                    url: this.jkurl + '/login',
                    method: 'post',
                    data: this.form,
                }).then(res => {
                    this.user = [res.data];
                    console.log(res.code);
                    if (res.code == 200) {
                        this.$message({
                            message: '登录成功',
                            type: 'success'
                        });
                        console.log(this.user.length);
                        this.user[this.user.length] = {
                            ...this.user[this.user.length],
                            "isLogined":"false"
                        };
                        // this.user[0].splice(this.user[0].length + 1, 0, { "isLogined":"false" });
                        this.dialogVisible = false;
                        this.yc();
                        this.hqtx();
                        this.hqdj();
                        this.zxys="display:block;";
                        this.cook(this.user,this.user[0].userpassword);
                        // alert("登录成功！")
                    }else{
                        console.log(res.code+res.msg);
                        this.$message({
                            message: '用户名或密码错误！',
                            type: 'error'
                        });

                    }
                });
            },
            //获取头像
            hqtx(){
                console.log("hqtx");
                request({
                    url: this.txurl + this.user[0].avatarnum,
                    method: 'get',
                }).then(res2 => {
                    if (res2.code == 200) {
                        this.tx = [res2.data.records[0]];
                    }
                });
            },
            //获取等级信息
            hqdj(){
                console.log("hqdj");
                request({
                    url: this.djurl + this.user[0].contribution,
                    method: 'get',
                }).then(res5 => {
                    if (res5.code == 200) {
                        this.dj = [res5.data.records[0]];
                    }
                });
            },
            //跳转个人信息
            tzgrxx(){
                var cookies = document.cookie.split(';');
                console.log(cookies.length+"");
                if(cookies.length==1) {
                    this.$message({
                        message: '游客不能修改信息！',
                        type: 'error'
                    });
                }else{
                    this.userhelper[0].id = this.user[0].id;
                    this.userhelper[0].usercode = this.user[0].usercode;
                    this.userhelper[0].username = this.user[0].username;
                    this.userhelper[0].email = this.user[0].email;
                    this.userhelper[0].avatar = this.tx[0];
                    this.userhelper[0].contributionValue = this.user[0].contribution;
                    this.userhelper[0].contribution = this.dj[0];
                    this.userhelper[0].creationdate = this.user[0].creationdate;
                    const userJson = JSON.stringify(this.userhelper);
                    window.location.href = "person?userList=" + encodeURIComponent(userJson);
                }
            },
            //注册方法
            onRegister(){
                console.log("注册");
                //验证
                if (this.form.usercode == '') {
                    this.$message({
                        message: '用户名不能为空！',
                        type: 'error'
                    });
                    return;
                } else if (this.form.userpassword == '') {
                    this.$message({
                        message: '密码不能为空！',
                        type: 'error'
                    });
                    return;
                } else if(this.form.userpassword != this.form2.userpassword2){
                    this.$message({
                        message: '两次密码不一样！',
                        type: 'error'
                    });
                    return;
                }else if(this.form.email==''){
                    this.$message({
                        message: '邮箱不能为空！',
                        type: 'error'
                    });
                    return;
                }
                request({
                    url:this.jkurl+'/register',
                    method:'post',
                    data:this.form,
                }).then(res3 => {
                    if(res3.code==200){
                        this.$message({
                            message:'注册成功！',
                            type:'success'
                        });

                        this.dialogVisible2 = false;
                    }else{
                        console.log(res3.code+res3.msg);
                        this.$message({
                            message: res3.msg,
                            type: 'error'
                        });

                    }




                });

            },
            //隐藏登录注册
            yc(){
                var zcanddl=document.getElementsByClassName("zcanddl");
                console.log(zcanddl);
                this.ycys="display:none";
                zcanddl.style="display:none";

            },
            //注销
            zx(){
                document.cookie = "isLogined" + "=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
                document.cookie = "userCode" + "=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
                document.cookie = "userPassword" + "=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
                window.location.href = "logout";
            },
            cook(e, o) {
                var t = {
                    usercode: o,
                    userpassword: e[0].userpassword
                };
                console.log(e,o);
                console.log(e[1].isLogined);
                if (e[1].isLogined) {
                    var o = $("#userCode").val(),
                        t = $("#userPassword").val();
                    $('#loginModal .checkbox input[type="checkbox"]').is(":checked") ? ($.cookie("isLogined", !0, {
                        expires: 7,
                        path: "/"
                    }), $.cookie("userCode", o, {
                        expires: 7,
                        path: "/"
                    }), $.cookie("userPassword", t, {
                        expires: 7,
                        path: "/"
                    })) : ($.cookie("isLogined", !0, {
                        path: "/"
                    }), $.cookie("userCode", o, {
                        path: "/"
                    }), $.cookie("userPassword", t, {
                        path: "/"
                    }))
                }

            },
            cookdl(e){
                request({
                    url:this.jkurl+'/login',
                    method:'post',
                    data:e,
                }).then(res4 => {
                    this.user = [res4.data];
                    console.log(res4.code);
                    if (res4.code == 200) {
                        this.$message({
                            message: '登录成功',
                            type: 'success'
                        });
                        this.yc();
                        this.hqtx();
                        this.hqdj();
                        this.xlogincz();
                        this.zxys="display:block;";

                    }
                });
            },
            butop(){
                if ("true" == $.cookie("isLogined")) {
                    this.userhelper[0].id=this.user[0].id;
                    this.userhelper[0].usercode = this.user[0].usercode;
                    this.userhelper[0].username = this.user[0].username;
                    this.userhelper[0].email = this.user[0].email;
                    this.userhelper[0].avatar = this.tx[0];
                    this.userhelper[0].contributionValue = this.user[0].contribution;
                    this.userhelper[0].contribution = this.dj[0];
                    this.userhelper[0].creationdate = this.user[0].creationdate;
                    console.log(this.userhelper);
                    const userJson = JSON.stringify(this.userhelper);
                    window.open("/javaeeproj_war_exploded/getUploadPage?userList=" + encodeURIComponent(userJson));
                }else {
                    $("#userHead").hasClass("hide") && $(".uploadBtn button").tooltip({
                        animation: !0,
                        title: "请先登陆！",
                        placement: "top",
                        trigger: "hover focus",
                        delay: {
                            show: 500,
                            hide: 100
                        }
                    })
                }

            },
            xlogincz(){
                this.userhelper[0].id=this.user[0].id;
                this.userhelper[0].usercode = this.user[0].usercode;
                this.userhelper[0].username = this.user[0].username;
                this.userhelper[0].email = this.user[0].email;
                this.userhelper[0].avatar = this.tx[0];
                this.userhelper[0].contributionValue = this.user[0].contribution;
                this.userhelper[0].contribution = this.dj[0];
                this.userhelper[0].creationdate = this.user[0].creationdate;
                request({
                    url:'http://shukuqt.viphk.91tunnel.com/javaeeproj_war_exploded/getUploadPagean',
                    method:'post',
                    data:this.userhelper[0]}).then(res10=>{
                    if (res10.code == 200) {
                        this.$message({
                            message: 'session成功',
                            type: 'success'
                        });
                    }
                });
            }


        },
        mounted() {
            if ("true" == $.cookie("isLogined")) {
                console.log("已登录！");
                var a = $.cookie("userCode"),
                    r = $.cookie("userPassword");
                console.log("userCode:" + a), console.log("userPassword:" + r);
                var c = {
                    usercode: a,
                    userpassword: r
                };
                this.cookdl(c);

            }else this.butop();
        }

    };
    const app = Vue.createApp(App);
    app.use(ElementPlus);
    app.mount("#app");
</script>
</body>
</html>

