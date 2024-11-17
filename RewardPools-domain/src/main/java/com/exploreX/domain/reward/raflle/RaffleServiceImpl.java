package com.exploreX.domain.reward.raflle;

import com.exploreX.domain.reward.raflle.chain.factory.ChainEngine;
import com.exploreX.domain.reward.raflle.chain.model.ChainInput;
import com.exploreX.domain.reward.raflle.model.AfterRaffleInput;
import com.exploreX.domain.reward.raflle.model.AfterRaffleOutput;
import com.exploreX.domain.reward.raflle.model.PreRaffleInput;
import com.exploreX.domain.reward.raflle.model.PreRaffleOutput;
import org.springframework.kafka.core.KafkaTemplate;

import javax.annotation.Resource;

/**
 * TODO
 *
 * @Description
 * @Author Lx
 * @Date 2024/11/17 下午2:43
 **/
public class RaffleServiceImpl extends RaflleService {
    @Resource
    ChainEngine chainEngine;
    @Resource
    KafkaTemplate kafkaTemplate;

    @Override
    public PreRaffleOutput doPreRaffle(PreRaffleInput preRaffleInput) {
        ChainInput chainInput = new ChainInput();
        chainEngine.executeChain("beforeRaffle",chainInput);
        return new PreRaffleOutput();
    }

    @Override
    public AfterRaffleOutput doAfterRaffle(AfterRaffleInput afterRaffleInput) {
        //TODO 通过MQ将数据入热池
        kafkaTemplate.send("HOTPOT",afterRaffleInput);

        return new AfterRaffleOutput();
    }


}
