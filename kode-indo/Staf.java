public class Staf extends Karyawan {
    public Staf(String nama, String idKaryawan, int lamaDinas, double biayaTransport, boolean luarKota) {
        super(nama, idKaryawan, "Staf", lamaDinas, biayaTransport, luarKota);
    }

    @Override
    public double hitungUangSaku() {
        return 200000 * getLamaDinas();
    }

    @Override
    public double hitungPenginapan() {
        int malam = getLamaDinas() - 1;
        return (malam > 0 ? malam : 0) * 400000;
    }
}
