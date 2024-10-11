/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import Clases.Assembler;
import Clases.Company;
import Clases.Director;
import Clases.Employee;
import Clases.ProjectManager;
import EDD.Lista;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.HashMap;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import productores.de.computadoras.TXT;

/**
 *
 * @author alons
 */
public class Home extends javax.swing.JFrame {

    Lista<Company> companies = new Lista<Company>();
    static TXT txt = new TXT();
    boolean running;
    boolean inicialized = false;
    static Company apple;
    static Company dell;
    ProjectManager pmApple;
    ProjectManager pmDell;
    Director directorApple;
    Director directorDell;
    
    

    /**
     * Creates new form Home
     */
    public Home() {
        initComponents();
        this.setLocationRelativeTo(null);
        JFormattedTextField spinnerTextField1 = ((JSpinner.DefaultEditor) base_emp_quantity.getEditor()).getTextField();
        JFormattedTextField spinnerTextField2 = ((JSpinner.DefaultEditor) cpu_emp_quantity.getEditor()).getTextField();
        JFormattedTextField spinnerTextField3 = ((JSpinner.DefaultEditor) ram_emp_quantity.getEditor()).getTextField();
        JFormattedTextField spinnerTextField4 = ((JSpinner.DefaultEditor) power_emp_quantity.getEditor()).getTextField();
        JFormattedTextField spinnerTextField5 = ((JSpinner.DefaultEditor) graphic_emp_quantity.getEditor()).getTextField();
        JFormattedTextField spinnerTextField6 = ((JSpinner.DefaultEditor) base_emp_quantity1.getEditor()).getTextField();
        JFormattedTextField spinnerTextField7 = ((JSpinner.DefaultEditor) cpu_emp_quantity1.getEditor()).getTextField();
        JFormattedTextField spinnerTextField8 = ((JSpinner.DefaultEditor) ram_emp_quantity1.getEditor()).getTextField();
        JFormattedTextField spinnerTextField9 = ((JSpinner.DefaultEditor) power_emp_quantity1.getEditor()).getTextField();
        JFormattedTextField spinnerTextField10 = ((JSpinner.DefaultEditor) graphic_emp_quantity1.getEditor()).getTextField();
        JFormattedTextField spinnerTextField11 = ((JSpinner.DefaultEditor) assembler_emp_quantity.getEditor()).getTextField();
        JFormattedTextField spinnerTextField12 = ((JSpinner.DefaultEditor) assembler_emp_quantity1.getEditor()).getTextField();

        initSpinners(spinnerTextField1);
        initSpinners(spinnerTextField2);
        initSpinners(spinnerTextField3);
        initSpinners(spinnerTextField4);
        initSpinners(spinnerTextField5);
        initSpinners(spinnerTextField6);
        initSpinners(spinnerTextField7);
        initSpinners(spinnerTextField8);
        initSpinners(spinnerTextField9);
        initSpinners(spinnerTextField10);
        initSpinners(spinnerTextField11);
        initSpinners(spinnerTextField12);

        loadInfo();
    }
    
    

    private void loadInfo() {
        txt.LeerTxt();
        companies = txt.getCompanies();
        //Apple
        apple = companies.getFirst().getData();

        base_emp_quantity.setValue(apple.getBase_employees().getSize());
        cpu_emp_quantity.setValue(apple.getCpu_employees().getSize());
        ram_emp_quantity.setValue(apple.getRam_employees().getSize());
        power_emp_quantity.setValue(apple.getPower_employees().getSize());
        graphic_emp_quantity.setValue(apple.getGraphic_employee().getSize());
        assembler_emp_quantity.setValue(apple.getAssembler().getSize());

        //Dell
        dell = companies.getLast().getData();

        base_emp_quantity1.setValue(dell.getBase_employees().getSize());
        cpu_emp_quantity1.setValue(dell.getCpu_employees().getSize());
        ram_emp_quantity1.setValue(dell.getRam_employees().getSize());
        power_emp_quantity1.setValue(dell.getPower_employees().getSize());
        graphic_emp_quantity1.setValue(dell.getGraphic_employee().getSize());
        assembler_emp_quantity1.setValue(dell.getAssembler().getSize());

        //Day duration
        dayDuration.setValue(txt.getDayDuration());

        //Deadline
        deadline.setValue(txt.getDeadline());

        inicialized = true;
    }

    public void manageQuantityAddChange(Employee new_emp, Company company) {
        if (!running) {
            company.AddEmployee(new_emp);
        } else {
            company.hireEmployee(new_emp);
        }
    }

    public void manageQuantityAddChangeAssembler(Assembler new_asm, Company company) {
        if (!running) {
            company.AddAssembler(new_asm);
        } else {
            company.hireAssembler(new_asm);
        }
    }

    public void manageQuantityDeleteChange(Company company, int type) {
        company.DeleteEmployee(type);
    }

    public void manageQuantityDeleteChangeAssembler(Company company) {
        company.DeleteAssembler();
    }

    public int getDifference(Lista<Employee> list, javax.swing.JSpinner spinner) {
        int diference = list.getSize() - (int) spinner.getValue();
        return diference;

    }

    public int getDifferenceAssembler(Lista<Assembler> list, javax.swing.JSpinner spinner) {
        int diference = list.getSize() - (int) spinner.getValue();
        return diference;

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        deadline = new javax.swing.JSpinner();
        dayDuration = new javax.swing.JSpinner();
        inicio = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        base_emp_quantity = new javax.swing.JSpinner();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cpu_emp_quantity = new javax.swing.JSpinner();
        jLabel11 = new javax.swing.JLabel();
        ram_emp_quantity = new javax.swing.JSpinner();
        graphic_emp_quantity = new javax.swing.JSpinner();
        jTextArea2 = new javax.swing.JTextArea();
        graphic_quantity = new javax.swing.JLabel();
        base_quantity = new javax.swing.JLabel();
        cpu_quantity = new javax.swing.JLabel();
        ram_quantity = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        assembler_emp_quantity = new javax.swing.JSpinner();
        comp_graph_quantity = new javax.swing.JLabel();
        comp_quantity = new javax.swing.JLabel();
        ganancias = new javax.swing.JLabel();
        gastos = new javax.swing.JLabel();
        utilidad = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        PMfaults = new javax.swing.JLabel();
        directorStatus = new javax.swing.JLabel();
        pmStatus = new javax.swing.JLabel();
        discount = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jTextArea3 = new javax.swing.JTextArea();
        power_emp_quantity = new javax.swing.JSpinner();
        power_quantity = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        daysToRealise = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        base_emp_quantity1 = new javax.swing.JSpinner();
        base_quantity1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        cpu_emp_quantity1 = new javax.swing.JSpinner();
        cpu_quantity1 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        ram_emp_quantity1 = new javax.swing.JSpinner();
        ram_quantity1 = new javax.swing.JLabel();
        directorStatus1 = new javax.swing.JLabel();
        pmStatus1 = new javax.swing.JLabel();
        daysToRealise1 = new javax.swing.JLabel();
        jTextArea5 = new javax.swing.JTextArea();
        power_emp_quantity1 = new javax.swing.JSpinner();
        power_quantity1 = new javax.swing.JLabel();
        utilidad1 = new javax.swing.JLabel();
        gastos1 = new javax.swing.JLabel();
        ganancias1 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        discount1 = new javax.swing.JLabel();
        PMfaults1 = new javax.swing.JLabel();
        Director1 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jTextArea6 = new javax.swing.JTextArea();
        jLabel15 = new javax.swing.JLabel();
        assembler_emp_quantity1 = new javax.swing.JSpinner();
        graphic_emp_quantity1 = new javax.swing.JSpinner();
        comp_graph_quantity1 = new javax.swing.JLabel();
        comp_quantity1 = new javax.swing.JLabel();
        graphic_quantity1 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        panelChart = new javax.swing.JPanel();
        jLabel62 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                formPropertyChange(evt);
            }
        });

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Simulaciones.com");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Deadline de entrega:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 210, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Duración de un día (segundos): ");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, -1, -1));

        deadline.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        jPanel1.add(deadline, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 150, 240, -1));

        dayDuration.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        jPanel1.add(dayDuration, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 110, 180, -1));

        inicio.setBackground(new java.awt.Color(0, 102, 255));
        inicio.setForeground(new java.awt.Color(255, 255, 255));
        inicio.setText("Iniciar simulación");
        inicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicioActionPerformed(evt);
            }
        });
        jPanel1.add(inicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 210, 140, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/background.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 460));

        jTabbedPane1.addTab("Config", jPanel1);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Cantidad de trabajadores");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Prod. Placa base:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, -1, 30));

        base_emp_quantity.setEditor(new javax.swing.JSpinner.NumberEditor(base_emp_quantity, ""));
        base_emp_quantity.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                base_emp_quantityStateChanged(evt);
            }
        });
        jPanel2.add(base_emp_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, 100, 30));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/applecomputer.png"))); // NOI18N
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        jLabel9.setBackground(new java.awt.Color(204, 91, 129));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Apple");
        jLabel9.setOpaque(true);
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, 440, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Prod. CPUs:");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, -1, 30));

        cpu_emp_quantity.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                cpu_emp_quantityStateChanged(evt);
            }
        });
        jPanel2.add(cpu_emp_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 270, 100, 30));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Prod. RAM:");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, -1, 30));

        ram_emp_quantity.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                ram_emp_quantityStateChanged(evt);
            }
        });
        jPanel2.add(ram_emp_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 310, 100, 30));

        graphic_emp_quantity.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                graphic_emp_quantityStateChanged(evt);
            }
        });
        jPanel2.add(graphic_emp_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 410, 100, 30));

        jTextArea2.setEditable(false);
        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextArea2.setForeground(new java.awt.Color(0, 0, 0));
        jTextArea2.setRows(5);
        jTextArea2.setText("Prod. tarjetas\ngráficas:");
        jTextArea2.setWrapStyleWord(true);
        jTextArea2.setBorder(null);
        jTextArea2.setCaretColor(new java.awt.Color(0, 0, 0));
        jTextArea2.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextArea2.setOpaque(false);
        jPanel2.add(jTextArea2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, 120, 50));

        graphic_quantity.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        graphic_quantity.setForeground(new java.awt.Color(0, 0, 0));
        graphic_quantity.setText("Unid. en almacén: 0/10");
        jPanel2.add(graphic_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 410, -1, 30));

        base_quantity.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        base_quantity.setForeground(new java.awt.Color(0, 0, 0));
        base_quantity.setText("Unid. en almacén: 0/25");
        base_quantity.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                base_quantityPropertyChange(evt);
            }
        });
        jPanel2.add(base_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 230, -1, 30));

        cpu_quantity.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cpu_quantity.setForeground(new java.awt.Color(0, 0, 0));
        cpu_quantity.setText("Unid. en almacén: 0/20");
        jPanel2.add(cpu_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 270, -1, 30));

        ram_quantity.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ram_quantity.setForeground(new java.awt.Color(0, 0, 0));
        ram_quantity.setText("Unid. en almacén: 0/55");
        jPanel2.add(ram_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 310, -1, 30));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Ensambladores");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 340, -1, 30));

        assembler_emp_quantity.setEditor(new javax.swing.JSpinner.NumberEditor(assembler_emp_quantity, ""));
        assembler_emp_quantity.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                assembler_emp_quantityStateChanged(evt);
            }
        });
        assembler_emp_quantity.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                assembler_emp_quantityPropertyChange(evt);
            }
        });
        jPanel2.add(assembler_emp_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 340, 100, 30));

        comp_graph_quantity.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        comp_graph_quantity.setForeground(new java.awt.Color(0, 0, 0));
        comp_graph_quantity.setText("con Gráficas: 0");
        jPanel2.add(comp_graph_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 410, -1, 30));

        comp_quantity.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        comp_quantity.setForeground(new java.awt.Color(0, 0, 0));
        comp_quantity.setText("Computadoras: 0");
        jPanel2.add(comp_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 380, -1, 30));

        ganancias.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ganancias.setForeground(new java.awt.Color(255, 255, 255));
        ganancias.setText("Ganancias: 0K");
        jPanel2.add(ganancias, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 80, 160, 30));

        gastos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        gastos.setForeground(new java.awt.Color(255, 255, 255));
        gastos.setText("Gastos: 0$");
        jPanel2.add(gastos, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 110, 160, 30));

        utilidad.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        utilidad.setForeground(new java.awt.Color(255, 255, 255));
        utilidad.setText("Utilidad: 0$");
        jPanel2.add(utilidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 140, 160, 30));

        jLabel37.setBackground(new java.awt.Color(204, 91, 129));
        jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setOpaque(true);
        jPanel2.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, 170, 90));

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(0, 0, 0));
        jLabel29.setText("Estados");
        jPanel2.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 130, 120, 30));

        jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(0, 0, 0));
        jLabel38.setText("Director:");
        jPanel2.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 190, 120, 30));

        PMfaults.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        PMfaults.setForeground(new java.awt.Color(0, 0, 0));
        PMfaults.setText("Faltas PM: 0");
        jPanel2.add(PMfaults, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 240, 120, 30));

        directorStatus.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        directorStatus.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(directorStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 190, 200, 30));

        pmStatus.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        pmStatus.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(pmStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 160, 150, 30));

        discount.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        discount.setForeground(new java.awt.Color(0, 0, 0));
        discount.setText("Sueldo descontado: 0");
        jPanel2.add(discount, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 270, 170, 30));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("Project Manager:");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 160, 120, 30));

        jTextArea3.setEditable(false);
        jTextArea3.setColumns(20);
        jTextArea3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextArea3.setForeground(new java.awt.Color(0, 0, 0));
        jTextArea3.setRows(5);
        jTextArea3.setText("Prod. Fuente de\nalimentación:");
        jTextArea3.setWrapStyleWord(true);
        jTextArea3.setBorder(null);
        jTextArea3.setCaretColor(new java.awt.Color(0, 0, 0));
        jTextArea3.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextArea3.setOpaque(false);
        jPanel2.add(jTextArea3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, 120, 50));

        power_emp_quantity.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                power_emp_quantityStateChanged(evt);
            }
        });
        jPanel2.add(power_emp_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 360, 100, 30));

        power_quantity.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        power_quantity.setForeground(new java.awt.Color(0, 0, 0));
        power_quantity.setText("Unid. en almacén: 0/35");
        jPanel2.add(power_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 360, -1, 30));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 0, 0));
        jLabel22.setText("Días para la entrega:");
        jPanel2.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 80, 140, 30));

        daysToRealise.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        daysToRealise.setForeground(new java.awt.Color(204, 91, 129));
        jPanel2.add(daysToRealise, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 80, 30, 30));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/background apple.png"))); // NOI18N
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 470));

        jTabbedPane1.addTab("Apple", jPanel2);

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel24.setBackground(new java.awt.Color(0, 118, 206));
        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Dell");
        jLabel24.setOpaque(true);
        jPanel3.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, 440, -1));

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/dellcomputer.png"))); // NOI18N
        jLabel23.setVerifyInputWhenFocusTarget(false);
        jPanel3.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Prod. Placa base:");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, -1, 30));

        base_emp_quantity1.setEditor(new javax.swing.JSpinner.NumberEditor(base_emp_quantity1, ""));
        base_emp_quantity1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                base_emp_quantity1StateChanged(evt);
            }
        });
        base_emp_quantity1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                base_emp_quantity1PropertyChange(evt);
            }
        });
        jPanel3.add(base_emp_quantity1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, 100, 30));

        base_quantity1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        base_quantity1.setForeground(new java.awt.Color(0, 0, 0));
        base_quantity1.setText("Unid. en almacén: 0/25");
        base_quantity1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                base_quantity1PropertyChange(evt);
            }
        });
        jPanel3.add(base_quantity1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 230, -1, 30));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Prod. CPUs:");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, -1, 30));

        cpu_emp_quantity1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                cpu_emp_quantity1StateChanged(evt);
            }
        });
        jPanel3.add(cpu_emp_quantity1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 270, 100, 30));

        cpu_quantity1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cpu_quantity1.setForeground(new java.awt.Color(0, 0, 0));
        cpu_quantity1.setText("Unid. en almacén: 0/20");
        jPanel3.add(cpu_quantity1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 270, -1, 30));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Prod. RAM:");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, -1, 30));

        ram_emp_quantity1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                ram_emp_quantity1StateChanged(evt);
            }
        });
        jPanel3.add(ram_emp_quantity1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 310, 100, 30));

        ram_quantity1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ram_quantity1.setForeground(new java.awt.Color(0, 0, 0));
        ram_quantity1.setText("Unid. en almacén: 0/55");
        jPanel3.add(ram_quantity1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 310, -1, 30));

        directorStatus1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        directorStatus1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel3.add(directorStatus1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 190, 200, 30));

        pmStatus1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        pmStatus1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel3.add(pmStatus1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 160, 150, 30));

        daysToRealise1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        daysToRealise1.setForeground(new java.awt.Color(0, 118, 206));
        jPanel3.add(daysToRealise1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 80, 30, 30));

        jTextArea5.setEditable(false);
        jTextArea5.setColumns(20);
        jTextArea5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextArea5.setForeground(new java.awt.Color(0, 0, 0));
        jTextArea5.setRows(5);
        jTextArea5.setText("Prod. Fuente de\nalimentación:");
        jTextArea5.setWrapStyleWord(true);
        jTextArea5.setBorder(null);
        jTextArea5.setCaretColor(new java.awt.Color(0, 0, 0));
        jTextArea5.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextArea5.setOpaque(false);
        jPanel3.add(jTextArea5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, 120, 50));

        power_emp_quantity1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                power_emp_quantity1StateChanged(evt);
            }
        });
        jPanel3.add(power_emp_quantity1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 360, 100, 30));

        power_quantity1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        power_quantity1.setForeground(new java.awt.Color(0, 0, 0));
        power_quantity1.setText("Unid. en almacén: 0/35");
        jPanel3.add(power_quantity1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 360, -1, 30));

        utilidad1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        utilidad1.setForeground(new java.awt.Color(255, 255, 255));
        utilidad1.setText("Utilidad:");
        jPanel3.add(utilidad1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 140, 160, 30));

        gastos1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        gastos1.setForeground(new java.awt.Color(255, 255, 255));
        gastos1.setText("Gastos: 0$");
        jPanel3.add(gastos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 110, 160, 30));

        ganancias1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ganancias1.setForeground(new java.awt.Color(255, 255, 255));
        ganancias1.setText("Ganancias: 0K");
        jPanel3.add(ganancias1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 80, 160, 30));

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(0, 0, 0));
        jLabel27.setText("Estados");
        jPanel3.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 130, 120, 30));

        discount1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        discount1.setForeground(new java.awt.Color(0, 0, 0));
        discount1.setText("Sueldo descontado: 0");
        jPanel3.add(discount1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 270, 170, 30));

        PMfaults1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        PMfaults1.setForeground(new java.awt.Color(0, 0, 0));
        PMfaults1.setText("Faltas PM: 0");
        jPanel3.add(PMfaults1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 240, 120, 30));

        Director1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Director1.setForeground(new java.awt.Color(0, 0, 0));
        Director1.setText("Director:");
        jPanel3.add(Director1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 190, 120, 30));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 0, 0));
        jLabel25.setText("Project Manager:");
        jPanel3.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 160, 120, 30));

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 0, 0));
        jLabel26.setText("Días para la entrega:");
        jPanel3.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 80, 140, 30));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 0));
        jLabel20.setText("Cantidad de trabajadores");
        jPanel3.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, -1, -1));

        jLabel33.setBackground(new java.awt.Color(0, 118, 206));
        jLabel33.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setOpaque(true);
        jPanel3.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, 170, 90));

        jTextArea6.setEditable(false);
        jTextArea6.setColumns(20);
        jTextArea6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextArea6.setForeground(new java.awt.Color(0, 0, 0));
        jTextArea6.setRows(5);
        jTextArea6.setText("Prod. tarjetas\ngráficas:");
        jTextArea6.setWrapStyleWord(true);
        jTextArea6.setBorder(null);
        jTextArea6.setCaretColor(new java.awt.Color(0, 0, 0));
        jTextArea6.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextArea6.setOpaque(false);
        jPanel3.add(jTextArea6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, 120, 50));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("Ensambladores");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 340, -1, 30));

        assembler_emp_quantity1.setEditor(new javax.swing.JSpinner.NumberEditor(assembler_emp_quantity1, ""));
        assembler_emp_quantity1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                assembler_emp_quantity1StateChanged(evt);
            }
        });
        assembler_emp_quantity1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                assembler_emp_quantity1PropertyChange(evt);
            }
        });
        jPanel3.add(assembler_emp_quantity1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 340, 100, 30));

        graphic_emp_quantity1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                graphic_emp_quantity1StateChanged(evt);
            }
        });
        jPanel3.add(graphic_emp_quantity1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 410, 100, 30));

        comp_graph_quantity1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        comp_graph_quantity1.setForeground(new java.awt.Color(0, 0, 0));
        comp_graph_quantity1.setText("con Gráficas: 0");
        jPanel3.add(comp_graph_quantity1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 410, -1, 30));

        comp_quantity1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        comp_quantity1.setForeground(new java.awt.Color(0, 0, 0));
        comp_quantity1.setText("Computadoras: 0");
        jPanel3.add(comp_quantity1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 380, -1, 30));

        graphic_quantity1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        graphic_quantity1.setForeground(new java.awt.Color(0, 0, 0));
        graphic_quantity1.setText("Unid. en almacén: 0/10");
        jPanel3.add(graphic_quantity1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 410, -1, 30));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/background dell.jpg"))); // NOI18N
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 470));

        jLabel39.setBackground(new java.awt.Color(0, 118, 206));
        jLabel39.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel39.setOpaque(true);
        jPanel3.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, 170, 90));

        jTabbedPane1.addTab("Dell", jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel36.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(0, 0, 0));
        jLabel36.setText("GANANCIAS");
        jPanel4.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, -1, -1));

        jLabel43.setBackground(new java.awt.Color(0, 118, 206));
        jLabel43.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel43.setOpaque(true);
        jPanel4.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, 180, 10));

        panelChart.setBackground(new java.awt.Color(204, 204, 204));
        panelChart.setForeground(new java.awt.Color(255, 255, 255));
        panelChart.setLayout(new java.awt.BorderLayout());
        jPanel4.add(panelChart, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 700, 390));

        jLabel62.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(0, 0, 0));
        jLabel62.setText("Apple:");
        jPanel4.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 10, -1, -1));

        jLabel28.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(0, 0, 0));
        jLabel28.setText("Dell:");
        jPanel4.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 30, -1, -1));

        jPanel7.setBackground(new java.awt.Color(0, 0, 0));
        jPanel4.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 10, -1, 20));

        jPanel8.setBackground(new java.awt.Color(255, 0, 0));
        jPanel4.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 30, -1, 20));

        jTabbedPane1.addTab("Gráfico", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 743, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void initSpinners(JFormattedTextField spinnerTextField) {
        spinnerTextField.setEditable(false);
        spinnerTextField.setFocusable(false);
    }
    private void inicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicioActionPerformed

        apple.getStore().setDeadline((int)deadline.getValue());
        dell.getStore().setDeadline((int)deadline.getValue());
        
        daysToRealise.setText(String.valueOf(apple.getStore().getDeadline()));
        daysToRealise1.setText(String.valueOf(dell.getStore().getDeadline()));
        
        
        pmApple = new ProjectManager((int) dayDuration.getValue(), apple.getStore());
        apple.setPM(pmApple);
        pmApple.start();

        pmDell = new ProjectManager((int) dayDuration.getValue(), dell.getStore());
        dell.setPM(pmDell);
        pmDell.start();

        directorApple = new Director((int) dayDuration.getValue(), apple.getStore());
        directorApple.start();

        directorDell = new Director((int) dayDuration.getValue(), dell.getStore());
        directorDell.start();

        apple.startAll((int) dayDuration.getValue());
        dell.startAll((int) dayDuration.getValue());
        running = true;

    //Grafica  
    Global.addApple(0, 0);
    Global.addDell(0, 0);
    Global.addSeries(Global.getApple());
    Global.addSeries(Global.getDell());
        
    JFreeChart chart = ChartFactory.createXYLineChart("Utilidad vs Tiempo", "Tiempo (Días)", "Utilidad (Millones $)", Global.dataset, PlotOrientation.VERTICAL, true, true, false);
        
    final XYPlot plot = chart.getXYPlot( );
        
    ChartPanel barPanel = new ChartPanel(chart);
        
    XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer( );
    renderer.setSeriesPaint( 0 , Color.BLACK );
    renderer.setSeriesPaint( 1 , Color.RED);
    renderer.setSeriesStroke( 0 , new BasicStroke( 4.0f ) );
    renderer.setSeriesStroke( 1 , new BasicStroke( 4.0f ) );
    plot.setRenderer( renderer );

    panelChart.removeAll();
    panelChart.add(barPanel);
    panelChart.revalidate();
    panelChart.repaint();
        

    }//GEN-LAST:event_inicioActionPerformed

    private void base_quantityPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_base_quantityPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_base_quantityPropertyChange

    private void base_emp_quantityStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_base_emp_quantityStateChanged

        //Apple Base # Employees Spinner change in real time
        if (inicialized) {

            int lastValidValue = apple.getBase_employees().getSize();

            if (lastValidValue > 1 || (int) base_emp_quantity.getValue() > lastValidValue) {

                if (apple.getTotalEmployees() < apple.getMaxEmployees() || (int) base_emp_quantity.getValue() < lastValidValue) {
                    if (getDifference(apple.getBase_employees(), base_emp_quantity) < 0) {
                        Employee new_emp = new Employee(20, apple, 0.25);
                        new_emp.setType(1);
                        new_emp.setDayDuration(txt.getDayDuration());
                        manageQuantityAddChange(new_emp, apple);
                    } else {
                        manageQuantityDeleteChange(apple, 1);
                    }
                } else {
                    base_emp_quantity.setValue(lastValidValue);
                    JOptionPane.showMessageDialog(rootPane, "Ha excedido la cantidad máxima de empleados");
                }
            } else {
                base_emp_quantity.setValue(lastValidValue);
                JOptionPane.showMessageDialog(rootPane, "Debe tener mínimo un (1) empleado");
            }
        }

    }//GEN-LAST:event_base_emp_quantityStateChanged

    private void base_emp_quantity1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_base_emp_quantity1StateChanged

        // Dell Base # Employees Spinner change in real time
        if (inicialized) {

            int lastValidValue = dell.getBase_employees().getSize();

            if (lastValidValue > 1 || (int) base_emp_quantity1.getValue() > lastValidValue) {

                if (dell.getTotalEmployees() < dell.getMaxEmployees() || (int) base_emp_quantity1.getValue() < lastValidValue) {
                    if (getDifference(dell.getBase_employees(), base_emp_quantity1) < 0) {
                        Employee new_emp = new Employee(20, dell, 0.34);
                        new_emp.setType(1);
                        new_emp.setDayDuration(txt.getDayDuration());
                        manageQuantityAddChange(new_emp, dell);
                    } else {
                        manageQuantityDeleteChange(dell, 1);
                    }
                } else {
                    base_emp_quantity1.setValue(lastValidValue);
                    JOptionPane.showMessageDialog(rootPane, "Ha excedido la cantidad máxima de empleados");
                }
            } else {
                base_emp_quantity1.setValue(lastValidValue);
                JOptionPane.showMessageDialog(rootPane, "Debe tener mínimo un (1) empleado");
            }
        }


    }//GEN-LAST:event_base_emp_quantity1StateChanged

    private void base_emp_quantity1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_base_emp_quantity1PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_base_emp_quantity1PropertyChange

    private void base_quantity1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_base_quantity1PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_base_quantity1PropertyChange

    private void cpu_emp_quantityStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cpu_emp_quantityStateChanged

        // Apple CPU # Employees Spinner change in real time
        if (inicialized) {

            int lastValidValue = apple.getCpu_employees().getSize();

            if (lastValidValue > 1 || (int) cpu_emp_quantity.getValue() > lastValidValue) {

                if (apple.getTotalEmployees() < apple.getMaxEmployees() || (int) cpu_emp_quantity.getValue() < lastValidValue) {
                    if (getDifference(apple.getCpu_employees(), cpu_emp_quantity) < 0) {
                        Employee new_emp = new Employee(26, apple, 0.25);
                        new_emp.setType(2);
                        new_emp.setDayDuration(txt.getDayDuration());
                        manageQuantityAddChange(new_emp, apple);
                    } else {
                        manageQuantityDeleteChange(apple, 2);
                    }
                } else {
                    cpu_emp_quantity.setValue(lastValidValue);
                    JOptionPane.showMessageDialog(rootPane, "Ha excedido la cantidad máxima de empleados");
                }
            } else {
                cpu_emp_quantity.setValue(lastValidValue);
                JOptionPane.showMessageDialog(rootPane, "Debe tener mínimo un (1) empleado");
            }
        }


    }//GEN-LAST:event_cpu_emp_quantityStateChanged

    private void ram_emp_quantityStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_ram_emp_quantityStateChanged

        // Apple RAM # Employees Spinner change in real time
        if (inicialized) {

            int lastValidValue = apple.getRam_employees().getSize();

            if (lastValidValue > 1 || (int) ram_emp_quantity.getValue() > lastValidValue) {

                if (apple.getTotalEmployees() < apple.getMaxEmployees() || (int) ram_emp_quantity.getValue() < lastValidValue) {
                    if (getDifference(apple.getRam_employees(), ram_emp_quantity) < 0) {
                        Employee new_emp = new Employee(40, apple, 1);
                        new_emp.setType(3);
                        new_emp.setDayDuration(txt.getDayDuration());
                        manageQuantityAddChange(new_emp, apple);
                    } else {
                        manageQuantityDeleteChange(apple, 3);
                    }
                } else {
                    ram_emp_quantity.setValue(lastValidValue);
                    JOptionPane.showMessageDialog(rootPane, "Ha excedido la cantidad máxima de empleados");
                }
            } else {
                ram_emp_quantity.setValue(lastValidValue);
                JOptionPane.showMessageDialog(rootPane, "Debe tener mínimo un (1) empleado");
            }
        }


    }//GEN-LAST:event_ram_emp_quantityStateChanged

    private void power_emp_quantityStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_power_emp_quantityStateChanged

        // Apple Power # Employees Spinner change in real time
        if (inicialized) {

            int lastValidValue = apple.getPower_employees().getSize();

            if (lastValidValue > 1 || (int) power_emp_quantity.getValue() > lastValidValue) {

                if (apple.getTotalEmployees() < apple.getMaxEmployees() || (int) power_emp_quantity.getValue() < lastValidValue) {
                    if (getDifference(apple.getPower_employees(), power_emp_quantity) < 0) {
                        Employee new_emp = new Employee(16, apple, 5);
                        new_emp.setType(4);
                        new_emp.setDayDuration(txt.getDayDuration());
                        manageQuantityAddChange(new_emp, apple);
                    } else {
                        manageQuantityDeleteChange(apple, 4);
                    }
                } else {
                    power_emp_quantity.setValue(lastValidValue);
                    JOptionPane.showMessageDialog(rootPane, "Ha excedido la cantidad máxima de empleados");
                }
            } else {
                power_emp_quantity.setValue(lastValidValue);
                JOptionPane.showMessageDialog(rootPane, "Debe tener mínimo un (1) empleado");
            }
        }


    }//GEN-LAST:event_power_emp_quantityStateChanged

    private void graphic_emp_quantityStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_graphic_emp_quantityStateChanged

        // Apple Grapic Card # Employees Spinner change in real time
        if (inicialized) {

            int lastValidValue = apple.getGraphic_employee().getSize();

            if (lastValidValue > 1 || (int) graphic_emp_quantity.getValue() > lastValidValue) {

                if (apple.getTotalEmployees() < apple.getMaxEmployees() || (int) graphic_emp_quantity.getValue() < lastValidValue) {
                    if (getDifference(apple.getGraphic_employee(), graphic_emp_quantity) < 0) {
                        Employee new_emp = new Employee(34, apple, 0.5);
                        new_emp.setType(5);
                        new_emp.setDayDuration(txt.getDayDuration());
                        manageQuantityAddChange(new_emp, apple);
                    } else {
                        manageQuantityDeleteChange(apple, 5);
                    }
                } else {
                    graphic_emp_quantity.setValue(lastValidValue);
                    JOptionPane.showMessageDialog(rootPane, "Ha excedido la cantidad máxima de empleados");
                }
            } else {
                graphic_emp_quantity.setValue(lastValidValue);
                JOptionPane.showMessageDialog(rootPane, "Debe tener mínimo un (1) empleado");
            }
        }


    }//GEN-LAST:event_graphic_emp_quantityStateChanged

    private void cpu_emp_quantity1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cpu_emp_quantity1StateChanged

        // Dell CPU # Employees Spinner change in real time
        if (inicialized) {

            int lastValidValue = dell.getCpu_employees().getSize();

            if (lastValidValue > 1 || (int) cpu_emp_quantity1.getValue() > lastValidValue) {

                if (dell.getTotalEmployees() < dell.getMaxEmployees() || (int) cpu_emp_quantity1.getValue() < lastValidValue) {
                    if (getDifference(dell.getCpu_employees(), cpu_emp_quantity1) < 0) {
                        Employee new_emp = new Employee(26, dell, 0.34);
                        new_emp.setType(2);
                        new_emp.setDayDuration(txt.getDayDuration());
                        manageQuantityAddChange(new_emp, dell);
                    } else {
                        manageQuantityDeleteChange(dell, 2);
                    }
                } else {
                    cpu_emp_quantity1.setValue(lastValidValue);
                    JOptionPane.showMessageDialog(rootPane, "Ha excedido la cantidad máxima de empleados");
                }
            } else {
                cpu_emp_quantity1.setValue(lastValidValue);
                JOptionPane.showMessageDialog(rootPane, "Debe tener mínimo un (1) empleado");
            }
        }


    }//GEN-LAST:event_cpu_emp_quantity1StateChanged

    private void ram_emp_quantity1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_ram_emp_quantity1StateChanged

        // Dell RAM # Employees Spinner change in real time
        if (inicialized) {

            int lastValidValue = dell.getRam_employees().getSize();

            if (lastValidValue > 1 || (int) ram_emp_quantity1.getValue() > lastValidValue) {

                if (dell.getTotalEmployees() < dell.getMaxEmployees() || (int) ram_emp_quantity1.getValue() < lastValidValue) {
                    if (getDifference(dell.getRam_employees(), ram_emp_quantity1) < 0) {
                        Employee new_emp = new Employee(40, dell, 2);
                        new_emp.setType(3);
                        new_emp.setDayDuration(txt.getDayDuration());
                        manageQuantityAddChange(new_emp, dell);
                    } else {
                        manageQuantityDeleteChange(dell, 3);
                    }
                } else {
                    ram_emp_quantity1.setValue(lastValidValue);
                    JOptionPane.showMessageDialog(rootPane, "Ha excedido la cantidad máxima de empleados");
                }
            } else {
                ram_emp_quantity1.setValue(lastValidValue);
                JOptionPane.showMessageDialog(rootPane, "Debe tener mínimo un (1) empleado");
            }
        }


    }//GEN-LAST:event_ram_emp_quantity1StateChanged

    private void power_emp_quantity1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_power_emp_quantity1StateChanged

        // Dell Power # Employees Spinner change in real time
        if (inicialized) {

            int lastValidValue = dell.getPower_employees().getSize();

            if (lastValidValue > 1 || (int) power_emp_quantity1.getValue() > lastValidValue) {

                if (dell.getTotalEmployees() < dell.getMaxEmployees() || (int) power_emp_quantity1.getValue() < lastValidValue) {
                    if (getDifference(dell.getPower_employees(), power_emp_quantity1) < 0) {
                        Employee new_emp = new Employee(16, dell, 5);
                        new_emp.setType(4);
                        new_emp.setDayDuration(txt.getDayDuration());
                        manageQuantityAddChange(new_emp, dell);
                    } else {
                        manageQuantityDeleteChange(dell, 4);
                    }
                } else {
                    power_emp_quantity1.setValue(lastValidValue);
                    JOptionPane.showMessageDialog(rootPane, "Ha excedido la cantidad máxima de empleados");
                }
            } else {
                power_emp_quantity1.setValue(lastValidValue);
                JOptionPane.showMessageDialog(rootPane, "Debe tener mínimo un (1) empleado");
            }
        }


    }//GEN-LAST:event_power_emp_quantity1StateChanged

    private void graphic_emp_quantity1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_graphic_emp_quantity1StateChanged

        // Dell Grapic Card # Employees Spinner change in real time
        if (inicialized) {

            int lastValidValue = dell.getGraphic_employee().getSize();

            if (lastValidValue > 1 || (int) graphic_emp_quantity1.getValue() > lastValidValue) {

                if (dell.getTotalEmployees() < dell.getMaxEmployees() || (int) graphic_emp_quantity1.getValue() < lastValidValue) {
                    if (getDifference(dell.getGraphic_employee(), graphic_emp_quantity1) < 0) {
                        Employee new_emp = new Employee(34, dell, 0.5);
                        new_emp.setType(5);
                        new_emp.setDayDuration(txt.getDayDuration());
                        manageQuantityAddChange(new_emp, dell);
                    } else {
                        manageQuantityDeleteChange(dell, 5);
                    }
                } else {
                    graphic_emp_quantity1.setValue(lastValidValue);
                    JOptionPane.showMessageDialog(rootPane, "Ha excedido la cantidad máxima de empleados");
                }
            } else {
                graphic_emp_quantity1.setValue(lastValidValue);
                JOptionPane.showMessageDialog(rootPane, "Debe tener mínimo un (1) empleado");
            }
        }


    }//GEN-LAST:event_graphic_emp_quantity1StateChanged

    private void assembler_emp_quantity1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_assembler_emp_quantity1StateChanged

        // Dell Assembler # Employees Spinner change in real time
        if (inicialized) {

            int lastValidValue = dell.getAssembler().getSize();

            if (lastValidValue > 1 || (int) assembler_emp_quantity1.getValue() > lastValidValue) {
                if (dell.getTotalEmployees() < dell.getMaxEmployees() || (int) assembler_emp_quantity1.getValue() < lastValidValue) {
                    if (getDifferenceAssembler(dell.getAssembler(), assembler_emp_quantity1) < 0) {
                        Assembler new_asm = new Assembler(dell.getStore(), txt.getDayDuration());
                        manageQuantityAddChangeAssembler(new_asm, dell);
                    } else {
                        manageQuantityDeleteChangeAssembler(dell);
                    }
                } else {
                    assembler_emp_quantity1.setValue(lastValidValue);
                    JOptionPane.showMessageDialog(rootPane, "Ha excedido la cantidad máxima de empleados");
                }
            } else {
                assembler_emp_quantity1.setValue(lastValidValue);
                JOptionPane.showMessageDialog(rootPane, "Debe tener mínimo un (1) empleado");
            }
        }


    }//GEN-LAST:event_assembler_emp_quantity1StateChanged

    private void assembler_emp_quantity1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_assembler_emp_quantity1PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_assembler_emp_quantity1PropertyChange

    private void assembler_emp_quantityStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_assembler_emp_quantityStateChanged

        // Apple Assembler # Employees Spinner change in real time
        if (inicialized) {

            int lastValidValue = apple.getAssembler().getSize();

            if (lastValidValue > 1 || (int) assembler_emp_quantity.getValue() > lastValidValue) {
                if (apple.getTotalEmployees() < apple.getMaxEmployees() || (int) assembler_emp_quantity.getValue() < lastValidValue) {
                    if (getDifferenceAssembler(apple.getAssembler(), assembler_emp_quantity) < 0) {
                        Assembler new_asm = new Assembler(apple.getStore(), txt.getDayDuration());
                        manageQuantityAddChangeAssembler(new_asm, apple);
                    } else {
                        manageQuantityDeleteChangeAssembler(apple);
                    }
                } else {
                    assembler_emp_quantity.setValue(lastValidValue);
                    JOptionPane.showMessageDialog(rootPane, "Ha excedido la cantidad máxima de empleados");
                }
            } else {
                assembler_emp_quantity.setValue(lastValidValue);
                JOptionPane.showMessageDialog(rootPane, "Debe tener mínimo un (1) empleado");
            }
        }


    }//GEN-LAST:event_assembler_emp_quantityStateChanged

    private void assembler_emp_quantityPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_assembler_emp_quantityPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_assembler_emp_quantityPropertyChange

    private void formPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_formPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_formPropertyChange

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame home = new Home();
                home.setVisible(true);
                
                
                home.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // Evita el cierre inmediato

        // Agregar un listener para manejar el evento de cierre
            home.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Aquí puedes programar la acción que deseas realizar
                int respuesta = JOptionPane.showConfirmDialog(home, "¿Desea guardar los cambios?", "Confirmar Cierre", JOptionPane.YES_NO_OPTION);
                if (respuesta == JOptionPane.YES_OPTION) {
                    txt.editTxt((int)dayDuration.getValue(),(int)deadline.getValue(),apple,dell);
                    home.dispose(); // Cierra la ventana
                } else if (respuesta == JOptionPane.NO_OPTION) {
                    home.dispose(); // Cierra la ventana
                }
            }
        });
                
            }
        });
        
        
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Director1;
    public static javax.swing.JLabel PMfaults;
    public static javax.swing.JLabel PMfaults1;
    private javax.swing.JSpinner assembler_emp_quantity;
    private javax.swing.JSpinner assembler_emp_quantity1;
    private javax.swing.JSpinner base_emp_quantity;
    private javax.swing.JSpinner base_emp_quantity1;
    public static javax.swing.JLabel base_quantity;
    public static javax.swing.JLabel base_quantity1;
    public static javax.swing.JLabel comp_graph_quantity;
    public static javax.swing.JLabel comp_graph_quantity1;
    public static javax.swing.JLabel comp_quantity;
    public static javax.swing.JLabel comp_quantity1;
    private javax.swing.JSpinner cpu_emp_quantity;
    private javax.swing.JSpinner cpu_emp_quantity1;
    public static javax.swing.JLabel cpu_quantity;
    public static javax.swing.JLabel cpu_quantity1;
    private static javax.swing.JSpinner dayDuration;
    public static javax.swing.JLabel daysToRealise;
    public static javax.swing.JLabel daysToRealise1;
    private static javax.swing.JSpinner deadline;
    public static javax.swing.JLabel directorStatus;
    public static javax.swing.JLabel directorStatus1;
    public static javax.swing.JLabel discount;
    public static javax.swing.JLabel discount1;
    public static javax.swing.JLabel ganancias;
    public static javax.swing.JLabel ganancias1;
    public static javax.swing.JLabel gastos;
    public static javax.swing.JLabel gastos1;
    private javax.swing.JSpinner graphic_emp_quantity;
    private javax.swing.JSpinner graphic_emp_quantity1;
    public static javax.swing.JLabel graphic_quantity;
    public static javax.swing.JLabel graphic_quantity1;
    private javax.swing.JToggleButton inicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    public static javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    public static javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextArea jTextArea5;
    private javax.swing.JTextArea jTextArea6;
    public static javax.swing.JPanel panelChart;
    public static javax.swing.JLabel pmStatus;
    public static javax.swing.JLabel pmStatus1;
    private javax.swing.JSpinner power_emp_quantity;
    private javax.swing.JSpinner power_emp_quantity1;
    public static javax.swing.JLabel power_quantity;
    public static javax.swing.JLabel power_quantity1;
    private javax.swing.JSpinner ram_emp_quantity;
    private javax.swing.JSpinner ram_emp_quantity1;
    public static javax.swing.JLabel ram_quantity;
    public static javax.swing.JLabel ram_quantity1;
    public static javax.swing.JLabel utilidad;
    public static javax.swing.JLabel utilidad1;
    // End of variables declaration//GEN-END:variables
}