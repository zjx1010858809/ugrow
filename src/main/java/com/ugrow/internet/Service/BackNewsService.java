package com.ugrow.internet.Service;

import java.util.List;

import com.ugrow.internet.Entity.BackNews;
import com.ugrow.internet.Utils.SearchInfo;

public interface BackNewsService {
	public List<BackNews> index(SearchInfo searchInfo);
	public void insert(BackNews o);
	public void update(BackNews o);
	public void delete(int id);
	public BackNews getByid(int id);
	public int count();
    public void updateLook(BackNews backNews);
	public void updateCarousel(BackNews backNews);
}
