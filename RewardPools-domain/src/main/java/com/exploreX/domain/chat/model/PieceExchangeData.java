package com.exploreX.domain.chat.model;

import lombok.Data;

/**
 * TODO
 *
 * @Description
 * @Author Lx
 * @Date 2024/11/3 下午2:37
 **/
@Data
public class PieceExchangeData {
    //交换的碎片
    PieceData pieceData;
    //提出交换的用户id
    String userId;
    //交换的请求url
    String url;
    //交换id
    String exchangeId;
}
