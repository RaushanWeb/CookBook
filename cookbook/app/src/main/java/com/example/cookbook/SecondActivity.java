package com.example.cookbook;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import static com.example.cookbook.MainActivity.hashMap;

public class SecondActivity extends AppCompatActivity
{
     EditText searchbar;
     ImageView FbLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        searchbar = (EditText)findViewById(R.id.searchbar);
        FbLogin  = (ImageView)findViewById(R.id.loginImage);

        Intent i = getIntent();
        String country  = i.getStringExtra("name");
        ArrayList<FoodItem> arrayList = hashMap.get(country);
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyclerview2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(new CustomAdapter(this,arrayList));

        // For searching....
        searchbar.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {

            }
            @Override
            public void afterTextChanged(Editable s)
            {
                ArrayList<FoodItem> filterdList = new ArrayList<FoodItem>();
                for(FoodItem item:arrayList)
                {
                    if(item.foodnames.toLowerCase().contains(s.toString().toLowerCase()))
                    {
                        filterdList.add(item);
                    }
                }
                recyclerView.setAdapter(new CustomAdapter(getApplicationContext(),filterdList));
            }
        });
        //for login to firebase...
        login();

    }
    public void login()
    {
        FbLogin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent1 = new Intent(getApplicationContext(),loginActivity.class);
                startActivity(intent1);

            }
        });
    }
}
