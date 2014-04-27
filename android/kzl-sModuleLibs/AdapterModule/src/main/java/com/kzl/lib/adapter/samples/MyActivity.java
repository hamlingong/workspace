//package com.kzl.lib.adapter.samples;
//
//import android.app.Activity;
//import android.os.Bundle;
//import android.os.Handler;
//import android.widget.ListView;
//import com.kzl.lib.adapter.sample.R;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Random;
//
//public class MyActivity extends Activity {
//    /**
//     * Called when the activity is first created.
//     */
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.main);
//        testSingleViewAdapter();
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        testMultiViewAdapter();
//                    }
//                });
//            }
//        }, 3000);
//    }
//
//    private void testSingleViewAdapter() {
//        List<String> list = new ArrayList<String>();
//        for (int i = 0; i < 10; i++) {
//            list.add("content" + i);
//        }
//
//        ListView listView = (ListView) findViewById(R.id.list_view);
//        TestSingleViewAdapter adapter = new TestSingleViewAdapter(this.getApplicationContext(), list);
//        listView.setAdapter(adapter);
//        adapter.notifyDataSetChanged();
//    }
//
//    private void testMultiViewAdapter() {
//        List<Card> list = new ArrayList<Card>();
//        Random r = new Random();
//        Card temp;
//        for (int i = 0, count = 10; i < count; i++) {
//            temp = new Card();
//            temp.type = r.nextInt(3);
//            list.add(temp);
//        }
//
//        ListView listView = (ListView) findViewById(R.id.list_view2);
//        TestMultiViewTypeAdapter adapter = new TestMultiViewTypeAdapter(this.getApplicationContext(), list);
//        listView.setAdapter(adapter);
//        adapter.notifyDataSetChanged();
//    }
//}
