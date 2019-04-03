package org.demo.mybatis;

import java.util.List;

import org.demo.mybatis.entity.User;
import org.demo.mybatis.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Example9SpringbootMybatisApplicationTests {
	private static final Logger log = LoggerFactory.getLogger(Example9SpringbootMybatisApplicationTests.class); 
	@Test
	public void contextLoads() {
	}

	@Autowired 
	private UserMapper userMapper; 
	
	@Test 
	public void testUserMapper() {
		final int row1 = userMapper.insert(new User("jacky1", "jacky1")); 
		log.info("[添加成功] - [{}]", row1);
		
		final int row2 = userMapper.insert(new User("jacky2", "jacky2")); 
		log.info("[添加成功] - [{}]", row2);
		
		final int row3 = userMapper.insert(new User("jacky3", "jacky3")); 
		log.info("[添加成功] - [{}]", row3);
		
		final List<User> ul = userMapper.findByUserName("jacky1"); 
		log.info("[根据用户名查询] - [{}]", ul);
		
	}
}
