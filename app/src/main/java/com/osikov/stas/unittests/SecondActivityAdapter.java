package com.osikov.stas.unittests;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.osikov.stas.unittests.presenter.Order;

import java.util.LinkedList;
import java.util.List;

public class SecondActivityAdapter extends AppCompatActivity {

    List<Order> data = new LinkedList<>();
    ListView listView;
    TextView textView;

    private ArrayAdapter<Order> mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity_layout);
        for (int i = 0; i < 100; i++){
            Order order = new Order();
            order.setName("Order name " + "" + i);
            order.setDescription("Order description " + "" + i);
            data.add(order);
        }
        textView = findViewById(R.id.textview);
        listView = findViewById(R.id.lvMain);
        mAdapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, data);
        listView.setAdapter(mAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Object item = adapterView.getItemAtPosition(i);
                textView.setText(item.toString());
                Toast.makeText(getApplicationContext(), "You've selected " + i, Toast.LENGTH_SHORT).show();
            }
        });
    }

}
