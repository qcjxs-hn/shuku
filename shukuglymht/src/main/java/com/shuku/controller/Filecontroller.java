package com.shuku.controller;


import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.shuku.common.Result;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

@RestController
@RequestMapping("/files")
public class Filecontroller {
    @CrossOrigin
    @PostMapping("/upload")
    public Result<?> upload(MultipartFile file, HttpServletRequest res){
        //获取源文件名称
         String Filename=file.getOriginalFilename();
        //定义唯一标识
        String uuid = IdUtil.fastSimpleUUID();
        //拼接路径
        String rootpath = System.getProperty("user.dir") +"/vue-springboot/src/main/resources/files/" +uuid+"_"+ Filename;
        System.out.print(System.getProperty("user.dir"));
        System.out.print(res.getServerName() +":"+res.getServerPort()+ res.getRequestURI()+"/"+uuid);
       // String rootpath = "https://www.qc-h.xyz/wzdtphoto"+uuid+"_"+ Filename;
        try {
            //传输文件
            FileUtil.writeBytes(file.getBytes(),rootpath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.print(res.getServerName() +":"+res.getServerPort()+ res.getRequestURI()+"/"+uuid);
        return Result.success("http://"+res.getServerName() +":"+res.getServerPort()+"/files/"+uuid);

    }
    @GetMapping("/{uuid}")
    public void getFile(HttpServletResponse response,@PathVariable String uuid){
        OutputStream os = null; //输出流
        String basepath=System.getProperty("user.dir") +"/vue-springboot/src/main/resources/files/";
        //获取所有文件名称
        List<String> filenames=FileUtil.listFileNames(basepath);
        //找到文件
        String file=filenames.stream().filter(name -> name.contains(uuid)).findAny().orElse("");
        try {
            if (StrUtil.isNotEmpty(file)) {
                response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(file, "UTF-8"));
                response.setContentType("application/octet-stream");
                byte[] bytes = FileUtil.readBytes(basepath + file);//读取文件字节流
                os=response.getOutputStream();//输出流返回文件
                os.write(bytes);
                os.flush();
                os.close();

            }
        }
        catch (Exception e){
            System.out.println("文件下载失败！");
        }
    }
}
