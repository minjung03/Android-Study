package com.cookandroid.and_2102_naengbuhae;

public class DateList {

    String tx_setDate, tx_location, tx_title, tx_viewDate, tx_enroll;

    public DateList(String tx_setDate, String tx_location, String tx_title, String tx_viewDate, String tx_enroll) {
        this.tx_setDate = tx_setDate;
        this.tx_location = tx_location;
        this.tx_title = tx_title;
        this.tx_viewDate = tx_viewDate;
        this.tx_enroll = tx_enroll;
    }

    public String getTx_setDate() {
        return tx_setDate;
    }

    public String getTx_location() {
        return tx_location;
    }

    public String getTx_title() {
        return tx_title;
    }

    public String getTx_viewDate() {
        return tx_viewDate;
    }

    public String getTx_enroll() {
        return tx_enroll;
    }

    public void setTx_setDate(String tx_setDate) {
        this.tx_setDate = tx_setDate;
    }

    public void setTx_location(String tx_location) {
        this.tx_location = tx_location;
    }

    public void setTx_title(String tx_title) {
        this.tx_title = tx_title;
    }

    public void setTx_viewDate(String tx_viewDate) {
        this.tx_viewDate = tx_viewDate;
    }

    public void setTx_enroll(String tx_enroll) {
        this.tx_enroll = tx_enroll;
    }
}
