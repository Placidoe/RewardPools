package com.exploreX.domain.chat.model;

import lombok.Data;

/**
 * TODO
 *
 * @Description
 * @Author Lx
 * @Date 2024/11/3 下午2:32
 **/
@Data
public class TransData extends BaseData {
    //1.文本消息
    MessageData message;
    //2.碎片交换消息
    PieceExchangeData pieceExchangeData;
    //3.许愿消息
    WishData wishData;
    //4.消息类型
    int flag;//1-文本消息 2-碎片交换消息 3-许愿消息
}
