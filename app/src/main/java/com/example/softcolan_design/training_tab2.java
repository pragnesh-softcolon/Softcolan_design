package com.example.softcolan_design;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;


public class training_tab2 extends Fragment
{
    LinearLayoutManager HorizontalLayout;
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_training_tab2, container, false);
        MyListData[] myListData = new MyListData[] {
                new MyListData("At vero eos\net accusamus\net iusto odio", R.drawable.rectangle79),
                new MyListData("At vero eos\net accusamus\net iusto odio",  R.drawable.workvideo),
                new MyListData("At vero eos\net accusamus\net iusto odio",  R.drawable.rectangle79),
                new MyListData("At vero eos\net accusamus\net iusto odio",  R.drawable.workvideo),
                new MyListData("At vero eos\net accusamus\net iusto odio",  R.drawable.rectangle79),
                new MyListData("At vero eos\net accusamus\net iusto odio",  R.drawable.workvideo),
                new MyListData("At vero eos\net accusamus\net iusto odio",  R.drawable.rectangle79),
                new MyListData("At vero eos\net accusamus\net iusto odio",  R.drawable.workvideo),
        };
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        MyListAdapter adapter = new MyListAdapter(myListData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        HorizontalLayout = new LinearLayoutManager(
                getContext(), LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(HorizontalLayout);
        return view;
    }
}