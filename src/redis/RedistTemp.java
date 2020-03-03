package redis;

import redis.clients.jedis.ShardedJedis;

public interface RedistTemp
{
	public ShardedJedis getShardedJedis();
}
