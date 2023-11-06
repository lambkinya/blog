package com.lambkin.blog.cache;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.*;

/**
 * 缓存
 *
 * @author lambkinya
 * @since 2023-10-13 11:43:28
 */
public class AppCache {

    private final static Map<String, Entity> MAP = new ConcurrentHashMap<>();

    /**
     * 定时器线程池，用于清除过期缓存
     */
    private final static ScheduledExecutorService EXECUTOR = Executors.newSingleThreadScheduledExecutor();

    /**
     * 添加缓存
     *
     * @param key  键
     * @param data 值
     */
    public static void put(String key, Object data) {
        put(key, data, 0);
    }

    /**
     * 添加缓存
     *
     * @param key    键
     * @param data   值
     * @param expire 过期时间，单位：秒， 0表示无限长
     */
    public static void put(String key, Object data, long expire) {
        //清除原键值对
        Entity entity = MAP.get(key);
        if (entity != null) {
            Future<?> oldFuture = entity.getFuture();
            if (oldFuture != null) {
                oldFuture.cancel(true);
            }
        }

        //设置过期时间
        if (expire > 0) {
            Future<?> future = EXECUTOR.schedule(() -> {
                MAP.remove(key);
            }, expire, TimeUnit.SECONDS);
            MAP.put(key, new Entity(data, future));
        } else {
            //不设置过期时间
            MAP.put(key, new Entity(data, null));
        }
    }

    /**
     * 读取缓存
     *
     * @param key 键
     */
    public static Object get(String key) {
        Entity entity = MAP.get(key);
        return entity == null ? null : entity.getValue();
    }

    /**
     * 读取所有缓存
     */
    public static Collection<?> values() {
        return MAP.values();
    }

    /**
     * 清除缓存
     */
    public static Object remove(String key) {
        //清除原缓存数据
        Entity entity = MAP.remove(key);
        if (entity == null) {
            return null;
        }
        //清除原键值对定时器
        Future<?> future = entity.getFuture();
        if (future != null) {
            future.cancel(true);
        }
        return entity.getValue();
    }

    /**
     * 查询当前缓存的键值对数量
     */
    public static int size() {
        return MAP.size();
    }

    /**
     * 缓存实体类
     */
    private static class Entity {
        //键值对的value
        private Object value;

        //定时器Future
        private Future future;

        public Entity(Object value, Future future) {
            this.value = value;
            this.future = future;
        }

        /**
         * 获取值
         */
        public Object getValue() {
            return value;
        }

        /**
         * 获取Future对象
         */
        public Future getFuture() {
            return future;
        }
    }
}
