# Sistem Reimbursement Perjalanan Dinas – PT Mitra Konsultan Prima

Program Java console untuk menghitung dan mencetak laporan reimbursement perjalanan dinas karyawan. Proyek ini adalah kunci jawaban **Jurnal Modul I** dan menerapkan **Enkapsulasi, Pewarisan (Inheritance), Polimorfisme (Overriding), dan Overloading**.

## Struktur Proyek

```
.
├── Main.java             # Titik masuk program, membuat data karyawan
├── Perusahaan.java       # Menyimpan karyawan di ArrayList dan mencetak laporan
├── Karyawan.java         # Superclass
├── Direktur.java         # Subclass: Direktur
├── Manajer.java          # Subclass: Manajer
├── Staf.java             # Subclass: Staf
├── class-diagram-v3-id.png   # Class diagram (Indonesia)
├── class-diagram-v3-en.png   # Class diagram (Inggris)
└── output.txt            # Contoh hasil eksekusi
```

## Cara Menjalankan

Pastikan JDK sudah terpasang (`java -version` dan `javac -version`).

```bash
javac *.java
java Main
```

## Aturan Perhitungan

| Jabatan | Uang saku (per hari) | Penginapan (per malam) | Biaya transport |
| --- | --- | --- | --- |
| Direktur | Rp 500.000 | Rp 1.200.000 | Tiket + sewa mobil |
| Manajer | Rp 350.000 | Rp 800.000 | Tiket |
| Staf | Rp 200.000 | Rp 400.000 | Tiket |

Catatan:
- Uang saku = tarif per hari × lama dinas.
- Jumlah malam = lama dinas − 1.
- Penginapan hanya dibayarkan jika tujuan dinas **Luar Kota**. Jika **Dalam Kota**, karyawan tidak menginap dan biaya penginapan Rp 0.
- Total reimbursement = uang saku + biaya transport + penginapan (hanya jika luar kota).

## Penjelasan Class

| Class | Peran |
| --- | --- |
| `Karyawan` | Superclass berisi atribut umum (`nama`, `idKaryawan`, `jabatan`, `lamaDinas`, `biayaTransport`, `luarKota`), getter dan setter, serta method perhitungan biaya. Bukan abstract class. |
| `Direktur` | Menambah atribut `biayaSewaMobil`. Mengoverride `hitungBiayaTransport()`, `getLabelTransport()`, `hitungUangSaku()`, dan `hitungPenginapan()`. |
| `Manajer` | Mengoverride `hitungUangSaku()` dan `hitungPenginapan()` dengan tarif Manajer. |
| `Staf` | Mengoverride `hitungUangSaku()` dan `hitungPenginapan()` dengan tarif Staf. |
| `Perusahaan` | Menyimpan `ArrayList<Karyawan>`, menambah karyawan lewat `tambahKaryawan()`, dan mencetak laporan semua karyawan lewat `hitungSemuaBiaya()`. |
| `Main` | Membuat 4 karyawan, memasukkannya ke `Perusahaan`, lalu memanggil `hitungSemuaBiaya()`. |

## Konsep OOP yang Diterapkan

- **Enkapsulasi**: seluruh atribut bersifat `private` dan diakses lewat getter dan setter `public`.
- **Pewarisan**: `Direktur`, `Manajer`, dan `Staf` mewarisi `Karyawan` dengan `extends` dan memanggil konstruktor induk lewat `super()`.
- **Polimorfisme (Overriding)**: tiap subclass meng-override `hitungUangSaku()` dan `hitungPenginapan()`. `Direktur` juga meng-override `hitungBiayaTransport()` dan `getLabelTransport()`. `Perusahaan` memanggil method itu lewat tipe `Karyawan`, sehingga yang dijalankan adalah versi milik subclass, tanpa memakai `instanceof`.
- **Overloading**: `hitungBiayaTransport()` dan `hitungBiayaTransport(double biayaSewaMobil)` memakai nama sama dengan parameter berbeda. Versi kedua dipakai oleh `Direktur`.

## Data Karyawan

| Nama | ID | Jabatan | Lama dinas | Tujuan | Transport |
| --- | --- | --- | --- | --- | --- |
| Bayu | DIR01 | Direktur | 4 hari | Luar Kota | Tiket Rp 3.000.000 + sewa mobil Rp 1.500.000 |
| Maya | MGR01 | Manajer | 3 hari | Luar Kota | Tiket Rp 1.800.000 |
| Fajar | STF01 | Staf | 5 hari | Luar Kota | Tiket Rp 1.200.000 |
| Nadia | STF02 | Staf | 2 hari | Dalam Kota | Rp 150.000 |

## Contoh Output

```
=======================================
LAPORAN REIMBURSEMENT PERJALANAN DINAS
=======================================
Nama Karyawan   : Bayu
ID              : DIR01
Jabatan         : Direktur
Lama Dinas      : 4 hari
Tujuan          : Luar Kota
Uang Saku       : Rp 2.000.000
Penginapan      : Rp 3.600.000
Transport + Sewa Mobil : Rp 4.500.000
Total Reimburse : Rp 10.100.000
---------------------------------------
Nama Karyawan   : Maya
ID              : MGR01
Jabatan         : Manajer
Lama Dinas      : 3 hari
Tujuan          : Luar Kota
Uang Saku       : Rp 1.050.000
Penginapan      : Rp 1.600.000
Biaya Transport : Rp 1.800.000
Total Reimburse : Rp 4.450.000
---------------------------------------
Nama Karyawan   : Fajar
ID              : STF01
Jabatan         : Staf
Lama Dinas      : 5 hari
Tujuan          : Luar Kota
Uang Saku       : Rp 1.000.000
Penginapan      : Rp 1.600.000
Biaya Transport : Rp 1.200.000
Total Reimburse : Rp 3.800.000
---------------------------------------
Nama Karyawan   : Nadia
ID              : STF02
Jabatan         : Staf
Lama Dinas      : 2 hari
Tujuan          : Dalam Kota
Uang Saku       : Rp 400.000
Penginapan      : Rp 0 (tidak menginap)
Biaya Transport : Rp 150.000
Total Reimburse : Rp 550.000
=======================================
TOTAL SELURUHNYA : Rp 18.900.000
=======================================
```
