const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  lintOnSave:false,
  devServer: {                //记住，别写错了devServer//设置本地默认端口  选填
    allowedHosts: [
        'free.idcfengye.com', // 允许访问的域名地址，即花生壳内网穿透的地址
        '.idcfengye.com'   // .是二级域名的通配符   
      ],
    port: 8080,
    proxy: {                 //设置代理，必须填
        '/api': {              //设置拦截器  拦截器格式   斜杠+拦截器名字，名字可以自己定
            target: 'http://localhost:8084',     //代理的目标地址
            changeOrigin: true,              //是否设置同源，输入是的
            pathRewrite: {                   //路径重写
                '^/api': ''                     //选择忽略拦截器里面的内容
            }
        }
    },
    
}
})
// // 跨域配置
// module.exports = {
//   devServer: {                //记住，别写错了devServer//设置本地默认端口  选填
//       port: 8080,
//       proxy: {                 //设置代理，必须填
//           '/api': {              //设置拦截器  拦截器格式   斜杠+拦截器名字，名字可以自己定
//               target: 'http://localhost:8084',     //代理的目标地址
//               changeOrigin: true,              //是否设置同源，输入是的
//               pathRewrite: {                   //路径重写
//                   '^/api': ''                     //选择忽略拦截器里面的内容
//               }
//           }
//       }
//   }
// }

