package org.bochinar.junitapp.ejemplo.beans;

public class BookingResponse {

    private String idFolio;
    private String response;

    private String customerName;
    private int tableSize;
    private String date;
    private String time;

    public String getIdFolio() {
        return idFolio;
    }

    public void setIdFolio(String idFolio) {
        this.idFolio = idFolio;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
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

    public BookingResponse(String idFolio, String response, String customerName, int tableSize, String date, String time) {
        this.idFolio = idFolio;
        this.response = response;
        this.customerName = customerName;
        this.tableSize = tableSize;
        this.date = date;
        this.time = time;
    }
}
