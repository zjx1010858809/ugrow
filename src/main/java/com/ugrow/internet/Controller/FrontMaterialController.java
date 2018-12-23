package com.ugrow.internet.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ugrow.internet.Entity.BackMaterial;
import com.ugrow.internet.Entity.BackType;
import com.ugrow.internet.Service.FrontMaterialService;
import com.ugrow.internet.Service.FrontMaterialService;
import com.ugrow.internet.Service.FrontNewsService;
import com.ugrow.internet.Service.FrontTypeService;
import com.ugrow.internet.Utils.FrontMaterialSearchinfo;
import com.ugrow.internet.Utils.FrontNewsSearchinfo;
import com.ugrow.internet.Utils.FrontTypeSearchinfo;

@Controller
@RequestMapping("front")
public class FrontMaterialController {
	@Autowired
	FrontMaterialService mservice;
	@Autowired
	FrontTypeService tservice;
	@RequestMapping("material")
	public String list(Model m,FrontMaterialSearchinfo info,int typeid) {
		//侧边栏标题
		BackType t=tservice.getbyid(typeid);
		FrontTypeSearchinfo info1=new FrontTypeSearchinfo();
		info1.setWhere(" where parentid="+t.getParentid());
		m.addAttribute("title", tservice.title(info1));
		m.addAttribute("typeid", typeid);
		return "front/materiallist";
	}
	@RequestMapping("materialJson")
	public @ResponseBody Map<String,Object> newsJson(FrontMaterialSearchinfo searchinfo,Integer typeid){
		Map<String,Object> map= new HashMap<String, Object>();
		if(typeid==19) {
			searchinfo.setWhere(" where fileType=0");
		}
		if(typeid==20) {
			searchinfo.setWhere(" where fileType=1");
		}
		map.put("list",mservice.index(searchinfo));
		int count=mservice.count(searchinfo);
		int pages=(count+searchinfo.getLimit()-1)/searchinfo.getLimit();
		map.put("pages",pages);
		return map;
	}
}
