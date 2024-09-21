/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package productores.de.computadoras;

import Clases.Company;
import Clases.Employee;
import Clases.Store;
import java.util.concurrent.Semaphore;

/**
 *
 * @author alons
 */
public class ProductoresDeComputadoras {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Semaphore mutex = new Semaphore(1);
        Store store1 = new Store(0,0,0,0);
        Store store2 = new Store(0,0,0,0);
        Company apple = new Company("apple",store1);
        Company dell = new Company("dell",store2);
        
        Employee emp1 = new Employee(1,25,0.25, apple);
        Employee emp2 = new Employee(1,25,0.25, apple);
        Employee emp3 = new Employee(1,25,0.25, apple);
        emp1.start();
        emp2.start();
        emp3.start();
        
    }
    
}
