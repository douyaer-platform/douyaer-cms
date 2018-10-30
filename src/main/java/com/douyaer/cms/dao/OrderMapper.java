package com.douyaer.cms.dao;

import java.util.Date;
import java.util.List;

import com.douyaer.cms.entity.OrderEntity;
import com.douyaer.cms.pojo.Order;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface OrderMapper {
    @Delete({
        "delete from t_user_order",
        "where order_id = #{orderId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Long orderId);

    @Insert({
        "insert into t_user_order (order_id, task_id, ",
        "user_id, ip_screenshot_url, ",
        "search_pic_url, compare_pic_url1, ",
        "compare_pic_url2, compare_pic_url3, ",
        "enter_store_url, view_remark_url, ",
        "view_buyershow_url, detail_page_url, ",
        "detail_page_bottom_url, home_page_url, ",
        "view_all_goods_url, view_other_goods_url, ",
        "chat_url, buy_goods_url, ",
        "finish_order_url, favorite_attention_url, ",
        "favorite_attention_entershop_url, groupon_detail_url, ",
        "finish_remark_url, brushhand_remark_des, ",
        "business_remark_des, buyershow_url1, ",
        "buyershow_url2, buyershow_url3, ",
        "back_buy_img1, back_buy_img2, ",
        "back_buy_img3, back_buy_img4, ",
        "back_buy_img5, create_time, ",
        "update_time, submit_order_time, ",
        "business_remark_time, brushhand_remark_time, ",
        "send_money_time, auto_sendmoney_time, ",
        "status)",
        "values (#{orderId,jdbcType=INTEGER}, #{taskId,jdbcType=VARCHAR}, ",
        "#{userId,jdbcType=INTEGER}, #{ipScreenshotUrl,jdbcType=VARCHAR}, ",
        "#{searchPicUrl,jdbcType=VARCHAR}, #{comparePicUrl1,jdbcType=VARCHAR}, ",
        "#{comparePicUrl2,jdbcType=VARCHAR}, #{comparePicUrl3,jdbcType=VARCHAR}, ",
        "#{enterStoreUrl,jdbcType=VARCHAR}, #{viewRemarkUrl,jdbcType=VARCHAR}, ",
        "#{viewBuyershowUrl,jdbcType=VARCHAR}, #{detailPageUrl,jdbcType=VARCHAR}, ",
        "#{detailPageBottomUrl,jdbcType=VARCHAR}, #{homePageUrl,jdbcType=VARCHAR}, ",
        "#{viewAllGoodsUrl,jdbcType=VARCHAR}, #{viewOtherGoodsUrl,jdbcType=VARCHAR}, ",
        "#{chatUrl,jdbcType=VARCHAR}, #{buyGoodsUrl,jdbcType=VARCHAR}, ",
        "#{finishOrderUrl,jdbcType=VARCHAR}, #{favoriteAttentionUrl,jdbcType=VARCHAR}, ",
        "#{favoriteAttentionEntershopUrl,jdbcType=VARCHAR}, #{grouponDetailUrl,jdbcType=VARCHAR}, ",
        "#{finishRemarkUrl,jdbcType=VARCHAR}, #{brushhandRemarkDes,jdbcType=VARCHAR}, ",
        "#{businessRemarkDes,jdbcType=VARCHAR}, #{buyershowUrl1,jdbcType=VARCHAR}, ",
        "#{buyershowUrl2,jdbcType=VARCHAR}, #{buyershowUrl3,jdbcType=VARCHAR}, ",
        "#{backBuyImg1,jdbcType=VARCHAR}, #{backBuyImg2,jdbcType=VARCHAR}, ",
        "#{backBuyImg3,jdbcType=VARCHAR}, #{backBuyImg4,jdbcType=VARCHAR}, ",
        "#{backBuyImg5,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{submitOrderTime,jdbcType=TIMESTAMP}, ",
        "#{businessRemarkTime,jdbcType=TIMESTAMP}, #{brushhandRemarkTime,jdbcType=TIMESTAMP}, ",
        "#{sendMoneyTime,jdbcType=TIMESTAMP}, #{autoSendmoneyTime,jdbcType=TIMESTAMP}, ",
        "#{status,jdbcType=INTEGER})"
    })
    int insert(Order record);

    int insertSelective(Order record);

    @Select({
        "select",
        "order_id, task_id, user_id, ip_screenshot_url, search_pic_url, compare_pic_url1, ",
        "compare_pic_url2, compare_pic_url3, enter_store_url, view_remark_url, view_buyershow_url, ",
        "detail_page_url, detail_page_bottom_url, home_page_url, view_all_goods_url, ",
        "view_other_goods_url, chat_url, buy_goods_url, finish_order_url, favorite_attention_url, ",
        "favorite_attention_entershop_url, groupon_detail_url, finish_remark_url, brushhand_remark_des, ",
        "business_remark_des, buyershow_url1, buyershow_url2, buyershow_url3, back_buy_img1, ",
        "back_buy_img2, back_buy_img3, back_buy_img4, back_buy_img5, create_time, update_time, ",
        "submit_order_time, business_remark_time, brushhand_remark_time, send_money_time, ",
        "auto_sendmoney_time, status",
        "from t_user_order",
        "where order_id = #{orderId,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    Order selectByPrimaryKey(Long orderId);

    int updateByPrimaryKeySelective(Order record);

    @Update({
        "update t_user_order",
        "set task_id = #{taskId,jdbcType=VARCHAR},",
          "user_id = #{userId,jdbcType=INTEGER},",
          "ip_screenshot_url = #{ipScreenshotUrl,jdbcType=VARCHAR},",
          "search_pic_url = #{searchPicUrl,jdbcType=VARCHAR},",
          "compare_pic_url1 = #{comparePicUrl1,jdbcType=VARCHAR},",
          "compare_pic_url2 = #{comparePicUrl2,jdbcType=VARCHAR},",
          "compare_pic_url3 = #{comparePicUrl3,jdbcType=VARCHAR},",
          "enter_store_url = #{enterStoreUrl,jdbcType=VARCHAR},",
          "view_remark_url = #{viewRemarkUrl,jdbcType=VARCHAR},",
          "view_buyershow_url = #{viewBuyershowUrl,jdbcType=VARCHAR},",
          "detail_page_url = #{detailPageUrl,jdbcType=VARCHAR},",
          "detail_page_bottom_url = #{detailPageBottomUrl,jdbcType=VARCHAR},",
          "home_page_url = #{homePageUrl,jdbcType=VARCHAR},",
          "view_all_goods_url = #{viewAllGoodsUrl,jdbcType=VARCHAR},",
          "view_other_goods_url = #{viewOtherGoodsUrl,jdbcType=VARCHAR},",
          "chat_url = #{chatUrl,jdbcType=VARCHAR},",
          "buy_goods_url = #{buyGoodsUrl,jdbcType=VARCHAR},",
          "finish_order_url = #{finishOrderUrl,jdbcType=VARCHAR},",
          "favorite_attention_url = #{favoriteAttentionUrl,jdbcType=VARCHAR},",
          "favorite_attention_entershop_url = #{favoriteAttentionEntershopUrl,jdbcType=VARCHAR},",
          "groupon_detail_url = #{grouponDetailUrl,jdbcType=VARCHAR},",
          "finish_remark_url = #{finishRemarkUrl,jdbcType=VARCHAR},",
          "brushhand_remark_des = #{brushhandRemarkDes,jdbcType=VARCHAR},",
          "business_remark_des = #{businessRemarkDes,jdbcType=VARCHAR},",
          "buyershow_url1 = #{buyershowUrl1,jdbcType=VARCHAR},",
          "buyershow_url2 = #{buyershowUrl2,jdbcType=VARCHAR},",
          "buyershow_url3 = #{buyershowUrl3,jdbcType=VARCHAR},",
          "back_buy_img1 = #{backBuyImg1,jdbcType=VARCHAR},",
          "back_buy_img2 = #{backBuyImg2,jdbcType=VARCHAR},",
          "back_buy_img3 = #{backBuyImg3,jdbcType=VARCHAR},",
          "back_buy_img4 = #{backBuyImg4,jdbcType=VARCHAR},",
          "back_buy_img5 = #{backBuyImg5,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "submit_order_time = #{submitOrderTime,jdbcType=TIMESTAMP},",
          "business_remark_time = #{businessRemarkTime,jdbcType=TIMESTAMP},",
          "brushhand_remark_time = #{brushhandRemarkTime,jdbcType=TIMESTAMP},",
          "send_money_time = #{sendMoneyTime,jdbcType=TIMESTAMP},",
          "auto_sendmoney_time = #{autoSendmoneyTime,jdbcType=TIMESTAMP},",
          "status = #{status,jdbcType=INTEGER}",
        "where order_id = #{orderId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Order record);

    @Select({
        "<script>",
        "select",
        "t1.order_id, t1.task_id, t1.user_id, t1.ip_screenshot_url, t1.search_pic_url, t1.compare_pic_url1, ",
        "t1.compare_pic_url2, t1.compare_pic_url3, t1.enter_store_url, t1.view_remark_url, t1.view_buyershow_url, ",
        "t1.detail_page_url, t1.detail_page_bottom_url, t1.home_page_url, t1.view_all_goods_url, ",
        "t1.view_other_goods_url, t1.chat_url, t1.buy_goods_url, t1.finish_order_url, t1.favorite_attention_url, ",
        "t1.favorite_attention_entershop_url, t1.groupon_detail_url, t1.finish_remark_url, t1.brushhand_remark_des, ",
        "t1.business_remark_des, t1.buyershow_url1, t1.buyershow_url2, t1.buyershow_url3, t1.back_buy_img1, ",
        "t1.back_buy_img2, t1.back_buy_img3, t1.back_buy_img4, t1.back_buy_img5, t1.create_time, t1.update_time, ",
        "t1.submit_order_time, t1.business_remark_time, t1.brushhand_remark_time, t1.send_money_time, ",
        "t1.auto_sendmoney_time, t1.status, ",
        "t2.store_name, t2.goods_url, t2.goods_pic_url, t2.search_pic_url as task_search_pic_url, t2.condition_pic_url, t2.order_price, t2.goods_price, t2.commission, t2.tags, t2.buy_back_type, t2.need_alitm,",
        "t3.phone, t3.taobao_account, t4.user_id as bus_user_id, t4.phone as bus_phone, t4.taobao_account as bus_taobao_account",
        "from t_user_order t1",
        "left join t_user_task t2 on t2.task_id = t1.task_id",
        "left join t_user t3 on t3.user_id = t1.user_id",
        "left join t_user t4 on t4.user_id = t2.user_id",
        "where 1=1",
        "<if test=\"phone != null and phone != ''\" >",
        "and t3.phone like concat('%', #{phone,jdbcType=VARCHAR}, '%')",
        "</if>",
        "<if test=\"busPhone != null and busPhone != ''\" >",
        "and t4.phone like concat('%', #{busPhone,jdbcType=VARCHAR}, '%')",
        "</if>",
        "<if test='orderId != null' >",
        "and t1.order_id = #{orderId,jdbcType=INTEGER}",
        "</if>",
        "<if test='status != null' >",
        "and t1.status = #{status,jdbcType=INTEGER}",
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
    @ResultMap("OrderEntity")
    List<OrderEntity> list(@Param("phone") String phone,
        @Param("busPhone") String busPhone,
        @Param("orderId") Long orderId, 
        @Param("status") Integer status,
        @Param("start") Date start,
        @Param("end") Date end);

}