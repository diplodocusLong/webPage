package com.bohui.wf.gps.website.webpage.config;


import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lianglong
 */

@Configuration
public class LocalDateTimeSerializerConfig {

    @Value("${spring.jackson.date-time-format:yyyy-MM-dd HH:mm:ss}")
    private String dateTimePattern;

    @Value("${spring.jackson.date-format:yyyy-MM-dd}")
    private String datePattern;

    //序列化器
    public LocalDateTimeSerializer localDateTimeserializer() {
        return new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(dateTimePattern));
    }
    public LocalDateSerializer localDateSerializer(){
        return new LocalDateSerializer(DateTimeFormatter.ofPattern(datePattern));
    }

    //反序列化器
    public LocalDateTimeDeserializer localDateTimeDeserializer(){

        return new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern(dateTimePattern));
    }
    public LocalDateDeserializer localDateDeSerializer(){
        return new LocalDateDeserializer(DateTimeFormatter.ofPattern(datePattern));
    }
    //加入spring
    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer() {

        Map<Class<?>, JsonSerializer<?>>  serializerMap = new HashMap<>();
        Map<Class<?>, JsonDeserializer<?>>  deSerializerMap = new HashMap<>();
        serializerMap.put(LocalDate.class,localDateSerializer());
        serializerMap.put(LocalDateTime.class,localDateTimeserializer());
        deSerializerMap.put(LocalDate.class,localDateDeSerializer());
        deSerializerMap.put(LocalDateTime.class,localDateTimeDeserializer());

        return builder -> builder.serializersByType(serializerMap)
                          .deserializersByType(deSerializerMap);

    }

}
