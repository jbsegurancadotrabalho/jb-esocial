package br.com.jbseguranca.api.config;


import java.util.Arrays;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class SwaggerConfiguration {

    @Value("${urlExterna}")
    String urlExterna;

    @Bean
    public GroupedOpenApi drogariaGroupedOpenApi() {
        return GroupedOpenApi.builder()
                .group("jbseguranca")
                .pathsToMatch("/**")
                .addOpenApiCustomizer(jbSegurancaOpenApiCustomizer())
                .packagesToScan("br.com.jbseguranca.api.controller")
                .build();
    }

    @Bean
    public OpenApiCustomizer jbSegurancaOpenApiCustomizer() {
        return openApi -> openApi.info(commonsInfo())
                .servers(Arrays.asList(new Server().url(urlExterna)));
    }

    private Info commonsInfo() {
        return new Info()
                .title("API ESocial - JB Segurança")
                .description("Documentação API JB Segurança.")
                .license(new License().name("Apache License Version 2.0")
                        .url("https://www.apache.org/licenses/LICENSE-2.0"))
                .contact(new Contact()
                        .name("JB Segurança")
                        .url("https://www.jbseguranca.com.br/")
                        .email("jbseguranca@gmail.com"));
    }
}
