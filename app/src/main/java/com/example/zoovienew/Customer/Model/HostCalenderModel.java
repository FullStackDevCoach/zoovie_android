package com.example.zoovienew.Customer.Model;

public class HostCalenderModel
{
    String fulldate,date,month,year;

    public HostCalenderModel(String fulldate, String date, String month, String year) {
        this.fulldate = fulldate;
        this.date = date;
        this.month = month;
        this.year = year;
    }

    public String getFulldate() {
        return fulldate;
    }

    public void setFulldate(String fulldate) {
        this.fulldate = fulldate;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
