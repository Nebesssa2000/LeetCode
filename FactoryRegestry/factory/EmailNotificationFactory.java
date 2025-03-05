package FactoryRegestry.factory;

import FactoryRegestry.notification.EmailNotification;
import FactoryRegestry.notification.Notification;

public class EmailNotificationFactory implements NotificationFactory {
    @Override
    public Notification createNotification() {
        return new EmailNotification();
    }
}
