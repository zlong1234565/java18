package com.turling.dao;

import com.turling.entity.Menu;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MenuMapper {
    @Select("select * from menu where pid=0")
    public List<Menu> findMenu();
    @Select("select * from menu where pid=#{id}")
    public  List<Menu> findMenuById(Integer id);
    @Select("select * from menu")
    public  List<Menu> findAll();
}
