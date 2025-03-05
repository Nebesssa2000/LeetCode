package FactoryRegestry.factory;

import FactoryRegestry.notification.Notification;
import FactoryRegestry.notification.SmsNotification;

public class SmsNotificationFactory implements NotificationFactory {
    @Override
    public Notification createNotification() {
        return new SmsNotification();
    }
}
