package com.douyaer.cms.dao;

import java.util.Date;
import java.util.List;

import com.douyaer.cms.entity.DepositEntity;
import com.douyaer.cms.entity.WithdrawEntity;
import com.douyaer.cms.pojo.DepositWithdraw;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface DepositWithdrawMapper {
    @Delete({
        "delete from t_user_deposit_withdraw_apply",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into t_user_deposit_withdraw_apply (id, user_id, ",
        "exchange_type, total_fee, ",
        "wechat_name, remark, ",
        "ctime, status)",
        "values (#{id,jdbcType=INTEGER}, #{userId,jdbcType=INTEGER}, ",
        "#{exchangeType,jdbcType=VARCHAR}, #{totalFee,jdbcType=DECIMAL}, ",
        "#{wechatName,jdbcType=VARCHAR}, #{remark,jdbcType=VARCHAR}, ",
        "#{ctime,jdbcType=TIMESTAMP}, #{status,jdbcType=INTEGER})"
    })
    int insert(DepositWithdraw record);

    int insertSelective(DepositWithdraw record);

    @Select({
        "select",
        "id, user_id, exchange_type, total_fee, wechat_name, remark, ctime, status",
        "from t_user_deposit_withdraw_apply",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    DepositWithdraw selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DepositWithdraw record);

    @Update({
        "update t_user_deposit_withdraw_apply",
        "set user_id = #{userId,jdbcType=INTEGER},",
          "exchange_type = #{exchangeType,jdbcType=VARCHAR},",
          "total_fee = #{totalFee,jdbcType=DECIMAL},",
          "wechat_name = #{wechatName,jdbcType=VARCHAR},",
          "remark = #{remark,jdbcType=VARCHAR},",
          "ctime = #{ctime,jdbcType=TIMESTAMP},",
          "status = #{status,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(DepositWithdraw record);

    @Select({
        "<script>",
        "select",
        "t1.id, t1.user_id, t1.exchange_type, t1.total_fee, t1.wechat_name, t1.remark, t1.ctime, t1.status,",
        "t2.real_name, t2.phone",
        "from t_user_deposit_withdraw_apply t1",
        "left join t_user t2 on t1.user_id = t2.user_id",
        "where t1.exchange_type = 'deposit'",
        "<if test=\"phone != null and phone != ''\" >",
        "and t2.phone like concat('%', #{phone,jdbcType=VARCHAR}, '%')",
        "</if>",
        "<if test='start != null' >",
        "and t1.ctime &gt;= #{start,jdbcType=TIMESTAMP}",
        "</if>",
        "<if test='end != null' >",
        "and t1.ctime &lt;= #{end,jdbcType=TIMESTAMP}",
        "</if>",
        "order by case when t1.status = 0 then 0 else 1 end asc, t1.ctime desc",
        "</script>"
    })
    @ResultMap("DepositEntity")
    List<DepositEntity> getDepositList(@Param("phone") String phone,
        @Param("start") Date start,
        @Param("end") Date end);

    @Select({
        "<script>",
        "select",
        "t1.id, t1.user_id, t1.exchange_type, t1.total_fee, t1.wechat_name, t1.remark, t1.ctime, t1.status,",
        "t2.real_name, t2.phone",
        "from t_user_deposit_withdraw_apply t1",
        "left join t_user t2 on t1.user_id = t2.user_id",
        "where t1.exchange_type = 'withdraw'",
        "<if test=\"phone != null and phone != ''\" >",
        "and t2.phone like concat('%', #{phone,jdbcType=VARCHAR}, '%')",
        "</if>",
        "<if test='start != null' >",
        "and t1.ctime &gt;= #{start,jdbcType=TIMESTAMP}",
        "</if>",
        "<if test='end != null' >",
        "and t1.ctime &lt;= #{end,jdbcType=TIMESTAMP}",
        "</if>",
        "order by case when t1.status = 0 then 0 else 1 end asc, t1.ctime desc",
        "</script>"
    })
    @ResultMap("WithdrawEntity")
    List<WithdrawEntity> getWithdrawList(@Param("phone") String phone,
        @Param("start") Date start,
        @Param("end") Date end);
}