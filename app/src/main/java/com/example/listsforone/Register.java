package com.example.listsforone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    EditText userRe;
    EditText passwordRe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        userRe = findViewById(R.id.userRe);
        passwordRe = findViewById(R.id.passwordRe);

    }
    public void Registrarse(View view) {
        String contenido_UserRe = userRe.getText().toString();
        String contenido_passwordRe = passwordRe.getText().toString();

        if (contenido_UserRe.isEmpty() || contenido_passwordRe.isEmpty()) {
            Toast.makeText(this, "El campo user y el campo contraseña esta vacio", Toast.LENGTH_SHORT).show();

            Animation shake = AnimationUtils.loadAnimation(Register.this, R.anim.shake);

            float red = 1.2f;
            float green = 1.0f;
            float blue = 1.0f;
            float alpha = 1.0f;

            ColorMatrix matrix = new ColorMatrix();
            matrix.setScale(red, green, blue, alpha);
            ColorMatrixColorFilter filter = new ColorMatrixColorFilter(matrix);
            // user.setBackgroundColor(Color.RED);
            userRe.getBackground().setColorFilter(filter);
            passwordRe.getBackground().setColorFilter(filter);

            userRe.startAnimation(shake);
            passwordRe.startAnimation(shake);

        } else if (contenido_passwordRe.length() < 7){
            Toast.makeText(this, "La contraseña introducida es menor a 7 caracteres. Minimo 7 caracteres.", Toast.LENGTH_SHORT).show();
        } else {
            startActivity(new Intent(Register.this, Login.class));
            Toast.makeText(this, "Registro completado", Toast.LENGTH_SHORT).show();
        }
    }
}