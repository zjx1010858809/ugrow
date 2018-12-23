package com.ugrow.internet.Controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class UploadController {
	/*
	 * 处理文件上传
	 */
	@RequestMapping("/upload")
	public Map<String, Object> fileUpload(MultipartFile file) throws Exception {
		System.out.println(file.getOriginalFilename());
		file.transferTo(new File("d:/pic/" + file.getOriginalFilename()));
		Map<String, Object> map = new HashMap<>();
		map.put("msg", "ok");
		map.put("code",0 );
		map.put("data", "ok");
		return map;
	}
	
	@RequestMapping("/front/file")
	public Map<String, Object> fileLoad(String path) throws Exception {
		System.out.println(path);
		Map<String, Object> map = new HashMap<>();
		map.put("msg", "ok");
		map.put("code",0 );
		map.put("data", "ok");
		return map;
	}
	
}
