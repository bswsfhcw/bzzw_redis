package com.youotech.bzzw.redis;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.youotech.bzzw.Application;
import com.youotech.bzzw.util.RedisUtil;


@RunWith(SpringRunner.class)
@SpringBootTest(classes=Application.class)
public class RedisUtilTest {
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private RedisUtil redisUtil;
	@Test
    public void testExpire() {
		Long timeOut = 2L;
		redisUtil.del("timeOut");
		LOGGER.info(redisUtil.getExpire("timeOut")+"");
		redisUtil.expire("timeOut", timeOut);
		LOGGER.info(redisUtil.getExpire("timeOut")+"");
		redisUtil.set("timeOut", "00000");
		redisUtil.expire("timeOut", timeOut);
		LOGGER.info(redisUtil.getExpire("timeOut")+"");
		LOGGER.info(redisUtil.hasKey("timeOut")+"");
		try {
			Thread.sleep(timeOut*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LOGGER.info(timeOut+"秒之后"+redisUtil.hasKey("timeOut")+"");
    }
	
	@Test
    public void testStringGetSet() {
		String[] keysAll = {"String","String1","String2","String3"};
		String[] keys = {"String1","String2","String3"};
		redisUtil.del(keysAll);
		LOGGER.info(redisUtil.hasKey("String1")+"");
		redisUtil.set("String", "00000");
		redisUtil.set("String1", "11111");
		redisUtil.set("String2", "22222");
		redisUtil.set("String3", "22222");
		LOGGER.info(redisUtil.hasKey("String1")+"");
		redisUtil.del(keys);
		LOGGER.info(redisUtil.hasKey("String")+"");
		LOGGER.info(redisUtil.hasKey("String1")+"");
		LOGGER.info(redisUtil.hasKey("String2")+"");
		LOGGER.info(redisUtil.hasKey("String3")+"");

    }
	@Test
	public void keys(){
		LOGGER.info(redisUtil.keys("ZSpacketNumberPortDay*").size()+"__________");
	}
}
