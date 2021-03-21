package com.tp2;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Main {

    public static String nama;
    public static String alamat = "";
    public static String tgl;
    public static String phone;
    public static String status = "";
    public static String noktp = "";

    public static void main(String[] args) {
        inputnama();
        inputtanggal();
        inputhp();
        menu();
    }



    public static void inputnama() {
        boolean inputnama = true;
        while (inputnama) {
            try {
                System.out.print("Masukkan nama : ");
                Scanner input1 = new Scanner(System.in);
                nama = input1.next();
                while (!nama.matches("[a-zA-Z]+")) {
                    System.out.println("Inputan_nama_salah!");
                    System.out.print("Masukkan nama : ");
                    nama = input1.next();
                }
                System.out.println("\tNama : " + nama);

                inputnama = prompt(inputnama);

            } catch (Exception e) {
                System.out.println("Error!");
            }
        }
    }



    public static void inputtanggal() {
        boolean inputtanggal = true;
        while (inputtanggal) {
            try {

                System.out.print("Masukkan tanggal lahir (dd/MM/yyyy): ");
                Scanner input2 = new Scanner(System.in);
                String date = input2.next();

//                SimpleDateFormat formattanggal = new SimpleDateFormat("dd/MM/yyyy");
//                Date tanggal1 = formattanggal.parse(date);
//                String tanggal2 = formattanggal.format(tanggal1);
                String[]out = date.split("/");

                int out0 = Integer.parseInt(out[0]);
                int out1 = Integer.parseInt(out[1]);
                int out2 = Integer.parseInt(out[2]);

                String bulan = "";
                if (out1 == 1) { bulan  = "Januari"; }
                else if (out1 == 2) { bulan  = "Februari"; }
                else if (out1 == 3) { bulan  = "Maret"; }
                else if (out1 == 4) { bulan  = "April"; }
                else if (out1 == 5) { bulan  = "Mei"; }
                else if (out1 == 6) { bulan  = "Juni"; }
                else if (out1 == 7) { bulan  = "Juli"; }
                else if (out1 == 8) { bulan  = "Agustus"; }
                else if (out1 == 9) { bulan  = "September"; }
                else if (out1 == 10) { bulan  = "Oktober"; }
                else if (out1 == 11) { bulan  = "November"; }
                else if (out1 == 12) { bulan  = "Desember"; }

                int count = 0;
                while (out2 != 0) {
                    out2 /= 10;
                    ++count;
                }

                if (out0 < 0 || out0 > 31 || out1 < 1 || out1 > 12 || count != 4){
                    System.out.println("Tgl_Error !");inputtanggal = true;
                }
                else {
                    tgl = out[0] + " " + bulan + " " + out[2];
                    System.out.println("\tTanggal lahir : " + tgl);
                    inputtanggal = prompt(inputtanggal);
                }


            } catch (Exception e) {
                System.out.println("Format_salah!");
            }
        }
    }



    public static void inputhp() {
        boolean inputhp = true;
        while (inputhp) {
            try {
                System.out.print("Masukkan no HP : ");
                Scanner input3 = new Scanner(System.in);
                phone = input3.next();
                while (!phone.matches("[0-9]+")) {
                    System.out.println("Inputan_hp_salah!");
                    System.out.print("Masukkan no HP : ");
                    phone = input3.next();
                }
                System.out.println("\tNomor HP :" + phone);

                inputhp = prompt(inputhp);

            } catch (Exception e) {
                System.out.println("Error!");
            }
        }
    }


    public static void inputalamat() {
        boolean inputalamat = true;
        while (inputalamat) {
            try {
                System.out.print("Masukkan alamat : ");
                Scanner input4 = new Scanner(System.in);
                alamat = input4.next();
                System.out.println("\tAlamat : " + alamat);

                inputalamat = prompt(inputalamat);

            } catch (Exception e) {
                System.out.println("Error!");
            }
        }
    }


    public static void inputstatus() {
        boolean inputstatus = true;
        while (inputstatus) {
            try {
                System.out.print("Masukkan status (1.single/2.menikah): ");
                Scanner input5 = new Scanner(System.in);
                status = input5.next();
                if (status.equals("1")){
                    status = "single";
                    System.out.println("\tStatus (single/menikah): " + status);
                    inputstatus = prompt(inputstatus);
                }
                else if (status.equals("2")){
                    status = "menikah";
                    System.out.println("\tStatus (single/menikah): " + status);
                    inputstatus = prompt(inputstatus);
                }
                else {
                    System.out.println("Input_salah!");inputstatus = true;
                }

            } catch (Exception e) {
                System.out.println("Error!");
            }
        }
    }


    public static void inputnoktp() {
        boolean inputnoktp = true;
        while (inputnoktp) {
            try {
                System.out.print("Masukkan no ktp : ");
                Scanner input6 = new Scanner(System.in);
                noktp = input6.next();
                while (!noktp.matches("[0-9]+")) {
                    System.out.println("Inputan_noktp_salah!");
                    System.out.print("Masukkan no ktp : ");
                    noktp = input6.next();
                }
                System.out.println("\tNo ktp : " + noktp);

                inputnoktp = prompt(inputnoktp);

            } catch (Exception e) {
                System.out.println("Error!");
            }
        }
    }


    public static boolean prompt(boolean data){
        boolean prompt = true;
            while (prompt) {
                System.out.print("yakin ? (Y/N) ");
                Scanner in = new Scanner(System.in);
                String yakin = in.next();
                if (yakin.equals("Y") || yakin.equals("y") || yakin.equals("N") || yakin.equals("n")) {
                    prompt = false;
                    data = yakin.equalsIgnoreCase("n");
                } else {
                    System.out.println("Input anda salah!");
                    prompt = true;
                }
            }
            return data;
    }


    public static void menu(){
        boolean mainmenu = true;
        while (mainmenu) {
            System.out.println(" ");
            System.out.println("\t===Menu Utama===");
            System.out.println("\t1. Lihat Data Diri");
            System.out.println("\t2. Update Data Diri");
            System.out.println("\t3. Keluar");
            System.out.print("Pilih : ");
            Scanner menu = new Scanner(System.in);
            String pilih = menu.next();

            switch (pilih) {

                case "1":
                    System.out.println(" ");
                    System.out.println("\t===Tampil Data Diri===");
                    System.out.println("Nama : " + nama);
                    System.out.println("Alamat : " + ((alamat.equals("")) ? "-" : alamat));
                    System.out.println("Nomor Handphone : " + phone);
                    System.out.println("Tgl lahir : " + tgl);
                    System.out.println("Status : " + ((status.equals("")) ? "-" : status));
                    System.out.println("No KTP : " + ((noktp.equals("")) ? "-" : noktp));
                    break;

                case "2":
                    System.out.println(" ");
                    System.out.println("\t===Update Data Diri===");
                    System.out.println("\t1. Nama");
                    System.out.println("\t2. Alamat");
                    System.out.println("\t3. No HP");
                    System.out.println("\t4. Tgl Lahir");
                    System.out.println("\t5. Status");
                    System.out.println("\t6. No KTP");
                    System.out.println("\t7. Cancel");
                    System.out.print("Pilih : ");
                    Scanner menu2 = new Scanner(System.in);
                    String pilih2 = menu2.next();

                    switch (pilih2){
                        case "1" :
                            inputnama();
                            break;
                        case "2" :
                            inputalamat();
                            break;
                        case "3" :
                            inputhp();
                            break;
                        case "4" :
                            inputtanggal();
                            break;
                        case "5" :
                            inputstatus();
                            break;
                        case "6" :
                            inputnoktp();
                            break;
                        case "7" :
                            mainmenu = true;
                    }
                    break;

                case "3":
                    mainmenu = false;
                    break;

                default:
                    System.out.println("Input anda salah!");

            }
        }
    }

}




