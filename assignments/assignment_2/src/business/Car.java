/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.Date;

/**
 * Class for storing the details regarding a car
 * @author raghavan
 */
public class Car {
    /**
     * Member variables that define the attributes of a car
     */
    private String serialNumber;
    private String modelNumber;
    private String manufacturer;
    private Integer totalSeats;
    private Integer availableSeats;
    private boolean available;
    private Date maintenanceCertificateExpiry;
    private Integer manufacturedYear;
    private String city;
    
    /**
     * Constructors for this class
     */

    public Car() {
        this.serialNumber = "";
        this.modelNumber = "";
        this.manufacturer = "";
        this.totalSeats = 0;
        this.availableSeats = 0;
        this.available = false;
        this.maintenanceCertificateExpiry = new Date();
        this.manufacturedYear = 1900;
        this.city = "n/a";
    }

    public Car(String serialNumber, String modelNumber, String manufacturer, 
            Integer totalSeats, Integer availableSeats, boolean available, 
            Date maintenanceCertificateExpiry, Integer manufacturedYear, 
            String city) {
        this.serialNumber = serialNumber;
        this.modelNumber = modelNumber;
        this.manufacturer = manufacturer;
        this.totalSeats = totalSeats;
        this.availableSeats = availableSeats;
        this.available = available;
        this.maintenanceCertificateExpiry = maintenanceCertificateExpiry;
        this.manufacturedYear = manufacturedYear;
        this.city = city;
    }
    
    /**
     * Getters and setters for the member variables
     */

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Integer getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(Integer totalSeats) {
        this.totalSeats = totalSeats;
    }

    public Integer getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(Integer availableSeats) {
        this.availableSeats = availableSeats;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Date getMaintenanceCertificateExpiry() {
        return maintenanceCertificateExpiry;
    }

    public void setMaintenanceCertificateExpiry(Date maintenanceCertificateExpiry) {
        this.maintenanceCertificateExpiry = maintenanceCertificateExpiry;
    }

    public Integer getManufacturedYear() {
        return manufacturedYear;
    }

    public void setManufacturedYear(Integer manufacturedYear) {
        this.manufacturedYear = manufacturedYear;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    
    @Override
    public String toString() {
        return serialNumber;
    }
}
