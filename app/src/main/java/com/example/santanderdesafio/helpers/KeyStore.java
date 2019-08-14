package com.example.santanderdesafio.helpers;

import android.content.Context;
import android.content.SharedPreferences;

public class KeyStore {
    private static KeyStore store;
    private SharedPreferences sp;
    private static String filename = "Keys";

    private KeyStore(Context context) {
        sp = context.getApplicationContext().getSharedPreferences(filename, 0);
    }

    public static KeyStore getInstance(Context context) {
        if (store == null) {
            store = new KeyStore(context);
        }
        return store;
    }

    public void put(String key, String value) {
        SharedPreferences.Editor editor = sp.edit();
        editor.remove(key);
        editor.putString(key, value);
        editor.apply();
    }

    public String get(String key) {
        return sp.getString(key, null);
    }

    public void putInt(String key, int value) {
        SharedPreferences.Editor editor = sp.edit();
        editor.remove(key);
        editor.putInt(key, value);
        editor.apply();
    }

    public int getInt(String key) {
        return sp.getInt(key, 0);
    }

    public void putDouble(String key, float value) {
        SharedPreferences.Editor editor = sp.edit();
        editor.remove(key);
        editor.putFloat(key, value);
        editor.apply();
    }

    public float getFloat(String key) {
        return sp.getFloat(key, 0);
    }

    public void clear() {
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
        editor.apply();
    }

    public void remove() {
        SharedPreferences.Editor editor = sp.edit();
        editor.remove(filename);
        editor.apply();
    }
}
