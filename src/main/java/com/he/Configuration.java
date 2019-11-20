package com.he;

import java.io.InputStream;
import java.util.Properties;

/**
 * 配置管理组件
 */
public class Configuration {
	
	private Properties prop = null;

	public static Configuration from(String path){
		return new Configuration(path);
	}

	private Configuration(final String propName){
		try {
			InputStream in = Configuration.class.getClassLoader()
					.getResourceAsStream(propName);
			this.prop = new Properties();
			this.prop.load(in);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	/**
	 * 获取指定key对应的value
	 * @param key
	 * @return value
	 */
	public String getString(String key) {
		return this.prop.getProperty(key);
	}
	
	/**
	 * 获取整数类型的配置项
	 * @param key
	 * @return value
	 */
	public  Integer getInteger(String key) {
		String value = getString(key);
		try {
			return Integer.valueOf(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	/**
	 * 获取布尔类型的配置项
	 * @param key
	 * @return value
	 */
	public Boolean getBoolean(String key) {
		String value = getString(key);
		try {
			return Boolean.valueOf(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 获取Long类型的配置项
	 * @param key
	 * @return
	 */
	public Long getLong(String key) {
		String value = getString(key);
		try {
			return Long.valueOf(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0L;
	}
	
}
