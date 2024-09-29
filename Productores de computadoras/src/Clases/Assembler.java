/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.util.logging.Level;
import java.util.logging.Logger;
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
    private int quantityEmployees;
    private Store store;

    public Assembler(Semaphore mutex, int dayDuration, int quantityWorkers, Store store) {
        this.mutex = mutex;
        this.dayDuration = dayDuration;
        this.quantityEmployees = quantityWorkers;
        this.store = store;
        this.dayCounter = 0;
        this.salary = 50;
        this.daysToAssemble = 2;
        this.salaryTotal = 0;
        
    }
    
    @Override
    public void run(){
        while(true) {
            try {  
                //paySalary();
                if (dayCounter == 0){ // comentar
                    if (check()){
                        work();
                    }
                }else{
                    work();
                }
                sleep(this.dayDuration);
            } catch (InterruptedException ex) {
                Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    public void work () {
        
        this.dayCounter += 1;
        if (this.dayCounter == this.daysToAssemble) {
            try {
                this.mutex.acquire(); // wait
                this.store.assembleComputer(this.quantityEmployees);
                this.mutex.release(); // signal
                this.dayCounter = 0;
            } catch (InterruptedException ex) {
                Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public boolean check(){
        boolean ready = false;
        try {
            this.mutex.acquire(); // wait
            ready = this.store.check();
            this.mutex.release(); // signal
        } catch (InterruptedException ex) {
            Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ready;
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

    public int getQuantityEmployees() {
        return quantityEmployees;
    }

    public void setQuantityEmployees(int quantityEmployees) {
        this.quantityEmployees = quantityEmployees;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }
    
     
}
