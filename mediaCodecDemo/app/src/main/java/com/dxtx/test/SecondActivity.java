package com.dxtx.test;

import android.Manifest;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by user on 2018/7/11.
 */

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ImageView view = new ImageView(this);
        setContentView(view);
        String path = Environment.getExternalStorageDirectory().getAbsolutePath();
        Log.d("px", "path->" + path);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA, Manifest.permission.RECORD_AUDIO}, 123);

        view.postDelayed(new Runnable() {
            @Override
            public void run() {
                test();
                String path = Environment.getExternalStorageDirectory().getAbsolutePath();
                Log.d("px", "path->" + path);
                int[] buf = new int[318 * 318];
                NativeUtils.testImg(path + "/faceapp/20180530/20180530-3.jpg", buf, "2018/07/12 12:55:66");
                Log.d("px", "buf.length=" + buf.length);
                Bitmap bitmap = Bitmap.createBitmap(318, 318, Bitmap.Config.RGB_565);
                bitmap.setPixels(buf, 0, 318, 0, 0, 318, 318);
                view.setImageBitmap(bitmap);
            }
        }, 5000);

    }

    private void test() {
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
        String text = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date());
        NativeUtils.fixFontFile(ttfPath);
        NativeUtils.fixTextArea(text);
    }
}
