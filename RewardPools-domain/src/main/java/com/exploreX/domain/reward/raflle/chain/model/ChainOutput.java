package com.exploreX.domain.reward.raflle.chain.model;

import lombok.Data;

import java.util.HashMap;

/**
 * TODO
 *
 * @Description
 * @Author Lx
 * @Date 2024/11/17 下午2:00
 **/
@Data
public class ChainOutput {
    HashMap<String,Object> params;
    int status;
}
