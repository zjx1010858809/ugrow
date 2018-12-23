package com.ugrow.internet.Service.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ugrow.internet.Entity.BackType;
import com.ugrow.internet.Entity.BackEducation;
import com.ugrow.internet.Entity.BackNews;
import com.ugrow.internet.Mapper.BackTypeMapper;
import com.ugrow.internet.Mapper.FrontEducationMapper;
import com.ugrow.internet.Mapper.FrontNewsMapper;
import com.ugrow.internet.Service.FrontEducationService;
import com.ugrow.internet.Service.FrontNewsService;
import com.ugrow.internet.Utils.FrontEducationSearchinfo;
import com.ugrow.internet.Utils.FrontNewsSearchinfo;

@Service
public class FrontEducationServiceImp implements FrontEducationService{
	@Autowired
	FrontEducationMapper mapper;
	@Override
	public List<BackEducation> index(FrontEducationSearchinfo info) {
		return mapper.index(info);
	}
	@Override
	public BackEducation getbyid(BackEducation b) {
		// TODO Auto-generated method stub
		return mapper.getbyid(b);
	}

	@Override
	public int count(FrontEducationSearchinfo info) {
		return mapper.count(info);
	}
}
