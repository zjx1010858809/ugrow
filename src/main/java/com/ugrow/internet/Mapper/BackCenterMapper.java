package com.ugrow.internet.Mapper;

import com.ugrow.internet.Entity.BackCenter;
import com.ugrow.internet.Utils.SearchInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
public interface BackCenterMapper {
    @Select("select * from center ${where}")
    public List<BackCenter> selectCenter(SearchInfo SearchInfo);
    @Update("update center set content=#{content},time=#{time} where id=#{id}")
    public void updateCenter(BackCenter center);
    @Insert("insert into center (content,time,typeid) values(#{content},#{time},#{typeid});")
    public void insertCenter(BackCenter center);

}
