package com.uso.guia_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
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
    private Button btnIniciar ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.txbUsuario = findViewById(R.id.txbUsuario);
        this.txbPass = findViewById(R.id.txbpass);
        this.btnIniciar = findViewById(R.id.btnIniciarSession);

        this.txbUsuario.addTextChangedListener(CaposLlenos);
        this.txbPass.addTextChangedListener(CaposLlenos);


    }
    private TextWatcher  CaposLlenos = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            //Convertir a String
            String txbUsu = txbUsuario.getText().toString().trim();
            String txbpa = txbPass.getText().toString().trim();
             //cambiar de estado el boton que viene false
            btnIniciar.setEnabled(!txbUsu.isEmpty() && !txbpa.isEmpty());

        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };






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