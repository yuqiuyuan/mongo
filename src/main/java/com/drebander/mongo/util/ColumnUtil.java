package com.drebander.mongo.util;

import com.drebander.mongo.annotation.Column;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public class ColumnUtil {

    public static List<String> getColumnValue(Class classz) {
        Field[] fields = classz.getDeclaredFields();
        Field field;
        String[] value = new String[fields.length];
        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
        }
        for (int i = 0; i < fields.length; i++) {
            try {
                field = classz.getDeclaredField(fields[i].getName());
                Column column = field.getAnnotation(Column.class);
                if (null != column) {
                    value[i] = column.name();
                }
            } catch (Exception e) {
                e.getMessage();
            }
        }
        return Arrays.asList(value);
    }
}
