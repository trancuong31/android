package com.example.listview_nangcao;

public class CaSi {
    private String ten;
    private String moTa;
    private int hinh;

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public void setHinh(int hinh) {
        this.hinh = hinh;
    }

    public String getTen() {
        return ten;
    }

    public String getMoTa() {
        return moTa;
    }

    public int getHinh() {
        return hinh;
    }

    public CaSi(String ten, String moTa, int hinh) {
        this.ten = ten;
        this.moTa = moTa;
        this.hinh = hinh;
    }
}
