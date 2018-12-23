package com.ugrow.internet.Service;

import java.util.List;
import com.ugrow.internet.Entity.BackEducation;
import com.ugrow.internet.Utils.BackEducationSearchInfo;

public interface BackEducationService {
	public List<BackEducation> index(BackEducationSearchInfo info);
	public int insert(BackEducation o);
	public int update(BackEducation o);
	public int delete(int id);
	public BackEducation getByid(int id);
	public int count(BackEducationSearchInfo info);

}
