/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;



/**
 *
 * @author alons
 */
public class Employee extends Thread{
    private int type;
    private double salary;
    private double day_count;
    private final double day_proportion;
    private Company company;

    public Employee(double salary, Company company, double day_proportion) {
        this.type = 0;
        this.salary = salary;
        this.day_count= 0;
        this.day_proportion = day_proportion;
        this.company = null;
    }

    /**
     * @return the type
     */
    public int getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(int type) {
        this.type = type;
    }

    /**
     * @return the salary
     */
    public double getSalary() {
        return salary;
    }

    /**
     * @param salary the salary to set
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    @Override 
    public void run(){
        for (int i = 1; i <= 5; i++){
            work();
        }
    }
    
    public void work(){
        
        if(this.day_count==1){
            try{
                this.company.getMutex().acquire();
                this.company.getStore().AddComponent(this.type);
                this.company.getMutex().release();
                this.day_count = 0;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } 
        this.day_count += this.day_proportion;
    }
    
    
}
