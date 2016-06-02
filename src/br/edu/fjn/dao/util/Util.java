package br.edu.fjn.dao.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {
	@SuppressWarnings("unused")
	public static String criotograph(String message) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		StringBuilder hexString = new StringBuilder();
		try {
			MessageDigest algorithm = MessageDigest.getInstance("sha-256");
			byte messageDigest[] = algorithm.digest(message.getBytes("UTF-8"));

			hexString = new StringBuilder();
			for (byte b : messageDigest) {
				hexString.append(String.format("%02X", 0xFF & b));
			}
		} catch (NoSuchAlgorithmException e) {
			// TODO: handle exception
		}catch (UnsupportedEncodingException e) {
			// TODO: handle exception
		}
		
		return hexString.toString();
	}
	@SuppressWarnings("unused")
	public static Date modifyDate(String string) throws ParseException {
		SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
		formater.setLenient(false);
		Date date = formater.parse(string);
		return date;
	}
}
