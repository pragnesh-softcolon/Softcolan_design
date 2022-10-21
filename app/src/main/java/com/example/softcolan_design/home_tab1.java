package com.example.softcolan_design;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class home_tab1 extends Fragment
{
    View view;
    GraphView graph;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home_tab1, container, false);
        graph = view.findViewById(R.id.graph);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[]
                {
                    new DataPoint(0, 8),
                    new DataPoint(1, 16),
                    new DataPoint(2, 15),
                    new DataPoint(3, 34),
                    new DataPoint(5, 75),
                    new DataPoint(6, 89),
                    new DataPoint(7, 25),
                    new DataPoint(8, 6),
                    new DataPoint(9, 5),
                    new DataPoint(10, 51)
                });
        graph.addSeries(series);
        return view;
    }

}