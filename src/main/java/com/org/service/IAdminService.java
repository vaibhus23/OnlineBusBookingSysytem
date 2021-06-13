package com.org.service;

import java.time.LocalDate;
import java.util.List;

import com.org.entities.BusOperator;

public interface IAdminService {
	public List<BusOperator> getAllBusOperators();

	public List<BusOperator> getAllBusOperatorsByRoute(int busrouteid);

	public Double getRevenueByDate(LocalDate date);

	public Double getRevenueByBusRoute(int busrouteid);

	public Double getRevenueByBusOperator(String operatorUsername);

//	public void updateBusTime(Bus bus,LocalTime newSourceTime,LocalTime newDestinationTime);
//	public void updateBusRoute(Bus bus,BusRoute newBusRoute);
//	public void updateBusFare(Bus bus,int newFare);

//	public void deleteBus(Bus bus);
	public void deleteBusByOperator(String busOperatorUserName);

//	public AdminUser singIn(AdminUser user);
//	public AdminUser singOut(AdminUser user);

}
