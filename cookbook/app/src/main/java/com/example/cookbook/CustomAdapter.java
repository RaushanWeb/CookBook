package com.example.cookbook;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collection;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.customViewHolder>
{
    Context context;
    ArrayList<FoodItem> arrayList = new ArrayList<>();

    public CustomAdapter(Context context, ArrayList<FoodItem> arrayList)
    {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public customViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.activity_grid_view,parent,false);
        return new customViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull customViewHolder holder, int position)
    {

        holder.textView.setText(arrayList.get(position).foodnames);
        holder.imageView.setImageResource(arrayList.get(position).image);

        holder.itemView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(context,arrayList.get(position).foodnames,Toast.LENGTH_LONG).show();
                Intent intent = new Intent(context,ThirdActivity.class);
                intent.putExtra("name",arrayList.get(position).foodnames);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount()
    {
        return arrayList.size();
    }

    public void filterList(ArrayList<FoodItem> filterdList)
    {
        arrayList = filterdList;
        notifyDataSetChanged();
    }

    public class customViewHolder extends RecyclerView.ViewHolder
    {
        ImageView imageView;
        TextView textView;
        public customViewHolder(@NonNull View itemView)
        {
            super(itemView);
            imageView = (ImageView)itemView.findViewById(R.id.imageView);
            textView = (TextView)itemView.findViewById(R.id.imageName);
        }
    }
}
