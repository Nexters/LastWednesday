package com.teamnexters.lastwednesday.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import com.teamnexters.lastwednesday.R;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by user on 2018-01-21.
 */

public class SearchActivity extends AppCompatActivity{
ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ListView lv = (ListView)findViewById(R.id.ListViewPlays);
        ArrayList<String> arrayPlays = new ArrayList<>();
        arrayPlays.addAll(Arrays.asList(getResources().getStringArray(R.array.array_plays)));

        adapter = new ArrayAdapter<String>(SearchActivity.this,
                android.R.layout.simple_expandable_list_item_1,
                arrayPlays);
        lv.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search, menu);
        MenuItem item = menu.findItem(R.id.menuSearch);
        SearchView searchView = (SearchView)item.getActionView();

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
        return super.onCreateOptionsMenu(menu);
    }
}
