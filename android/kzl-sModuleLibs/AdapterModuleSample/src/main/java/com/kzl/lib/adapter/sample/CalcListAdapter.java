package com.kzl.lib.adapter.sample;//package com.kzl.lib.adapter.sample;
//
//import android.content.Context;
//import android.widget.TextView;
//import com.zushou.android.phone.adapter.base.AbstractAdapter;
//import com.zushou.android.phone.utils.utils.StringUtils;
//
//import java.util.List;
//
///**
// * Project:ZuShou365_phone
// * Email: <A href="kezhenlu@qq.com">kezhenlu@qq.com</A><br/>
// * User: kenny.ke
// * Date: 14-3-31<br/>
// * Time: 下午5:10<br/>
// * To change this template use File | Settings | File Templates.
// */
//public class CalcListAdapter extends AbstractAdapter<String> {
//    public CalcListAdapter(Context context, List<String> list) {
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
//        TextView tv_item_money, tv_item_month;
//
//        @Override
//        public void setData(String bean, int position) {
//            tv_item_month.setText("第" + (position + 1) + "个月还款");
//            tv_item_money.setText(StringUtils.getDecimalFormat(getItem(position), StringUtils.MONEY_DECIMAL_FORMAT));
//        }
//    }
//}
