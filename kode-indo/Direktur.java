public class Direktur extends Karyawan {
    private double biayaSewaMobil;

    public Direktur(String nama, String idKaryawan, int lamaDinas, double biayaTransport,
                    double biayaSewaMobil, boolean luarKota) {
        super(nama, idKaryawan, "Direktur", lamaDinas, biayaTransport, luarKota);
        this.biayaSewaMobil = biayaSewaMobil;
    }

    public double getBiayaSewaMobil() {
        return biayaSewaMobil;
    }

    public void setBiayaSewaMobil(double biayaSewaMobil) {
        this.biayaSewaMobil = biayaSewaMobil;
    }

    // Transport Direktur = tiket + sewa mobil (memakai overloading di superclass)
    @Override
    public double hitungBiayaTransport() {
        return hitungBiayaTransport(biayaSewaMobil);
    }

    @Override
    public String getLabelTransport() {
        return "Transport + Sewa Mobil";
    }

    @Override
    public double hitungUangSaku() {
        return 500000 * getLamaDinas();
    }

    @Override
    public double hitungPenginapan() {
        int malam = getLamaDinas() - 1;
        return (malam > 0 ? malam : 0) * 1200000;
    }
}
