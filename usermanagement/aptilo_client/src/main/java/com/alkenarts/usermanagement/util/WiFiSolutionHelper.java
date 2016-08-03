package com.alkenarts.usermanagement.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;

public class WiFiSolutionHelper {

	public static List<String> generateAccessCode(int count) {
		List<String> accessCodes = new ArrayList<String>();
		String alphabet = "bcdfghjklmnpqrstvwxz";

		for (int index = 0; index < count; index++) {
			String accessCode = RandomStringUtils.random(6, alphabet);
			accessCodes.add(accessCode);
		}
		return accessCodes;
	}

	public static String convertDateFromJS(String str) throws ParseException {
		DateFormat formatter = new SimpleDateFormat("EEE MMM dd yyyy HH:mm:ss Z");
		Date date = (Date) formatter.parse(str);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return df.format(date);
	}
	
	public static String convertToString(String value) {

		try {
			long time = Long.parseLong(value);

			Date date = new Date(time * 1000);
			String sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
					.format(date);
			return sdf;
		} catch (Exception e) {

		}
		return value;
	}
}
