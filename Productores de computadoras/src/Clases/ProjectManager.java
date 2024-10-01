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
                    Home.pmStatus.setText(status);
                    sleep(oneHour/2);
                    
                    status = "Viendo One Piece";
                    Home.pmStatus.setText(status);
                    sleep(oneHour/2);
                }
                
                // 8 horas restantes
                status= "Trabajando";
                Home.pmStatus.setText(status);
                sleep(oneHour*8);
                store.getDaysMutex().acquire();
                store.setDeadline(store.getDeadline() - 1);
                Home.daysToRealise.setText(String.valueOf(store.getDeadline()));
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
