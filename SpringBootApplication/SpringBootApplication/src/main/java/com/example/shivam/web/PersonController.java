package com.example.shivam.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.shivam.domain.Person;
import com.example.shivam.domain.PersonRepository;

@Controller
public class PersonController {
	
	@Autowired
	PersonRepository personRepository;
	
	@RequestMapping("/login")
	public String login() {
    	return "login";
    }
	
	@RequestMapping("/person")
	public String indexPerson(Model model) {
	
		List<Person> personList = (List<Person>)personRepository.findAll();
		model.addAttribute("person",personList);
		return "person";
	}
	
	public String addPerson(Model model) {
			model.addAttribute("person", new Person());
		return "addperson";
	}
	
	 @RequestMapping(value = "/edit/{id}")
	    public String editPerson(@PathVariable("id") Long personId, Model model){
	    	model.addAttribute("person", personRepository.findById(personId));
	        return "editperson";
	    }	    
	    
	    @RequestMapping(value = "save", method = RequestMethod.POST)
	    public String save(Person person){
	        personRepository.save(person);
	    	return "redirect:/persons";
	    }
	    
	    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	    public String deleteStudent(@PathVariable("id") Long personId, Model model) {
	    	personRepository.deleteById(personId);
	        return "redirect:/persons";
	    }
	
	    @RequestMapping(value = "getpersons", method = RequestMethod.GET)
	    public @ResponseBody List<Person> getPersons() {
	            return (List<Person>)personRepository.findAll();
	    }    

}
