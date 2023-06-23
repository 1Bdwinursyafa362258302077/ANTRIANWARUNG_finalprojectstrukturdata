import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Studikasus2 {

    private static ArrayList<String> menuItems = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        // Inisialisasi menu makanan
        menuItems.add("Nasi Ayam (Chicken Rice)");
        menuItems.add("Mie Sapi (Beef Noodles)");
        menuItems.add("Kari Kambing (Lamb Curry)");
        menuItems.add("Tumis Sayuran (Vegetable Stir-Fry)");

        // Tampilan menu
        System.out.println("Selamat datang di warung kami! Berikut adalah menu kami:");
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.println((i + 1) + " " + menuItems.get(i));//mendapatkan index ke-i
        }

        // Ambil pesanan pengguna
        System.out.println("Apa yang ingin Anda pesan? (Masukkan nomor pesanan)");
        int orderNumber = scanner.nextInt();
        scanner.nextLine(); // Membersihkan newline character

        // Validasi nomor pesanan yang valid
        if (orderNumber < 1 || orderNumber > menuItems.size()) {
            System.out.println("Nomor pesanan tidak valid. Silakan coba lagi.");
            return;
        }

        // Ambil pesanan berdasarkan nomor urutan dan index array  mulai 0
        String order = menuItems.get(orderNumber - 1);

        // Jika pesanan ditemukan, tampilkan konfirmasi pesanan
        System.out.println("Pesanan Anda: " + order);
        System.out.println("Pesanan Anda telah dikonfirmasi. Terima kasih!");

        // Tambahkan pesanan ke antrian
        Queue<String> orderQueue = new LinkedList<>();
        orderQueue.add(order);

        // memeriksa Proses pesanan dalam antrian dan  mengambil pesanan
        while (!orderQueue.isEmpty()) {
            String currentOrder = orderQueue.poll(); 

            // Persiapkan pesanan
            System.out.println("Menyiapkan pesanan Anda...");

            // Masak pesanan
            System.out.println("Memasak pesanan Anda...");

            // Sajikan pesanan
            System.out.println("Pesanan Anda siap! Selamat menikmati!");
        }

        // Terima kasih kepada pengguna atas pesanannya
        System.out.println("Terima kasih atas pesanan Anda! Kami harap Anda menikmati makanan Anda.");
    }
}
