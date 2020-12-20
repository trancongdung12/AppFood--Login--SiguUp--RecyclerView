package com.example.appfood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class AppActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView rcvCatecvory;
    ArrayList<Category> arrayList;

    private RecyclerView rcvFood;
    private Button recentBtn,nearbyBtn;
    private GridLayoutManager gridLayoutManager;

    int icons[] = {R.drawable.search,R.drawable.ship,R.drawable.tea,R.drawable.caricon};
    String iconsName[] = {"Chrome", "Google Drive", "Facebook", "Twitter"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcvCatecvory = findViewById(R.id.main_rcv);
        arrayList = new ArrayList<>();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        rcvCatecvory.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false));
        rcvCatecvory.setItemAnimator(new DefaultItemAnimator());

        for (int i = 0; i < icons.length; i++) {
            Category itemModel = new Category();
            itemModel.setResourceId(icons[i]);
            itemModel.setTitle(iconsName[i]);

            //add in array list
            arrayList.add(itemModel);
        }

        CategoryAdapter adapter = new CategoryAdapter(getApplicationContext(), arrayList);
        rcvCatecvory.setAdapter(adapter);


        //Food

        recentBtn = findViewById(R.id.recent);
        nearbyBtn = findViewById(R.id.nearby);

        rcvFood = findViewById(R.id.rcv_food);
         gridLayoutManager = new GridLayoutManager(this,2);
        rcvFood.setLayoutManager(gridLayoutManager);

        FoodAdapter foodAdapter = new FoodAdapter(getListFood());
        rcvFood.setAdapter(foodAdapter);

        recentBtn.setOnClickListener(this);
        nearbyBtn.setOnClickListener(this);
    }

    private List<Food> getListFood() {

        List<Food> list= new ArrayList<>();

        list.add(new Food(R.drawable.chao,"Cháo sườn","Cháo là món ăn rất ngon",Food.TypeNearBy));
        list.add(new Food(R.drawable.chao,"Cháo sườn","Cháo là món ăn rất ngon",Food.TypeNearBy));
        list.add(new Food(R.drawable.chao,"Cháo sườn","Cháo là món ăn rất ngon",Food.TypeNearBy));
        list.add(new Food(R.drawable.chao,"Cháo sườn","Cháo là món ăn rất ngon",Food.TypeNearBy));
        list.add(new Food(R.drawable.chao,"Cháo sườn","Cháo là món ăn rất ngon",Food.TypeNearBy));
        list.add(new Food(R.drawable.chao,"Cháo sườn","Cháo là món ăn rất ngon",Food.TypeNearBy));

        list.add(new Food(R.drawable.banhmi,"Bánh mì","Bán mì là món ngon của việt nam",Food.TypeRecent));
        list.add(new Food(R.drawable.banhmi,"Bánh mì","Bán mì là món ngon của việt nam",Food.TypeRecent));
        list.add(new Food(R.drawable.banhmi,"Bánh mì","Bán mì là món ngon của việt nam",Food.TypeRecent));
        list.add(new Food(R.drawable.banhmi,"Bánh mì","Bán mì là món ngon của việt nam",Food.TypeRecent));
        list.add(new Food(R.drawable.banhmi,"Bánh mì","Bán mì là món ngon của việt nam",Food.TypeRecent));
        list.add(new Food(R.drawable.banhmi,"Bánh mì","Bán mì là món ngon của việt nam",Food.TypeRecent));
        list.add(new Food(R.drawable.banhmi,"Bánh mì","Bán mì là món ngon của việt nam",Food.TypeRecent));
        list.add(new Food(R.drawable.banhmi,"Bánh mì","Bán mì là món ngon của việt nam",Food.TypeRecent));
        list.add(new Food(R.drawable.banhmi,"Bánh mì","Bán mì là món ngon của việt nam",Food.TypeRecent));




        return list;
    }

    @Override
    public void onClick(View v) {
            switch (v.getId()){
                case R.id.recent:
                    scrollToItem(0);
                break;
                case R.id.nearby:
                    scrollToItem(7);
                    break;
            }
    }

    private void scrollToItem(int index) {
        if(gridLayoutManager == null)
        {
            return;
        }
        gridLayoutManager.scrollToPositionWithOffset(index,0);
    }


    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()){
                case R.id.home:
                    Toast.makeText(AppActivity.this, "Home", Toast.LENGTH_SHORT).show(); break;
                case R.id.profile:
                    Intent myIntent = new Intent(getApplicationContext(), ProfileActivity.class);
                    startActivity(myIntent);
                    overridePendingTransition(0, 0);
                    break;
            }
            return true;
        }
    };
}