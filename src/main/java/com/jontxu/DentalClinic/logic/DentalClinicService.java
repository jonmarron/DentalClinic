package com.jontxu.DentalClinic.logic;

import com.jontxu.DentalClinic.data.Visit;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class DentalClinicService {
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

    
}
