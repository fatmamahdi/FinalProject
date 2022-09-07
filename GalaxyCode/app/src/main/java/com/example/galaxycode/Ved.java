package com.example.galaxycode;

import java.io.Serializable;

public class Ved implements Serializable {
    private String Ved;
    private int IVed;
    private int SVed;
    private String e;


    public Ved(String ved, int IVed, int SVed, String e) {
        Ved = ved;
        this.IVed = IVed;
        this.SVed = SVed;
        this.e = e;
    }

    public String getVed() {
        return Ved;
    }

    public void setVed(String ved) {
        Ved = ved;
    }

    public int getIVed() {
        return IVed;
    }

    public void setIVed(int IVed) {
        this.IVed = IVed;
    }

    public int getSVed() {
        return SVed;
    }

    public void setSVed(int SVed) {
        this.SVed = SVed;
    }

    public String getE() {
        return e;
    }

    public void setE(String e) {
        this.e = e;
    }
}
