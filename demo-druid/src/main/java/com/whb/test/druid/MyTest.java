package com.whb.test.druid;

import org.jasypt.encryption.StringEncryptor;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

/**
 * @author bean wanghb_prm@si-tech.com.cn
 * @Title MyTest.java
 * @Project demo-druid
 * @Description
 * @create 2018-07-25
 */
public class MyTest implements StringEncryptor {

    private static final String ALGO = "AES";

    private static final String DEFAULT_ENCODING = "UTF-8";
    private static final char[] DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    private static final String DEFAULT_SALT = "__O2O__NO1__";
    private static final String SALT_PREFIX = "@@";
    private static final String SALT_SUFFIX = "##";

    private String password;
    private String salt = DEFAULT_SALT;

    protected String getProcessedSalt() {
        return SALT_PREFIX + salt + SALT_SUFFIX;
    }

    @Override
    public String encrypt(String s) {
        try {
            Cipher cipher = Cipher.getInstance(ALGO);
            Key key = new SecretKeySpec(getProcessedSalt().getBytes(DEFAULT_ENCODING), ALGO);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            return new String(encodeHex(cipher.doFinal(s.getBytes(DEFAULT_ENCODING))));
        } catch (Exception e) {
            throw new IllegalStateException("failed to encrypt password.", e);
        }
    }

    @Override
    public String decrypt(String s) {
        try {
            Cipher cipher = Cipher.getInstance(ALGO);
            Key key = new SecretKeySpec(getProcessedSalt().getBytes(DEFAULT_ENCODING), ALGO);
            cipher.init(Cipher.DECRYPT_MODE, key);
            return new String(cipher.doFinal(decodeHex(s.toCharArray())), DEFAULT_ENCODING);
        } catch (Exception e) {
            throw new IllegalStateException("failed to decrypt password.", e);
        }
    }


    protected char[] encodeHex(byte[] data) {
        int l = data.length;
        char[] out = new char[l << 1];
        for (int i = 0, j = 0; i < l; i++) {
            out[j++] = DIGITS[(0xF0 & data[i]) >>> 4];
            out[j++] = DIGITS[0x0F & data[i]];
        }
        return out;
    }

    public byte[] decodeHex(char[] data) {
        int len = data.length;
        if ((len & 0x01) != 0) {
            throw new IllegalStateException("Odd number of characters.");
        }

        byte[] out = new byte[len >> 1];
        for (int i = 0, j = 0; j < len; i++) {
            int f = toDigit(data[j], j) << 4;
            j++;
            f = f | toDigit(data[j], j);
            j++;
            out[i] = (byte) (f & 0xFF);
        }
        return out;
    }

    protected int toDigit(char ch, int index) {
        int digit = Character.digit(ch, 16);
        if (digit == -1) {
            throw new IllegalStateException("Illegal hexadecimal character " + ch + " at index " + index);
        }
        return digit;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
