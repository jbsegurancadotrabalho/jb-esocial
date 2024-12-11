package br.com.jbseguranca.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;

import java.util.List;

@Configuration
public class MessageConverterConfig {

    @Bean
    public List<HttpMessageConverter<?>> messageConverters() {
        return List.of(
                new MappingJackson2HttpMessageConverter(),  // Suporte a JSON
                new Jaxb2RootElementHttpMessageConverter()  // Suporte a XML
        );
    }
}