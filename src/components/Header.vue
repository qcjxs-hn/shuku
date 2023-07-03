<template>
    <div style="height:50px; line-height:50px; border-bottom:1px solid #ccc; display:flex;">
        <div class="Headerstyle1">书酷后台管理</div>
        <div style="flex:1;"></div>
        <div class="Headerstyle2">
            <el-dropdown>
                <span class="el-dropdown-link">
                    {{this.username}}
                    <el-icon class="el-icon--right">
                        <arrow-down ></arrow-down>
                    </el-icon>
                    </span>
                    <template #dropdown>
                    <el-dropdown-menu>
                       
                        <el-dropdown-item @click="$router.push('/login')">退出系统</el-dropdown-item>
                    </el-dropdown-menu>
                    </template>
            </el-dropdown>
        </div>
    </div>

</template>

<script>

export default {
    name:'Header',
    data() {
        return {
            username:'hhh'
        }
    },
    created () {
        console.log(this.$route.query.user);
        this.username=this.$route.query.user;
    }
}
</script>

<style>

</style>