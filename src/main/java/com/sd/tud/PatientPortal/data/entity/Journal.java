package com.sd.tud.PatientPortal.data.entity;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass

/*
 * using the MappedSuperClass Approach means:
 * 
 * - all the subclasses get their own table
 * - relationships between superclass and other entities are not possible
 * - polymorphic queries that select all Journals is not possible
 * - each subclass has their own relationship with other entities
 * - abstract classes dont get any tables
 * 
 */

public abstract class Journal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="JOURNAL_ID", updatable = false, nullable = false)
	private int intJournalID;
	@Column(name="JOURNAL_CREATE_DATE")
	private Timestamp datJournalCreateDate;
	@Column(name="JOURNAL_LAST_UPDATED")
	private Timestamp dateJournalUpdateDate;
	@Column(name="JOURNAL_NAME")
	private String strJournalName;
	@Column(name="JOURNAL_USER_ID")
	private int intUserId;
	
	public int getIntJournalID() {
		return intJournalID;
	}
	public void setIntJournalID(int intJournalID) {
		this.intJournalID = intJournalID;
	}
	public Timestamp getDatJournalCreateDate() {
		return datJournalCreateDate;
	}
	public void setDatJournalCreateDate(Timestamp datJournalCreateDate) {
		this.datJournalCreateDate = datJournalCreateDate;
	}
	public Timestamp getDateJournalUpdateDate() {
		return dateJournalUpdateDate;
	}
	public void setDateJournalUpdateDate(Timestamp dateJournalUpdateDate) {
		this.dateJournalUpdateDate = dateJournalUpdateDate;
	}
	public String getStrJournalName() {
		return strJournalName;
	}
	public void setStrJournalName(String strJournalName) {
		this.strJournalName = strJournalName;
	}
	public int getIntUserId() {
		return this.intUserId;
	}
	public void setIntUserId(int intUserId) {
		this.intUserId=intUserId;
	}
	

}
