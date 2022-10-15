package FactoryPattern;

import org.reflections.Reflections;

import java.util.Map;
import java.util.Set;

public class Config<T> {

    private final Reflections scanner;
    private Map<Class<T>, Class<? extends T>> implMemo;

    public Config(String packageToScan, Map<Class<T>, Class<? extends T>> implMemo) {
        this.scanner = new Reflections(packageToScan);
        this.implMemo = implMemo;
    }

    public Class<? extends T> getClassByIfc(Class<T> ifc) {
        return implMemo.computeIfAbsent(ifc, aClass -> {
            Set<Class<? extends T>> classes = scanner.getSubTypesOf(ifc);
            if (classes.size() != 1) {
                throw new RuntimeException(ifc + " has 0 or more than one impl please update your config");
            }
            return classes.iterator().next();
        });
    }
}
