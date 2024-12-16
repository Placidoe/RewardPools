package com.exploreX.trigger.apis.hotPool.service;

import java.util.HashMap;
import java.util.Map;

// 观察者接口，定义了接收通知的方法
interface Observer {
    void update(String nodeName, HotPoolNode node);
}

// 被观察的对象，这里是HotPoolNode类
class HotPoolNode {
    private String name;
    private Map<String, Object> innerMap = new HashMap<>();
    private final Map<Observer, Boolean> observers = new HashMap<>();

    public HotPoolNode(String name) {
        this.name = name;
    }

    // 添加参数到内部的HashMap中，并在size达到4时通知观察者
    public void addParam(String key, Object value) {
        innerMap.put(key, value);
        if (innerMap.size() == 4) {
            notifyObservers();
        }
    }

    // 注册观察者
    public void registerObserver(Observer observer) {
        observers.put(observer, true);
    }

    // 移除观察者
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    // 通知所有已注册的观察者
    private void notifyObservers() {
        for (Observer observer : observers.keySet()) {
            observer.update(name, this);
        }
    }

    public String getName() {
        return name;
    }

    public Map<String, Object> getInnerMap() {
        return innerMap;
    }
}

// 具体的观察者实现类，这里简单地实现了打印通知信息的逻辑
class MyObserver implements Observer {
    @Override
    public void update(String nodeName, HotPoolNode node) {
        System.out.println("节点 " + nodeName + " 的参数个数已达到要求，当前参数列表: " + node.getInnerMap());
        //todo 下发调用处理接口

        //todo 统计数据

        //todo 更新数据库节点表的节点状态

        //todo hashmap更新节点状态


    }
}

public class ObserverPatternDemo {
    public static void main(String[] args) {
        // 创建一个HotPoolNode实例
        HotPoolNode hotPoolNode = new HotPoolNode("node1");

        // 创建观察者实例
        Observer observer = new MyObserver();

        // 注册观察者到HotPoolNode
        hotPoolNode.registerObserver(observer);

        // 向HotPoolNode添加参数
        hotPoolNode.addParam("param1", "value1");
        hotPoolNode.addParam("param2", "value2");
        hotPoolNode.addParam("param3", "value3");
        hotPoolNode.addParam("param4", "value4");

        // 尝试添加更多参数（不会再触发通知，因为通知只在size达到4时触发一次）
        hotPoolNode.addParam("param5", "value5");

        // 移除观察者
        hotPoolNode.removeObserver(observer);

        // 再次添加参数（由于观察者已移除，不会触发通知）
        hotPoolNode.addParam("param6", "value6");
    }
}