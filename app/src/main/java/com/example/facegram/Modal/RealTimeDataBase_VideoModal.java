package com.example.facegram.Modal;

public class RealTimeDataBase_VideoModal {
    String v_title, v_url;

    public RealTimeDataBase_VideoModal() {
    }

    public RealTimeDataBase_VideoModal(String v_title, String v_url) {
        this.v_title = v_title;
        this.v_url = v_url;
    }

    public String getV_title() {
        return v_title;
    }

    public void setV_title(String v_title) {
        this.v_title = v_title;
    }

    public String getV_url() {
        return v_url;
    }

    public void setV_url(String v_url) {
        this.v_url = v_url;
    }
}
