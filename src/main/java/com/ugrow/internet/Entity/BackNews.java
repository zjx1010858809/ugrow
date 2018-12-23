package com.ugrow.internet.Entity;

public class BackNews {
private Integer id;
private String title;
private String content;
private String time;
private Integer typeid;
private String pic;
private Integer look;  //主页中显示  0 不显示 1 显示
private  String start;
private  String end;
private  Integer carousel; //轮播 0不显示  1 显示

	public Integer getCarousel() {
		return carousel;
	}

	public void setCarousel(Integer carousel) {
		this.carousel = carousel;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public String getLooks() {
		return looks[this.look];
	}
public static  String[] looks={"不显示","显示"};
	public Integer getLook() {
		return look;
	}

	public void setLook(Integer look) {
		this.look = look;
	}

	public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public String getTime() {
	return time;
}
public void setTime(String time) {
	this.time = time;
}
public int getTypeid() {
	return typeid;
}
public void setTypeid(int typeid) {
	this.typeid = typeid;
}
public String getPic() {
	return pic;
}
public void setPic(String pic) {
	this.pic = pic;
}

}
