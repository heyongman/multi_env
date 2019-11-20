package com.he;

import java.io.InputStream;
import java.util.Properties;

public class SparkConfig {
    private static Properties prop;
    private String appName;
    static {
        try {
            InputStream in = Configuration.class.getClassLoader().getResourceAsStream("my.properties");
            prop = new Properties();
            prop.load(in);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getAppName(){
        return prop.getProperty("a");
    }
}
