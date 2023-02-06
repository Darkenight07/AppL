package com.example.listsforone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText cajaNumero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cajaNumero = findViewById(R.id.cajaNum); // Caja texto
    }
    public void BotonGuardar(View view) {
        String contenido = cajaNumero.getText().toString();

        if (contenido.isEmpty()) {
            Toast.makeText(this, "Debe ingresar un numero!", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            long numFinal = Long.parseLong(contenido);
            if (numFinal == 10) {
                Toast.makeText(this, "Llevandote al inicio de sesion", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, Login.class));
            } else if (numFinal <= 0) {
                Toast.makeText(this, "No puedes ingresar un numero menor o igual que 0", Toast.LENGTH_SHORT).show();
            } else if (numFinal > 100) {
                Toast.makeText(this, "No puedes ingresar un numero mayor que 100", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Numero guardado, el numero ingresado es: " + numFinal, Toast.LENGTH_SHORT).show();
            }
        } catch (NumberFormatException e) {
            Toast.makeText(this, "El número es demasiado grande para guardar", Toast.LENGTH_SHORT).show();
        }
    }

}