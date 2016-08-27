package com.study.sid;

public abstract class Duck {
    FlyBehavior flybehavoir;

    //QuackBehavior quackbehavoir;
    public Duck() {
    }

    public void performfly() {
        flybehavoir.fly();
    }
}
