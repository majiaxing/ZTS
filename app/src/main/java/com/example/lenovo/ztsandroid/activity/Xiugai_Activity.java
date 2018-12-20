package com.example.lenovo.ztsandroid.activity;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.FileProvider;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.ztsandroid.App;
import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.adapter.List_popup_Adapter;
import com.example.lenovo.ztsandroid.base.BaseActivity;
import com.example.lenovo.ztsandroid.cotract.Lu_SC_Cotract;
import com.example.lenovo.ztsandroid.cotract.TouX_SC_Cotract;
import com.example.lenovo.ztsandroid.model.entity.LiY_SC_WJ_Bean;
import com.example.lenovo.ztsandroid.model.entity.SC_YX_Bean;
import com.example.lenovo.ztsandroid.model.entity.Spinner_Bean;
import com.example.lenovo.ztsandroid.presenter.Sc_Lu_Presenter;
import com.example.lenovo.ztsandroid.presenter.Sc_toux_file_Presenter;
import com.example.lenovo.ztsandroid.presenter.Use_Toux_Presenter;
import com.example.lenovo.ztsandroid.utils.MyLog;
import com.example.lenovo.ztsandroid.utils.TakePhotoUtils;
import com.example.lenovo.ztsandroid.view.CircleImageView;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.lenovo.ztsandroid.R.id.imageView;

/**
 * Created by Administrator on 2018/11/29.
 */
public class Xiugai_Activity extends BaseActivity implements TouX_SC_Cotract.View{


    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.back_jt)
    ImageView backJt;
    @BindView(R.id.XG_Toux_text)
    TextView XGTouxText;
    @BindView(R.id.XG_toux_image)
    CircleImageView XGTouxImage;
    @BindView(R.id.touxiang_xg)
    LinearLayout touxiangXg;
    @BindView(R.id.XG_mingc_text)
    TextView XGMingcText;
    @BindView(R.id.XG_YonghMs)
    TextView XGYonghMs;
    @BindView(R.id.mingc_xg)
    LinearLayout mingcXg;
    @BindView(R.id.XG_xued_text)
    TextView XGXuedText;
    @BindView(R.id.XG_Xd)
    TextView XGXd;
    @BindView(R.id.xued_xg)
    LinearLayout xuedXg;
    @BindView(R.id.XG_nj_text)
    TextView XGNjText;
    @BindView(R.id.XG_Nj)
    TextView XGNj;
    @BindView(R.id.nianji_xg)
    LinearLayout nianjiXg;
    LinearLayout linearParent;

    private Uri imageUri = null;
    private TouX_SC_Cotract.Presenter presenter;
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static final int REQUEST_EXTERNAL_STORAGET = 2;
    private static String[] PERMISSIONS_STORAGE = {
            "android.permission.WRITE_EXTERNAL_STORAGE",
            "android.permission.RECORD_AUDIO"
    };
    private File file;
    private String student;

    public static void verifyStoragePermissions(Activity activity) {

        try {
            //检测是否有写的权限
            int permission = ActivityCompat.checkSelfPermission(activity,
                    "android.permission.WRITE_EXTERNAL_STORAGE");
            if (permission != PackageManager.PERMISSION_GRANTED) {
                // 没有写的权限，去申请写的权限，会弹出对话框
                ActivityCompat.requestPermissions(activity, PERMISSIONS_STORAGE,REQUEST_EXTERNAL_STORAGE);
                ActivityCompat.requestPermissions(activity, PERMISSIONS_STORAGE,REQUEST_EXTERNAL_STORAGET);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    @Override
    protected int getLayoutId() {
        verifyStoragePermissions(App.activity);
        return R.layout.xg_zil_activity;
    }

    @Override
    protected void initView() {

        linearParent = (LinearLayout) findViewById(R.id.linear_parent);
        Intent intent = getIntent();
        student = intent.getStringExtra("student");
    }

    @Override
    public void initData() {

    }

    @Override
    public void loadData() {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {


        if (resultCode == RESULT_CANCELED) {

            Toast.makeText(App.activity, "点击取消从相册选择", Toast.LENGTH_LONG).show();
            return;
        }
        switch (requestCode){
            case 2:
                // 获得图片

                try {
                    //该uri就是照片文件夹对应的uri
                    Bitmap bit = BitmapFactory.decodeStream(getContentResolver().openInputStream(imageUri));
                    // 给相应的ImageView设置图片 未裁剪
                    XGTouxImage.setImageBitmap(bit);
//                    String[] proj = { MediaStore.Images.Media.DATA };
//
//                    Cursor actualimagecursor = managedQuery(TakePhotoUtils.imageUri,proj,null,null,null);
//
//                    int actual_image_column_index = actualimagecursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
//
//                    actualimagecursor.moveToFirst();
//
//                    String img_path = actualimagecursor.getString(actual_image_column_index);
//
//                    File file = new File(img_path);
//
//                    presenter = new Sc_Lu_Presenter(this);
//                    presenter.seturl(file,"1","homework/45670/41/");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 1:

                try {
                    Uri imageUri = data.getData();
                    Log.e("TAG", imageUri.toString());
                    XGTouxImage.setImageURI(imageUri);
                    String[] proj = { MediaStore.Images.Media.DATA };

                    Cursor actualimagecursor = managedQuery(imageUri,proj,null,null,null);

                    int actual_image_column_index = actualimagecursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);

                    actualimagecursor.moveToFirst();

                    String img_path = actualimagecursor.getString(actual_image_column_index);

                    file = new File(img_path);

                    presenter = new Use_Toux_Presenter(this);
                    presenter.SetU(student, "", App.stuid);

                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }

        super.onActivityResult(requestCode, resultCode, data);

    }

    public void choosePhoto(){
        Intent intentToPickPic = new Intent(Intent.ACTION_PICK, null);
        // 如果限制上传到服务器的图片类型时可以直接写如："image/jpeg 、 image/png等的类型" 所有类型则写 "image/*"
        intentToPickPic.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/jpeg");
        startActivityForResult(intentToPickPic, 1);
    }


    public  Uri takePhoto(Activity mActivity, int flag)  {
        //指定拍照intent
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        if (takePictureIntent.resolveActivity(mActivity.getPackageManager()) != null) {
            String sdcardState = Environment.getExternalStorageState();
            File outputImage = null;
            if (Environment.MEDIA_MOUNTED.equals(sdcardState)) {
                try {
                    outputImage = createImageFile(mActivity);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                Toast.makeText(mActivity.getApplicationContext(), "内存异常", Toast.LENGTH_SHORT).show();
            }
            try {
                if (outputImage.exists()) {
                    outputImage.delete();
                }
                outputImage.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (outputImage != null) {
                imageUri = Uri.fromFile(outputImage);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
                mActivity.startActivityForResult(takePictureIntent, flag);
            }
        }

        return imageUri;
    }





    public static  File createImageFile(Activity mActivity) throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp;//创建以时间命名的文件名称
        File storageDir = getOwnCacheDirectory(mActivity, "takephoto");//创建保存的路径
        File image = new File(storageDir.getPath(), imageFileName + ".jpg");
        if (!image.exists()) {
            try {
                //在指定的文件夹中创建文件
                image.createNewFile();
            } catch (Exception e) {
            }
        }

        return image;
    }


    /**
     * 根据目录创建文件夹
     * @param context
     * @param cacheDir
     * @return
     */
    public static File getOwnCacheDirectory(Activity context, String cacheDir) {
        File appCacheDir = null;
        //判断sd卡正常挂载并且拥有权限的时候创建文件
        if ( Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState()) && hasExternalStoragePermission(context)) {
            appCacheDir = new File(Environment.getExternalStorageDirectory(), cacheDir);
        }
        if (appCacheDir == null || !appCacheDir.exists() && !appCacheDir.mkdirs()) {
            appCacheDir = context.getCacheDir();
        }
        return appCacheDir;
    }


    /**
     * 检查是否有权限
     * @param context
     * @return
     */
    private static boolean hasExternalStoragePermission(Context context) {
        int perm = context.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE");
        return perm == 0;
    }

    /**
     * 获取压缩图片的options
     *
     * @return
     */
    public static BitmapFactory.Options getOptions(String path) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(path, options);
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        options.inSampleSize = 4;      //此项参数可以根据需求进行计算
        options.inJustDecodeBounds = false;

        return options;
    }

    public  PopupWindow popupWindow;

    public  void upPopupWindow(View view) {
        View v = LayoutInflater.from(App.activity).inflate(R.layout.xg_touxiang_popup, null);
        popupView(v);
        popupWindow = new PopupWindow(v, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        popupWindow.setFocusable(true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable()); // 响应返回键必须的语句

        popupWindow.showAtLocation(view, Gravity.BOTTOM, 0, 0);


    }





    public  void popupView(View v) {

        TextView textView1 = v.findViewById(R.id.btn_take_photo);
        TextView textView2 = v.findViewById(R.id.btn_pick_photo);
        TextView textView3 = v.findViewById(R.id.btn_cancel);


        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                try {

                    TakePhotoUtils.imageUri = null;
                    takePhoto(App.activity,2);
//
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }

                popupWindow.dismiss();
            }
        });

        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choosePhoto();
                popupWindow.dismiss();
            }
        });

        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.touxiang_xg, R.id.mingc_xg, R.id.xued_xg, R.id.nianji_xg})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.touxiang_xg:
                upPopupWindow(view);
                break;
            case R.id.mingc_xg:

                break;
            case R.id.xued_xg:
                break;
            case R.id.nianji_xg:
                break;
        }
    }

    @Override
    public void getManager(LiY_SC_WJ_Bean xq_bean) {

        MyLog.e("获取到的路径",xq_bean.getData().getSave_path() + "");

        presenter = new Sc_toux_file_Presenter(this);
        presenter.seturl(file,"1",xq_bean.getData().getSave_path());
    }

    @Override
    public void getWJSC(SC_YX_Bean sc_yx_bean) {

    }

    @Override
    public void showmessage(String str) {

    }

    @Override
    public void setBasePresenter(TouX_SC_Cotract.Presenter presenter) {

    }
}
