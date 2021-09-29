package com.kuang.utils;

import org.apache.ibatis.cache.Cache;

/**
 * @author 郭宇航
 * @date 2021/9/29
 * @apiNote
 */
public class MyCache implements Cache {
    @Override
    public String getId() {
        return null;
    }

    @Override
    public void putObject(Object o, Object o1) {

    }

    @Override
    public Object getObject(Object o) {
        return null;
    }

    @Override
    public Object removeObject(Object o) {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public int getSize() {
        return 0;
    }
}
