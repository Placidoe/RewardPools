package com.exploreX.infrastructure.persistent.repository;

import com.exploreX.domain.chat.model.PieceExchangeData;
import com.exploreX.domain.chat.repository.IChatRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * TODO
 *
 * @Description
 * @Author Lx
 * @Date 2024/11/3 下午4:39
 **/
@Component
public class DemoRepository implements IChatRepository {



    public void test() {
        System.out.println("test");
    }

    @Override
    public void savePieceExchangeData(PieceExchangeData pieceExchangeData, long exchangeId) {

    }

    @Override
    public PieceExchangeData getPieceExchangeDataByid(String exchangeid) {
        return null;
    }
}
