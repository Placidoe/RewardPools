package com.exploreX.domain.user.model;

import lombok.Data;

/**
 * TODO
 *
 * @Description
 * @Author Lx
 * @Date 2024/11/3 下午3:18
 **/
@Data
public class UserInfo {
    private String userId;
    private String userName;
    private String userAvatar;
    private String userSignature;
    private String userAddress;
    private String userPhone;
    private String userEmail;
    private String userSex;
    private String userBirthday;
    private String userStatus;
    private String userCreateTime;
    private String userUpdateTime;
    private String signId;
}
