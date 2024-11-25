package ProjArq.ControlSubApp.aplicacao.service;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class CacheService {

    private final Cache<String, String> cache;

    public CacheService(@Value("${cache.ttl}") long ttlMillis) {
        // Configura o cache com TTL
        this.cache = Caffeine.newBuilder()
                .expireAfterWrite(ttlMillis, TimeUnit.MILLISECONDS)
                .build();
    }

    public String getCacheInfo(String appId) {
        return cache.getIfPresent(appId);
    }

    public void updateCache(String appId, String validity) {
        cache.put(appId, validity);
    }

    public int getCacheSize() {
        return (int) cache.estimatedSize();
    }
}
