package com.noidfrx.aprendiendo_android_s4_form;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button btnMainSiguiente;
    private EditText etNombrePersona;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_myicon);
        btnMainSiguiente=findViewById(R.id.btnMainSiguiente);
        etNombrePersona = findViewById(R.id.etNombrePersona);

        //lo que pasa al tocar boton
        btnMainSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, SecondActivity.class);

                String nombre = etNombrePersona.getText().toString();
                if(!nombre.isEmpty() && nombre != null){
                    i.putExtra("nombre", nombre);
                    startActivity(i);
                }else{
                    etNombrePersona.setError("Ingrese nombre");
                }

            }
        });
    }
}