package org.demo;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.demo.web.UserController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=MockServletContext.class)
@WebAppConfiguration
public class Example4Swagger2Tests {

	private MockMvc mvc; 
	
	@Before 
	public void setUp() throws Exception{
		mvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
	}
	
	
	@Test 
	public void testUserController() throws Exception {
		RequestBuilder request = null; 
		
		request = get("/users/");
		mvc.perform(request)
		   .andExpect(status().isOk())
		   .andExpect(content().string(equalTo("[]")));
	
	
		request = post("/users/")
				.param("id", "1")
				.param("name", "测试大师")
				.param("age", "20"); 
		mvc.perform(request)
			.andExpect(content().string(equalTo("success")));
		
		request = get("/users/");
		mvc.perform(request)
			.andExpect(status().isOk())
			.andExpect(content().string(equalTo("[{\"id\":1,\"name\":\"测试大师\",\"age\":20}]")));
		
		request = put("/users/1")
				.param("name", "测试终极大师")
				.param("age", "30"); 
		mvc.perform(request)
			.andExpect(content().string(equalTo("success"))); 
		
		request = get("/users/1"); 
		mvc.perform(request)
			.andExpect(content().string(equalTo("{\"id\":1,\"name\":\"测试终极大师\",\"age\":30}")));
			
			
		request = delete("/users/1");
		mvc.perform(request)
			.andExpect(content().string(equalTo("success")));
		request = get("/users/");
		mvc.perform(request)
			.andExpect(status().isOk())
			.andExpect(content().string(equalTo("[]")));		
	}
	
}
