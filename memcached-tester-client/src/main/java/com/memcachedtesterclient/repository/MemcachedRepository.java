package com.memcachedtesterclient.repository;

/**
 * Created by Sa2 on 2017/01/05.
 */
public interface MemcachedRepository {

    public String store(String key, String value);

    public String resolve(String key);

    public String deleteValue(String key);

}
