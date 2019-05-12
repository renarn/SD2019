package com.sd.tud.PatientPortal.data.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sd.tud.PatientPortal.data.entity.MedicalJournalEntry;

@Repository
public interface MedicalJournalEntryRepository extends CrudRepository<MedicalJournalEntry,Long>{

}
