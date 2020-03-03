package redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import redis.clients.jedis.ShardedJedis;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring-redis.xml")
public class RedisTest
{
	@Autowired
	private RedistTempImpl redistTempImpl;

	@Test
	public void test()
	{
		ShardedJedis shardedJedis = redistTempImpl.getShardedJedis();
		System.out.println(shardedJedis.get("name"));
	}
}
