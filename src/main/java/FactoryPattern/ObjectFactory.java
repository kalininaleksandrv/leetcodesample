package FactoryPattern;

import java.util.HashMap;

public class ObjectFactory<T> {

    private final Config<T> configuration = new Config<>("FactoryPattern", new HashMap<>());

    T createObject (Class<T> type){
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
