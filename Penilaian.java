public class Penilaian {
        
    Mahasiswa mahasiswa;
    MataKuliah mataKuliah;

    double nilaiTugas, nilaiUTS, nilaiUAS, nilaiAkhir;

    public Penilaian(Mahasiswa mahasiswa, MataKuliah mataKuliah, double tugas, double uts, double uas) {
        this.mahasiswa = mahasiswa;
        this.mataKuliah = mataKuliah;
        this.nilaiTugas = tugas;
        this.nilaiUTS = uts;
        this.nilaiUAS = uas;
    }

    void hitungNilaiAkhir() {
        this.nilaiAkhir = 0.3 * nilaiTugas + 0.3 * nilaiUTS + 0.4 * nilaiUAS;
    }
}
