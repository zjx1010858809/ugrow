package com.ugrow.internet.Service;

import java.util.List;

import com.ugrow.internet.Entity.BackType;

public interface BackTypeService {
	public List<BackType> index();
	public int insert(BackType b);
	public int update(BackType b);
	public int delete(int id);
	public BackType getByid(int id);

}
