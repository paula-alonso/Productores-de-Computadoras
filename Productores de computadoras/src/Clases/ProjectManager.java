/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author marie
 */

import Interfaces.Home;
import java.util.concurrent.Semaphore;


public class ProjectManager extends Thread {
    
    private int dayDuration;
    private int salary;
    private int fault;
    private int discount;
    private String status;
    private Store store;
    
    private double salaryAcumulate;

    /**
     * Get the value of salaryAcumulate
     *
     * @return the value of salaryAcumulate
     */
    public double getSalaryAcumulate() {
        return salaryAcumulate;
    }

    /**
     * Set the value of salaryAcumulate
     *
     * @param salaryAcumulate new value of salaryAcumulate
     */
    public void setSalaryAcumulate(double salaryAcumulate) {
        this.salaryAcumulate = salaryAcumulate;
    }


    public ProjectManager(int dayDuration, Store store) {

        this.dayDuration = dayDuration;
        this.store = store;
        this.dayDuration = dayDuration;
        this.salary = 40;
        this.fault = 0;
        this.discount = 0;
        this.status = null;
        
    }
    
    @Override
    public void run() {
        while (true){
            try{
                long start_time = System.currentTimeMillis();
                int oneHour = Math.round(dayDuration/24);
                //Primeras 16 horas
                while (System.currentTimeMillis() - start_time <= (oneHour*16)){
                    status = "Trabajando";
                    if ("Apple".equals(this.store.getCompany().getName())){
                        Home.pmStatus.setText(status);
                    } else {
                        Home.pmStatus1.setText(status);
                    }
                  
                    sleep(oneHour/2);
                    
                    status = "Viendo One Piece";
                    
                    if ("Apple".equals(this.store.getCompany().getName())){
                        Home.pmStatus.setText(status);
                    } else {
                        Home.pmStatus1.setText(status);
                    }
                    
                    sleep(oneHour/2);
                }
                
                // 8 horas restantes
                status= "Trabajando";
                if ("Apple".equals(this.store.getCompany().getName())){
                    Home.pmStatus.setText(status);
                } else {
                    Home.pmStatus1.setText(status);
                }
                sleep(oneHour*8);
                store.getDaysMutex().acquire();
                store.setDeadline(store.getDeadline() - 1);
                
                if ("Apple".equals(this.store.getCompany().getName())){
                    Home.daysToRealise.setText(String.valueOf(store.getDeadline()));
                } else {
                    Home.daysToRealise1.setText(String.valueOf(store.getDeadline()));
                }
                
                store.getDaysMutex().release();  
            }catch (InterruptedException ex){
            
            }
        }
        
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
    
}
