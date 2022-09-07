package com.example.galaxycode;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class listA extends ArrayAdapter<Ved> {
    List<Ved> listA;

    public listA(@NonNull Context context, int resource, @NonNull List<Ved> objects) {
        super(context, resource, objects);
        listA = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.list_ved, parent, false);

        Ved Cved = listA.get(position);

        TextView VedName = view.findViewById(R.id.textView9);
        ImageView VedImage = view.findViewById(R.id.imageView);
        ImageView SVed = view.findViewById(R.id.imageView2);


        VedName.setText(Cved.getVed());
        VedImage.setImageResource(Cved.getIVed());

        return view;


    }

}
