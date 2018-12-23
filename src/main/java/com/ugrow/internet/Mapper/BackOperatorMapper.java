package com.ugrow.internet.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.ugrow.internet.Entity.BackOperator;
import com.ugrow.internet.Utils.BackOperatorSearchInfo;


@Repository
public interface BackOperatorMapper {
	@Select("select * from operator ${where} order by id desc ${limits}")
	public List<BackOperator> index(BackOperatorSearchInfo info);
	@Insert("insert into operator(nike,name,sex,pass,tel,comments) values(#{nike},#{name},#{sex},123,#{tel},#{comments})")
	public int insert(BackOperator o);
	@Update("update operator set nike=#{nike},name=#{name},sex=#{sex},tel=#{tel},comments=#{comments} where id=#{id}")
	public int update(BackOperator o);
	@Delete("delete from operator where id=#{id}")
	public int delete(int id);
	@Select("select * from operator where id=#{id}")
	public BackOperator getByid(int id);
	@Select("select count(id) from operator ${where}")
	public int count(BackOperatorSearchInfo info);
	@Update("update operator set pass='123' where id=#{id}")
	public int reset(int id);
	@Select("select count(id) from operator where nike=#{nike}")
	public int check(String nike);
	@Select("select * from operator where nike=#{nike} and pass=#{pass}")
	public BackOperator logIn(BackOperator operator);
	@Update("update operator set pass=#{pass} where id=#{id}")
	public int updatePass(BackOperator o);
}
