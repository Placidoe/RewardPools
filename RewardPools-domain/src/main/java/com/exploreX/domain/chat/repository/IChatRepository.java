package com.exploreX.domain.chat.repository;

import com.exploreX.domain.chat.model.PieceExchangeData;

/**
 * TODO
 *
 * @Description
 * @Author 1
 * @Date 2024/11/3 下午4:43
 **/
public interface IChatRepository {

    public void savePieceExchangeData(PieceExchangeData pieceExchangeData, long exchangeId);

    public PieceExchangeData getPieceExchangeDataByid(String exchangeid);
}
