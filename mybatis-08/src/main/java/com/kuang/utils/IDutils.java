package com.kuang.utils;

import org.junit.Test;

import java.util.UUID;

/**
 * @author 郭宇航
 * @date 2021/9/23
 * @apiNote
 */
@SuppressWarnings("all") //抑制警告
public class IDutils {

    public static String getUUIDString() {
        return UUID.randomUUID().toString().replace("-","");
    }

    @Test
    public void test() {
        System.out.println(IDutils.getUUIDString());
    }
}
