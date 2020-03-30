package com.example.mysalatapp1;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    private ListView listView;
    private String[] listNames;
    private String[] salatDescription;
    private SearchView searchView;

    ArrayAdapter<String>adapter;

     int[] imgs ={R.drawable.salat,R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.m,
            R.drawable.e,R.drawable.f,R.drawable.g,R.drawable.h,R.drawable.i,
            R.drawable.j,R.drawable.k,R.drawable.list};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        listView=(ListView)findViewById(R.id.listViewId);

        searchView=(SearchView)findViewById(R.id.searchViewId);

        listNames =getResources().getStringArray(R.array.salatList_names);

        salatDescription =getResources().getStringArray(R.array.Salat_description);

        adapter=new ArrayAdapter<String>(Main2Activity.this,R.layout.sample,R.id.salatListId,listNames);

        listView.setAdapter(adapter);




        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                adapter.getFilter().filter(newText);
                return false;
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //String value=adapter.getItem(position);
                String value= listNames [position];
                Toast.makeText(Main2Activity.this,value+" "+position,Toast.LENGTH_SHORT).show();

                Intent intent=new Intent(Main2Activity.this,Description.class);
                intent.putExtra("salat_names",listNames[position]);
                intent.putExtra("salat_description",salatDescription[position]);
                intent.putExtra("description_images",imgs[position]);
                startActivity(intent);
            }
        });

    }

}


