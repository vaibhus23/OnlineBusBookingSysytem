package com.org.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.org.entities.BusOperator;
import com.org.service.IAdminServiceImpl;

@RestController
@RequestMapping("/Admin")
public class AdminController {

	@Autowired
	IAdminServiceImpl Admin_service;

	@GetMapping("/findAllBusOperator")
	public List<BusOperator> getAllBusOperators() {
		return Admin_service.getAllBusOperators();
	}

	@GetMapping("/findAllBusOperatorByRouteId/{busrouteid}")
	public List<BusOperator> getAllBusOperatorsByRoute(int busrouteid) {
		return Admin_service.getAllBusOperatorsByRoute(busrouteid);
	}

	@GetMapping("/revenueByRouteIdandDate/{date}")
	public Double getRevenueByBusRouteAndDate(
			@RequestParam("start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
		return Admin_service.getRevenueByDate(date);
	}

	@GetMapping("/revenueByRouteId/{operatorUsername}")
	public Double getRevenueByBusRoute(String operatorUsername) {
		return Admin_service.getRevenueByBusOperator(operatorUsername);

	}
	
	@DeleteMapping("/deleteBusByOperator/{busOperatorUsername}")
	public void deleteBusOperatorByUserName(@PathVariable("busOperatorUsername") String busOperatorUsername) {
		Admin_service.deleteBusByOperator(busOperatorUsername);
	}
}
