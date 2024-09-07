package dev.nailah.jmppraktek;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;

public class InputDataActivity extends AppCompatActivity {

    private EditText etUsername;
    private EditText etPassword;
    private EditText etEmail;
    private EditText etNamaLengkap;
    private EditText etAsalSekolah;
    private EditText etAlamat;
    private EditText[] ets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_data);

        // Views to object
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setTitle("Register");
        }

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        etEmail = findViewById(R.id.etEmail);
        etNamaLengkap = findViewById(R.id.etNamaLengkap);
        etAsalSekolah = findViewById(R.id.etAsalSekolah);
        etAlamat = findViewById(R.id.etAlamat);

        Button btSimpan = findViewById(R.id.btSimpan);

        ets = new EditText[]{
                etUsername,
                etPassword,
                etEmail,
                etNamaLengkap,
                etAsalSekolah,
                etAlamat
        };

        // Event handler
        btSimpan.setOnClickListener(v -> {
            if (isValidation()) {
                simpanFileData();
            } else {
                Toast.makeText(this, "Mohon Lengkapi Seluruh Data", Toast.LENGTH_SHORT).show();
            }
        });
    }

    boolean isValidation() {
        for (EditText et : ets) {
            if (et.getText().toString().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    void simpanFileData() {
        StringBuilder isiFile = new StringBuilder();
        for (EditText et : ets) {
            isiFile.append(et.getText().toString()).append(";");
        }

        File file = new File(getFilesDir(), etUsername.getText().toString());

        try (FileOutputStream fos = new FileOutputStream(file, false)) {
            fos.write(isiFile.toString().getBytes());
            fos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Toast.makeText(this, "Register Berhasil", Toast.LENGTH_SHORT).show();
        onBackPressed();
    }
}
