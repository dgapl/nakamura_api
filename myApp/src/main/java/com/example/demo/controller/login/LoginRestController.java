package com.example.demo.controller.login;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controller.login.dto.SelectAllUsersResDto;
import com.example.demo.controller.login.dto.SelectUserReqDto;
import com.example.demo.controller.login.dto.SelectUserResDto;
import com.example.demo.model.dto.SelectAllUsersOutDto;
import com.example.demo.model.dto.SelectUserInDto;
import com.example.demo.model.dto.SelectUserOutDto;
import com.example.demo.model.service.UserService;

@RestController
@RequestMapping("/login")
public class LoginRestController {

	@Autowired
	ModelMapper modelMapper;

	@Autowired
	UserService userService;

	@RequestMapping(value = "/login001", method = RequestMethod.GET)
	public String selectHello() {

		String msg = userService.selectHello();

		return msg;
	}

	@RequestMapping(value = "/login002", method = RequestMethod.POST)
	public SelectUserResDto selectUser(@RequestBody SelectUserReqDto reqDto) {

		SelectUserInDto inDto = modelMapper.map(reqDto, SelectUserInDto.class);

		SelectUserOutDto outDto = userService.selectUser(inDto);

		SelectUserResDto resDto = new SelectUserResDto();
		if (outDto != null) {
			resDto.setUserNm(outDto.getUserNm());
		} else {
			resDto.setUserNm("名無し");
		}

		return resDto;
	}

	@RequestMapping(value = "/login003", method = RequestMethod.GET)
	public List<SelectAllUsersResDto> searchAllUsers() {

		List<SelectAllUsersOutDto> outDtoList = userService.selectAllUsers();

		List<SelectAllUsersResDto> resDtoList = new ArrayList<>();

		for (SelectAllUsersOutDto outDto : outDtoList) {
			SelectAllUsersResDto resDto = modelMapper.map(outDto, SelectAllUsersResDto.class);
			resDtoList.add(resDto);
		}

		return resDtoList;
	}

}
