package com.tpajay.medicus.dao;

import java.util.List;

import com.tpajay.medicus.model.Physician;

public interface PhysicianDaoInterface {

	public Physician getById(int physicianId);
	
	public Physician getByName(String lastName, String firstName);

	public List getPhysicianList();

	public void savePhysician(Physician physician);

	public void updatePhysician(Physician physician);

	public void deletePhysician(Physician physician);

	public void deletePhysician(int physicianId);
	
}
