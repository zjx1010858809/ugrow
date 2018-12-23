package com.ugrow.internet.Controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ugrow.internet.Entity.BackEducation;
import com.ugrow.internet.Service.BackEducationService;
import com.ugrow.internet.Utils.BackEducationSearchInfo;
import com.ugrow.internet.Utils.jsonInfo;
/**
 * 教学相关管理
 * @author Administrator
 *
 */
@Controller
@RequestMapping("education")
public class BackEducationController {
	@Autowired
	BackEducationService service;


	//	进入主页
	@RequestMapping("index")
	public String index(String type,Model m) {
		if(type.equals("arrange")) {
//			实验安排
			m.addAttribute("type",12);
		}else if(type.equals("instruct")) {
//			指导书
			m.addAttribute("type",13);
		}
		else if(type.equals("instrument")) {
//			仪器
			m.addAttribute("type",14);
		}
		else if(type.equals("research")) {
//			研究
			m.addAttribute("type",15);
		}
		else if(type.equals("innovate")) {
//			创新
			m.addAttribute("type",16);
		}
		else if(type.equals("culture")) {
//			文化
			m.addAttribute("type",17);
		}
		return "back/education/index";
	}

	//	首页数据填充
	@RequestMapping("index_json")
	@ResponseBody
	public HashMap<String, Object> index(int typeid,BackEducationSearchInfo info) throws Exception {
		HashMap<String, Object> m = new HashMap<String, Object>();
		ArrayList<BackEducation> list = new ArrayList<BackEducation>();

//		获取条件
		String title=info.getTitle();

		if (title == null) {
			info.setWhere(" where typeid="+typeid+" ");
		} else if (title == "") {
			info.setWhere(" where typeid="+typeid+" ");
		} else {
			info.setWhere(" where title like '%"+title+"%' and typeid="+typeid+" ");
			info.setLimits(" ");
		}

//		查询
		list = (ArrayList<BackEducation>) service.index(info);

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
	public String add(Integer typeid,Model m) {
		m.addAttribute("typeid",typeid);
		return "back/education/edit";
	}

	//	进入修改页
	@RequestMapping("edit")
	public String edit(int id,Model m) {
		m.addAttribute("educationInfo",service.getByid(id));
		return "back/education/edit";
	}

	//	新增
	@RequestMapping("insert")
	public @ResponseBody jsonInfo insert(BackEducation e) {
		Date time=new Date();
		SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
		e.setTime(formatter.format(time));
		int i=service.insert(e);
		if(i==1) {
			return new jsonInfo(1, "新增成功！");
		}else {
			return new jsonInfo(0, "请重新操作！");
		}
	}

	//	修改
	@RequestMapping("update")
	public @ResponseBody jsonInfo update(BackEducation e) {
		Date time=new Date();
		SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
		e.setTime(formatter.format(time));
		int i=service.update(e);
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
			return new jsonInfo(1, "删除成功！");
		}else {
			return new jsonInfo(0, "请重新操作！");
		}
	}

}
