package com.example.lenovo.ztsandroid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.model.entity.Spinner_Bean;

import java.util.List;

/**
 * Created by Administrator on 2018/11/7.
 */

public class Kw_Xq_Adapter extends BaseAdapter {

    private List<Spinner_Bean> mList;
    private Context mContext;

    public Kw_Xq_Adapter(List<Spinner_Bean> mList, Context mContext) {
        this.mList = mList;
        this.mContext = mContext;
    }



    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int i) {
        return mList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater _LayoutInflater=LayoutInflater.from(mContext);
        view=_LayoutInflater.inflate(R.layout.kw_ld_spinner_item, null);
        if(view!=null)
        {
            TextView _TextView1=(TextView)view.findViewById(R.id.QH_title);
            _TextView1.setText(mList.get(i).getPersonName());
        }
        return view;
    }


}
