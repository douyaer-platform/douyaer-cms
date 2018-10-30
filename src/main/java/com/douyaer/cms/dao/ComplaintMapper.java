package com.douyaer.cms.dao;

import java.util.List;

import com.douyaer.cms.entity.ComplaintEntity;
import com.douyaer.cms.pojo.Complaint;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface ComplaintMapper {
    @Delete({
        "delete from t_user_order_complaint",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into t_user_order_complaint (id, order_id, ",
        "complaint_user_id, remark, ",
        "status, ctime)",
        "values (#{id,jdbcType=INTEGER}, #{orderId,jdbcType=INTEGER}, ",
        "#{complaintUserId,jdbcType=INTEGER}, #{remark,jdbcType=VARCHAR}, ",
        "#{status,jdbcType=INTEGER}, #{ctime,jdbcType=TIMESTAMP})"
    })
    int insert(Complaint record);

    int insertSelective(Complaint record);

    @Select({
        "select",
        "id, order_id, complaint_user_id, remark, status, ctime",
        "from t_user_order_complaint",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    Complaint selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Complaint record);

    @Update({
        "update t_user_order_complaint",
        "set order_id = #{orderId,jdbcType=INTEGER},",
        "complaint_user_id = #{complaintUserId,jdbcType=INTEGER},",
        "remark = #{remark,jdbcType=VARCHAR},",
        "status = #{status,jdbcType=INTEGER},",
        "ctime = #{ctime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Complaint record);

    @Select({
        "<script>",
        "select",
        "t1.id, t1.order_id, t1.complaint_user_id, t1.remark, t1.status, t1.ctime,",
        "t2.phone",
        "from t_user_order_complaint t1",
        "left join t_user t2 on t1.complaint_user_id = t2.user_id",
        "<if test=\"phone != null and phone != ''\" >",
        "where t2.phone like concat('%', #{phone,jdbcType=VARCHAR}, '%')",
        "</if>",
        "order by case when t1.status = 0 then 0 else 1 end asc, t1.ctime desc",
        "</script>"
    })
    @ResultMap("ComplaintEntity")
    List<ComplaintEntity> list(@Param("phone") String phone);
}