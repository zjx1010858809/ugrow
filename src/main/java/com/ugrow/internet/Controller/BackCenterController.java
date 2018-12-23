package com.ugrow.internet.Controller;

import com.ugrow.internet.Entity.BackCenter;
import com.ugrow.internet.Service.BackTypeService;

import com.ugrow.internet.Service.BackCenterService;
import com.ugrow.internet.Utils.SearchInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/back/center")
public class BackCenterController {
	@Autowired
	BackCenterService center_service;
	@Autowired
	BackTypeService backType_service;

	/**
	 *
	 * @param model
	 * @param typeid 点击左侧抽屉传过类型名，用innerjoin关联type和center表，条件是type中的name为typenama
	 * @return
	 */
	@RequestMapping("/institution")
	public String institution(Model model,Integer typeid) {
		SearchInfo SearchInfo = new SearchInfo();
		SearchInfo.setWhere("where typeid="+typeid);
		List<BackCenter> list=center_service.selectCenter(SearchInfo);
		if (list.size()==0){
			model.addAttribute("institution",null);
			model.addAttribute("typeid",typeid);
		}else{
			model.addAttribute("institution",list.get(0));
			SearchInfo.setWhere("where typeid="+typeid);
			model.addAttribute("typeid",typeid);
		}
		return "back/center/institution";
	}
	@RequestMapping("/institutionInsert")
	public  String institutionInsert(Model model,BackCenter center){
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String  time=simpleDateFormat.format(date);
		center.setTime(time);
		center_service.insertCenter(center);
		SearchInfo SearchInfo = new SearchInfo();
		SearchInfo.setWhere("where typeid="+center.getTypeid());
		List<BackCenter> list=center_service.selectCenter(SearchInfo);
		model.addAttribute("institution",list.get(0));
		return "back/center/institution";
	}
	@RequestMapping("/institutionUpdate")
	public String institutionUpdate(Model model,BackCenter center){
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String  time=simpleDateFormat.format(date);
		center.setTime(time);
		center_service.updateCenter(center);
		SearchInfo SearchInfo = new SearchInfo();
		SearchInfo.setWhere("where id="+center.getId());
		List<BackCenter> list=center_service.selectCenter(SearchInfo);
		model.addAttribute("institution",list.get(0));
		return "back/center/institution";
	}

}
