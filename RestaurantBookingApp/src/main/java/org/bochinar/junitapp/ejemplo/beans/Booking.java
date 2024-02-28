package org.bochinar.junitapp.ejemplo.beans;

import java.util.Objects;

public class Booking {
    private String id;
    private String customerName;
    private int tableSize;
    private String date;
    private String time;


    public Booking() {
    }

    public Booking(String id, String customerName, int tableSize, String date, String time) {
        this.id = id;
        this.customerName = customerName;
        this.tableSize = tableSize;
        this.date = date;
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getTableSize() {
        return tableSize;
    }

    public void setTableSize(int tableSize) {
        this.tableSize = tableSize;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id='" + id + '\'' +
                ", customerName='" + customerName + '\'' +
                ", tableSize=" + tableSize +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
