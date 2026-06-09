package com.mycompany.login_reservafacil.util;

import java.io.InputStream;
import java.util.Properties;

public class ConfigUtil {

    private static Properties props = new Properties();

    static {
        try {
            InputStream input = ConfigUtil.class
                .getClassLoader()
                .getResourceAsStream("config.properties");

            if (input == null) {
                throw new RuntimeException("No se encontró config.properties en resources");
            }

            props.load(input);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String get(String key) {
        return props.getProperty(key);
    }
}