package com.example.mac.homelesscash;

public class Donor {
    String username;
    String email;
    String password;
    int totalAmount;

    public Donor(){
    }

    public Donor(String username, String email, String password, int totalAmount){
        this.username = username;
        this.email = email;
        this.password = password;
        this.totalAmount = totalAmount;
    }

    public Donor(String email, String password){
        this.email = email;
        this.password = password;
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

    public int getTotalAmount(){
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount){
        this.totalAmount = totalAmount;
    }
}
