package com.packagee.tugasuasakb;

/*
    Tanggal pengerjaan  : 8/11/2020
    NIM                 : 10117267
    Nama                : Ichsan Nugraha
    Kelas               : IF - 8
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "twisata.db";
    private static final int DATABASE_VERSION = 1;
    public DataHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        addDataWisata(db);

    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
        // TODO Auto-generated method stub

    }

    private void addDataWisata(SQLiteDatabase db){
        String sql = "create table tempatwisata(no integer primary key, nama text null, deskripsi text null, v text null, v1 text null, gambar text null);";
        Log.d("Data", "onCreate: " + sql);
        db.execSQL(sql);
        sql = "INSERT INTO tempatwisata (no, nama, deskripsi, v, v1, gambar) VALUES ('1', 'Tafso Barn', 'Cafe seru lainnya untuk bersantai bersama keluarga di Bandung adalah Tafso Barn. Kafe ini terletak di Pagerwangi, Lembang, Bandung. Dengan pemandang khas Lembang, yaitu hamparan hijau dari ketinggian, tentu membuat suasana menjadi menenangkan. Konsep yang digunakan kafe Tafso Barn adalah tempat makan dengan bentuk sangkar dari tenda plastik bening. Wah, seru, ya! Harga makanannya mulai dari Rp20.000 – Rp78.000', '-6.8428014', '107.6208043', 'tafso_barn');";
        db.execSQL(sql);
        sql = "INSERT INTO tempatwisata (no, nama, deskripsi, v, v1, gambar) VALUES ('2', 'Glamping Lakeside Rancabali', 'Bagi kamu yang ingin keluar dari ingar bingar kota dan lebih suka menikmati alam indah Bandung, berkemah di Glamping Lakeside Rancabali merupakan alternatif liburan yang sangat menyenangkan dan dapat memberi pengalaman baru untukmu.\n\nBerbeda dengan camping normal yang biasanya tidak “cantik”, di Glamping Lakeside kamu akan melakukan aktivitas glamping yang menyatu dengan alam tetapi tetap nyaman dan bersih.\n\nUntuk berkemah, tersedia tenda atau resort yang bisa dipilih tergantung keinginan dan kebutuhanmu saja.\n\nTak hanya untuk glamping, jika kamu tidak ingin menginap tetap terdapat banyak wahana yang bisa dinikmati seperti mengitari danau dengan perahu, menikmati pemandangan dan berfoto-foto di Teras Bintang, dan bermain seluncuran di Golesat Circuit.', '-7.1575444', '107.3629825', 'glamping_lakeside');";
        db.execSQL(sql);
        sql = "INSERT INTO tempatwisata (no, nama, deskripsi, v, v1, gambar) VALUES ('3', 'Dusun Bambu', 'Di Dusun Bambu, kamu bisa menikmati pengalaman menginap yang sangat nyaman dan asri, dengan desain bangunan yang mencampurkan alam dengan modernitas.\n\nTerdapat dua jenis penginapan: kamar biasa atau dalam tenda untuk glamping. Namun, jika tidak ingin menginap pun terdapat kafe atau restoran seperti saungnya yang menawarkan pengalaman makan unik di saung yang mengelilingi danau. \n\nDusun Bambu juga bisa digunakan untuk berbagai macam acara, lho. Jadi, jika kamu ingin berlibur bersama keluarga besar dan mengadakan semacam gathering, Dusun Bambu bisa jadi pilihan tempat yang menarik. ', '-6.7894709', '107.5766398', 'dusun_bambu');";
        db.execSQL(sql);
        sql = "INSERT INTO tempatwisata (no, nama, deskripsi, v, v1, gambar) VALUES ('4', 'Farm House Susu Lembang', 'Salah satu tempat wisata Bandung yang hits sejak dulu adalah Farmhouse Lembang. Selain memiliki banyak spot foto yang instagramable untuk kamera-mu, di Farmhouse Lembang kamu juga bisa berinteraksi dengan berbagai hewan ternak lucu, menikmati taman bunga, dan miniatur kota bergaya Eropa.', '-6.8329663', '107.6035328', 'farmhouse_lembang');";
        db.execSQL(sql);
        sql = "INSERT INTO tempatwisata (no, nama, deskripsi, v, v1, gambar) VALUES ('5', 'Floating Market Lembang', 'Salah satu tempat liburan di Bandung yang wajib dikunjungi adalah Floating Market Lembang.\n\nDi sini, Toppers bisa menikmati kawasan tertata rapi yang dilengkapi berbagai wahana permainan, kuliner yang dijual di atas perahu, dan berbagai spot untuk membidik lensa kamera-mu seperti wahana kota mini dan taman bunga.', '-6.8185574', '107.6157675', 'floating_market');";
        db.execSQL(sql);

    }

}
