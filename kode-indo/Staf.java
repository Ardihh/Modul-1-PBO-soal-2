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
        return Math.max(getLamaDinas() - 1, 0) * 400000;
    }
}
