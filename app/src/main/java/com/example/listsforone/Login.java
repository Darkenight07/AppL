package com.example.listsforone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Login extends AppCompatActivity {

    EditText user;
    EditText password;
    Button InicioSesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        InicioSesion = findViewById(R.id.inicioSesion); // Boton
        user = findViewById(R.id.user); // Caja user
        password = findViewById(R.id.password); // Caja password

        InicioSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user_contenido = user.getText().toString();
                String password_contenido = password.getText().toString();
                if (user_contenido.equals("admin") && password_contenido.equals("admin")) {
                    Toast.makeText(Login.this, "Iniciando sesion", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Login.this, Lists.class));
                } else {

                    Animation shake = AnimationUtils.loadAnimation(Login.this, R.anim.shake);

                    float red = 1.2f;
                    float green = 1.0f;
                    float blue = 1.0f;
                    float alpha = 1.0f;

                    ColorMatrix matrix = new ColorMatrix();
                    matrix.setScale(red, green, blue, alpha);
                    ColorMatrixColorFilter filter = new ColorMatrixColorFilter(matrix);
                    // user.setBackgroundColor(Color.RED);
                    user.getBackground().setColorFilter(filter);
                    password.getBackground().setColorFilter(filter);

                    password.startAnimation(shake);
                    user.startAnimation(shake);

                    Toast.makeText(Login.this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void Registrar(View view) {
        startActivity(new Intent(Login.this, Register.class));
    }

}