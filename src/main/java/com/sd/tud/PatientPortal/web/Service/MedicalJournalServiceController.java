package com.sd.tud.PatientPortal.web.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sd.tud.PatientPortal.business.service.MedicalJournalService;
import com.sd.tud.PatientPortal.data.entity.MedicalJournal;

@RestController
@RequestMapping(value="/api")
public class MedicalJournalServiceController {
	
	@Autowired
	private MedicalJournalService medJournalService;

	@RequestMapping(method = RequestMethod.GET, value ="/medJournals")
	public List<MedicalJournal> getAllMedicalJournals () {
		
		
		return medJournalService.getAllMedicalJournals();
			
	}
	
}
