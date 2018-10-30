package com.douyaer.cms.dao;

import java.util.List;

import com.douyaer.cms.entity.CertEntity;
import com.douyaer.cms.pojo.Cert;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface CertMapper {
    @Delete({
        "delete from t_user_cert",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into t_user_cert (id, user_id, ",
        "real_name, identify_no, ",
        "sex, ip, provnce, ",
        "city, address, taobao_account, ",
        "alitm, store_url, ",
        "identify_no_url, ip_screenshot_url, ",
        "taobao_screenshot_url, alipay_screenshot_url, ",
        "create_time, status)",
        "values (#{id,jdbcType=INTEGER}, #{userId,jdbcType=INTEGER}, ",
        "#{realName,jdbcType=VARCHAR}, #{identifyNo,jdbcType=VARCHAR}, ",
        "#{sex,jdbcType=VARCHAR}, #{ip,jdbcType=VARCHAR}, #{provnce,jdbcType=VARCHAR}, ",
        "#{city,jdbcType=VARCHAR}, #{address,jdbcType=VARCHAR}, #{taobaoAccount,jdbcType=VARCHAR}, ",
        "#{alitm,jdbcType=VARCHAR}, #{storeUrl,jdbcType=VARCHAR}, ",
        "#{identifyNoUrl,jdbcType=VARCHAR}, #{ipScreenshotUrl,jdbcType=VARCHAR}, ",
        "#{taobaoScreenshotUrl,jdbcType=VARCHAR}, #{alipayScreenshotUrl,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{status,jdbcType=INTEGER})"
    })
    int insert(Cert record);

    int insertSelective(Cert record);

    @Select({
        "select",
        "id, user_id, real_name, identify_no, sex, ip, provnce, city, address, taobao_account, ",
        "alitm, store_url, identify_no_url, ip_screenshot_url, taobao_screenshot_url, ",
        "alipay_screenshot_url, create_time, status",
        "from t_user_cert",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    Cert selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Cert record);

    @Update({
        "update t_user_cert",
        "set user_id = #{userId,jdbcType=INTEGER},",
          "real_name = #{realName,jdbcType=VARCHAR},",
          "identify_no = #{identifyNo,jdbcType=VARCHAR},",
          "sex = #{sex,jdbcType=VARCHAR},",
          "ip = #{ip,jdbcType=VARCHAR},",
          "provnce = #{provnce,jdbcType=VARCHAR},",
          "city = #{city,jdbcType=VARCHAR},",
          "address = #{address,jdbcType=VARCHAR},",
          "taobao_account = #{taobaoAccount,jdbcType=VARCHAR},",
          "alitm = #{alitm,jdbcType=VARCHAR},",
          "store_url = #{storeUrl,jdbcType=VARCHAR},",
          "identify_no_url = #{identifyNoUrl,jdbcType=VARCHAR},",
          "ip_screenshot_url = #{ipScreenshotUrl,jdbcType=VARCHAR},",
          "taobao_screenshot_url = #{taobaoScreenshotUrl,jdbcType=VARCHAR},",
          "alipay_screenshot_url = #{alipayScreenshotUrl,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "status = #{status,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Cert record);

    @Select({
        "<script>",
        "select",
        "t1.id, t1.user_id, t1.real_name, t1.identify_no, t1.sex, t1.ip, t1.provnce, t1.city, t1.address, t1.taobao_account, ",
        "t1.alitm, t1.store_url, t1.identify_no_url, t1.ip_screenshot_url, t1.taobao_screenshot_url, ",
        "t1.alipay_screenshot_url, t1.create_time, t1.status, t2.phone",
        "from t_user_cert t1",
        "left join t_user t2 on t1.user_id = t2.user_id",
        "where t2.user_role = 'brushhand'",
        "<if test=\"phone != null and phone != ''\" >",
        "and t2.phone like concat('%', #{phone,jdbcType=VARCHAR}, '%')",
        "</if>",
        "order by case when t1.status = 0 then 0 else 1 end asc, t1.create_time desc",
        "</script>"
    })
    @ResultMap("CertEntity")
    List<CertEntity> getBrushhandCertList(@Param("phone") String phone);

    @Select({
        "<script>",
        "select",
        "t1.id, t1.user_id, t1.real_name, t1.identify_no, t1.sex, t1.ip, t1.provnce, t1.city, t1.address, t1.taobao_account, ",
        "t1.alitm, t1.store_url, t1.identify_no_url, t1.ip_screenshot_url, t1.taobao_screenshot_url, ",
        "t1.alipay_screenshot_url, t1.create_time, t1.status, t2.phone",
        "from t_user_cert t1",
        "left join t_user t2 on t1.user_id = t2.user_id",
        "where t2.user_role = 'business'",
        "<if test=\"phone != null and phone != ''\" >",
        "and t2.phone like concat('%', #{phone,jdbcType=VARCHAR}, '%')",
        "</if>",
        "order by case when t1.status = 0 then 0 else 1 end asc, t1.create_time desc",
        "</script>"
    })
    @ResultMap("CertEntity")
    List<CertEntity> getBusinessCertList(@Param("phone") String phone);
}