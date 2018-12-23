package com.ugrow.internet.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import com.ugrow.internet.Entity.BackCenter;
import com.ugrow.internet.Entity.BackEducation;
import com.ugrow.internet.Entity.BackNews;
import com.ugrow.internet.Entity.BackType;
import com.ugrow.internet.Utils.BackEducationSearchInfo;
import com.ugrow.internet.Utils.FrontCenterSearchinfo;
import com.ugrow.internet.Utils.FrontNewsSearchinfo;
import com.ugrow.internet.Utils.FrontTypeSearchinfo;

@Repository
public interface FrontCenterMapper {
	@Select("select * from center ${where}")
	public BackCenter index(FrontCenterSearchinfo info);
}
