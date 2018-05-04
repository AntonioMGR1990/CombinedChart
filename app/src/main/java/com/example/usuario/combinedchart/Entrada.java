package com.example.usuario.combinedchart;

import com.github.mikephil.charting.charts.CombinedChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.CombinedData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;

import java.util.Date;

/**
 * Created by Usuario on 03/05/2018.
 */

public class Entrada extends BarEntry{

    public Entrada(float x, float y) {
        super(x, y);
    }

}
class XXX<T extends BarEntry>{

    Date fecha=new Date();
    T[] datos;

    public static  void YYY(){
        XXX<BarEntry>datos=new XXX<>();
    }


    public CombinedData getGrafica(){
        CombinedData z=new CombinedData();
        z.setData(new BarData());
        z.setData(new LineData());
        return z;
    }

}