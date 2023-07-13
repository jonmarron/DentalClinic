package com.jontxu.DentalClinic.logic;

import com.jontxu.DentalClinic.data.Employee;
import com.jontxu.DentalClinic.data.Patient;
import com.jontxu.DentalClinic.data.Visit;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class DentalClinicService {

    public void markPatientLoyal(Patient patient, List<Visit> visits, int loyalVisits){
        long count = visits.stream()
                .filter(visit -> visit.patient().equals(patient))
                .count();
        if (count >= loyalVisits) patient.setLoyal(true);
    }
    public List<Visit> getVisitsWeek(List<Visit> visits, LocalDate weekStart){
        return visits.stream()
                .filter(visit -> visit.date().isAfter(weekStart) && visit.date().isBefore(weekStart.plusDays(6)))
                .collect(Collectors.toList());
    }

    public List<Visit> getVisitsMonth(List<Visit> visits, int monthValue){
        return visits.stream()
                .filter(visit -> visit.date().getMonthValue() == monthValue)
                .collect(Collectors.toList());
    }

    public List<Patient> getPatientByDentist(List<Visit> visits, Employee employee){
        return visits.stream()
                .filter(visit -> hasEmployee(visit, employee))
                .map(visit1 -> visit1.patient())
                .collect(Collectors.toList());
    }

    private boolean hasEmployee(Visit visit, Employee employee) {
        return visit.employees().stream()
                .anyMatch(employee1 -> employee1 == employee);
    }


}
