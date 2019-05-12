package com.sd.tud.PatientPortal.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sd.tud.PatientPortal.data.entity.MedicalJournal;

@Repository
public interface MedicalJournalRepository extends CrudRepository<MedicalJournal,Long>{

}
