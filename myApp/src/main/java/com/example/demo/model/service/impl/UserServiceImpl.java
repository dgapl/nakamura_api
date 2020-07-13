package com.example.demo.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.dto.DeleteUserInDto;
import com.example.demo.model.dto.InsertUserInDto;
import com.example.demo.model.dto.SelectAllUsersOutDto;
import com.example.demo.model.dto.SelectUserInDto;
import com.example.demo.model.dto.SelectUserOutDto;
import com.example.demo.model.repository.UserMapper;
import com.example.demo.model.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	UserMapper userMapper;

	@Override
	public String selectHello() {

		return userMapper.selectHello();

	}

	@Override
	public SelectUserOutDto selectUser(SelectUserInDto inDto) {

		return userMapper.selectUser(inDto);

	}

	@Override
	public List<SelectAllUsersOutDto> selectAllUsers() {

		return userMapper.selectAllUsers();

	}

	@Override
	public boolean insertUser(InsertUserInDto inDto) {

		return userMapper.insertUser(inDto);

	}

	@Override
	public boolean deleteUser(DeleteUserInDto inDto) {

		return userMapper.deleteUser(inDto);

	}

}
