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
    private Lista<Employee> base_employees;
    private Lista<Employee> cpu_employees;
    private Lista<Employee> ram_employees;
    private Lista<Employee> power_employees;
    private Lista<Employee> graphic_employee;
    private Lista<Assembler> assembler;
    public ProjectManager PM;

    /**
     * Get the value of PM
     *
     * @return the value of PM
     */
    public ProjectManager getPM() {
        return PM;
    }

    /**
     * Set the value of PM
     *
     * @param PM new value of PM
     */
    public void setPM(ProjectManager PM) {
        this.PM = PM;
    }

    
    
    public Company(String name, Store store) {
        this.name = name;
        this.store = store;
        this.base_employees = new Lista<Employee>();
        this.cpu_employees = new Lista<Employee>();
        this.ram_employees = new Lista<Employee>();
        this.power_employees = new Lista<Employee>();
        this.graphic_employee = new Lista<Employee>();
        this.assembler = new Lista<Assembler>();
    }

    public void AddEmployee(Employee employee) {
        switch (employee.getType()) {
            case 1:
                System.out.println(base_employees.getSize());
                this.base_employees.AddElement(employee);
                System.out.println("Empleado añadodo a base");
                System.out.println(base_employees.getSize());
                break;
            case 2:
                System.out.println("Empleado añadodo a cpu");
                this.cpu_employees.AddElement(employee);
                System.out.println(cpu_employees.getSize());
                break;
            case 3:
                System.out.println("Empleado añadodo a ram");
                this.ram_employees.AddElement(employee);
                System.out.println(ram_employees.getSize());
                break;
            case 4:
                System.out.println("Empleado añadodo a alimentacion");
                this.power_employees.AddElement(employee);
                System.out.println(power_employees.getSize());
                break;
            case 5:
                System.out.println("Empleado añadodo a tarjeta");
                this.graphic_employee.AddElement(employee);
                System.out.println(graphic_employee.getSize());
                break;
        }
    }
    
    public void AddAssembler(Assembler assembler) {
        System.out.println("Assembler añadido");
        this.assembler.AddElement(assembler);
        System.out.println(this.assembler.getSize());
    }
    
    public void hireEmployee(Employee employee){
        AddEmployee(employee);
        employee.start();
        System.out.println("Empleado iniciado");
    }
    
    public void hireAssembler(Assembler assembler){
        AddAssembler(assembler);
        assembler.start();
        System.out.println("Assembler iniciado");
    }

    public void DeleteEmployee(int type) {
        Employee emp_deleted = null;
        switch (type) {
            case 1:
                emp_deleted = (Employee) this.base_employees.removeLast().getData();
                System.out.println("Empleado eliminado de la lista de base");
                System.out.println(base_employees.getSize());
                break;
            case 2:
                emp_deleted = (Employee) this.cpu_employees.removeLast().getData();
                System.out.println("Empleado eliminado de la lista de cpu");
                System.out.println(cpu_employees.getSize());
                break;
            case 3:
                emp_deleted = (Employee) this.ram_employees.removeLast().getData();
                System.out.println("Empleado eliminado de la lista de ram");
                System.out.println(ram_employees.getSize());
                break;
            case 4:
                emp_deleted = (Employee) this.power_employees.removeLast().getData();
                System.out.println("Empleado eliminado de la lista de power");
                System.out.println(power_employees.getSize());
                break;
            case 5:
                emp_deleted = (Employee) this.graphic_employee.removeLast().getData();
                System.out.println("Empleado eliminado de la lista de tarjeta");
                System.out.println(graphic_employee.getSize());
                break;
        }
        if(emp_deleted.isWorking()){
            emp_deleted.Stop();
        }

    }

    public void DeleteAssembler() {
        Assembler asm_deleted = null;
        
        asm_deleted = (Assembler) this.assembler.removeLast().getData();
        System.out.println("Empleado eliminado de la lista assembler");
        System.out.println(assembler.getSize());
                
        
        if(asm_deleted.isWorking()){
            asm_deleted.Stop();
        }

    }
  

    public void startAll(int dayDuration) {
        startList(base_employees, dayDuration);
        startList(cpu_employees, dayDuration);
        startList(ram_employees, dayDuration);
        startList(power_employees, dayDuration);
        startList(graphic_employee, dayDuration);
        startListAssembler(assembler);

    }

    public void startList(Lista<Employee> employees, int dayDuration) {
        Nodo<Employee> emp = employees.getFirst();
        while (emp != null) {
            emp.getData().setDayDuration(dayDuration);
            emp.getData().start();
            emp = emp.getpNext();
        }
    }
    
    public void startListAssembler(Lista<Assembler> assemblers) {
        Nodo<Assembler> emp = assemblers.getFirst();
        while (emp != null) {
            emp.getData().start();
            emp = emp.getpNext();
        }
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
    
    public Lista<Assembler> getAssembler() {
        return assembler;
    }

    public void setAssembler(Lista<Assembler> assembler) {
        this.assembler = assembler;
    }


}
