package com.exploreX.infrastructure.persistent.dao;


import com.exploreX.infrastructure.persistent.po.Festival;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author 1
* @description 针对表【festival】的数据库操作Mapper
* @createDate 2024-11-13 09:44:13
* @Entity src/main/java/com/exploreX/gen.domain.Festival
*/
@Mapper
public interface FestivalDAO extends BaseMapper<Festival> {

    List<Festival> selectBatchByFestivalIds(List<String> festivalIds);
}




