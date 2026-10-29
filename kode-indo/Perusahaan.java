import java.util.ArrayList;

public class Perusahaan {
    private String namaPerusahaan;
    private ArrayList<Karyawan> daftarKaryawan;

    public Perusahaan(String namaPerusahaan) {
        this.namaPerusahaan = namaPerusahaan;
        this.daftarKaryawan = new ArrayList<>();
    }

    public String getNamaPerusahaan() {
        return namaPerusahaan;
    }

    public void tambahKaryawan(Karyawan karyawan) {
        daftarKaryawan.add(karyawan);
    }

    // Format nilai rupiah: 6000000 -> "Rp 6.000.000"
    private String formatRupiah(double nilai) {
        long bulat = Math.round(nilai);
        String digit = String.valueOf(Math.abs(bulat));
        StringBuilder hasil = new StringBuilder();
        for (int i = 0; i < digit.length(); i++) {
            if (i > 0 && (digit.length() - i) % 3 == 0) {
                hasil.append('.');
            }
            hasil.append(digit.charAt(i));
        }
        return (bulat < 0 ? "-Rp " : "Rp ") + hasil;
    }

    // Cetak satu baris laporan: label dilebarkan minimal 15 karakter agar titik dua sejajar
    private void cetak(String label, String isi) {
        System.out.printf("%-15s : %s%n", label, isi);
    }

    // Looping dan cetak laporan semua karyawan, lalu total seluruh reimbursement
    public void hitungSemuaBiaya() {
        String garisAtas = "=======================================";
        String garisPemisah = "---------------------------------------";
        double totalSeluruhnya = 0;

        System.out.println(garisAtas);
        System.out.println("LAPORAN REIMBURSEMENT PERJALANAN DINAS");
        System.out.println(garisAtas);

        for (int i = 0; i < daftarKaryawan.size(); i++) {
            Karyawan k = daftarKaryawan.get(i);
            boolean luarKota = k.isLuarKota();
            double total = k.hitungTotalBiaya(luarKota);
            totalSeluruhnya += total;

            cetak("Nama Karyawan", k.getNama());
            cetak("ID", k.getIdKaryawan());
            cetak("Jabatan", k.getJabatan());
            cetak("Lama Dinas", k.getLamaDinas() + " hari");
            cetak("Tujuan", luarKota ? "Luar Kota" : "Dalam Kota");
            cetak("Uang Saku", formatRupiah(k.hitungUangSaku()));

            if (luarKota) {
                cetak("Penginapan", formatRupiah(k.hitungPenginapan()));
            } else {
                cetak("Penginapan", "Rp 0 (tidak menginap)");
            }

            // Label dan nilai transport ditentukan oleh method milik masing-masing subclass
            cetak(k.getLabelTransport(), formatRupiah(k.hitungBiayaTransport()));

            cetak("Total Reimburse", formatRupiah(total));

            if (i < daftarKaryawan.size() - 1) {
                System.out.println(garisPemisah);
            }
        }
        System.out.println(garisAtas);
        cetak("TOTAL SELURUHNYA", formatRupiah(totalSeluruhnya));
        System.out.println(garisAtas);
    }
}
