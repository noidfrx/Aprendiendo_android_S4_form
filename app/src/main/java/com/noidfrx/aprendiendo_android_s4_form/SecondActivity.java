package com.noidfrx.aprendiendo_android_s4_form;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    private Button btnSecondSiguiente;
    private SeekBar seekBarEdad;
    private TextView tvEdad;

    private String nombre;
    private int edad = 18;
    private final int MAX_EDAD = 60;
    private final int MIN_EDAD = 16;

    public static final int OPCION_SALUDO = 1;
    public static final int OPCION_DESPEDIDA = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        btnSecondSiguiente = findViewById(R.id.btnSecondSiguiente);
        seekBarEdad = findViewById(R.id.seekBarEdad);
        tvEdad = findViewById(R.id.tvEdad);
        tvEdad.setText(edad+"");

        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){
            nombre = bundle.getString("nombre");
            Toast.makeText(SecondActivity.this, "Su nombre es "+nombre, Toast.LENGTH_SHORT).show();
        }

        seekBarEdad.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                //Cuando se esté moviendo el seekbar se muestra en textview
                edad = i;
                tvEdad.setText(i+"");

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //Cuando deje de mover el seekbar se selecciona el número
                edad = seekBar.getProgress();
                tvEdad.setText(edad+"");

                if(edad > MAX_EDAD){
                    Toast.makeText(SecondActivity.this, "La edad seleccionada supera la edad máxima: "+MAX_EDAD, Toast.LENGTH_SHORT).show();
                    btnSecondSiguiente.setVisibility(View.INVISIBLE);
                } else if(edad < MIN_EDAD){
                    Toast.makeText(SecondActivity.this, "La edad seleccionada está bajo la edad mínima: "+MIN_EDAD, Toast.LENGTH_SHORT).show();
                    btnSecondSiguiente.setVisibility(View.INVISIBLE);
                }else {
                    btnSecondSiguiente.setVisibility(View.VISIBLE);
                }
            }
        });

        btnSecondSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent( SecondActivity.this, ThirdActivity.class);
                startActivity(i);
            }
        });
    }
}