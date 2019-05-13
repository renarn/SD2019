package com.sd.tud.PatientPortal.data.entity;


import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;




@MappedSuperclass
public abstract class JournalEntry {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="JOURNAL_ENTRY_ID", nullable = false)
	private long lngJournalEntryId;
	@Column(name="JOURNAL_ENTRY_DATE")
	@NotNull
	@DateTimeFormat(pattern="dd.MM.yyyy")
	private LocalDate ldJournalEntryDate;
	@Column(name="JOURNAL_ENTRY_CREATE_DATE")
	@CreationTimestamp
	private LocalDateTime ldtJournalEntryCreateDate;
	@Column(name="JOURNAL_ENTRY_LAST_UPDATED")
	@UpdateTimestamp
	private LocalDateTime ldtJournalEntryUpdateDate;
	@Column(name="JOURNAL_ENTRY_NOTE")
	@Size(min=0,max=255)
	private String strNote;
	

	public JournalEntry() {}
	
	public JournalEntry(long lngJournalEntryId, LocalDate ldJournalEntryDate, LocalDateTime ldtJournalEntryCreateDate,
			LocalDateTime ldtJournalEntryUpdateDate, String strNote) {
		this.lngJournalEntryId = lngJournalEntryId;
		this.ldJournalEntryDate = ldJournalEntryDate;
		this.ldtJournalEntryCreateDate = ldtJournalEntryCreateDate;
		this.ldtJournalEntryUpdateDate = ldtJournalEntryUpdateDate;
		this.strNote = strNote;
	}

	public long getLngJournalEntryId() {
		return lngJournalEntryId;
	}

	public void setLngJournalEntryId(long id) {
		this.lngJournalEntryId = id;
	}

	public LocalDate getLdJournalEntryDate() {
		return ldJournalEntryDate;
	}

	public void setLdJournalEntryDate(LocalDate ldJournalEntryDate) {
		this.ldJournalEntryDate = ldJournalEntryDate;
	}

	public LocalDateTime getLdtJournalEntryCreateDate() {
		return ldtJournalEntryCreateDate;
	}

	public void setLdtJournalEntryCreateDate(LocalDateTime ldtJournalEntryCreateDate) {
		this.ldtJournalEntryCreateDate = ldtJournalEntryCreateDate;
	}

	public LocalDateTime getLdtJournalEntryUpdateDate() {
		return ldtJournalEntryUpdateDate;
	}

	public void setLdtJournalEntryUpdateDate(LocalDateTime ldtJournalEntryUpdateDate) {
		this.ldtJournalEntryUpdateDate = ldtJournalEntryUpdateDate;
	}

	public String getStrNote() {
		return strNote;
	}

	public void setStrNote(String strNote) {
		this.strNote = strNote;
	}
	
	
}
