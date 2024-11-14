package com.exploreX.trigger.apis.config;

import com.exploreX.types.common.ZookeeperConstants;
import com.exploreX.types.enums.ResponseCode;
import com.exploreX.types.model.pojo.Response;
import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;
import org.apache.zookeeper.data.Stat;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;

/**
 * TODO
 *
 * @Description
 * @Author Lx
 * @Date 2024/11/7 下午11:06
 **/
@Slf4j
@RestController
@RequestMapping("/config")
public class DCCValueLimterController {    /*修改限流状态*/

    @Resource
    private CuratorFramework client;

    @PostMapping("/changeStatus")
    public Response<Boolean> changeLimiterStatus(/*limiter*/String lmiterKey , String activeKey, String value) {
        try {
            log.info("活动状态开始变更 key:{} value:{}", lmiterKey+"/"+activeKey, value);
            String keyPath = ZookeeperConstants.BASE_BUSINESS_PATH_CONFIG.concat("/").concat( lmiterKey+"/"+activeKey);
            if (null == client.checkExists().forPath(keyPath)) {
                client.create().creatingParentsIfNeeded().forPath(keyPath);
                log.info("DCC 节点监听 base node {} not absent create new done!", keyPath);
            }
            Stat stat = client.setData().forPath(keyPath, value.getBytes(StandardCharsets.UTF_8));
            log.info("DCC 动态配置值变更完成 key:{} value:{} time:{}",  lmiterKey+":"+activeKey, value, stat.getCtime());


            return Response.<Boolean>builder()
                    .code(ResponseCode.SUCCESS.getCode())
                    .info(ResponseCode.SUCCESS.getInfo())
                    .build();
        } catch (Exception e) {
            log.error("DCC 动态配置值变更失败 key:{} value:{}",  lmiterKey+"/"+activeKey, value, e);
            return Response.<Boolean>builder()
                    .code(ResponseCode.UN_ERROR.getCode())
                    .info(ResponseCode.UN_ERROR.getInfo())
                    .build();
        }
    }
}
