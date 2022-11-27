package ch.rr.calender.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Appointment {
    private static DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");
    private String titel;
    private LocalDateTime date;
    private LocalTime begin;
    private LocalTime end;
    private String note;

    public Appointment(String titel, LocalDate date, String begin, String end, String note) {
        this.titel = titel;
        this.date = date.atStartOfDay();
        this.begin = LocalTime.parse(begin.trim(), TIME_FORMATTER);
        this.end = LocalTime.parse(end.trim(), TIME_FORMATTER);

    }

    public Appointment(String titel, LocalDateTime date, LocalTime begin, LocalTime end, String note) {
        this.titel = titel;
        this.date = date;
        this.begin = begin;
        this.end = end;

    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public LocalTime getBegin() {
        return begin;
    }

    public void setBegin(LocalTime begin) {
        this.begin = begin;
    }

    public LocalTime getEnd() {
        return end;
    }

    public void setEnd(LocalTime end) {
        this.end = end;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }
}
