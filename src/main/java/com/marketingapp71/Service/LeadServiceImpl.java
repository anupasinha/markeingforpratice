package com.marketingapp71.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketingapp71.entities.Lead;
import com.marketingapp71.repository.LeadRepository;
@Service
public class LeadServiceImpl implements LeadService {
// we are doing dependency injection
	@Autowired
	private LeadRepository leadRepo;// means which ever add in laed ob it will also add in leadRepo
	
	
	@Override
	public String saveLead(Lead lead) {
		leadRepo.save(lead);//service layer take the ob address and save that in leadRepo after saving this service
		//goes back to controoler layer
		return null;
		
	}


	@Override
	public List<Lead> getAllLeads() {
		List<Lead> leads = leadRepo.findAll();//it will create two entity ob because there r two adress store
		return leads;
	}

}
