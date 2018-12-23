package com.ugrow.internet.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ugrow.internet.Entity.BackOperator;
import com.ugrow.internet.Entity.BackNews;
import com.ugrow.internet.Service.FrontEducationService;
import com.ugrow.internet.Service.FrontNewsService;
import com.ugrow.internet.Utils.FrontEducationSearchinfo;
import com.ugrow.internet.Utils.FrontNewsSearchinfo;

@Controller
@RequestMapping("front")
public class FrontIndexController {
	@Autowired 
	FrontNewsService nservice;
	@Autowired 
	FrontEducationService eservice;
	@RequestMapping("index")
	public String index(Model m){
		//首页新闻
		FrontNewsSearchinfo info1=new FrontNewsSearchinfo();
		info1.setWhere(" where typeid=10 and look=1");
		info1.setLimits(" limit 0,8");
		m.addAttribute("dynamic", nservice.index(info1));
		//首页通告
		FrontNewsSearchinfo info2=new FrontNewsSearchinfo();
		info2.setWhere(" where typeid=11 and look=1");
		info2.setLimits(" limit 0,8");
		m.addAttribute("notice", nservice.index(info2));
		//首页教学
		FrontNewsSearchinfo info3=new FrontNewsSearchinfo();
		info3.setWhere(" where typeid=3");
		info3.setLimits(" limit 0,8");
		m.addAttribute("rules", nservice.index(info3));
		//首页成果
		FrontEducationSearchinfo info4=new FrontEducationSearchinfo();
		info4.setLimits(" limit 0,8");
		m.addAttribute("result", eservice.index(info4));
		//轮播
		FrontNewsSearchinfo info5=new FrontNewsSearchinfo();
		info5.setWhere(" where typeid=10 and carousel=1");
		info5.setLimits( "limit 0,5");
		m.addAttribute("carousel",nservice.index(info5));
		return "front/index";
	}
}
