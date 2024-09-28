/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import Interfaces.Home;

/**
 *
 * @author alons
 */
public class Store {
    private int motherboards;
    private int cpu;
    private int ram;
    private int power;
    private int graphic_cards;
    private int computersQuantity;
    private int computer;
    private int computerWithGraphic;
    private int counterForGraphic;
    private Company company;
    private int [] necessaryComponents; 

    public Store() {
        
        this.company = company;
        this.motherboards = 0;
        this.cpu = 0;
        this.ram = 0;
        this.graphic_cards = 0;
        this.power=0;
        this.computersQuantity = 0;
        this.computer = 0;
        this.computerWithGraphic = 0;
        this.counterForGraphic = 0;
        
    }

    /**
     * @return the motherboards
     */
    public int getMotherboards() {
        return motherboards;
    }

    /**
     * @param motherboards the motherboards to set
     */
    public void setMotherboards(int motherboards) {
        this.motherboards = motherboards;
    }

    /**
     * @return the cpu
     */
    public int getCpu() {
        return cpu;
    }

    /**
     * @param cpu the cpu to set
     */
    public void setCpu(int cpu) {
        this.cpu = cpu;
    }

    /**
     * @return the ram
     */
    public int getRam() {
        return ram;
    }

    /**
     * @param ram the ram to set
     */
    public void setRam(int ram) {
        this.ram = ram;
    }

    /**
     * @return the graphic_cards
     */
    public int getGraphic_cards() {
        return graphic_cards;
    }

    /**
     * @param graphic_cards the graphic_cards to set
     */
    public void setGraphic_cards(int graphic_cards) {
        this.graphic_cards = graphic_cards;
    }
    
    public void AddComponent(int employee_type){
        switch(employee_type){
            case 1:
              this.motherboards += 1;
              Home.base_quantity.setText("Unid. en almacén: "+Integer.toString(this.motherboards)+"/25");
              break;
            case 2:
                this.cpu += 1;
                Home.cpu_quantity.setText("Unid. en almacén: "+Integer.toString(this.cpu)+"/20");
                break;
            case 3:
                this.ram += 1;
                Home.ram_quantity.setText("Unid. en almacén: "+Integer.toString(this.ram)+"/55");
                break;
            case 4:
                this.power += 1;
                Home.power_quantity.setText("Unid. en almacén: "+Integer.toString(this.power)+"/35");
                break;
            case 5:
                this.graphic_cards += 1;
                Home.graphic_quantity.setText("Unid. en almacén: "+Integer.toString(this.power)+"/10");
                break;
        }
        
    }
    
    /**
     * Función para calcular la cantidad de computadores que es posible ensamblar en base a los componentes disponibles en la tienda
     *
     * @param amount // Total de componentes de ese tipo (type) disponibles en la tienda
     * @param type // Tipo de componente
     * @return quantity // Cantidad de computadoras posibles
     */
    public int possibleComputers (int amount, int type) {
        int componentAmount = amount; // Total de componentes de ese tipo (type) disponibles en la tienda
        int quantity = 0; // Camtidad de computadoras que se pueden producir según la disponibilidad de ese componente
        
        while (componentAmount > 0) {
            int spare = componentAmount - necessaryComponents[type]; // Son los componentes que sobran después de tomar los que necesito
            if (spare >= 0) { // Si hay suficiente disponibilidad de componentes
                quantity += 1; 
            } 
            componentAmount = spare; // Se iguala los componentes disponibles a los sobrantes
        }
        return quantity;
    }
    
    /**
     * Función para ensamblar las computadoras y agregarlas a la tienda
     * Actualiza los compontentes disponibles en la tienda
     * 
     * @param assemblersAmount // Cantidad de ensambladores disponibles
     */
    public void assembleComputer (int assemblersAmount) {
        
        int[] component = null;
        component[0] = motherboards;
        component[1] = cpu;
        component[2] = ram;
        component[3] = power;
        
        
        int computersAmount = assemblersAmount; // Se inicializa la cantidad de computadoras posibles en el número de ensambladores disponibles para ir disminuyendo de ser necesario
        
        for (int i = 0; i < 4; i++) {
            int quantity = possibleComputers (component[i], i); 
        
            if (quantity < computersAmount) {
                computersAmount = quantity; // Si la cantidad de componentes necesarios disponibles es menor, se iguala la cantidad de computadoras a esa
            }
         }
        
    }
    
    
    
    
}
