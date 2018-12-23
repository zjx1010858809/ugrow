package com.ugrow.internet.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.ugrow.internet.Entity.BackEducation;
import com.ugrow.internet.Utils.BackEducationSearchInfo;

@Repository
public interface BackEducationMapper {
	@Select("select * from education ${where} order by id desc ${limits}")
	public List<BackEducation> index(BackEducationSearchInfo info);
	@Insert("insert into education(title,content,time,typeid) values(#{title},#{content},#{time},#{typeid})")
	public int insert(BackEducation o);
	@Update("update education set title=#{title},content=#{content},time=#{time} where id=#{id}")
	public int update(BackEducation o);
	@Delete("delete from education where id=#{id}")
	public int delete(int id);
	@Select("select * from education where id=#{id}")
	public BackEducation getByid(int id);
	@Select("select count(id) from education ${where}")
	public int count(BackEducationSearchInfo info);

}
