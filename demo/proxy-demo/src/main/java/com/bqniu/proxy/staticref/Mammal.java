package com.bqniu.proxy.staticref;

public class Mammal implements Animal {
    Dog dog;

    public Mammal(Dog dog) {
        super();
        this.dog = dog;
    }

    @Override
    public void eat() {
        dog.eat();
    }

    @Override
    public void run() {
        dog.run();
    }

    @Override
    public void cry() {
        //TODO
        dog.cry();
        //TODO
    }
}
