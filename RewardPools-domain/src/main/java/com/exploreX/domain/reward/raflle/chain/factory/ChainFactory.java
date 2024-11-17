package com.exploreX.domain.reward.raflle.chain.factory;

import com.exploreX.domain.reward.raflle.chain.TemplateChain;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * TODO
 *
 * @Description
 * @Author Lx
 * @Date 2024/11/17 下午2:21
 **/
@Service
public class ChainFactory {
    @Resource
    Map<String, TemplateChain> chainMap;

    public ChainFactory(Map<String,TemplateChain> map){
        this.chainMap=map;
    }
    public TemplateChain getChain(String chainName){
        return chainMap.get(chainName);
    }

    public void builChain(){
        //TODO
    }
}
