public class Main {
    public static void main(String[] args) {
        Perusahaan perusahaan = new Perusahaan("PT Mitra Konsultan Prima");

        Karyawan karyawan1 = new Direktur("Bayu", "DIR01", 4, 3000000, 1500000, true);
        Karyawan karyawan2 = new Manajer("Maya", "MGR01", 3, 1800000, true);
        Karyawan karyawan3 = new Staf("Fajar", "STF01", 5, 1200000, true);
        Karyawan karyawan4 = new Staf("Nadia", "STF02", 2, 150000, false);

        perusahaan.tambahKaryawan(karyawan1);
        perusahaan.tambahKaryawan(karyawan2);
        perusahaan.tambahKaryawan(karyawan3);
        perusahaan.tambahKaryawan(karyawan4);

        perusahaan.hitungSemuaBiaya();
    }
}
