package domain.observer;

public class DatabaseObserver implements Observer {
    @Override
    public void update(String event) {
        System.out.println("[Database] Updating record: " + event);
    }
}
