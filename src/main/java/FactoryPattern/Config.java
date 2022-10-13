package FactoryPattern;

import org.reflections.Reflections;

import java.util.Set;

public class Config {

    private Reflections scanner;

    public Config(String packageToScan) {
        this.scanner = new Reflections(packageToScan);
    }

    public <T> Class<? extends T> getClassByIfc(Class<T> ifc) {
        Set<Class<? extends T>> classes = scanner.getSubTypesOf(ifc);
        if (classes.size() != 1) {
            throw new RuntimeException(ifc + " has 0 or more than one impl please update your config");
        }
        return classes.iterator().next();
    }
}
