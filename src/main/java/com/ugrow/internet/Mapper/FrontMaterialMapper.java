package com.ugrow.internet.Mapper;

import java.util.List;

import com.ugrow.internet.Utils.*;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.ugrow.internet.Entity.BackEducation;
import com.ugrow.internet.Entity.BackMaterial;
import com.ugrow.internet.Entity.BackNews;
import com.ugrow.internet.Entity.BackType;

@Repository
public interface FrontMaterialMapper {
	@Select("select * from material ${where} order by id desc")
	public List<BackMaterial> index(FrontMaterialSearchinfo info);
	@Select("select * from material where id=#{id}")
	public BackMaterial getbyid(BackMaterial b);
	@Select("select count(id) from material ${where}")
	public int count(FrontMaterialSearchinfo info);
}
