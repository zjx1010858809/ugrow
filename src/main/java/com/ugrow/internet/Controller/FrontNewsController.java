package com.ugrow.internet.Controller;

import com.ugrow.internet.Service.FrontEducationService;
import com.ugrow.internet.Utils.FrontEducationSearchinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ugrow.internet.Entity.BackNews;
import com.ugrow.internet.Entity.BackType;
import com.ugrow.internet.Service.FrontNewsService;
import com.ugrow.internet.Service.FrontTypeService;
import com.ugrow.internet.Utils.FrontNewsSearchinfo;
import com.ugrow.internet.Utils.FrontTypeSearchinfo;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("front")
public class FrontNewsController {
	@Autowired 
	FrontNewsService nservice;
	@Autowired 
	FrontTypeService tservice;
	@Autowired
	FrontEducationService eservice;
	@RequestMapping("news")
	public String list(Model m,FrontNewsSearchinfo info,int typeid) {
		//侧边栏标题
		BackType t=tservice.getbyid(typeid);
		FrontTypeSearchinfo info1=new FrontTypeSearchinfo();
		info1.setWhere(" where parentid="+t.getParentid());
		m.addAttribute("title", tservice.title(info1));
		m.addAttribute("typeid", typeid);
		return "front/list";
	}
	//翻页
	@RequestMapping("newsJson")
	public @ResponseBody Map<String,Object> newsJson(FrontNewsSearchinfo searchinfo,Integer typeid){
		Map<String,Object> map= new HashMap<String, Object>();
		searchinfo.setWhere(" where typeid="+typeid);
		if (typeid>=1&&typeid<=11){
			map.put("list",nservice.index(searchinfo));
			int count=nservice.count(searchinfo);
			int pages=(count+searchinfo.getLimit()-1)/searchinfo.getLimit();
			map.put("pages",pages);
			map.put("typeid",typeid);
		}
		if (typeid>=12&&typeid<=17){
			FrontEducationSearchinfo searchinfo1=new FrontEducationSearchinfo();
			searchinfo1.setWhere(searchinfo.getWhere());
			searchinfo.setLimits(searchinfo.getLimits());
			searchinfo1.setLimit(searchinfo.getLimit());
			map.put("list",eservice.index(searchinfo1));
			int count=eservice.count(searchinfo1);
			int pages=(count+searchinfo.getLimit()-1)/searchinfo.getLimit();
			map.put("pages",pages);
			map.put("typeid",typeid);
		}
		return map;
	}

	@RequestMapping("newsdetail")
	public String detail(Model m,int typeid,BackNews n) {
		m.addAttribute("detail", nservice.getbyid(n));
		m.addAttribute("typeid", typeid);
		m.addAttribute("title", 1);
		m.addAttribute("title1","新闻公告");
		m.addAttribute("title2", tservice.getbyid(typeid).getName());
		return "front/detail";
	}
}