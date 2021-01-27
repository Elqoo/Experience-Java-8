package academy.elqoo.java8.lambda;


public class Transaction {

    public void start(Runnable runnable) {
        runnable.run();
    }

    public void stop(Runnable runnable) {
    }

}
