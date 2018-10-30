package com.douyaer.cms.dao;

import java.util.List;

import com.douyaer.cms.pojo.Admin;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface AdminMapper {
    @Delete({
        "delete from t_admin",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into t_admin (id, name, ",
        "password, ctime, ",
        "mtime)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{password,jdbcType=VARCHAR}, #{ctime,jdbcType=TIMESTAMP}, ",
        "#{mtime,jdbcType=TIMESTAMP})"
    })
    int insert(Admin record);

    int insertSelective(Admin record);

    @Select({
        "select",
        "id, name, password, ctime, mtime",
        "from t_admin",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    Admin selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Admin record);

    @Update({
        "update t_admin",
        "set name = #{name,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "ctime = #{ctime,jdbcType=TIMESTAMP},",
          "mtime = #{mtime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Admin record);

    @Select({
        "select",
        "id, name, password, ctime, mtime",
        "from t_admin",
        "where name = #{name,jdbcType=VARCHAR}"
    })
    @ResultMap("BaseResultMap")
    Admin getAdminByName(String name);

    @Select({
        "select",
        "id, name, password, ctime, mtime",
        "from t_admin"
    })
    @ResultMap("BaseResultMap")
    List<Admin> list();
}