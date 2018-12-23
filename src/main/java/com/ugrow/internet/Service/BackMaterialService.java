package com.ugrow.internet.Service;

import java.util.List;

import com.ugrow.internet.Entity.BackMaterial;
import com.ugrow.internet.Utils.BackMaterialSearchInfo;

public interface BackMaterialService {
	public List<BackMaterial> index(BackMaterialSearchInfo info);
	public int insert(BackMaterial b);
	public int update(BackMaterial b);
	public int delete(int id);
	public BackMaterial getByid(int id);
	public int count(BackMaterialSearchInfo info);

}
