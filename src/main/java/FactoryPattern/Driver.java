package FactoryPattern;

public class Driver implements Worker {
    @Override
    public String doWork() {
        return "I Drive a car";
    }
}
