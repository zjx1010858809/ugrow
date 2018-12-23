package com.ugrow.internet.Service;

import java.util.List;

import com.ugrow.internet.Utils.FrontMaterialSearchinfo;
import com.ugrow.internet.Utils.FrontNewsSearchinfo;
import com.ugrow.internet.Entity.BackEducation;
import com.ugrow.internet.Entity.BackMaterial;
import com.ugrow.internet.Entity.BackNews;

public interface FrontMaterialService {
	public List<BackMaterial> index(FrontMaterialSearchinfo info);
	public BackMaterial getbyid(BackMaterial b);
	public int count(FrontMaterialSearchinfo searchinfo);
}
