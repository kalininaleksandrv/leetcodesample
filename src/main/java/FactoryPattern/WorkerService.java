package FactoryPattern;

public class WorkerService {

    private final Worker person;

    public WorkerService() {
        ObjectFactory<Worker> objectFactory = new ObjectFactory<>();
        person = objectFactory.createObject(Worker.class);
    }

    public String makePersonDoWork() {
        return person.doWork();
    }
}
