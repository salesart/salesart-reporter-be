package com.saleart.reporter.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "report")
@Data
public class ReportProperties {

    private long postRequestSizeLimit = 2 * 1024 * 1024;

}
