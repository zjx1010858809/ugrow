package com.ugrow.internet.Service.Imp;

import java.util.List;

import com.ugrow.internet.Utils.SearchInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ugrow.internet.Entity.BackNews;
import com.ugrow.internet.Mapper.BackNewsMapper;
import com.ugrow.internet.Service.BackNewsService;

@Service
public class BackNewsImp implements BackNewsService {
	@Autowired
	BackNewsMapper mapper;

	@Override
	public List<BackNews> index(SearchInfo searchInfo) {
		return mapper.index(searchInfo);
	}

	@Override
	public void insert(BackNews o) {
		 mapper.insert(o);
	}

	@Override
	public void update(BackNews o) {
		 mapper.update(o);
	}

	@Override
	public void delete(int id) {
		 mapper.delete(id);
	}

	@Override
	public BackNews getByid(int id) {
		return mapper.getByid(id);
	}

	@Override
	public int  count() {

		return  mapper.count();
	}

	@Override
	public void updateLook(BackNews backNews) {
		mapper.updateLook(backNews);
	}

	@Override
	public void updateCarousel(BackNews backNews) {
		mapper.updateCarousel(backNews);
	}
}
