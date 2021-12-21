package com.cvk.lc.common;

import java.util.regex.Pattern;

public class RegexUtil {
	
	private RegexUtil() {
		super();
	}

	public static boolean anyMatch(String regex, String text) {
	    Pattern pattern = Pattern.compile(regex);
	    return pattern.matcher(text).find();
	}
}
