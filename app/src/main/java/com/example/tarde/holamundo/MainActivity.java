package com.example.tarde.holamundo;

import android.app.Activity;
import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    //maneja evento de crear actividad
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);  // indica la vista
        //R es una clase auto-generada. Tiene constantes. No hay que tocarla.

        View boton = findViewById(R.id.button);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondaryActivity.class);

                //si queremos mandar un objeto (a la actividad que vamos a envocar) no primitiva tiene que ser serializable..
                intent.putExtra("dato", "Mi nombre es Jose");

                startActivity(intent);  //para abrir la nueva ventana
            }
        });


        View botonConResultado = findViewById(R.id.btConResultado);

        botonConResultado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, ConResultadoActivity.class);

                //si queremos mandar un objeto (a la actividad que vamos a envocar) no primitiva tiene que ser serializable..
                //intent.putExtra("dato","Mi nombre es Jose");

                startActivityForResult(intent, 0);
                //requestCode

            }
        });

       }


       @Override
        protected void onActivityResult(int requestCode,int resultCode, Intent data){

            super.onActivityResult(requestCode,  resultCode,  data);

            if(requestCode==0){
                if (resultCode == Activity.RESULT_OK){
                    String resultado = data.getStringExtra("Resultado");
                    Toast.makeText(this,"El resultado es: " + resultado, Toast.LENGTH_LONG ).show();
                }else{

                    Log.i(MainActivity.class.getName(), "El resultado de la petición no ha sido correcto");
                    //Toast.makeText(this,"Back", Toast.LENGTH_LONG ).show();

                }


            }
    }

    //maneja evento de crear menu de la actividad
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
