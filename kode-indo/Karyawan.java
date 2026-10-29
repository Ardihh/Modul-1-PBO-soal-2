public class Karyawan {
    // Enkapsulasi: semua atribut private, diakses lewat getter/setter
    private String nama;
    private String idKaryawan;
    private String jabatan;
    private int lamaDinas;
    private double biayaTransport;
    private boolean luarKota;

    public Karyawan(String nama, String idKaryawan, String jabatan, int lamaDinas,
                    double biayaTransport, boolean luarKota) {
        this.nama = nama;
        this.idKaryawan = idKaryawan;
        this.jabatan = jabatan;
        this.lamaDinas = lamaDinas;
        this.biayaTransport = biayaTransport;
        this.luarKota = luarKota;
    }

    // ===== Getter & Setter =====
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getIdKaryawan() {
        return idKaryawan;
    }

    public void setIdKaryawan(String idKaryawan) {
        this.idKaryawan = idKaryawan;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public int getLamaDinas() {
        return lamaDinas;
    }

    public void setLamaDinas(int lamaDinas) {
        this.lamaDinas = lamaDinas;
    }

    public double getBiayaTransport() {
        return biayaTransport;
    }

    public void setBiayaTransport(double biayaTransport) {
        this.biayaTransport = biayaTransport;
    }

    public boolean isLuarKota() {
        return luarKota;
    }

    public void setLuarKota(boolean luarKota) {
        this.luarKota = luarKota;
    }

    // ===== Overloading hitungBiayaTransport =====

    // Biaya transport standar (biaya tiket)
    public double hitungBiayaTransport() {
        return biayaTransport;
    }

    // Biaya transport + sewa mobil (hanya dipakai Direktur)
    public double hitungBiayaTransport(double biayaSewaMobil) {
        return biayaTransport + biayaSewaMobil;
    }

    // ===== Method yang di-override oleh subclass (Polimorfisme) =====

    // Uang saku selama dinas. Default 0, di-override subclass
    public double hitungUangSaku() {
        return 0;
    }

    // Biaya penginapan (jumlah malam = lama dinas - 1). Default 0, di-override subclass
    public double hitungPenginapan() {
        return 0;
    }

    // Label baris transport pada laporan. Default "Biaya Transport", di-override Direktur
    public String getLabelTransport() {
        return "Biaya Transport";
    }

    // Total = uang saku + transport + penginapan (hanya jika luar kota)
    public double hitungTotalBiaya(boolean luarKota) {
        double total = hitungUangSaku() + hitungBiayaTransport();
        if (luarKota) {
            total += hitungPenginapan();
        }
        return total;
    }
}
