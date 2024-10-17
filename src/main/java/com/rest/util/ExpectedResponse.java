package com.rest.util;

import static org.apache.http.HttpStatus.SC_CREATED;
import static org.apache.http.HttpStatus.SC_OK;
import static org.apache.http.HttpStatus.SC_UNAUTHORIZED;
import static org.apache.http.HttpStatus.SC_METHOD_NOT_ALLOWED;

public class ExpectedResponse {

	/*
	 * // Any response code ANY(-1),
	 * 
	 * // 2xx Response Codes
	 *//** 200 **/
	/*
	 * OK(SC_OK),
	 *//** 201 **/
	/*
	 * CREATED(SC_CREATED),
	 *//** 202 **/
	/*
	 * ACCEPTED(SC_ACCEPTED),
	 *//** 204 **/
	/*
	 * DELETED(SC_NO_CONTENT),
	 * 
	 * // 4xx Response Codes
	
	 *
	 *//** 400 **/
	/*
	 * BAD_REQUEST(SC_BAD_REQUEST),
	
	 *//** 401 **/
	/*
	 * UNAUTHORIZED(SC_UNAUTHORIZED),
	
	 *//** 403 **/
	/*
	 * FORBIDDEN(SC_FORBIDDEN),
	 
	 *//** 404 **/
	/*
	 * NOT_FOUND(SC_NOT_FOUND),
	 
	 *//** 405 **/
	/*
	 * METHOD_NOT_ALLOWED(SC_METHOD_NOT_ALLOWED),
	
	 *//** 406 **/
	/*
	 * NOT_ACCEPTABLE(SC_NOT_ACCEPTABLE),
	 
	 *//** 409 **/
	/*
	 * CONFLICT(SC_CONFLICT),
	
	 *//** 413 **/
	/*
	 * REQUEST_TOO_LONG(SC_REQUEST_TOO_LONG),
	
	 *//** 415 **/
	/*
	 * UNSUPPORTED_MEDIA_TYPE(SC_UNSUPPORTED_MEDIA_TYPE),
	
	 *//** 422 **/
	/*
	 * UNPROCESSABLE_ENTITY(SC_UNPROCESSABLE_ENTITY),
	
	 *//** 423 **/
	/*
	 * LOCKED(SC_LOCKED),
	 * 
	 * // 5xx Response Codes
	
	 *//** 503 **/
	/*
	 * SERVICE_UNAVAILABLE(SC_SERVICE_UNAVAILABLE),
	 
	 *//** 504 **//*
	* GATEWAY_TIMEOUT(SC_GATEWAY_TIMEOUT);
					 */
	
	

	public static final Integer OK_RESPONSE = SC_OK;
	public static final Integer CREATED = SC_CREATED;
	public static final Integer UNAUTHORIZED = SC_UNAUTHORIZED;
	public static final Integer NOT_ALLOWED = SC_METHOD_NOT_ALLOWED;
}
