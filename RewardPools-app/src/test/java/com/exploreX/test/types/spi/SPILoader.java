package com.exploreX.test.types.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

public class SPILoader {
    public static void main(String[] args) {
        // 使用ServiceLoader加载Animal接口的所有服务提供者实现类
        ServiceLoader<Animal> animalServiceLoader = ServiceLoader.load(Animal.class);

        // 遍历并调用每个实现类的makeSound方法
        Iterator<Animal> iterator = animalServiceLoader.iterator();
        while (iterator.hasNext()) {
            Animal animal = iterator.next();
            animal.makeSound();
        }
    }
}