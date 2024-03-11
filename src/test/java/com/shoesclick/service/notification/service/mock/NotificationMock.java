package com.shoesclick.service.notification.service.mock;

import com.shoesclick.service.notification.entity.Notification;
import com.shoesclick.service.notification.enums.TypeTemplate;

public class NotificationMock {

    private NotificationMock(){}

    public static Notification getOrderNotification() {
        return new Notification().setIdOrder(1L).setIdCustomer(1L).setTypeTemplate(TypeTemplate.CREATE_ORDER);
    }

}
