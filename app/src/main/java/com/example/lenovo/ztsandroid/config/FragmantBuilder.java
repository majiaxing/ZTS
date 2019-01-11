package com.example.lenovo.ztsandroid.config;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.example.lenovo.ztsandroid.App;
import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.base.BaseFragment;


/**
 * Created by Lenovo on 2017/5/12.
 */

public class FragmantBuilder {

    private static FragmantBuilder builder;
    private int containerViewId;
    private BaseFragment lastFragment;
    private BaseFragment fragment;
//构造方法（无参）
    private FragmantBuilder() {

    }
    //构造方法（有参）
    public static FragmantBuilder getInstance() {
        if (builder == null) {
            synchronized (FragmantBuilder.class) {

                if (builder == null)
                    builder = new FragmantBuilder();
            }
        }

        return builder;
    }

    public FragmantBuilder containerId(int containerViewId) {
        this.containerViewId = containerViewId;
        return this;
    }
//    动态管理 开始fragment 方法
    public FragmantBuilder start(Class<? extends BaseFragment> fragmentClass) {

        FragmentManager fragmentManager = App.activity.getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        String simpleName = fragmentClass.getSimpleName();
        fragment = (BaseFragment) fragmentManager.findFragmentByTag(simpleName);
        if (fragment == null) {
            try {
                //Java动态代理创建对象
                fragment = fragmentClass.newInstance();

                transaction.add(R.id.FrameLayout, fragment, simpleName);

            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        //隐藏上一个fragment
        if (lastFragment != null)
            transaction.hide(lastFragment);

        //显示当前的Fragment
        transaction.show(fragment);
        transaction.addToBackStack(simpleName);
        lastFragment = fragment;
        transaction.commit();
        return this;
    }

    public BaseFragment getLastFragment() {
        return lastFragment;
    }

    public void setLastFragment(BaseFragment lastFragment) {
        this.lastFragment = lastFragment;
    }

    public void setParams(Bundle bundle) {
        fragment.setParams(bundle);
    }

}
