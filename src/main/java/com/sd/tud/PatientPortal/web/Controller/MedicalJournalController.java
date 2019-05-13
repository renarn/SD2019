package com.sd.tud.PatientPortal.web.Controller;

import com.sd.tud.PatientPortal.business.service.MedicalJournalEntryService;
import com.sd.tud.PatientPortal.business.service.MedicalJournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
// @SessionAttributes({"lngMedicalJournalEntryId"})
@RequestMapping(value="/medJourEntries")
public class MedicalJournalController {

    @Autowired
    private MedicalJournalEntryService medicalJournalEntryService;

    @Autowired
    private MedicalJournalService medicalJournalService;

    @RequestMapping(value="/all", method = RequestMethod.GET)
    public String showAllMedicalJournalEntries(Model model) {

        model.addAttribute("medicalJournalEntries",medicalJournalService.getAllMedicalJournalEntries());
        return "medJourEntries";
    }

}
