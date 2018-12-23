package com.ugrow.internet.Service;

import java.util.List;

import com.ugrow.internet.Entity.BackType;
import com.ugrow.internet.Utils.FrontEducationSearchinfo;
import com.ugrow.internet.Utils.FrontNewsSearchinfo;
import com.ugrow.internet.Entity.BackEducation;
import com.ugrow.internet.Entity.BackNews;

public interface FrontEducationService {
	public List<BackEducation> index(FrontEducationSearchinfo info);
	public BackEducation getbyid(BackEducation b);
	public int count(FrontEducationSearchinfo info);
}
