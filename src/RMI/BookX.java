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
public class BookX implements Serializable{
    private static final long serialVersionUID = 20241124L;
    public String id, title, author, genre, code;
    public int yearPublished;

    public BookX(String id, String title, String author, String genre, int yearPublished) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.yearPublished = yearPublished;
    }
    
}
