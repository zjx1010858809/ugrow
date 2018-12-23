package com.ugrow.internet.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.ugrow.internet.Entity.BackEducation;
import com.ugrow.internet.Entity.BackNews;
import com.ugrow.internet.Entity.BackType;
import com.ugrow.internet.Utils.BackEducationSearchInfo;
import com.ugrow.internet.Utils.FrontNewsSearchinfo;
import com.ugrow.internet.Utils.FrontTypeSearchinfo;

@Repository
public interface FrontNewsMapper {
	@Select("select * from news ${where} order by time desc ${limits}")
	public List<BackNews> index(FrontNewsSearchinfo info);
	@Select("select count(id) from news ${where}")
	public int count(FrontNewsSearchinfo searchinfo);
	@Select("select * from news where id=#{id}")
	public BackNews getbyid(BackNews n);
}
