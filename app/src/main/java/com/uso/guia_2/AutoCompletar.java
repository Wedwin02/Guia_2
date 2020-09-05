package com.uso.guia_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class AutoCompletar extends AppCompatActivity {
    private AutoCompleteTextView txbLenguajeP;
    private AutoCompleteTextView  txbAnimal;
    private AutoCompleteTextView txbFruta;
    private Button procesarbtn;
    private ProgressBar barra;

    //para la barra
    private static  int Contador = 0;
    private Handler miHandler;
    //Para autoCompletado

    private ArrayAdapter<String> AdaptadorF;
    private ArrayAdapter<String> AdaptadorL;
    private ArrayAdapter<String> AdaptadorA;
    private String[] Lenguaje = {"C++","JavaScript","Python","PHP","C#","Java"};
    private String[] Animal = {"Gato", "Perro","Perico", "Conejo","Higuana","Peces"};
    private String[] Fruta = {"Fresa","Guineo","Manzana","Melocoton","Sandia"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_completar);
        this.txbFruta = findViewById(R.id.txbFrutas);
        this.txbAnimal = findViewById(R.id.txbAnimales);
        this.txbLenguajeP = findViewById(R.id.txbLP);
        this.barra = findViewById(R.id.idBarra);
        this.procesarbtn = findViewById(R.id.btnProcesar);
        this.miHandler = new Handler();
        this.barra.setMax(100);
        this.txbLenguajeP =findViewById(R.id.txbLP);
        this.txbFruta = findViewById(R.id.txbFrutas);
        this.txbAnimal = findViewById(R.id.txbAnimales);

        LLenarDatos();
    }
    public  void Procesar_onclick(View v){

        new Thread(new ProcesoSecundario()).start();
    }




    private void LLenarDatos(){
        AdaptadorL = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, this.Lenguaje);
        AdaptadorF = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, this.Fruta);
        AdaptadorA = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,this.Animal);

        txbLenguajeP.setThreshold(1);
        txbLenguajeP.setAdapter(AdaptadorL);
        txbFruta.setThreshold(1);
        txbFruta.setAdapter(AdaptadorF);
        txbAnimal.setThreshold(1);
        txbAnimal.setAdapter(AdaptadorA);




    }

    final class ProcesoSecundario implements Runnable{

        @Override
        public void run() {
            while(Contador<100){
                metodoEspera();
                miHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        barra.setProgress(Contador);
                        if (Contador == 100){

                            Toast.makeText(AutoCompletar.this,"Fruta " + txbFruta.getText().toString(),Toast.LENGTH_SHORT).show();
                            Toast.makeText(AutoCompletar.this,"Animal " + txbAnimal.getText().toString(),Toast.LENGTH_SHORT).show();
                            Toast.makeText(AutoCompletar.this,"Lenguaje " + txbLenguajeP.getText().toString(),Toast.LENGTH_SHORT).show();

                        }
                    }
                });


            }

        }
    }

    private void metodoEspera(){
        try{
            Thread.sleep(100);
            Contador++;
        } catch (Exception e) {

        }

    }

}