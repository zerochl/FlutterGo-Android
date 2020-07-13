package com.zero.fluttergo.util;

import com.zero.gson.Gson;
import com.zero.gson.reflect.TypeToken;

public class JsonUtil {

    public static <T> T gsonParse(String json, Class<T> classObj) {
        try {
            return new Gson().fromJson(json, classObj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> T gsonParse(String json, TypeToken typeToken) {
        try {
            return new Gson().fromJson(json, typeToken.getType());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> String gsonToJson(T obj) {
        if (null == obj) {
            return "";
        }
        return new Gson().toJson(obj);
    }

}
