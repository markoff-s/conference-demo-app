package com.pluralsight.conferencedemo.actuator.endpoints;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "readiness")
public class ReadinessEndpoint {

    private String ready = "NOT_READY";

    @ReadOperation
    public String getReadiness() {
        return ready;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void setAppIsReadyFromAppReadyEvent() {
        this.ready = "APP_IS_READY_FROM_APP_READY_EVENT";
    }

    @WriteOperation
    public void setAppIsReadyFromJMX() {
        this.ready = "APP_IS_READY_FROM_JMX";
    }
}
