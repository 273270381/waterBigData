package com.suchness.floodcontrol.earlywarning.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface RainLevelMapper {
    Integer insertMonth(String statement);

    Integer delete(String statement);

    Integer updateMonth(String statement);

    List<Map<String, Object>> selectList(String statement);

    String selectOne(String statement);
}
