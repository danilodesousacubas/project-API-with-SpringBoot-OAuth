package br.com.retail.security.utils;

import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;

public final class AuthorizationUtils {

	private AuthorizationUtils(){}
	
	private static Logger logger = Logger.getLogger(AuthorizationUtils.class);
	
	public synchronized static String encodeStringToBase64(String stringToEncode){
		byte[] plainBasicTokenBytes = stringToEncode.getBytes();
		byte[] base64BasicTokenBytes = Base64.encodeBase64(plainBasicTokenBytes);
		String base64BasicToken = "";
		try {
			base64BasicToken = new String(base64BasicTokenBytes, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			logger.error("Error on encodeStringToBase64.");
			logger.error(e, e);
		}
		return base64BasicToken;
	}
	
	public synchronized static String encodeBytesToBase64(byte[] bytesToEncode){
		byte[] base64BasicTokenBytes = Base64.encodeBase64(bytesToEncode);
		String base64BasicToken = "";
		try {
			base64BasicToken = new String(base64BasicTokenBytes, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			logger.error("Error on encodeBytesToBase64.");
			logger.error(e, e);
		}
		return base64BasicToken;
	}
	
	public synchronized static byte[] decodeBytesFromBase64(byte[] bytesToDecode){
		return Base64.decodeBase64(bytesToDecode);
	}
}
