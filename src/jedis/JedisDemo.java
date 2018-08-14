package jedis;

import org.junit.Test;

import redis.clients.jedis.Jedis;

@SuppressWarnings("resource")
public class JedisDemo {
	
	
	@Test
	public void t1() throws Exception {
		Jedis jedis = new Jedis("101.132.175.237",6379);
		jedis.auth("password");	
		//string 
//		jedis.set("name","king");
	
		/**
		 * 列表  底层实现 linkedList
		 *  lpop 
		 *  lpush
		 *  
		 */
		
		Long len = jedis.llen("score");
		System.out.println(len);
		for (int i = 0; i < len; i++) {
			String l = jedis.lindex("score", i);
			System.out.println(l);
		}
		/**
		 * 集合 set
		 *  redis 的 Set 是 String 类型的无序集合。集合成员是唯一的，这就意味着集合中不能出现重复的数据。
			Redis 中集合是通过哈希表实现的，所以添加，删除，查找的复杂度都是 O(1)。
			1添加 sadd(key, members)
			2删除 spop(key) 移除并返回集合中的一个随机元素
			3修改
			4返回所有成员 	jedis.smembers(key)
			2总记录数 scard(key)
			srem(key, members) 移除集合中一个或多个成员
			jedis.sscan(key, cursor) 迭代集合中键的元素。
		 */
		
		
		/**
		 * 有序集合(sorted set)
		 * 	edis 有序集合和集合一样也是string类型元素的集合,且不允许重复的成员。
			不同的是每个元素都会关联一个double类型的分数。redis正是通过分数来为集合中的成员进行从小到大的排序。
			有序集合的成员是唯一的,但分数(score)却可以重复。
		 */
		
		/**
		 *  重要!!
		 * Redis 哈希(Hash)
			Redis hash 是一个string类型的field和value的映射表，hash特别适合用于存储对象。
			hmset object filed1 "value1" filed2 "value2" ...
		 */
		
		/**
		 * Redis 发布订阅
		 * 
		 * client1: SUBSCRIBE chanel1
		 * client2: PUBLISH chanel1 "哈哈哈哈哈"
		 * 
		 * # 订阅者的客户端(client1)会显示如下消息
				"message"
				"chanel1"
				"哈哈哈哈哈"			
		 */
	}

}
