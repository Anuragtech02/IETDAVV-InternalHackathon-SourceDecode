package com.sepsis.sepsis.model;

public class patient_model {
    private String mname, musermae,mage, mgender;

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getMusermae() {
        return musermae;
    }

    public void setMusermae(String musermae) {
        this.musermae = musermae;
    }

    public String getMage() {
        return mage;
    }

    public void setMage(String mage) {
        this.mage = mage;
    }

    public String getMgender() {
        return mgender;
    }

    public void setMgender(String mgender) {
        this.mgender = mgender;
    }

    public patient_model(String mname, String musermae, String mage, String mgender) {
        this.mname = mname;
        this.musermae = musermae;
        this.mage = mage;
        this.mgender = mgender;
    }

    public patient_model() {
    }
}
