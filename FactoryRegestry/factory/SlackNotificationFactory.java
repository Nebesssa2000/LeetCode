package FactoryRegestry.factory;

import FactoryRegestry.notification.Notification;
import FactoryRegestry.notification.SlackNotification;

public class SlackNotificationFactory implements NotificationFactory {
    @Override
    public Notification createNotification() {
        return new SlackNotification();
    }
}
