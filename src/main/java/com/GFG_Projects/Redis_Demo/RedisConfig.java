package com.GFG_Projects.Redis_Demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.*;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

//    @Bean
//    public RedisConnectionFactory getConnectionFactory() {
//        RedisStandaloneConfiguration redisStandaloneConfiguration =
//                new RedisStandaloneConfiguration();
//
//        RedisConnectionFactory factory = new LettuceConnectionFactory(redisStandaloneConfiguration);
//
//        return factory;
//    }

//    @Bean
//    public RedisTemplate<String, Object> getTemplate() {
//        RedisTemplate template = new RedisTemplate<String, Object>();
//
//        template.setConnectionFactory(getConnectionFactory());
//        template.setHashKeySerializer(new StringRedisSerializer());
//        template.setHashValueSerializer(new JdkSerializationRedisSerializer());
//        template.setKeySerializer(new StringRedisSerializer());
//        template.setValueSerializer(new JdkSerializationRedisSerializer());
//
//        return template;
//    }


    @Bean
    public RedisTemplate<String, Object> getTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);

        // Use String serializer for keys
        template.setKeySerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new StringRedisSerializer());

        // Use JSON serializer for values
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        template.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());

        return template;
    }


}
