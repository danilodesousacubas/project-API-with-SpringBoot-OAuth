package br.com.retail.security.utils;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public final class CryptUtils {
	private CryptUtils(){}
	
	public static Cipher buildCipher(String pass, int mode) 
    		throws NoSuchAlgorithmException, NoSuchPaddingException {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        return cipher;
      }
	
    public static SecretKeySpec buildKey() throws NoSuchAlgorithmException, UnsupportedEncodingException {
    	byte[] keyData = "S3cr3t".getBytes("UTF-8");
        SecretKeySpec spec = new SecretKeySpec(keyData, "AES");
        return spec;
    }
}
