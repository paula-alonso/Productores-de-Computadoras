/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import Clases.Company;
import Clases.Employee;
import EDD.Lista;
import java.io.File;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import productores.de.computadoras.Functions;

/**
 *
 * @author alons
 */
public class Home extends javax.swing.JFrame {

    Lista<Company> companies = new Lista<Company>();
    Functions func = new Functions();
    boolean running;
    boolean inicialized = false;
    Company apple;
    Company dell;

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
        initSpinners(spinnerTextField1);
        initSpinners(spinnerTextField2);
        initSpinners(spinnerTextField3);
        initSpinners(spinnerTextField4);
        initSpinners(spinnerTextField5);

        
        loadInfo();
    }

    private void loadInfo() {
        companies = func.LeerTxt();
        apple=companies.getFirst().getData();
        dell=companies.getLast().getData();
        base_emp_quantity.setValue(apple.getBase_employees().getSize());
        cpu_emp_quantity.setValue(apple.getCpu_employees().getSize());
        ram_emp_quantity.setValue(apple.getRam_employees().getSize());
        power_emp_quantity.setValue(apple.getPower_employees().getSize());
        graphic_emp_quantity.setValue(apple.getGraphic_employee().getSize());
        base_emp_quantity1.setValue(dell.getBase_employees().getSize());
        cpu_emp_quantity1.setValue(dell.getCpu_employees().getSize());
        ram_emp_quantity1.setValue(dell.getRam_employees().getSize());
        power_emp_quantity1.setValue(dell.getPower_employees().getSize());
        graphic_emp_quantity1.setValue(dell.getGraphic_employee().getSize());
        inicialized = true;
    }

    public void manageQuantityAddChange(Employee new_emp, Company company) {
        if (!running) {
            company.AddEmployee(new_emp);
        } else {
            company.hireEmployee(new_emp);
        }
    }

    public void manageQuantityDeleteChange(Company company, int type) {
        company.DeleteEmployee(type);
    }

    public int getDifference(Lista<Employee> list, javax.swing.JSpinner spinner) {
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
        jSpinner2 = new javax.swing.JSpinner();
        jSpinner1 = new javax.swing.JSpinner();
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
        jTextArea3 = new javax.swing.JTextArea();
        power_emp_quantity = new javax.swing.JSpinner();
        power_quantity = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
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
        jTextArea5 = new javax.swing.JTextArea();
        power_emp_quantity1 = new javax.swing.JSpinner();
        power_quantity1 = new javax.swing.JLabel();
        jTextArea6 = new javax.swing.JTextArea();
        graphic_emp_quantity1 = new javax.swing.JSpinner();
        graphic_quantity1 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

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

        jSpinner2.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        jPanel1.add(jSpinner2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 150, 240, -1));

        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        jPanel1.add(jSpinner1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 110, 180, -1));

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

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/background apple.png"))); // NOI18N
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 460));

        jTabbedPane1.addTab("Apple", jPanel2);

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 0, 0));
        jLabel21.setText("Deadline");
        jPanel3.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 100, -1, -1));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setText("Número de trabajadores");
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, -1));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 0));
        jLabel20.setText("Estados");
        jPanel3.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, -1, -1));

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
        jPanel3.add(cpu_emp_quantity1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 270, 100, 30));

        cpu_quantity1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cpu_quantity1.setForeground(new java.awt.Color(0, 0, 0));
        cpu_quantity1.setText("Unid. en almacén: 0/20");
        jPanel3.add(cpu_quantity1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 270, -1, 30));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Prod. RAM:");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, -1, 30));
        jPanel3.add(ram_emp_quantity1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 310, 100, 30));

        ram_quantity1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ram_quantity1.setForeground(new java.awt.Color(0, 0, 0));
        ram_quantity1.setText("Unid. en almacén: 0/55");
        jPanel3.add(ram_quantity1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 310, -1, 30));

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
        jPanel3.add(power_emp_quantity1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 360, 100, 30));

        power_quantity1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        power_quantity1.setForeground(new java.awt.Color(0, 0, 0));
        power_quantity1.setText("Unid. en almacén: 0/35");
        jPanel3.add(power_quantity1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 360, -1, 30));

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
        jPanel3.add(graphic_emp_quantity1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 410, 100, 30));

        graphic_quantity1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        graphic_quantity1.setForeground(new java.awt.Color(0, 0, 0));
        graphic_quantity1.setText("Unid. en almacén: 0/10");
        jPanel3.add(graphic_quantity1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 410, -1, 30));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/background dell.jpg"))); // NOI18N
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 470));

        jTabbedPane1.addTab("Dell", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 731, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        apple.startAll();
        running = true;

    }//GEN-LAST:event_inicioActionPerformed

    private void base_quantityPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_base_quantityPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_base_quantityPropertyChange

    private void base_emp_quantityStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_base_emp_quantityStateChanged

        
       //Apple 
        
        if (inicialized) {
            if (getDifference(apple.getBase_employees(), base_emp_quantity) < 0) {
                Employee new_emp = new Employee(20, apple, 0.25);
                new_emp.setType(1);
                manageQuantityAddChange(new_emp, apple);
            } else {
                manageQuantityDeleteChange(apple, 1);
            }
        }

    }//GEN-LAST:event_base_emp_quantityStateChanged

    private void base_emp_quantity1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_base_emp_quantity1StateChanged
        
        // Dell
      
        if (inicialized) {
            if (getDifference(dell.getBase_employees(), base_emp_quantity1) < 0) {
                Employee new_emp = new Employee(20, dell, 0.25);
                new_emp.setType(1);
                manageQuantityAddChange(new_emp, dell);
            } else {
                manageQuantityDeleteChange(dell, 1);
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
        if (inicialized) {
            if (getDifference(apple.getCpu_employees(), cpu_emp_quantity) < 0) {
                Employee new_emp = new Employee(26, apple, 0.25);
                new_emp.setType(2);
                manageQuantityAddChange(new_emp, apple);
            } else {
                manageQuantityDeleteChange(apple, 2);
            }
        }
    }//GEN-LAST:event_cpu_emp_quantityStateChanged

    private void ram_emp_quantityStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_ram_emp_quantityStateChanged
        if (inicialized) {
            if (getDifference(apple.getRam_employees(), ram_emp_quantity) < 0) {
                Employee new_emp = new Employee(40, apple, 1);
                new_emp.setType(3);
                manageQuantityAddChange(new_emp, apple);
            } else {
                manageQuantityDeleteChange(apple, 3);
            }
        }
    }//GEN-LAST:event_ram_emp_quantityStateChanged

    private void power_emp_quantityStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_power_emp_quantityStateChanged
        if (inicialized) {
            if (getDifference(apple.getPower_employees(), power_emp_quantity) < 0) {
                Employee new_emp = new Employee(16, apple, 5);
                new_emp.setType(4);
                manageQuantityAddChange(new_emp, apple);
            } else {
                manageQuantityDeleteChange(apple, 4);
            }
        }
    }//GEN-LAST:event_power_emp_quantityStateChanged

    private void graphic_emp_quantityStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_graphic_emp_quantityStateChanged
        if (inicialized) {
            if (getDifference(apple.getGraphic_employee(), graphic_emp_quantity) < 0) {
                Employee new_emp = new Employee(34, apple, 0.5);
                new_emp.setType(5);
                manageQuantityAddChange(new_emp, apple);
            } else {
                manageQuantityDeleteChange(apple, 5);
            }
        }
    }//GEN-LAST:event_graphic_emp_quantityStateChanged

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
                new Home().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner base_emp_quantity;
    private javax.swing.JSpinner base_emp_quantity1;
    public static javax.swing.JLabel base_quantity;
    public static javax.swing.JLabel base_quantity1;
    private javax.swing.JSpinner cpu_emp_quantity;
    private javax.swing.JSpinner cpu_emp_quantity1;
    public static javax.swing.JLabel cpu_quantity;
    public static javax.swing.JLabel cpu_quantity1;
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
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextArea jTextArea5;
    private javax.swing.JTextArea jTextArea6;
    private javax.swing.JSpinner power_emp_quantity;
    private javax.swing.JSpinner power_emp_quantity1;
    public static javax.swing.JLabel power_quantity;
    public static javax.swing.JLabel power_quantity1;
    private javax.swing.JSpinner ram_emp_quantity;
    private javax.swing.JSpinner ram_emp_quantity1;
    public static javax.swing.JLabel ram_quantity;
    public static javax.swing.JLabel ram_quantity1;
    // End of variables declaration//GEN-END:variables
}
