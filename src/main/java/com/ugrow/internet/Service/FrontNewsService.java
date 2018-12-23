package com.ugrow.internet.Service;

import java.util.List;

import com.ugrow.internet.Utils.FrontNewsSearchinfo;
import com.ugrow.internet.Entity.BackEducation;
import com.ugrow.internet.Entity.BackNews;

public interface FrontNewsService {
	public List<BackNews> index(FrontNewsSearchinfo info);
	public int count(FrontNewsSearchinfo searchinfo);
	public BackNews getbyid(BackNews n);
}
