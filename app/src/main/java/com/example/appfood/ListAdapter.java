package com.example.appfood;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListAdapter extends  RecyclerView.Adapter<ListAdapter.ListHolder>{

    private Context mContext;
    private List<ListCategory> mList;

    public ListAdapter(Context mContext) {
        this.mContext = mContext;
    }
    public void setData(List<ListCategory> list){
            this.mList = list;

    }

    @NonNull
    @Override
    public ListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category,parent,false);
        return new ListHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListHolder holder, int position) {
        ListCategory list = mList.get(position);
        if(list == null){
            return;
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext,RecyclerView.HORIZONTAL,false);
        holder.rcv.setLayoutManager(linearLayoutManager);
        CategoryAdapter categoryAdapter = new CategoryAdapter();
        categoryAdapter.setData(list.getCategories());
        holder.rcv.setAdapter(categoryAdapter);
    }

    @Override
    public int getItemCount() {
        if(mList != null){
            return mList.size();
        }
        return 0;
    }

    public class ListHolder extends RecyclerView.ViewHolder{

        private RecyclerView rcv;
        public ListHolder(@NonNull View itemView) {
            super(itemView);
            rcv = itemView.findViewById(R.id.rcv_category);
        }
    }
}
