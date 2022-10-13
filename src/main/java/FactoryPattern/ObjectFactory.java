package FactoryPattern;

public class ObjectFactory {

    private final Config configuration = new Config("FactoryPattern");

    <T> T createObject (Class<T> type){
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
