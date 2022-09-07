package com.example.galaxycode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class list2 extends AppCompatActivity {
    ArrayList<Ved> Vedlist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ved);

        Ved v1 = new Ved("الدرس 1",R.drawable.nnn,R.drawable.ic_baseline_play_arrow_24,"قريبا");
        Ved v2 = new Ved("الدرس 2",R.drawable.nnn,R.drawable.ic_baseline_play_arrow_24,"قريبا");
        Ved v3 = new Ved("الدرس 3",R.drawable.nnn,R.drawable.ic_baseline_play_arrow_24,"قريبا");
        Ved v4 = new Ved("الدرس 4",R.drawable.nnn,R.drawable.ic_baseline_play_arrow_24,"قريبا");
        Ved v5 = new Ved("الدرس 5",R.drawable.nnn,R.drawable.ic_baseline_play_arrow_24,"قريبا");
        Ved v6 = new Ved("الدرس 6",R.drawable.nnn,R.drawable.ic_baseline_play_arrow_24,"قريبا");
        Ved v7 = new Ved("الدرس 7",R.drawable.nnn,R.drawable.ic_baseline_play_arrow_24,"قريبا");
        Ved v8 = new Ved("الدرس 8",R.drawable.nnn,R.drawable.ic_baseline_play_arrow_24,"قريبا");
        Ved v9 = new Ved("الدرس 9",R.drawable.nnn,R.drawable.ic_baseline_play_arrow_24,"قريبا");
        Ved v10 = new Ved("الدرس 10",R.drawable.nnn,R.drawable.ic_baseline_play_arrow_24,"قريبا");


        Vedlist.add(v1);
        Vedlist.add(v2);
        Vedlist.add(v3);
        Vedlist.add(v4);
        Vedlist.add(v5);
        Vedlist.add(v6);
        Vedlist.add(v7);
        Vedlist.add(v8);
        Vedlist.add(v9);
        Vedlist.add(v10);


        listA VedA= new listA(this ,0,Vedlist);

        ListView list =findViewById(R.id.list);

        list.setAdapter(VedA);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Ved currentVed = Vedlist.get(i);
                Intent Details = new Intent(list2.this,Dlist.class);
                Details.putExtra("currentVed",currentVed);
                startActivity(Details);
            }
        });

    }
}