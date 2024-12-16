package com.exploreX.types.utils.nacos;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.PropertyKeyConst;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingFactory;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import com.alibaba.nacos.api.naming.pojo.ServiceInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Properties;

@Service
public class NacosService {

    private static final Logger logger = LoggerFactory.getLogger(NacosService.class);

    // Nacos服务器地址，根据实际情况修改
    private static final String SERVER_ADDR = "192.168.253.144:8848";
    // 命名空间ID，非必需，如果有配置则填写
    private static final String NAMESPACE = "";


    /**
     * 向Nacos配置中心发布配置信息
     *
     * @param dataId    配置的dataId，用于唯一标识配置
     * @param groupId   配置的groupId，用于对配置进行分组管理
     * @param content   配置内容，以字符串形式传递
     * @param isEncrypt 是否加密配置内容（如果Nacos配置中心支持加密功能，可按需设置），这里暂未实现加密逻辑，仅作参数预留
     * @return 发布成功返回true，否则返回false
     */
    public static boolean publishConfigToNacos(String dataId, String groupId, String content, boolean isEncrypt) {
        try {
            Properties properties = new Properties();
            properties.put(PropertyKeyConst.SERVER_ADDR, SERVER_ADDR);
            if (!NAMESPACE.isEmpty()) {
                properties.put(PropertyKeyConst.NAMESPACE, NAMESPACE);
            }
            ConfigService configService = NacosFactory.createConfigService(properties);
            // 调用Nacos的ConfigService的发布配置方法，此处传入的参数分别为dataId、groupId、配置内容以及配置格式（这里固定为"text"，表示文本格式）
            configService.publishConfig(dataId, groupId, content, "text");
            logger.info("成功向Nacos配置中心发布配置，dataId: {}, groupId: {}", dataId, groupId);
            return true;
        } catch (NacosException e) {
            logger.error("向Nacos配置中心发布配置失败，dataId: {}, groupId: {}, 原因: {}", dataId, groupId, e.getMessage());
            return false;
        }
    }


    /**
     * 测试是否能连接到Nacos服务器，通过尝试获取一个配置来判断（简单示例）
     *
     * @return 如果能成功连接并获取到配置（哪怕是空配置）返回true，否则返回false
     */
    public boolean canConnectToNacos() {
        try {
            Properties properties = new Properties();
            properties.put(PropertyKeyConst.SERVER_ADDR, SERVER_ADDR);
            if (!NAMESPACE.isEmpty()) {
                properties.put(PropertyKeyConst.NAMESPACE, NAMESPACE);
            }
            ConfigService configService = NacosFactory.createConfigService(properties);
            // 尝试获取一个默认的配置（这里dataId和groupId可以根据实际情况调整，只是简单测试连接）
            String config = configService.getConfig("test-dataId", "test-groupId", 5000);
            return true;
        } catch (NacosException e) {
            logger.error("连接Nacos服务器失败，原因: {}", e.getMessage());
            return false;
        }
    }

    /**
     * 从Nacos配置中心获取配置信息
     *
     * @param dataId    配置的dataId
     * @param groupId   配置的groupId
     * @param timeoutMs 获取配置的超时时间（毫秒）
     * @return 获取到的配置内容字符串，如果获取失败返回null
     */
    public String getConfigFromNacos(String dataId, String groupId, long timeoutMs) {
        try {
            Properties properties = new Properties();
            properties.put(PropertyKeyConst.SERVER_ADDR, SERVER_ADDR);
            if (!NAMESPACE.isEmpty()) {
                properties.put(PropertyKeyConst.NAMESPACE, NAMESPACE);
            }
            ConfigService configService = NacosFactory.createConfigService(properties);
            return configService.getConfig(dataId, groupId, timeoutMs);
        } catch (NacosException e) {
            logger.error("从Nacos获取配置失败，dataId: {}, groupId: {}, 原因: {}", dataId, groupId, e.getMessage());
            return null;
        }
    }

    /**
     * 向Nacos服务注册中心注册服务实例
     *
     * @param serviceName 服务名称
     * @param ip          服务实例IP地址
     * @param port        服务实例端口号
     * @param healthy     服务实例健康状态
     * @param metadata    服务实例元数据（可选，以键值对形式传递更多服务相关信息）
     */
    public void registerServiceToNacos(String serviceName, String ip, int port, boolean healthy,
                                       Properties metadata) {
        try {
            Properties properties = new Properties();
            properties.put(PropertyKeyConst.SERVER_ADDR, SERVER_ADDR);
            if (!NAMESPACE.isEmpty()) {
                properties.put(PropertyKeyConst.NAMESPACE, NAMESPACE);
            }
            NamingService namingService = NamingFactory.createNamingService(properties);
            Instance instance = new Instance();
            instance.setIp(ip);
            instance.setPort(port);
            instance.setHealthy(healthy);
            instance.setMetadata(PropertiesToHashMapUtil.propertiesToHashMap(metadata));
            namingService.registerInstance(serviceName, instance);
            logger.info("服务 {} 已成功注册到Nacos，IP: {}, 端口: {}", serviceName, ip, port);
        } catch (NacosException e) {
            logger.error("服务注册到Nacos失败，服务名: {}, 原因: {}", serviceName, e.getMessage());
        }
    }

    /**
     * 从Nacos服务注册中心获取指定服务的信息
     *
     * @param serviceName 服务名称
     * @return 服务信息对象，如果获取失败返回null
     */
    public ServiceInfo getServiceInfoFromNacos(String serviceName) {
        try {
            Properties properties = new Properties();
            properties.put(PropertyKeyConst.SERVER_ADDR, SERVER_ADDR);
            if (!NAMESPACE.isEmpty()) {
                properties.put(PropertyKeyConst.NAMESPACE, NAMESPACE);
            }
            NamingService namingService = NamingFactory.createNamingService(properties);
            final List<ServiceInfo> subscribeServices = namingService.getSubscribeServices();
            ServiceInfo resServiceInfo = null;
            for (ServiceInfo serviceInfo : subscribeServices) {
                if (serviceInfo.getName().equals(serviceName)) {
                    resServiceInfo = serviceInfo;
                }
            }
            return resServiceInfo;
        } catch (NacosException e) {
            logger.error("从Nacos获取服务信息失败，服务名: {}, 原因: {}", serviceName, e.getMessage());
            return null;
        }
    }
}