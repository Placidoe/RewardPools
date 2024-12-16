package com.exploreX.trigger.apis.hotPool.service;

import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheService<K, V> {

    private final int capacity;
    private final LinkedHashMap<K, V> cache;

    public LRUCacheService(int capacity) {
        this.capacity = capacity;
        // 第三个参数设置为 true，表示按照访问顺序排序（即访问元素时会将其移动到末尾）
        this.cache = new LinkedHashMap<K, V>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return size() > capacity;
            }
        };
    }

    // 获取缓存中的值，如果存在则将其移动到末尾表示最近使用过，然后返回值
    public V get(K key) {
        return cache.get(key);
    }

    // 将键值对放入缓存，如果缓存已满则会自动淘汰最近最少使用的元素
    public void put(K key, V value) {
        cache.put(key, value);
    }

    // 获取当前缓存的大小（元素个数）
    public int size() {
        return cache.size();
    }

    // 判断缓存中是否包含指定的键
    public boolean containsKey(K key) {
        return cache.containsKey(key);
    }

    // 清空缓存中的所有元素
    public void clear() {
        cache.clear();
    }

    // 示例用法（可在测试类或者主函数中运行查看效果）
    public static void main(String[] args) {
        LRUCacheService<Integer, String> lruCache = new LRUCacheService<>(3);

        lruCache.put(1, "value1");
        lruCache.put(2, "value2");
        lruCache.put(3, "value3");

        System.out.println("初始缓存内容: " + lruCache.cache);

        lruCache.get(1);

        lruCache.put(4, "value4");

        System.out.println("操作后的缓存内容: " + lruCache.cache);

        System.out.println("缓存是否包含键2: " + lruCache.containsKey(2));
    }
}