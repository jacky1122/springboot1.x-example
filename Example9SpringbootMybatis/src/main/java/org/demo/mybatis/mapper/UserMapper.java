package org.demo.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.demo.mybatis.entity.User;

@Mapper
public interface UserMapper {

	@Select("SELECT * FROM t_user WHERE user_name = #{userName}")
	List<User> findByUserName(@Param("userName") String userNaMe); 


	int insert(User user); 
}	
