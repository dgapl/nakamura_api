package com.example.demo.model.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.dto.DeleteUserInDto;
import com.example.demo.model.dto.InsertUserInDto;
import com.example.demo.model.dto.SelectAllUsersOutDto;
import com.example.demo.model.dto.SelectUserInDto;
import com.example.demo.model.dto.SelectUserOutDto;

@Mapper
public interface UserMapper {

	public String selectHello();

	public SelectUserOutDto selectUser(SelectUserInDto inDto);

	public List<SelectAllUsersOutDto> selectAllUsers();

	public boolean insertUser(InsertUserInDto inDto);

	public boolean deleteUser(DeleteUserInDto inDto);

}
