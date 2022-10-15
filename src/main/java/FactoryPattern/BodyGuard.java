package FactoryPattern;

public class BodyGuard implements Worker{
    @Override
    public String doWork() {
        return "I guard my boss";
    }
}
