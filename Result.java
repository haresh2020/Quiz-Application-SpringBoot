package com.example.store.product;


import jakarta.persistence.*;

@Entity
@Table(name = "Result")
public class Result {
    @Id@GeneratedValue(strategy=GenerationType.SEQUENCE)
    private int sno;
    private String userId;
    private int result;
    private String email;
    public int getSno() {
        return sno;
    }
    public void setSno(int sno) {
        this.sno = sno;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public int getResult() {
        return result;
    }
    public void setResult(int result) {
        this.result = result;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
