package com.newhero.commonsdk.utils;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by zdj on 2016/11/19.
 */

public class DateAdapter implements JsonDeserializer<Date> {
    private final DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public Date deserialize(JsonElement arg0, Type arg1, JsonDeserializationContext arg2) throws JsonParseException {
        try {
            long l = arg0.getAsLong();
            Date date = new Date(l);
            return date;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
