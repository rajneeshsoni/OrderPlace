package com.order.orderplace.api.util;
import org.springframework.stereotype.Service;

@Service
public class ApiConstants {
	
	public static final String JWT_HEADER_KEY = "Authorization"; // header to be sent containing JWT
	public static final String JWT_HEADER_VALUE_PREFIX = "Bearer "; // prefix JWT value (mind the space)
	
	public static final Integer JWT_VALIDITY = 60 * 30; // JWT validity period in seconds - 30 minutes

	public static final String JWT_SECRET_KEY = "secret"; // Shouldn't change unless necessary


}
