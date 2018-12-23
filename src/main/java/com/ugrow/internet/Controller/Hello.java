package com.ugrow.internet.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ugrow.internet.Service.BackTypeService;
/**
 * 后台首页()
 * @author Administrator
 *
 */
@Controller
public class Hello {
	@Autowired
	BackTypeService service;
	@RequestMapping("index")
	public String index(Model m) {
		m.addAttribute("list", service.index());
		return "back/index";
	}
	@RequestMapping("welcome")
	public String welcome(Model m) {

		return "back/welcome";
	}


}
