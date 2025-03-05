package FactoryRegestry;

import FactoryRegestry.factory.EmailNotificationFactory;
import FactoryRegestry.factory.PushNotificationFactory;
import FactoryRegestry.factory.SmsNotificationFactory;
import FactoryRegestry.notification.Notification;

public class NotificationService {
    private final NotificationFactoryRegistry factoryRegistry;

    public NotificationService(NotificationFactoryRegistry factoryRegistry) {
        this.factoryRegistry = factoryRegistry;
        registerFactories();
    }

    private void registerFactories() {
        factoryRegistry.registerNotificationFactory("Email", new EmailNotificationFactory());
        factoryRegistry.registerNotificationFactory("SMS", new SmsNotificationFactory());
        factoryRegistry.registerNotificationFactory("Push", new PushNotificationFactory());
    }

    public void sendNotification(String type, String message) {
        Notification notification = factoryRegistry.createNotification(type);
        notification.send(message);
    }
}
