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
public class Assembler extends Thread {
    
    private int salary;
    private Semaphore mutex;
    private int dayDuration;
    private int dayCounter;
    private int daysToAssemble;
    private float salaryTotal;
    private int quantityWorkers;
    private Store store;

    public Assembler(Semaphore mutex, int dayDuration, int quantityWorkers, Store store) {
        this.mutex = mutex;
        this.dayDuration = dayDuration;
        this.quantityWorkers = quantityWorkers;
        this.store = store;
        this.dayCounter = 0;
        this.salary = 50;
        this.daysToAssemble = 2;
        this.salaryTotal = 0;
        
    }
    

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
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

    public int getDayCounter() {
        return dayCounter;
    }

    public void setDayCounter(int dayCounter) {
        this.dayCounter = dayCounter;
    }

    public int getDaysToAssemble() {
        return daysToAssemble;
    }

    public void setDaysToAssemble(int daysToAssemble) {
        this.daysToAssemble = daysToAssemble;
    }

    public float getSalaryTotal() {
        return salaryTotal;
    }

    public void setSalaryTotal(float salaryTotal) {
        this.salaryTotal = salaryTotal;
    }

    public int getQuantityWorkers() {
        return quantityWorkers;
    }

    public void setQuantityWorkers(int quantityWorkers) {
        this.quantityWorkers = quantityWorkers;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }
    
     
}
