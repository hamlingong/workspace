//package com.zushou.android.phone.adapter.samples;
//
//import android.content.Context;
//import android.widget.TextView;
//import com.zushou.android.phone.R;
//import com.zushou.android.phone.adapter.base.AbstractAdapter;
//import com.zushou.android.phone.view.User;
//
//import java.util.List;
//
///**
// * a sample adapter without multi viewType
// * just ignore the param itemViewType;
// *
// * @author davidleen29
// * @创建时间 2013年11月14日
// */
//public class SimpleAdapterWithoutViewType extends AbstractAdapter<User> {
//
//    public SimpleAdapterWithoutViewType(Context context) {
//        super(context);
//    }
//
//    public SimpleAdapterWithoutViewType(Context context, List<User> cards) {
//        super(context, cards);
//
//    }
//
//    @Override
//    protected int getItemViewLayout(int itemViewType) {
//        return R.layout.test;
//
//    }
//
//    @Override
//    protected BaseViewHolder<User> getItemViewHolder(int itemViewType) {
//
//        return new NumberTypeBinder();
//
//    }
//
//    /**
//     * number type view binder
//     *
//     * @author davidleen29
//     * @创建时间 2013年11月14日
//     */
//    class NumberTypeBinder implements BaseViewHolder<User> {
//        TextView cardType;
//
//        @Override
//        public void setData(User data, int position) {
//            // here do all your bind obj
//            cardType.setText(data.toString());
//        }
//
//    }
//
//}
