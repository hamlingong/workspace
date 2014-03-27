package com.yfz;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;

import com.yfz.view.MyView;

public class TopFrame extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button button = (Button) findViewById(R.id.bt);
        button.setOnClickListener(onclick);
    }

    private MyView tv = null;
    OnClickListener onclick = new OnClickListener() {

        @Override
        public void onClick(View v) {
            if (tv != null && tv.isShown()) {
                WindowManager wm = (WindowManager) getApplicationContext().getSystemService(
                        TopFrame.this.WINDOW_SERVICE);
                wm.removeView(tv);
            }
            show();

        }
    };

    private void show() {
        Rect frame = new Rect();
        getWindow().getDecorView().getWindowVisibleDisplayFrame(frame);
        MyView.TOOL_BAR_HIGH = frame.top;

        WindowManager wm = (WindowManager) getApplicationContext().getSystemService(WINDOW_SERVICE);
        WindowManager.LayoutParams params = MyView.params;
        WindowManager.LayoutParams paramsTmp = MyView.params;

        params.type = WindowManager.LayoutParams.TYPE_SYSTEM_ERROR;
        params.width = WindowManager.LayoutParams.FILL_PARENT;
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        params.alpha = 80;

        params.gravity = Gravity.LEFT | Gravity.TOP;
        params.x = 100;
        params.y = 100;
        tv = new MyView(TopFrame.this);
        Resources res = getResources();
        tv.setBackgroundColor(res.getColor(com.yfz.R.color.red));
        wm.addView(tv, paramsTmp);
        params.flags &= (~WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE);
        params.flags |= WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL;
        wm.updateViewLayout(tv, params);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}