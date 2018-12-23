package com.ugrow.internet.Controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileUploadController {
	//自定义文件的上传路径
	@Value("${web.upload.path}")
	private String uploadPath;
	/*
	 * { " ": 0 ,"msg": "" ,"data": { "src": "http://cdn.layui.com/123.jpg" } }
	 */
	@RequestMapping("/fileUploadController")
	public Map<String, Object> fileUpload(MultipartFile file) throws Exception {
		File f = new File(uploadPath);
		if(!f.exists()) {	//判断上传路径是否存在，不在创建
			f.mkdir();		
		}
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String DataDir=sdf.format(d);
		
		File secondDir = new File(uploadPath+DataDir);//根据每天创建子文件夹，不存在则创建
		if(!secondDir.exists()) {
			secondDir.mkdir();	
		}

		System.out.println(secondDir.getPath());
		File file1=(new File(secondDir.getPath() +"\\"+ System.currentTimeMillis()+"."+getExtensionName(file.getOriginalFilename())));
		file.transferTo(file1);//将文件上传到指定目录
		String url=DataDir+"/"+file1.getName();
		System.out.println(url);//获取文件的路径
		Map<String, Object> map = new HashMap<>();
		map.put("msg", "ok");
		map.put("code", 0);
		map.put("data", "ok");
		map.put("url",url);
	
		return map;
	}
	//获取文件的后缀名
	 public static String getExtensionName(String filename) { 
	        if ((filename != null) && (filename.length() > 0)) { 
	            int dot = filename.lastIndexOf('.'); 
	            if ((dot >-1) && (dot < (filename.length() - 1))) { 
	                return filename.substring(dot + 1); 
	            } 
	        } 
	        return filename; 
	    }

}
