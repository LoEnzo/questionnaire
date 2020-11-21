package com.freefly.questionnaire.config;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import java.util.List;

/**
 * ProjectName:
 * ClassName:
 * Class Description:
 *
 * @Author hjwu
 * @Date2020/11/20 13:30
 */
public class MyPropertyPlaceholder extends PropertyPlaceholderConfigurer {

    private List<String> encryptPropNames;

    @Override
    protected String convertProperty(String propertyName, String propertyValue) {

        if (encryptPropNames.contains(propertyName)) {
            /**
             * 在这里做一些 加解密 操作
             */
//            return DESUtil.decrypt(propertyValue);
            AESUtil aesUtil = new AESUtil(false,"C:\\Users\\92826\\Desktop\\a1.properties");
            return aesUtil.decrypt(propertyValue);
        }

        return super.convertProperty(propertyName, propertyValue);
    }

    public List<String> getEncryptPropNames() {
        return encryptPropNames;
    }

    public void setEncryptPropNames(List<String> encryptPropNames) {
        this.encryptPropNames = encryptPropNames;
    }
}
