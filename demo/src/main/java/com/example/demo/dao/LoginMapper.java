package com.example.demo.dao;


import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface LoginMapper {
	
    int select_test(String user_id, String user_pw);
}


