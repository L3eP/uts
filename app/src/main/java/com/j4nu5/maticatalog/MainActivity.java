package com.j4nu5.maticatalog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton btnVespa,btnYamaha,btnSuzuki;
    public static final String JENIS_GALERI_KEY = "JENIS_GALERI";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inisialisasiView();

    }

    private void inisialisasiView() {
        btnVespa = findViewById(R.id.btn_buka_motor_vespa);
        btnYamaha = findViewById(R.id.btn_buka_motor_yamaha);
        btnSuzuki = findViewById(R.id.btn_buka_motor_suzuki);
        btnVespa.setOnClickListener(view -> bukaGaleri("Vespa"));
        btnYamaha.setOnClickListener(view -> bukaGaleri("Yamaha"));
        btnSuzuki.setOnClickListener(view -> bukaGaleri("Suzuki"));
    }

    private void bukaGaleri(String jenisMatic) {
        Log.d("MAIN","Buka activity vespa");
        Intent intent = new Intent(this, GaleriActivity.class);
        intent.putExtra(JENIS_GALERI_KEY, jenisMatic);
        startActivity(intent);
    }

}