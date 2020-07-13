package com.example.demo.controller.insert;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controller.insert.dto.InsertUserReqDto;
import com.example.demo.controller.insert.dto.InsertUserResDto;
import com.example.demo.model.dto.InsertUserInDto;
import com.example.demo.model.service.UserService;

@RestController
@RequestMapping("/insert")
public class InsertRestController {

	@Autowired
	ModelMapper modelMapper;

	@Autowired
	UserService userService;

	@RequestMapping(value = "/insert001", method = RequestMethod.POST)
	public InsertUserResDto insertUser(@RequestBody InsertUserReqDto reqDto) {

		InsertUserInDto inDto = modelMapper.map(reqDto, InsertUserInDto.class);

		boolean outDto = userService.insertUser(inDto);

		InsertUserResDto resDto = new InsertUserResDto();
		if (outDto) {
			resDto.setResultMsg("OK");
		}

		return resDto;
	}

}
