package FactoryPattern;

import java.util.HashMap;
import java.util.Map;

public class WorkerService {

    private final Worker person;

    public WorkerService() {
        /*
         since we have more than two impl of Worker, we add default impl to map
         it makes us erase type of Config because we need it to be <T> but put concrete ipl in map
         */
        ObjectFactory<Worker> objectFactory = new ObjectFactory<>(new Config<>("FactoryPattern", new HashMap<>(Map.of(Worker.class, Driver.class))));
        person = objectFactory.createObject(Worker.class);
    }

    public String makePersonDoWork() {
        return person.doWork();
    }
}
