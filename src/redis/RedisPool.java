package redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisPool
{
	private static JedisPool pool;

	private static Integer maxTotal = 20;// jedis�����������
	private static Integer maxIdle = 20;// jedis����������
	private static Integer minIdle = 1;// ��С������

	// ��borrowһ��jedisʵ����ʱ���Ƿ�Ҫ������֤�����������ֵtrue����õ���jedisʵ���϶��ǿ����õġ�
	private static Boolean testOnBorrow = true;
	// ��returnһ��jedisʵ����ʱ���Ƿ�Ҫ������֤�����������ֵtrue����Ż�jedispool��jedisʵ���϶��ǿ����õġ�
	private static Boolean testOnReturn = true;

	private static void initPool()
	{
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxIdle(maxIdle);
		config.setMinIdle(minIdle);

		config.setMaxTotal(maxTotal);

		config.setTestOnBorrow(testOnBorrow);
		config.setTestOnReturn(testOnReturn);

		// true��ʾ���������������ʱ���Ƿ��������ֱ������ʱ�䵽
		// false��ʾ���������������ʱ��ֱ���׳��쳣
		config.setBlockWhenExhausted(true);

		pool = new JedisPool(config, "127.0.0.1", 6379, 1000 * 2);

	}

	static
	{
		initPool();
	}

	public static Jedis getJedis()
	{
		return pool.getResource();
	}

	/**
	 * ��ִ��jedi�����쳣ʱ����
	 * 
	 * @param jedis
	 */
	public static void returnBrokenResource(Jedis jedis)
	{
		pool.returnBrokenResource(jedis);
	}

	/**
	 * ��ִ��jiedis��������ʱ����
	 * 
	 * @param jedis
	 */
	public static void returnResource(Jedis jedis)
	{
		pool.returnResource(jedis);
	}

	public static void main(String args[])
	{
		Jedis jedis = RedisPool.getJedis();
		String value = jedis.get("name");
		System.out.println(value);
		pool.destroy();// ������������
	}
}
