package com.exploreX.domain.chat.model;

import com.exploreX.domain.user.model.UserVO;

/**
 * TODO
 *
 * @Description
 * @Author Lx
 * @Date 2024/11/3 下午3:06
 **/
@lombok.Data
public class BaseData {
    private String from;
    private String to;
    private UserVO userVO;
}
