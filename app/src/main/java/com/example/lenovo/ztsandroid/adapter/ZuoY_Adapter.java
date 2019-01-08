package com.example.lenovo.ztsandroid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import com.example.lenovo.ztsandroid.App;
import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.model.entity.Spinner_Bean;
import com.example.lenovo.ztsandroid.model.entity.Spinner_Zuoy_Bean;
import com.example.lenovo.ztsandroid.utils.MyLog;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/11/2.
 */

public class ZuoY_Adapter extends BaseAdapter {

    private Context context;
    public ArrayList<Spinner_Zuoy_Bean> channels;
    private ArrayList<Spinner_Zuoy_Bean.DataBean> mlist = new ArrayList<>();
    private ZuoY_Item_Adapter adapter;
    private Map<String ,ArrayList<Spinner_Zuoy_Bean.DataBean>> map = new HashMap<>();


    public ZuoY_Adapter(Context context, ArrayList<Spinner_Zuoy_Bean> channels,Map<String ,ArrayList<Spinner_Zuoy_Bean.DataBean>> map) {
        this.context = context;
        this.channels = channels;
        this.map = map;
    }

    @Override
    public int getCount() {
        return channels.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if (view == null){
            viewHolder = new ViewHolder();
            view = LayoutInflater.from(context).inflate(R.layout.zuoy_item,null);
            viewHolder.textView = view.findViewById(R.id.type);
            viewHolder.gridView = view.findViewById(R.id.Grid_item);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }

        Spinner_Zuoy_Bean liveBean = channels.get(i);

        viewHolder.textView.setText(liveBean.getType());

        switch (liveBean.getType()){
            case "音标":
                mlist.clear();
                mlist.addAll( map.get("yb_typeList"));
                MyLog.e("输出这个map",map.toString()  + "");
                break;
            case "课文":
                mlist.clear();
                mlist.addAll( map.get("kw_typeList"));
//                adapter = new ZuoY_Item_Adapter(context, mlist);
//                viewHolder.gridView.setAdapter(adapter);
//                adapter.notifyDataSetChanged();
                break;
         case "单词":
             mlist.clear();
             mlist.addAll( map.get("dc_typeList"));
//             adapter = new ZuoY_Item_Adapter(context, mlist);
//             viewHolder.gridView.setAdapter(adapter);
//             adapter.notifyDataSetChanged();
                break;
         case "句子":
             mlist.clear();
             mlist.addAll( map.get("jz_typeList"));
//             adapter = new ZuoY_Item_Adapter(context, mlist);
//             viewHolder.gridView.setAdapter(adapter);
//             adapter.notifyDataSetChanged();
                break;
         case "对话":
             mlist.clear();
             mlist.addAll( map.get("dh_typeList"));
//             adapter = new ZuoY_Item_Adapter(context, mlist);
//             viewHolder.gridView.setAdapter(adapter);
//             adapter.notifyDataSetChanged();

                break;
         case "听力":
             mlist.clear();
             mlist.addAll( map.get("tl_typeList"));
//             adapter = new ZuoY_Item_Adapter(context, mlist);
//             viewHolder.gridView.setAdapter(adapter);
//             adapter.notifyDataSetChanged();
                break;
            case "阅读":
                mlist.clear();
                mlist.addAll( map.get("yd_typeList"));
//                adapter = new ZuoY_Item_Adapter(context, mlist);
//                viewHolder.gridView.setAdapter(adapter);
//                adapter.notifyDataSetChanged();

                break;
                case "短语":
                    mlist.clear();
                    mlist.addAll( map.get("dy_typeList"));
//                    adapter = new ZuoY_Item_Adapter(context, mlist);
//                    viewHolder.gridView.setAdapter(adapter);
//                    adapter.notifyDataSetChanged();
                break;
        }
        final Boolean[] bbb = {false};
        adapter = new ZuoY_Item_Adapter(context, mlist);
        viewHolder.gridView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        final ViewHolder finalViewHolder = viewHolder;

        viewHolder.gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                View view1 = finalViewHolder.gridView.getChildAt(position);
                TextView textView = view1.findViewById(R.id.T_H);
                TextView textView_XZ = view1.findViewById(R.id.T_H_XZ);


                textView_XZ.setVisibility(View.VISIBLE);
                textView.setVisibility(View.GONE);
//                }
            }
        });


        return view;
    }

    static class ViewHolder {
        public TextView textView;
        private GridView gridView;
    }

}
