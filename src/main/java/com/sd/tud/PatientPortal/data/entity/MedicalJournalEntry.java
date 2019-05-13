package com.sd.tud.PatientPortal.data.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name="MED_JOURNAL_ENTRY")
public class MedicalJournalEntry extends JournalEntry{
	

	/*
	 * The following attributes are inherited from the supperclass JournalEntry
	 * intJournalEntryId
	 * datJournalEntryDate
	 * tstmpJournalEntryCreateDate
	 * tstmpJournalEntryUpdateDate
	 * 
	 * getters and setters are defined and implemented in the supperclass Journal as well
	 * 
	 */

	public MedicalJournalEntry() {}
	
	public MedicalJournalEntry(long lngJournalEntryId, LocalDate ldJournalEntryDate, LocalDateTime ldtJournalEntryCreateDate,
			LocalDateTime ldtJournalEntryUpdateDate, String strNote, BloodPressure bloodPressure,
			MedicalJournal medJournal, short shPulse, short shHeight, short shWeight, float fltBmi, boolean blnIsSick) {
		
		super(lngJournalEntryId, ldJournalEntryDate, ldtJournalEntryCreateDate, ldtJournalEntryUpdateDate, strNote);
		this.bloodPressure = bloodPressure;
		this.medJournal = medJournal;
		this.shPulse = shPulse;
		this.shHeight = shHeight;
		this.shWeight = shWeight;
		this.fltBmi = fltBmi;
		this.blnIsSick = blnIsSick;
	}

	@Embedded
	private BloodPressure bloodPressure;
	
	@ManyToOne
	@JoinColumn(name = "JOURNAL_ID")
	@JsonBackReference
	private MedicalJournal medJournal; // bidirectional relationship with entity MedicalJournal
	
	@Column(name="JOURNAL_ENTRY_PULSE")
	private short shPulse; 
	@Column(name="JOURNAL_ENTRY_HEIGHT")
	@Min(value = 1, message="Die Größe muss größer als 1cm sein.")
	@Max(value = 300, message="Die Größe muss kleiner als 300cm sein.")
	private short shHeight; // in centimeters
	@Column(name="JOURNAL_ENTRY_WEIGHT")
	@Min(value = 1, message="Das Gewicht muss größer als 1kg sein.")
	@Max(value = 500, message="Das Gewicht muss kleiner als 500kg sein.")
	private short shWeight; // in kilograms
	@Column(name="JOURNAL_ENTRY_BMI")
	private float fltBmi;
	@Column(name="JOURNAL_ENTRY_IS_SICK")
	private boolean blnIsSick;
	
	
	public BloodPressure getBloodPressure() {
		return bloodPressure;
	}
	public void setBloodPressure(BloodPressure bloodPressure) {
		this.bloodPressure = bloodPressure;
	}
	public MedicalJournal getMedJournal() {
		return medJournal;
	}
	public void setMedJournal(MedicalJournal medJournal) {
		this.medJournal = medJournal;
	}
	public short getShPulse() {
		return shPulse;
	}
	public void setShPulse(short shPulse) {
		this.shPulse = shPulse;
	}
	public short getShHeight() {
		return shHeight;
	}
	public void setShHeight(short shHeight) {
		this.shHeight = shHeight;
	}
	public short getShWeight() {
		return shWeight;
	}
	public void setShWeight(short shWeight) {
		this.shWeight = shWeight;
	}
	public float getFltBmi() {
		return fltBmi;
	}
	public void setFltBmi(float fltBmi) {
		this.fltBmi = fltBmi;
	}
	public boolean getBlnIsSick() {
		return blnIsSick;
	}
	public void setBlnIsSick(boolean isSick) {
		this.blnIsSick = isSick;
	}
	
	
	
	
	

}
