package com.example.cookbook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class ThirdActivity extends AppCompatActivity
{
    ArrayList<Recipies> manakeesh = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        Intent intent = getIntent();
        String s = intent.getStringExtra("name");

        manakeesh.add(new Recipies("2 1/4 lb flour"));
        manakeesh.add(new Recipies("2 cup of warm water"));
        manakeesh.add(new Recipies("Fresh zaater oil"));
        manakeesh.add(new Recipies("2 tbsp dry yeast"));
        manakeesh.add(new Recipies("2 tbsp olive oil"));
        manakeesh.add(new Recipies("1/3 cup grated akawi cheese"));
        manakeesh.add(new Recipies("1 tbsp Salt"));
        manakeesh.add(new Recipies("Time:- 1 hour"));


        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyclerview3);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new RecipiesAdapter(this, manakeesh));
    }
}