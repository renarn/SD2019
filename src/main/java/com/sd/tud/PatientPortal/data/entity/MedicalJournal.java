package com.sd.tud.PatientPortal.data.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;


@Entity
@Table(name="MED_JOURNAL")
public class MedicalJournal extends Journal {

	// attributes
	/*
	 * The following attributes are inherited from the supperclass Journal
	 * intJournalID
	 * datJournalCreateDate
	 * dateJournalUpdateDate
	 * strJournalName
	 * 
	 * getters and setters are defined and implemented in the supperclass Journal as well
	 * 
	 */
	
	/*@OneToMany
	@JoinTable(name = "MED_JOURNAL_ENTRY",
	joinColumns=@JoinColumn(name="JOURNAL_ID"),
	inverseJoinColumns=@JoinColumn(name="JOURNAL_ENTRY_ID")) */
	
	@OneToMany(mappedBy = "medJournal", cascade = CascadeType.ALL) // bidirectional relationship to field attribute medJournal of entity MedicalJournalEntry
	@JsonManagedReference
	private List<MedicalJournalEntry> medJournalEntries = new ArrayList<MedicalJournalEntry>();

	public List<MedicalJournalEntry> getMedJournalEntries() {
		return medJournalEntries;
	}

	public void setMedJournalEntries(List<MedicalJournalEntry> medJournalEntries) {
		this.medJournalEntries = medJournalEntries;
	};
	
	
	
}
