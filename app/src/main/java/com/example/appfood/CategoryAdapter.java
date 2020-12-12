package com.example.appfood;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryHolder> {
    private  List<Category> mCategories;

    public void setData(List<Category> list){
            this.mCategories = list;
            notifyDataSetChanged();
    }
    @NonNull
    @Override
    public CategoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        return new CategoryHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryHolder holder, int position) {
        Category cate = mCategories.get(position);
        if(cate == null){
            return;
        }
        holder.img_view.setImageResource(cate.getResourceId());
        holder.tx_view.setText(cate.getTitle());
    }

    @Override
    public int getItemCount() {
        if(mCategories !=null){
            return mCategories.size();
        }
        return 0;
    }

    public class CategoryHolder extends RecyclerView.ViewHolder{
         private ImageView img_view;
         private TextView tx_view;
        public CategoryHolder(@NonNull View itemView) {
            super(itemView);
            img_view = itemView.findViewById(R.id.img_category);
            tx_view = itemView.findViewById(R.id.title);
        }
    }
}
