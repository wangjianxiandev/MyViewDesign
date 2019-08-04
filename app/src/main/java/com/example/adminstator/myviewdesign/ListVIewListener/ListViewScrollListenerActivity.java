package com.example.adminstator.myviewdesign.ListVIewListener;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.adminstator.myviewdesign.R;

public class ListViewScrollListenerActivity extends AppCompatActivity {

    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_scroll_listener);
        listView = (ListView)findViewById(R.id.listview);
        String[] arr ={
                "aaa",
                "bbb",
                "ccc",
                "ddd",
                "eee"
        };
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.array_item, arr);
        listView.setAdapter(arrayAdapter);
        listView.setOnScrollListener(new ListView.OnScrollListener() {
            /**
             * 监听ListView的滑动状态的改变，滑动存在三种状态
             * SCROLL_STATE_IDLE：ListView滑动停止 0
             * SCROLL_STATE_TOUCH_SCROLL：手指正在拖动ListVIew 1
             * SCROLL_STATE_FLING：ListView正在自由滑动 2
             * @param view
             * @param scrollState
             */
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                Log.d("WJX", "scrollState: "+ scrollState);
            }

            /**
             * @param view
             * @param firstVisibleItem：表示屏幕中第一条显示的数据在adapter中的位置
             * @param visibleItemCount：表示屏幕中显示的数据的数目
             * @param totalItemCount：则是在adapter中的总条数
             */
            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                Log.d("WJX", "firstVisibleItem:"+firstVisibleItem+" "+"visibleItemCount:"+visibleItemCount+" "+"totalItemCount:"+totalItemCount);
            }
        });
    }
    private int calItemHeight(ListView listView){
        int totalHeight = 0;
        ListAdapter listAdapter = listView.getAdapter();
        if(listAdapter == null){
            return 0;
        }
        for(int i = 0, size = listAdapter.getCount(); i < size; i++){
            View item = listAdapter.getView(i, null, listView);
            item.measure(0, 0);
            totalHeight += item.getMeasuredHeight();
        }
        return  totalHeight;

    }
}
