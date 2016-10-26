package com.bawei.dapter;

import android.content.Context;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.bawei.y.MainActivity;
import com.bawei.y.R;

import java.util.List;

import bean.Bean;

/**
 * Created by haokuanyi on 2016/9/26.
 */
public class MyListAdapter extends BaseAdapter {
    private final List<Bean.DataBean> dataList;
    private final Context context;
    private Bean.DataBean dataBean;


    public MyListAdapter(Context context, List<Bean.DataBean> dataList) {
        this.context = context;
        this.dataList = dataList;

    }
//数量
    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
//每个条目的适配
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = View.inflate(context, R.layout.list_item, null);
            holder.checkBox = (CheckBox) convertView.findViewById(R.id.list_item_checkbox);
            holder.title = (TextView) convertView.findViewById(R.id.list_item_title);
            holder.price = (TextView) convertView.findViewById(R.id.list_item_price);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        dataBean = dataList.get(position);
        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public int zj;
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //点击为选中状态的时候重新遍历数据进行算钱
                if (isChecked) {
                    dataList.get(position).setCb(true);
                    zj = 0;
                    for (int i = 0; i < dataList.size(); i++) {
                        if (dataList.get(i).getCb()) {
                            zj += (int) (10 * Float.parseFloat(dataList.get(i)
                                    .getMoney()));
                        }
                    }
                } else {
                    //点击为非选中状态的时候遍历进行计算价格
                    dataList.get(position).setCb(false);
                    zj = 0;
                    for (int i = 0; i < dataList.size(); i++) {
                        if (dataList.get(i).getCb()) {
                            zj += (int) (10 * Float.parseFloat(dataList.get(i)
                                    .getMoney()));
                        }
                    }
                }
                MainActivity.main_zong.setText(zj / 10.0 + "元");
            }
        });
        //设置点击状态
        holder.checkBox.setChecked(dataBean.getCb());
        //设置标题
        holder.title.setText(dataBean.getTitle());
        //设置价格
        holder.price.setText(dataBean.getMoney() + "元");
        return convertView;
    }
//优化
    class ViewHolder {
        CheckBox checkBox;
        TextView title, price;
    }


}
