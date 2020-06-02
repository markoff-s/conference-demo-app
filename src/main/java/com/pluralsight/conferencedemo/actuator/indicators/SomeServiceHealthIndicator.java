package com.pluralsight.conferencedemo.actuator.indicators;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

// Custom health indicator
@Component
public class SomeServiceHealthIndicator implements HealthIndicator {
    @Override
    public Health getHealth(boolean includeDetails) {
        Boolean isUp = false;

        if (!isUp)
            return Health.down().withDetail("SomeService", "Not available").build();
        else
            return Health.up().withDetail("SomeService", "Available").build();
    }

    @Override
    public Health health() {
        return null;
    }
}
