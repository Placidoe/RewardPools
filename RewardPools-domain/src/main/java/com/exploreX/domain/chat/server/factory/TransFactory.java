package com.exploreX.domain.chat.server.factory;

import com.exploreX.domain.chat.server.factory.TransService.TransService;
import com.exploreX.types.enums.TransEnum;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 *
 * @Description
 * @Author Lx
 * @Date 2024/11/3 下午2:41
 **/
@Component
public class TransFactory {
    @Resource
    private static final Map<String, TransService> transMenthodMap = new HashMap<>();

    public TransService getTransService(int codeType) {
        return transMenthodMap.get(TransEnum.BURN.getNameByCode(codeType));
    }
}
