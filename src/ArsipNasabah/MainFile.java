/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArsipNasabah;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Siti Komalasari
 */
public class MainFile {
    Scanner sc = new Scanner(System.in);
    
    public void SaveToFile() {
        Nasabah N = new Nasabah();
        float saldo;
        String norek="", pin="", nama="";
        System.out.println("======= Masukan Data Nasabah Awal =======");
        ObjectOutputStream out = null;
        System.out.print("Masukan jumlah data nasabah yang ingin ditambahkan: ");
        int n = sc.nextInt();
        try {
            out = new ObjectOutputStream(new FileOutputStream
            ("C:\\Users\\Mala Padilah\\OneDrive\\Documents\\NetBeansProjects\\Algoritma Pemrograman\\Nasabah.dat" + ""));
            BufferedReader brInput = new BufferedReader(new InputStreamReader(System.in));
            for(int i=0; i<n; i++) {
                try {
                    System.out.print("No Rekening: ");
                    norek = brInput.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    System.out.print("PIN: ");
                    pin = brInput.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    System.out.print("Nama: ");
                    nama = brInput.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    System.out.print("Saldo: ");
                    saldo = sc.nextFloat();
                    N = new Nasabah(norek,pin,nama,saldo);
                    out.writeObject(N);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void ViewFile(){
        Nasabah N = new Nasabah();
        int total=0;
        System.out.println("======= Tampilkan Data Nasabah ======="); 
        ObjectInputStream in = null;
        try {
            in=new ObjectInputStream(new FileInputStream
            ("C:\\Users\\Mala Padilah\\OneDrive\\Documents\\NetBeansProjects\\Algoritma Pemrograman\\Nasabah.dat"));
            Object curR = in.readObject();
            try {
                while (true) {
                N = (Nasabah) curR;
                System.out.println("No Rekening: " + N.getNorek());
                System.out.println("PIN: " + N.getPin());
                System.out.println("Nama: "+N.getNama());
                System.out.println("Saldo: "+N.getSaldo());
                System.out.println("");
                total++;
                curR = in.readObject();
                } 
            } catch (EOFException e) {}
        System.out.println("Total record: " + total);
        } catch (ClassNotFoundException e) {
        System.out.println("Class tidak ditemukan.");
        } catch (IOException e) {
        e.printStackTrace();
        } 
    }
    
    public void ViewFile2(String nama){
        Nasabah N = new Nasabah();
        int total=0;
        System.out.println("===== ViewFile2 ====="); 
        ObjectInputStream in = null;
        try {
            in=new ObjectInputStream(new FileInputStream
            (nama));
            Object curR = in.readObject();
            try {
                while (true) {
                N = (Nasabah) curR;
                System.out.println("No Rekening: " + N.getNorek());
                System.out.println("PIN: " + N.getPin());
                System.out.println("Nama: "+N.getNama());
                System.out.println("Saldo: "+N.getSaldo());
                total++;
                curR = in.readObject();
                } 
            } catch (EOFException e) {}
        System.out.println("Total record: " + total);
        } catch (ClassNotFoundException e) {
        System.out.println("Class tidak ditemukan.");
        } catch (IOException e) {
        e.printStackTrace();
        } 
    }
    
    public void SalinFile() {
        Nasabah N = new Nasabah();
        int total=0;
        System.out.println("===== SalinFile ====="); 
        ObjectInputStream in = null;
        ObjectOutputStream out = null;
        try {
            in = new ObjectInputStream(new FileInputStream
            ("C:\\Users\\Mala Padilah\\OneDrive\\Documents\\NetBeansProjects\\Algoritma Pemrograman\\Nasabah.dat"));
            Object curR = in.readObject();
            out = new ObjectOutputStream(new FileOutputStream
            ("C:\\Users\\Mala Padilah\\OneDrive\\Documents\\NetBeansProjects\\Algoritma Pemrograman\\Nasabah2.dat" + ""));
            try {
                while (true) {
                    N = (Nasabah) curR;
                    out.writeObject(N);
                    total++;
                    curR = in.readObject();
                } 
            } catch (EOFException e) {
                System.out.println("Total record: "+ total);                
            } catch (ClassNotFoundException e) {
                System.out.println("Class tidak ditemukan.");
            } catch (IOException e) {
                e.printStackTrace();
            }
            in.close();
            out.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void SalinFile2() {
        Nasabah N = new Nasabah();
        int total=0;
        System.out.println("===== SalinFile ====="); 
        ObjectInputStream in = null;
        ObjectOutputStream out = null;
        try {
            in = new ObjectInputStream(new FileInputStream
            ("C:\\Users\\Mala Padilah\\OneDrive\\Documents\\NetBeansProjects\\Algoritma Pemrograman\\Nasabah.dat"));
            Object curR = in.readObject();
            out = new ObjectOutputStream(new FileOutputStream
            ("C:\\Users\\Mala Padilah\\OneDrive\\Documents\\NetBeansProjects\\Algoritma Pemrograman\\Nasabah2.dat" + ""));
            try {
                while (true) {
                    N = (Nasabah) curR;
                    if(N.getSaldo() >= 10000) {
                        out.writeObject(N);
                        total++;
                    }
                    curR = in.readObject();
                } 
            } catch (EOFException e) {
                System.out.println("Total record: "+ total);                
            } catch (ClassNotFoundException e) {
                System.out.println("Class tidak ditemukan.");
            } catch (IOException e) {
                e.printStackTrace();
            }
            in.close();
            out.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void TambahData() {
        Nasabah N = new Nasabah();
        float saldo = 0;
        String norek="", pin="", nama="";
        
        System.out.print("Masukan jumlah data nasabah yang ingin ditambahkan: ");
        int n = sc.nextInt();

        System.out.println("======= Tambah Data Nasabah Baru =======");
        ObjectInputStream in = null;
        ObjectOutputStream out = null;
        try {
            in=new ObjectInputStream(new FileInputStream
            ("C:\\Users\\Mala Padilah\\OneDrive\\Documents\\NetBeansProjects\\Algoritma Pemrograman\\Nasabah.dat"));
            Object curR = in.readObject();
            out = new ObjectOutputStream(new FileOutputStream
            ("C:\\Users\\Mala Padilah\\OneDrive\\Documents\\NetBeansProjects\\Algoritma Pemrograman\\NasabahTemp.dat" + ""));
            BufferedReader brInput= new BufferedReader(new InputStreamReader(System.in));
            try {
                while (true) {
                    N = (Nasabah) curR;
                    out.writeObject(N);
                    curR = in.readObject();
                }
            } catch (EOFException e) {}
            
            for (int i=0;i<n;i++){
                System.out.println("Nasabah ke-"+(i+1));
                try {
                    System.out.print("No Rekening: ");
                    norek = brInput.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    System.out.print("PIN: ");
                    pin = brInput.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    System.out.print("Nama: ");
                    nama = brInput.readLine();
                } catch (Exception e){
                    e.printStackTrace();
                }
                try {
                    System.out.print("Saldo : ");
                    saldo =sc.nextFloat();
                    N = new Nasabah(norek, pin, nama, saldo); 
                    out.writeObject(N);
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
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
    
    public void MutakhirkanData(){
        Nasabah N = new Nasabah();
        boolean ketemu = false;
        String norek = "", pinBaru="", namaBaru="";
        
        System.out.println("======= Mutakhirkan Data Nasabah =======");
        ObjectInputStream in = null;
        ObjectOutputStream out = null;
        try {
            in=new ObjectInputStream(new FileInputStream
            ("C:\\Users\\Mala Padilah\\OneDrive\\Documents\\NetBeansProjects\\Algoritma Pemrograman\\Nasabah.dat"));
            Object curR = in.readObject();
            out = new ObjectOutputStream(new FileOutputStream
            ("C:\\Users\\Mala Padilah\\OneDrive\\Documents\\NetBeansProjects\\Algoritma Pemrograman\\NasabahTemp.dat" + ""));
            BufferedReader brInput = new BufferedReader(new InputStreamReader(System.in));
            try {
                try {
                    System.out.print("Masukan nomor rekening: ");
                    norek = brInput.readLine();       
                } catch (IOException e) {
                    e.printStackTrace();
                }

                while(!ketemu) {
                    N = (Nasabah) curR;
                    if(N.getNorek().equals(norek)) {
                        ketemu = true;
                    }else {
                        out.writeObject(N);
                        curR = in.readObject();
                    }
                }
            } catch(EOFException e) {
            } catch(IOException e) {
                e.printStackTrace();
            }
            if(ketemu == true) {
                System.out.println("No Rekening: " + N.getNorek());
                System.out.println("PIN: " + N.getPin());
                System.out.println("Nama: " + N.getNama());
                System.out.println("Saldo: " + N.getSaldo());
                System.out.println("");
                System.out.println("Silakan pilih data yang ingin dimutakhirkan: ");
                System.out.println("1. PIN");
                System.out.println("2. Nama Nasabah");
                System.out.print("Pilihan anda: ");
                int pilih = sc.nextInt();
                switch(pilih) {
                    case 1: System.out.print("PIN baru: ");
                            pinBaru = sc.next();
                            N.setPin(pinBaru);
                            System.out.println("PIN nasabah telah dimutakhirkan");
                            break;
                    case 2: System.out.print("Nama baru: ");
                            namaBaru = sc.next();
                            N.setNama(namaBaru);
                            System.out.println("Nama nasabah telah dimutakhirkan");
                            break;
                    default: System.out.println("Pilihan salah!");
                }
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
        }catch(IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            in = new ObjectInputStream(new FileInputStream
            ("C:\\Users\\Mala Padilah\\OneDrive\\Documents\\NetBeansProjects\\Algoritma Pemrograman\\NasabahTemp.dat"+ ""));
            Object curR = in.readObject();
            out = new ObjectOutputStream(new FileOutputStream
            ("C:\\Users\\Mala Padilah\\OneDrive\\Documents\\NetBeansProjects\\Algoritma Pemrograman\\Nasabah.dat"+ ""));
            try {
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
            in.close();
            out.close();
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public void HapusData() {
        Nasabah N = new Nasabah();
        String norek = "";
        int total = 0;
        boolean ketemu = false;
        
        System.out.println("======= Hapus Data Nasabah =======");
        ObjectInputStream in = null;
        ObjectOutputStream out = null;
        try {
            in = new ObjectInputStream(new FileInputStream("Nasabah.dat" + ""));
            Object curR = in.readObject();
            out = new ObjectOutputStream(new FileOutputStream("NasabahTemp.dat" + ""));
            BufferedReader brInput = new BufferedReader(new InputStreamReader(System.in));
            try {
                try {
                    System.out.print("Masukan nomor rekening: ");
                    norek = brInput.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                while(true) {
                    N = (Nasabah) curR;
                    if (N.getNorek().equals(norek)) {
                        ketemu = true;
                    } else {
                        out.writeObject(N);
                    }
                    curR = in.readObject();
                }
            } catch (Exception e) {
            }
            out.close();

            if (!ketemu) {
                System.out.println("Nomor rekening tidak ditemukan");
            }else {
                try {
                    in = new ObjectInputStream(new FileInputStream("NasabahTemp.dat" + ""));
                    curR = in.readObject();
                    out = new ObjectOutputStream(new FileOutputStream("Nasabah.dat" + ""));
                    total = 0;
                    try {
                        while (true) {
                            N = (Nasabah) curR;
                            out.writeObject(N);
                            total++;
                            curR = in.readObject();
                        }
                    } catch (EOFException e) {
                        System.out.println("Data nasabah telah dihapus");
                        System.out.println("Total Record : " + total);
                    }
                    in.close();
                    out.close();
                } catch (Exception e) {
                }
            }

        } catch (Exception e) {
        }
    }
    
    public void CariData(){
        Nasabah N = new Nasabah();
        boolean ketemu = false;
        String norek = "";
        
        System.out.println("======= Cari Data Nasabah =======");
        ObjectInputStream in = null;
        ObjectOutputStream out = null;
        try {
            in=new ObjectInputStream(new FileInputStream
            ("C:\\Users\\Mala Padilah\\OneDrive\\Documents\\NetBeansProjects\\Algoritma Pemrograman\\Nasabah.dat"));
            Object curR = in.readObject();
            out = new ObjectOutputStream(new FileOutputStream
            ("C:\\Users\\Mala Padilah\\OneDrive\\Documents\\NetBeansProjects\\Algoritma Pemrograman\\NasabahTemp.dat" + ""));
            BufferedReader brInput = new BufferedReader(new InputStreamReader(System.in));
            try {
                try {
                    System.out.print("Masukan nomor rekening: ");
                    norek = brInput.readLine();       
                } catch (IOException e) {
                    e.printStackTrace();
                }

                while(!ketemu) {
                    N = (Nasabah) curR;
                    if(N.getNorek().equals(norek)) {
                        ketemu = true;
                    }else {
                        out.writeObject(N);
                        curR = in.readObject();
                    }
                }
            } catch(EOFException e) {
            } catch(IOException e) {
                e.printStackTrace();
            }
            if(ketemu == true) {
                System.out.println("No Rekening: " + N.getNorek());
                System.out.println("PIN: " + N.getPin());
                System.out.println("Nama: " + N.getNama());
                System.out.println("Saldo: " + N.getSaldo());
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
                System.out.println("Data nasabah tidak ditemukan");
            }
            in.close();
            out.close();  
        }catch(IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            in = new ObjectInputStream(new FileInputStream
            ("C:\\Users\\Mala Padilah\\OneDrive\\Documents\\NetBeansProjects\\Algoritma Pemrograman\\NasabahTemp.dat"+ ""));
            Object curR = in.readObject();
            out = new ObjectOutputStream(new FileOutputStream
            ("C:\\Users\\Mala Padilah\\OneDrive\\Documents\\NetBeansProjects\\Algoritma Pemrograman\\Nasabah.dat"+ ""));
            try {
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
            in.close();
            out.close();
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    int Menu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Menu: ");
        System.out.println("1. Masukan Data Nasabah Awal");
        System.out.println("2. Tampilkan Data Nasabah");
        System.out.println("3. Tambah Data Nasabah Baru");
        System.out.println("4. Mutakhirkan Data Nasabah");
        System.out.println("5. Hapus Data Nasabah");
        System.out.println("6. Cari Data Nasabah");
        System.out.println("0. Keluar");
        System.out.print("Pilihan Anda: ");
        int X = sc.nextInt();
        return X;
    }
    
    public static void main(String[] args) {
        Nasabah N = new Nasabah();
        MainFile B = new MainFile();
        Scanner sc = new Scanner(System.in);
        int pilih = B.Menu();
        while(pilih!=0) {
            switch(pilih) {
                case 1: B.SaveToFile();break;
                case 2: B.ViewFile();break;
                case 3: B.TambahData();break;
                case 4: B.MutakhirkanData();break;
                case 5: B.HapusData();break;
                case 6: B.CariData();break;
                case 0: System.exit(pilih);break;
                default: System.out.println("Pilihan salah!");
            }
            pilih = B.Menu();
        }
    }
}
