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
// * a sample adapter with multi viewType
// *
// * @author davidleen29
// * @创建时间 2013年11月14日
// */
//public class TestMultiViewTypeAdapter extends AbstractAdapter<Card> {
//
//    public TestMultiViewTypeAdapter(Context context, List<Card> cards) {
//        super(context, cards);
//
//    }
//
//    @Override
//    protected int getItemViewLayout(int itemViewType) {
//        switch (itemViewType) {
//            case 0:
//                return R.layout.list_item_number_type;
//            default:
//                return R.layout.list_item_member_type;
//        }
//    }
//
//    @Override
//    protected BaseViewHolder<Card> getItemViewHolder(int itemViewType) {
//        switch (itemViewType) {
//            case 0:
//                return new NumberTypeBinder();
//            default:
//                return new MemberTypeBinder();
//        }
//
//    }
//
//    /**
//     * get viewType of the position
//     * depend on your bussiness;
//     */
//    @Override
//    public int getItemViewType(int position) {
//        Card card = getItem(position);
//        return card.type == Card.NUMBER_TYPE ? 0 : 1;
//
//    }
//
//    /**
//     * view type count here 2 String.NUMBER_TYPE String.NUMBER_TYPE
//     */
//    @Override
//    public int getViewTypeCount() {
//        return 2;
//    }
//
//    /**
//     * number type view binder
//     *
//     * @author davidleen29
//     * @创建时间 2013年11月14日
//     */
//    class NumberTypeBinder implements BaseViewHolder<Card> {
//        TextView textView;
//
//        @Override
//        public void setData(Card data, int position) {
//            textView.setText(data.toString());
//        }
//
//    }
//
//    /**
//     * number type view binder
//     *
//     * @author davidleen29
//     * @创建时间 2013年11月14日
//     */
//    class MemberTypeBinder implements BaseViewHolder<Card> {
//        TextView textView;
//
//        @Override
//        public void setData(Card data, int position) {
//            textView.setText(data.toString());
//        }
//    }
//}
