package com.honeywell.homemgmt.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.honeywell.homemgmt.dao.ModelRepository;
import com.honeywell.homemgmt.model.PowerDevice;
import com.honeywell.homemgmt.services.PowerService;

@RestController
public class PowerController {
	
	@Autowired
	ModelRepository repo;
	

	@Autowired
	private PowerService powerService;
	
	@RequestMapping("/powerdevices/{homeId}")
	public List<PowerDevice> powerDevicelist(@PathVariable("homeId") Long homeId){
		
		return powerService.getAllPowerDevices(homeId);
		
	}
	
	@RequestMapping(value = "/home/{homeId}/device", method = RequestMethod.POST)
    public void addDevices(@PathVariable("homeId") Long homeId, @RequestBody PowerDevice device) {
		powerService.addDevices(homeId, device);
 
    }

}
