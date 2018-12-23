package com.ugrow.internet.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.ugrow.internet.Entity.BackMaterial;
import com.ugrow.internet.Utils.BackMaterialSearchInfo;

@Repository
public interface BackMaterialMapper {
	@Select("select * from material ${where} order by id desc ${limits}")
	public List<BackMaterial> index(BackMaterialSearchInfo info);
	@Insert("insert into Material(title,url,fileType) values(#{title},#{url},#{fileType})")
	public int insert(BackMaterial b);
	@Update("update Material set title=#{title},url=#{url},fileType=#{fileType} where id=#{id}")
	public int update(BackMaterial b);
	@Delete("delete from Material where id=#{id}")
	public int delete(int id);
	@Select("select * from Material where id=#{id}")
	public BackMaterial getByid(int id);
	@Select("select count(id) from Material ${where}")
	public int count(BackMaterialSearchInfo info);

}