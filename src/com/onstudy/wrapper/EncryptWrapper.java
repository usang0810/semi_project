package com.onstudy.wrapper;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import com.oreilly.servlet.MultipartRequest;

public class EncryptWrapper extends HttpServletRequestWrapper{

	public EncryptWrapper(HttpServletRequest request) {
		super(request);
	}
	
//	public EncryptWrapper(MultipartRequest multiRequest) {
//		super((HttpServletRequest) multiRequest);
//	}

	@Override				
	public String getParameter(String key) {
		
		String value="";
		
		if(key != null && (key.equals("inputPassword") || 
						   key.equals("changePwd-input-pwd1") ||
						   key.equals("signupPwd") ||
						   key.equals("newPwd1") ||
						   key.equals("pwd1") )) {

			value = getSha512(super.getParameter(key));
		} else {
			value=super.getParameter(key);
		}
		return value;
	}


	/** SHA-512 해시함수를 이용하여 암호화하는 메소드
	 * @param pwd
	 * @return encPwd
	 */
	public static String getSha512(String pwd) {
		String encPwd = null;
		
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-512");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		byte[] bytes = pwd.getBytes(Charset.forName("UTF-8"));
		
		md.update(bytes);
		
		encPwd = Base64.getEncoder().encodeToString(md.digest());
		
		return encPwd;
	}
}
