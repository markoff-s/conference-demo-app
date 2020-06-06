package com.pluralsight.conferencedemo.actuator.indicators;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

@Component
public class ProjectInfoContributor implements InfoContributor {
    @Override
    public void contribute(Info.Builder builder) {
        builder
                .withDetail("project_name", "xz")
                .withDetail("owned_by", "me")
                .withDetail("contact", "again me");

    }
}
