package com.alkenarts.usermanagement.util;

public enum ValidationUtil {
	VALIDATION_HELPER;

	public boolean isEmpty(String str) {
		return (null == str || "".equals(str));
	}

}
