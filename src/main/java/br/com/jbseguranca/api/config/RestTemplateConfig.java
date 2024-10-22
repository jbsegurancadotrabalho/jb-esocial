package br.com.jbseguranca.api.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
    
    @Value("${acidente.trabalho.auth.token}")
    private String apiToken;
    
    @Value("${acidente.trabalho.auth.cnpj}")
    private String cnpjSh;
    
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder, List<ClientHttpRequestInterceptor> interceptors) {
        return builder
                .additionalInterceptors(interceptors)
                .build();
    }
    
    @Bean
    public ClientHttpRequestInterceptor authInterceptor() {
        return (request, body, execution) -> {
            request.getHeaders().add("cnpj_sh", cnpjSh);
            request.getHeaders().add("token_sh", apiToken);
            request.getHeaders().add("Content-Type", "text/tx2");
            return execution.execute(request, body);
        };
    }
}