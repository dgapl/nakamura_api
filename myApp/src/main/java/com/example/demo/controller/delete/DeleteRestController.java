package com.example.demo.controller.delete;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controller.delete.dto.DeleteUserReqDto;
import com.example.demo.controller.delete.dto.DeleteUserResDto;
import com.example.demo.model.dto.DeleteUserInDto;
import com.example.demo.model.service.UserService;

@RestController
@RequestMapping("/delete")
public class DeleteRestController {

	@Autowired
	ModelMapper modelMapper;

	@Autowired
	UserService userService;

	@RequestMapping(value = "/delete001", method = RequestMethod.POST)
	public DeleteUserResDto deleteUser(@RequestBody DeleteUserReqDto reqDto) {

		DeleteUserInDto inDto = modelMapper.map(reqDto, DeleteUserInDto.class);

		boolean outDto = userService.deleteUser(inDto);

		DeleteUserResDto resDto = new DeleteUserResDto();
		if (outDto) {
			resDto.setResultMsg("OK");
		}

		return resDto;
	}

}
