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
public class Event implements Serializable{
    private static final long serialVersionUID = 20241131L;
    public String id, eventName, eventDate, eventCode;
    public int expectedAttendance;

    public Event(String id, String eventName, String eventDate, int expectedAttendance) {
        this.id = id;
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.expectedAttendance = expectedAttendance;
    }

    public Event() {
    }
    
}
