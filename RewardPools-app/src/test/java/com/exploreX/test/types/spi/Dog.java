package com.exploreX.test.types.spi;

// 狗类实现Animal接口
public class Dog implements Animal {
    @Override
    public void makeSound() {
        System.out.println("汪汪汪");
    }
}

