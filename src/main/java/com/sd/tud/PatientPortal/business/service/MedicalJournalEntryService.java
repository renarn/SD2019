package com.sd.tud.PatientPortal.business.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sd.tud.PatientPortal.data.entity.MedicalJournalEntry;
import com.sd.tud.PatientPortal.data.repository.MedicalJournalEntryRepository;


@Service
public class MedicalJournalEntryService {
	
	private MedicalJournalEntryRepository medicalJournalEntryRepository;
	
	@Autowired
	public MedicalJournalEntryService(MedicalJournalEntryRepository medicalJournalEntryRepository) {
		this.medicalJournalEntryRepository = medicalJournalEntryRepository;
	}
	/**
	 * persist a given entity of type MedicalJournalEntry to the database
	 * @param medicalJournalEntry	the entity which needs to be persisted
	 * @return	the persisted entity
	 */
	public MedicalJournalEntry saveMedicalJournalEntry(MedicalJournalEntry medicalJournalEntry) {
		
		this.medicalJournalEntryRepository.save(medicalJournalEntry);
		return medicalJournalEntry;
	}

	/**
	 * fetch a single entity of type MedicalJournalEntry from the database
	 * @param id	the id of the object you want to get
	 * @return	the object of typ MedicalJournalEntry which matches the given id from the database
	 */
	public Optional<MedicalJournalEntry> findMedicalJournalEntryById(long id) {
		return medicalJournalEntryRepository.findById(id);
	}
	
	/**
	 * deletes a single entity of type MedicalJournalEntry from the database
	 * @param medicalJournalEntry	the entity which needs to be deleted
	 * @return true
	 */
	public Boolean deleteMedicalJournalEntry(MedicalJournalEntry medicalJournalEntry) {
		medicalJournalEntryRepository.delete(medicalJournalEntry);
		return true;
	}
	
	
	
	

}
