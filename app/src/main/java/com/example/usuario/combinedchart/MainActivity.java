package com.example.usuario.combinedchart;

import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.CombinedChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.CombinedData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private CombinedChart combinedChart;
    private CombinedData data;
    private  ArrayList<Entrada> entradas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ComunicacionTask com = new ComunicacionTask();
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
    private ArrayList<String> getXAxisValues(){
        ArrayList<String> labels = new ArrayList<>();
        for (int i = 1;i<24;i++){
            labels.add(String.valueOf(i));
        }

        return labels;
    }
    public void Xaxis(XAxis xAxis){
        xAxis.setGranularityEnabled(true);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setAxisMinimum(0.45f);
        xAxis.setAxisMaximum(entradas.size()+1);
        xAxis.setGranularity(1);
        xAxis.setValueFormatter(new IndexAxisValueFormatter(getXAxisValues()));
    }
    public void YaxisLeft(YAxis yAxis){
       // yAxis.setSpaceBottom(0);
       // yAxis.setSpaceTop(20);
        yAxis.setGranularityEnabled(true);
        yAxis.setGranularity(5);
        yAxis.setAxisMinimum(0);

    }
    public void YaxisRight(YAxis yAxis){
        yAxis.setEnabled(false);
    }
    public LineData lineData(){
        ArrayList<Entry> line = new ArrayList<>();
        for (int i = 0;i<entradas.size();i++){
            line.add(entradas.get(i));
        }

        LineDataSet lineDataSet = new LineDataSet(line, "Brand 2");
        lineDataSet.setColors(Color.parseColor("#36b4fc"));
        LineData lineData = new LineData(lineDataSet);

        return lineData;

    }
    public BarData barData(){
       ArrayList<BarEntry> group1 = new ArrayList<>();
        for (int i = 0;i<entradas.size();i++){
            float x = entradas.get(i).getX();
            float y = entradas.get(i).getY();
            group1.add(entradas.get(i));
        }

        BarDataSet barDataSet = new BarDataSet(group1, "Brand 1");
        //barDataSet.setColor(Color.rgb(0, 155, 0));

        barDataSet.setColors(Color.parseColor("#3062b8"));
        BarData barData = new BarData(barDataSet);
        barData.setValueTextSize(10);
        return barData;
    }
    private class ComunicacionTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {
            String cadena = "";
            try {
                URL url = new URL(params[0]);
                URLConnection con = url.openConnection();
                //recuperacion de la respuesta JSON
                String s;
                InputStream is = con.getInputStream();
                //utilizamos UTF-8 para que interprete
                //correctamente las ñ y acentos
                BufferedReader bf = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
                while ((s = bf.readLine()) != null) {
                    if (s.equals("MARGINALPDBC;") || s.equals("*")) {

                    } else{
                        cadena += s;
                    }
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            return cadena;
        }

        @Override
        protected void onPostExecute(String result) {

            entradas = new ArrayList<>();
            String[] array = result.split(";");



            for (int x = 6; x <= array.length;x+=6) {
                Entrada entrada = new Entrada(Float.parseFloat(array[x-3]),Float.parseFloat(array[x-2]));
                entradas.add(entrada);
            }
            System.out.println("");
            combinedChart = findViewById(R.id.combinedChart);
            data = new CombinedData();
            data.setData(barData());
            data.setData(lineData());
            combinedChart.setData(data);

            combinedChart.animateY(3000, Easing.EasingOption.EaseInOutExpo);
            combinedChart.getLegend().setEnabled(false);

            Xaxis(combinedChart.getXAxis());
            YaxisLeft(combinedChart.getAxisLeft());
            YaxisRight(combinedChart.getAxisRight());

        }
    }
}