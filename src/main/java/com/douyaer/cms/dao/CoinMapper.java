package com.douyaer.cms.dao;

import java.util.Date;
import java.util.List;

import com.douyaer.cms.entity.CoinEntity;
import com.douyaer.cms.pojo.Coin;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface CoinMapper {
    @Delete({
        "delete from t_user_coin_log",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into t_user_coin_log (id, user_id, ",
        "event, event_id, ",
        "comment, count, ",
        "account_balance, ctime)",
        "values (#{id,jdbcType=INTEGER}, #{userId,jdbcType=INTEGER}, ",
        "#{event,jdbcType=VARCHAR}, #{eventId,jdbcType=VARCHAR}, ",
        "#{comment,jdbcType=VARCHAR}, #{count,jdbcType=DECIMAL}, ",
        "#{accountBalance,jdbcType=DECIMAL}, #{ctime,jdbcType=TIMESTAMP})"
    })
    int insert(Coin record);

    int insertSelective(Coin record);

    @Select({
        "select",
        "id, user_id, event, event_id, comment, count, account_balance, ctime",
        "from t_user_coin_log",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    Coin selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Coin record);

    @Update({
        "update t_user_coin_log",
        "set user_id = #{userId,jdbcType=INTEGER},",
          "event = #{event,jdbcType=VARCHAR},",
          "event_id = #{eventId,jdbcType=VARCHAR},",
          "comment = #{comment,jdbcType=VARCHAR},",
          "count = #{count,jdbcType=DECIMAL},",
          "account_balance = #{accountBalance,jdbcType=DECIMAL},",
          "ctime = #{ctime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Coin record);

    @Select({
        "<script>",
        "select",
        "t1.id, t1.user_id, t1.event, t1.event_id, t1.comment, t1.count, t1.account_balance, t1.ctime,",
        "t2.phone",
        "from t_user_coin_log t1",
        "left join t_user t2 on t2.user_id = t1.user_id",
        "where 1=1",
        "<if test=\"phone != null and phone != ''\" >",
        "and t2.phone like concat('%', #{phone,jdbcType=VARCHAR}, '%')",
        "</if>",
        "<if test='id != null' >",
        "and t1.id = #{id, jdbcType=INTEGER}",
        "</if>",
        "<if test='start != null' >",
        "and t1.ctime &gt;= #{start,jdbcType=TIMESTAMP}",
        "</if>",
        "<if test='end != null' >",
        "and t1.ctime &lt;= #{end,jdbcType=TIMESTAMP}",
        "</if>",
        "order by t1.ctime desc",
        "</script>"
    })
    @ResultMap("CoinEntity")
    List<CoinEntity> list(@Param("phone") String phone,
        @Param("id") Long id,
        @Param("start") Date start,
        @Param("end") Date end);
}