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
import java.util.List;

public class ProgrammingAdapter extends RecyclerView.Adapter<ProgrammingAdapter.ProgrammingViewHolder>
{
    Context context;
    String [] name;
    int [] image;

    public ProgrammingAdapter(Context context, String [] name,int []image)
    {
        this.context = context;
        this.name = name;
        this.image = image;
    }
    @NonNull
    @Override
    public ProgrammingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.cuisines_layout,parent,false);
        return new ProgrammingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProgrammingViewHolder holder, int position)
    {
        String text =name[position];
        holder.textView.setText(text);
        final int f = image[position];
        holder.imageView.setImageResource(f);

        holder.itemView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(context,name[position],Toast.LENGTH_LONG).show();
                Intent intent = new Intent(context,SecondActivity.class);
                intent.putExtra("name",name[position]);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount()
    {
        return name.length;
    }

    public class ProgrammingViewHolder extends RecyclerView.ViewHolder
    {
        ImageView imageView;
        TextView textView;

        public ProgrammingViewHolder(@NonNull View itemView)
        {
            super(itemView);
            imageView = (ImageView)itemView.findViewById(R.id.imageIcon);
            textView = (TextView)itemView.findViewById(R.id.name);
        }
    }
}
