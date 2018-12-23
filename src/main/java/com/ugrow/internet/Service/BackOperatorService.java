package com.ugrow.internet.Service;

import java.util.List;

import com.ugrow.internet.Entity.BackOperator;
import com.ugrow.internet.Utils.BackOperatorSearchInfo;

public interface BackOperatorService {
	public List<BackOperator> index(BackOperatorSearchInfo info);
	public int insert(BackOperator o);
	public int update(BackOperator o);
	public int delete(int id);
	public BackOperator getByid(int id);
	public int count(BackOperatorSearchInfo info);
	public int reset(int id);
	public int check(String nike);
	public BackOperator logIn(BackOperator operator);
	public int updatePass(BackOperator o);

}
