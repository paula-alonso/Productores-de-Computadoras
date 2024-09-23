/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import EDD.Lista;
import java.util.concurrent.Semaphore;

/**
 *
 * @author alons
 */
public class Company {
    private String name;
    private Store store;
    private Semaphore mutex;
    private Lista<Employee> base_employees;
    private Lista<Employee> cpu_employees;
    private Lista<Employee> ram_employees;
    private Lista<Employee> power_employees;
    private Lista<Employee> graphic_employee;

    public Company(String name, Store store) {
        this.name = name;
        this.store = store;
        this.mutex = new Semaphore(1);
        this.base_employees = null;
        this.cpu_employees = null;
        this.ram_employees = null;
        this.power_employees = null;
        this.graphic_employee=null;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the store
     */
    public Store getStore() {
        return store;
    }

    /**
     * @param store the store to set
     */
    public void setStore(Store store) {
        this.store = store;
    }

    /**
     * @return the mutex
     */
    public Semaphore getMutex() {
        return mutex;
    }

    /**
     * @param mutex the mutex to set
     */
    public void setMutex(Semaphore mutex) {
        this.mutex = mutex;
    }

    /**
     * @return the base_employees
     */
    public Lista<Employee> getBase_employees() {
        return base_employees;
    }

    /**
     * @param base_employees the base_employees to set
     */
    public void setBase_employees(Lista<Employee> base_employees) {
        this.base_employees = base_employees;
    }

    /**
     * @return the cpu_employees
     */
    public Lista<Employee> getCpu_employees() {
        return cpu_employees;
    }

    /**
     * @param cpu_employees the cpu_employees to set
     */
    public void setCpu_employees(Lista<Employee> cpu_employees) {
        this.cpu_employees = cpu_employees;
    }

    /**
     * @return the ram_employees
     */
    public Lista<Employee> getRam_employees() {
        return ram_employees;
    }

    /**
     * @param ram_employees the ram_employees to set
     */
    public void setRam_employees(Lista<Employee> ram_employees) {
        this.ram_employees = ram_employees;
    }

    /**
     * @return the power_employees
     */
    public Lista<Employee> getPower_employees() {
        return power_employees;
    }

    /**
     * @param power_employees the power_employees to set
     */
    public void setPower_employees(Lista<Employee> power_employees) {
        this.power_employees = power_employees;
    }
    
    
}
