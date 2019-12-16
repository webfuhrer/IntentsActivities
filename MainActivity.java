package com.example.prubaactivity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button btn_abrirActivity;
    EditText et_nombre;
    Context contexto;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        String nombre_vuelta=data.getExtras().getString("nombre_vuelta");
        et_nombre.setText(nombre_vuelta);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contexto=this;
        //Inicializo el botón
        btn_abrirActivity=findViewById(R.id.btn_enviar);
        et_nombre=findViewById(R.id.et_nombre);
        btn_abrirActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dato=et_nombre.getText().toString();
                Intent i=new Intent(contexto, Main2Activity.class);
                i.putExtra("nombre", dato);
                //startActivity(i);
                startActivityForResult(i, 1);
            }
        });
    }
}
