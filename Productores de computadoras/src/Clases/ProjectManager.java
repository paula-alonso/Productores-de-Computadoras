/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author marie
 */

import java.util.concurrent.Semaphore;


public class ProjectManager extends Thread {
    
    private Semaphore mutex;
    private int dayDuration;
    private int salary;
    private int fault;
    private int discount;
    private String status;
    private int hoursCounter;
    private int minutesCounter;
    private int daysCounter;
    private Company company;

    public ProjectManager(Semaphore mutex, int dayDuration, Company company) {
        this.mutex = mutex;
        this.dayDuration = dayDuration;
        this.company = company;
        this.dayDuration = dayDuration;
        this.salary = 40;
        this.fault = 0;
        this.discount = 0;
        this.minutesCounter = 0;
        this.hoursCounter = 0;
        this.daysCounter = 0;
        this.status = "Working...";
        
    }

    public Semaphore getMutex() {
        return mutex;
    }

    public void setMutex(Semaphore mutex) {
        this.mutex = mutex;
    }

    public int getDayDuration() {
        return dayDuration;
    }

    public void setDayDuration(int dayDuration) {
        this.dayDuration = dayDuration;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getFault() {
        return fault;
    }

    public void setFault(int fault) {
        this.fault = fault;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getHoursCounter() {
        return hoursCounter;
    }

    public void setHoursCounter(int hoursCounter) {
        this.hoursCounter = hoursCounter;
    }

    public int getMinutesCounter() {
        return minutesCounter;
    }

    public void setMinutesCounter(int minutesCounter) {
        this.minutesCounter = minutesCounter;
    }

    public int getDaysCounter() {
        return daysCounter;
    }

    public void setDaysCounter(int daysCounter) {
        this.daysCounter = daysCounter;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    
    
    
}
