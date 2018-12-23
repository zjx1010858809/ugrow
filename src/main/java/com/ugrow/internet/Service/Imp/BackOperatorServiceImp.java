package com.ugrow.internet.Service.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ugrow.internet.Entity.BackOperator;
import com.ugrow.internet.Mapper.BackOperatorMapper;
import com.ugrow.internet.Service.BackOperatorService;
import com.ugrow.internet.Utils.BackOperatorSearchInfo;

@Service
public class BackOperatorServiceImp implements BackOperatorService {
	@Autowired
	BackOperatorMapper mapper;

	@Override
	public List<BackOperator> index(BackOperatorSearchInfo info) {
		return mapper.index(info);
	}

	@Override
	public int insert(BackOperator o) {
		return mapper.insert(o);
	}

	@Override
	public int update(BackOperator o) {
		return mapper.update(o);
	}

	@Override
	public int delete(int id) {
		return mapper.delete(id);
	}

	@Override
	public BackOperator getByid(int id) {
		return mapper.getByid(id);
	}

	@Override
	public int count(BackOperatorSearchInfo info) {
		return mapper.count(info);
	}

	@Override
	public int reset(int id) {
		return mapper.reset(id);
	}

	@Override
	public int check(String nike) {
		return mapper.check(nike);
	}

	@Override
	public BackOperator logIn(BackOperator operator) {
		return mapper.logIn(operator);
	}

	@Override
	public int updatePass(BackOperator o) {
		return mapper.updatePass(o);
	}

}
