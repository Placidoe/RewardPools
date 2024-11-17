package com.exploreX.domain.reward.raflle.chain;

import com.exploreX.domain.reward.raflle.chain.model.ChainInput;
import com.exploreX.domain.reward.raflle.chain.model.ChainOutput;

/**
 * TODO
 *
 * @Description
 * @Author Lx
 * @Date 2024/11/17 下午1:59
 **/
public interface TemplateChain {

    void setChain(TemplateChain cur);
    public ChainOutput doChain(ChainInput chainInput);
    void setNext(TemplateChain next);
    TemplateChain getNext();

}
