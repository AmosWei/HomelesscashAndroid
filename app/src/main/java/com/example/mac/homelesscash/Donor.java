package com.example.mac.homelesscash;

public class Donor {
    String username;
    String email;
    String password;
    String beaconID;
    int totalAmount;

    public Donor(){
    }

    public Donor(String username, String email, String password, String beaconID, int totalAmount){
        this.username = username;
        this.email = email;
        this.password = password;
        this.beaconID = beaconID;
        this.totalAmount = totalAmount;
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getBeaconID(){
        return beaconID;
    }

    public void setBeaconID(String beaconID){
        this.beaconID = beaconID;
    }

    public int getTotalAmount(){
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount){
        this.totalAmount = totalAmount;
    }
}
