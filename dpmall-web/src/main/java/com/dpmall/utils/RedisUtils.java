package com.dpmall.utils;

import redis.clients.jedis.Jedis;

public class RedisUtils {
	private static Jedis jedis = null; 
	
	private static final String HOST = "localhost";
	
	private static final Integer PORT = 6379;
	
	public static Jedis getClient() {
		if (jedis==null) {
			return new Jedis(HOST, PORT);
		}
		else {
			return jedis;
		}
	}   
}
