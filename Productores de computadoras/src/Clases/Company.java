/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import EDD.Lista;
import EDD.Nodo;
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
        this.base_employees = new Lista<Employee>();
        this.cpu_employees = new Lista<Employee>();
        this.ram_employees = new Lista<Employee>();
        this.power_employees = new Lista<Employee>();
        this.graphic_employee = new Lista<Employee>();
    }

    public void AddEmployee(int type, Employee employee) {
        switch (type) {
            case 1:
                employee.setType(type);
                this.base_employees.AddElement(employee);
                break;
            case 2:
                employee.setType(type);
                this.cpu_employees.AddElement(employee);
                break;
            case 3:
                employee.setType(type);
                this.ram_employees.AddElement(employee);
                break;
            case 4:
                employee.setType(type);
                this.power_employees.AddElement(employee);
                break;
            case 5:
                employee.setType(type);
                this.graphic_employee.AddElement(employee);
                break;
        }
        employee.start();
    }
    
    public void DeleteEmployee(int type){
        Employee emp_deleted = null;
        switch (type) {
            case 1:
                emp_deleted = (Employee) this.base_employees.removeLast().getData();
                break;
            case 2:
                emp_deleted = (Employee) this.cpu_employees.removeLast().getData();
                break;
            case 3:
                emp_deleted = (Employee)  this.ram_employees.removeLast().getData();
                break;
            case 4:
                emp_deleted = (Employee)  this.power_employees.removeLast().getData();
                break;
            case 5:
                emp_deleted = (Employee)  this.graphic_employee.removeLast().getData();
                break;
        }
        emp_deleted.Stop();
        
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

    /**
     * @return the graphic_employee
     */
    public Lista<Employee> getGraphic_employee() {
        return graphic_employee;
    }

    /**
     * @param graphic_employee the graphic_employee to set
     */
    public void setGraphic_employee(Lista<Employee> graphic_employee) {
        this.graphic_employee = graphic_employee;
    }

}
