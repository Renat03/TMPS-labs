package domain.observer;

public class LoggingObserver implements Observer {
    @Override
    public void update(String event) {
        System.out.println("[Log] " + event);
    }
}
