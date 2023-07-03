<template>
  <div>
       <el-menu style="width:200px"
        :default-active="path"
        router
        class="el-menu-vertical-demo"
      >
        <el-menu-item index="user" >
          <el-icon class="fa fa-user-o"><document /></el-icon>
          <span>用户管理</span>
        </el-menu-item>
        <el-menu-item index="upload">
          <el-icon class="fa fa-file-text"><icon-menu /></el-icon>
          <span>上传管理</span>
        </el-menu-item>
        <el-menu-item index="tx">
          <el-icon class="fa  fa-smile-o"><icon-menu /></el-icon>
          <span>头像管理</span>
        </el-menu-item>
        <el-menu-item index="feedback">
          <el-icon class="fa fa-share-square"><icon-menu /></el-icon>
          <span>反馈管理</span>
        </el-menu-item>
        <el-menu-item index="contribution">
          <el-icon class="fa fa-align-center"><icon-menu /></el-icon>
          <span>等级管理</span>
        </el-menu-item>
        <el-sub-menu index="1">
          <template #title>
            <el-icon class="fa fa-align-left"><icon-menu /></el-icon>
            <span>书籍管理</span>
          </template>
            <el-menu-item index="book"><el-icon class="fa fa-book"><icon-menu/></el-icon>书籍</el-menu-item>
            <el-menu-item index="booktype"><el-icon class="fa fa-bookmark"><icon-menu/></el-icon>书籍类型</el-menu-item>
            
        </el-sub-menu>
        <el-menu-item index="4">
          <el-icon class="fa fa-cog"><setting /></el-icon>
          <span>设置</span>
        </el-menu-item>


      </el-menu>

  </div>
</template>

<script>
export default {
      data() {
        return {
          path:this.$route.path.substr(1)
        }
      },

}
</script>

<style>

</style>