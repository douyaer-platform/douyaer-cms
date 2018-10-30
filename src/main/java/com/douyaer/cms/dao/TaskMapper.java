package com.douyaer.cms.dao;

import java.util.List;

import com.douyaer.cms.entity.TaskEntity;
import com.douyaer.cms.pojo.Task;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface TaskMapper {
    @Delete({
        "delete from t_user_task",
        "where task_id = #{taskId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String taskId);

    @Insert({
        "insert into t_user_task (task_id, user_id, ",
        "brushhand_sex, provinces, ",
        "start_time, end_time, ",
        "order_count, cost_total_coin, ",
        "order_price, commission, ",
        "finish_scalping_count, remark, ",
        "store_name, goods_url, ",
        "goods_pic_url, search_pic_url, ",
        "condition_pic_url, goods_price, ",
        "tags, buy_back_type, ",
        "need_alitm, create_time, ",
        "status, refund_coin, ",
        "refund_time)",
        "values (#{taskId,jdbcType=VARCHAR}, #{userId,jdbcType=INTEGER}, ",
        "#{brushhandSex,jdbcType=VARCHAR}, #{provinces,jdbcType=VARCHAR}, ",
        "#{startTime,jdbcType=TIMESTAMP}, #{endTime,jdbcType=TIMESTAMP}, ",
        "#{orderCount,jdbcType=INTEGER}, #{costTotalCoin,jdbcType=DECIMAL}, ",
        "#{orderPrice,jdbcType=DECIMAL}, #{commission,jdbcType=INTEGER}, ",
        "#{finishScalpingCount,jdbcType=INTEGER}, #{remark,jdbcType=VARCHAR}, ",
        "#{storeName,jdbcType=VARCHAR}, #{goodsUrl,jdbcType=VARCHAR}, ",
        "#{goodsPicUrl,jdbcType=VARCHAR}, #{searchPicUrl,jdbcType=VARCHAR}, ",
        "#{conditionPicUrl,jdbcType=VARCHAR}, #{goodsPrice,jdbcType=DECIMAL}, ",
        "#{tags,jdbcType=VARCHAR}, #{buyBackType,jdbcType=SMALLINT}, ",
        "#{needAlitm,jdbcType=SMALLINT}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{status,jdbcType=INTEGER}, #{refundCoin,jdbcType=DECIMAL}, ",
        "#{refundTime,jdbcType=TIMESTAMP})"
    })
    int insert(Task record);

    int insertSelective(Task record);

    @Select({
        "select",
        "task_id, user_id, brushhand_sex, provinces, start_time, end_time, order_count, ",
        "cost_total_coin, order_price, commission, finish_scalping_count, remark, store_name, ",
        "goods_url, goods_pic_url, search_pic_url, condition_pic_url, goods_price, tags, ",
        "buy_back_type, need_alitm, create_time, status, refund_coin, refund_time",
        "from t_user_task",
        "where task_id = #{taskId,jdbcType=VARCHAR}"
    })
    @ResultMap("BaseResultMap")
    Task selectByPrimaryKey(String taskId);

    int updateByPrimaryKeySelective(Task record);

    @Update({
        "update t_user_task",
        "set user_id = #{userId,jdbcType=INTEGER},",
          "brushhand_sex = #{brushhandSex,jdbcType=VARCHAR},",
          "provinces = #{provinces,jdbcType=VARCHAR},",
          "start_time = #{startTime,jdbcType=TIMESTAMP},",
          "end_time = #{endTime,jdbcType=TIMESTAMP},",
          "order_count = #{orderCount,jdbcType=INTEGER},",
          "cost_total_coin = #{costTotalCoin,jdbcType=DECIMAL},",
          "order_price = #{orderPrice,jdbcType=DECIMAL},",
          "commission = #{commission,jdbcType=INTEGER},",
          "finish_scalping_count = #{finishScalpingCount,jdbcType=INTEGER},",
          "remark = #{remark,jdbcType=VARCHAR},",
          "store_name = #{storeName,jdbcType=VARCHAR},",
          "goods_url = #{goodsUrl,jdbcType=VARCHAR},",
          "goods_pic_url = #{goodsPicUrl,jdbcType=VARCHAR},",
          "search_pic_url = #{searchPicUrl,jdbcType=VARCHAR},",
          "condition_pic_url = #{conditionPicUrl,jdbcType=VARCHAR},",
          "goods_price = #{goodsPrice,jdbcType=DECIMAL},",
          "tags = #{tags,jdbcType=VARCHAR},",
          "buy_back_type = #{buyBackType,jdbcType=SMALLINT},",
          "need_alitm = #{needAlitm,jdbcType=SMALLINT},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "status = #{status,jdbcType=INTEGER},",
          "refund_coin = #{refundCoin,jdbcType=DECIMAL},",
          "refund_time = #{refundTime,jdbcType=TIMESTAMP}",
        "where task_id = #{taskId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(Task record);

    @Select({
        "<script>",
        "select",
        "t1.task_id, t1.user_id, t1.brushhand_sex, t1.provinces, t1.start_time, t1.end_time, t1.order_count, ",
        "t1.cost_total_coin, t1.order_price, t1.commission, t1.finish_scalping_count, t1.remark, t1.store_name, ",
        "t1.goods_url, t1.goods_pic_url, t1.search_pic_url, t1.condition_pic_url, t1.goods_price, t1.tags, ",
        "t1.buy_back_type, t1.need_alitm, t1.create_time, t1.status, t1.refund_coin, t1.refund_time,",
        "t2.phone, t2.taobao_account",
        "from t_user_task t1",
        "left join t_user t2 on t1.user_id = t2.user_id",
        "where 1=1",
        "<if test=\"phone != null and phone != ''\">",
        "and t2.phone like concat('%', #{phone,jdbcType=VARCHAR}, '%')",
        "</if>",
        "<if test=\"taobaoAccount != null and taobaoAccount != ''\">",
        "and t2.taobao_account like concat('%', #{taobaoAccount,jdbcType=VARCHAR}, '%')",
        "</if>",
        "order by case when t1.status = 0 then 0 else 1 end asc, t1.create_time desc",
        "</script>"
    })
    @ResultMap("TaskEntity")
    List<TaskEntity> list(@Param("phone") String phone,
        @Param("taobaoAccount") String taobaoAccount);
}