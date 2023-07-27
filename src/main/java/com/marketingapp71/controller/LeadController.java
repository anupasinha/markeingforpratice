package com.marketingapp71.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.marketingapp71.LeadDto.LeadDto;
import com.marketingapp71.Service.LeadService;
import com.marketingapp71.entities.Lead;


@Controller
public class LeadController {
	
	@Autowired
	private LeadService leadService;
	
	//http://localhost:8080/create
	@RequestMapping("/create")//when you enter the url it is going to call this method
	public String ViewCreateLead() {
		return "create_lead";//it is just like requestdispatcher this is load this page to given path
		
	}
	@RequestMapping("/saveLead")
	public String saveLead(@ModelAttribute Lead lead,Model model) { // All your form data goes to this ob
		leadService.saveLead(lead);//Controller is calling service layer impl
		model.addAttribute("msg","Record is saved");//This will  act like request.setAttribute
		return "create_lead";
		//@modelattribute copy the data from form to entity ob
		
	}
	//There are two ways to store the data in db
//	@RequestMapping("/saveLead")
//	public String saveLead(
//			@RequestParam("firstName") String firstName,
//	        @RequestParam("lastName") String lastName,
//	        @RequestParam("email") String email,
//            @RequestParam("mobile") long mobile
//           
//	)
//	{ 
//		Lead lead = new Lead();
//		lead.setFirstName(firstName);
//		lead.setLastName(lastName);
//		lead.setEmail(email);
//		lead.setMobile(mobile);
//		leadService.saveLead(lead);
//		
//		return "create_lead";
//		
//	}
	//now we are going to third approach
//	@RequestMapping("/saveLead")
//	public String saveLead(LeadDto leadDto) {// All your form data goes to this ob
//		//we can not save the data through db we save the through entity class
//		//so we create the entity class ob and save the data in entity class ob
//		Lead lead= new Lead();
//		lead.setFirstName(leadDto.getFirstName());
//		lead.setLastName(leadDto.getLastName());
//		lead.setEmail(leadDto.getEmail());
//		lead.setMobile(leadDto.getMobile());
//		leadService.saveLead(lead);//controoler is calling service layer impl
//		return "create_lead";
//		
//	}
	//http://localhost:8080/listAll
	@RequestMapping("/listAll")
	public String getAllLeads(Model model) {
		List<Lead> leads = leadService.getAllLeads();
		model.addAttribute("leads",leads);
		return"search_result";
	}
}
