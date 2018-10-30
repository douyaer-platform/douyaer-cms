package com.douyaer.cms.dao;

import com.douyaer.cms.pojo.Notice;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface NoticeMapper {
    @Delete({
        "delete from t_sys_notice",
        "where notice_id = #{noticeId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Long noticeId);

    @Insert({
        "insert into t_sys_notice (notice_id, content, ",
        "ctime, status)",
        "values (#{noticeId,jdbcType=INTEGER}, #{content,jdbcType=VARCHAR}, ",
        "#{ctime,jdbcType=TIMESTAMP}, #{status,jdbcType=INTEGER})"
    })
    int insert(Notice record);

    int insertSelective(Notice record);

    @Select({
        "select",
        "notice_id, content, ctime, status",
        "from t_sys_notice",
        "where notice_id = #{noticeId,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    Notice selectByPrimaryKey(Long noticeId);

    int updateByPrimaryKeySelective(Notice record);

    @Update({
        "update t_sys_notice",
        "set content = #{content,jdbcType=VARCHAR},",
          "ctime = #{ctime,jdbcType=TIMESTAMP},",
          "status = #{status,jdbcType=INTEGER}",
        "where notice_id = #{noticeId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Notice record);

    @Select({
        "select",
        "notice_id, content, ctime, status",
        "from t_sys_notice",
        "where status = 0",
        "order by ctime desc",
        "limit 1"
    })
    @ResultMap("BaseResultMap")
    Notice getNewestNotice();
}