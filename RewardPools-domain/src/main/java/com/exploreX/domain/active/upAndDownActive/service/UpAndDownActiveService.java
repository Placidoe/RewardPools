package com.exploreX.domain.active.upAndDownActive.service;

import org.springframework.stereotype.Service;

/**
 * TODO
 *
 * @Description
 * @Author Lx
 * @Date 2024/11/5 上午12:54
 **/
public interface UpAndDownActiveService {

    public void upActive(String activeId,String value);
    public void downActive(String activeId);
}
