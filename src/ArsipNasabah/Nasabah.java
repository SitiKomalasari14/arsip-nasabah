/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArsipNasabah;

/**
 *
 * @author Siti Komalasari
 */

/**
 *
 * @author Hifki Y
 */
public class Nasabah implements java.io.Serializable {
    private String norek;
    private String pin;
    private String nama;
    private float saldo;
    
    public Nasabah() {
    }
    
    public Nasabah(String norek, String pin, String nama, float saldo) {
        this.norek = norek;
        this.pin = pin;
        this.nama = nama;
        this.saldo = saldo;
    }
    
    public String getNorek() {
        return norek;
    }
    public void setNorek(String norek) {
        this.norek = norek;
    }
    
    public String getPin() {
        return pin;
    }
    public void setPin(String pin) {
        this.pin = pin;
    }
    
    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    
    public float getSaldo() {
        return saldo;
    }
    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
}