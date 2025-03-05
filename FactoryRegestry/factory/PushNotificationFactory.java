package FactoryRegestry.factory;

import FactoryRegestry.notification.Notification;
import FactoryRegestry.notification.PushNotification;

public class PushNotificationFactory implements NotificationFactory {
    @Override
    public Notification createNotification() {
        return new PushNotification();
    }
}
