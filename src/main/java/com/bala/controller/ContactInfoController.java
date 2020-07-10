package com.bala.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bala.model.ContactModel;
import com.bala.service.ContactService;

@Controller
public class ContactInfoController {
	@Autowired
	private ContactService contactService;
	
	@GetMapping(value="/")
	public String loadForm(Model model) {
		ContactModel c=new ContactModel();
		model.addAttribute("contact", c);
		
		return "contactInfo";
		
	}
	@PostMapping(value="/saveContact")
	public  String handleSubmitBtn(@ModelAttribute("contact") ContactModel cm,Model model) {
		boolean isSaved=contactService.saveContact(cm);
		if(isSaved) {
			model.addAttribute("succMsg", "Contact Saved");
		}else {
			model.addAttribute("errMsg", "Failed to save contact");
			
		}
		return "contactInfo";
		
	}
	@GetMapping(value="/viewContacts")
	public String handleViewContactLink(Model model) {
		List<ContactModel> contactList=contactService.getAllContacts();
		model.addAttribute("contacts", contactList);
		return "viewContacts";	}

}
