package redis;

import redis.clients.jedis.Jedis;

public class RedisPoolUtil
{

	/**
	 * ִ��set����
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
	 * ִ��get����
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
	 * ִ��redis��setEx����
	 * 
	 * extime�ĵ�λ����
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
	 * ִ��expire���ʱ�䵥λ����
	 * 
	 * expire��������key����Чʱ��
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
	 * ɾ��key
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
