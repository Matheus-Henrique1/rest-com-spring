package br.com.curso.rest_com_spring.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Value("${cors.origin.patterns}")
    private String corsOriginPatterns = "";

    @Value("${cors.origin.methods}")
    private String corsOriginMethods = "";

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {

        //VIA HEADER
        configurer.favorParameter(false)
                .ignoreAcceptHeader(false)
                .useRegisteredExtensionsOnly(false)
                .defaultContentType(MediaType.APPLICATION_JSON)
                .mediaType("json", MediaType.APPLICATION_JSON)
                .mediaType("xml", MediaType.APPLICATION_XML);

//        VIA QUERYPARAM
//        configurer.favorParameter(true)
//                .parameterName("mediaType")
//                .ignoreAcceptHeader(true)
//                .useRegisteredExtensionsOnly(false)
//                .defaultContentType(MediaType.APPLICATION_JSON)
//                    .mediaType("json", MediaType.APPLICATION_JSON)
//                    .mediaType("xml", MediaType.APPLICATION_XML);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry){
        var corsMethods = corsOriginMethods.split(",");
        registry.addMapping("/**")
                .allowedOrigins(corsOriginPatterns)
                .allowedMethods(corsMethods)
                .allowCredentials(true);
    }
}
