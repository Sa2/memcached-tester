package com.memcachedtesterclient.repository;

import com.memcachedtesterclient.config.BasicMemcachedConfig;
import net.spy.memcached.MemcachedClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * Created by Sa2 on 2017/01/05.
 */
@Component
public class BasicMemcachedRepository implements MemcachedRepository {

    private MemcachedClient memcachedClient;

    @Autowired
    private BasicMemcachedConfig basicMemcachedConfig;

    public BasicMemcachedRepository(BasicMemcachedConfig basicMemcachedConfig) throws IOException {
        basicMemcachedConfig.displayHost();
        memcachedClient = new net.spy.memcached.MemcachedClient(new InetSocketAddress(basicMemcachedConfig.getHost(), basicMemcachedConfig.getPort()));
    }

    public String deleteValue(String key) {
        // 予めキーがキャッシュされているかチェック
        try {
            memcachedClient.get(key).toString();
        } catch (Exception e) {
            return key + " was not found...";
        }

        try {
            memcachedClient.delete(key);
        } catch (Exception e) {
            return "Failed delete cache from memcached...";
        }
        return key + " is deleted";
    }

    public String store(String key, String value) {
        try {
            memcachedClient.set(key, basicMemcachedConfig.getExpr(), value);
        } catch (Exception e) {
            return "Failed store from memcached... key : " + key + ", value : " + value;
        }
        return "Stored key : " + key + ", value : " + value;
    }

    public String resolve(String key) {
        String cachedValue;
        try {
            cachedValue = memcachedClient.get(key).toString();
        } catch (Exception e) {
            return "Failed resolve from memcached... key : " + key;
        }
        return cachedValue;
    }
}
