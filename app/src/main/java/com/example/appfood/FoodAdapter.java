package com.example.appfood;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {

    private List<Food> mFood;

    public FoodAdapter(List<Food> mFood) {
        this.mFood = mFood;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_food,parent,false);
        return new FoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        Food food = mFood.get(position);
        if(food ==null){
            return;
        }
        holder.imgFood.setImageResource(food.getImage());
        holder.nameFood.setText(food.getName());
        holder.descFood.setText(food.getDescription());

    }

    @Override
    public int getItemCount() {
        if(mFood != null){
            return mFood.size();
        }
        return 0;
    }

    public class FoodViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFood;
        private TextView nameFood;
        private TextView descFood;


        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFood = itemView.findViewById(R.id.img_food);
            nameFood =itemView.findViewById(R.id.name_food);
            descFood = itemView.findViewById(R.id.desc_food);
        }
    }
}
