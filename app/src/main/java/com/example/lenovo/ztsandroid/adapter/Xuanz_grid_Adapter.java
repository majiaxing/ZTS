package com.example.lenovo.ztsandroid.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.ztsandroid.App;
import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.model.entity.Spinner_Bean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/11/9.
 */

public class Xuanz_grid_Adapter extends BaseAdapter {

    private Context context;
    public ArrayList<Spinner_Bean> channels;
    public Xuanz_grid_Adapter(Context context, ArrayList<Spinner_Bean> channels) {
        this.context = context;
        this.channels = channels;
    }


    private int temp = -6;

    @Override
    public int getCount() {
        // TODO  Auto-generated method stub
        return channels.size();
    }

    @Override
    public Object getItem(int position)  {
        // TODO Auto-generated method stub
        return  null;
    }

    @Override
    public long getItemId(int  position) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public View  getView(int position, View convertView, ViewGroup parent) {
        Holder holder;
        if(convertView == null){
            convertView =App.activity.getLayoutInflater().inflate(R.layout.xz_grid_item,  null);
            holder = new Holder();
            convertView.setTag(holder);
        }else{
            holder =  (Holder) convertView.getTag();
        }

        holder.text = (TextView) convertView.findViewById(R.id.Xuanz_text);
        holder.text.setText(channels.get(position).getPersonName());
        holder.text.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(App.activity, "button", Toast.LENGTH_SHORT).show();
            }
        });

        holder.radioButton = convertView.findViewById(R.id.Xuanz_btn);
//        holder.radioButton.setId(position);
        holder.radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()  {

            @Override
            public  void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked){
                    if(temp != -6){
                        RadioButton tempButton =  (RadioButton) App.activity.findViewById(buttonView.getId());
                        tempButton.setChecked(false);

                    }


                    Log.i("*****************","you are women- -   " +  isChecked + "   " + temp);
                    //如果点击了ListView条目，在这里拿到Position做想要的操作...
                }
            }
        });
        return  convertView;
    }
    private class Holder{
        private TextView text;
        private RadioButton radioButton;
    }
}
