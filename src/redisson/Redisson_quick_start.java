package redisson;

import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;
import org.redisson.Redisson;
import org.redisson.api.RKeys;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

public class Redisson_quick_start {
	
	@Test
	public void testName() throws Exception {
		//创建配置
		Config config = new Config();	 
		//指定使用单节点部署方式
		config.useSingleServer().setAddress("redis://101.132.175.237:6379");

		config.useSingleServer().setPassword("password");
		config.useSingleServer().setConnectionPoolSize(500);//设置对于master节点的连接池中连接数最大为500
		config.useSingleServer().setIdleConnectionTimeout(10000);//如果当前连接池里的连接数量超过了最小空闲连接数，而同时有连接空闲时间超过了该数值，那么这些连接将会自动被关闭，并从连接池里去掉。时间单位是毫秒。
		config.useSingleServer().setConnectTimeout(30000);//同任何节点建立连接时的等待超时。时间单位是毫秒。
		config.useSingleServer().setTimeout(3000);//等待节点回复命令的时间。该时间从命令发送成功时开始计时。
		config.useSingleServer().setPingTimeout(30000);
		//config.useSingleServer().setReconnectionTimeout(3000);//当与某个节点的连接断开时，等待与其重新建立连接的时间间隔。时间单位是毫秒。
		 
		// 2. Create Redisson instance
		RedissonClient redisson = Redisson.create(config);

		// 3. Get object you need
		RKeys keys = redisson.getKeys();
		long count = keys.count();
		System.out.println(count);
		
//		RMap<Object, Object> map = redisson.getMap("hello");
//		map.put(1, "one");
//		map.put(2, "two");
//		map.put(3, "three");
		

		
		RMap<Object, Object> map2 = redisson.getMap("hello");
		Set<Entry<Object, Object>> entrySet = map2.entrySet();
		for (Entry<Object, Object> entry : entrySet) {
			Object key = entry.getKey();
			Object value = entry.getValue();
			System.out.println(key+":"+value);
		}
		//RLock lock = redisson.getLock("myLock");

		//RExecutorService executor = redisson.getExecutorService("myExecutorService");
	}

}
