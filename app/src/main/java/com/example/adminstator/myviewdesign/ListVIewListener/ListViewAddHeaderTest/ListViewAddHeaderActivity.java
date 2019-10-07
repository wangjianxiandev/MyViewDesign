package com.example.adminstator.myviewdesign.ListVIewListener.ListViewAddHeaderTest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.adminstator.myviewdesign.R;

public class ListViewAddHeaderActivity extends AppCompatActivity {

    private ListView listView;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_add_header);
        getWindow().getDecorView().setPadding(8, 0, 8, 0);
        listView = findViewById(R.id.list_header);
        textView = new TextView(this);
        textView.setText("WJX");
        String[] arrs = {
                "aaa",
                "bbb",
                "ccc",
                "ddd",
                "eee",
                "fff",
                "ggg",
                "hhh"
        };
        View headerView = getLayoutInflater().inflate(R.layout.list_header_view, null);
        Button button = headerView.findViewById(R.id.header_button);
        TextView headerTextView = headerView.findViewById(R.id.header_text);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter(this, R.layout.array_item, arrs);
        listView.addHeaderView(headerView);
        listView.setAdapter(arrayAdapter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                headerTextView.setVisibility(View.GONE);
            }
        });
    }
}
