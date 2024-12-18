package com.exploreX.domain.reward.raflle.chain.impl;

import com.exploreX.domain.reward.raflle.chain.TemplateChain;
import com.exploreX.domain.reward.raflle.chain.model.ChainInput;
import com.exploreX.domain.reward.raflle.chain.model.ChainOutput;
import org.springframework.stereotype.Service;

/**
 * TODO
 *
 * @Description
 * @Author Lx
 * @Date 2024/11/17 上午2:17
 **/
@Service("LockJudgeChain")
public class LockJudgeChain implements TemplateChain {
    TemplateChain curChain;
    TemplateChain nextChain;

    @Override
    public void setChain(TemplateChain cur) {
        this.curChain = cur;
    }

    @Override
    public ChainOutput doChain(ChainInput chainInput) {
        //TODO 奖品解锁判断

        ChainOutput chainOutput = new ChainOutput();
        return chainOutput;
    }

    @Override
    public void setNext(TemplateChain next) {
        this.nextChain = next;
    }

    @Override
    public TemplateChain getNext() {
        return null;
    }
}
