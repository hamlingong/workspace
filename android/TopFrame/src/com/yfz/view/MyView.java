package com.yfz.view;

import android.content.Context;
import android.content.res.Resources;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.yfz.R;

public class MyView extends LinearLayout {
    public static int TOOL_BAR_HIGH = 0;
    public static WindowManager.LayoutParams params = new WindowManager.LayoutParams();

    WindowManager wm = (WindowManager) (getContext().getApplicationContext()
            .getSystemService(getContext().WINDOW_SERVICE));

    public MyView(Context context) {
        super(context);
        con = context;

        setOrientation(LinearLayout.HORIZONTAL);

        init();
        updateView(false);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                y = event.getY();
                break;
            case MotionEvent.ACTION_UP: {
                float nowY = event.getY();
                if (!change) {
                    if (nowY > y) {
                        updateView(true);
                        updatePositon();
                        change = true;
                    } else if (nowY < y) {
                        wm.removeView(this);
                    }
                } else {
                    if (nowY < y) {
                        updateView(false);
                        updatePositon();
                        change = false;
                    }
                }
            }
                break;
            default:
                break;
        }

        return true;
    }

    public void onClick(View v) {
        int id = v.getId();

        switch (id) {
            case 103: // more ==> 更多资讯
            case 201: // cancel ==> 不再提醒
            case 202: // later ==> 稍后提醒
                wm.removeView(this);
                break;
            default:
                break;
        }
    }

    private void init() {
        LinearLayout left = new LinearLayout(con);
        left.setId(100);
        left.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams leftParams =
                new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        addView(left, leftParams);
        createLeftContent(left);

        LinearLayout rightTop = new LinearLayout(con);
        rightTop.setId(200);
        rightTop.setOrientation(LinearLayout.HORIZONTAL);
        rightTop.setGravity(Gravity.RIGHT);
        LinearLayout.LayoutParams rightTopParams =
                new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        addView(rightTop, rightTopParams);
        createRightContent(rightTop, true);

        RelativeLayout right = new RelativeLayout(con);
        right.setId(300);
        right.setGravity(Gravity.RIGHT);
        LinearLayout.LayoutParams rightParams =
                new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        addView(right, rightParams);
        createRightContent(right, false);
    }

    private void updateView(boolean showAll) {
        if (!showAll) {
            LinearLayout ll = (LinearLayout) (findViewById(100).findViewById(102));
            ll.setVisibility(GONE);
            ll = (LinearLayout) (findViewById(100).findViewById(103));
            ll.setVisibility(GONE);

            ll = (LinearLayout) (findViewById(200));
            ll.setVisibility(VISIBLE);
            RelativeLayout rl = (RelativeLayout) (findViewById(300));
            rl.setVisibility(GONE);
        } else {
            LinearLayout ll = (LinearLayout) (findViewById(100).findViewById(102));
            ll.setVisibility(VISIBLE);
            ll = (LinearLayout) (findViewById(100).findViewById(103));
            ll.setVisibility(VISIBLE);

            ll = (LinearLayout) (findViewById(200));
            ll.setVisibility(GONE);
            RelativeLayout rl = (RelativeLayout) (findViewById(300));
            rl.setVisibility(VISIBLE);
        }
    }

    private void createLeftContent(LinearLayout container) {
        Resources res = con.getResources();
        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

        LinearLayout title = new LinearLayout(con);
        title.setId(101);
        title.setLayoutParams(params);
        title.setOrientation(LinearLayout.HORIZONTAL);
        title.setGravity(Gravity.CENTER_VERTICAL);
        container.addView(title);
        String titleStr = "本月账单快到了";
        initSetion(title, res.getDimension(R.dimen.title_size), titleStr, R.drawable.notice_icon);

        LinearLayout detail = new LinearLayout(con);
        detail.setId(102);
        detail.setLayoutParams(params);
        detail.setOrientation(LinearLayout.HORIZONTAL);
        detail.setGravity(Gravity.CENTER_VERTICAL);
        container.addView(detail);

        LinearLayout distance = new LinearLayout(con);
        distance.setLayoutParams(params);
        distance.setOrientation(LinearLayout.HORIZONTAL);
        distance.setGravity(Gravity.CENTER_VERTICAL);
        detail.addView(distance);
        String distanceStr = "0.7km";
        initSetion(distance, res.getDimension(R.dimen.detail_size), distanceStr, R.drawable.distance_icon);

        LinearLayout description = new LinearLayout(con);
        description.setLayoutParams(params);
        description.setOrientation(LinearLayout.HORIZONTAL);
        description.setGravity(Gravity.CENTER_VERTICAL);
        detail.addView(description);
        String descriptionStr = "02-29187-878";
        initSetion(description, res.getDimension(R.dimen.detail_size), descriptionStr, R.drawable.phone_icon);

        LinearLayout more = new LinearLayout(con);
        more.setId(103);
        more.setLayoutParams(params);
        more.setOrientation(LinearLayout.HORIZONTAL);
        more.setGravity(Gravity.CENTER_VERTICAL);
        container.addView(more);
        String moreStr = "更多资讯";
        initSetion(more, res.getDimension(R.dimen.detail_size), moreStr, R.drawable.more_icon);
    }

    public class CancelClickListener implements View.OnClickListener {
        public CancelClickListener(MyView myView) {
            this.myView = myView;
        }
        @Override
        public void onClick(View paramView) {
            myView.wm.removeView(myView);
        }
        private MyView myView;
    };

    private void createRightContent(ViewGroup container, boolean isTop) {
        ImageView cancel = new ImageView(con);
        cancel.setId(201);
        cancel.setImageResource(R.drawable.cancel_icon);
        cancel.setOnClickListener(new CancelClickListener(this));

        ImageView later = new ImageView(con);
        later.setId(202);
        later.setImageResource(R.drawable.later_icon);

        if (isTop) {
            container.addView(later);
            container.addView(cancel);
        } else {
            RelativeLayout.LayoutParams cancelParams =
                    new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            cancelParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
            container.addView(cancel, cancelParams);

            RelativeLayout.LayoutParams laterParams =
                    new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            laterParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
            container.addView(later, laterParams);
        }
    }

    private void initSetion(LinearLayout layout, float textsize, String textstr, int iconID) {
        ImageView image = new ImageView(con);
        image.setImageResource(iconID);
        layout.addView(image);

        TextView text = new TextView(con);
        text.setText(textstr);
        text.setTextSize(textsize);
        Resources res = con.getResources();
        text.setTextColor(res.getColor(R.color.darkblack));
        LinearLayout.LayoutParams textParams =
                new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        textParams.gravity = Gravity.CENTER_VERTICAL;
        layout.addView(text);
    }

    private void updatePositon() {
        wm.updateViewLayout(this, params);
    }

    private Context con;
    private float y;
    boolean change = false;
}
