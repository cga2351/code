package com.dxtx.test;

/**
 * Created by user on 2016/7/15.
 * 视频录制
 */

import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.RequiresApi;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.dxtx.codec.R;
import com.dxtx.test.record.CameraUtils;
import com.dxtx.test.record.VideoRecordTask;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

@RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class TakeVideoActivity2 extends Activity implements SurfaceHolder.Callback, View.OnClickListener, Camera.PreviewCallback {
    private static final String TAG = "px";
    //拍照文件缓存路径
    private String fileCachePath;
    private long videoCreateTime;
    private SurfaceView surfaceView;
    private Button recordButton;
    private Button unRecordButton;
    private Button previewButton;
    private TextView timeSecondView, curTimeView;    //显示时间的文本框
    private ProgressBar progressBar;

    //    private CameraManager mCameraManager;
    private Camera camera;
    Camera.Parameters parameters;

    private Point mPreviewSize;

    private VideoRecordTask recordTask;

    private State state = State.None;

    private enum State {
        None, Priview, Recorde, Complete;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //全屏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);   //应用运行时，保持屏幕高亮，不锁屏
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_take_video);

        //获取控件
        surfaceView = (SurfaceView) findViewById(R.id.surfaceview);
        recordButton = (Button) findViewById(R.id.btn_start_record);
        unRecordButton = (Button) findViewById(R.id.btn_stop_record);
        previewButton = (Button) findViewById(R.id.btn_preview);
        recordButton.setOnClickListener(this);
        unRecordButton.setOnClickListener(this);
        previewButton.setOnClickListener(this);

        timeSecondView = (TextView) findViewById(R.id.time);
        curTimeView = (TextView) findViewById(R.id.tv_time);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setMax(MaxDuring);

        SurfaceHolder holder = surfaceView.getHolder();
        holder.addCallback(this);
        holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);

        startTime();

        //获取支持480p视频
        mPreviewSize = CameraUtils.initSupportProfile();
        Log.d("-mqmsdebug", "mPreviewSize=" + mPreviewSize);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        //保持预览和视频长宽比一致,不拉伸压缩失真
        surfaceView.getLayoutParams().height=mPreviewSize.x * dm.widthPixels / mPreviewSize.y;
//        surfaceView.setLayoutParams(new RelativeLayout.LayoutParams(-1, ));

        fileCachePath = getIntent().getStringExtra("fileCachePath");

        recordTask = new VideoRecordTask(fileCachePath, this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        try {
            camera = Camera.open(Camera.CameraInfo.CAMERA_FACING_BACK);
            parameters = CameraUtils.setupCameraParams(camera, mPreviewSize);
            camera.setPreviewDisplay(holder);
            camera.startPreview();
        } catch (Exception e) {
            Log.w(TAG, "Can not openDriver: " + e.getMessage());
            e.printStackTrace();
            camera.stopPreview();
            camera.release();
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        Log.d(TAG, "surfaceChanged");
        if (camera == null) {
            return;
        }
        Log.d("px", "mPreviewSize=" + mPreviewSize);
        byte[] previewBuf = new byte[mPreviewSize.x * mPreviewSize.y * 3 / 2];
        camera.addCallbackBuffer(previewBuf);
        camera.setPreviewCallback(this);

        int decodeColor = CameraUtils.preview2deocode(parameters.getPreviewFormat());

        recordTask.setVideoPreviewSizeColor(mPreviewSize.x, mPreviewSize.y, decodeColor);
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        Log.d(TAG, "surfaceDestroyed");
        if (camera != null) {
            try {
                camera.setPreviewDisplay(null);
                task.cancel();
                timer.cancel();
                camera.stopPreview();
                camera.release();
                camera = null;
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        try {
            if (id == R.id.btn_start_record) {
                startRecorder();
            } else if (id == R.id.btn_stop_record) {
                if (state == State.Recorde)
                    stopRecorder();
                else if (state == State.Complete)
                    complete();
            } else if (id == R.id.btn_preview) {
                playVideo();
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (camera != null) {
                try {
                    camera.setPreviewDisplay(null);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                camera.stopPreview();
                camera.release();
            }
        }
    }

    private void startRecorder() {
        if (state == State.Recorde) {
            return;
        }
        if (state == State.Complete) {
            camera.startPreview();//重拍启动预览,这里主要启动对焦程序,如果不启动,则manager不知道已经启动,在stop的时候不会关闭预览
        }

        recordTask.start();

        state = State.Recorde;
        unRecordButton.setVisibility(View.VISIBLE);
        recordButton.setVisibility(View.GONE);
        previewButton.setVisibility(View.GONE);
        unRecordButton.setText("停止");
    }


    private void stopRecorder() {
        if (state == State.Recorde) {
            Log.d("px", "------------stopRecorder--------------------");

            recordTask.finishRecord();
            camera.stopPreview();

            state = State.Complete;
            previewButton.setVisibility(View.VISIBLE);
            unRecordButton.setVisibility(View.VISIBLE);
            recordButton.setVisibility(View.VISIBLE);
            unRecordButton.setText("完成");
            recordButton.setText("重拍");
        }
    }

    private void playVideo() {
        //预览录像
        Intent intent = new Intent(Intent.ACTION_VIEW);
        String type = "video/mp4";
        Uri uri = Uri.parse("file://" + fileCachePath);
        intent.setDataAndType(uri, type);
        startActivity(intent);
    }

    private void complete() {
        //告诉调用者结果
        Intent intent = new Intent();
        intent.putExtra("fileCachePath", fileCachePath);
        intent.putExtra("videoCreateTime", videoCreateTime);
        setResult(RESULT_OK, intent);
        finish();

    }


    //////////////////显示时间信息的代码
    SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    Timer timer = new Timer();
    private int curTimeSecond = MaxDuring;
    private static final int MaxDuring = 60;
    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            String s = format.format(new Date());
            handler.obtainMessage(CHANGE_TIME, s).sendToTarget();
        }
    };

    private static final int CHANGE_TIME = 111;
    Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            switch (msg.what) {
                case CHANGE_TIME:
                    if (state == State.Recorde) {
                        curTimeSecond--;
                        if (curTimeSecond == 0) {
                            stopRecorder();
                            return false;
                        }
                        if (timeSecondView.getVisibility() != View.VISIBLE) {
                            timeSecondView.setVisibility(View.VISIBLE);
                        }
                        timeSecondView.setText(CameraUtils.secondToText(curTimeSecond));
                        progressBar.setProgress(MaxDuring - curTimeSecond);
                    } else if (timeSecondView.getVisibility() == View.VISIBLE) {
                        timeSecondView.setVisibility(View.INVISIBLE);
                        curTimeSecond = MaxDuring;
                        progressBar.setProgress(0);
                    }
                    curTimeView.setText(msg.obj.toString());
                    break;
            }
            return false;
        }
    });


    @Override
    public void onBackPressed() {
        if (state != State.Recorde) {
            setResult(RESULT_CANCELED);
            finish();
        }
    }

    void startTime() {
        timer.schedule(task, 0, 1000);
    }
    //////////////////////////////////////


    @Override
    public void onPreviewFrame(byte[] data, Camera camera) {
        if (state == State.Recorde) {
            recordTask.captureImg(data, mPreviewSize.x, mPreviewSize.y);
        }
    }
}
