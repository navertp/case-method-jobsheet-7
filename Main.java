import java.util.Scanner;

public class Main {

	public static Scanner input = new Scanner(System.in);

	public static void searchBerdasarkanNim(Mahasiswa[] daftarMahasiswa, String nim) {
		for (int i = 0; i < daftarMahasiswa.length; i++) {
			if (daftarMahasiswa[i].nim.equals(nim)) {
				System.out.println("Mahasiswa Ditemukan: NIM: " + daftarMahasiswa[i].nim + " | Nama: " + daftarMahasiswa[i].nama + " | Prodi: " + daftarMahasiswa[i].prodi);
				break;
			}
			if (i == daftarMahasiswa.length - 1) {
				System.err.println("Mahasiswa dengan NIM " + nim + " tidak ditemukan");
			}
		}
	}

	public static int menu() {
		System.out.println("=== MENU SISTEM AKADEMIK ===");
		System.out.println("1. Tampilkan Daftar Mahasiswa");
		System.out.println("2. Tampilkan Daftar Mata Kuliah");
		System.out.println("3. Tampilkan Data Penilaian");
		System.out.println("4. Urutkan Mahasiswa Berdasarkan Nilai Akhir");
		System.out.println("5. Cari Mahasiswa Berdasarkan NIM");
		System.out.println("0. Keluar");
		System.err.print("Pilih Menu: ");
		return input.nextInt();
	}

	public static void main(String[] args) {
		Mahasiswa[] daftarMahasiswa = new Mahasiswa[3];
		daftarMahasiswa[0] = new Mahasiswa("22001", "Ali Rahman", "Informatika");
		daftarMahasiswa[1] = new Mahasiswa("22002", "Budi Santoso", "Informatika");
		daftarMahasiswa[2] = new Mahasiswa("22003", "Citra Dewi", "Sistem Informasi Bisnis");

		MataKuliah[] daftarMataKuliah = new MataKuliah[3];
		daftarMataKuliah[0] = new MataKuliah("MK001", "Struktur Data", 3);
		daftarMataKuliah[1] = new MataKuliah("MK002", "Basis Data", 3);
		daftarMataKuliah[2] = new MataKuliah("MK003", "Desain Web", 3);

		Penilaian[] daftarPenilaian = new Penilaian[5];
		daftarPenilaian[0] = new Penilaian(daftarMahasiswa[0], daftarMataKuliah[0], 80, 85, 90);
		daftarPenilaian[1] = new Penilaian(daftarMahasiswa[0], daftarMataKuliah[1], 60, 75, 70);
		daftarPenilaian[2] = new Penilaian(daftarMahasiswa[1], daftarMataKuliah[0], 75, 70, 80);
		daftarPenilaian[3] = new Penilaian(daftarMahasiswa[2], daftarMataKuliah[1], 85, 90, 95);
		daftarPenilaian[4] = new Penilaian(daftarMahasiswa[2], daftarMataKuliah[2], 80, 90, 65);

		boolean run = true;
		while (run) {
			int menu = menu();
			switch (menu) {
				case 0:
					run = false;
					break;
				case 1:
					System.out.println("Daftar Mahasiswa:");
					break;
				case 5:
					System.out.print("Masukkan NIM mahasiswa yang dicari: ");
					String nim = input.next();
					searchBerdasarkanNim(daftarMahasiswa, nim);
					break;
				default:
					System.err.println("Menu Tidak Tersedia");
					break;
			}
		}
	}
}