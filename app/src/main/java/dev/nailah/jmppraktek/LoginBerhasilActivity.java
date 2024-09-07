package dev.nailah.jmppraktek;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class LoginBerhasilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_berhasil);

        // Menampilkan pesan login berhasil
        displayLoginSuccessMessage();

        // Mengarahkan ke MainActivity setelah beberapa detik (contoh: 2 detik)
        redirectToMainActivity();
    }

    private void displayLoginSuccessMessage() {
        // Tambahkan kode untuk menampilkan pesan login berhasil di sini
        // Misalnya, menggunakan Toast atau TextView
    }

    private void redirectToMainActivity() {
        new android.os.Handler().postDelayed(
                () -> {
                    Intent intent = new Intent(LoginBerhasilActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                },
                5000 // Waktu delay dalam milidetik (2 detik)
        );
    }
}
