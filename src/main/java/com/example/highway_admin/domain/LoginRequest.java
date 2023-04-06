package com.example.highway_admin.domain;

public class LoginRequest {

    private int id;
    private String password;

    private String adminFlg;

    private String passCode;

    public String getAdminFlg() {
        return adminFlg;
    }

    public void setAdminFlg(String adminFlg) {
        this.adminFlg = adminFlg;
    }

    public String getPassCode() {
        return passCode;
    }

    public void setPassCode(String passCode) {
        this.passCode = passCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
