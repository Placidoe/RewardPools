package com.exploreX.domain.reward.raflle.chain.factory;

import com.exploreX.domain.reward.raflle.chain.TemplateChain;
import com.exploreX.domain.reward.raflle.chain.model.ChainInput;
import com.exploreX.domain.reward.raflle.chain.model.ChainOutput;
import com.exploreX.types.common.ChainConstants;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * TODO
 *
 * @Description
 * @Author Lx
 * @Date 2024/11/17 下午2:21
 **/
@Service
public class ChainEngine {

    @Resource
    ChainFactory factory;

    public void executeChain(String chainName, ChainInput input) {
        TemplateChain chain = factory.getChain(chainName);
        ChainOutput chainOutput = chain.doChain(input);

        int status = chainOutput.getStatus();
        HashMap<String, Object> params = chainOutput.getParams();

        //TODO makeNextInput
        ChainInput nextInput = new ChainInput();

        if(status== ChainConstants.SUCCESS){
            chain.getNext().doChain(nextInput);
        }

    }

}
