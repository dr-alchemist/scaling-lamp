package dralchemist.scaling.lamp.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {

        return new OpenAPI().components(new Components())
                .info(new Info()
                .title("NASA REST SVC")
                .description("APOD DTA RETRIEVAL")
                .version("snapshot"));
    }

    @Bean
    public GroupedOpenApi api() {
        return GroupedOpenApi.builder()
                .setGroup("scaling-lamp")
                .pathsToMatch("/**")
                .build();
    }

}
