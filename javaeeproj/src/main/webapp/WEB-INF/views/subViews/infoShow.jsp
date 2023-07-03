<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div id="infoShow" class="index">
    <div class="label-img">
        <label class="label-name">头像：</label>
        <img class="img-thumbnail" src="${pageContext.request.contextPath}/${user.avatar.avatarimg}" alt="avatar">
    </div>
    <p>
        <label class="label-name">用户名：</label>
        <label class="label-value">${user.usercode}</label>
    </p>
    <p>
        <label class="label-name">昵称:</label>
        <label class="label-value">${user.username}</label>
    </p>
    <p>
        <label class="label-name">邮箱：</label>
        <label class="label-value">${user.email}</label>
    </p>

    <p>
        <label class="label-name">等级：</label>
        <label class="label-value">${user.contribution.leveltxt}</label>
    </p>
    <p>
        <label class="label-name">贡献值：</label>
        <label class="label-value">${user.contributionValue}</label>
    </p>
</div>