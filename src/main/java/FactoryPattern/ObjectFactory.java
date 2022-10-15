package FactoryPattern;

import java.util.HashMap;
import java.util.Map;

public class ObjectFactory<T> {

    private final Config<Worker> configuration;

    public ObjectFactory() {
        this.configuration = new Config<>("FactoryPattern", new HashMap<>(Map.of(Worker.class, Driver.class)));
    }

    T createObject (Class type){
        Class<? extends T> implClass = type;
        if(type.isInterface()){
            implClass = configuration.getClassByIfc(type);
        }
        T instance;
        try {
            instance = implClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("unable to instantiate class " + type.getSimpleName());
        }
        return instance;
    }
}
