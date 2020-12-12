package com.example.appfood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rcv;
    private ListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcv = findViewById(R.id.main_rcv);
        listAdapter = new ListAdapter(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        rcv.setLayoutManager(linearLayoutManager);

        listAdapter.setData(getList());
        rcv.setAdapter(listAdapter);
    }
    private List<ListCategory> getList(){
        List<ListCategory> list = new ArrayList<>();

        List<Category> listCategory = new ArrayList<>();
        listCategory.add(new Category(R.drawable.search,"Discovery"));
        listCategory.add(new Category(R.drawable.ship,"Ship"));
        listCategory.add(new Category(R.drawable.tea,"Drinks"));
        listCategory.add(new Category(R.drawable.caricon,"CarDelivery"));

        list.add(new ListCategory(listCategory));

        return list;

    }
}