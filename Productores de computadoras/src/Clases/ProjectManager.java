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
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProjectManager extends Thread {

    private int dayDuration;
    private int salary;
    private int fault;
    private int discount;
    private String status;
    private Store store;
    private Semaphore mutex;

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
        this.mutex = store.getProductionMutex();

    }

    @Override
    public void run() {
        while (true) {
            int oneHour = Math.round(dayDuration / 24);
            for (int i = 1; i <= 16; i++) { //simula las 16 horas
                try {
                    status = "Trabajando";
                    if ("Apple".equals(this.store.getCompany().getName())) {
                        Home.pmStatus.setText(status);
                    } else {
                        Home.pmStatus1.setText(status);
                    }
                    sleep(oneHour / 2);//espera media hora
                    status = "Viendo One Piece";
                    if ("Apple".equals(this.store.getCompany().getName())) {
                        Home.pmStatus.setText(status);
                    } else {
                        Home.pmStatus1.setText(status);
                    }
                    sleep(oneHour / 2);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ProjectManager.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("error en pm en las 16 horas " + this.store.getCompany());
                }
            }
            status = "Trabajando";
            if ("Apple".equals(this.store.getCompany().getName())) {
                Home.pmStatus.setText(status);
            } else {
                Home.pmStatus1.setText(status);
            }
            
            try {
                sleep(oneHour * 8); //siguientes 8 horas
                store.getProductionMutex().acquire();
                if (store.getDeadline() > 0) {
                    store.setDeadline(store.getDeadline() - 1);
                    if ("Apple".equals(this.store.getCompany().getName())) {
                        Home.daysToRealise.setText(String.valueOf(store.getDeadline()));
                    } else {
                        Home.daysToRealise1.setText(String.valueOf(store.getDeadline()));
                    }
                }
                paySalary();
                Global.setDaycounter(Global.getDaycounter() + 1);
                store.getProductionMutex().release();
            } catch (InterruptedException ex) {
                Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void work(int oneHour) {
        try {
            sleep(oneHour * 8);
            store.getProductionMutex().acquire();
            if (store.getDeadline() > 0) {
                store.setDeadline(store.getDeadline() - 1);
                if ("Apple".equals(this.store.getCompany().getName())) {
                    Home.daysToRealise.setText(String.valueOf(store.getDeadline()));
                } else {
                    Home.daysToRealise1.setText(String.valueOf(store.getDeadline()));
                }
            }
            store.getProductionMutex().release();
        } catch (InterruptedException ex) {
            Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void paySalary() {
        store.setCosts(store.getCosts() + salary * 24, store.getCompany().getName());
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
