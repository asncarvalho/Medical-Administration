/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.models;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Queries implements Serializable{
    private String description;
    private Date scheduledAppointment;

    public Queries(String description, Date scheduledAppointment) {
        this.description = description;
        this.scheduledAppointment = scheduledAppointment;
    }

    public void setDescription(String description) { this.description = description; }

    public void setScheduledAppointment(Date scheduledAppointment) { this.scheduledAppointment = scheduledAppointment; }

    public String getDescription() { return description; }

    public Date getScheduledAppointment() { return scheduledAppointment; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Queries queries = (Queries) o;
        return getDescription().equals(queries.getDescription()) && getScheduledAppointment().equals(queries.getScheduledAppointment());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDescription(), getScheduledAppointment());
    }
}

