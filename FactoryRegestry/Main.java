package FactoryRegestry;

import FactoryRegestry.factory.SlackNotificationFactory;

public class Main {
    public static void main(String[] args) {
        NotificationFactoryRegistry factoryRegistry = new NotificationFactoryRegistry();
        NotificationService notificationService = new NotificationService(factoryRegistry);

        notificationService.sendNotification("Email", "Hello via Email!");
        notificationService.sendNotification("SMS", "Hello via SMS!");
        notificationService.sendNotification("Push", "Hello via Push Notification!");

        // Добавление нового типа уведомления
        factoryRegistry.registerNotificationFactory("Slack", new SlackNotificationFactory());
        notificationService.sendNotification("Slack", "Hello via Slack!");
    }
}
