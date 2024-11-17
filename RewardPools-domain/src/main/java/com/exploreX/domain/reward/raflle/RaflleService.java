package com.exploreX.domain.reward.raflle;

import com.exploreX.domain.reward.raflle.model.*;

import javax.annotation.Resource;

/**
 * TODO
 *
 * @Description
 * @Author 1
 * @Date 2024/11/17 下午2:48
 **/
public abstract class RaflleService implements RaffleTemplate {

    public RaffleOutput doRaffle(RaffleInput raffleInput){
        PreRaffleInput preRaffleInput = new PreRaffleInput();
        PreRaffleOutput preRaffleOutput = doPreRaffle(preRaffleInput);
        System.out.println("doRaffle");
        AfterRaffleInput afterRaffleInput = new AfterRaffleInput();
        AfterRaffleOutput afterRaffleOutput = doAfterRaffle(afterRaffleInput);

        return new RaffleOutput();
    }
}
