package com.rjp.shell.base;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/**
 * 自动登录信息保存类（首选项）
 *
 * @author Administrator
 */
public class MySharedPreferences {

    public static final String FILENAME_SHAREPEREFERANCE = "shell_file";

    public static final String SAVE_NEWS = "save_news";

    private SharedPreferences sharedPreferences;
    private Editor editor;
    private static MySharedPreferences instance = null;

    private MySharedPreferences() {

    }

    public void init(Context context){
        sharedPreferences = context.getSharedPreferences(MySharedPreferences.FILENAME_SHAREPEREFERANCE, context.MODE_APPEND);
        editor = sharedPreferences.edit();
    }

    public static MySharedPreferences getInstance() {
        if (instance == null) {
            instance = new MySharedPreferences();
        }
        return instance;
    }

    /**
     * 设置String值
     *
     * @param key
     * @param value
     */
    public void putString(String key, String value) {
        editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    /**
     * 得到String值
     *
     * @param key
     *
     * @return
     */
    public String getString(String key) {
        return sharedPreferences.getString(key, "");
    }

    /**
     * 得到boolean值
     *
     * @param key
     *
     * @return
     */
    public boolean getBoolean(String key) {
        return sharedPreferences.getBoolean(key, false);
    }

    /**
     * 设置boolean值
     *
     * @param key
     * @param value
     */
    public void putBoolean(String key, boolean value) {
        editor = sharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    /**
     * 设置String值
     *
     * @param key
     * @param value
     */
    public void putInt(String key, int value) {
        editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.commit();
    }

    /**
     * 得到String值
     *
     * @param key
     *
     * @return
     */
    public int getInt(String key) {
        return sharedPreferences.getInt(key, 0);
    }
}
