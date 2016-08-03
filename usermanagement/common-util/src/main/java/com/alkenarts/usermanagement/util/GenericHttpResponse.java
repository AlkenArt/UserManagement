package com.alkenarts.usermanagement.util;

public class GenericHttpResponse {

	private int statusCode;
	private String statusText;
	private String responseBody;

	/**
	 * @param statusCode
	 * @param statusText
	 * @param responseBody
	 */
	public GenericHttpResponse(int statusCode, String statusText,
			String responseBody) {
		super();
		this.statusCode = statusCode;
		this.statusText = statusText;
		this.responseBody = responseBody;
	}

	/**
	 * @return the statusCode
	 */
	public int getStatusCode() {
		return statusCode;
	}

	/**
	 * @return the statusText
	 */
	public String getStatusText() {
		return statusText;
	}

	/**
	 * @return the responseBody
	 */
	public String getResponseBody() {
		return responseBody;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "GenericHttpResponse [statusCode=" + statusCode
				+ ", statusText=" + statusText + ", responseBody="
				+ responseBody + "]";
	}

}
