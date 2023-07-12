package com.jontxu.DentalClinic.data;

import java.time.LocalDate;
import java.util.List;

public record Visit(Patient patient, List<Employee> employees, int tooth, String description, String procedureType, LocalDate date) {
}
