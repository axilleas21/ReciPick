package com.app.recipick.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.app.recipick.R;
import com.app.recipick.data.Recipe.Recipe;
import java.util.ArrayList;

public class TheAdapter extends RecyclerView.Adapter<TheAdapter.ViewHolder>{
    public interface OnRecipeClickListener{void onRecipeClick(Recipe recipe);}
    private ArrayList<Recipe> recipes; private OnRecipeClickListener listener;

    public TheAdapter(ArrayList<Recipe> recipes, OnRecipeClickListener listener){this.recipes=recipes; this.listener=listener;}

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtName;TextView txtDescription;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            txtName=itemView.findViewById(R.id.txtRecipeName);
            txtDescription=itemView.findViewById(R.id.txtDescription);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent,int viewType){
        // kanei to item sth lista na mhn einai diko tou activity mesw tou recycler
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recipe,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position){
        Recipe recipe=recipes.get(position);
        holder.txtName.setText(recipe.getName());
        holder.txtDescription.setText(recipe.getDescription());
        holder.itemView.setOnClickListener(v->listener.onRecipeClick(recipe));
    }

    @Override
    public int getItemCount(){return recipes.size();}
}














