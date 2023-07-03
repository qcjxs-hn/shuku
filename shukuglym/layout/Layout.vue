<template>
    <div>
        <!-- 头部 -->
        <Header></Header>
        <!-- 主体 -->
        <div style="display:flex;">
        <!-- 左侧菜单 -->
        <Aside/>
            <!-- 内容 -->
            <router-view style="flex:1;"></router-view>
        </div>
    </div>
</template>

<script>
import Aside from '../src/components/Aside.vue' 
import Header from '../src/components/Header.vue'
export default {
    components: {
        Header,
        Aside,
    }
}
</script>

<style>

</style>