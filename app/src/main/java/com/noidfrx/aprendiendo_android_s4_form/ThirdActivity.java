package com.noidfrx.aprendiendo_android_s4_form;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ThirdActivity extends AppCompatActivity {
    private String nombre;
    private int saludoSeleccionado;
    private int edad;

    private Button btnMostrarMensaje;
    private Button btnCompartirMensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnMostrarMensaje = findViewById(R.id.btnMostrarMensaje);
        btnCompartirMensaje = findViewById(R.id.btnCompartirMensaje);


        btnCompartirMensaje.setVisibility(View.INVISIBLE);

        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){
            nombre = bundle.getString("nombre");
            edad = bundle.getInt("edad");
            saludoSeleccionado = bundle.getInt("saludoSeleccionado");
        }

        btnMostrarMensaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(ThirdActivity.this, createMessage(nombre,edad,saludoSeleccionado), Toast.LENGTH_SHORT).show();

                btnMostrarMensaje.setVisibility(View.INVISIBLE);
                btnCompartirMensaje.setVisibility(View.VISIBLE);
            }
        });

        btnCompartirMensaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_TEXT, createMessage(nombre,edad,saludoSeleccionado));
                startActivity(i);
            }
        });




    }

    public String createMessage(String nombre, int edad, int saludoSeleccionado){
        String textoAMostrar="";
        if(saludoSeleccionado == SecondActivity.OPCION_SALUDO){
            textoAMostrar = "Hola! "+nombre+" ¿Cómo llevas esos "+edad+" años? #MyForm";

        }else if(saludoSeleccionado == SecondActivity.OPCION_DESPEDIDA){
            textoAMostrar = "Espero verte pronto "+nombre+" antes que cumplas "+(edad+1)+" #MyForm";
        }
        return textoAMostrar;

    }
}