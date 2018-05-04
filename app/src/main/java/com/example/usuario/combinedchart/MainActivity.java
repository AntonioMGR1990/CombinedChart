package com.example.usuario.combinedchart;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.CombinedChart;

import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.CombinedData;
import com.example.usuario.combinedchart.conexion.ComunationTask;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private CombinedChart combinedChart;
    private CombinedData data;
    private  ArrayList<BarEntry> entradas;
    private ComunationTask com;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        com = new ComunationTask(findViewById(R.id.combinedChart));
        com.execute("http://www.omie.es/datosPub/marginalpdbc/marginalpdbc_20180503.1");

        //iniciamos el combinechart
        /*
        combinedChart = findViewById(R.id.combinedChart);
        data = new CombinedData();

        data.setData(barData());
        data.setData(lineData());
        combinedChart.setData(data);
        Description description = new Description();
        description.setText("grafica combinada");
        combinedChart.setDescription(description);
        combinedChart.animateY(3000, Easing.EasingOption.EaseInOutExpo);
        combinedChart.getLegend().setEnabled(false);
        combinedChart.getAxisRight().setEnabled(false);
        XAxis xAxis = combinedChart.getXAxis();
        xAxis.setGranularityEnabled(false);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setValueFormatter(new IndexAxisValueFormatter(getXAxisValues()));
        */

    }


}