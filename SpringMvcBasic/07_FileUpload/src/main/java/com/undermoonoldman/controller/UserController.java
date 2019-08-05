package com.undermoonoldman.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.undermoonoldman.bean.User;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {
    /***
     * 传统方式的文件上传
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/fileupload_01")
    public String fileupload_01(HttpServletRequest request) throws Exception{
        System.out.println("执行 fileupload_01");
        System.out.println("传统方式文件上传");
        //使用fileupload组件完成文件上传
        //上传位置
        String path = request.getSession().getServletContext().getRealPath("/uploads/");

        //判断路径是否存在，不存在则创建文件夹
        File file = new File(path);
        if(!file.exists()){
            file.mkdirs();
        }

        //解析request对象，获取上传文件项
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        //解析request
        List<FileItem> items = upload.parseRequest(request);
        //遍历
        for(FileItem item : items){
            //判断当前item是否是上传文件项
            if(item.isFormField()){
                //为普通表单项

            } else {
                //为上传文件项
                //获取上传文件名称
                String fileName = item.getName();
                //把文件名称设置为唯一值uuid
                String uuid = UUID.randomUUID().toString().replace("-", "");
                fileName = uuid + "_" + fileName;
                //完成文件上传
                item.write(new File(path, fileName));
                //删除临时文件(上传大于10kb就会有临时文件)
                item.delete();
            }
        }
        return "success";
    }


    /***
     * SpringMvc方式的文件上传
     * MultipartFile的名字要与表单文件选项名称一致
     * @param request
     * @param upload
     * @return
     * @throws Exception
     */
    @RequestMapping("/fileupload_02")
    public String fileupload_02(HttpServletRequest request, MultipartFile upload) throws Exception{
        System.out.println("执行 fileupload_02");
        System.out.println("SpringMvc文件上传");
        //使用fileupload组件完成文件上传
        //上传位置
        String path = request.getSession().getServletContext().getRealPath("/uploads/");

        //判断路径是否存在，不存在则创建文件夹
        File file = new File(path);
        if(!file.exists()){
            file.mkdirs();
        }
        //为上传文件项
        //获取上传文件名称
        String fileName = upload.getOriginalFilename();
        //把文件名称设置为唯一值uuid
        String uuid = UUID.randomUUID().toString().replace("-", "");
        fileName = uuid + "_" + fileName;
        //完成文件上传
        upload.transferTo(new File(path, fileName));
        return "success";
    }


    /***
     * 跨服务器文件上传
     * MultipartFile的名字要与表单文件选项名称一致
     * @param upload
     * @return
     * @throws Exception
     */
    @RequestMapping("/fileupload_03")
    public String fileupload_03(MultipartFile upload) throws Exception{
        System.out.println("执行 fileupload_03");
        System.out.println("跨服务器文件上传");
        //定义上传服务器路径
        String path = "http://localhost:9090/uploads/";


        //为上传文件项
        //获取上传文件名称
        String fileName = upload.getOriginalFilename();
        //把文件名称设置为唯一值uuid
        String uuid = UUID.randomUUID().toString().replace("-", "");
        fileName = uuid + "_" + fileName;
        //创建客户端对象
        Client client = Client.create();
        //与图片服务器进行连接
        WebResource webResource = client.resource(path + fileName);
        //上传文件
        webResource.put(upload.getBytes());
        return "success";
    }
}
