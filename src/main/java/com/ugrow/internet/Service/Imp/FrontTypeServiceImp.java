package com.ugrow.internet.Service.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ugrow.internet.Entity.BackType;
import com.ugrow.internet.Entity.BackNews;
import com.ugrow.internet.Mapper.BackTypeMapper;
import com.ugrow.internet.Mapper.FrontNewsMapper;
import com.ugrow.internet.Mapper.FrontTypeMapper;
import com.ugrow.internet.Service.FrontNewsService;
import com.ugrow.internet.Service.FrontTypeService;
import com.ugrow.internet.Utils.FrontNewsSearchinfo;
import com.ugrow.internet.Utils.FrontTypeSearchinfo;

@Service
public class FrontTypeServiceImp implements FrontTypeService{
	@Autowired
	FrontTypeMapper tmapper;

	@Override
	public List<BackType> title(FrontTypeSearchinfo info) {
		return tmapper.title(info);
	}

	@Override
	public BackType getbyid(int typeid) {		
		return tmapper.getbyid(typeid);
	}
}
