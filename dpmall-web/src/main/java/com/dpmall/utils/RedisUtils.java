package com.dpmall.utils;

import redis.clients.jedis.Jedis;



public class RedisUtils {
	
	private static Jedis jedis;
	
	
	public static Jedis getClient() {
		if (jedis==null) {
			return new Jedis("localhost",6379);
		}
		else {
			return jedis;
		}
	}   
}
