package com.elango.ehr;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
    

    private String primaryAddress;
    private String secondaryAddress;
    private int pincode;
    private int mobNo;
    private String residentName;

    public Address() {}

 
    public Address(String primaryAddress, String secondaryAddress, int pincode, int mobNo, String residentName) {
        this.primaryAddress = primaryAddress;
        this.secondaryAddress = secondaryAddress;
        this.pincode = pincode;
        this.mobNo = mobNo;
        this.residentName = residentName;
    }

    
    @Override
    public String toString() {
        return "Address [primaryAddress=" + primaryAddress + ", secondaryAddress=" + secondaryAddress + ", pincode="
                + pincode + ", mobNo=" + mobNo + ", residentName=" + residentName + "]";
    }


    public String getPrimaryAddress() {
        return primaryAddress;
    }
    public void setPrimaryAddress(String primaryAddress) {
        this.primaryAddress = primaryAddress;
    }
    public String getSecondaryAddress() {
        return secondaryAddress;
    }
    public void setSecondaryAddress(String secondaryAddress) {
        this.secondaryAddress = secondaryAddress;
    }
    public int getPincode() {
        return pincode;
    }
    public void setPincode(int pincode) {
        this.pincode = pincode;
    }
    public int getMobNo() {
        return mobNo;
    }
    public void setMobNo(int mobNo) {
        this.mobNo = mobNo;
    }
    public String getResidentName() {
        return residentName;
    }
    public void setResidentName(String residentName) {
        this.residentName = residentName;
    }


    
}
