package com.exploreX.types.utils.nacos;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertiesToHashMapUtil {

    /**
     * 将Properties对象转换为HashMap
     *
     * @param properties 要转换的Properties对象
     * @return 转换后的HashMap，其中键和值的类型根据Properties中的数据类型确定，通常为String类型
     */
    public static Map<String, String> propertiesToHashMap(Properties properties) {
        Map<String, String> hashMap = new HashMap<>();
        for (String key : properties.stringPropertyNames()) {
            hashMap.put(key, properties.getProperty(key));
        }
        return hashMap;
    }

    public static void main(String[] args) {
        Properties properties = new Properties();
        try {
            properties.load(PropertiesToHashMapUtil.class.getClassLoader().getResourceAsStream("test.properties"));
            Map<String, String> result = propertiesToHashMap(properties);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}