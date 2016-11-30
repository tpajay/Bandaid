package com.tpajay.medicus.dao;

import java.util.List;

import com.tpajay.medicus.model.PatientProcedure;

public interface ProcedureDaoInterface {

	public PatientProcedure getById(int procedureId);
	
	public List getProcedureList();

	public void saveProcedure(PatientProcedure provider);

	public void updateProcedure(PatientProcedure provider);

	public void deleteProcedure(PatientProcedure provider);

	public void deleteProcedure(int procedureId);
	
}
