package com.ugrow.internet.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ugrow.internet.Entity.BackEducation;
import com.ugrow.internet.Entity.BackType;
import com.ugrow.internet.Service.FrontEducationService;
import com.ugrow.internet.Service.FrontNewsService;
import com.ugrow.internet.Service.FrontTypeService;
import com.ugrow.internet.Utils.FrontEducationSearchinfo;
import com.ugrow.internet.Utils.FrontNewsSearchinfo;
import com.ugrow.internet.Utils.FrontTypeSearchinfo;

@Controller
@RequestMapping("front")
public class FrontEducationController {
	@Autowired 
	FrontEducationService eservice;
	@Autowired 
	FrontTypeService tservice;
	@RequestMapping("education")
	public String list(Model m,FrontEducationSearchinfo info,int typeid) {
		//侧边栏标题
		BackType t=tservice.getbyid(typeid);
		FrontTypeSearchinfo info1=new FrontTypeSearchinfo();
		info1.setWhere(" where parentid="+t.getParentid());
		m.addAttribute("title", tservice.title(info1));
		m.addAttribute("typeid", typeid);
		return "front/list";
	}
	@RequestMapping("educationdetail")
	public String detail(Model m,BackEducation e,int typeid) {
		m.addAttribute("detail", eservice.getbyid(e));
		m.addAttribute("title", 1);
		m.addAttribute("typeid", typeid);
		m.addAttribute("title1","成果展示");
		m.addAttribute("title2", tservice.getbyid(typeid).getName());
		return "front/detail";
	}
}
