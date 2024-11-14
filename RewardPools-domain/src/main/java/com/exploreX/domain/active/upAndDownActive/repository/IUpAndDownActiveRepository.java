package com.exploreX.domain.active.upAndDownActive.repository;


import java.util.List;

public interface IUpAndDownActiveRepository {

    List<String> getFestivalIdsByDays(Long daysSinceStartOfYear);

    void WarmUpFestivalByIds(List<String> festivalIds);

    void asyncCopyTableData(String tableName);

}
