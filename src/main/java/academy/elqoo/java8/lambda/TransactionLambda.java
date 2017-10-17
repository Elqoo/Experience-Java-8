package academy.elqoo.java8.lambda;

public class TransactionLambda implements Runnable{

    private boolean consumed = false;

    public boolean isConsumed() {
        return consumed;
    }

    @Override
    public void run() {
        consumed = true;
    }
}
