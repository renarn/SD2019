package com.sd.tud.PatientPortal.web.Controller;


/*
 * Hallo
 */

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sd.tud.PatientPortal.business.service.MedicalJournalEntryService;
import com.sd.tud.PatientPortal.business.service.MedicalJournalService;
import com.sd.tud.PatientPortal.data.entity.MedicalJournalEntry;

@Controller
@SessionAttributes({"lngMedicalJournalEntryId"})
@RequestMapping(value="/medJourEntry")

public class MedicalJournalEntryController {
	
	//TODO: finish javadoc
	
	@Autowired
	private MedicalJournalService medicalJournalService;
	
	@Autowired
	private MedicalJournalEntryService medicalJournalEntryService;

	/**
	 * 
	 * @param medicalJournalEntry
	 * @return
	 */
	//TODO: entfernen entspricht doch add, oder?
	@RequestMapping(value="/create", method = RequestMethod.GET)
	public String showCreateMedicalJournalEntryForm(MedicalJournalEntry medicalJournalEntry) {
		
		return "create-medJournalEntry";
	}
	
	/**
	 * add a new MedicalJournalEntry to the database
	 * 
	 * @param medicalJournalEntry		the entity of type MedicalJournalEntry which you want to persist
	 * @param bindingResult				holds errors if validation of entered data fails
	 * @param model 					model of MVC framework
	 * @return 							returns index view
	 */
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String addMedicalJournalEntry(@Valid MedicalJournalEntry medicalJournalEntry, BindingResult bindingResult, Model model ) {

		
		if (bindingResult.hasErrors()) {
			return "create-medJournalEntry";
		}
		
		medicalJournalEntryService.saveMedicalJournalEntry(medicalJournalEntry);
		// update list of persisted entities in corresponding view
		model.addAttribute("medicalJournalEntries",medicalJournalService.getAllMedicalJournalEntries());
		return "medJourEntries";
	}
	
	/**
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String showUpdateMedicalJournalEntryForm(@PathVariable("id") long id, Model model) {
		
		// fetch the medicalJournalEntry that matches the supplied id from the database
		// if the entity exists, it will be passed on as a model attribute to the update form view so that the
		//    correspongding fields can be filled with values
		MedicalJournalEntry medicalJournalEntry = medicalJournalEntryService.findMedicalJournalEntryById(id)
				.orElseThrow(() -> new IllegalArgumentException("Falsche ID: " + id));
		
		model.addAttribute("medicalJournalEntry",medicalJournalEntry);

		// set the session attribute:
		model.addAttribute("lngMedicalJournalEntryId", medicalJournalEntry.getLngJournalEntryId());

		return "update-medJournalEntry";
	}
	
	/**
	 * 
	 * @param medicalJournalEntry
	 * @param medicalJournalEntryId
	 * @param bindingResult
	 * @param model
	 * @return
	 */

	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public String updateMedicalJournalEntry(@Valid MedicalJournalEntry medicalJournalEntry, BindingResult bindingResult, Model model, @SessionAttribute("lngMedicalJournalEntryId") long medicalJournalEntryId) {
		
			// check for errors:
			if(bindingResult.hasErrors()) {
				return "update-medJournalEntry";
			}
			
			// fetch the original object
			MedicalJournalEntry existingMedicalJournalEntry = medicalJournalEntryService.findMedicalJournalEntryById(medicalJournalEntryId)
					.orElseThrow(() -> new IllegalArgumentException("Falsche ID: " + medicalJournalEntryId));
			
			// update original object with new values
			existingMedicalJournalEntry.setStrNote(medicalJournalEntry.getStrNote());

			existingMedicalJournalEntry.setLdJournalEntryDate(medicalJournalEntry.getLdJournalEntryDate());
			
			// save the altered entity:
			medicalJournalEntryService.saveMedicalJournalEntry(existingMedicalJournalEntry);

			// pass the altered list of items to the modell:
			model.addAttribute("medicalJournalEntries",medicalJournalService.getAllMedicalJournalEntries());

			// return the view:
			return "medJourEntries";
	}
	
	/**
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
	public String deleteMedicalJournalEntry(@PathVariable("id") long id, Model model) {
		
		MedicalJournalEntry medicalJournalEntry = medicalJournalEntryService.findMedicalJournalEntryById(id)
				.orElseThrow(() -> new IllegalArgumentException("Falsche ID: " + id));
		

		medicalJournalEntryService.deleteMedicalJournalEntry(medicalJournalEntry);

		model.addAttribute("medicalJournalEntries",medicalJournalService.getAllMedicalJournalEntries());

		return "medJourEntries";
	}
}
