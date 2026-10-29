public class Manajer extends Karyawan {
    public Manajer(String nama, String idKaryawan, int lamaDinas, double biayaTransport, boolean luarKota) {
        super(nama, idKaryawan, "Manajer", lamaDinas, biayaTransport, luarKota);
    }

    @Override
    public double hitungUangSaku() {
        return 350000 * getLamaDinas();
    }

    @Override
    public double hitungPenginapan() {
        int malam = getLamaDinas() - 1;
        return (malam > 0 ? malam : 0) * 800000;
    }
}
