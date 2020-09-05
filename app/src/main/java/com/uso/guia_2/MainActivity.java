package com.uso.guia_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText txbUsuario,txbPass;
    private String Usu;
    private  String pass;
    Button btnIniciar ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.txbUsuario = findViewById(R.id.txbUsuario);
        this.txbPass = findViewById(R.id.txbpass);
        this.btnIniciar = findViewById(R.id.btnIniciarSession);

        String u = txbUsuario.getText().toString().trim();
        String p = txbPass.getText().toString().trim();
        if(u.length() > 0  && p.length() > 0){
            btnIniciar.setEnabled(true);
        }
    }







    public void IniciarSession_onClick(View v){
         this.Usu = txbUsuario.getText().toString().trim();
         this.pass = txbPass.getText().toString().trim();

         CargarDatos(Usu,pass);
    }



    public void  CargarDatos(String u,String p){
        String UsuarioQuemado = "Admin";
        String PassQuemada = "12345";
            if (u.equals(UsuarioQuemado) && p.equals(PassQuemada)) {
                Intent i = new Intent(this, AutoCompletar.class);
                Toast.makeText(this, "Bienvenido " + UsuarioQuemado, Toast.LENGTH_LONG).show();
                startActivity(i);
            } else {
                Toast.makeText(MainActivity.this, "Error Usuario ó Contraseña equivocada...", Toast.LENGTH_SHORT).show();
            }
    }




}