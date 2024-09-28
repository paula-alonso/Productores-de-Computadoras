/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.util.concurrent.Semaphore;

/**
 *
 * @author marie
 */
public class Director extends Thread {
    
    private float salaryAcumulate;
    private int dayDuration;
    private int salary;
    private Store store;
    private int daysCounter;
    private int daysToDeliver;
    private String status;
    private Semaphore mutex;
    private Company company;

    public Director(int dayDuration, Store store, Semaphore mutex, Company company) {
        this.dayDuration = dayDuration;
        this.store = store;
        this.mutex = mutex;
        this.company = company;
        this.salary = 60;
        this.daysToDeliver = 1;
    }

    public float getSalaryAcumulate() {
        return salaryAcumulate;
    }

    public void setSalaryAcumulate(float salaryAcumulate) {
        this.salaryAcumulate = salaryAcumulate;
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

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public int getDaysCounter() {
        return daysCounter;
    }

    public void setDaysCounter(int daysCounter) {
        this.daysCounter = daysCounter;
    }

    public int getDaysToDeliver() {
        return daysToDeliver;
    }

    public void setDaysToDeliver(int daysToDeliver) {
        this.daysToDeliver = daysToDeliver;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Semaphore getMutex() {
        return mutex;
    }

    public void setMutex(Semaphore mutex) {
        this.mutex = mutex;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
            
          
    
    
}
