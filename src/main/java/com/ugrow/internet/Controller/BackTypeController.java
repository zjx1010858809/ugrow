package com.ugrow.internet.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ugrow.internet.Service.BackTypeService;
/**
 * 导航栏分类管理
 * @author Administrator
 *
 */
@Controller
@RequestMapping("backtype")
public class BackTypeController {
	@Autowired
	BackTypeService service;

	@RequestMapping("index")
	public String index(Model m){
		m.addAttribute("data",service.index());
		return "back/type/index";
	}
}
