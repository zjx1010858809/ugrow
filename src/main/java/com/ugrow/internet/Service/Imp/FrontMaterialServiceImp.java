package com.ugrow.internet.Service.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ugrow.internet.Entity.BackEducation;
import com.ugrow.internet.Entity.BackMaterial;
import com.ugrow.internet.Entity.BackNews;
import com.ugrow.internet.Mapper.FrontMaterialMapper;
import com.ugrow.internet.Mapper.FrontNewsMapper;
import com.ugrow.internet.Service.FrontMaterialService;
import com.ugrow.internet.Service.FrontNewsService;
import com.ugrow.internet.Utils.FrontMaterialSearchinfo;
import com.ugrow.internet.Utils.FrontNewsSearchinfo;

@Service
public class FrontMaterialServiceImp implements FrontMaterialService{
	@Autowired
	FrontMaterialMapper mapper;

	@Override
	public List<BackMaterial> index(FrontMaterialSearchinfo info) {
		return mapper.index(info);
	}

	@Override
	public BackMaterial getbyid(BackMaterial b) {
		return mapper.getbyid(b);
	}

	@Override
	public int count(FrontMaterialSearchinfo searchinfo) {
		return mapper.count(searchinfo);
	}


}
