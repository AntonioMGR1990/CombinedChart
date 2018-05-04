package com.example.usuario.combinedchart;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import com.example.usuario.combinedchart.conexion.ComunationTask;


import java.util.Calendar;
import java.util.Date;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            getSupportActionBar().hide();
        }catch (NullPointerException e){
            e.printStackTrace();
        }


        Date date = new Date();
        // Crea el objeto Date
        Calendar calendar = Calendar.getInstance(); // Obtiene una instancia de Calendar
        calendar.setTime(date);

        int year        = calendar.get(Calendar.YEAR);
        int month       = calendar.get(Calendar.MONTH);
        int day         = calendar.get(Calendar.DAY_OF_MONTH);


            System.out.println(year);

        ComunationTask com = new ComunationTask(findViewById(R.id.combinedChart));
            String Url = "http://www.omie.es/datosPub/marginalpdbc/marginalpdbc_";
            Url = Url + String.valueOf(year) + "0" + String.valueOf(month + 1) + "0" + String.valueOf(day) + ".1";
            System.out.println(Url);
            com.execute(Url);




    }


}