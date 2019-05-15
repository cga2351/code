package mqms.ncp.navercorp.com.testgpuimage;

import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.media.CamcorderProfile;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.media.MediaRecorder;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Range;
import android.view.Display;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jp.co.cyberagent.android.gpuimage.GPUImage;
import jp.co.cyberagent.android.gpuimage.util.Rotation;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn_1)
    Button btn1;
    @BindView(R.id.btn_2)
    Button btn2;
    @BindView(R.id.btn_3)
    Button btn3;
    @BindView(R.id.btn_4)
    Button btn4;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.sv_1)
    SurfaceView sv1;
    @BindView(R.id.glsv_1)
    android.opengl.GLSurfaceView glsv1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        surfaceHolder = sv1.getHolder();
        glsv1.setEGLContextClientVersion(2);

        gpuImage = new GPUImage(MainActivity.this);
        gpuImage.setGLSurfaceView(glsv1);
        gpuImage.setRotation(Rotation.ROTATION_90);
//        glsv1.setRenderer(new GLSurfaceView.Renderer() {
//            @Override
//            public void onSurfaceCreated(GL10 gl10, EGLConfig eglConfig) {
//                Log.d("-mqmsdebug", "myRender onSurfaceCreated(), entry");
//            }
//
//            @Override
//            public void onSurfaceChanged(GL10 gl10, int i, int i1) {
//                Log.d("-mqmsdebug", "myRender onSurfaceChanged(), entry");
//            }
//
//            @Override
//            public void onDrawFrame(GL10 gl10) {
//                Log.d("-mqmsdebug", "myRender onDrawFrame(), entry");
//            }
//        });
//        glsv1.setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);

//        previewSize = initSupportProfile();
    }

    int textIndex = 0;
    boolean preview = false;
    Camera camera;
    SurfaceHolder surfaceHolder;
//    int previewWidth = 1280;
//    int previewHeight = 720;
    int previewWidth = 1280;
    int previewHeight = 720;

//    int videoWidth = 640;
//    int videoHeight = 360;
//    int videoWidth = 2220;
//    int videoHeight = 1080;
    int videoWidth = 1280;
    int videoHeight = 720;

    Point previewSize = null;
    ////////////////////////////////////////////////////////////////////
    GPUImage gpuImage;
    int imageIndex = 0;
    byte[] previewDataBuf = new byte[previewWidth * previewHeight * ImageFormat.getBitsPerPixel(ImageFormat.NV21) / 8];
//    byte[] previewDataBuf = new byte[previewWidth * previewHeight * 3 / 2];
//    byte[] previewDataBuf = new byte[previewWidth * previewHeight * 3 / 2];
//    byte[] previewDataBuf = null;

    private MediaRecorder mediaRecorder = null;
    private boolean recording = false;
    private boolean recordByMediaCodec = false;
    private String mediaFormatType = MediaFormat.MIMETYPE_VIDEO_MPEG4;
    private Surface persistentSurface = null;
    ////////////////////////////////////////////////////////////////////

    // for media codec
    private MediaCodec videoEncoder;
    private MediaMuxer videoMuxer;
    private MediaFormat videoFormat;
//    private int videoEncodeColor = MediaCodecInfo.CodecCapabilities.COLOR_FormatYUV420SemiPlanar;
    private int videoEncodeColor;
    MediaCodec.BufferInfo frameInfo = new MediaCodec.BufferInfo();
    private long videoCreateTime = 0;
    private int videoTrackIndex = 0;
//    private int srcWidth, srcHeight, dstWidth, dstHeight;

    public static Point initSupportProfile() {
        int mQuality = 0;

        if (CamcorderProfile.hasProfile(CamcorderProfile.QUALITY_TIME_LAPSE_480P)) {//无声音的480p
            mQuality = CamcorderProfile.QUALITY_TIME_LAPSE_480P;
        } else if (CamcorderProfile.hasProfile(CamcorderProfile.QUALITY_TIME_LAPSE_QVGA)) {
            mQuality = CamcorderProfile.QUALITY_TIME_LAPSE_QVGA;
        } else if (CamcorderProfile.hasProfile(CamcorderProfile.QUALITY_TIME_LAPSE_CIF)) {
            mQuality = CamcorderProfile.QUALITY_TIME_LAPSE_CIF;
        } else if (CamcorderProfile.hasProfile(CamcorderProfile.QUALITY_TIME_LAPSE_720P)) {
            mQuality = CamcorderProfile.QUALITY_TIME_LAPSE_720P;
        } else if (CamcorderProfile.hasProfile(CamcorderProfile.QUALITY_TIME_LAPSE_1080P)) {
            mQuality = CamcorderProfile.QUALITY_TIME_LAPSE_1080P;
        }
        Log.d("px", "finally mQuality resolution:" + mQuality);
        CamcorderProfile profile = CamcorderProfile.get(mQuality);
        Log.d("px", "video screen from CamcorderProfile resolution:" + profile.videoFrameWidth + "*" + profile.videoFrameHeight);
        //因为竖屏被旋转了90度
        return new Point(profile.videoFrameWidth, profile.videoFrameHeight);
    }

    @OnClick({R.id.btn_1, R.id.btn_2, R.id.btn_3, R.id.btn_4})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_1:
                btn1Click();
                break;
            case R.id.btn_2:
                break;
            case R.id.btn_3:
                break;
            case R.id.btn_4:
                break;
        }
    }

    public static Bitmap yuvToBitmap(byte[] data, int width, int height) {
        int frameSize = width * height;
        int[] rgba = new int[frameSize];
        for (int i = 0; i < height; i++)
            for (int j = 0; j < width; j++) {
                int y = (0xff & ((int) data[i * width + j]));
                int u = (0xff & ((int) data[frameSize + (i >> 1) * width + (j & ~1) + 0]));
                int v = (0xff & ((int) data[frameSize + (i >> 1) * width + (j & ~1) + 1]));
                y = y < 16 ? 16 : y;
                int r = Math.round(1.164f * (y - 16) + 1.596f * (v - 128));
                int g = Math.round(1.164f * (y - 16) - 0.813f * (v - 128) - 0.391f * (u - 128));
                int b = Math.round(1.164f * (y - 16) + 2.018f * (u - 128));
                r = r < 0 ? 0 : (r > 255 ? 255 : r);
                g = g < 0 ? 0 : (g > 255 ? 255 : g);
                b = b < 0 ? 0 : (b > 255 ? 255 : b);
                rgba[i * width + j] = 0xff000000 + (b << 16) + (g << 8) + r;
            }
        Bitmap bmp = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        bmp.setPixels(rgba, 0, width, 0, 0, width, height);
        return bmp;
    }

    public void stopRecordWithMediaRecorder() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (null != mediaRecorder) {
                mediaRecorder.stop();
                mediaRecorder.release();
                mediaRecorder = null;
            }
        }
        recording = false;

    }

    public void stopRecordWithMediaCodec() {
        recording = false;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////
//    protected void stop() {
//        if (recording) {
//            // 如果正在录音，停止并释放资源
//            mediaRecorder.stop();
//            mediaRecorder.release();
//            mediaRecorder = null;
//            recording = false;
//            Toast.makeText(MainActivity.this, "录音结束", 0).show();
//        }
//    }
//
//    protected void start(String filePath) {
//        try {
//            File file = new File(filePath);
//            if (file.exists()) {
//                // 如果文件存在，删除它，演示代码保证设备上只有一个录音文件
//                file.delete();
//            }
//
//            mediaRecorder = new MediaRecorder();
//            mediaRecorder.reset();
//            // 设置音频录入源
//            mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
//            // 设置视频图像的录入源
//            mediaRecorder.setVideoSource(MediaRecorder.VideoSource.CAMERA);
//            // 设置录入媒体的输出格式
//            mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
//            // 设置音频的编码格式
//            mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.DEFAULT);
//            // 设置视频的编码格式
//            mediaRecorder.setVideoEncoder(MediaRecorder.VideoEncoder.MPEG_4_SP);
//            // 设置视频的采样率，每秒4帧
//            mediaRecorder.setVideoFrameRate(4);
//            // 设置录制视频文件的输出路径
//            mediaRecorder.setOutputFile(file.getAbsolutePath());
//            // 设置捕获视频图像的预览界面
//            mediaRecorder.setPreviewDisplay(sv1.getHolder().getSurface());
//
//            mediaRecorder.setOnErrorListener(new MediaRecorder.OnErrorListener() {
//
//                @Override
//                public void onError(MediaRecorder mr, int what, int extra) {
//                    // 发生错误，停止录制
//                    mediaRecorder.stop();
//                    mediaRecorder.release();
//                    mediaRecorder = null;
//                    recording = false;
//                    Toast.makeText(MainActivity.this, "录制出错", 0).show();
//                }
//            });
//
//            // 准备、开始
//            mediaRecorder.prepare();
//            mediaRecorder.start();
//
//            recording = true;
//            Toast.makeText(MainActivity.this, "开始录像", 0).show();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
    /////////////////////////////////////////////////////////////////////////////////////////////

    public void startRecordScreen(int width, int height, int dpi, String recordFilePath, long startTimestamp) {
        if (recording) {
            Log.d("-mqmsdebug", "startRecordScreen(), is recording now");
        } else {

            if (System.currentTimeMillis() < startTimestamp) {
                try {
                    Thread.sleep(startTimestamp - System.currentTimeMillis());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if (null == mediaRecorder) {
                mediaRecorder = new MediaRecorder();
            }
            // init media recorder
            List<Integer> supportedFrameRate = camera.getParameters().getSupportedPreviewFrameRates();
            camera.unlock();
            mediaRecorder.setCamera(camera);
            mediaRecorder.setPreviewDisplay(surfaceHolder.getSurface());
            mediaRecorder.setVideoSource(MediaRecorder.VideoSource.CAMERA);
            mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
            mediaRecorder.setOutputFile(recordFilePath);
            mediaRecorder.setVideoEncodingBitRate(4 * width * height);
            mediaRecorder.setVideoEncoder(MediaRecorder.VideoEncoder.H264);
            mediaRecorder.setVideoSize(width, height);
            mediaRecorder.setVideoFrameRate(30);
            mediaRecorder.setCaptureRate(30);
            mediaRecorder.setOrientationHint(90);

            try {
                mediaRecorder.prepare();
                Log.d("-mqmsdebug", "startRecordScreen(), start record");
                mediaRecorder.start();
                recording = true;
            } catch (IOException e) {
                e.printStackTrace();
                stopRecordWithMediaRecorder();
                Log.d("-mqmsdebug", "startRecordScreen(), MediaRecorder prepare exception, info:" + e.getMessage());
            }
        }
    }

    private void btn1Click() {
        if (recording || preview) {
            Log.d("-mqmsdebug", "onViewClicked(), stop preview");

            if (recordByMediaCodec) {
                // stop record with media codec
                stopRecordWithMediaCodec();
            } else {
                // stop
                stopRecordWithMediaRecorder();
            }

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            camera.stopPreview();
            camera.release();
            preview = false;
        } else {
            Log.d("-mqmsdebug", "onViewClicked(), start preview");

            initCamera();

            // start preview
            startPreview();

            // start record
//            startRecordWithMediaRecorder();

            // start record with mediaCodec
            startRecordWithMediaCodec();

//            byte[] previewDataBuf = new byte[previewWidth * previewHeight * ImageFormat.getBitsPerPixel(ImageFormat.NV21) / 8];
//            byte[] previewDataBuf = new byte[previewWidth * previewHeight * 3 / 2];
            camera.addCallbackBuffer(previewDataBuf);;
        }
    }

    public Object[] initEncoder() {
        MediaCodec mediaEncode = null;
        MediaCodecInfo codecInfo = null;
        try {
            mediaEncode = MediaCodec.createEncoderByType(mediaFormatType);
            codecInfo = mediaEncode.getCodecInfo();
        } catch (IOException e) {
            Log.d("px", e.toString());
            e.printStackTrace();
        }
        if (codecInfo == null || mediaEncode == null) {
            return null;
        }

        //检查所支持的colorspace
        int colorFormat = 0;
        MediaCodecInfo.CodecCapabilities capabilities = codecInfo.getCapabilitiesForType(mediaFormatType);
        MediaCodecInfo.VideoCapabilities videoCapabilities = capabilities.getVideoCapabilities();
        Log.d("-mqmsdebug", "length-" + capabilities.colorFormats.length + "==" + Arrays.toString(capabilities.colorFormats));

        List<Integer> colorFormats = new ArrayList<>();
        outside:
        for (int i = 0; i < capabilities.colorFormats.length; i++) {
            colorFormats.add(capabilities.colorFormats[i]);
//            Log.d("-mqmsdebug", "colorFormats=" + capabilities.colorFormats[i]);
        }
//                case MediaCodecInfo.CodecCapabilities.COLOR_FormatYUV420PackedPlanar:
//                case MediaCodecInfo.CodecCapabilities.COLOR_FormatYUV420PackedSemiPlanar:
//                case MediaCodecInfo.CodecCapabilities.COLOR_TI_FormatYUV420PackedSemiPlanar:
//                case MediaCodecInfo.CodecCapabilities.COLOR_FormatSurface:

//        if (colorFormats.contains(MediaCodecInfo.CodecCapabilities.COLOR_FormatYUV420SemiPlanar)) {
//            colorFormat = MediaCodecInfo.CodecCapabilities.COLOR_FormatYUV420SemiPlanar;
//        } else if (colorFormats.contains(MediaCodecInfo.CodecCapabilities.COLOR_FormatYUV420Planar)) {
            colorFormat = MediaCodecInfo.CodecCapabilities.COLOR_FormatYUV420Planar;
//        }

//        colorFormat = MediaCodecInfo.CodecCapabilities.COLOR_FormatYUV420Planar;
//         colorFormat = MediaCodecInfo.CodecCapabilities.COLOR_FormatYUV420SemiPlanar;

        Log.d("-mqmsdebug", "find codec support color format ->" + colorFormat);
//        Log.d("-mqmsdebug", "my width and height:" + width + "*" + height);
        //查找支持的帧率,尺寸等
        Range<Integer> frameRates = videoCapabilities.getSupportedFrameRates();
        Range<Integer> widths = videoCapabilities.getSupportedWidths();
        Range<Integer> heights = videoCapabilities.getSupportedHeights();
        Range<Integer> bitrates = videoCapabilities.getBitrateRange();
        Log.d("-mqmsdebug", "frameRates:" + frameRates);
        Log.d("-mqmsdebug", "widths:" + widths);
        Log.d("-mqmsdebug", "heights:" + heights);
        Log.d("-mqmsdebug", "BitrateRange:" + bitrates);
//        Range<Double> achievableFrameRate = videoCapabilities.getAchievableFrameRatesFor(width, height);
//        Log.d("-mqmsdebug", "AchievableFrame for " + width + "*" + height + ":" + achievableFrameRate);


        // 摄像头是旋转了90度
//        MediaFormat inputMediaFormat = MediaFormat.createVideoFormat(MediaFormat.MIMETYPE_VIDEO_AVC, previewWidth, previewHeight);
//        MediaFormat inputMediaFormat = MediaFormat.createVideoFormat(mediaFormatType, previewWidth, previewHeight);
        MediaFormat inputMediaFormat = MediaFormat.createVideoFormat(mediaFormatType, videoWidth, videoHeight);
//        MediaFormat inputMediaFormat = MediaFormat.createVideoFormat(mediaFormatType, 2220, 1080);
//        inputMediaFormat.setInteger(MediaFormat.KEY_BIT_RATE, videoWidth * videoHeight * 8);
        inputMediaFormat.setInteger(MediaFormat.KEY_BIT_RATE, 6000*1024);
//        inputMediaFormat.setFloat(MediaFormat.KEY_FRAME_RATE, achievableFrameRate.getUpper().floatValue());
        inputMediaFormat.setFloat(MediaFormat.KEY_FRAME_RATE, 30);
        inputMediaFormat.setInteger(MediaFormat.KEY_COLOR_FORMAT, colorFormat);
        inputMediaFormat.setInteger(MediaFormat.KEY_I_FRAME_INTERVAL, 1);
//        inputMediaFormat.setInteger(MediaFormat.KEY_ROTATION, 90);

        mediaEncode.configure(inputMediaFormat, null, null, MediaCodec.CONFIGURE_FLAG_ENCODE);
//        return new Object[]{mediaEncode, colorFormat};

        Log.d("-mqmsdebug", "mediaEncode.getInputFormat().colorFormat=" + mediaEncode.getInputFormat().getInteger(MediaFormat.KEY_COLOR_FORMAT) +
//                ", mediaEncode.getOutputFormat().colorFormat=" + mediaEncode.getOutputFormat().getInteger(MediaFormat.KEY_COLOR_FORMAT)  +
                ", format.colorFormat=" + inputMediaFormat.getInteger(MediaFormat.KEY_COLOR_FORMAT) );

        return new Object[]{mediaEncode, inputMediaFormat};

    }



    void initMediaEncode() {
//        Object[] objects = initEncoder(previewWidth, previewHeight);
        Object[] objects = initEncoder();
        videoEncoder = (MediaCodec) objects[0];
        videoFormat = (MediaFormat) objects[1];
        videoEncodeColor = videoFormat.getInteger(MediaFormat.KEY_COLOR_FORMAT);
    }

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    public void captureImg(byte[] data, int width, int height) {
        Date date = new Date();
        byte[] frameData = new byte[videoWidth * videoHeight * 3 / 2];
        Log.d("-mqmsdebug", "captureImg(), 1");
        NativeUtils.drawText(data, frameData, width, height, videoWidth, videoHeight, dateFormat.format(date));
        Log.d("-mqmsdebug", "captureImg(), 2");
        frameInfo.flags = MediaCodec.BUFFER_FLAG_CODEC_CONFIG;
        frameInfo.presentationTimeUs = (date.getTime() - videoCreateTime) * 1000;

//        putIn(data, frameInfo);
        putIn(frameData, frameInfo);
    }

    void putIn(byte[] data, MediaCodec.BufferInfo videoInfo) {
        if (data == null) {
            Log.d("px", "data ==null ,so end");
            return;
        }
        int inputIndex = videoEncoder.dequeueInputBuffer(50000);//同解码器
        if (inputIndex < 0) {
            Log.d("px", "dequeueInputBuffer return inputIndex " + inputIndex + ",then break");
//            videoEncoder.signalEndOfInputStream();
            return;
        }
        ByteBuffer inputBuffer = videoEncoder.getInputBuffer(inputIndex);//同解码器
        inputBuffer.clear();//同解码器
        inputBuffer.put(data);//PCM数据填充给inputBuffer
        inputBuffer.limit(videoInfo.size);
        videoEncoder.queueInputBuffer(inputIndex, 0, data.length, videoInfo.presentationTimeUs, videoInfo.flags);//通知编码器 编码
    }

    long lastFrameTime = 0;
    long lastFrameWriteTime = 0;
    private void encode() {

        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        int outputIndex = videoEncoder.dequeueOutputBuffer(bufferInfo, 50000);//同解码器
        switch (outputIndex) {
            case MediaCodec.INFO_OUTPUT_BUFFERS_CHANGED:
                Log.d("-mqmsdebug", "INFO_OUTPUT_BUFFERS_CHANGED");
                break;
            case MediaCodec.INFO_OUTPUT_FORMAT_CHANGED:
                MediaFormat outputFormat = videoEncoder.getOutputFormat();
//                outputFormat.setInteger(MediaFormat.KEY_ROTATION, 90);
//                outputFormat.setInteger(MediaFormat.KEY_COLOR_FORMAT, videoEncodeColor);
//                Log.d("-mqmsdebug", "videoEncoder find New format " + outputFormat);
                //向合成器添加视频轨
                videoTrackIndex = videoMuxer.addTrack(outputFormat);
                videoMuxer.start();
                break;
            case MediaCodec.INFO_TRY_AGAIN_LATER:
                Log.d("-mqmsdebug", "dequeueOutputBuffer timed out!");
                break;
            default:
                ByteBuffer outputBuffer;
                while (outputIndex >= 0) {//同解码器
                    outputBuffer = videoEncoder.getOutputBuffer(outputIndex);//拿到输出Buffer

                    long curTime = System.currentTimeMillis();
                    Log.d("-mqmsdebug", "encode(), write a video sample" +
                            ", frame time:" + (bufferInfo.presentationTimeUs / 1000) +
                            ", frame write time:" + (curTime - lastFrameWriteTime));
                    lastFrameTime = bufferInfo.presentationTimeUs;
                    lastFrameWriteTime = curTime;

                    videoMuxer.writeSampleData(videoTrackIndex, outputBuffer, bufferInfo);
                    videoEncoder.releaseOutputBuffer(outputIndex, false);

                    outputIndex = videoEncoder.dequeueOutputBuffer(bufferInfo, 50000);
                }
                break;
        }
    }

    public int preview2deocode(int previewFormat) {
        Log.d("px", "previewFormat=" + previewFormat);
        int decodeColor = 0;
        //获取相机预览的颜色格式,暂时只有这两种
        if (previewFormat == ImageFormat.NV21) {
            //camera预览的nv21相当于opencv里面的nv12
            decodeColor = NativeUtils.NV12;
        } else if (previewFormat == ImageFormat.YV12) {
            //camera预览的YV12相当于opencv里面的I420,也有可能是我的概念偏差
            decodeColor = NativeUtils.I420;
        }
        return decodeColor;
    }

    private void startRecordWithMediaCodec() {

        recordByMediaCodec = true;
        initTextDrawProp();
        initMediaEncode();


        try {
            if (new File("/sdcard/mqms/tmp/testRecordVideo/recordByMediaCodec.mp4").exists()) {
                new File("/sdcard/mqms/tmp/testRecordVideo/recordByMediaCodec.mp4").delete();
            }
            videoMuxer = new MediaMuxer("/sdcard/mqms/tmp/testRecordVideo/recordByMediaCodec.mp4", MediaMuxer.OutputFormat.MUXER_OUTPUT_MPEG_4);
            videoMuxer.setOrientationHint(90);
        } catch (IOException e) {
            e.printStackTrace();
        }
        videoCreateTime = System.currentTimeMillis();
        recording = true;
        videoEncoder.start();

        Thread thread = new Thread() {
            @Override
            public void run() {
                while (recording) {
                    encode();
                }
                videoEncoder.stop();
                videoEncoder.release();
                videoMuxer.stop();
                videoMuxer.release();
//                NativeUtils.release();
            }
        };
        thread.start();
    }

    private void initTextDrawProp() {
        //首次 释放字体文件
        String ttfPath = "sdcard/mqms/Courier.ttf";
        File ttf = new File(ttfPath);
        NativeUtils.fixFontFile(ttfPath);
        String text = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date());
        NativeUtils.fixTextArea(text);
        NativeUtils.fixColorFormat(preview2deocode(camera.getParameters().getPreviewFormat()), videoEncodeColor);
    }

    private void startRecordWithMediaRecorder() {
        recordByMediaCodec = false;
        WindowManager wm = (WindowManager) MainActivity.this.getSystemService(ContextWrapper.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        display.getRealMetrics(displayMetrics);
//        start("/sdcard/mqms/tmp/testRecordSurfaceVideo.mp4");
//        startRecordScreen(previewWidth, previewHeight, displayMetrics.densityDpi, "/sdcard/mqms/tmp/testRecordVideo/recordByMediaRecorder.mp4", System.currentTimeMillis() + 1000);
//        startRecordScreen(videoWidth, videoHeight, displayMetrics.densityDpi, "/sdcard/mqms/tmp/testRecordVideo/recordByMediaRecorder.mp4", System.currentTimeMillis() + 1000);
        startRecordScreen(1920, 1080, displayMetrics.densityDpi, "/sdcard/mqms/tmp/testRecordVideo/recordByMediaRecorder.mp4", System.currentTimeMillis() + 1000);
    }

    private void startPreview() {

        try {
            camera.setPreviewDisplay(surfaceHolder);
        } catch (IOException e) {
            e.printStackTrace();
        }


        camera.startPreview();
        preview = true;
    }

    int waterMarkWidth = 300;
    int waterMarkHeight = 100;
    private Rect testbounds = new Rect();
    long firstFrameTime = System.currentTimeMillis();
    private void setTextSizeForWidth(Paint paint, float desiredWidth, String text) {
        final float testTextSize = 48f;
        paint.setTextSize(testTextSize);
        paint.getTextBounds(text, 0, text.length(), testbounds);
        float desiredTextSize = testTextSize * desiredWidth / testbounds.width() - 4;
        paint.setTextSize(desiredTextSize);
    }

    private Bitmap tvConvertedToBitmap(long currentFrameTime, int _currentFrameNum) {
        if(previewWidth == 0 || previewHeight == 0) {
            //return null;
            previewWidth = 1280;
            previewHeight = 720;
//            previewSize = new Point(720, 480);
        }

        Bitmap bitmap = Bitmap.createBitmap(waterMarkWidth, waterMarkHeight, Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bitmap);
        Rect rect = new Rect(0,0, waterMarkWidth, waterMarkHeight);
        Paint rectPaint = new Paint();
        rectPaint.setColor(Color.BLACK);
        rectPaint.setStyle(Paint.Style.FILL);
        canvas.drawRect(rect, rectPaint);

        Paint textPaint = new Paint();
        textPaint.setColor(Color.WHITE);
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setTextAlign(Paint.Align.CENTER);
        textPaint.setAntiAlias(true);
//        textPaint.setTypeface(typeface);

        String text = String.format("#%04d.%05d#", _currentFrameNum, (currentFrameTime - firstFrameTime) / 10);//以10MS为单位
        setTextSizeForWidth(textPaint, waterMarkWidth, text);

        Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
        float top = fontMetrics.top;
        float bottom = fontMetrics.bottom;
        int baseLineY = (int) (rect.centerY() - top / 2 - bottom / 2);

        canvas.drawText(text, rect.centerX(), baseLineY, textPaint);

        Matrix matrix = new Matrix();
//        matrix.postRotate(90);
        matrix.postRotate(270);
        Log.i("machiningFrameData :", waterMarkWidth + "     " + waterMarkHeight);
        Bitmap newBM = Bitmap.createBitmap(bitmap, 0, 0, waterMarkWidth, waterMarkHeight, matrix, false);
        if (!bitmap.isRecycled()) {
            bitmap.recycle();
        }

        return newBM;
    }

    private byte[] getYUVByBitmap(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int size = width * height;
        int pixels[] = new int[size];
        bitmap.getPixels(pixels, 0, width, 0, 0, width, height);
        byte[] data = rgb2YCbCr420(pixels, width, height);
        if (!bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return data;
    }

    private byte[] rgb2YCbCr420(int[] argb, int width, int height) {
        final int frameSize = width * height;

        byte[] yuv420sp = new byte[width * height + 2 * (int) Math.ceil(width / 2.0) * (int) Math.ceil(height / 2.0)];

        int yIndex = 0;
        int uvIndex = frameSize;

        int R, G, B, Y, U, V;
        int index = 0;
        for (int j = 0; j < height; j++) {
            for (int i = 0; i < width; i++) {
                R = (argb[index] & 0xff0000) >> 16;
                G = (argb[index] & 0xff00) >> 8;
                B = (argb[index] & 0xff) >> 0;

                Y = ((66 * R + 129 * G + 25 * B + 128) >> 8) + 16;
                U = ((-38 * R - 74 * G + 112 * B + 128) >> 8) + 128;
                V = ((112 * R - 94 * G - 18 * B + 128) >> 8) + 128;

                yuv420sp[yIndex++] = (byte) ((Y < 0) ? 0 : ((Y > 255) ? 255 : Y));
                if (j % 2 == 0 && index % 2 == 0) {
                    yuv420sp[uvIndex++] = (byte) ((V < 0) ? 0 : ((V > 255) ? 255 : V));
                    yuv420sp[uvIndex++] = (byte) ((U < 0) ? 0 : ((U > 255) ? 255 : U));
                }

                index++;
            }
        }
        return yuv420sp;
    }

    private void combine(byte[] initBytes, byte[] waterMarkBytes) {
        combineCal(initBytes, previewWidth, previewHeight, waterMarkBytes,
                waterMarkHeight, waterMarkWidth, (previewHeight - waterMarkHeight) / 2 - previewWidth * 5 / 100,
                (previewHeight - waterMarkWidth) / 2);
    }

    private void combineCal(byte[] initBytes, int w1, int h1, byte[] waterMarkBytes, int w2, int h2, int off_x, int off_y) {
        if(initBytes == null) {
            return;
        }
        int size1 = w1 * h1;
        int size2 = w2 * h2;

        int y1 = 0;
        int uv1 = y1 + size1;

        int y2 = 0;
        int uv2 = y2 + size2;

        int nOff;
        try {
            for (int i = 0; i < h2; i++) {
                nOff = w1 * (off_y + i) + off_x;
                System.arraycopy(waterMarkBytes, y2 + w2 * i, initBytes, y1 + nOff, w2);
            }

            for (int j = 0; j < h2 / 2; j++) {
                nOff = w1 * (off_y / 2 + j) + off_x;
                System.arraycopy(waterMarkBytes, uv2 + w2 / 2 * j, initBytes, uv1 + nOff, w2);
            }
        }
        catch (ArrayIndexOutOfBoundsException e) {
            Log.e("Utils combineCal", e.getMessage());
        }
    }

    public void setupCameraParams(Camera camera, Point size) {
        //处理预览像素,帧率,颜色格式
        Camera.Parameters parameters = showSupportPreviewSize(camera, size);

        //设置简单的聚焦,白平衡,闪光灯等等
        parameters.setFlashMode(Camera.Parameters.FLASH_MODE_AUTO);
        parameters.setFocusMode(Camera.Parameters.FOCUS_MODE_CONTINUOUS_VIDEO);
        parameters.setWhiteBalance(Camera.Parameters.WHITE_BALANCE_AUTO);
        parameters.setSceneMode(Camera.Parameters.SCENE_MODE_AUTO);

        camera.setParameters(parameters);
        camera.setDisplayOrientation(90); // Portrait mode
    }

    static Camera.Parameters showSupportPreviewSize(Camera camera, Point size) {
        //处理预览尺寸
        Camera.Parameters parameters = camera.getParameters();
        List<Camera.Size> previewSizes = parameters.getSupportedPreviewSizes();
        if (previewSizes != null) {
            StringBuilder sb = new StringBuilder("SupportedPreviewSizes:[");
            for (Camera.Size s : previewSizes) {
                sb.append(s.width).append("*").append(s.height).append(",");
                if (s.width * s.height == size.x * size.y) {
                    parameters.setPreviewSize(s.width, s.height);
                    Log.d("px", "resolution size:" + s.width + "*" + s.height);
                }
            }
            Log.d("px", sb.deleteCharAt(sb.length() - 1).toString());
        } else {
            Log.d("px", "SupportedVideoSizes:null");
        }

        //处理预览帧率
        int[] range = {0, 0};
        List<int[]> previewFpsRange = parameters.getSupportedPreviewFpsRange();
        StringBuilder sb = new StringBuilder("SupportedPreviewFpsRange:");
        for (int[] r : previewFpsRange) {
            sb.append("[");
            for (int i = 0; i < r.length; i++) {
                sb.append(r[i]).append(",");
            }
            if (r[0] > 20 * 1000 && r[0] > range[0]) {//取一个大于20的帧率
                range = r;
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append("],");
        }
        sb.deleteCharAt(sb.length() - 1);
        Log.d("px", sb.toString() + "->use:[" + range[0] + "," + range[1] + "]");
        //帧率
//        p.setPreviewFpsRange(24, 24);

        List<Integer> formats = parameters.getSupportedPreviewFormats();
        Log.d("px", "SupportedPreviewFormats:" + formats);
        if (formats.contains(ImageFormat.NV21))
            parameters.setPreviewFormat(ImageFormat.NV21);
        else if (formats.contains(ImageFormat.YV12))
            parameters.setPreviewFormat(ImageFormat.YV12);

        return parameters;
    }

    private void initCamera() {
        int mCameraId = Camera.CameraInfo.CAMERA_FACING_BACK;
        camera = Camera.open(mCameraId);
//        setupCameraParams(camera, previewSize);

//        setVideoPreviewSizeColor(previewWidth, previewHeight, 0);

        Camera.Parameters parameters = camera.getParameters();
        parameters.set("orientation", "portrait");
        parameters.setFocusMode(Camera.Parameters.FOCUS_MODE_CONTINUOUS_VIDEO);
        parameters.setPreviewSize(previewWidth, previewHeight);
        parameters.setPreviewFormat(ImageFormat.NV21);

        camera.setDisplayOrientation(90);
        camera.setParameters(parameters);

//            gpuImage.setGLSurfaceView(glsv1);
        camera.setPreviewCallbackWithBuffer(new Camera.PreviewCallback() {
            @Override
            public void onPreviewFrame(byte[] data, Camera camera) {
                Log.d("-mqmsdebug", "onPreviewFrame(), entry");


                // add water mark
                Bitmap bitmap = tvConvertedToBitmap(System.currentTimeMillis(), imageIndex);
                if(bitmap != null) {
                    byte[] bytesYUV = getYUVByBitmap(bitmap);
                    combine(data, bytesYUV);
                }

                // set data to gpu image to display
//                setData2GPUImage(data);


                // set data to mediaCodec to encode to video
                if (recording && recordByMediaCodec) {
                    captureImg(data, previewWidth, previewHeight);
                }


                imageIndex++;
                camera.addCallbackBuffer(data);
            }
        });
    }

    private void setData2GPUImage(byte[] data) {
        Bitmap bitmap2 = yuvToBitmap(data, previewWidth, previewHeight);
        gpuImage.setImage(bitmap2);
        gpuImage.saveToPictures("/sdcard/mqms/tmp/picGPUImage", "testGPUImage_" + imageIndex + ".jpg", null);
    }
}
