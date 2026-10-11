import java.util.Scanner;
 
// Node menyimpan data pelanggan: kode (nomor antrian), nama, dan total belanja
class Node {
    String kode;
    String nama;
    long total;
    Node next;
 
    Node(String kode, String nama, long total) {
        this.kode = kode;
        this.nama = nama;
        this.total = total;
        this.next = null;
    }
}
 
// Queue (FIFO) untuk antrian pelanggan
class Queue {
    static final int MINIMAL = 5; // jumlah pelanggan minimal di antrian
    Node front;
    Node rear;
    int size;
 
    boolean isEmpty() {
        return front == null;
    }
 
    // Enqueue: menambah pelanggan di belakang antrian
    void enqueue(String kode, String nama, long total) {
        Node baru = new Node(kode, nama, total);
        if (isEmpty()) {
            front = baru;
        } else {
            rear.next = baru;
        }
        rear = baru;
        size++;
    }
 
    // Dequeue: mengambil pelanggan paling depan, null jika antrian kosong
    Node dequeue() {
        if (isEmpty()) {
            return null;
        }
        Node keluar = front;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        keluar.next = null;
        size--;
        return keluar;
    }
 
    // Menampilkan antrian dari depan ke belakang
    void tampilkan() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
            return;
        }
        System.out.println("Antrian saat ini:");
        Node bantu = front;
        int no = 1;
        while (bantu != null) {
            System.out.println(no + ". " + bantu.kode + " | " + bantu.nama
                    + " | Rp" + bantu.total);
            bantu = bantu.next;
            no++;
        }
        System.out.println("Jumlah antrian: " + size);
        // Validasi: antrian minimal 5 pelanggan (hanya peringatan)
        if (size < MINIMAL) {
            System.out.println("Catatan: antrian minimal " + MINIMAL
                    + " pelanggan, saat ini baru ada " + size + ".");
        }
    }
}
 
// Stack (LIFO) untuk riwayat transaksi
class Stack {
    Node top;
 
    boolean isEmpty() {
        return top == null;
    }
 
    // Push: menyimpan transaksi baru di atas stack
    void push(String kode, String nama, long total) {
        Node baru = new Node(kode, nama, total);
        baru.next = top;
        top = baru;
    }
 
    // Menampilkan riwayat dari transaksi terbaru ke terlama
    void tampilkan() {
        if (isEmpty()) {
            System.out.println("Belum ada riwayat transaksi.");
            return;
        }
        System.out.println("Riwayat transaksi (terbaru di atas):");
        Node bantu = top;
        int no = 1;
        while (bantu != null) {
            System.out.println(no + ". " + bantu.kode + " | " + bantu.nama
                    + " | Rp" + bantu.total);
            bantu = bantu.next;
            no++;
        }
    }
}
 
public class KasirToko {
    static Scanner input = new Scanner(System.in);
    static Queue antrian = new Queue();
    static Stack riwayat = new Stack();
 
    // Menu 1: tambah pelanggan ke antrian (enqueue) dengan validasi
    static void tambahAntrian() {
        System.out.print("Masukkan Nomor Antrian: ");
        String kode = input.nextLine().trim();
        if (kode.length() == 0) {
            System.out.println("Nomor antrian tidak boleh kosong.");
            return;
        }
        System.out.print("Masukkan Nama Pelanggan: ");
        String nama = input.nextLine().trim();
        if (nama.length() == 0) {
            System.out.println("Nama pelanggan tidak boleh kosong.");
            return;
        }
        System.out.print("Masukkan Total Belanja: ");
        long total;
        try {
            total = Long.parseLong(input.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Total belanja harus berupa angka.");
            return;
        }
        if (total <= 0) {
            System.out.println("Total belanja harus lebih dari 0.");
            return;
        }
        antrian.enqueue(kode, nama, total);
        System.out.println("Data pelanggan ditambahkan ke antrian!");
    }
 
    // Menu 2: layani pelanggan (dequeue lalu push ke stack riwayat)
    static void layaniPelanggan() {
        Node pelanggan = antrian.dequeue();
        if (pelanggan == null) {
            System.out.println("Tidak ada pelanggan dalam antrian.");
            return;
        }
        System.out.println("Melayani pelanggan " + pelanggan.kode
                + " (" + pelanggan.nama + ")");
        riwayat.push(pelanggan.kode, pelanggan.nama, pelanggan.total);
        System.out.println("Transaksi disimpan ke riwayat.");
    }
 
    public static void main(String[] args) {
        boolean jalan = true;
 
        while (jalan) {
            System.out.println();
            System.out.println("=== SISTEM KASIR TOKO ===");
            System.out.println("1. Tambah Antrian");
            System.out.println("2. Layani Pelanggan");
            System.out.println("3. Tampilkan Antrian");
            System.out.println("4. Lihat Riwayat Transaksi");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            String pilihan = input.nextLine().trim();
            System.out.println();
 
            switch (pilihan) {
                case "1":
                    tambahAntrian();
                    break;
                case "2":
                    layaniPelanggan();
                    break;
                case "3":
                    antrian.tampilkan();
                    break;
                case "4":
                    riwayat.tampilkan();
                    break;
                case "5":
                    System.out.println("Terima kasih, program selesai.");
                    jalan = false;
                    break;
                default:
                    System.out.println("Menu tidak valid, pilih 1-5.");
            }
        }
        input.close();
    }
}
