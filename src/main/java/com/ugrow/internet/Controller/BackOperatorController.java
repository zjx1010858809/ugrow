package com.ugrow.internet.Controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ugrow.internet.Entity.BackOperator;
import com.ugrow.internet.Service.BackOperatorService;
import com.ugrow.internet.Utils.jsonInfo;
import com.ugrow.internet.Utils.BackOperatorSearchInfo;
/**
 * 操作员管理
 * @author Administrator
 *
 */
@Controller
@RequestMapping("operator")
public class BackOperatorController {
	@Autowired
	BackOperatorService service;


//	进入首页
	@RequestMapping("index")
	public String index() {
		return "back/operator/index";
	}
//	首页数据填充
	@RequestMapping("index_json")
	@ResponseBody
	public HashMap<String, Object> index(BackOperatorSearchInfo info) throws Exception {
		HashMap<String, Object> m = new HashMap<String, Object>();
		ArrayList<BackOperator> list = new ArrayList<BackOperator>();

//		获取条件
		String name=info.getName();

		if (name == null) {
			info.setWhere("");
		} else if (name == "") {
			info.setWhere("");
		} else {
			info.setWhere(" where name like '%"+name+"%' ");
			info.setLimits(" ");
		}

//		查询
		list = (ArrayList<BackOperator>) service.index(info);

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
	public String add() {
		return "back/operator/edit";
	}

//	进入修改页
	@RequestMapping("edit")
	public String edit(int id,Model m) {
		m.addAttribute("operatorInfo",service.getByid(id));
		return "back/operator/edit";
	}

//	新增
	@RequestMapping("insert")
	public @ResponseBody jsonInfo insert(BackOperator o) {
		int k=service.check(o.getNike());
		if(k>0) {
			return new jsonInfo(-1, "用户名已被占用！");
		}else {
			int i=service.insert(o);
			if(i==1) {
				return new jsonInfo(1, "新增成功！");
			}else {
				return new jsonInfo(0, "请重新操作！");
			}
		}
	}

//	修改
	@RequestMapping("update")
	public @ResponseBody jsonInfo update(BackOperator o) {
			int i=service.update(o);
			if(i==1) {
				return new jsonInfo(1, "修改成功！");
			}else {
				return new jsonInfo(0, "请重新操作！");
			}
	}

//	重置密码
	@RequestMapping("reset")
	public @ResponseBody jsonInfo reset(int id) {
		int i=service.reset(id);
		if(i==1) {
			return new jsonInfo(1, "密码重置成功！");
		}else {
			return new jsonInfo(0, "请重新操作！");
		}
	}
	
//	删除
	@RequestMapping("delete")
	public @ResponseBody jsonInfo delete(int id) {
		int i=service.delete(id);
		if(i==1) {
			return new jsonInfo(1, "删除成功！");
		}else {
			return new jsonInfo(0, "请重新操作！");
		}
	}	

}
