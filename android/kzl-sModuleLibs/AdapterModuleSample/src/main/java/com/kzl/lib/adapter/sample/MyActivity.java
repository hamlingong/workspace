package com.kzl.lib.adapter.sample;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import com.kzl.lib.adapter.base.UnMixable;
import com.kzl.lib.adapter.base.ViewInjectorByReflect;
import com.kzl.lib.adapter.sample.model.Card;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MyActivity extends Activity {
    ViewHolder holder;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        holder = new ViewHolder();
        ViewInjectorByReflect.injectView(holder, getWindow().getDecorView());

        testSingleViewAdapter();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        testMultiViewAdapter();
                    }
                });
            }
        }, 3000);
    }

    private void testSingleViewAdapter() {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            list.add("content" + i);
        }

        TestSingleViewAdapter adapter = new TestSingleViewAdapter(this.getApplicationContext(), list);
        holder.list_view.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void testMultiViewAdapter() {
        List<Card> list = new ArrayList<Card>();
        Random r = new Random();
        Card temp;
        for (int i = 0, count = 10; i < count; i++) {
            temp = new Card();
            temp.type = r.nextInt(3);
            list.add(temp);
        }

        TestMultiViewTypeAdapter adapter = new TestMultiViewTypeAdapter(this.getApplicationContext(), list);
        holder.list_view2.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private class ViewHolder implements UnMixable {
        ListView list_view, list_view2;
    }
}
