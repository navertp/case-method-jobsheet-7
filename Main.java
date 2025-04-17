import java.util.Scanner;

public class Main {

	public static Scanner input = new Scanner(System.in);

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
				default:
					System.err.println("Menu Tidak Tersedia");
					break;
			}
		}
	}
}