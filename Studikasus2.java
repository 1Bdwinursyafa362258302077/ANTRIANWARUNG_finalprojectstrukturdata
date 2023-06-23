import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Studikasus2 {

    private static ArrayList<String> menuItems = new ArrayList<>();
    private static ArrayList<Integer> menuPrices = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        // Inisialisasi menu makanan
        menuItems.add("Nasi Ayam (Chicken Rice)");
        menuItems.add("Mie Sapi (Beef Noodles)");
        menuItems.add("Kari Kambing (Lamb Curry)");
        menuItems.add("Tumis Sayuran (Vegetable Stir-Fry)");

        // Inisialisasi harga makanan
        menuPrices.add(15000);
        menuPrices.add(20000);
        menuPrices.add(25000);
        menuPrices.add(12000);

        // Tampilan menu
        System.out.println("Selamat datang di warung kami! Berikut adalah menu kami:");
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.println((i + 1) + ". " + menuItems.get(i) + " - Rp" + menuPrices.get(i));//mendapatkan index ke-i
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

        // Ambil pesanan berdasarkan nomor urutan dan index array mulai 0
        String order = menuItems.get(orderNumber - 1);
        int orderPrice = menuPrices.get(orderNumber - 1);

        // Jika pesanan ditemukan, tampilkan konfirmasi pesanan
        System.out.println("Pesanan Anda: " + order + " - Rp" + orderPrice);
        System.out.println("Pesanan Anda telah dikonfirmasi. Terima kasih!");

        // Tambahkan pesanan ke antrian
        Queue<String> orderQueue = new LinkedList<>();
        orderQueue.add(order);

        // Memeriksa dan memproses pesanan dalam antrian
        while (!orderQueue.isEmpty()) {
            String currentOrder = orderQueue.poll();

            // Persiapkan pesanan
            System.out.println("Menyiapkan pesanan Anda...");

            // Simulasi waktu persiapan
            simulateProcessingTime(3000);

            // Masak pesanan
            System.out.println("Memasak pesanan Anda...");

            // Simulasi waktu memasak
            simulateProcessingTime(5000);

            // Sajikan pesanan
            System.out.println("Pesanan Anda siap! Selamat menikmati!");

            // Tanya apakah pengguna ingin menambah pesanan
            System.out.println("Apakah Anda ingin menambah pesanan? (Ya/Tidak)");
            String addMoreOrder = scanner.nextLine();

            if (addMoreOrder.equalsIgnoreCase("Ya")) {
                // Tampilkan menu untuk pesanan tambahan
                System.out.println("Berikut adalah menu kami:");
                for (int i = 0; i < menuItems.size(); i++) {
                    System.out.println((i + 1) + ". " + menuItems.get(i) + " - Rp" + menuPrices.get(i));
                }

                // Ambil pesanan tambahan dari pengguna
                System.out.println("Apa yang ingin Anda pesan? (Masukkan nomor pesanan)");
                int additionalOrderNumber = scanner.nextInt();
                scanner.nextLine(); // Membersihkan newline character

                // Validasi nomor pesanan tambahan yang valid
                if (additionalOrderNumber < 1 || additionalOrderNumber > menuItems.size()) {
                    System.out.println("Nomor pesanan tidak valid. Pesanan tambahan tidak akan ditambahkan.");
                } else {
                    // Ambil pesanan tambahan berdasarkan nomor urutan dan index array mulai 0
                    String additionalOrder = menuItems.get(additionalOrderNumber - 1);
                    int additionalOrderPrice = menuPrices.get(additionalOrderNumber - 1);
                    orderQueue.add(additionalOrder);
                    System.out.println("Pesanan tambahan Anda (" + additionalOrder + " - Rp" + additionalOrderPrice + ") telah ditambahkan.");
                }
            }
        }

        // Terima kasih kepada pengguna atas pesanannya
        System.out.println("Terima kasih atas pesanan Anda! Kami harap Anda menikmati makanan Anda.");
    }

    private static void simulateProcessingTime(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
