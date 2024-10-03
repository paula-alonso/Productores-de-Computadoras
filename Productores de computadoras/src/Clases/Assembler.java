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
    
    private double salary;
    private Semaphore mutex;
    private int dayDuration;
    private int dayCounter;
    private int daysToAssemble;
    private float salaryTotal;
    private int quantityEmployees;
    private Store store;
    private Company company;
    private boolean working;

    public Assembler(Store store) {
        this.mutex = store.getProductionMutex();
        this.dayDuration = dayDuration;
        this.company =  store.getCompany();
        this.quantityEmployees = quantityEmployees;
        this.store = store;
        this.dayCounter = 0;
        this.salary = 50;
        this.daysToAssemble = 2;
        this.salaryTotal = 0;
        this.working = true;
        
    }

    public boolean isWorking() {
        return working;
    }

    public void setWorking(boolean working) {
        this.working = working;
    }
    
    public void Stop() {
        this.setWorking(false);
        System.out.println("empleado detenido");
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
                sleep(this.dayDuration); // Gestiona la velocidad con que avanzan los días
            } catch (InterruptedException ex) {
                Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    /**
     * Función para el trabajo del Ensamblador
     */
    public void work () {
        
        this.dayCounter += 1; // Se suma un día de trabajo
        if (this.dayCounter == this.daysToAssemble) { // Si ya han pasado los días necesarios para ensamblar
            try {
               this.getMutex().acquire(); // wait
               this.store.assembleComputer(this.company.getAssembler().getSize()); // Se ensamblan las computadoras
               this.getMutex().release(); // signal
               this.dayCounter = 0; // Se reinicia el contador de días
            } catch (InterruptedException ex) { // Si hay una interrupción al tratar de aplicar la exclusión mutua al hilo
                Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex); //
            }
        }
    }
    
    /**
     * Checkea que se tengan los componentes necesarios para ensamblar en Store
     * @return ready
     */
    public boolean check(){
        boolean ready = false; 
        try {
            this.mutex.acquire(); // wait
            ready = this.store.check(); // Revisa la función Check de la tienda para verificar si se tienen los componentes necesarios
            this.mutex.release(); // signal
        } catch (InterruptedException ex) { // 
            Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ready;
    }
    
    
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
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
