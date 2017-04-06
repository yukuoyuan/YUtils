package cn.yky.utils;

import android.util.Log;


/**
 * Created by yukuo on 2015/11/18.
 * 这是一个log的工具类
 */
public class L {
    private static boolean flag = !Utils.isDebug();

    public static void e(String tag, String text) {
        if (!flag) {
            Log.e(tag, text);
        }
    }

    public static void d(String tag, String text) {
        if (!flag) {
            Log.d(tag, text);
        }
    }

    public static void i(String tag, String text) {
        if (!flag) {
            Log.i(tag, text);
        }
    }

    public static void v(String tag, String text) {
        if (!flag) {
            Log.v(tag, text);
        }
    }

    public static void w(String tag, String text) {
        if (!flag) {
            Log.w(tag, text);
        }
    }

    public static void wtf(String tag, String text) {
        if (!flag) {
            Log.wtf(tag, text);
        }
    }
}
