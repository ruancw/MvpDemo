package com.zhongmeng.rxjava2test.adapter;

import android.content.Context;

import com.zhongmeng.rxjava2test.R;
import com.zhongmeng.rxjava2test.bean.Notice;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.List;

/**
 * author :rcw.
 * date :2017/10/12 14:53.
 */

public class NoticeAdapter extends CommonAdapter {
    private List<Notice.NoticeListBean> datas;
    public NoticeAdapter(Context context, int layoutId, List<Notice.NoticeListBean> datas) {
        super(context, layoutId, datas);
        this.datas=datas;
    }

    @Override
    protected void convert(ViewHolder holder, Object o, final int position) {
        holder.setText(R.id.notic_name,datas.get(position).getTitle());
        holder.setText(R.id.notic_date,datas.get(position).getNotice_date());
        /*LinearLayout linearLayout=holder.getView(R.id.item);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LogUtils.z("URL="+datas.get(position).getUrl()+"posion="+position);
            }
        });*/
    }

}
