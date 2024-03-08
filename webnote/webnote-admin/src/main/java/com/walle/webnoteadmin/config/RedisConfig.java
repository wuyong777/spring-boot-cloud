package com.walle.webnoteadmin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import java.time.Duration;

/**
 * Redis配置类，用于配置Redis相关的模板和缓存管理器。
 */
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {

    /**
     * 配置并返回RedisTemplate，用于操作Redis数据库。
     *
     * @param redisConnectionFactory Redis连接工厂。
     * @return 配置好的RedisTemplate实例。
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        // 设置键的序列化方式为StringRedisSerializer
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        // 设置值的序列化方式为GenericJackson2JsonRedisSerializer，使用Jackson JSON库进行序列化
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        return redisTemplate;
    }

    /**
     * 配置并返回RedisCacheManager，作为Spring应用的缓存管理器。
     *
     * @param redisConnectionFactory Redis连接工厂。
     * @return 配置好的RedisCacheManager实例。
     */
    @Bean
    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
        // 配置缓存默认设置，如过期时间
        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofSeconds(600));

        // 构建RedisCacheManager实例，启用事务支持
        RedisCacheManager redisCacheManager = RedisCacheManager.builder(redisConnectionFactory)
                .cacheDefaults(redisCacheConfiguration)
                .transactionAware()
                .build();

        return redisCacheManager;
    }
}
