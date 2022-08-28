package JavaCore;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.stream.IntStream;

public class ConcurrencyExample {

    // TODO: 27.08.2022 synchronization on class and on method is a different - add example

    public int exampleOfSync() {
        ExampleOfSynchronization example = new ExampleOfSynchronization();
        return example.main();
    }

    public void howToCreateThreads() {

        //simple runnable
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello from " + Thread.currentThread().getName());
            }
        };

        //same with lambda
        Runnable runnableWithLambda = () -> System.out.println("hello from " + Thread.currentThread().getName());

        Thread thread1 = new Thread(runnable);
        thread1.setName("my-custom-thread");
        thread1.start();

        Thread thread2 = new Thread(runnableWithLambda);
        thread2.start();

        //same with class which implements Runnable
        Thread thread3 = new Thread(new HowToCreateThreads());
        thread3.start();
    }

    public int calculationInDifferentThreadWithCallable(int[] nums) {

        FutureTask<Integer> task = new FutureTask<>(new ParallelCalculator(nums));
        Thread thread1 = new Thread(task);
        thread1.start();
        try {
            return task.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    public int callableCalculatorLambdaSimplification(int[] nums) {

        FutureTask<Integer> task = new FutureTask<>(() -> IntStream.of(nums).sum());
        Thread thread1 = new Thread(task);
        thread1.start();
        try {
            return task.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}

class ExampleOfSynchronization {

    private static int count = 0;

    /*
     * both methods main() and add() are synchronized, but since monitor holds by the same object,
     * the thread could re-enter in a different from main method to add
     */

    public synchronized int main() {
        inc();
        return count;
    }
    public synchronized void inc (){
        count++;
    }
}

class HowToCreateThreads implements Runnable {

    @Override
    public void run() {
        System.out.println("hello from new class in " + Thread.currentThread().getName());
    }
}

class ParallelCalculator implements Callable<Integer> {

    int[] numbersToCalculate;

    public ParallelCalculator(int[] numbersToCalculate) {
        this.numbersToCalculate = numbersToCalculate;
    }

    @Override
    public Integer call() {
        System.out.println("trying to calculate in thread " + Thread.currentThread().getName());
        return IntStream.of(numbersToCalculate).sum();
    }
}
