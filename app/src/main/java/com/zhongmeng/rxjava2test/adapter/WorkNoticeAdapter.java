package com.zhongmeng.rxjava2test.adapter;

import android.content.Context;

import com.zhongmeng.rxjava2test.R;
import com.zhongmeng.rxjava2test.bean.Work;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.List;

/**
 * author :rcw.
 * date :2017/10/12 14:53.
 */

public class WorkNoticeAdapter extends CommonAdapter {
    //private String platType;
    private List<Work.TjdbListBean> datas;
    public WorkNoticeAdapter(Context context, int layoutId, List<Work.TjdbListBean> datas) {
        super(context, layoutId, datas);
        this.datas=datas;
        //platType= SaveUserInfo.getInstance().getType();
    }

    @Override
    protected void convert(ViewHolder holder, Object o, final int position) {
            switch (position){
                case 0:
                    holder.setText(R.id.title,datas.get(position).getTypeName()+"("+datas.get(position).getNeednumber()+")");
                    break;
                case 1:
                    holder.setText(R.id.title,datas.get(position).getTypeName()+"("+datas.get(position).getCurrentnumber()+")");
                    break;
        }



        /*LinearLayout linearLayout=holder.getView(R.id.item);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LogUtils.z("URL="+datas.get(position).getUrl()+"posion="+position);
            }
        });*/
    }

}
