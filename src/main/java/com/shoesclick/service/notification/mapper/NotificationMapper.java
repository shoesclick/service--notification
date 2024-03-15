package com.shoesclick.service.notification.mapper;

import com.shoesclick.notification.avro.TemplateEmailAvro;
import com.shoesclick.service.notification.entity.Notification;
import com.shoesclick.notification.avro.NotificationAvro;
import com.shoesclick.service.notification.entity.TemplateEmail;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel= MappingConstants.ComponentModel.SPRING)
public interface NotificationMapper {

    Notification map(NotificationAvro notificationAvro);

    TemplateEmail map(TemplateEmailAvro templateEmailAvro);
}
