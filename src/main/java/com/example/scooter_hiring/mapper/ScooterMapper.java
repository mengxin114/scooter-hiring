package com.example.scooter_hiring.mapper;

import com.example.scooter_hiring.bean.Scooter;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface ScooterMapper {

    @Select("select * from scooter where id = #{id}")
    Scooter getScooterById(@Param("id") Long id);

    @Update("update scooter set status = #{status} where id = #{id}")
    int updateScooterStatus(@Param("id") Long id, @Param("status") String status);
}