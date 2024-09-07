package dev.nailah.jmppraktek;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnListData = findViewById(R.id.btnListData);
        Button btnDialog = findViewById(R.id.btnDialog);
        Button btnInformasi = findViewById(R.id.btnInformasi);

        btnListData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Arahkan ke DataMahasiswaActivity saat tombol Data Mahasiswa diklik
                startActivity(new Intent(MainActivity.this, DataMahasiswaActivity.class));
            }
        });

        btnDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Arahkan ke InputDataActivity saat tombol Input Data diklik
                startActivity(new Intent(MainActivity.this, InputDataActivity.class));
            }
        });

        btnInformasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Arahkan ke InformasiKampusActivity saat tombol Informasi Kampus diklik
                startActivity(new Intent(MainActivity.this, InformasiKampusActivity.class));
            }
        });
    }
}
