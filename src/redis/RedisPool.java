package redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisPool
{
	private static JedisPool pool;

	private static Integer maxTotal = 20;// jedis的最大连接数
	private static Integer maxIdle = 20;// jedis的最大空闲数
	private static Integer minIdle = 1;// 最小空闲数

	// 在borrow一个jedis实例的时候，是否要进行验证操作，如果赋值true。则得到的jedis实例肯定是可以用的。
	private static Boolean testOnBorrow = true;
	// 在return一个jedis实例的时候，是否要进行验证操作，如果赋值true。则放回jedispool的jedis实例肯定是可以用的。
	private static Boolean testOnReturn = true;

	private static void initPool()
	{
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxIdle(maxIdle);
		config.setMinIdle(minIdle);

		config.setMaxTotal(maxTotal);

		config.setTestOnBorrow(testOnBorrow);
		config.setTestOnReturn(testOnReturn);

		// true表示到达最大连接数的时候是否进入阻塞直到阻塞时间到
		// false表示到达最大连接数的时候直接抛出异常
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
	 * 当执行jedi命令异常时调用
	 * 
	 * @param jedis
	 */
	public static void returnBrokenResource(Jedis jedis)
	{
		pool.returnBrokenResource(jedis);
	}

	/**
	 * 当执行jiedis命令正常时调用
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
		pool.destroy();// 销毁所有连接
	}
}
