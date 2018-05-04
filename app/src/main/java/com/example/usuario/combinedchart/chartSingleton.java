package com.example.usuario.combinedchart;

import android.view.View;

import com.github.mikephil.charting.charts.CombinedChart;
import com.github.mikephil.charting.data.CombinedData;

import java.util.Date;

/**
 * Created by Usuario on 03/05/2018.
 */

public class chartSingleton {
    private static final chartSingleton ourInstance = new chartSingleton();

    private CombinedData lastChart;
    private View grafica;
    private Date fecha;

    public static chartSingleton getInstance() {
        return ourInstance;
    }

    private chartSingleton() {
    }

    public CombinedData getLastChart() {
        return lastChart;
    }

    public void setLastChart(CombinedData lastChart) {
        this.lastChart = lastChart;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public View getGrafica() {
        return grafica;
    }

    public void setGrafica(View grafica) {
        this.grafica = grafica;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        chartSingleton that = (chartSingleton) o;

        if (lastChart != null ? !lastChart.equals(that.lastChart) : that.lastChart != null)
            return false;
        return fecha != null ? fecha.equals(that.fecha) : that.fecha == null;
    }

    @Override
    public int hashCode() {
        int result = lastChart != null ? lastChart.hashCode() : 0;
        result = 31 * result + (fecha != null ? fecha.hashCode() : 0);
        return result;
    }
}
