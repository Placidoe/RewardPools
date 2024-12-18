package com.exploreX.test.types.spi;

// 猫类实现Animal接口
public class Cat implements Animal {
    @Override
    public void makeSound() {
        System.out.println("喵喵喵");
    }
}