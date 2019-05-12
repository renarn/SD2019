package com.sd.tud.PatientPortal.data.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable // is part of MedicalJournalEntry
public class BloodPressure {
	
	public BloodPressure(int intSYS, int intDIA) {
		this.intSYS = intSYS;
		this.intDIA = intDIA;
	}
	@Column(name ="BLOOD_PRESSURE_SYS")
	private int intSYS;
	@Column(name = "BLOOD_PRESSURE_DIA")
	private int intDIA;
	
	
	public int getIntSYS() {
		return intSYS;
	}
	public void setIntSYS(int intSYS) {
		this.intSYS = intSYS;
	}
	public int getIntDIA() {
		return intDIA;
	}
	public void setIntDIA(int intDIA) {
		this.intDIA = intDIA;
	}
	
	public BloodPressure() {}
	
	

}
