package com.carfax.payload;

/**
 * Response for the kata service.
 * 
 * @author Mallikarjun Nuti
 *
 */
public class KataResponse {
	public KataResponse() {
		this(null);
	}

	public KataResponse(String response) {
		this.response = response;
	}

	/*
	 * Response value
	 */
	private String response;

	/**
	 * @return the response
	 */
	public String getResponse() {
		return response;
	}

	/**
	 * @param response
	 *            the response to set
	 */
	public void setResponse(String response) {
		this.response = response;
	}

}
