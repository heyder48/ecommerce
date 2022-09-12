package com.lestscode.ecommerce.configuration;

import com.lestscode.ecommerce.utils.OrderStatusConverter;
import org.springframework.core.convert.converter.GenericConverter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter((GenericConverter) new OrderStatusConverter());
    }
}
