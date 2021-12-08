package main.models;

import lombok.Data;

import java.util.Date;

@Data
public class MedicalAppointment {
    private Doctor doctor;
    private Patient patient;
    private Date expectedDate;
}
