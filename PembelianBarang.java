/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package uas_ppbo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Kelas Barang merepresentasikan barang yang akan dibeli
class Barang {
    private String kode;
    private String nama;
    private double harga;

    public Barang(String kode, String nama, double harga) {
        this.kode = kode;
        this.nama = nama;
        this.harga = harga;
    }

    public String getKode() {
        return kode;
    }

    public String getNama() {
        return nama;
    }

    public double getHarga() {
        return harga;
    }
}

// Kelas KeranjangBelanja mengelola daftar barang yang akan dibeli
class KeranjangBelanja {
    private List<Barang> daftarBarang;

    public KeranjangBelanja() {
        daftarBarang = new ArrayList<>();
    }

    public void tambahBarang(Barang barang) {
        daftarBarang.add(barang);
        System.out.println("Barang \"" + barang.getNama() + "\" ditambahkan ke keranjang belanja.");
    }

    public void hapusBarang(String kode) {
        Barang barangDihapus = null;
        for (Barang barang : daftarBarang) {
            if (barang.getKode().equals(kode)) {
                barangDihapus = barang;
                break;
            }
        }

        if (barangDihapus != null) {
            daftarBarang.remove(barangDihapus);
            System.out.println("Barang \"" + barangDihapus.getNama() + "\" dihapus dari keranjang belanja.");
        } else {
            System.out.println("Barang dengan kode \"" + kode + "\" tidak ditemukan dalam keranjang belanja.");
        }
    }

    public double hitungTotalHarga() {
        double totalHarga = 0;
        for (Barang barang : daftarBarang) {
            totalHarga += barang.getHarga();
        }
        return totalHarga;
    }

    public void tampilkanDetailPembelian() {
        if (daftarBarang.isEmpty()) {
            System.out.println("Keranjang belanja kosong.");
        } else {
            System.out.println("Detail Pembelian:");
            for (Barang barang : daftarBarang) {
                System.out.println("Kode Barang: " + barang.getKode());
                System.out.println("Nama Barang: " + barang.getNama());
                System.out.println("Harga Barang: " + barang.getHarga());
                System.out.println("--------------------");
            }
            System.out.println("Total Harga: " + hitungTotalHarga());
        }
    }
}

// Kelas utama untuk menjalankan program
public class PembelianBarang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        KeranjangBelanja keranjangBelanja = new KeranjangBelanja();

        boolean exit = false;
        while (!exit) {
            System.out.println("Program Pembelian Barang");
            System.out.println("1. Tambah Barang ke Keranjang Belanja");
            System.out.println("2. Hapus Barang dari Keranjang Belanja");
            System.out.println("3. Hitung Total Harga");
            System.out.println("4. Tampilkan Detail Pembelian");
            System.out.println("5. Exit");
            System.out.print("Masukkan pilihan Anda: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan kode barang: ");
                    String kodeBarang = scanner.nextLine();
                    System.out.print("Masukkan nama barang: ");
                    String namaBarang = scanner.nextLine();
                    System.out.print("Masukkan harga barang: ");
                    double hargaBarang = scanner.nextDouble();
                    scanner.nextLine();

                    Barang barang = new Barang(kodeBarang, namaBarang, hargaBarang);
                    keranjangBelanja.tambahBarang(barang);
                    break;

                case 2:
                    System.out.print("Masukkan kode barang yang akan dihapus: ");
                    String kodeHapus = scanner.nextLine();
                    keranjangBelanja.hapusBarang(kodeHapus);
                    break;

                case 3:
                    double totalHarga = keranjangBelanja.hitungTotalHarga();
                    System.out.println("Total Harga: " + totalHarga);
                    break;

                case 4:
                    keranjangBelanja.tampilkanDetailPembelian();
                    break;

                case 5:
                    exit = true;
                    System.out.println("Terima kasih telah menggunakan program Pembelian Barang. Sampai jumpa!");
                    break;

                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                    break;
            }

            System.out.println();
        }
    }
}
