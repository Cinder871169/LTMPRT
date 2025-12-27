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
public class Book implements Serializable{
    private static final long serialVersionUID = 20241123L; 
    public String id, title, author, code;
    public int yearPublished, pageCount;

    public Book(String id, String title, String author, int yearPublished, int pageCount) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.pageCount = pageCount;
    }
}
