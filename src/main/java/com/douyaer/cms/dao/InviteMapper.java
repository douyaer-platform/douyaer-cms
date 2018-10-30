package com.douyaer.cms.dao;

import java.util.List;

import com.douyaer.cms.entity.InviteEntity;
import com.douyaer.cms.pojo.Invite;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface InviteMapper {
    @Delete({
        "delete from t_user_invite",
        "where invite_id = #{inviteId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String inviteId);

    @Insert({
        "insert into t_user_invite (invite_id, user_id, ",
        "desc_user_id, status, ",
        "ctime, receive_ctime, ",
        "integral)",
        "values (#{inviteId,jdbcType=VARCHAR}, #{userId,jdbcType=INTEGER}, ",
        "#{descUserId,jdbcType=INTEGER}, #{status,jdbcType=INTEGER}, ",
        "#{ctime,jdbcType=TIMESTAMP}, #{receiveCtime,jdbcType=TIMESTAMP}, ",
        "#{integral,jdbcType=INTEGER})"
    })
    int insert(Invite record);

    int insertSelective(Invite record);

    @Select({
        "select",
        "invite_id, user_id, desc_user_id, status, ctime, receive_ctime, integral",
        "from t_user_invite",
        "where invite_id = #{inviteId,jdbcType=VARCHAR}"
    })
    @ResultMap("BaseResultMap")
    Invite selectByPrimaryKey(String inviteId);

    int updateByPrimaryKeySelective(Invite record);

    @Update({
        "update t_user_invite",
        "set user_id = #{userId,jdbcType=INTEGER},",
          "desc_user_id = #{descUserId,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "ctime = #{ctime,jdbcType=TIMESTAMP},",
          "receive_ctime = #{receiveCtime,jdbcType=TIMESTAMP},",
          "integral = #{integral,jdbcType=INTEGER}",
        "where invite_id = #{inviteId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(Invite record);

    @Select({
        "<script>",
        "select",
        "t1.invite_id, t1.user_id, t1.desc_user_id, t1.status, t1.ctime, t1.receive_ctime, t1.integral, ",
        "t2.real_name, t2.phone, t3.real_name as desc_real_name, t3.phone as desc_phone, t3.taobao_account as desc_taobao_account, ifnull(t4.order_count, 0) as order_count",
        "from t_user_invite t1",
        "left join t_user t2 on t1.user_id = t2.user_id",
        "left join t_user t3 on t1.desc_user_id = t3.user_id",
        "left join (select user_id, count(user_id) as order_count from t_user_order where status = 4 group by user_id) t4 on t4.user_id = t1.desc_user_id",
        "where t1.status=1",
        "<if test=\"phone != null and phone != ''\" >",
        "and t2.phone like concat('%', #{phone,jdbcType=VARCHAR}, '%')",
        "</if>",
        "<if test=\"descPhone != null and descPhone != ''\" >",
        "and t3.phone like concat('%', #{descPhone,jdbcType=VARCHAR}, '%')",
        "</if>",
        "<if test=\"taobaoAccount != null and taobaoAccount != ''\" >",
        "and t3.taobao_account like concat('%', #{taobaoAccount,jdbcType=VARCHAR}, '%')",
        "</if>",
        "order by t1.ctime desc",
        "</script>"
    })
    @ResultMap("InviteEntity")
    List<InviteEntity> list(@Param("phone") String phone,
        @Param("descPhone") String descPhone,
        @Param("taobaoAccount") String taobaoAccount);
}