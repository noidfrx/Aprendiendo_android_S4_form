package com.noidfrx.aprendiendo_android_s4_form;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    private Button btnSecondSiguiente;
    private String nombre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        btnSecondSiguiente = findViewById(R.id.btnSecondSiguiente);
        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){
            nombre = bundle.getString("nombre");
            Toast.makeText(SecondActivity.this, "Su nombre es "+nombre, Toast.LENGTH_SHORT).show();
        }

        btnSecondSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent( SecondActivity.this, ThirdActivity.class);
                startActivity(i);
            }
        });
    }
}