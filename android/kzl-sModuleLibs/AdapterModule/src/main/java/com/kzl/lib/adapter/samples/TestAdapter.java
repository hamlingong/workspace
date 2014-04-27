//package com.zushou.android.phone.adapter.samples;
//
//import android.content.Context;
//import android.widget.TextView;
//import com.zushou.android.phone.R;
//import com.zushou.android.phone.adapter.base.AbstractAdapter;
//
//import java.util.List;
//
///**
// * Created by Administrator on 14-3-18.
// */
//public class TestAdapter extends AbstractAdapter<String>{
//
//    public TestAdapter(Context context) {
//        super(context);
//    }
//
//    public TestAdapter(Context context, List<String> list) {
//        super(context, list);
//    }
//
//    @Override
//    protected int getItemViewLayout(int itemViewType) {
//        return R.layout.test;
//    }
//
//    @Override
//    protected BaseViewHolder<String> getItemViewHolder(int itemViewType) {
//        return new TestBinder();
//    }
//
//    /**
//     * number type view binder
//     *
//     * @author davidleen29
//     * @创建时间 2013年11月14日
//     */
//    class TestBinder implements BaseViewHolder<String> {
//        TextView name;
//        TextView nick;
//        @Override
//        public void setData(String data, int position) {
//            // here do all your bind obj
//            name.setText(data);
//            nick.setText(data);
//        }
//    }
//}
