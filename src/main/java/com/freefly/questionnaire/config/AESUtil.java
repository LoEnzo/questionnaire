package com.freefly.questionnaire.config;

import lombok.extern.slf4j.Slf4j;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.util.regex.Pattern;

/**
 * ProjectName：ota-utils
 * ClassName：AESUtil
 *
 * @author：xiongxh
 * @date：10:59 2018/6/4
 * modifier：xiongxh
 * modify time：10:59 2018/6/4
 * Modify Remark：
 */
@Slf4j
public class AESUtil {

    private final String AES_CHARSET = "UTF-8";
    /**
     * 加解密算法/模式/填充方式
     */
    private final String KEY_AES = "AES/CBC/PKCS5Padding";
    /**
     * 算法名称
     */
    final String KEY_ALGORITHM = "AES";

    private String key;
    private Integer secretKeySize;

    private static final Pattern NUM_PATTERN = Pattern.compile("^[-\\+]?[\\d]*$");


    /**
     * secretKeySize
     */
    private String ivParameter;

    /**
     * 创建新的实例 AESUtil.
     * @param propertyName
     */
    public AESUtil(String propertyName){
        // 初始化key
        readKeyFromProperty(true, propertyName);
    }

    /**
     * 创建新的实例 AESUtil.
     * @param propertyFileInWar 属性文件是否在War包中
     * @param propertyFilePath 属性文件路径
     */
    public AESUtil(boolean propertyFileInWar, String propertyFilePath) {
        // 初始化key
        readKeyFromProperty(propertyFileInWar, propertyFilePath);
    }

    /**
     * 创建新的实例 AESUtil.
     * @param propertyFileInWar 属性文件是否在War包中
     * @param propertyFilePath 属性文件路径
     */
    public AESUtil(boolean propertyFileInWar, String propertyFilePath, boolean ivParameterInd) {
        // 初始化key
        PropertiesAccess propertiesAccess = new PropertiesAccess(propertyFileInWar, propertyFilePath);
        key = propertiesAccess.getKey("AESedeCodeKey", true);
        String secretKeySizeStr = propertiesAccess.getKey("SecretKeySize", true);
        ivParameter = propertiesAccess.getKey("IvParameter", true);
        if (isInteger(secretKeySizeStr)) {
            secretKeySize = Integer.valueOf(secretKeySizeStr);
        } else {
            //使用默认的128位加密
            secretKeySize = 128;
        }
    }

    /**
     * readKeyFromProperty: 从配置文件中读取key
     *
     * @param propertyFileInWar 属性文件是否在War包中
     * @param propertyFilePath  属性文件路径
     */
    private void readKeyFromProperty(boolean propertyFileInWar, String propertyFilePath) {
        PropertiesAccess propertiesAccess = new PropertiesAccess(propertyFileInWar, propertyFilePath);
        key = propertiesAccess.getKey("AESedeCodeKey", true);
        String secretKeySizeStr = propertiesAccess.getKey("SecretKeySize", true);
        if (isInteger(secretKeySizeStr)) {
            secretKeySize = Integer.valueOf(secretKeySizeStr);
        } else {
            //使用默认的128位加密
            secretKeySize = 128;
        }
    }

    /**
     *
     * 功能描述: isInteger 判断是否是数字
     * @param: [str]
     * @return: boolean
     * @auther: xiongxh
     * @date: 2018/6/5 10:12
     */
    public static boolean isInteger(String str) {
        return NUM_PATTERN.matcher(str).matches();
    }
    /**
     * 加密
     *
     * @param data 需要加密的内容
     * @return
     */
    public String encrypt(String data) {
        return doAES(data, key, Cipher.ENCRYPT_MODE, ivParameter);
    }

    /**
     * 解密
     *
     * @param data 待解密内容
     * @return
     */
    public String decrypt(String data) {
        return doAES(data, key, Cipher.DECRYPT_MODE, ivParameter);
    }

    /**
     * 加解密
     *
     * @param data 待处理数据
     * @param key 密钥
     * @param mode 加解密mode
     * @return
     */
    private String doAES(String data, String key, int mode, String ivParameter) {
        try {
            if (null == data || null == key) {
                return null;
            }
            //判断是加密还是解密
            boolean encrypt = mode == Cipher.ENCRYPT_MODE;
            byte[] content;
            //true 加密内容 false 解密内容
            if (encrypt) {
                content = data.getBytes(AES_CHARSET);
            } else {
                content = parseHexStr2Byte(data);
            }
            //1.构造密钥生成器，指定为AES算法,不区分大小写
            KeyGenerator kgen = KeyGenerator.getInstance(KEY_ALGORITHM);
            //2.根据ecnodeRules规则初始化密钥生成器
            //生成一个128位的随机源,根据传入的字节数组
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            random.setSeed(key.getBytes());
            kgen.init(secretKeySize, random);
            //3.产生原始对称密钥
            SecretKey secretKey = kgen.generateKey();
            //4.获得原始对称密钥的字节数组
            byte[] enCodeFormat = secretKey.getEncoded();
            //5.根据字节数组生成AES密钥
            SecretKeySpec keySpec = new SecretKeySpec(enCodeFormat, KEY_ALGORITHM);
            //6.根据指定算法AES自成密码器
            Cipher cipher = null;
            //7.初始化密码器，第一个参数为加密(Encrypt_mode)或者解密解密(Decrypt_mode)操作，第二个参数为使用的KEY
            if (null == ivParameter) {
                cipher = Cipher.getInstance(KEY_AES);// 创建密码器
                cipher.init(mode, keySpec,  new IvParameterSpec(ivParameter.getBytes()));// 初始化
            } else {
                cipher = Cipher.getInstance(KEY_ALGORITHM);// 创建密码器
                cipher.init(mode, keySpec);// 初始化
            }
            byte[] result = cipher.doFinal(content);
            if (encrypt) {
                //将二进制转换成16进制
                return parseByte2HexStr(result);
            } else {
                return new String(result, AES_CHARSET);
            }
        } catch (Exception e) {
            log.error("AES 密文处理异常", e);
        }
        return null;
    }
    /**
     * 将二进制转换成16进制
     *
     * @param buf
     * @return
     */
    public String parseByte2HexStr(byte[] buf) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }
    /**
     * 将16进制转换为二进制
     *
     * @param hexStr
     * @return
     */
    public byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1) {
            return null;
        }
        byte[] result = new byte[hexStr.length() / 2];
        for (int i = 0; i < hexStr.length() / 2; i++) {
            int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
            int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }
}
