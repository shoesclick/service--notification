package com.shoesclick.service.notification.config;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Component;

@Component
public class NotificationMetrics {

    private final Counter notificationProcess;

    private final Counter notificationErrors;

    public NotificationMetrics(MeterRegistry registry) {
        this.notificationProcess = Counter.builder("notification_process_total")
                .description("Total de Notificações Processados")
                .register(registry);

        this.notificationErrors = Counter.builder("notification_process_errors_total")
                .description("Total de Notificações Com erros")
                .register(registry);

    }

    public void incrementNotificationSuccessCount() {
        notificationErrors.increment();
    }

    public void incrementNotificationErrorCount() {
        notificationErrors.increment();
    }
}
