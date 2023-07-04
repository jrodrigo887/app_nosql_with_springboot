package com.mongodb.api.app_nosql.resources.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public abstract class URL {
    public static String decode(String text) {
        try {
            return URLDecoder.decode(text, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }
}
