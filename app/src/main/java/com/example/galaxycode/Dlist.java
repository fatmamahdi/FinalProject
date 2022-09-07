package com.example.galaxycode;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Dlist extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);


        Bundle Vedd = getIntent().getExtras();


        TextView Name = findViewById(R.id.textView10);
        ImageView photo = findViewById(R.id.imageView3);

        Ved currentVed = (Ved) Vedd.getSerializable("currentVed");

        Name.setText(currentVed.getE());

    }
}