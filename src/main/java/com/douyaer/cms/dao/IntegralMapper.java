package com.douyaer.cms.dao;

import com.douyaer.cms.pojo.Integral;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface IntegralMapper {
    @Delete({
        "delete from t_user_integral_log",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into t_user_integral_log (id, user_id, ",
        "event, event_id, ",
        "comment, count, ",
        "ctime)",
        "values (#{id,jdbcType=INTEGER}, #{userId,jdbcType=INTEGER}, ",
        "#{event,jdbcType=VARCHAR}, #{eventId,jdbcType=VARCHAR}, ",
        "#{comment,jdbcType=VARCHAR}, #{count,jdbcType=INTEGER}, ",
        "#{ctime,jdbcType=TIMESTAMP})"
    })
    int insert(Integral record);

    int insertSelective(Integral record);

    @Select({
        "select",
        "id, user_id, event, event_id, comment, count, ctime",
        "from t_user_integral_log",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    Integral selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Integral record);

    @Update({
        "update t_user_integral_log",
        "set user_id = #{userId,jdbcType=INTEGER},",
          "event = #{event,jdbcType=VARCHAR},",
          "event_id = #{eventId,jdbcType=VARCHAR},",
          "comment = #{comment,jdbcType=VARCHAR},",
          "count = #{count,jdbcType=INTEGER},",
          "ctime = #{ctime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Integral record);
}