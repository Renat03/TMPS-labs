package domain.observer;

public class EmailNotificationObserver implements Observer {
    @Override
    public void update(String event) {
        System.out.println("[Email Notification] " + event);
    }
}

