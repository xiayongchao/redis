package com.xyc.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.nio.charset.Charset;

@SpringBootApplication
public class RedisApplication {
    public static void main(String[] args) {
        SpringApplication.run(RedisApplication.class, args);
    }

    @Bean
    public JedisConnectionFactory redisConnectionFactory() {
        /**
         * 使用JedisConnectionFactory的默认配置，可根据具体需求调整
         * this.hostName = "localhost";
         * this.port = 6379;
         * this.timeout = 2000;
         * this.usePool = true;
         * this.useSsl = false;
         * this.poolConfig = new JedisPoolConfig();
         * this.dbIndex = 0;
         * this.convertPipelineAndTxResults = true;
         */
        return new JedisConnectionFactory();
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory());
        redisTemplate.setKeySerializer(new StringRedisSerializer(Charset.forName("UTF8")));
        return redisTemplate;
    }
}
