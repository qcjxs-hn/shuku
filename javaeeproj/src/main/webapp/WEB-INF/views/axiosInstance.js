import axios from '../../resources/js/axios';

// 创建 Axios 实例
const instance = axios.create({
    baseURL: 'http://localhost:8084', // 设置请求的基本 URL
    headers: {
        'Content-Type': 'application/json', // 设置请求头
    },
});

export default instance;
