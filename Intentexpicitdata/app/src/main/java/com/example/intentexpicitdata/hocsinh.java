package com.example.intentexpicitdata;

import java.io.Serializable;

public class hocsinh implements Serializable {
    private String name;
    private String diaChi;

    public hocsinh(String name, String diaChi) {
        this.name = name;
        this.diaChi = diaChi;
    }

    public String getName() {
        return name;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
}
