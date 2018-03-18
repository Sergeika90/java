package com.testtask.resumegenerator;

import java.util.Properties;

/**
 * Created by jdev on 1/28/18.
 */
public class ResumeProperties extends Properties {
    @Override
    public Object put(Object key, Object value)  {
        if (get(key) != null) {
            // Обрабатываем ситуацию дублированного ключа
            Object mergeValue = get(key).toString().concat(" " + value);
            return super.put(key, mergeValue);
        }
        return super.put(key, value);
    }
}
