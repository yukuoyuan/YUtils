package cn.yky.utils;

import android.content.Context;
import android.content.SharedPreferences;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;

/**
 * Created by yukuo on 2016/1/9.
 * 这是一个存储数据到本地的工具类
 */
public class SPUtil {
    private static final String SP_NAME = AppUtils.getAppName(Utils.getContext());
    private static SharedPreferences sp;

    /**
     * 这是一个存储long类型值的方法
     *
     * @param context
     * @param key
     * @param value
     */
    public static void putlong(Context context, String key, long value) {
        if (sp == null) {
            sp = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        }
        sp.edit().putLong(key, value).commit();
    }

    /**
     * 这是一个存储String值类型的方法
     *
     * @param context
     * @param key
     * @param value
     */
    public static void putString(Context context, String key, String value) {
        if (sp == null) {
            sp = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        }
        sp.edit().putString(key, value).commit();
    }

    /**
     * 这是一个存储int类型值的方法
     *
     * @param context
     * @param key
     * @param value
     */
    public static void putInt(Context context, String key, int value) {
        if (sp == null) {
            sp = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        }
        sp.edit().putInt(key, value).commit();
    }

    /**
     * 这是一个存储flot类型值的方法
     *
     * @param context
     * @param key
     * @param value
     */
    public static void putFloat(Context context, String key, float value) {
        if (sp == null) {
            sp = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        }
        sp.edit().putFloat(key, value).commit();
    }

    /**
     * 这是一个存储set集合的方法
     *
     * @param context
     * @param key
     * @param value
     */
    public static void putStringSet(Context context, String key, Set value) {
        if (sp == null) {
            sp = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        }
        sp.edit().putStringSet(key, value).commit();
    }

    /**
     * 这是一个存储boolean类型值的方法
     *
     * @param context
     * @param key
     * @param value
     */
    public static void putBoolean(Context context, String key, boolean value) {
        if (sp == null) {
            sp = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        }
        sp.edit().putBoolean(key, value).commit();
    }

    /**
     * 这是一个获取存储在本地的boolean类型值的方法
     *
     * @param context
     * @param key
     * @param value
     * @return
     */
    public static boolean getBoolean(Context context, String key, boolean value) {
        if (sp == null) {
            sp = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        }
        return sp.getBoolean(key, value);
    }

    /**
     * 这是一个获取存储在本地的set集合的方法
     *
     * @param context
     * @param key
     * @param value
     * @return
     */
    public static Set getStringSetn(Context context, String key, Set value) {
        if (sp == null) {
            sp = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        }
        return sp.getStringSet(key, value);
    }

    /**
     * 这是一个获取存储在本地的int类型值的方法
     *
     * @param context
     * @param key
     * @param value
     * @return
     */
    public static int getInt(Context context, String key, int value) {
        if (sp == null) {
            sp = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        }
        return sp.getInt(key, value);
    }

    /**
     * 这是一个获取存储在本地的String类型数据的方法
     *
     * @param context
     * @param key
     * @param value
     * @return
     */
    public static String getString(Context context, String key, String value) {
        if (sp == null) {
            sp = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        }
        return sp.getString(key, value);
    }

    /**
     * 这是一个获取存储在本地的long类型数据的方法
     *
     * @param context
     * @param key
     * @param value
     * @return
     */
    public static long getLong(Context context, String key, long value) {
        if (sp == null) {
            sp = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        }
        return sp.getLong(key, value);
    }

    /**
     * 这是一个获取存储在本地的float类型数据的方法
     *
     * @param context
     * @param key
     * @param value
     * @return
     */
    public static float getFloat(Context context, String key, float value) {
        if (sp == null) {
            sp = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        }
        return sp.getFloat(key, value);
    }

    /**
     * 移除某个key值已经对应的值
     *
     * @param context
     * @param key
     */
    public static void remove(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences(SP_NAME,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.remove(key);
        SharedPreferencesCompat.apply(editor);
    }

    /**
     * 清除所有数据
     *
     * @param context
     */
    public static void clear(Context context) {
        SharedPreferences sp = context.getSharedPreferences(SP_NAME,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
        SharedPreferencesCompat.apply(editor);
    }

    /**
     * 查询某个key是否已经存在
     *
     * @param context
     * @param key
     * @return
     */
    public static boolean contains(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences(SP_NAME,
                Context.MODE_PRIVATE);
        return sp.contains(key);
    }

    /**
     * 返回所有的键值对
     *
     * @param context
     * @return
     */
    public static Map<String, ?> getAll(Context context) {
        SharedPreferences sp = context.getSharedPreferences(SP_NAME,
                Context.MODE_PRIVATE);
        return sp.getAll();
    }

    /**
     * 创建一个解决SharedPreferencesCompat.apply方法的一个兼容类
     *
     * @author yky
     */
    private static class SharedPreferencesCompat {
        private static final Method sApplyMethod = findApplyMethod();

        /**
         * 反射查找apply的方法
         *
         * @return
         */
        @SuppressWarnings({"unchecked", "rawtypes"})
        private static Method findApplyMethod() {
            try {
                Class clz = SharedPreferences.Editor.class;
                return clz.getMethod("apply");
            } catch (NoSuchMethodException e) {
            }

            return null;
        }

        /**
         * 如果找到则使用apply执行，否则使用commit
         *
         * @param editor
         */
        public static void apply(SharedPreferences.Editor editor) {
            try {
                if (sApplyMethod != null) {
                    sApplyMethod.invoke(editor);
                    return;
                }
            } catch (IllegalArgumentException e) {
            } catch (IllegalAccessException e) {
            } catch (InvocationTargetException e) {
            }
            editor.commit();
        }
    }
}
