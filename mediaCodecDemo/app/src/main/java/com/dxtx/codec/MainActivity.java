package com.dxtx.codec;

import android.Manifest.permission;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.dxtx.test.TakeVideoActivity2;
import com.dxtx.test.NativeUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity {
    private static final int TakeVideoCode = 111;
    private TextView srcTV;
    TextView dstTV;
    private String dir;
    private VideoCodecModel video;
    private ProgressBar bar;

    private android.os.Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            VideoCodecModel video = (VideoCodecModel) msg.obj;
            switch (msg.what) {
                case VideoCodecTask2.PROGRESS:
                    bar.setMax(msg.arg2);
                    bar.setProgress(msg.arg1);
                    break;
                case VideoCodecTask2.START:
                    Log.d("px", "codec start");
                    break;
                case VideoCodecTask2.COMPLETE:
                    Log.d("px", "codec complete");
                    break;
                case VideoCodecTask2.ERROR:
                    Log.d("px", "codec error");
                    break;
                case VideoCodecTask2.CANCEL:
                    Log.d("px", "codec cancel");
                    break;
            }
        }


    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();

        //因为是demo,直接请求权限,防止无权限奔溃
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if ((PackageManager.PERMISSION_GRANTED != checkSelfPermission(permission.WRITE_EXTERNAL_STORAGE)) ||
                    (PackageManager.PERMISSION_GRANTED != checkSelfPermission(permission.CAMERA)) ||
                    (PackageManager.PERMISSION_GRANTED != checkSelfPermission(permission.RECORD_AUDIO))) {
                ActivityCompat.requestPermissions(this, new String[]{permission.WRITE_EXTERNAL_STORAGE, permission.CAMERA, permission.RECORD_AUDIO}, 123);
            }
        }


        //复制ttf文件到缓存中去,ndk不能直接通过地址访问assets内容,但可以通过缓存路径,ttf给中文水印使用
        //因为是demo,所以在主线程操作了
        String ttfPath = this.getExternalCacheDir().getAbsolutePath() + "/msyh.ttf";
        File ttf = new File(ttfPath);
        if (!ttf.exists()) {
            try {
                ttf.createNewFile();
                InputStream in = getAssets().open("msyh.ttf");
                OutputStream out = new FileOutputStream(ttf);

                byte bt[] = new byte[1024];
                int c;
                while ((c = in.read(bt)) > 0) {
                    out.write(bt, 0, c);
                }
                in.close();
                out.flush();
                out.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //配置ndk助手使用字体
        NativeUtils.fixFontFile(ttfPath);
    }


    private void initView() {
        dstTV = (TextView) findViewById(R.id.dst);
        srcTV = (TextView) findViewById(R.id.et1);
        bar = (ProgressBar) findViewById(R.id.progressBar);
    }

    private void initData() {
        dir = Environment.getExternalStorageDirectory().getAbsolutePath() + "/";
        dstTV.setText("加水印后路径" + dir + "nihao.mp4");
    }

    public void onTakeVideo(View v) {
        String fileCachePath = dir + "nihao_no_water_mark.mp4";
        File file = new File(fileCachePath);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        if (file.exists()) {
            file.delete();
        }
        Intent intent = new Intent(this, TakeVideoActivity2.class);
        intent.putExtra("fileCachePath", fileCachePath);
        startActivityForResult(intent, TakeVideoCode);
    }

    public void onClick(View v) {
        if (video == null) {
            Toast.makeText(this, "还没拍摄", Toast.LENGTH_SHORT).show();
            return;
        }
        VideoCodecTask2 task = new VideoCodecTask2(video);
        task.setProgressHandler(handler);

        task.start();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case TakeVideoCode:
                if (resultCode == RESULT_OK) {
                    video = new VideoCodecModel();
                    video.dstPath = dir + "nihao.mp4";

                    String srcPath = data.getStringExtra("fileCachePath");
                    long videoCreateTime = data.getLongExtra("videoCreateTime", 0);

                    video.srcPath = srcPath;
                    video.videoCreateTime = videoCreateTime;
                }
                break;
        }
    }

}
