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

    public static Lista<Company> LeerTxt(File archivo) {
        
        Lista<Company> companies = new Lista<Company>();
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
                    double duration = Double.parseDouble(sections[1].replace(";", ""));
                    double deadline = Double.parseDouble(sections[3].replace(";", ""));
                    int i = 5;
                    while (i < sections.length) {
                        company_name = sections[i].replace("/", "").trim();
                        Store store = new Store();
                        Company company = new Company(company_name, store);
                        i += 2; // Saltar a la sección de trabajadores

                        // Leer los trabajadores de la empresa
                        while (i < sections.length && !sections[i].contains("/")) {
                            String[] trabajador = sections[i].split(",");
                            String type = trabajador[0];
                            int num=0;
                            switch (type) {
                                    case "base":
                                        num = 1;
                                        break;
                                    case "cpu":
                                        num = 2;
                                        break;
                                    case "ram":
                                        num = 3;
                                        break;
                                    case "power":
                                        num = 4;
                                        break;
                                    case "graphic":
                                        num = 5;
                                        break;
                                }
                            double salary = Double.parseDouble(trabajador[2]);
                            double day_prod = Double.parseDouble(trabajador[3]);
                            for (int j = 1; j <= Integer.parseInt(trabajador[1]); j++) {
                                Employee employee = new Employee(salary, company, day_prod);
                                company.AddEmployee(num, employee);
                            }
                            i++;
                            

                        }
                        companies.AddElement(company);
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
