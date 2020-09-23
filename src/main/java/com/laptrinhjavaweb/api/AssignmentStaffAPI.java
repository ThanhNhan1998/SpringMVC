package com.laptrinhjavaweb.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.service.IUserService;

@RestController
@RequestMapping("/api/assignmentstaff")

public class AssignmentStaffAPI {
	
	@Autowired
	private IUserService userService;
	
	@GetMapping
	public List<UserDTO> staffList(@RequestParam("id") Long buildingId){
		return userService.findStaff(buildingId);
	}
	
	@PostMapping
	public void assignmentStaff(@RequestBody UserDTO users) {
		userService.assignmentBuilding(users.getIds(), Long.parseLong(users.getBuildingId()));
	}
}
