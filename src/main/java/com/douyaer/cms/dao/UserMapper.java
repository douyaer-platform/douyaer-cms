package com.douyaer.cms.dao;

import java.util.Date;
import java.util.List;

import com.douyaer.cms.entity.BrushhandEntity;
import com.douyaer.cms.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UserMapper {
    @Delete({
        "delete from t_user",
        "where user_id = #{userId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Long userId);

    @Insert({
        "insert into t_user (user_id, user_role, ",
        "phone, password, ",
        "real_name, avatar, ",
        "sex, identify_no, ",
        "coin, freeze_coin, ",
        "integral, taobao_account, ",
        "ip, address, alitm, ",
        "store_url, inviter_user_id, ",
        "create_time, update_time, ",
        "status, identify_no_url)",
        "values (#{userId,jdbcType=INTEGER}, #{userRole,jdbcType=VARCHAR}, ",
        "#{phone,jdbcType=VARCHAR}, #{password,jdbcType=VARCHAR}, ",
        "#{realName,jdbcType=VARCHAR}, #{avatar,jdbcType=VARCHAR}, ",
        "#{sex,jdbcType=VARCHAR}, #{identifyNo,jdbcType=VARCHAR}, ",
        "#{coin,jdbcType=DECIMAL}, #{freezeCoin,jdbcType=DECIMAL}, ",
        "#{integral,jdbcType=INTEGER}, #{taobaoAccount,jdbcType=VARCHAR}, ",
        "#{ip,jdbcType=VARCHAR}, #{address,jdbcType=VARCHAR}, #{alitm,jdbcType=VARCHAR}, ",
        "#{storeUrl,jdbcType=VARCHAR}, #{inviterUserId,jdbcType=INTEGER}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{status,jdbcType=INTEGER}, #{identifyNoUrl,jdbcType=VARCHAR})"
    })
    int insert(User record);

    int insertSelective(User record);

    @Select({
        "select",
        "user_id, user_role, phone, password, real_name, avatar, sex, identify_no, coin, ",
        "freeze_coin, integral, taobao_account, ip, address, alitm, store_url, inviter_user_id, ",
        "create_time, update_time, status, identify_no_url",
        "from t_user",
        "where user_id = #{userId,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    User selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(User record);

    @Update({
        "update t_user",
        "set user_role = #{userRole,jdbcType=VARCHAR},",
          "phone = #{phone,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "real_name = #{realName,jdbcType=VARCHAR},",
          "avatar = #{avatar,jdbcType=VARCHAR},",
          "sex = #{sex,jdbcType=VARCHAR},",
          "identify_no = #{identifyNo,jdbcType=VARCHAR},",
          "coin = #{coin,jdbcType=DECIMAL},",
          "freeze_coin = #{freezeCoin,jdbcType=DECIMAL},",
          "integral = #{integral,jdbcType=INTEGER},",
          "taobao_account = #{taobaoAccount,jdbcType=VARCHAR},",
          "ip = #{ip,jdbcType=VARCHAR},",
          "address = #{address,jdbcType=VARCHAR},",
          "alitm = #{alitm,jdbcType=VARCHAR},",
          "store_url = #{storeUrl,jdbcType=VARCHAR},",
          "inviter_user_id = #{inviterUserId,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "status = #{status,jdbcType=INTEGER},",
          "identify_no_url = #{identifyNoUrl,jdbcType=VARCHAR}",
        "where user_id = #{userId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(User record);

    @Select({
        "select",
        "user_id, user_role, phone, password, real_name, avatar, sex, identify_no, coin, ",
        "freeze_coin, integral, taobao_account, ip, address, alitm, store_url, inviter_user_id, ",
        "create_time, update_time, status, identify_no_url",
        "from t_user",
        "where phone = #{phone,jdbcType=VARCHAR}"
    })
    @ResultMap("BaseResultMap")
    User getUserByPhone(String phone);

    @Select({
        "<script>",
        "select",
        "t1.user_id, t1.user_role, t1.phone, t1.password, t1.real_name, t1.avatar, t1.sex, t1.identify_no, t1.coin, ",
        "t1.freeze_coin, t1.integral, t1.taobao_account, t1.ip, t1.address, t1.alitm, t1.store_url, t1.inviter_user_id, ",
        "t1.create_time, t1.update_time, t1.status, t1.identify_no_url, t2.real_name as invite_real_name",
        "from t_user t1",
        "left join t_user t2 on t1.inviter_user_id = t2.user_id", 
        "where t1.user_role = 'brushhand'",
        "<if test=\"phone != null and phone != ''\" >",
        "and t1.phone like concat('%', #{phone,jdbcType=VARCHAR}, '%')",
        "</if>",
        "<if test=\"taobaoAccount != null and taobaoAccount != ''\" >",
        "and t1.taobao_account like concat('%', #{taobaoAccount,jdbcType=VARCHAR}, '%')",
        "</if>",
        "<if test='start != null' >",
        "and t1.create_time &gt;= #{start,jdbcType=TIMESTAMP}",
        "</if>",
        "<if test='end != null' >",
        "and t1.create_time &lt;= #{end,jdbcType=TIMESTAMP}",
        "</if>",
        "order by t1.create_time desc",
        "</script>"
    })
    @ResultMap("BrushhandEntity")
    List<BrushhandEntity> getBrushhandList(@Param("phone") String phone,
        @Param("taobaoAccount") String taobaoAccount,
        @Param("start") Date start,
        @Param("end") Date end);

    @Select({
        "<script>",
        "select",
        "user_id, user_role, phone, password, real_name, avatar, sex, identify_no, coin, ",
        "freeze_coin, integral, taobao_account, ip, address, alitm, store_url, inviter_user_id, ",
        "create_time, update_time, status, identify_no_url",
        "from t_user",
        "where user_role = 'business'",
        "<if test=\"phone != null and phone != ''\" >",
        "and phone like concat('%', #{phone,jdbcType=VARCHAR}, '%')",
        "</if>",
        "<if test=\"alitm != null and alitm != ''\" >",
        "and alitm like concat('%', #{alitm,jdbcType=VARCHAR}, '%')",
        "</if>",
        "<if test='start != null' >",
        "and create_time &gt;= #{start,jdbcType=TIMESTAMP}",
        "</if>",
        "<if test='end != null' >",
        "and create_time &lt;= #{end,jdbcType=TIMESTAMP}",
        "</if>",
        "order by create_time desc",
        "</script>"
    })
    @ResultMap("BaseResultMap")
    List<User> getBusinessList(@Param("phone") String phone,
        @Param("alitm") String alitm,
        @Param("start") Date start,
        @Param("end") Date end);

}