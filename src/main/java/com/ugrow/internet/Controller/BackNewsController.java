package com.ugrow.internet.Controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import com.ugrow.internet.Utils.jsonInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ugrow.internet.Entity.BackNews;
import com.ugrow.internet.Service.BackNewsService;
import com.ugrow.internet.Utils.SearchInfo;

@Controller
@RequestMapping("news")
public class BackNewsController {
	@Autowired
	BackNewsService service;


	//	首页数据填充
	@RequestMapping("index_json")
	@ResponseBody
	public HashMap<String, Object> index(BackNews backNews,SearchInfo info) throws Exception {
		HashMap<String, Object> m = new HashMap<String, Object>();
		ArrayList<BackNews> list = new ArrayList<BackNews>();
			info.setWhere(" where typeid="+backNews.getTypeid());
			StringBuilder sbWhere=new StringBuilder();
			String Carousel="";
			if(backNews.getCarousel()!=null){
				if (backNews.getCarousel()==0){
					Carousel=" and length(pic)=0";
				}else {
					Carousel=" and length(pic)>0";
				}
			}
			if (backNews.getStart()!=null&&backNews.getStart().length()>0&&backNews.getEnd()!=null&&backNews.getEnd().length()>0){
				info.setWhere(" where time between '"+backNews.getStart()+"' and '"+backNews.getEnd()+"' and typeid="+backNews.getTypeid());
			}
			if (backNews.getStart()!=null&&backNews.getStart().length()>0&&backNews.getEnd().length()==0){
				info.setWhere(" where time > '"+backNews.getStart()+"'and typeid="+backNews.getTypeid());
			}
			if (backNews.getEnd()!=null&&backNews.getEnd().length()>0&&backNews.getStart().length()==0){
				info.setWhere(" where time < '"+backNews.getEnd()+"' and typeid="+backNews.getTypeid());
			}
			if(backNews.getStart()==null&&backNews.getEnd()==null){
				info.setWhere(" where typeid="+backNews.getTypeid());
			}
			sbWhere.append(info.getWhere()+Carousel);
			info.setWhere(sbWhere.toString());
//		查询
		list = (ArrayList<BackNews>) service.index(info);
		// count
		int count = service.count();
		m.put("data", list);
		m.put("count", count);
		m.put("msg", "");
		m.put("code", 0);
		return m;
	}
	//新增
	@RequestMapping("addNews")
	public @ResponseBody jsonInfo addNews(BackNews backNews) {
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		backNews.setTime(simpleDateFormat.format(date));
		backNews.setLook(1);
		backNews.setCarousel(0);
		service.insert(backNews);
		return new jsonInfo(1,"ok");
	}
	//编辑
	@RequestMapping("editNews")
	public String editNews(Integer id, Model model,Integer typeid) {
		BackNews news=service.getByid(id);
		model.addAttribute("news",news);
		if(typeid==10)
		return "back/news/adddynamic";
		return "back/news/addnotice";
	}
	//更新
	@RequestMapping("updateNews")
	public @ResponseBody jsonInfo updateNews(BackNews backNews) {
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		backNews.setTime(simpleDateFormat.format(date));
		service.update(backNews);
		return new jsonInfo(1,"ok");
	}
	//删除
	@RequestMapping("deleteNews")
	public @ResponseBody jsonInfo deleteNews(Integer id) {
		service.delete(id);
		return new jsonInfo(1,"ok");
	}

	//主页显示
	@RequestMapping("updateLook")
	public @ResponseBody jsonInfo updateLook(BackNews backNews) {
		service.updateLook(backNews);
		return new jsonInfo(1,"ok");
	}
	//轮播显示
	@RequestMapping("updateCarousel")
	public @ResponseBody jsonInfo updateCarousel(BackNews backNews) {
		service.updateCarousel(backNews);
		return new jsonInfo(1,"ok");
	}

	@RequestMapping("adddynamic")
	public String adddynamic(Model model,Integer typeid) {
		model.addAttribute("typeid",typeid);
		return "back/news/adddynamic";
	}
	@RequestMapping("addnotice")
	public String addnotice(Model model,Integer typeid) {
		model.addAttribute("typeid",typeid);
		return "back/news/addnotice";
	}
	@RequestMapping("dynamic")
	public String dynamic(Model model){
		Integer typeid=10;
		model.addAttribute("typeid",typeid);
		return "back/news/dynamic";
	}
	@RequestMapping("notice")
	public String notice(Model model) {
		Integer typeid=11;
		model.addAttribute("typeid",typeid);
		return "back/news/notice";
	}
	@RequestMapping("rule")
	public String rule(Model model) {
		Integer typeid=3;
		model.addAttribute("typeid",typeid);
		return "back/news/notice";
	}
	@RequestMapping("/404")
	public String notfind(Model model) {

		return "back/404";
	}
}
