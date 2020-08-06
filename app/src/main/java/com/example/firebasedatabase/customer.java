package com.example.firebasedatabase;

public class customer {
    public String FullName,UserName,Email,Password,Gender;
    public customer(String fullname, String username1, String email, String password1, String gender){

    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public customer(String password) {
        Password = password;
    }

    public customer(String fullName, String userName, String email, String gender) {
        FullName = fullName;
        UserName = userName;
        Email = email;
        Gender = gender;

    }

}
