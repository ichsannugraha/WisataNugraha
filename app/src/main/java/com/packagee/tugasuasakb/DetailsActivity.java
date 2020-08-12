package com.packagee.tugasuasakb;

/*
    Tanggal pengerjaan  : 8/11/2020
    NIM                 : 10117267
    Nama                : Ichsan Nugraha
    Kelas               : IF - 8
 */

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.squareup.picasso.Picasso;

public class DetailsActivity extends AppCompatActivity implements OnMapReadyCallback {

    GoogleMap map;
    protected Cursor cursor;
    DataHelper dbHelper;

    String nama, deskripsi, v, v1;
    TextView namaTempat, deskripsiTempat;
    ImageView gambarTempat;
    String imageName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        getSupportActionBar().setTitle("Detail Tempat Wisata");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        namaTempat = findViewById(R.id.namaTempat);
        deskripsiTempat = findViewById(R.id.deskripsiTempat);
        gambarTempat = findViewById(R.id.gambarTempat);


        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        dbHelper = new DataHelper(this);
        SQLiteDatabase db =dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM tempatwisata WHERE nama = '" +
                getIntent().getStringExtra("nama") + "'",null);
        if (cursor.getCount()>0)
        {
            cursor.moveToPosition(0);
            //text1.setText(cursor.getString(0).toString());
            namaTempat.setText(cursor.getString(1).toString());
            deskripsiTempat.setText(cursor.getString(2).toString());
            v = cursor.getString(3).toString();
            v1 = cursor.getString(4).toString();
            Context context = gambarTempat.getContext();
            int id = context.getResources().getIdentifier(cursor.getString(5).toString(), "drawable", context.getPackageName());
            gambarTempat.setImageResource(id);
        }



    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        Double latV = Double.parseDouble(v);
        Double latV1 = Double.parseDouble(v1);

        map = googleMap;

        LatLng latLng = new LatLng(latV, latV1);

        map.addMarker(new MarkerOptions().position(latLng).title(nama));
        map.moveCamera(CameraUpdateFactory.newLatLng(latLng));
    }
}
