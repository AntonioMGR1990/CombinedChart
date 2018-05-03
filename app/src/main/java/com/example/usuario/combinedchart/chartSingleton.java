package com.example.usuario.combinedchart;

import com.github.mikephil.charting.charts.CombinedChart;

import java.util.Date;

/**
 * Created by Usuario on 03/05/2018.
 */

class chartSingleton {
    private static final chartSingleton ourInstance = new chartSingleton();

    private CombinedChart lastChart;
    private Date fecha;

    static chartSingleton getInstance() {
        return ourInstance;
    }

    private chartSingleton() {
    }

    public CombinedChart getLastChart() {
        return lastChart;
    }

    public void setLastChart(CombinedChart lastChart) {
        this.lastChart = lastChart;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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
