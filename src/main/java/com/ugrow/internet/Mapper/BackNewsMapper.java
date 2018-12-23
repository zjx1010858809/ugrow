package com.ugrow.internet.Mapper;

import java.util.List;

import com.ugrow.internet.Utils.SearchInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.ugrow.internet.Entity.BackNews;


@Repository
public interface BackNewsMapper {
	@Select("select * from News ${where} order by id desc ${limits}")
	public List<BackNews> index(SearchInfo searchInfo);
	@Insert("insert into News(title,content,time,typeid,pic,look,carousel) values(#{title},#{content},#{time},#{typeid},#{pic},#{look},#{carousel})")
	public void insert(BackNews o);
	@Update("update News set title=#{title},content=#{content},time=#{time},pic=#{pic} where id=#{id}")
	public void update(BackNews o);
	@Delete("delete from News where id=#{id}")
	public void delete(int id);
	@Select("select * from News where id=#{id}")
	public BackNews getByid(int id);
	@Select("select count(id) from news")
	public int count();
	@Update("update news set look=#{look} where id=#{id}")
	public void updateLook(BackNews backNews);
	@Update("update news set carousel=#{carousel} where id=#{id}")
	public void updateCarousel(BackNews backNews);
}
