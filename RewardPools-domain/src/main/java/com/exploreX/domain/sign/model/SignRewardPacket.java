package com.exploreX.domain.sign.model;

/**
 * TODO
 *
 * @Description
 * @Author Lx
 * @Date 2024/11/5 上午12:52
 **/
public class SignRewardPacket<T> {
    private String userId;
    private String rewardPacketId;
    private String rewardPacketName;
    private String rewardPacketAmount;
    private String rewardPacketType;
    private String rewardPacketStatus;
    private T rewardPacketData;
}
