package com.ugrow.internet.Service.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ugrow.internet.Entity.BackEducation;
import com.ugrow.internet.Entity.BackNews;
import com.ugrow.internet.Mapper.FrontNewsMapper;
import com.ugrow.internet.Service.FrontNewsService;
import com.ugrow.internet.Utils.FrontNewsSearchinfo;

@Service
public class FrontNewsServiceImp implements FrontNewsService{
	@Autowired
	FrontNewsMapper mapper;
	@Override
	public List<BackNews> index(FrontNewsSearchinfo info) {
		return mapper.index(info);
	}

	@Override
	public int count(FrontNewsSearchinfo searchinfo) {
		return mapper.count(searchinfo);
	}

	@Override
	public BackNews getbyid(BackNews n) {
		return mapper.getbyid(n);
	}

}
