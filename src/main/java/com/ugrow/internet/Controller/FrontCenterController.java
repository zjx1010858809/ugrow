package com.ugrow.internet.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ugrow.internet.Entity.BackCenter;
import com.ugrow.internet.Entity.BackType;
import com.ugrow.internet.Service.FrontCenterService;
import com.ugrow.internet.Service.FrontNewsService;
import com.ugrow.internet.Service.FrontTypeService;
import com.ugrow.internet.Utils.FrontCenterSearchinfo;
import com.ugrow.internet.Utils.FrontNewsSearchinfo;
import com.ugrow.internet.Utils.FrontTypeSearchinfo;

@Controller
@RequestMapping("front")
public class FrontCenterController {
	@Autowired 
	FrontTypeService tservice;
	@Autowired 
	FrontCenterService cservice;
	@RequestMapping("center")
	public String list(Model m,FrontCenterSearchinfo info,int typeid) {
		info.setWhere(" where typeid="+typeid);
		m.addAttribute("detail", cservice.index(info));
		m.addAttribute("typeid", typeid);
		m.addAttribute("title", 0);
		m.addAttribute("title1","中心概况");
		m.addAttribute("title2", tservice.getbyid(typeid).getName());
		return "front/detail";
	}
}
