package com.example.postapiragister2;

public class SendModel {

    String email;
    String password;

    public SendModel(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return "SendModel{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
