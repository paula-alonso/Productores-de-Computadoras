/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author alons
 */
public class Store {
    private int motherboards;
    private int cpu;
    private int ram;
    private int graphic_cards;

    public Store(int motherboards, int cpu, int ram, int graphic_cards) {
        this.motherboards = motherboards;
        this.cpu = cpu;
        this.ram = ram;
        this.graphic_cards = graphic_cards;
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
        System.out.println("se agrego una parte");
        switch(employee_type){
            case 1:
              this.motherboards += 1;
              break;
            case 2:
                this.cpu += 1;
                break;
            case 3:
                this.ram += 1;
                break;
            case 4:
                this.graphic_cards += 1;
                break;
        }
    }
}
