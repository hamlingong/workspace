//package com.kzl.lib.adapter.samples;
//
//import android.content.Context;
//import android.widget.TextView;
//import com.kzl.lib.adapter.base.AbstractAdapter;
//import com.kzl.lib.adapter.base.BaseViewHolder;
//import com.kzl.lib.adapter.sample.R;
//
//import java.util.List;
//
///**
// * Project:trunk
// * Email: <A href="kezhenlu@qq.com">kezhenlu@qq.com</A><br/>
// * User: kenny.ke
// * Date: 14-4-2<br/>
// * Time: 下午8:54<br/>
// * To change this template use File | Settings | File Templates.
// */
//public class TestSimpleAdapter extends AbstractAdapter<String> {
//
//    public TestSimpleAdapter(Context context, List<String> list) {
//        super(context, list);
//    }
//
//    @Override
//    protected int getItemViewLayout(int itemViewType) {
//        return R.layout.item_calculate_result;
//    }
//
//    @Override
//    protected BaseViewHolder<String> getItemViewHolder(int itemViewType) {
//        return new MyViewHolder();
//    }
//
//    class MyViewHolder implements BaseViewHolder<String> {
//        TextView text_view;
//
//        @Override
//        public void setData(String bean, int position) {
//            text_view.setText("position==" + position + "--bean == " + bean);
//        }
//    }
//}
