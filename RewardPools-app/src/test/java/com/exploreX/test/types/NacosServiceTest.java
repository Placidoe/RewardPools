package com.exploreX.test.types;

import com.alibaba.nacos.api.naming.pojo.ServiceInfo;
import com.exploreX.types.utils.nacos.NacosService;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Properties;

@SpringBootTest
public class NacosServiceTest {

    private static final Logger logger = LoggerFactory.getLogger(NacosServiceTest.class);

    @Autowired
    private NacosService nacosService;

    @BeforeEach
    public void setUp() {
        nacosService = new NacosService();
    }

    @AfterEach
    public void tearDown() {
        // 可以在这里进行一些清理操作
    }


    @Test
    public void checkNacosConnection() {
        boolean isConnected = nacosService.canConnectToNacos();
        if (isConnected) {
            System.out.println("能够成功连接到Nacos服务器");
        } else {
            System.out.println("无法连接到Nacos服务器，请检查相关配置和服务器状态");
        }
    }

    @Test
    public void testGetConfigFromNacos() {
        // 测试正常获取配置
        String dataId = "testDataId";
        String groupId = "testGroupId";
        long timeoutMs = 5000;
        String config = nacosService.getConfigFromNacos(dataId, groupId, timeoutMs);
        Assertions.assertNotNull(config);

        // 测试获取配置失败的情况
        String invalidDataId = "invalidDataId";
        String invalidGroupId = "invalidGroupId";
        String invalidConfig = nacosService.getConfigFromNacos(invalidDataId, invalidGroupId, timeoutMs);
        Assertions.assertNull(invalidConfig);
    }

    @Test
    public void testRegisterServiceToNacos() {
        // 测试服务注册
        String serviceName = "testService";
        String ip = "127.0.0.1";
        int port = 8881;
        boolean healthy = true;
        Properties metadata = new Properties();
        metadata.put("key1", "value1");
        metadata.put("key2", "value2");

        nacosService.registerServiceToNacos(serviceName, ip, port, healthy, metadata);

        // 可以添加一些断言来验证服务是否成功注册
    }

    @Test
    public void testGetServiceInfoFromNacos() {
        // 测试获取服务信息
        String serviceName = "testService";
        ServiceInfo serviceInfo = nacosService.getServiceInfoFromNacos(serviceName);
        Assertions.assertNotNull(serviceInfo);

        // 测试获取不存在的服务信息
        String nonExistentServiceName = "nonExistentService";
        ServiceInfo nonExistentServiceInfo = nacosService.getServiceInfoFromNacos(nonExistentServiceName);
        Assertions.assertNull(nonExistentServiceInfo);
    }
}
