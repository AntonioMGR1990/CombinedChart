package com.example.usuario.combinedchart;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.CombinedChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.CombinedData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private CombinedChart combinedChart;
    private CombinedData data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //iniciamos el combinechart
        combinedChart = findViewById(R.id.combinedChart);
        data = new CombinedData();
        data.setData(barData());
        data.setData(lineData());
        combinedChart.setData(data);
        Description description = new Description();
        description.setText("grafica combinada");
        combinedChart.setDescription(description);
        combinedChart.animateX(2500);
        combinedChart.getLegend().setEnabled(false);
        combinedChart.setPadding(2,2,2,2);
        XAxis xAxis = combinedChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setValueFormatter(new IndexAxisValueFormatter(getXAxisValues()));

    }
    private ArrayList<String> getXAxisValues(){
        ArrayList<String> labels = new ArrayList<>();
        for (int i = 1;i<24;i++){
            labels.add(String.valueOf(i));
        }

        return labels;
    }
    public LineData lineData(){
        ArrayList<Entry> line = new ArrayList<>();
                line.add(new Entry(1f, 6));
                line.add(new Entry(2f, 1));
                line.add(new Entry(3f, 2));
                line.add(new Entry(4f, 3));
                line.add(new Entry(5f, 4));
                line.add(new Entry(6f, 8));
                line.add(new Entry(7f, 4));
                line.add(new Entry(8f, 1));
                line.add(new Entry(9f, 2));
                line.add(new Entry(10f, 3));
                line.add(new Entry(11f, 4));
                line.add(new Entry(12f, 5));
                line.add(new Entry(13f, 3));
                line.add(new Entry(14f, 1));
                line.add(new Entry(15f, 4));
                line.add(new Entry(16f, 3));
                line.add(new Entry(17f, 4));
                line.add(new Entry(18f, 5));
                line.add(new Entry(19f, 5));
                line.add(new Entry(20f, 1));
                line.add(new Entry(21f, 7));
                line.add(new Entry(22f, 3));
                line.add(new Entry(23f, 6));
                line.add(new Entry(24f, 5));
        LineDataSet lineDataSet = new LineDataSet(line, "Brand 2");
        lineDataSet.setColors(Color.parseColor("#36b4fc"));
        LineData lineData = new LineData(lineDataSet);
        return lineData;

    }
    public BarData barData(){
       ArrayList<BarEntry> group1 = new ArrayList<>();
                group1.add(new BarEntry(1f, 3));
                group1.add(new BarEntry(2f, 1));
                group1.add(new BarEntry(3f, 2));
                group1.add(new BarEntry(4f, 5));
                group1.add(new BarEntry(5f, 4));
                group1.add(new BarEntry(6f, 1));
                group1.add(new BarEntry(7f, 4));
                group1.add(new BarEntry(8f, 1));
                group1.add(new BarEntry(9f, 2));
                group1.add(new BarEntry(10f, 3));
                group1.add(new BarEntry(11f, 9));
                group1.add(new BarEntry(12f, 5));
                group1.add(new BarEntry(13f, 7));
                group1.add(new BarEntry(14f, 1));
                group1.add(new BarEntry(15f, 5));
                group1.add(new BarEntry(16f, 3));
                group1.add(new BarEntry(17f, 2));
                group1.add(new BarEntry(18f, 5));
                group1.add(new BarEntry(19f, 5));
                group1.add(new BarEntry(20f, 10));
                group1.add(new BarEntry(21f, 1));
                group1.add(new BarEntry(22f, 4));
                group1.add(new BarEntry(23f, 3));
                group1.add(new BarEntry(24f, 1));

        BarDataSet barDataSet = new BarDataSet(group1, "Brand 1");
        //barDataSet.setColor(Color.rgb(0, 155, 0));

        barDataSet.setColors(Color.parseColor("#3062b8"));
        BarData barData = new BarData(barDataSet);
        return barData;
    }
}
