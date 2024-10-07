/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import Interfaces.Home;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    private Semaphore mutex2;

    /**
     * Get the value of mutex2
     *
     * @return the value of mutex2
     */
    public Semaphore getMutex2() {
        return mutex2;
    }

    /**
     * Set the value of mutex2
     *
     * @param mutex2 new value of mutex2
     */
    public void setMutex2(Semaphore mutex2) {
        this.mutex2 = mutex2;
    }

    private boolean directorMode;

    /**
     * Get the value of directorMode
     *
     * @return the value of directorMode
     */
    public boolean isDirectorMode() {
        return directorMode;
    }

    /**
     * Set the value of directorMode
     *
     * @param directorMode new value of directorMode
     */
    public void setDirectorMode(boolean directorMode) {
        this.directorMode = directorMode;
    }

    public Director(int dayDuration, Store store) {
        this.dayDuration = dayDuration;
        this.store = store;
        this.mutex = store.getProductionMutex();
        this.company = store.getCompany();
        this.status = "Labores Administrativas";
        this.salary = 60;
        this.daysToDeliver = 1;
        this.directorMode = false;
        this.reinicioDeadline = store.getDeadline();
        this.mutex2 = store.getProductionMutex();
    }
    private int reinicioDeadline;

    /**
     * Get the value of reinicioDeadline
     *
     * @return the value of reinicioDeadline
     */
    public int getReinicioDeadline() {
        return reinicioDeadline;
    }

    /**
     * Set the value of reinicioDeadline
     *
     * @param reinicioDeadline new value of reinicioDeadline
     */
    public void setReinicioDeadline(int reinicioDeadline) {
        this.reinicioDeadline = reinicioDeadline;
    }

    @Override
    public void run() {
        if ("Apple".equals(this.company.getName())) {
            Home.directorStatus.setText(status);
        } else {
            Home.directorStatus1.setText(status);
        }
        while (true) {
            if (this.store.getDeadline() <= 0) {
                try {
                    status = "Enviando Computadoras";
                    if ("Apple".equals(this.company.getName())) {
                        Home.directorStatus.setText(status);
                    } else {
                        Home.directorStatus1.setText(status);
                    }
                    sleep(dayDuration);
                    mutex.acquire();
                    this.store.setDeadline(reinicioDeadline);
                    if ("Apple".equals(this.store.getCompany().getName())) {
                        Home.daysToRealise.setText(Integer.toString(this.store.getDeadline()));
                    } else {
                        Home.daysToRealise1.setText(Integer.toString(this.store.getDeadline()));
                    }
                    store.sendComputers();
                    mutex.release();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Director.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (store.getDeadline() > 0) {
                Random random = new Random();
                int horaAleatoria;
                while ((horaAleatoria = random.nextInt(24)) == 0) {
                    horaAleatoria = random.nextInt(24);
                }
                for (int i = 1; i <= 24; i++) {
                    try {
                        status = "Labores administrativas";
                        if ("Apple".equals(this.company.getName())) {
                            Home.directorStatus.setText(status);
                        } else {
                            Home.directorStatus1.setText(status);
                        }
                        if (i == horaAleatoria) {
                            status = "Revisando al Project Manager";
                            if ("Apple".equals(this.company.getName())) {
                                Home.directorStatus.setText(status);
                            } else {
                                Home.directorStatus1.setText(status);
                            }
                            mutex.acquire();
                            boolean continuar = checkPM();
                            if (!continuar) {
                                sleep((long) ((dayDuration / 24) / (60 / 17)));
                                // System.out.println(pm.getEstado()+" el pm esta "+ drive.getEstudio());
                                continuar = checkPM();
                                //System.out.println(pm.getEstado()+" el pm esta");
                            }
                            if (!continuar) {
                                sleep((long) ((dayDuration / 24) / (60 / 17)));
                                //System.out.println(pm.getEstado()+" el pm esta "+ drive.getEstudio());
                                checkPM();
                            }
                            mutex.release();
                        }
                        sleep((long) ((dayDuration/24) / (12 / 7)));
                    } catch (InterruptedException ex){
                        Logger.getLogger(Director.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
                paySalary();
            }
//            try {
//                if (directorMode) {
//
//                    sleep(this.dayDuration); // Dura 1 día haciendo esto
//                    work();
//                    restartDeadline();
//                } else {
//                    double randomHour = Math.random() * 24;
//                    int random = (int) randomHour;
//                    sleep((this.dayDuration * random) / 24);
//
//                    status = "Revisando PM";
//
//                    if ("Apple".equals(this.company.getName())) {
//                        Home.directorStatus.setText(status);
//                    } else {
//                        Home.directorStatus1.setText(status);
//                    }
//
//                    checkPM();
//                    sleep((dayDuration * 30) / (24 * 60));
//                    checkPM();
//                    sleep((dayDuration * 5) / (24 * 60));
//
//                    status = "Labores Administrativos";
//
//                    if ("Apple".equals(this.company.getName())) {
//                        Home.directorStatus.setText(status);
//                    } else {
//                        Home.directorStatus1.setText(status);
//                    }
//
//                    sleep((dayDuration * 25) / (60 * 24));
//                    sleep((this.dayDuration * (24 - random)) / 24);
//
//                }
//
//            } catch (InterruptedException ex) {
//                Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
//            }
        }
    }

    public void paySalary() {
        try{
            mutex.acquire();
            store.setCosts(store.getCosts() + salary*24, company.getName());
            mutex.release();
        }catch(InterruptedException ex){
            Logger.getLogger(Director.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void checkDeadline() {
        try {
            this.mutex.acquire(); //wait
            if (this.store.getDeadline() <= 0) {
                directorMode = true;
            }
            this.mutex.release(); // signal
        } catch (InterruptedException ex) {
            Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void restartDeadline() {
        try {
            this.mutex.acquire(); //wait
            this.store.setDeadline(reinicioDeadline);
            if ("Apple".equals(this.store.getCompany().getName())) {
                Home.daysToRealise.setText(Integer.toString(this.store.getDeadline()));
            } else {
                Home.daysToRealise1.setText(Integer.toString(this.store.getDeadline()));
            }
            this.mutex.release(); // signal
        } catch (InterruptedException ex) {
            Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void work() {
        this.daysCounter += 1;
        if (this.daysCounter == this.daysToDeliver) { // 
            try {
                this.mutex.acquire(); //wait
                store.sendComputers();
                this.mutex.release(); // signal
                this.daysCounter = 0;
                directorMode = false;
            } catch (InterruptedException ex) {
                Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public boolean checkPM() {
        if (company.getPM().getStatus().equals("Viendo One Piece")) {
            company.getPM().setFault(company.getPM().getFault() + 1);

            if ("Apple".equals(this.store.getCompany().getName())) {
                Home.PMfaults.setText("Faltas PM: " + Integer.toString(company.getPM().getFault()));
            } else {
                Home.PMfaults1.setText("Faltas PM: " + Integer.toString(company.getPM().getFault()));
            }

            company.getPM().setDiscount(company.getPM().getDiscount() + 100);

            if ("Apple".equals(this.store.getCompany().getName())) {
                Home.discount.setText("Sueldo descontado: " + Integer.toString(company.getPM().getDiscount()));
            } else {
                Home.discount1.setText("Sueldo descontado: " + Integer.toString(company.getPM().getDiscount()));
            }
            company.getPM().setSalaryAcumulate(company.getPM().getSalaryAcumulate() - 100);
            return true;
        } else {
            return false;
        }
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
