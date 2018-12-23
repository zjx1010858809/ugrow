package com.ugrow.internet.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.ugrow.internet.Entity.BackType;

@Repository
public interface BackTypeMapper {
	@Select("select * from type")
	public List<BackType> index();
	@Insert("insert into Type(name,parentid) values(#{name},#{parentid})")
	public int insert(BackType b);
	@Update("update Type set name=#{name} where id=#{id}")
	public int update(BackType b);
	@Delete("delete from Type where id=#{id}")
	public int delete(int id);
	@Select("select * from Type where id=#{id}")
	public BackType getByid(int id);

}
