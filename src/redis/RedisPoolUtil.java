package redis;

import redis.clients.jedis.Jedis;

public class RedisPoolUtil
{

	/**
	 * 执行set命令
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public static String set(String key, String value)
	{
		String result = null;
		Jedis jedis = RedisPool.getJedis();
		result = jedis.set(key, value);
		RedisPool.returnResource(jedis);

		return result;

	}

	/**
	 * 执行get命令
	 * 
	 * @param key
	 * @return
	 */
	public static String get(String key)
	{
		String value = null;
		Jedis jedis = RedisPool.getJedis();
		value = jedis.get(key);
		RedisPool.returnResource(jedis);
		return value;
	}

	/**
	 * 执行redis的setEx命令
	 * 
	 * extime的单位是秒
	 * 
	 * @param key
	 * @param value
	 * @param exTime
	 * @return
	 */
	public static String setEx(String key, String value, int exTime)
	{
		String result = null;
		Jedis jedis = RedisPool.getJedis();
		result = jedis.setex(key, exTime, value);
		RedisPool.returnResource(jedis);

		return result;

	}

	/**
	 * 执行expire命令，时间单位是秒
	 * 
	 * expire命令设置key的有效时间
	 * 
	 * @param key
	 * @param exTime
	 * @return
	 */
	public static Long expire(String key, int exTime)
	{
		Long result = null;
		Jedis jedis = RedisPool.getJedis();
		result = jedis.expire(key, exTime);
		RedisPool.returnResource(jedis);

		return result;
	}

	/**
	 * 删除key
	 * 
	 * @param key
	 * @return
	 */
	public static Long del(String key)
	{
		Long result = null;
		Jedis jedis = RedisPool.getJedis();
		result = jedis.del(key);
		RedisPool.returnResource(jedis);

		return result;
		// java.util.concurrent
	}
}
