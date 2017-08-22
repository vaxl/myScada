package ru.vaxl.scada.core.config;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.beans.factory.FactoryBean;

import java.util.concurrent.TimeUnit;

/**
 * Created by U7 on 31.07.2017.
 */
public class CacheSettings implements FactoryBean<Cache> {
    @Override
    public Cache getObject() throws Exception {
        return Caffeine.newBuilder()
                .maximumSize(200)
                .expireAfterAccess(1, TimeUnit.HOURS)
                .build();
    }

    @Override
    public Class<?> getObjectType() {
        return Cache.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}