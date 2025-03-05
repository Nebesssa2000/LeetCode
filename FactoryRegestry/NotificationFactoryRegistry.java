package FactoryRegestry;

import FactoryRegestry.factory.NotificationFactory;
import FactoryRegestry.notification.Notification;

import java.util.HashMap;
import java.util.Map;

public class NotificationFactoryRegistry {
    private final Map<String, NotificationFactory> registry = new HashMap<>();

    public void registerNotificationFactory(String type, NotificationFactory factory) {
        registry.put(type, factory);
    }

    public Notification createNotification(String type) {
        NotificationFactory factory = registry.get(type);
        if (factory == null) {
            throw new IllegalArgumentException("Unknown notification type: " + type);
        }
        return factory.createNotification();
    }
}
