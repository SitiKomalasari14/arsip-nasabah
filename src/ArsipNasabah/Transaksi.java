/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArsipNasabah;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author Siti Komalasari
 */
public class Transaksi implements java.io.Serializable {
    private String norek;
    private String jenisT;
    private String tanggal;
    private int kodeT;
    private float jumlahT;
    
    public Transaksi() {
    }
    
    public Transaksi(String norek, String jenisT, String tanggal, int kodeT, float jumlahT) {
        this.norek = norek;
        this.jenisT = jenisT;
        this.tanggal = tanggal;
        this.kodeT = kodeT;
        this.jumlahT = jumlahT;
    }
    
    public String getNorek() {
        return norek;
    }
    public void setNorek(String norek) {
        this.norek = norek;
    }
    
    public String getJenisT() {
        return jenisT;
    }
    public void setJenisT(String jenisT) {
        this.jenisT = jenisT;
    }
    
    public String getTanggal() {
        return tanggal;
    }
    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }
    
    public int getKodeT() {
        return kodeT;
    }
    public void setKodeT(int kodeT) {
        this.kodeT = kodeT;
    }
    
    public float getJumlahT() {
        return jumlahT;
    }
    
    public void setJumlahT(float jumlahT) {
        this.jumlahT = jumlahT;
    }
}