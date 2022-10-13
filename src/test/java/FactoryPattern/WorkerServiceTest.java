package FactoryPattern;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WorkerServiceTest {

    @Test
    void makePersonDoWork() {
        WorkerService workerService = new WorkerService();
        assertEquals("I Drive a car", workerService.makePersonDoWork());
    }
}