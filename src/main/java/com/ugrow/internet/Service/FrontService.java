package com.ugrow.internet.Service;

import java.util.List;

import com.ugrow.internet.Entity.BackType;
import com.ugrow.internet.Utils.FrontNewsSearchinfo;
import com.ugrow.internet.Utils.FrontTypeSearchinfo;
import com.ugrow.internet.Entity.BackNews;

public interface FrontService {
	public List<BackNews> index(FrontNewsSearchinfo info);
	public List<BackType> title(FrontTypeSearchinfo info);
}
