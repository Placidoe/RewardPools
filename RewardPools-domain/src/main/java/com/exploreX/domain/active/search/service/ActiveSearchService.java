package com.exploreX.domain.active.search.service;

/**
 * TODO
 *
 * @Description
 * @Author 1
 * @Date 2024/11/5 上午12:56
 **/
public interface ActiveSearchService {
    //1.查询单个活动详情
    public void searchActive(String activeId);
    //2.批量查询活动列表
    public void searchActiveList(String activeType);
}
