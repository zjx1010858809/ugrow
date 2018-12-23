package com.ugrow.internet.Controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ugrow.internet.Entity.BackMaterial;
import com.ugrow.internet.Service.BackMaterialService;
import com.ugrow.internet.Utils.jsonInfo;
import com.ugrow.internet.Utils.BackMaterialSearchInfo;
/**
 * 资料管理
 * @author Administrator
 *
 */
@Controller
@RequestMapping("material")
public class BackMaterialController {
//文档软件上传路径
	@Value("${web.fileupload.path}")
	private String fileuploadpath;
	@Value("${web.sorftupload.path}")
	private String sorftuploadpath;
	@Autowired
	BackMaterialService service;
//	进入首页
	@RequestMapping("index")
	public String index(int fileType,Model m) {
		m.addAttribute("fileType",fileType);
		return "back/material/index";
	}
	
//	首页数据填充
	@RequestMapping("index_json")
	@ResponseBody
	public HashMap<String, Object> index(BackMaterialSearchInfo info,int fileType) throws Exception {
		HashMap<String, Object> m = new HashMap<String, Object>();
		ArrayList<BackMaterial> list = new ArrayList<BackMaterial>();
		
//		获取条件
		String title=info.getTitle();
		
		if (title == null) {
			info.setWhere(" where fileType="+fileType+" ");
		} else if (title == "") {
			info.setWhere(" where fileType="+fileType+" ");
		} else {
			info.setWhere(" where title like '%"+title+"%' and fileType="+fileType+" ");
			info.setLimits(" ");
		}
		
//		查询
		list = (ArrayList<BackMaterial>) service.index(info);
		
		// count
		int count = service.count(info);
		m.put("data", list);
		m.put("count", count);
		m.put("msg", "");
		m.put("code", 0);
		return m;
	}
	
//	进入新增页
	@RequestMapping("add")
	public String add(int fileType,Model m) {
		m.addAttribute("fileType",fileType);
		return "back/material/edit";
	}
	
//	进入修改页
	@RequestMapping("edit")
	public String edit(int id,Model m) {
		m.addAttribute("MaterialInfo",service.getByid(id));
		return "back/material/edit";
	}
	
//	新增
	@RequestMapping("insert")
	public @ResponseBody jsonInfo insert(BackMaterial o) {
		
			int i=service.insert(o);
			if(i==1) {
				return new jsonInfo(1, "新增成功！");
			}else {
				return new jsonInfo(0, "请重新操作！");
			}
	}
	
//	修改
	@RequestMapping("update")
	public @ResponseBody jsonInfo update(BackMaterial o) {
			int i=service.update(o);
			if(i==1) {
				return new jsonInfo(1, "修改成功！");
			}else {
				return new jsonInfo(0, "请重新操作！");
			}
	}
	
//	删除
	@RequestMapping("del")
	public @ResponseBody jsonInfo delete(int id) {
			int i=service.delete(id);
			if(i==1) {
				return new jsonInfo(1, "修改成功！");
			}else {
				return new jsonInfo(0, "请重新操作！");
			}
	}
	
	
	
//文件上传
	@PostMapping("upload")
	@ResponseBody
	public HashMap<String, Object> singleFileUpload(@RequestParam("file") MultipartFile file,int fileType) {
		HashMap<String, Object> m = new HashMap<String, Object>();
				
		Path path = null;

	    try{
	        byte[] bytes = file.getBytes();
	        if(fileType==0) {
	        	File fileUp=new File(fileuploadpath);
	        	if(!fileUp.exists()){
	        		fileUp.mkdirs();
				}
	        	path = Paths.get(fileuploadpath +System.currentTimeMillis()+ "-"+file.getOriginalFilename());
	        }else {
				File fileUp=new File(sorftuploadpath);
				if(!fileUp.exists()){
					fileUp.mkdirs();
				}
	        	path = Paths.get(sorftuploadpath +System.currentTimeMillis()+ "-"+ file.getOriginalFilename());
	        }
	        
	        Files.write(path, bytes);
	        
	        m.put("data", path);
			m.put("msg", "请重新操作！");
			m.put("code", 0);
	        
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    
		
		return m;
	}
}
