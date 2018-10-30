package com.douyaer.cms.dao;

import com.douyaer.cms.pojo.SysDic;
import com.douyaer.cms.pojo.SysDicKey;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface SysDicMapper {
    @Delete({
        "delete from t_sys_dic",
        "where dic_type = #{dicType,jdbcType=VARCHAR}",
          "and dic_key = #{dicKey,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(SysDicKey key);

    @Insert({
        "insert into t_sys_dic (dic_type, dic_key, ",
        "dic_value, order_num)",
        "values (#{dicType,jdbcType=VARCHAR}, #{dicKey,jdbcType=VARCHAR}, ",
        "#{dicValue,jdbcType=VARCHAR}, #{orderNum,jdbcType=INTEGER})"
    })
    int insert(SysDic record);

    int insertSelective(SysDic record);

    @Select({
        "select",
        "dic_type, dic_key, dic_value, order_num",
        "from t_sys_dic",
        "where dic_type = #{dicType,jdbcType=VARCHAR}",
          "and dic_key = #{dicKey,jdbcType=VARCHAR}"
    })
    @ResultMap("BaseResultMap")
    SysDic selectByPrimaryKey(SysDicKey key);

    int updateByPrimaryKeySelective(SysDic record);

    @Update({
        "update t_sys_dic",
        "set dic_value = #{dicValue,jdbcType=VARCHAR},",
          "order_num = #{orderNum,jdbcType=INTEGER}",
        "where dic_type = #{dicType,jdbcType=VARCHAR}",
          "and dic_key = #{dicKey,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(SysDic record);
}