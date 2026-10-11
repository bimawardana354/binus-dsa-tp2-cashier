# Sistem Kasir Toko — Queue dan Stack

Program Java ini mensimulasikan sistem kasir toko menggunakan dua struktur data:
`Queue` (FIFO) untuk antrian pelanggan dan `Stack` (LIFO) untuk riwayat transaksi.
Pelanggan ditambahkan ke antrian, dilayani satu per satu dari depan, lalu transaksi
yang selesai disimpan ke riwayat dengan yang terbaru berada di atas.

## Struktur Data

1. `Node` menyimpan data satu pelanggan: kode (nomor antrian), nama, dan total belanja.
2. `Queue` (FIFO) mengatur antrian pelanggan lewat `enqueue` dan `dequeue`.
3. `Stack` (LIFO) menyimpan riwayat transaksi lewat `push`.

## Menu Program

1. **Tambah Antrian** — menambah pelanggan ke belakang antrian (`enqueue`) dengan validasi input.
2. **Layani Pelanggan** — mengambil pelanggan terdepan (`dequeue`) lalu menyimpannya ke riwayat (`push`).
3. **Tampilkan Antrian** — menampilkan antrian dari depan ke belakang.
4. **Lihat Riwayat Transaksi** — menampilkan riwayat dari transaksi terbaru ke terlama.
5. **Keluar** — menghentikan program.

## Cara Menjalankan

```bash
javac KasirToko.java
java KasirToko
```

## Output Program

```text
bwrdn@bima MINGW64 /d/Bima Folder/S1-Binus-University/binus-dsa-personal-assignment-2
$ javac KasirToko.java

bwrdn@bima MINGW64 /d/Bima Folder/S1-Binus-University/binus-dsa-personal-assignment-2
$ java KasirToko.java

=== SISTEM KASIR TOKO ===
1. Tambah Antrian
2. Layani Pelanggan
3. Tampilkan Antrian
4. Lihat Riwayat Transaksi
5. Keluar
Pilih menu: 1

Masukkan Nomor Antrian: A1
Masukkan Nama Pelanggan: Budi
Masukkan Total Belanja: 200000
Data pelanggan ditambahkan ke antrian!

=== SISTEM KASIR TOKO ===
1. Tambah Antrian
2. Layani Pelanggan
3. Tampilkan Antrian
4. Lihat Riwayat Transaksi
5. Keluar
Pilih menu: 1

Masukkan Nomor Antrian: A2
Masukkan Nama Pelanggan: Lina
Masukkan Total Belanja: 50000
Data pelanggan ditambahkan ke antrian!

=== SISTEM KASIR TOKO ===
1. Tambah Antrian
2. Layani Pelanggan
3. Tampilkan Antrian
4. Lihat Riwayat Transaksi
5. Keluar
Pilih menu: 1

Masukkan Nomor Antrian: A3
Masukkan Nama Pelanggan: Arvin
Masukkan Total Belanja: 2000000
Data pelanggan ditambahkan ke antrian!

=== SISTEM KASIR TOKO ===
1. Tambah Antrian
2. Layani Pelanggan
3. Tampilkan Antrian
4. Lihat Riwayat Transaksi
5. Keluar
Pilih menu: 1

Masukkan Nomor Antrian: A4
Masukkan Nama Pelanggan: Alex
Masukkan Total Belanja: 5000000
Data pelanggan ditambahkan ke antrian!

=== SISTEM KASIR TOKO ===
1. Tambah Antrian
2. Layani Pelanggan
3. Tampilkan Antrian
4. Lihat Riwayat Transaksi
5. Keluar
Pilih menu: 1

Masukkan Nomor Antrian: A5
Masukkan Nama Pelanggan: Gary
Masukkan Total Belanja: 100000
Data pelanggan ditambahkan ke antrian!

=== SISTEM KASIR TOKO ===
1. Tambah Antrian
2. Layani Pelanggan
3. Tampilkan Antrian
4. Lihat Riwayat Transaksi
5. Keluar
Pilih menu: 1 

Masukkan Nomor Antrian: A6
Masukkan Nama Pelanggan: Elina
Masukkan Total Belanja: 500000
Data pelanggan ditambahkan ke antrian!

=== SISTEM KASIR TOKO ===
1. Tambah Antrian
2. Layani Pelanggan
3. Tampilkan Antrian
4. Lihat Riwayat Transaksi
5. Keluar
Pilih menu: 3

Antrian saat ini:
1. A1 | Budi | Rp200000
2. A2 | Lina | Rp50000
3. A3 | Arvin | Rp2000000
4. A4 | Alex | Rp5000000
5. A5 | Gary | Rp100000
6. A6 | Elina | Rp500000
Jumlah antrian: 6

=== SISTEM KASIR TOKO ===
1. Tambah Antrian
2. Layani Pelanggan
3. Tampilkan Antrian
4. Lihat Riwayat Transaksi
5. Keluar
Pilih menu: 2

Melayani pelanggan A1 (Budi)
Transaksi disimpan ke riwayat.

=== SISTEM KASIR TOKO ===
1. Tambah Antrian
2. Layani Pelanggan
3. Tampilkan Antrian
4. Lihat Riwayat Transaksi
5. Keluar
Pilih menu: 3

Antrian saat ini:
1. A2 | Lina | Rp50000
2. A3 | Arvin | Rp2000000
3. A4 | Alex | Rp5000000
4. A5 | Gary | Rp100000
5. A6 | Elina | Rp500000
Jumlah antrian: 5

=== SISTEM KASIR TOKO ===
1. Tambah Antrian
2. Layani Pelanggan
3. Tampilkan Antrian
4. Lihat Riwayat Transaksi
5. Keluar
Pilih menu: 4

Riwayat transaksi (terbaru di atas):
1. A1 | Budi | Rp200000

=== SISTEM KASIR TOKO ===
1. Tambah Antrian
2. Layani Pelanggan
3. Tampilkan Antrian
4. Lihat Riwayat Transaksi
5. Keluar
Pilih menu: 5

Terima kasih, program selesai.
```
