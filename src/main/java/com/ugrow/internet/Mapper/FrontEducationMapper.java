package com.ugrow.internet.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.ugrow.internet.Entity.BackEducation;
import com.ugrow.internet.Entity.BackNews;
import com.ugrow.internet.Utils.BackEducationSearchInfo;
import com.ugrow.internet.Utils.FrontEducationSearchinfo;
import com.ugrow.internet.Utils.FrontNewsSearchinfo;

@Repository
public interface FrontEducationMapper {
	@Select("select * from education ${where} order by time desc ${limits}")
	public List<BackEducation> index(FrontEducationSearchinfo info);
	@Select("select * from education where id=#{id}")
	public BackEducation getbyid(BackEducation b);
	@Select("select count(id) from education ${where}")
	public int count(FrontEducationSearchinfo info);
}
