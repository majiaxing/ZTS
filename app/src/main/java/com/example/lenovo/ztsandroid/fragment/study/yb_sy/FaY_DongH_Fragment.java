package com.example.lenovo.ztsandroid.fragment.study.yb_sy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lenovo.ztsandroid.App;
import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2018/12/23.
 */
public class FaY_DongH_Fragment extends BaseFragment {
    @BindView(R.id.image)
    ImageView image;
    @BindView(R.id.YB_Nr)
    TextView YBNr;
    Unbinder unbinder;
    private Bundle bundle;
    @Override
    protected int getLayoutId() {
        return R.layout.fay_dongh_frsgment;
    }
    @Override
    protected void init(View view) {


        String relative_path = bundle.getString("relative_path");
        String yb_photo = bundle.getString("yb_photo");
        String bofUrl = "https://zts100.com/demo/file/download"+"/?"+"Relative_path="+relative_path+"&"+"type=1"+"&"+"fileName="+yb_photo;

        String ybTranslate = bundle.getString("yb_translate");

        YBNr.setText(ybTranslate);

        Glide.with(App.activity).load(bofUrl).asGif().into(image);
    }

    @Override
    protected void loadData() {

    }

    @Override
    public void setParams(Bundle bundle) {
        this.bundle = bundle;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
