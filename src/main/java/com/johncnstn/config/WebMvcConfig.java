package com.johncnstn.config;

import com.johncnstn.view.resolver.CsvViewResolver;
import com.johncnstn.view.resolver.ExcelViewResolver;
import com.johncnstn.view.resolver.PdfViewResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer
                .defaultContentType(MediaType.APPLICATION_JSON)
                .favorPathExtension(true);
    }

    @Bean
    public ViewResolver contentNegotiatingViewResolver(ContentNegotiationManager manager) {
        ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
        resolver.setContentNegotiationManager(manager);

        // Define all possible view resolvers
        List<ViewResolver> resolvers = new ArrayList<>();

        InternalResourceViewResolver mainResolver = new InternalResourceViewResolver();
        mainResolver.setSuffix(".html");

        resolvers.add(mainResolver);
        resolvers.add(excelViewResolver());
        resolvers.add(csvViewResolver());
        resolvers.add(pdfViewResolver());

        resolver.setViewResolvers(resolvers);
        return mainResolver;
    }

    @Bean
    public ViewResolver excelViewResolver() {
        return new ExcelViewResolver();
    }

    @Bean
    public ViewResolver csvViewResolver() {
        return new CsvViewResolver();
    }

    @Bean
    public ViewResolver pdfViewResolver() {
        return new PdfViewResolver();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(4);
    }

}
