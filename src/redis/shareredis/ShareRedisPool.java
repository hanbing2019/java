package redis.shareredis;

import java.util.ArrayList;
import java.util.List;

import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;
import redis.clients.util.Hashing;
import redis.clients.util.Sharded;

public class ShareRedisPool
{
	private static ShardedJedisPool pool;
	// private static JedisPool pool;

	private static Integer maxTotal = 20;// jedis�����������
	private static Integer maxIdle = 20;// jedis����������
	private static Integer minIdle = 1;// ��С������

	// ��borrowһ��jedisʵ����ʱ���Ƿ�Ҫ������֤�����������ֵtrue����õ���jedisʵ���϶��ǿ����õġ�
	private static Boolean testOnBorrow = true;
	// ��returnһ��jedisʵ����ʱ���Ƿ�Ҫ������֤�����������ֵtrue����Ż�jedispool��jedisʵ���϶��ǿ����õġ�
	private static Boolean testOnReturn = true;

	private static String redisIp1 = "127.0.0.1";
	private static int port1 = 6379;

	private static String redisIp2 = "127.0.0.1";
	private static int port2 = 6380;

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

		JedisShardInfo jsi1 = new JedisShardInfo(redisIp1, port1, 1000 * 2);

		JedisShardInfo jsi2 = new JedisShardInfo(redisIp2, port2, 1000 * 2);

		List<JedisShardInfo> list = new ArrayList<JedisShardInfo>(2);
		list.add(jsi2);
		list.add(jsi1);

		pool = new ShardedJedisPool(config, list, Hashing.MURMUR_HASH,
				Sharded.DEFAULT_KEY_TAG_PATTERN);

	}

	static
	{
		initPool();
	}

	public static ShardedJedis getJedis()
	{
		return pool.getResource();
	}

	/**
	 * ��ִ��jedi�����쳣ʱ����
	 * 
	 * @param jedis
	 */
	public static void returnBrokenResource(ShardedJedis jedis)
	{
		pool.returnBrokenResource(jedis);
	}

	/**
	 * ��ִ��jiedis��������ʱ����
	 * 
	 * @param jedis
	 */
	public static void returnResource(ShardedJedis jedis)
	{
		pool.returnResource(jedis);
	}

	public static void main(String args[])
	{

		try
		{
			ShardedJedis jedis = pool.getResource();
			for (int i = 0; i < 10; i++)
			{
				jedis.set("key" + i, "value" + i);
			}
			returnResource(jedis);
		} catch (Exception e)
		{
			e.printStackTrace();
		}

	}
}
