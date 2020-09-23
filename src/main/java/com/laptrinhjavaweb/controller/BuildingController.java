package com.laptrinhjavaweb.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.builder.BuildingSearchBuilder;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.service.IBuildingService;
import com.laptrinhjavaweb.service.IUserService;

@Controller(value = "buildingControllerOfAdmin")
public class BuildingController {
	
	@Autowired
	private IBuildingService buildingService;
	
	@Autowired
	private IUserService userService;
	
	
	@RequestMapping(value = "/admin/building/list", method = RequestMethod.GET)
	public ModelAndView showList(@ModelAttribute("model") BuildingDTO model) {
		
		ModelAndView mav = new ModelAndView("admin/building/ListBuilding");
		
//		model.setPage(1);
//		model.setLimit(2);
		
		BuildingSearchBuilder fieldSearchBuilder = new BuildingSearchBuilder.Builder()
				.setName(model.getName()).setDistrict(model.getDistrict())
				.setBuildingArea(model.getBuildingArea()).setNumberOfBasement(model.getNumberOfBasement())
				.setCostRentFrom(model.getCostRentFrom()).setCostRentTo(model.getCostRentTo())
				.setAreaRentFrom(model.getAreaRentFrom()).setAreaRentTo(model.getAreaRentTo())
				.setBuildingTypes(model.getBuildingTypes())
				.setStaffId(model.getStaffId())
				.build();
		
//		Pageable pageable = new PageRequest(model.getPage() - 1, model.getLimit());
		
		List<BuildingDTO> buildingDTOs = buildingService.findAll(fieldSearchBuilder);
	
		List<UserDTO> userDTOs = userService.findStaff();
		
		mav.addObject("districts", buildingService.getDistricts());
		mav.addObject("buildingTypes", buildingService.getBuildingTypes());
		
		mav.addObject("users", userDTOs);
		mav.addObject("buildings", buildingDTOs);
		
		return mav;
	}
	
	@RequestMapping(value = "/admin/building/edit", method = RequestMethod.GET)
	public ModelAndView editBuilding(@RequestParam(value = "id", required = false) Long id) {
		ModelAndView mav = new ModelAndView("admin/building/EditBuilding");
		
		BuildingDTO model = new BuildingDTO();
		
		if (id != null) {
	
			model = buildingService.findById(id);
			
			mav.addObject("buildingTypes", buildingService.getBuildingTypes());
			mav.addObject("isEdit", true);
					
		}else {
			mav.addObject("isEdit", false);
			mav.addObject("buildingTypes", buildingService.getBuildingTypes());
		}
		
		
		mav.addObject("model", model);
		
		return mav;
	}
}
