/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArsipNasabah;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Siti Komalasari
 */
public class ATM {
    Date tanggal = new Date();
    SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
    String tgl = s.format(tanggal);
    Random random = new Random();
    int kodeT = random.nextInt(999999);
    Scanner sc = new Scanner(System.in);
    
    public void Setoran(String norek) {
        Nasabah N = new Nasabah();
        String jenisT = "Setoran";
        float jumlahT = 0;
        boolean ketemu = false;
        
        System.out.println("======= Setoran =======");
        ObjectInputStream in = null;
        ObjectOutputStream out = null;
        try {
            in=new ObjectInputStream(new FileInputStream
            ("C:\\Users\\Mala Padilah\\OneDrive\\Documents\\NetBeansProjects\\Algoritma Pemrograman\\Nasabah.dat"));
            Object curR = in.readObject();
            out = new ObjectOutputStream(new FileOutputStream
            ("C:\\Users\\Mala Padilah\\OneDrive\\Documents\\NetBeansProjects\\Algoritma Pemrograman\\NasabahTemp.dat" + ""));
            try {
                while(!ketemu) {
                    N = (Nasabah) curR;
                    if(N.getNorek().equals(norek)) {
                        ketemu = true;
                    }else {
                        out.writeObject(N);
                        curR = in.readObject();
                    }
                }
            } catch (EOFException e) {}
            if(ketemu == true) {
                System.out.println("No Rekening: " + N.getNorek());
                System.out.println("Nama: " + N.getNama());
                System.out.println("Saldo: " + N.getSaldo());
                System.out.println("");
                System.out.print("Jumlah Setoran: ");
                jumlahT = sc.nextFloat();
                N.setSaldo(N.getSaldo() + jumlahT);
                System.out.println("Setoran berhasil");
                // Menyimpan hasil transaksi ke file Transaksi.dat
                SimpanTransaksi(norek,jenisT,tgl,kodeT,jumlahT);
                out.writeObject(N);
                try {
                    curR = in.readObject();
                    while (true){
                        N = (Nasabah) curR;
                        out.writeObject(N);
                        curR = in.readObject();
                    }
                } catch (EOFException e){
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            } else{
                System.out.println("Nomor rekening tidak ditemukan");
            }
            in.close();
            out.close();
            try {
                in=new ObjectInputStream(new FileInputStream
                ("C:\\Users\\Mala Padilah\\OneDrive\\Documents\\NetBeansProjects\\Algoritma Pemrograman\\NasabahTemp.dat"));
                curR = in.readObject();
                out = new ObjectOutputStream(new FileOutputStream
                ("C:\\Users\\Mala Padilah\\OneDrive\\Documents\\NetBeansProjects\\Algoritma Pemrograman\\Nasabah.dat" + ""));
                try {
                    while(true) {
                        N = (Nasabah) curR;
                        out.writeObject(N);
                        curR = in.readObject();
                    }
                } catch (EOFException e) {}
                in.close();
                out.close(); 
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            System.out.println("File tidak ditemukan.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void Penarikan(String norek) {
        Nasabah N = new Nasabah();
        String jenisT = "Penarikan";
        float jumlahT = 0;
        boolean ketemu = false;
        
        System.out.println("======= Penarikan =======");
        ObjectInputStream in = null;
        ObjectOutputStream out = null;
        try {
            in=new ObjectInputStream(new FileInputStream
            ("C:\\Users\\Mala Padilah\\OneDrive\\Documents\\NetBeansProjects\\Algoritma Pemrograman\\Nasabah.dat"));
            Object curR = in.readObject();
            out = new ObjectOutputStream(new FileOutputStream
            ("C:\\Users\\Mala Padilah\\OneDrive\\Documents\\NetBeansProjects\\Algoritma Pemrograman\\NasabahTemp.dat" + ""));
            try {
                while(!ketemu) {
                    N = (Nasabah) curR;
                    if(N.getNorek().equals(norek)) {
                        ketemu = true;
                    }else {
                        out.writeObject(N);
                        curR = in.readObject();
                    }
                }
            } catch (EOFException e) {}
            if(ketemu == true) {
                System.out.println("No Rekening: " + N.getNorek());
                System.out.println("Nama: " + N.getNama());
                System.out.println("Saldo: " + N.getSaldo());
                System.out.println("");
                System.out.print("Jumlah Penarikan: ");
                jumlahT = sc.nextFloat();
                if(jumlahT > N.getSaldo()) {
                    System.out.println("Jumlah penarikan terlalu besar, saldo tidak cukup");
                    out.writeObject(N);
                }else {
                    N.setSaldo(N.getSaldo() - jumlahT);
                    System.out.println("Penarikan berhasil");
                    // Menyimpan hasil transaksi ke file Transaksi.dat
                    SimpanTransaksi(norek,jenisT,tgl,kodeT,jumlahT);
                    out.writeObject(N);
                }
                try {
                    curR = in.readObject();
                    while (true){
                        N = (Nasabah) curR;
                        out.writeObject(N);
                        curR = in.readObject();
                    }
                } catch (EOFException e){
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            } else{
                System.out.println("Nomor rekening tidak ditemukan");
            }
            in.close();
            out.close(); 
            try {
                in=new ObjectInputStream(new FileInputStream
                ("C:\\Users\\Mala Padilah\\OneDrive\\Documents\\NetBeansProjects\\Algoritma Pemrograman\\NasabahTemp.dat"));
                curR = in.readObject();
                out = new ObjectOutputStream(new FileOutputStream
                ("C:\\Users\\Mala Padilah\\OneDrive\\Documents\\NetBeansProjects\\Algoritma Pemrograman\\Nasabah.dat" + ""));
                try {
                    while(true) {
                        N = (Nasabah) curR;
                        out.writeObject(N);
                        curR = in.readObject();
                    }
                } catch (EOFException e) {}
                in.close();
                out.close(); 
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            System.out.println("File tidak ditemukan.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        
    public void RiwayatTransaksi(String norek){
        Transaksi T = new Transaksi();
        
        System.out.println("======= Riwayat Transaksi ======="); 
        ObjectInputStream in = null;
        try {
            in=new ObjectInputStream(new FileInputStream
            ("C:\\Users\\Mala Padilah\\OneDrive\\Documents\\NetBeansProjects\\Algoritma Pemrograman\\Transaksi.dat"));
            Object curR = in.readObject();
            try {
                while (true) {
                T = (Transaksi) curR;
                if(norek.equals(T.getNorek())) {
                    System.out.println("No Rekening: " + T.getNorek());
                    System.out.println("Jenis Transaksi: " + T.getJenisT());
                    System.out.println("Tanggal Transaksi: " + T.getTanggal());
                    System.out.println("Kode Transaksi: " + T.getKodeT());
                    System.out.println("Jumlah Transaksi: " + T.getJumlahT());
                    System.out.println("");
                    }
                curR = in.readObject();
                } 
            } catch (EOFException e) {}
        } catch (ClassNotFoundException e) {
        System.out.println("Class tidak ditemukan.");
        } catch (IOException e) {
        e.printStackTrace();
        } 
    }
    
    public void CekSaldo(String norek){
        Nasabah N = new Nasabah();
        
        System.out.println("======= Cek Saldo ======="); 
        ObjectInputStream in = null;
        try {
            in=new ObjectInputStream(new FileInputStream
            ("C:\\Users\\Mala Padilah\\OneDrive\\Documents\\NetBeansProjects\\Algoritma Pemrograman\\Nasabah.dat"));
            Object curR = in.readObject();
            try {
                while (true) {
                    N = (Nasabah) curR;
                    if(norek.equals(N.getNorek())) {
                        System.out.println("No Rekening: " + N.getNorek());
                        System.out.println("Nama: " + N.getNama());
                        System.out.println("Saldo: " + N.getSaldo());
                        System.out.println("");
                    }
                    curR = in.readObject();
                } 
            } catch (EOFException e) {}
        } catch (ClassNotFoundException e) {
        System.out.println("Class tidak ditemukan.");
        } catch (IOException e) {
        e.printStackTrace();
        } 
    }
    
    public void SimpanTransaksi(String norek, String jenisT, String tanggal, int kodeT, float jumlahT) {
        Transaksi T = new Transaksi();

        System.out.println("======= Simpan Transaksi =======");
        ObjectInputStream in = null;
        ObjectOutputStream out = null;
        try {
            in=new ObjectInputStream(new FileInputStream
            ("C:\\Users\\Mala Padilah\\OneDrive\\Documents\\NetBeansProjects\\Algoritma Pemrograman\\Transaksi.dat"));
            Object curR = in.readObject();
            out = new ObjectOutputStream(new FileOutputStream
            ("C:\\Users\\Mala Padilah\\OneDrive\\Documents\\NetBeansProjects\\Algoritma Pemrograman\\TransaksiTemp.dat" + ""));
            try {
                while (true) {
                    T = (Transaksi) curR;
                    out.writeObject(T);
                    curR = in.readObject();
                }
            } catch (EOFException e) {}
            
            T = new Transaksi(norek,jenisT,tanggal,kodeT,jumlahT);
            out.writeObject(T);
            out.close();
            try {
                in=new ObjectInputStream(new FileInputStream
                ("C:\\Users\\Mala Padilah\\OneDrive\\Documents\\NetBeansProjects\\Algoritma Pemrograman\\TransaksiTemp.dat"));
                curR = in.readObject();
                out = new ObjectOutputStream(new FileOutputStream
                ("C:\\Users\\Mala Padilah\\OneDrive\\Documents\\NetBeansProjects\\Algoritma Pemrograman\\Transaksi.dat" + ""));
                try {
                    while(true) {
                        T = (Transaksi) curR;
                        out.writeObject(T);
                        curR = in.readObject();
                    }
                } catch (EOFException e) {}
                out.close(); 
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            System.out.println("File tidak ditemukan.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    String Login() {
        Nasabah N = new Nasabah();
        Scanner sc = new Scanner(System.in);
        String norek, pin;
        boolean ketemu = false;
        int ulang = 0;
        System.out.println("======= ATM BANK UNPAS =======");
        do {
            System.out.println("Silakan login...");
            System.out.print("No Rekening: ");
            norek = sc.next();
            System.out.print("PIN: ");
            pin = sc.next();

            ObjectInputStream in = null;
            try {
                in = new ObjectInputStream(new FileInputStream
                ("C:\\Users\\Mala Padilah\\OneDrive\\Documents\\NetBeansProjects\\Algoritma Pemrograman\\Nasabah.dat"));
                Object curR = in.readObject();
                try {
                    while(ketemu == false) {
                        N = (Nasabah) curR;
                        if(norek.equals(N.getNorek()) && pin.equals(N.getPin())) {
                            ketemu = true;
                        }else {
                            curR = in.readObject();
                        }
                    }
                } catch (EOFException e) {}
            } catch (ClassNotFoundException e) {
            System.out.println("Class tidak ditemukan.");
            } catch (IOException e) {
            e.printStackTrace();
            }
            ulang++;
        }while((ketemu == false) && (ulang<3));
        if(ketemu == true) {
            System.out.println("Selamat Datang \nNo Rekening: " + N.getNorek());
                    
            return N.getNorek();
        }else {
            System.out.println("Anda telah melakukan percobaan login sebanyak " + ulang + " kali");
            return "0";
        }
    }

    int Menu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Silakan pilih jenis transaksi:");
        System.out.println("1. Setoran");
        System.out.println("2. Penarikan");
        System.out.println("3. Riwayat Transaksi");
        System.out.println("4. Cek Saldo");
        System.out.println("0. Keluar");
        System.out.print("Pilihan Anda: ");
        int X = sc.nextInt();
        return X;
    }
    
    public static void main(String[] args) {
        ATM atm = new ATM();
        
        String log = atm.Login();
        if(!log.equals("0")) {
            int pilih = atm.Menu();
            while(pilih!=0) {
                switch(pilih) {
                    case 1: atm.Setoran(log);break;
                    case 2: atm.Penarikan(log);break;
                    case 3: atm.RiwayatTransaksi(log);break;
                    case 4: atm.CekSaldo(log);break;
                    case 0: System.exit(pilih);break;
                    default: System.out.println("Pilihan salah!");
                }
                pilih = atm.Menu();
            }
        }
    }
}