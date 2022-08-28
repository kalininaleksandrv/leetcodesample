package JavaCore;

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
