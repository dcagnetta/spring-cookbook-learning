package co.za.codeboss.bookpub.properties;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@ConfigurationProperties(prefix = "custom")
@Validated
@Getter
@Setter
public class CustomProperties {

    private String welcomeMessage;

}
