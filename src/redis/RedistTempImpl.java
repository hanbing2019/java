package redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

@Repository("redistTempImpl")
public class RedistTempImpl implements RedistTemp
{

	@Autowired
	private ShardedJedisPool shardedJedisPool;

	@Override
	public ShardedJedis getShardedJedis()
	{
		return shardedJedisPool.getResource();
	}
}
