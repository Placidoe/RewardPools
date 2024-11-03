package com.exploreX.types.utils;

import org.springframework.stereotype.Component;

@Component
public class SnowflakeUtil {

    // 起始的时间戳
    private final static long START_TIMESTAMP = 1609459200000L; // 2021-01-01 00:00:00

    // 每一部分占用的位数
    private final static long TIMESTAMP_BITS = 41;
    private final static long MACHINE_ID_BITS = 10;
    private final static long SEQUENCE_BITS = 12;

    // 每一部分的最大值
    private final static long MAX_MACHINE_ID = ~(-1L << MACHINE_ID_BITS);
    private final static long MAX_SEQUENCE = ~(-1L << SEQUENCE_BITS);

    // 每一部分向左的位移
    private final static long MACHINE_ID_SHIFT = SEQUENCE_BITS;
    private final static long TIMESTAMP_LEFT_SHIFT = SEQUENCE_BITS + MACHINE_ID_BITS;
    private final static long SEQUENCE_MASK = ~(-1L << SEQUENCE_BITS);

    // 工作机器 ID
    private long machineId;
    // 序列号
    private long sequence = 0L;
    // 上一次时间戳
    private long lastTimestamp = -1L;

    private static SnowflakeUtil instance;

    private SnowflakeUtil(long machineId) {
        if (machineId > MAX_MACHINE_ID || machineId < 0) {
            throw new IllegalArgumentException(String.format("Machine Id can't be greater than %d or less than 0", MAX_MACHINE_ID));
        }
        this.machineId = machineId;
    }

    public static synchronized SnowflakeUtil getInstance(long machineId) {
        if (instance == null) {
            instance = new SnowflakeUtil(machineId);
        }
        return instance;
    }

    public synchronized long nextId() {
        long timestamp = timeGen();

        // 如果当前时间小于上一次生成 ID 的时间，说明系统时钟回退，异常处理
        if (timestamp < lastTimestamp) {
            throw new RuntimeException(String.format("Clock moved backwards. Refusing to generate id for %d milliseconds", lastTimestamp - timestamp));
        }

        // 如果是同一时间生成的，则进行序列号加一
        if (lastTimestamp == timestamp) {
            sequence = (sequence + 1) & SEQUENCE_MASK;
            // 同一毫秒的序列号溢出
            if (sequence == 0) {
                // 阻塞到下一个毫秒,获得新的时间戳
                timestamp = tilNextMillis(lastTimestamp);
            }
        } else {
            // 时间戳改变，序列号重置
            sequence = 0L;
        }

        // 上次生成 ID 的时间截
        lastTimestamp = timestamp;

        // 移位并通过或运算拼到一起组成 64 位的 ID
        return ((timestamp - START_TIMESTAMP) << TIMESTAMP_LEFT_SHIFT) |
                (machineId << MACHINE_ID_SHIFT) |
                sequence;
    }

    protected long tilNextMillis(long lastTimestamp) {
        long timestamp = timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = timeGen();
        }
        return timestamp;
    }

    protected long timeGen() {
        return System.currentTimeMillis();
    }

    /**
     * 静态方法，提供获取分布式 ID 的功能
     * @param machineId 机器标识
     * @return 生成的分布式 ID
     */
    public static long getNextId(long machineId) {
        return getInstance(machineId).nextId();
    }
}