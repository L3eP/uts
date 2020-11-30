package com.j4nu5.maticatalog;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;
import com.j4nu5.maticatalog.model.Matic;

public class GaleriActivity extends AppCompatActivity {

    List<Matic> matics;
    int indeksTampil = 0;
    String jenisMatic;
    Button btnPertama,btnTerakhir,btnSebelumnya,btnBerikutnya;
    TextView txRas,txAsal,txDeskripsi,txJudul;
    ImageView ivFotoHewan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil_ras);
        Intent intent = getIntent();
        jenisMatic = intent.getStringExtra(MainActivity.JENIS_GALERI_KEY);
        matics = DataProvider.getHewansByTipe(this,jenisMatic);
        inisialisasiView();
        tampilkanProfil();
    }

    private void inisialisasiView() {
        btnPertama = findViewById(R.id.btnPertama);
        btnSebelumnya = findViewById(R.id.btnSebelumnya);
        btnBerikutnya = findViewById(R.id.btnBerikutnya);
        btnTerakhir = findViewById(R.id.btnTerakhir);

        btnPertama.setOnClickListener(view -> hewanPertama());
        btnTerakhir.setOnClickListener(view -> hewanTerakhir());
        btnSebelumnya.setOnClickListener(view -> hewanSebelumnya());
        btnBerikutnya.setOnClickListener(view -> hewanBerikutnya());

        txRas = findViewById(R.id.txRas);
        txAsal = findViewById(R.id.txAsal);
        txDeskripsi = findViewById(R.id.txDeskripsi);
        ivFotoHewan = findViewById(R.id.gambarMatic);

        txJudul = findViewById(R.id.txJudul);
        txJudul.setText("Berbagai Macam Jenis "+jenisMatic);
    }


    private void tampilkanProfil() {
        Matic k = matics.get(indeksTampil);
        Log.d("VESPA","Menampilkan vespa "+k.getRas());
        txRas.setText(k.getRas());
        txAsal.setText(k.getAsal());
        txDeskripsi.setText(k.getDeskripsi());
        ivFotoHewan.setImageDrawable(this.getDrawable(k.getDrawableRes()));
    }

    private void hewanPertama() {
        int posAwal = 0;
        if (indeksTampil == posAwal) {
            Toast.makeText(this,"Sudah di posisi pertama",Toast.LENGTH_SHORT).show();
            return;
        } else {
            indeksTampil = posAwal;
            tampilkanProfil();
        }
    }

    private void hewanTerakhir() {
        int posAkhir = matics.size() - 1;
        if (indeksTampil == posAkhir) {
            Toast.makeText(this,"Sudah di posisi terakhir",Toast.LENGTH_SHORT).show();
            return;
        } else {
            indeksTampil = posAkhir;
            tampilkanProfil();
        }
    }

    private void hewanBerikutnya() {
        if (indeksTampil == matics.size() - 1) {
            Toast.makeText(this,"Sudah di posisi terakhir",Toast.LENGTH_SHORT).show();
            return;
        } else {
            indeksTampil++;
            tampilkanProfil();
        }
    }

    private void hewanSebelumnya() {
        if (indeksTampil == 0) {
            Toast.makeText(this,"Sudah di posisi pertama",Toast.LENGTH_SHORT).show();
            return;
        } else {
            indeksTampil--;
            tampilkanProfil();
        }
    }
}