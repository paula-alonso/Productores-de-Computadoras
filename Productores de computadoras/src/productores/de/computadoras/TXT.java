/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productores.de.computadoras;

import Clases.Assembler;
import Clases.Company;
import Clases.Employee;
import Clases.Store;
import EDD.Lista;
import java.awt.Component;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author alons
 */
public class TXT {

    private static Component areaTexto;
    private Lista<Company> companies;
    private int deadline;
    private int dayDuration;

    public TXT() {
        this.companies = new Lista<Company>();
        this.deadline = 0;
        this.dayDuration = 0;
    }


    public void LeerTxt() {
        String line;
        String computadorastxt = "";
        //String path = "test\\computadoras.txt";
        try {
            InputStream inputStream = getClass().getResourceAsStream("computadoras.txt"); // Cambia esto según la ubicación del archivo
            if (inputStream == null) {
                throw new FileNotFoundException("El archivo no se encuentra dentro del proyecto.");
            } else {
                BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
                while ((line = br.readLine()) != null) {
                    if (!line.isEmpty()) {
                        computadorastxt += line + "\n";
                    }
                }
                if (!"".equals(computadorastxt)) {

                    String company_name = "";
                    String[] sections = computadorastxt.split("\n");
                    setDayDuration(Integer.parseInt(sections[1].replace(";", "")));
                    setDeadline(Integer.parseInt(sections[3].replace(";", "")));
                    int i = 5;
                    while (i < sections.length) {
                        company_name = sections[i].replace("/", "").trim();
                        Store store = new Store(getDeadline());
                        Company company = new Company(company_name, store);
                        store.setCompany(company);

                        if ("Apple".equals(company_name)) {

                            int[] necessaryComponents = {2, 1, 4, 4};
                            store.setNecessaryComponents(necessaryComponents);
                            store.setComputerPrice(150);
                            store.setGraphicsQuantity(2);
                            company.setMaxEmployees(18);

                        } else {
                            int[] necessaryComponents = {1, 5, 6, 5};
                            store.setNecessaryComponents(necessaryComponents);
                            store.setComputerPrice(80);
                            store.setGraphicsQuantity(1);
                            company.setMaxEmployees(17);
                        }

                        i += 2; // Saltar a la sección de trabajadores

                        // Leer los trabajadores de la empresa
                        while (i < sections.length && !sections[i].contains("/")) {
                            String[] trabajador = sections[i].split(",");
                            String type = trabajador[0];
                            int num = 0;
                            switch (type) {
                                case "base" ->
                                    num = 1;
                                case "cpu" ->
                                    num = 2;
                                case "ram" ->
                                    num = 3;
                                case "power" ->
                                    num = 4;
                                case "graphic" ->
                                    num = 5;
                                case "assembler" ->
                                    num = 6;
                            }
                            double salary = Double.parseDouble(trabajador[2]);
                            double day_prod = Double.parseDouble(trabajador[3]);
                            for (int j = 1; j <= Integer.parseInt(trabajador[1]); j++) {
                                if (num < 6) {
                                    Employee employee = new Employee(salary, company, day_prod);
                                    employee.setType(num);
                                    company.AddEmployee(employee);
                                } else {
                                    Assembler assembler = new Assembler(store, dayDuration);
                                    company.AddAssembler(assembler);
                                }

                            }
                            i++;

                        }
                        getCompanies().AddElement(company);
                    }
                }

                br.close();
                JOptionPane.showMessageDialog(null, "Lectura exitosa");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void editTxt(int newDuracion, int newDeadline, Company company1, Company company2) {
        
        try {
            int base_number = company1.getBase_employees().getSize();
            int cpu_number = company1.getCpu_employees().getSize();
            int ram_number = company1.getRam_employees().getSize();
            int power_number = company1.getPower_employees().getSize();
            int graphic_number = company1.getGraphic_employee().getSize();
            int assembler_number = company1.getAssembler().getSize();
             int base_number1 = company2.getBase_employees().getSize();
            int cpu_number1 = company2.getCpu_employees().getSize();
            int ram_number1 = company2.getRam_employees().getSize();
            int power_number1 = company2.getPower_employees().getSize();
            int graphic_number1 = company2.getGraphic_employee().getSize();
            int assembler_number1 = company2.getAssembler().getSize();
            
            String todoTXT = "Duracion\n"
                    + newDuracion+";\n"
                    + "Deadline\n"
                    + newDeadline+";\n"
                    + "Empresas\n"
                    + "Apple/\n"
                    + "Trabajadores:\n"
                    + "base,"+base_number+",20,0.25\n"
                    + "cpu,"+cpu_number+",26,0.25\n"
                    + "ram,"+ram_number+",40,1\n"
                    + "power,"+power_number+",16,5\n"
                    + "graphic,"+graphic_number+",34,0.5\n"
                    + "assembler,"+assembler_number+",50,2\n"
                    + "Dell/\n"
                    + "Trabajadores:\n"
                    + "base,"+base_number1+",20,0.34\n"
                    + "cpu,"+cpu_number1+",26,0.34\n"
                    + "ram,"+ram_number1+",40,2\n"
                    + "power,"+power_number1+",16,5\n"
                    + "graphic,"+graphic_number1+",34,0.5\n"
                    + "assembler,"+assembler_number1+",50,2";
            System.out.println(todoTXT);
            
            String path = "src\\productores\\de\\computadoras\\computadoras.txt";
            
            System.out.println(path);
            
            String paths = getClass().getResource("computadoras.txt").toString();
            
            System.out.println(paths);
            
            PrintWriter writer = new PrintWriter(path);
            
            writer.print(todoTXT);
            writer.close();
            
            

            JOptionPane.showMessageDialog(null, "Archivo editado exitosamente");
            
            

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    /**
     * @return the companies
     */
    public Lista<Company> getCompanies() {
        return companies;
    }

    /**
     * @return the deadline
     */
    public int getDeadline() {
        return deadline;
    }

    /**
     * @param deadline the deadline to set
     */
    public void setDeadline(int deadline) {
        this.deadline = deadline;
    }

    /**
     * @return the dayDuration
     */
    public int getDayDuration() {
        return dayDuration;
    }

    /**
     * @param dayDuration the dayDuration to set
     */
    public void setDayDuration(int dayDuration) {
        this.dayDuration = dayDuration;
    }
}
