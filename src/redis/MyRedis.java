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
		// ����jedis���󣬹��캯������1��ip��ַ��2�˿�
		Jedis jedis = new Jedis("127.0.0.1", 6379);

		// �����ļ�������������ʱ����Ҫ��֤
		// jedis.auth("");
		// ��ȡstring��������
		String name = jedis.get("name");
		// ����string��������
		jedis.set("key", "value");
		// jedis.setex("d", seconds, value)

		System.out.println(jedis.get("key"));
		System.out.println(name);
		initialShardedPool();
	}

	// redisĬ���ǵ��ݻ���ʹ�õģ��������ϴ�����Ҫʹ�ö���������ʱ�����ҪShardedJedis
	// ShardedJedis�ǻ���һ���Թ�ϣ�㷨ʵ�ֵķֲ�ʽRedis��Ⱥ�ͻ���
	private void initialPool()
	{
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxTotal(20);// ����������ӳ�
		config.setMaxIdle(5);// ������С���ӳ�
		config.setMaxWaitMillis(1000l);// ���õȴ�ʱ��
		config.setTestOnBorrow(false);

		// new JedisPool(config, "127.0.0.1", 6379, 2000, "password");
		// ��������ʱ���������ӳ�Ҫ�ô�������Ĺ��캯��
		JedisPool jedisPool = new JedisPool(config, "127.0.0.1", 6379);

		Jedis jedis = jedisPool.getResource();

	}

	// redisĬ���ǵ��ݻ���ʹ�õģ��������ϴ�����Ҫʹ�ö���������ʱ�����ҪShardedJedis
	// ShardedJedis�ǻ���һ���Թ�ϣ�㷨ʵ�ֵķֲ�ʽRedis��Ⱥ�ͻ���
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
		System.out.println(shardedJedis.exists("name"));// �ж��Ƿ����keyֵname,����true,false
		System.out.println(shardedJedis.get("name"));

	}

	public void test()
	{

	}
}
