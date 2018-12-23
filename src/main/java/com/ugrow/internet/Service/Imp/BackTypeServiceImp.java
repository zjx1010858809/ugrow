package com.ugrow.internet.Service.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ugrow.internet.Entity.BackType;
import com.ugrow.internet.Mapper.BackTypeMapper;
import com.ugrow.internet.Service.BackTypeService;
@Service
public class BackTypeServiceImp implements BackTypeService {
	@Autowired
	BackTypeMapper mapper;

	@Override
	public List<BackType> index() {
		return mapper.index();
	}

	@Override
	public int insert(BackType b) {
		return mapper.insert(b);
	}

	@Override
	public int update(BackType b) {
		return mapper.update(b);
	}

	@Override
	public int delete(int id) {
		return mapper.delete(id);
	}

	@Override
	public BackType getByid(int id) {
		return mapper.getByid(id);
	}

	

}
