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

	public static void sorting(Penilaian[] data) {
		for (int i = 0; i < data.length - 1; i++) {
			for (int j = 1; j < data.length - i; j++) {
				data[j-1].hitungNilaiAkhir();
				data[j].hitungNilaiAkhir();
				if (data[j-1].nilaiAkhir < data[j].nilaiAkhir) {
					Penilaian temp = data[j];
					data[j] = data[j-1];
					data[j-1] = temp;
				}
			}
		}
		for (Penilaian penilaian : data) {
			penilaian.hitungNilaiAkhir();
			System.out.println(penilaian.mahasiswa.nama + " | " + penilaian.mataKuliah.namaMK + " | " + penilaian.nilaiAkhir);
		}
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
					System.out.println("\nDaftar Mahasiswa:");
						for (Mahasiswa mhs : daftarMahasiswa) {
						System.out.println("NIM: " + mhs.nim + " | Nama: " + mhs.nama + " | Prodi: " + mhs.prodi);
						}
					System.out.println();
					break;
				case 2:
					System.out.println("\nDaftar Mata Kuliah:");
						for (MataKuliah mk : daftarMataKuliah) {
						System.out.println("Kode MK: " + mk.kodeMK + " | Nama: " + mk.namaMK + " | SKS: " + mk.sks);
						}
					System.out.println();
					break;
				case 3:
					System.out.println("\nData Penilaian");
					for (Penilaian penilaian : daftarPenilaian) {
						penilaian.hitungNilaiAkhir();
						System.out.println(penilaian.mahasiswa.nama + " | " + penilaian.mataKuliah.namaMK + " | " + penilaian.nilaiAkhir);
					}
					System.out.println();
					break;
				case 4:
					System.out.println("\nData Penilaian");
					sorting(daftarPenilaian);
					System.out.println();
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