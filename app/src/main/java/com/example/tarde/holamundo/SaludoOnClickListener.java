package com.example.tarde.holamundo;

import android.app.Activity;
import android.view.View;

/**
 * Created by tarde on 29/01/2015.
 */
public class SaludoOnClickListener implements View.OnClickListener{


    @Override
    public void onClick(View v) {
        Activity context = (Activity) v.getContext();  //contexto en el que se ha creado la view (es la actividad correspondiente

    }
}
