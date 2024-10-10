/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

/**
 *
 * @author marie
 * 
 */


import Clases.Store;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;


public class Global {
    
    final static XYSeries apple = new XYSeries( "Apple" );
    final static XYSeries dell = new XYSeries( "Dell" );
      
    public final static XYSeriesCollection dataset = new XYSeriesCollection( );
    
    public static int daycounter = 0;

    public static XYSeries getApple() {
        return apple;
    }

    public static XYSeries getDell() {
        return dell;
    }

    public static XYSeriesCollection getDataset() {
        return dataset;
    }
    
    public static void addApple(int num1, int num2){
        getApple().add(num1, num2);
    }
    
    public static void addDell(int num1, int num2){
        getDell().add(num1, num2);
    }   
    
    public static void addSeries(XYSeries computer){
        getDataset().addSeries(computer);
    }

    public static int getDaycounter() {
        return daycounter;
    }

    public static void setDaycounter(int daycounter) {
        Global.daycounter = daycounter;
    }
    
}
