package com.clancy.conor.foodrater;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        RecyclerView recyclerView = findViewById(R.id.recycler_view); // name as per content main
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setHasFixedSize(true);

        //TODO: Connect the RecycleView to our NameAdapter
        final FoodAdapter foodAdapter = new FoodAdapter();
        recyclerView.setAdapter(foodAdapter);


            foodAdapter.addFood();

            foodAdapter.addFood();

            foodAdapter.addFood();



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Adding new food ", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                try{
                    foodAdapter.addFood();
                }catch (Exception ex){
                    Log.e("Error on contact", ex.getMessage());
                }

            }
        });
    }



}
