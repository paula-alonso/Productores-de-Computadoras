/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productores.de.computadoras;

import Clases.Company;
import Clases.Employee;
import Clases.Store;
import EDD.Lista;
import java.awt.Component;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author alons
 */
public class Functions {

    private static Component areaTexto;

    public static File FileChooser() {

        File fichero = null;

        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(".TXT", "txt");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setFileFilter(filter);
        int seleccion = fileChooser.showOpenDialog(areaTexto);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            fichero = fileChooser.getSelectedFile();
            String path = fichero.getAbsolutePath();
            if (!path.contains("txt")) {
                JOptionPane.showMessageDialog(null, "Por favor elija un archivo del tipo txt");
                return null;
            }
        }

        return fichero;

    }

    public static Company[] LeerTxt(File archivo) {
        
        Company[] companies = new Company[2];
        String line;
        String computadorastxt = "";
        //String path = "test\\computadoras.txt";
        File file = archivo;
        try {
            if (!file.exists()) {
                file.createNewFile();
            } else {
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                while ((line = br.readLine()) != null) {
                    if (!line.isEmpty()) {
                        computadorastxt += line + "\n";
                    }
                }
                if (!"".equals(computadorastxt)) {

                    String company_name = "";
                    String[] sections = computadorastxt.split("\n");
                    double duration = Integer.parseInt(sections[1].replace(";", ""));
                    double deadline = Integer.parseInt(sections[3].replace(";", ""));
                    int i = 5;
                    while (i < sections.length) {
                        company_name = sections[i].replace("/", "").trim();
                        Store store = new Store();
                        Company company = new Company(company_name, store);
                        Lista<Employee> base_employee = new Lista<Employee>();
                        Lista<Employee> cpu_employee = new Lista<Employee>();
                        Lista<Employee> ram_employee = new Lista<Employee>();
                        Lista<Employee> power_employee = new Lista<Employee>();
                        Lista<Employee> graphic_employee = new Lista<Employee>();
                        i += 2; // Saltar a la sección de trabajadores

                        // Leer los trabajadores de la empresa
                        while (i < sections.length && !sections[i].contains("/")) {
                            String[] trabajador = sections[i].split(",");
                            String type = trabajador[0];
                            double salary = Integer.parseInt(trabajador[2]);
                            double day_prod = Integer.parseInt(trabajador[3]);
                            int num = 0;
                            Employee employee = new Employee(salary, company, day_prod);
                            for (int j = 1; j <= Integer.parseInt(trabajador[1]); j++) {
                                switch (type) {
                                    case "base":
                                        num = 1;
                                        employee.setType(num);
                                        base_employee.AddElement(employee);
                                        break;
                                    case "cpu":
                                        num = 2;
                                        employee.setType(num);
                                        cpu_employee.AddElement(employee);
                                        break;
                                    case "ram":
                                        num = 3;
                                        employee.setType(num);
                                        ram_employee.AddElement(employee);
                                        break;
                                    case "power":
                                        num = 4;
                                        employee.setType(num);
                                        power_employee.AddElement(employee);
                                        break;
                                    case "graphic":
                                        num = 5;
                                        employee.setType(num);
                                        graphic_employee.AddElement(employee);
                                        break;
                                }
                            }
                            

                        }
                        companies[0] = company;
                        i++;
                    }
                }

                br.close();
                JOptionPane.showMessageDialog(null, "Lectura exitosa");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

        return companies;

    }
}
