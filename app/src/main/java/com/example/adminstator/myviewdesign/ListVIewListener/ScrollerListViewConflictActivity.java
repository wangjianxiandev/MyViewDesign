package com.example.adminstator.myviewdesign.ListVIewListener;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.adminstator.myviewdesign.R;

public class ScrollerListViewConflictActivity extends AppCompatActivity {
    private ListView listView;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroller_list_view_conflict);
        listView = (ListView) findViewById(R.id.listviewscroll);
        textView = (TextView) findViewById(R.id.result);
        String[] arr = {
                "a",
                "b",
                "c",
                "d",
                "e",
                "f",
                "g"
        };
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.array_item, arr);
        listView.setAdapter(arrayAdapter);
        setListViewHeightBaseOnChildren(listView);
    }

    /**
     * 动态计算ListView中的item的高度，在计算总高度
     *
     * @param listView
     */
    public void setListViewHeightBaseOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            return;
        }
        int totalHeight = 0;
        for (int i = 0, size = listAdapter.getCount(); i < size; i++) {
            View item = listAdapter.getView(i, null, listView);
            item.measure(0, 0);
            totalHeight += item.getMeasuredHeight();
        }
        ViewGroup.LayoutParams layoutParams = listView.getLayoutParams();
        layoutParams.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        layoutParams.height += 5;
        listView.setLayoutParams(layoutParams);
    }

}
