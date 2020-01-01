package com.example.hiddenvalley;

public class Contact {
    String username,pass,password;

    public Contact(String username,String pass,String password){
        this.username=username;
        this.pass=pass;
        this.password=password;
    }

    public void setUsername(String username){
        this.username=username;
    }
    public String getUsername(){
        return username;
    }
    public void setPass(String pass){
        this.pass=pass;
    }
    public String getPass(){
        return pass;
    }
    public void setPassword(String password){
        this.password=password;
    }
    public String getPassword(){
        return password;

    }
}
