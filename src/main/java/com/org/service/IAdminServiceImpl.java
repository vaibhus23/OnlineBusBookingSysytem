package com.org.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.org.entities.BusOperator;
import com.org.repository.IAdminRepository;

@Service
@Transactional
public class IAdminServiceImpl implements IAdminService {

	@Autowired
	private IAdminRepository Admin_Repository;

	@Override
	public List<BusOperator> getAllBusOperators() {
		return Admin_Repository.findAll();
	}

	@Override
	public List<BusOperator> getAllBusOperatorsByRoute(int busrouteid) {
		return Admin_Repository.getAllBusOperatorsByRoute(busrouteid);
	}

	@Override
	public Double getRevenueByDate(LocalDate date) {
		return Admin_Repository.getRevenueByDate(date);
	}

	@Override
	public Double getRevenueByBusRoute(int busrouteid) {
		return Admin_Repository.getRevenueByBusRoute(busrouteid);
	}

	@Override
	public Double getRevenueByBusOperator(String operatorUsername) {
		return Admin_Repository.getRevenueByBusOperator(operatorUsername);
	}

	@Override
	public void deleteBusByOperator(String busOperatorUserName) {
		Admin_Repository.deleteBusByOperator(busOperatorUserName);
	}

//	@Override
//	public void deleteBus(Bus bus) {
//		Admin_Repository.
//		
//	}
}
