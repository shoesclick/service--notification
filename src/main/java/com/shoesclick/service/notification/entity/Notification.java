package com.shoesclick.service.notification.entity;

import com.shoesclick.service.notification.enums.TypeTemplate;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;


@Entity
@Table(name="notification")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name="UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID uuid;

    private Long idOrder;

    private Long idCustomer;

    @Enumerated(EnumType.STRING)
    private TypeTemplate typeTemplate;

    public Long getIdOrder() {
        return idOrder;
    }

    public Notification setIdOrder(Long idOrder) {
        this.idOrder = idOrder;
        return this;
    }

    public Long getIdCustomer() {
        return idCustomer;
    }

    public Notification setIdCustomer(Long idCustomer) {
        this.idCustomer = idCustomer;
        return this;
    }

    public TypeTemplate getTypeTemplate() {
        return typeTemplate;
    }

    public Notification setTypeTemplate(TypeTemplate typeTemplate) {
        this.typeTemplate = typeTemplate;
        return this;
    }
}
