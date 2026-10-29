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
        return Math.max(getLamaDinas() - 1, 0) * 800000;
    }
}
