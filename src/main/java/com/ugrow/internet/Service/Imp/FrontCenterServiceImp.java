package com.ugrow.internet.Service.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ugrow.internet.Entity.BackCenter;
import com.ugrow.internet.Entity.BackEducation;
import com.ugrow.internet.Entity.BackNews;
import com.ugrow.internet.Mapper.FrontCenterMapper;
import com.ugrow.internet.Mapper.FrontNewsMapper;
import com.ugrow.internet.Service.FrontCenterService;
import com.ugrow.internet.Service.FrontNewsService;
import com.ugrow.internet.Utils.FrontCenterSearchinfo;
import com.ugrow.internet.Utils.FrontNewsSearchinfo;

@Service
public class FrontCenterServiceImp implements FrontCenterService{
	@Autowired
	FrontCenterMapper mapper;

	@Override
	public BackCenter index(FrontCenterSearchinfo info) {
		return mapper.index(info);
	}


}
