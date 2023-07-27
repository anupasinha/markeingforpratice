package com.marketingapp71.Service;

import java.util.List;

import com.marketingapp71.entities.Lead;

public interface LeadService {
	public String saveLead(Lead lead);//This is ob which have data so data form the code goes to the this ob address goes to 
	//service layer save that entity ob t0 db
	public List<Lead> getAllLeads();//why i am write list because it will not return one lead ob it will return
	//two entity ob more than ob store we require collection that is list
	
}
