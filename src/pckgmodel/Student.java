package pckgmodel;

import java.sql.Date;

public class Student {
    private int id;
    String name, address;
    private int sem;
    private int roll;
    private String username;
    private String password;
    private String dob;

    
    
    public String getDob() {
        return dob;
    }

    public void setDob(String dob){
        this.dob=dob;
    }

    public Date getRegDate() {
       // regDate=new Date(); // always returns system current date and time
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }
    private Date regDate;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
           

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getSem() {
        return sem;
    }

    public void setSem(int sem) {
        this.sem = sem;
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }
}
