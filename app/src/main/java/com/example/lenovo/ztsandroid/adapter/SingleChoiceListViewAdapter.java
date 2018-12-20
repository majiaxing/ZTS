package com.example.lenovo.ztsandroid.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.lenovo.ztsandroid.App;
import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.base.BaseFragment;
import com.example.lenovo.ztsandroid.model.entity.Spinner_Bean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/11/12.
 */

public class SingleChoiceListViewAdapter extends BaseAdapter {


    private ArrayList<Spinner_Bean> strings;
    private Activity activity;
    private int temp = -1;//记录每次点击的按钮的Id

    public SingleChoiceListViewAdapter(Activity activity, ArrayList<Spinner_Bean> strings) {
        this.strings = strings;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return strings.size();
    }

    @Override
    public Object getItem(int position) {
        return strings.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(App.activity).inflate(R.layout.xz_tm_item, null);
            viewHolder.textView = (TextView) convertView.findViewById(R.id.Xuanz_nr);
            viewHolder.radioButton = (RadioButton) convertView.findViewById(R.id.Xuanz_btn);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.textView.setText(strings.get(position).getPersonName());
        viewHolder.radioButton.setId(position);//把RadioButton的Id设置为position
        viewHolder.radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {//如果是选中状态
                    if (temp != -1) {//temp不为-1，说明已经进行过点击事件
                        RadioButton tempButton = (RadioButton) App.activity.findViewById(temp);
                        if (tempButton != null) {
                            tempButton.setChecked(false);//取到上一次点击的RadioButton，并设置为未选中状态
                        }
                    }
                    temp = buttonView.getId();//将temp重新赋值，记录下本次点击的RadioButton
                }
            }
        });
        if (position == temp) {
            viewHolder.radioButton.setChecked(true);//将本次点击的RadioButton设置为选中状态
        } else {
            viewHolder.radioButton.setChecked(false);
        }
        return convertView;
    }

    final class ViewHolder {
        public TextView textView;
        public RadioButton radioButton;
    }



}
