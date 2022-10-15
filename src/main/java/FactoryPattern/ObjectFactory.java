package FactoryPattern;

import java.util.HashMap;
import java.util.Map;

public class ObjectFactory<T> {

    private final Config<T> configuration;

    public ObjectFactory() {
        /*
         since we have more then two impl of Worker, we add default impl to map
         it makes us erase type of Config because we need it to be <T> but put concrete ipl in map
         */
        this.configuration = new Config("FactoryPattern", new HashMap<>(Map.of(Worker.class, Driver.class)));
    }

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
