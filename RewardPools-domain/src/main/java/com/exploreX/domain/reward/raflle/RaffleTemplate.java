package com.exploreX.domain.reward.raflle;

import com.exploreX.domain.reward.raflle.model.AfterRaffleInput;
import com.exploreX.domain.reward.raflle.model.AfterRaffleOutput;
import com.exploreX.domain.reward.raflle.model.PreRaffleInput;
import com.exploreX.domain.reward.raflle.model.PreRaffleOutput;

/**
 * TODO
 *
 * @Description
 * @Author 1
 * @Date 2024/11/17 下午2:31
 **/
public interface RaffleTemplate {
    public PreRaffleOutput doPreRaffle(PreRaffleInput preRaffleInput);
    public AfterRaffleOutput doAfterRaffle(AfterRaffleInput afterRaffleInput);


}
