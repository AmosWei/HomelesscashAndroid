package com.example.mac.homelesscash;

public class Donor {
    String username;
    String email;
    String password;
    int totalAmount;
    int numberOfDonation;
    int numberOfRecipient;

    public Donor(){
    }

    public Donor(String username, String email, String password, int totalAmount, int numberOfDonation, int numberOfRecipient){
        this.username = username;
        this.email = email;
        this.password = password;
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

    public int getTotalAmount(){
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount){
        this.totalAmount = totalAmount;
    }

    public int getNumberOfDonation(){
        return numberOfDonation;
    }

    public void setNumberOfDonation(int numberOfDonation){
        this.numberOfDonation = numberOfDonation;
    }

    public int getNumberOfRecipient(){
        return numberOfRecipient;
    }

    public void setNumberOfRecipient(int numberOfRecipient){
        this.numberOfRecipient = numberOfRecipient;
    }
}
