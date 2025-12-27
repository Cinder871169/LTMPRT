/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMI;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class Product implements Serializable{
    private static final long serialVersionUID = 20151107L;
    public String id, code;
    public Double importPrice, exportPrice;

    public Product(String id, String code, Double importPrice, Double exportPrice) {
        this.id = id;
        this.code = code;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
    }

    public Product() {
    }
    
}
