package com.sd.tud.PatientPortal.business.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.sd.tud.PatientPortal.data.entity.MedicalJournalEntry;
import com.sd.tud.PatientPortal.data.repository.MedicalJournalEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import com.sd.tud.PatientPortal.data.entity.MedicalJournal;
import com.sd.tud.PatientPortal.data.repository.MedicalJournalRepository;

@Service
public class MedicalJournalService {
	
	// data access through repository interface
	private MedicalJournalRepository medicalJournalRepository;

	// data access through repository interface
	@Autowired
	private MedicalJournalEntryRepository medicalJournalEntryRepository;


	@Autowired // activates dependency injection for the constructor
	public MedicalJournalService(MedicalJournalRepository medJournalRepository) {
		this.medicalJournalRepository = medJournalRepository;

	}
	
	/**
	 * Returns all available instances of Medical Journal from the database
	 * 
	 * @return a List of Medical Journals
	 */
	public List<MedicalJournal> getAllMedicalJournals(){
		
		List<MedicalJournal> medJournals = (List<MedicalJournal>) this.medicalJournalRepository.findAll();
		
		// just return all available Medical Journals
		
		return medJournals;
		
	}
	
	/**
	 * Saves a given medJournal to the database
	 * 
	 * @param instance of Medical Journal which needs to be saved
	 * @return the saved instance
	 */
	public MedicalJournal saveMedicalJournal(MedicalJournal medJournal) {
		
		this.medicalJournalRepository.save(medJournal);
		
		return medJournal;
	}
	
	/**
	 * takes an Id of an instance of Medical Journal and deletes it inside the database.
	 * 
	 * @param id 	the Id of the Medical Journal which needs to be deleted
	 * @return		true if the Medical Journal got deleted, else false. 
	 * 				returns also false if the given Id is null 
	 * @autor 		Volker Sedlmair
	 * 
	 */
	
	public Boolean deleteMedicalJournalById(long id) {
		
		try {
			this.medicalJournalRepository.deleteById(id);
		}
		catch (IllegalArgumentException iae)
		{
			return false;
		}
		
		return true;
		
	}

	/**
	 * fetch all persisted entities of type MedicalJournalEntry from the database
	 * @return	a List with all MedicalJournalEntries
	 */
	public List<MedicalJournalEntry> getAllMedicalJournalEntries(){

		List<MedicalJournalEntry> medicalJournalEntries = (List<MedicalJournalEntry>) medicalJournalEntryRepository.findAll();
		return medicalJournalEntries;
	}

	/**
	 * fetch all persisted entities of type MedicalJournalEntry from the database
	 * @return	a Optional with MedicalJournalEntries filtered by their Medical Journal
	 */
	public Optional<MedicalJournalEntry> getAllMedicalJournalEntries(MedicalJournal medJournal) {

		Optional<MedicalJournalEntry> medicalJournalEntries=((List<MedicalJournalEntry>) medicalJournalEntryRepository.findAll()).stream().filter(p -> p.getMedJournal() == medJournal).findAny();

		return medicalJournalEntries;
	}

}
