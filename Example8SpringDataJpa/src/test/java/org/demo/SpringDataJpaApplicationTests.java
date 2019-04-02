package org.demo;

import java.util.List;

import org.demo.entity.User;
import org.demo.repo.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringDataJpaApplicationTests {

	@Test
	public void contextLoads() {
	}
	
	private static final Logger log = LoggerFactory.getLogger(SpringDataJpaApplicationTests.class); 
	
	@Autowired
	private UserRepository userRepository; 
	
	@Test 
	public void test1() throws Exception {
		final User user = userRepository.save(new User("u1", "p1")); 
		log.info("[添加成功]-[{}]", user);
		final List<User> u1 = userRepository.findAllByUserName("u1"); 
		log.info("[条件查询[{}]", u1);
	
		Pageable pageable = PageRequest.of(0, 10, Sort.by(Sort.Order.desc("userName")));
		final Page<User> users = userRepository.findAll(pageable); 
		log.info("[分页查询[{}]", u1);

		userRepository.findById(users.getContent().get(0).getId()).ifPresent(user1 -> 
			log.info("[主键查询] - [{}]", user1)); 	
		
		final User edit = userRepository.save(new User(user.getId(), "修改后UI", "修改后的P1")); 
		log.info("[修改成功]-[{}]", edit);
		userRepository.deleteById(user.getId());
		log.info("[删除成功]-[{}]", user.getId());
	}

}
