package com.JWT.Sample.Model;

import lombok.Builder;

@Builder
public class JWTRequest {

    private String email;
    private String password;

    public JWTRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public JWTRequest() {
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "JWTRequest {\n" +
                "email : " + email + ",\n" +
                "password : " + password + "\n}\n";
    }

}
