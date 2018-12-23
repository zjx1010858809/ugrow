package com.ugrow.internet.Service.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ugrow.internet.Entity.BackEducation;
import com.ugrow.internet.Mapper.BackEducationMapper;
import com.ugrow.internet.Service.BackEducationService;
import com.ugrow.internet.Utils.BackEducationSearchInfo;

@Service
public class BackEducationServiceImp implements BackEducationService {
	@Autowired
	BackEducationMapper mapper;

	@Override
	public List<BackEducation> index(BackEducationSearchInfo info) {
		return mapper.index(info);
	}

	@Override
	public int insert(BackEducation o) {
		return mapper.insert(o);
	}

	@Override
	public int update(BackEducation o) {
		return mapper.update(o);
	}

	@Override
	public int delete(int id) {
		return mapper.delete(id);
	}

	@Override
	public BackEducation getByid(int id) {
		return mapper.getByid(id);
	}

	@Override
	public int count(BackEducationSearchInfo info) {
		return mapper.count(info);
	}
	
}
