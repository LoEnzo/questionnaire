package com.freefly.questionnaire.config;
/**
 * Copyright (C) 2017-2019 Travelsky Technology Limited Ltd.
 *
 * All right reserved.
 *
 * This software is the confidential and proprietary
 * information of Travelsky  of China.
 * ("Confidential Information"). You shall not disclose
 * such Confidential Information and shall use it only
 * in accordance with the terms of the contract agreement
 * you entered into with Travelsky inc.
 *
 */
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 可以通过配置文件配置properties属性文件路径，注入本类实例中。
 * @author MAYUE
 *
 */
public class PropertiesAccess {
	/**
	 * 配置信息
	 */
	private Properties properties;
	/**
	 * 文件路径
	 */
	private String filePath;
	
	public PropertiesAccess(){}

    /**
     * 根据配置文件相对路径 加载Properties
     *
     * @param filePath 属性文件路径
     */
    public PropertiesAccess(String filePath) {
        this.filePath = filePath;
        init();
    }

    /**
     * 根据配置文件相对路径 加载Properties
     *
     * @param propertyFileInWar 属性文件是否在War包中
     * @param propertyFilePath 属性文件路径
     */
    public PropertiesAccess(boolean propertyFileInWar, String propertyFilePath) {
        this.filePath = propertyFilePath;
        if (propertyFileInWar) {
            init();
            return;
        }

        try (InputStream is = new FileInputStream(propertyFilePath)) {
            Properties prop = new Properties();
            prop.load(is);
            this.properties = prop;
        } catch (IOException ex) {
            throw new RuntimeException("属性文件不存在！The file is " + filePath);
        }
    }

    private void init() {
        try (InputStream is = PropertiesAccess.class.getClassLoader().getResourceAsStream(filePath)) {
            if (is == null) {
                throw new RuntimeException("属性文件不存在！The file is " + filePath);
            }
            Properties prop = new Properties();
            prop.load(is);
            this.properties = prop;
        } catch (IOException ex) {
            throw new RuntimeException("属性文件不存在！The file is " + filePath);
        }
    }

    /**
     * 从Property文件中获取key对应的值
     * @param key
     * @param throwable 在获取不到key对应的值时，是否抛出异常
     * @return
     */
    public String getKey(String key, boolean throwable){
    	String value = null;
    	value = properties.getProperty(key);
    	if (value == null || value == ""){
			if (throwable){
				RuntimeException dal = new RuntimeException("属性文件中不存在此配置！Detail:"  + filePath + " of " + key);
	                throw dal;
			}
		}
    
		return value;
    }

}
