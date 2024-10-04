/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import Interfaces.Home;

import Interfaces.Home;
import java.util.concurrent.Semaphore;

/**
 *
 * @author alons
 */
public class Store {
    
    //Productos fabricados
    private int motherboards;
    private int cpu;
    private int ram;
    private int power;
    private int graphic_cards;
    private int computersQuantity;
    private int computerWithGraphic;
    private Company company;
    private int [] necessaryComponents;
    private int earnings;
    private int computerPrice;
    
    private int graphicsQuantity; //per Computer

    /**
     * Get the value of graphicsQuantity necessary per Computer
     *
     * @return the value of graphicsQuantity
     */
    public int getGraphicsQuantity() {
        return graphicsQuantity;
    }

    /**
     * Set the value of graphicsQuantity
     *
     * @param graphicsQuantity new value of graphicsQuantity
     */
    public void setGraphicsQuantity(int graphicsQuantity) {
        this.graphicsQuantity = graphicsQuantity;
    }


    /**
     * Get the value of computerPrice
     *
     * @return the value of computerPrice
     */
    public int getComputerPrice() {
        return computerPrice;
    }

    /**
     * Set the value of computerPrice
     *
     * @param computerPrice new value of computerPrice
     */
    public void setComputerPrice(int computerPrice) {
        this.computerPrice = computerPrice;
    }


    /**
     * Get the value of earnings
     *
     * @return the value of earnings
     */
    public int getEarnings() {
        return earnings;
    }

    /**
     * Set the value of earnings
     *
     * @param earnings new value of earnings
     */
    public void setEarnings(int earnings) {
        this.earnings = earnings;
    }


    public int[] getNecessaryComponents() {
        return necessaryComponents;
    }

    public void setNecessaryComponents(int[] necessaryComponents) {
        this.necessaryComponents = necessaryComponents;
    }
    private int deadline;
    
    //Semáforos
    private Semaphore productionMutex; //acceso a unidades producidas
    private Semaphore daysMutex; //acceso al contador de dias

    public Store(int deadline) {
        this.productionMutex = new Semaphore(1);
        this.daysMutex = new Semaphore(1);
        this.deadline = deadline;
        this.company = this.getCompany();
        this.motherboards = 0;
        this.cpu = 0;
        this.ram = 0;
        this.graphic_cards = 0;
        this.power=0;
        this.computersQuantity = 0;
        this.computerWithGraphic = 0;
        
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
    
    public void AddComponent(int employee_type, String company_name){
        
        if ("Apple".equals(company_name)) {
            switch(employee_type){
            case 1:
              if (this.motherboards < 25) {
                this.motherboards += 1;
                Home.base_quantity.setText("Unid. en almacén: "+Integer.toString(this.motherboards)+"/25");
              }
              break;
            case 2:
              if (this.cpu < 20) {  
                this.cpu += 1;
                Home.cpu_quantity.setText("Unid. en almacén: "+Integer.toString(this.cpu)+"/20");
              }
                break;
            case 3:
                if (this.ram < 55) {
                    this.ram += 1;
                    Home.ram_quantity.setText("Unid. en almacén: "+Integer.toString(this.ram)+"/55");
                }
                break;
            case 4:
                if (this.power < 31) {
                    this.power += 5;
                    Home.power_quantity.setText("Unid. en almacén: "+Integer.toString(this.power)+"/35");
                }
                break;
            case 5:
                if (this.graphic_cards< 10) {
                    this.graphic_cards += 1;
                    Home.graphic_quantity.setText("Unid. en almacén: "+Integer.toString(this.graphic_cards)+"/10");
                }
                break;
        
            }
            
        
        } else if ("Dell".equals(company_name)) {
            switch(employee_type){
            case 1:
              if (this.motherboards < 25) {
                this.motherboards += 1;
                Home.base_quantity1.setText("Unid. en almacén: "+Integer.toString(this.motherboards)+"/25");
              }
              break;
            case 2:
              if (this.cpu < 20) {  
                this.cpu += 1;
                Home.cpu_quantity1.setText("Unid. en almacén: "+Integer.toString(this.cpu)+"/20");
              }
                break;
            case 3:
                if (this.ram < 55) {
                    this.ram += 1;
                    Home.ram_quantity1.setText("Unid. en almacén: "+Integer.toString(this.ram)+"/55");
                }
                break;
            case 4:
                if (this.power < 31) {
                    this.power += 5;
                    Home.power_quantity1.setText("Unid. en almacén: "+Integer.toString(this.power)+"/35");
                }
                break;
            case 5:
                if (this.graphic_cards< 10) {
                    this.graphic_cards += 1;
                    Home.graphic_quantity1.setText("Unid. en almacén: "+Integer.toString(this.graphic_cards)+"/10");
                }
                break;
        
            }
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
        
        int[] component = {motherboards,cpu,ram,power};  
        
        int computersAmount = assemblersAmount; // Se inicializa la cantidad de computadoras posibles en el número de ensambladores disponibles para ir disminuyendo de ser necesario
        
        for (int i = 0; i < 4; i++) {
            int quantity = possibleComputers (component[i], i); 
        
            if (quantity < computersAmount) {
                computersAmount = quantity; // Si la cantidad de componentes necesarios disponibles es menor, se iguala la cantidad de computadoras a esa
            }
        }
        
        this.computersQuantity += computersAmount;
        
        int amount = computersQuantity-1;
        
        // Caso Tarjeta Gráfica
        
        if (amount > 0 && amount % 5 == 0) {
            
            this.computerWithGraphic = amount / 5;
            graphic_cards -= this.getGraphicsQuantity();
            
            
        }
        
        // Se actualiza la disponibilidad en la tienda
        motherboards -= computersAmount*necessaryComponents[0];
        cpu -= computersAmount*necessaryComponents[1];
        ram -= computersAmount*necessaryComponents[2];
        power -= computersAmount*necessaryComponents[3];
        
        //Reflejo interfaz
        
        if ("Apple".equals(this.company.getName())) {
            Home.comp_quantity.setText("Computadoras: "+ Integer.toString(computersQuantity));
            Home.comp_graph_quantity.setText("con Gráficas: "+ Integer.toString(computerWithGraphic));
        } else {
            Home.comp_quantity1.setText("Computadoras: "+ Integer.toString(computersQuantity));
            Home.comp_graph_quantity1.setText("con Gráficas: "+ Integer.toString(computerWithGraphic));
        }
        
    }
    
    /**
     * Checkea que ya se tengan todos los componentes necesarios para armar al menos una computadora
     * @return ready
     */
    public boolean check(){
        boolean ready = false;
        if (motherboards >= necessaryComponents[0] &&  cpu >= necessaryComponents[1] && ram >= necessaryComponents[2] && power >= necessaryComponents[3]){
            ready= true;
        }
        return ready;
    }
    
    public void sendComputers() {
        //
        earnings += computersQuantity*computerPrice;
        computersQuantity = 0;
        computerWithGraphic = 0;
        
        if ("Apple".equals(this.company.getName())) {
            Home.comp_quantity.setText("Computadoras: "+ Integer.toString(computersQuantity));
            Home.comp_graph_quantity.setText("con Gráficas: "+ Integer.toString(computerWithGraphic));
        } else {
            Home.comp_quantity1.setText("Computadoras: "+ Integer.toString(computersQuantity));
            Home.comp_graph_quantity1.setText("con Gráficas: "+ Integer.toString(computerWithGraphic));
        }
        
        
        if ("Apple".equals(this.company.getName())) {
            Home.ganancias.setText("Ganancias: "+ Integer.toString(earnings)+"K");
        } else {
            Home.ganancias1.setText("Ganancias: "+ Integer.toString(earnings)+"K");
        }
        
        System.out.print("\nComputadoras enviadas");
    }

    /**
     * @return the productionMutex
     */
    public Semaphore getProductionMutex() {
        return productionMutex;
    }

    /**
     * @param productionMutex the productionMutex to set
     */
    public void setProductionMutex(Semaphore productionMutex) {
        this.productionMutex = productionMutex;
    }

    /**
     * @return the daysMutex
     */
    public Semaphore getDaysMutex() {
        return daysMutex;
    }

    /**
     * @param daysMutex the daysMutex to set
     */
    public void setDaysMutex(Semaphore daysMutex) {
        this.daysMutex = daysMutex;
    }

    /**
     * @return the company
     */
    public Company getCompany() {
        return company;
    }

    /**
     * @param company the company to set
     */
    public void setCompany(Company company) {
        this.company = company;
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
    
    
    
    
}
