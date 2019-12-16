package com.example.prubaactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
TextView tv_mostrar_nombre;
Button btn;
EditText et_nombre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent i=getIntent();
        Bundle b=i.getExtras();
        et_nombre=findViewById(R.id.et_main2);
        btn=findViewById(R.id.btn_volver);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.putExtra("nombre_vuelta",et_nombre.getText().toString());
                setResult(Activity.RESULT_OK,i);
                finish();
            }
        });
        tv_mostrar_nombre=findViewById(R.id.tv_mostrar_nombre);
        String nombre=b.getString("nombre");
        tv_mostrar_nombre.setText("Hola, te llamas "+nombre);
    }
}
