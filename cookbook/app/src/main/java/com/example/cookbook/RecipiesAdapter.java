package com.example.cookbook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecipiesAdapter extends RecyclerView.Adapter<RecipiesAdapter.RecipiesViewHolder>
{
    Context context;
    ArrayList<Recipies> arrayList = new ArrayList<>();

    public RecipiesAdapter(Context context, ArrayList<Recipies> arrayList)
    {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public RecipiesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.recipies_layout,parent,false);
        return new RecipiesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipiesViewHolder holder, int position)
    {
        holder.textView.setText(arrayList.get(position).text);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class RecipiesViewHolder extends RecyclerView.ViewHolder
    {
        TextView textView;

        public RecipiesViewHolder(@NonNull View itemView)
        {
            super(itemView);
            textView = (TextView)itemView.findViewById(R.id.recipiesName);
        }
    }
}
