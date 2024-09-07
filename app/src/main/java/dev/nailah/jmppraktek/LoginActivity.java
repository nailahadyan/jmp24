package dev.nailah.jmppraktek;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class LoginActivity extends AppCompatActivity {
    public static final String FILENAME = "login";
    private EditText etUsername;
    private EditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = findViewById(R.id.username);
        etPassword = findViewById(R.id.etPassword);
        Button btLogin = findViewById(R.id.btLogin);
        Button btRegister = findViewById(R.id.btRegister);

        btLogin.setOnClickListener(v -> login());

        btRegister.setOnClickListener(v -> {
            // Implement register button functionality here
            Toast.makeText(LoginActivity.this, "Implementasi register belum dilakukan", Toast.LENGTH_SHORT).show();
        });
    }

    void simpanFileLogin() {
        String isiFile = etUsername.getText().toString() + ";" + etPassword.getText().toString();
        File file = new File(getFilesDir(), FILENAME);

        try (FileOutputStream fos = new FileOutputStream(file, false)) {
            fos.write(isiFile.getBytes());
            fos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Toast.makeText(this, "Login Berhasil, Selamat datang di KampusKU", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    void login() {
        File file = new File(getFilesDir(), FILENAME);

        if (file.exists()) {
            StringBuilder text = new StringBuilder();
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {
                    text.append(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            String data = text.toString();
            String[] dataUser = data.split(";");

            // Username dan password yang ditetapkan secara statis
            String usernameStatic = "admin";
            String passwordStatic = "admin123";

            if (etUsername.getText().toString().equals(usernameStatic) &&
                    etPassword.getText().toString().equals(passwordStatic)) {
                simpanFileLogin();
            } else {
                Toast.makeText(this, "Username atau Password Tidak Sesuai", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "User Tidak Ditemukan", Toast.LENGTH_SHORT).show();
        }
    }
}