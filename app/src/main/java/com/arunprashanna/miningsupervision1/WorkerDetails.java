package com.arunprashanna.miningsupervision1;

public class WorkerDetails {
    public String name, tagId, mobileNo, age, dob, address;

    public WorkerDetails() { }

    public WorkerDetails(String name, String tagId, String mobileNo, String age, String dob, String address) {
        this.name = name;
        this.tagId = tagId;
        this.mobileNo = mobileNo;
        this.age = age;
        this.dob = dob;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
