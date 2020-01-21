package com.sepsis.sepsis.model;

public class staff_reis_model {
    private String mname;

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getMempno() {
        return mempno;
    }

    public void setMempno(String mempno) {
        this.mempno = mempno;
    }

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

    public staff_reis_model(String mname, String mempno, String username, String password) {
        this.mname = mname;
        this.mempno = mempno;
        this.username = username;
        this.password = password;
    }

    public staff_reis_model() {
    }

    private String mempno;
    private String username;
    private String password;
}
