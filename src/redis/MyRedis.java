package redis;

import java.util.ArrayList;
import java.util.List;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

public class MyRedis
{
	public static void main(String args[])
	{
		// 创建jedis对象，构造函数参数1：ip地址，2端口
		Jedis jedis = new Jedis("127.0.0.1", 6379);

		// 配置文件中设置了密码时，需要认证
		// jedis.auth("");
		// 获取string类型数据
		String name = jedis.get("name");
		// 设置string类型数据
		jedis.set("key", "value");
		// jedis.setex("d", seconds, value)

		System.out.println(jedis.get("key"));
		System.out.println(name);
		initialShardedPool();
	}

	// redis默认是单据环境使用的，数据量较大是需要使用多机环境这个时候就需要ShardedJedis
	// ShardedJedis是基于一致性哈希算法实现的分布式Redis集群客户端
	private void initialPool()
	{
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxTotal(20);// 设置最大连接池
		config.setMaxIdle(5);// 设置最小连接池
		config.setMaxWaitMillis(1000l);// 设置等待时间
		config.setTestOnBorrow(false);

		// new JedisPool(config, "127.0.0.1", 6379, 2000, "password");
		// 当有密码时，创建连接池要用带有密码的构造函数
		JedisPool jedisPool = new JedisPool(config, "127.0.0.1", 6379);

		Jedis jedis = jedisPool.getResource();

	}

	// redis默认是单据环境使用的，数据量较大是需要使用多机环境这个时候就需要ShardedJedis
	// ShardedJedis是基于一致性哈希算法实现的分布式Redis集群客户端
	private static void initialShardedPool()
	{
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxTotal(20);
		config.setMaxIdle(5);
		config.setMaxWaitMillis(1000l);
		config.setTestOnBorrow(false);
		List<JedisShardInfo> shards = new ArrayList<JedisShardInfo>();

		shards.add(new JedisShardInfo("127.0.0.1", 6379, "master"));

		ShardedJedisPool shardedJedisPool = new ShardedJedisPool(config, shards);
		ShardedJedis shardedJedis = shardedJedisPool.getResource();
		System.out.println(shardedJedis.exists("name"));// 判断是否存在key值name,返回true,false
		System.out.println(shardedJedis.get("name"));

	}

	public void test()
	{

	}
}
