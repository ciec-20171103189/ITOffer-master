package cn.edu.imnu.ITOffer.DButil;

import java.io.UnsupportedEncodingException;

import org.apache.tomcat.util.codec.binary.Base64;

public class CookieEncryptTool {
	public static String encodeBase64(String cleartext) {
		try {
			cleartext = new String (Base64.encodeBase64(cleartext.getBytes("UTF-8")));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cleartext;
	}
	
	public static String  decodeBase64(String ciphertexttext) {
		try {
			ciphertexttext = new String(Base64.decodeBase64(ciphertexttext.getBytes()),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ciphertexttext;
	}
	
	public static void main(String[] args) {
		String Testtext = new String();
		Testtext = encodeBase64("Sunny");
		System.out.println(Testtext);
		System.out.println(decodeBase64(Testtext));
	}
}
