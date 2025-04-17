public class MataKuliah {
    String kodeMK;
    String namaMK;
    int sks;

    public MataKuliah(String kodeMK, String namaMK, int sks) {
        this.kodeMK = kodeMK;
        this.namaMK = namaMK;
        this.sks = sks;
    }

    public void tampilMataKuliah() {
        System.out.println("Kode Mata Kuliah : " + kodeMK);
        System.out.println("Nama Mata Kuliah : " + namaMK);
        System.out.println("SKS : " + sks);
    }
}
