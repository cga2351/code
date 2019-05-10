package com.dxtx.codec;

/**
 * Created by user on 2016/7/15.
 * 视频录制
 */

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.ImageFormat;
import android.hardware.Camera;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class TakeVideoActivity extends Activity implements SurfaceHolder.Callback, View.OnClickListener {
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
    private MediaRecorder mRecorder;

    //    private CameraManager mCameraManager;
    private Camera camera;
    private int mPreviewWidth;
    private int mPreviewHeight;

    private String localdir = Environment.getExternalStorageDirectory().getAbsolutePath() + "/jrzhuxue/video/";

    private State state = State.None;

    private enum State {
        None, Priview, Recorde, Complete;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        //全屏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);   //应用运行时，保持屏幕高亮，不锁屏
        super.onCreate(savedInstanceState);
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
//        mCameraManager = new CameraManager(this);


        SurfaceHolder holder = surfaceView.getHolder();
        holder.addCallback(this);
        holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);

        startTime();

//        serNo = "src123456";
        //获取支持480p视频
        initSupportProfile();
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        //保持预览和视频长宽比一致,不拉伸压缩失真
        surfaceView.setLayoutParams(new FrameLayout.LayoutParams(-1, mVideoHeiht * dm.widthPixels / mVideoWidth, Gravity.TOP));

        fileCachePath = getIntent().getStringExtra("fileCachePath");
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        try {
            // Indicate camera, our View dimensions
//            mCameraManager.openDriver(holder, 720, 1280);
//            mCameraManager.openDriver(holder, mVideoWidth, mVideoHeiht);
            camera = Camera.open();
            showSupportVideoSize(camera);

            camera.stopPreview();
            camera.setDisplayOrientation(90); // Portrait mode
            camera.setPreviewDisplay(holder);
            camera.startPreview();
        } catch (Exception e) {
            Log.w(TAG, "Can not openDriver: " + e.getMessage());
            camera.stopPreview();
            camera.release();
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        Log.d(TAG, "surfaceChanged");

        if (hasResult) {
            return;
        }
        if (holder.getSurface() == null) {
            Log.e(TAG, "Error: preview surface does not exist");
            return;
        }

        //preview_width = width;
        //preview_height = height;

        mPreviewWidth = camera.getParameters().getPreviewSize().width;
        mPreviewHeight = camera.getParameters().getPreviewSize().height;
        Log.d("px", "mPreviewWidth=" + mPreviewWidth + ",mPreviewHeight=" + mPreviewHeight);

//        mCameraManager.stopPreview();
//        camera.setDisplayOrientation(90); // Portrait mode
//
//        mCameraManager.startPreview();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        Log.d(TAG, "surfaceDestroyed");
        if (camera != null) {
            try {
                camera.setPreviewDisplay(null);
            } catch (IOException e) {
                e.printStackTrace();
            }
            camera.stopPreview();
            camera.release();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        try {
            task.cancel();
            timer.cancel();
            if (camera != null) {
                camera.setPreviewDisplay(null);
                camera.stopPreview();
                camera.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
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
                    skipToCodec();
            } else if (id == R.id.btn_preview) {
                previewVideo();
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
        // 关闭预览并释放资源
        Camera c = camera;
//        c.setPreviewDisplay(null);
//        c.stopPreview();
        c.unlock();
//        camera.release();
//        mCameraManager.closeDriver();

        mRecorder = new MediaRecorder();
        mRecorder.reset();


        mRecorder.setCamera(c);
//        mRecorder.setProfile(CamcorderProfile.get(CamcorderProfile.QUALITY_720P));
        //.设置采集声音
//        mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        //设置采集图像
        mRecorder.setVideoSource(MediaRecorder.VideoSource.CAMERA);
        //.设置视频，音频的输出格式
//        mRecorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
        //.设置音频的编码格式
//        mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AAC);
        //设置图像的编码格式
//        mRecorder.setVideoEncoder(MediaRecorder.VideoEncoder.MPEG_4_SP);
        //设置立体声
//        mRecorder.setAudioChannels();
        //设置最大录像时间 单位：毫秒

//        mRecorder.setMaxFileSize(*);
        //音频一秒钟包含多少数据位
//        mRecorder.setAudioEncodingBitRate();

        mRecorder.setProfile(CamcorderProfile.get(mQuality));//尼玛setProfile解决一切,参数并不应该自己设
        // 设置视频录制的分辨率。必须放在设置编码和格式的后面，否则报错
//        mRecorder.setVideoSize(720, 1280);
        // 设置录制的视频帧率。必须放在设置编码和格式的后面，否则报错
//        mRecorder.setVideoFrameRate(30);
//        mRecorder.setVideoEncodingBitRate(1024 * 512);

//        mRecorder.setPreviewDisplay(surfaceView.getHolder().getSurface());
        //设置选择角度，顺时针方向，因为默认是逆向度的，这样图像就是正常显示了,这里设置的是观看保存后的视频的角度
        mRecorder.setOrientationHint(90);
        videoCreateTime = System.currentTimeMillis();
        Log.d("px", "video cache path:" + fileCachePath);
        try {
            File file = new File(fileCachePath);
            if (!file.getParentFile().exists()) file.getParentFile().mkdirs();
            if (file.exists()) file.delete();
            file.createNewFile();

            mRecorder.setOutputFile(file.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            mRecorder.prepare();
            mRecorder.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
        state = State.Recorde;
        unRecordButton.setVisibility(View.VISIBLE);
        recordButton.setVisibility(View.GONE);
        previewButton.setVisibility(View.GONE);
        unRecordButton.setText("停止");
    }


    private void stopRecorder() {
        if (state == State.Recorde) {
            Log.d("px", "------------stopRecorder--------------------");
            //停止录制
            mRecorder.stop();
            //释放资源
            mRecorder.release();
            mRecorder = null;
            camera.stopPreview();

            state = State.Complete;
            previewButton.setVisibility(View.VISIBLE);
            unRecordButton.setVisibility(View.VISIBLE);
            recordButton.setVisibility(View.VISIBLE);
            unRecordButton.setText("完成");
            recordButton.setText("重拍");
        }
    }

    private void previewVideo() {
        //预览录像
        Intent intent = new Intent(Intent.ACTION_VIEW);
        String type = "video/mp4";
        Uri uri = Uri.parse("file://" + fileCachePath);
        intent.setDataAndType(uri, type);
        startActivity(intent);
    }

    private void skipToCodec() {


        //告诉调用者结果
        Intent intent = new Intent();
        intent.putExtra("fileCachePath", fileCachePath);
        intent.putExtra("videoCreateTime", videoCreateTime);
        String thumpPath = new String(fileCachePath);

        thumpPath = thumpPath.replace(".mp4", ".jpg");
        thumpPath = thumpPath.replace("/video/", "/thump/");
        Log.d("px", "thumpPath=" + thumpPath);
        saveBitmapWithName(getVideoThumbnail(fileCachePath), thumpPath);
        intent.putExtra("thumpPath", thumpPath);

        setResult(RESULT_OK, intent);
        finish();

    }

    private boolean hasResult = false;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 0x123 && resultCode == RESULT_OK) {
            hasResult = true;
            Intent intent = new Intent();
            intent.putExtra("fileCachePath", fileCachePath);
            setResult(RESULT_OK, intent);
            new File(fileCachePath).delete();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    finish();
                }
            }, 250);
        }
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
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case CHANGE_TIME:
                    if (state == State.Recorde) {
                        curTimeSecond--;
                        if (curTimeSecond == 0) {
                            stopRecorder();
                            return;
                        }
                        if (timeSecondView.getVisibility() != View.VISIBLE) {
                            timeSecondView.setVisibility(View.VISIBLE);
                        }
                        timeSecondView.setText(secondToText(curTimeSecond));
                        progressBar.setProgress(MaxDuring - curTimeSecond);
                    } else if (timeSecondView.getVisibility() == View.VISIBLE) {
                        timeSecondView.setVisibility(View.INVISIBLE);
                        curTimeSecond = MaxDuring;
                        progressBar.setProgress(0);
                    }
                    curTimeView.setText(msg.obj.toString());
                    break;
            }
        }
    };

    String secondToText(int second) {
        if (second < 10) {
            return " 00:0" + second;
        } else if (second < 60) {
            return " 00:" + second;
        } else {
            return " 01:" + second % 60;
        }
    }

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


    private int mQuality = -1;

    private void showSupportVideoSize(Camera camera) {
        Camera.Parameters p = camera.getParameters();
        List<Camera.Size> videoSizes = p.getSupportedVideoSizes();
        if (videoSizes != null) {
            StringBuilder sb = new StringBuilder("SupportedVideoSizes:[");
            for (Camera.Size s : videoSizes) {
                sb.append(s.width).append("*").append(s.height).append(",");
            }
            Log.d("px", sb.deleteCharAt(sb.length() - 1).toString());
        } else {
            Log.d("px", "SupportedVideoSizes:null");
        }
        List<Integer> formats = p.getSupportedPreviewFormats();
        if (formats.contains(ImageFormat.NV21))
            p.setPreviewFormat(ImageFormat.NV21);
    }

    private int mVideoWidth, mVideoHeiht;

    private void initSupportProfile() {

        if (CamcorderProfile.hasProfile(CamcorderProfile.QUALITY_TIME_LAPSE_480P)) {//无声音的480p
            mQuality = CamcorderProfile.QUALITY_TIME_LAPSE_480P;
        } else if (CamcorderProfile.hasProfile(CamcorderProfile.QUALITY_TIME_LAPSE_QVGA)) {
            mQuality = CamcorderProfile.QUALITY_TIME_LAPSE_QVGA;
        } else if (CamcorderProfile.hasProfile(CamcorderProfile.QUALITY_TIME_LAPSE_CIF)) {
            mQuality = CamcorderProfile.QUALITY_TIME_LAPSE_CIF;
        } else if (CamcorderProfile.hasProfile(CamcorderProfile.QUALITY_TIME_LAPSE_720P)) {
            mQuality = CamcorderProfile.QUALITY_TIME_LAPSE_720P;
        }
        Log.d("px", "finally mQuality resolution:" + mQuality);
        CamcorderProfile profile = CamcorderProfile.get(mQuality);
        //因为竖屏被旋转了90度
        mVideoHeiht = profile.videoFrameWidth;
        mVideoWidth = profile.videoFrameHeight;
        Log.d("px", "video screen from CamcorderProfile resolution:" + mVideoWidth + "*" + mVideoHeiht);
    }

    public static Bitmap getVideoThumbnail(String filePath) {
        return ThumbnailUtils.createVideoThumbnail(filePath, MediaStore.Images.Thumbnails.MINI_KIND);
    }

    public static void saveBitmapWithName(Bitmap bitmap, String path) {
        FileOutputStream outputStream = null;
        try {
            File file = new File(path);
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            file.createNewFile();
            outputStream = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
    }
}
