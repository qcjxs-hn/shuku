<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%--导航栏（包括左侧图标、导航链接和右侧的按钮组）--%>

<div id="loginHead">

  <div  class="navbar navbar-default" style="margin-top: 10px">
    <div class="container">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed"
                data-toggle="collapse" data-target="#navbar"
                aria-expanded="false" aria-controls="navbar">
          <span class="sr-only">Toggle navigation</span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>

      </div>
      <div id="navbar" class="navbar-collapse collapse clearfix">
        <ul class="nav navbar-nav">
          <li><a href="index">首页</a> </li>
          <li><a href="bookList?bookType=经典文学">经典文学</a> </li>
          <li><a href="bookList?bookType=通俗小说">通俗小说</a> </li>
          <li><a href="bookList?bookType=计算机类">计算机类</a> </li>
          <li><a href="bookList?bookType=杂志期刊">杂志期刊</a> </li>
        </ul>

        <%--在页面头部右侧显示登录和注册按钮--%>
        <%--登录注册按钮组，用于触发登录或注册模态框--%>
<%--        <div id="loginGroup" class="btn-group pull-right btn-group-sm">--%>
<%--          <button type="button" class="btn btn-default" data-toggle="modal" data-target="#loginModal">登录</button>--%>

<%--          <button type="button" class="btn btn-default" data-toggle="modal" data-target="#regModal">注册</button>--%>
<%--        </div>--%>
        <%
          String cgur = request.getQueryString();
//          out.print(cgur);
          if(cgur==null) {
            out.print(" <div class='sc'> <div class='uploadBtn col-md-4 col-sm-6 col-md-offset-1'> " +
                    "<button  class='btn btn-primary' type='button' @click='butop'> " +
                    "我要上传&nbsp;<span class='glyphicon glyphicon-upload'></span></button> " +
                    "</div>");
          }
          %>
        </div>

        </div>


      </div>
    </div>
  </div>










