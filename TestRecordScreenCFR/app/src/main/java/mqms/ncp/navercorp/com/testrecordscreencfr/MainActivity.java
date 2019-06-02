package mqms.ncp.navercorp.com.testrecordscreencfr;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.hardware.display.DisplayManager;
import android.hardware.display.VirtualDisplay;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.media.MediaRecorder;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjectionManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.Surface;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mqms.ncp.navercorp.com.testrecordscreencfr.recorder.coder.MediaEncoder;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "test_cfr";

    // for video record
    private long videoStartTime = 0;
    //    public static boolean recordThreadExit = false;
    private MediaCodec videoEncoder;
    private MediaMuxer videoMuxer;
//    private boolean videoMuxerStart = false;
    private Thread videoEncodeThread;
    //    private MediaFormat videoFormat;
//    private int videoEncodeColor;
    private String videoMediaFormatType = MediaFormat.MIMETYPE_VIDEO_AVC;
    private int videoTrackIndex = 0;
    private final int REQUEST_CODE_SCREEN_CAPTURE = 1;
//    private static boolean needRecord = false;
    private boolean recording = false;
    private boolean videoMuxerStarted = false;
    private int recordType = 2;

    private MediaProjection mediaProjection = null;
    private VirtualDisplay virtualDisplay = null;
    private MediaRecorder mediaRecorder = null;
    private static final String recordVideoFileFullPath = "/sdcard/mqms/tmp/testRecordVideo/testcfr.mp4";

    private int screenCaptureResultCode = 0;
    private Intent screenCaptureData = null;

    ///////////////////////////////////////////////////////////////////////////////////////
    // test virtual display -> surface texture -> opengl -> media codec
    private MediaEncoder encoder;
    ///////////////////////////////////////////////////////////////////////////////////////



    @BindView(R.id.btn_test1)
    Button btnTest1;
    @BindView(R.id.btn_test2)
    Button btnTest2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            MediaProjectionManager mediaProjectionManager = (MediaProjectionManager) getSystemService(Context.MEDIA_PROJECTION_SERVICE);
            startActivityForResult(mediaProjectionManager.createScreenCaptureIntent(), REQUEST_CODE_SCREEN_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_SCREEN_CAPTURE && RESULT_OK == resultCode) {
            Log.d(TAG, "onActivityResult(), screenCaptureResultCode=" + screenCaptureResultCode + ", screenCaptureData=" + screenCaptureData);
            screenCaptureResultCode = resultCode;
            screenCaptureData = data;
        }
    }

    boolean btnProcessing = false;
    @OnClick({R.id.btn_test1, R.id.btn_test2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_test1:
                btnTestClick();
                break;
            case R.id.btn_test2:
                btnTest2Click();
                break;
        }
    }

    private void btnTestClick() {
        if (!btnProcessing) {
            btnProcessing = true;
            new Thread(new Runnable() {
                @Override
                public void run() {
//                    try {
//                        Thread.sleep(2000);
//                                recordingStartStop();
//                                Thread.sleep(5000);
                        recordingStartStop();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    btnProcessing = false;
                }
            }).start();
        }
    }

    private void recordingStartStop() {
        if (!recording) {
            // start record
            if (0 == recordType) {
                startRecordScreenByMediaRecorder();
            } else if (1 == recordType){
                startRecordScreenByMediaCodec();
            } else if (2 == recordType) {
                startRecordScreenCFR();
            }

        } else {
            // stop record
            if (0 == recordType) {
                stopRecordScreenByMediaRecorder();
            } else if (1 == recordType){
                stopRecordScreenByMediaCodec();
            } else if (2 == recordType) {
                stopRecordScreenCFR();
            }
        }
    }

    private void btnTest2Click() {

    }

    public void startRecordScreenByMediaRecorder() {
        WindowManager wm = (WindowManager) MainActivity.this.getSystemService(ContextWrapper.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        display.getRealMetrics(displayMetrics);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (null == mediaRecorder) {
                mediaRecorder = new MediaRecorder();
            }
            // init media recorder
            mediaRecorder.setVideoSource(MediaRecorder.VideoSource.SURFACE);
//                mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
            mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
//                mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
            mediaRecorder.setOutputFile(recordVideoFileFullPath);
            mediaRecorder.setVideoEncodingBitRate(5 * displayMetrics.widthPixels * displayMetrics.heightPixels);
            mediaRecorder.setVideoEncoder(MediaRecorder.VideoEncoder.DEFAULT);
            mediaRecorder.setVideoSize(displayMetrics.widthPixels, displayMetrics.heightPixels);
            mediaRecorder.setVideoFrameRate(60);
            mediaRecorder.setCaptureRate(60);
//                mediaRecorder.setOrientationHint(90);
            try {
                mediaRecorder.prepare();

                MediaProjectionManager mediaProjectionManager = (MediaProjectionManager)MainActivity.this.getSystemService(Context.MEDIA_PROJECTION_SERVICE);
                if (null != mediaProjectionManager) {
                    Log.d(TAG, "startRecordScreenByMediaRecorder(), screenCaptureResultCode=" + screenCaptureResultCode + ", screenCaptureData=" + screenCaptureData);
                    mediaProjection = mediaProjectionManager.getMediaProjection(screenCaptureResultCode, screenCaptureData);
                    if (null != mediaProjection) {
                        virtualDisplay = mediaProjection.createVirtualDisplay("test_vfr",
                                displayMetrics.widthPixels,
                                displayMetrics.heightPixels,
                                displayMetrics.densityDpi,
                                DisplayManager.VIRTUAL_DISPLAY_FLAG_PUBLIC,
                                mediaRecorder.getSurface(), null, null);
                        Log.d(TAG, "startRecordScreenByMediaRecorder(), start record");
                        mediaRecorder.start();
                        recording = true;
                    } else {
                        Log.e(TAG, "startRecordScreenByMediaRecorder(), create MediaProjection failed");
                    }
                } else {
                    Log.e(TAG, "startRecordScreenByMediaRecorder(), get mediaProjectionManager failed");
                }
            } catch (IOException e) {
                e.printStackTrace();
                Log.e(TAG, "startRecordScreenByMediaRecorder(), MediaRecorder prepare exception, info:" + e.getMessage());
                stopRecordScreenByMediaRecorder();
            }
        } else {
            Log.e(TAG, "startRecordScreenByMediaRecorder(), android version is less than 21, do not record screen");
        }
    }

    private void stopRecordScreenByMediaCodec() {
//        try {
//            videoEncodeThread.join(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        releaseMediaProjection();
        recording = false;
    }

    private void releaseMediaProjection() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (null != virtualDisplay) {
                virtualDisplay.release();
                virtualDisplay = null;
            }

            if (null != mediaProjection) {
                mediaProjection.stop();
                mediaProjection = null;
            }
        }
    }

    public void stopRecordScreenByMediaRecorder() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (null != mediaRecorder) {
                mediaRecorder.stop();
                mediaRecorder.release();
                mediaRecorder = null;
            }
        }
        releaseMediaProjection();
        recording = false;
    }

    private SurfaceTexture intermediateSurfaceTexture;
    private Surface intermediateSurface;
    private Surface videoEncoderSurface;

    public void initIntermediateSurface() {
        if (null == intermediateSurface) {
            if (null == intermediateSurfaceTexture) {
                intermediateSurfaceTexture = new SurfaceTexture(111, false);
                intermediateSurfaceTexture.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener() {
                    @Override
                    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
                        Log.d(TAG, "onFrameAvailable(), entry");
                    }
                });
            }
            intermediateSurface = new Surface(intermediateSurfaceTexture);
        }
    }

    public void initVirtualDisplay() {
        initIntermediateSurface();

        WindowManager wm = (WindowManager) MainActivity.this.getSystemService(ContextWrapper.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        display.getRealMetrics(displayMetrics);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            try {
                MediaProjectionManager mediaProjectionManager = (MediaProjectionManager)MainActivity.this.getSystemService(Context.MEDIA_PROJECTION_SERVICE);
                if (null != mediaProjectionManager) {
                    Log.d(TAG, "initVirtualDisplay(), screenCaptureResultCode=" + screenCaptureResultCode + ", screenCaptureData=" + screenCaptureData);
                    mediaProjection = mediaProjectionManager.getMediaProjection(screenCaptureResultCode, screenCaptureData);
                    if (null != mediaProjection) {
                        virtualDisplay = mediaProjection.createVirtualDisplay("test_vfr",
//                                displayMetrics.widthPixels,
////                                displayMetrics.heightPixels,
                                720,
                                1280,
                                displayMetrics.densityDpi,
                                DisplayManager.VIRTUAL_DISPLAY_FLAG_PUBLIC,
//                                intermediateSurface,
                                videoEncoderSurface,
                                null, null);
                        Log.d(TAG, "initVirtualDisplay(), start record");
                        recording = true;
                    } else {
                        Log.e(TAG, "initVirtualDisplay(), create MediaProjection failed");
                    }
                } else {
                    Log.e(TAG, "initVirtualDisplay(), get mediaProjectionManager failed");
                }
            } catch (Exception e) {
                e.printStackTrace();
                Log.e(TAG, "initVirtualDisplay(), MediaRecorder prepare exception, info:" + e.getMessage());
                stopRecordScreenByMediaRecorder();
            }
        } else {
            Log.e(TAG, "initVirtualDisplay(), android version is less than 21, do not record screen");
        }
    }

    public String startRecordScreenByMediaCodec() {
        String result = "success";

        // start record camera data
        result = initMediaEncode();

        // create record video MediaMuxer
        result = initMediaMuxer();

        initVirtualDisplay();

        // start media encodeVideoFrame thread
        startVideoEncodeThread();

        // start write video thread
        startWriteFrameThread();

        return result;
    }

    public void stopRecordScreenCFR() {
        if (encoder != null) {
            encoder.stopScreen();
            recording = false;
        }
    }

    public String startRecordScreenCFR() {
        String result = "success";

        // test virtual display -> surface texture -> opengl -> media codec
        result = initMediaMuxer();

        WindowManager wm = (WindowManager) MainActivity.this.getSystemService(ContextWrapper.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        display.getRealMetrics(displayMetrics);

        MediaProjectionManager mediaProjectionManager = (MediaProjectionManager)MainActivity.this.getSystemService(Context.MEDIA_PROJECTION_SERVICE);
        if (null != mediaProjectionManager) {
            Log.d(TAG, "startRecordScreenByMediaRecorder(), screenCaptureResultCode=" + screenCaptureResultCode + ", screenCaptureData=" + screenCaptureData);
            mediaProjection = mediaProjectionManager.getMediaProjection(screenCaptureResultCode, screenCaptureData);
        }

        if (mediaProjection != null) {
            encoder = new MediaEncoder(mediaProjection, 720, 1280, displayMetrics.densityDpi)
                    .setVideoBit(6000 * 1024)
                    .setVideoFPS(100);
        }

        if (encoder != null) {
            encoder.setOnScreenCallBack(null);
            encoder.start();
        }

        recording = true;

        return result;
    }

    private String initMediaMuxer() {
        String result = "success";

        try {
//            String playVideoFilePath = startPlayVideoReq.getPlayVideoFullPath();
//            String recordVideoFileFullPath = startPlayVideoReq.getRecordVideoFullPath();
            File recordVideoFile = new File(recordVideoFileFullPath);
            if (recordVideoFile.exists()) {
                recordVideoFile.delete();
            }
            videoMuxer = new MediaMuxer(recordVideoFileFullPath, MediaMuxer.OutputFormat.MUXER_OUTPUT_MPEG_4);
//            videoMuxer.setOrientationHint(90);
        } catch (IOException e) {
            result = "create media muxer failed, info:" + e.getMessage();
            Log.e(TAG, "initMediaMuxer(), create media muxer failed");
            e.printStackTrace();
        }

        return result;
    }

    private void startVideoEncodeThread() {
        videoEncodeThread = new Thread(new Runnable() {
            @Override
            public void run() {
//                long threadStartTime = System.currentTimeMillis();
//                while (!WaterMarkUtils.startPlayingVideo && System.currentTimeMillis() - threadStartTime < (5 * 60 * 1000)) {
//                    // wait start playing video or 5 minutes
//                    try {
//                        Thread.sleep(10);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }

                // start playing video
//                if (System.currentTimeMillis() - threadStartTime < (5 * 60 * 1000)) {
//                    videoStartTime = System.currentTimeMillis();
                videoEncoder.start();

                while (recording) {
                    encodeVideoFrame();
                }

                videoEncoderSurface.release();
                videoEncoder.stop();
                videoEncoder.release();
                if (videoMuxerStarted) {
                    videoMuxer.stop();
                    videoMuxerStarted = false;
                }
                videoMuxer.release();

                videoEncoder = null;
                videoMuxer = null;
//                }
            }
        });
        videoEncodeThread.start();
    }

    private String initMediaEncode() {
        String result = "success";

        try {
            // samsung s8 supported input color format:
            // 0x7f420888 -> COLOR_FormatYUV420Flexible
            // 0x13 -> COLOR_FormatYUV420Planar
            // 0x15 -> COLOR_FormatYUV420SemiPlanar
            // 0x7f000011 -> ????????????????????
            // 0x10 -> COLOR_Format32bitARGB8888
            // 0x7F00A000 -> COLOR_Format32bitABGR8888
            // 0x7f000789 -> COLOR_FormatSurface
            // 0x7f000012 -> ????????????????????

            videoEncoder = MediaCodec.createEncoderByType(videoMediaFormatType);
            // get supported color format
            int colorFormat = 0;
            MediaCodecInfo.CodecCapabilities capabilities = videoEncoder.getCodecInfo().getCapabilitiesForType(videoMediaFormatType);
            for (int i = 0; i < capabilities.colorFormats.length; i++) {
                // record video with COLOR_FormatYUV420Planar, I420
                if (capabilities.colorFormats[i] == MediaCodecInfo.CodecCapabilities.COLOR_FormatYUV420Planar) {
                    // 录制视频，media codec的输入数据设置为yuv420p(I420),opencv中处理完成后可以直接转换为该格式
                    colorFormat = MediaCodecInfo.CodecCapabilities.COLOR_FormatYUV420Planar;
                    break;
                }
            }
            if (0 == colorFormat) {
                Log.e(TAG, "media codec do not support yuv420p(I420), need support yuv420sp(NV12)");
            }

            MediaFormat inputMediaFormat = MediaFormat.createVideoFormat(videoMediaFormatType, 720, 1280);
            inputMediaFormat.setInteger(MediaFormat.KEY_BIT_RATE, 6000 * 1024);
            inputMediaFormat.setFloat(MediaFormat.KEY_FRAME_RATE, 50);
//            inputMediaFormat.setInteger(MediaFormat.KEY_COLOR_FORMAT, colorFormat);
            inputMediaFormat.setInteger(MediaFormat.KEY_COLOR_FORMAT, MediaCodecInfo.CodecCapabilities.COLOR_FormatSurface);
            inputMediaFormat.setInteger(MediaFormat.KEY_I_FRAME_INTERVAL, 1);

            videoEncoder.configure(inputMediaFormat, null, null, MediaCodec.CONFIGURE_FLAG_ENCODE);
            videoEncoderSurface = videoEncoder.createInputSurface();

            // init encoder listener
//            initVideoEncoderListener();

        } catch (IOException e) {
            result = "create media codec failed, info:" + e.getMessage();
            Log.e(TAG, "initMediaEncode(), create media codec failed, info:" + e.getMessage());
            e.printStackTrace();
        }

        return result;
    }

    private void initVideoEncoderListener() {
        // set input/output listener
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            videoEncoder.setOnFrameRenderedListener(new MediaCodec.OnFrameRenderedListener() {
                @Override
                public void onFrameRendered(@androidx.annotation.NonNull MediaCodec codec, long presentationTimeUs, long nanoTime) {
                    Log.d(TAG, "onFrameRendered(), entry, presentationTimeUs=" + presentationTimeUs);
                }
            }, null);
        }
//        videoEncoder.setCallback(new MediaCodec.Callback() {
//            @Override
//            public void onInputBufferAvailable(@androidx.annotation.NonNull MediaCodec codec, int index) {
//                Log.d(TAG, "videoEncoder.Callback().onInputBufferAvailable(), entry, index=" + index);
//            }
//
//            @Override
//            public void onOutputBufferAvailable(@androidx.annotation.NonNull MediaCodec codec, int index, @androidx.annotation.NonNull MediaCodec.BufferInfo info) {
//                Log.d(TAG, "videoEncoder.Callback().onOutputBufferAvailable(), entry, index=" + index + ", bufferInfo =" + info);
//            }
//
//            @Override
//            public void onError(@androidx.annotation.NonNull MediaCodec codec, @androidx.annotation.NonNull MediaCodec.CodecException e) {
//                Log.d(TAG, "videoEncoder.Callback().onError(), entry, info:" + e.getMessage());
//            }
//
//            @Override
//            public void onOutputFormatChanged(@androidx.annotation.NonNull MediaCodec codec, @androidx.annotation.NonNull MediaFormat format) {
//                Log.d(TAG, "videoEncoder.Callback().onOutputFormatChanged(), entry, format=" + format);
//            }
//        });
    }

    private int testFlag = 0;

    private void encodeVideoFrame() {
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        int outputIndex = videoEncoder.dequeueOutputBuffer(bufferInfo, 20000);
        switch (outputIndex) {
            case MediaCodec.INFO_OUTPUT_BUFFERS_CHANGED:
                Log.d(TAG, "encodeVideoFrame(), INFO_OUTPUT_BUFFERS_CHANGED");
                break;
            case MediaCodec.INFO_OUTPUT_FORMAT_CHANGED:
                MediaFormat outputFormat = videoEncoder.getOutputFormat();
                videoTrackIndex = videoMuxer.addTrack(outputFormat);
                videoMuxer.start();
                videoMuxerStarted = true;
                Log.d(TAG, "encodeVideoFrame(), videoMuxer.start()");
                break;
            case MediaCodec.INFO_TRY_AGAIN_LATER:
//                if (videoMuxerStarted && null != latestFrameBuffer && null != latestFrameBufferInfo) {
//                    Log.d(TAG, "encodeVideoFrame(), dequeueOutputBuffer timed out, write the latestFrameBuffer");
//                    latestFrameBufferInfo.presentationTimeUs = lastWriteFrameTimestampUs + 20_000;
//                    videoMuxer.writeSampleData(videoTrackIndex, latestFrameBuffer, latestFrameBufferInfo);
//                    lastWriteFrameTimestampUs = latestFrameBufferInfo.presentationTimeUs;
//                }
                break;
            default:
                ByteBuffer curFrameBuffer;

                while (outputIndex >= 0) {
//                    curFrameBuffer = videoEncoder.getOutputBuffer(outputIndex);
//                    videoMuxer.writeSampleData(videoTrackIndex, curFrameBuffer, bufferInfo);
//                    videoEncoder.releaseOutputBuffer(outputIndex, false);
//                    outputIndex = videoEncoder.dequeueOutputBuffer(bufferInfo, 50000);
//
//                    String logInfo = String.format(Locale.getDefault(),", bufferInfo.flags=%d, bufferInfo.offset=%d, bufferInfo.size=%d, bufferInfo.presentationTimeUs=%d",
//                            bufferInfo.flags, bufferInfo.offset, bufferInfo.size, bufferInfo.presentationTimeUs);
//                    Log.d(TAG, "encodeVideoFrame(), write a sample video data " + logInfo);


                    /////////////////////////////////////////////////////////////////////////////
                    curFrameBuffer = videoEncoder.getOutputBuffer(outputIndex);
//                    videoMuxer.writeSampleData(videoTrackIndex, curFrameBuffer, bufferInfo);
//                    Log.d(TAG, "encodeVideoFrame(), write a sample video data interval:" + (bufferInfo.presentationTimeUs - lastWriteFrameTimestampUs) / 1000);
//                    lastWriteFrameTimestampUs = bufferInfo.presentationTimeUs;
//                    Log.d(TAG, "encodeVideoFrame(), bufferInfo.flags=" + bufferInfo.flags);



                    if (0 == lastWriteFrameTimestampUs) {
                        videoMuxer.writeSampleData(videoTrackIndex, curFrameBuffer, bufferInfo);
//                        videoMuxer.writeSampleData(videoTrackIndex, curFrameBuffer, bufferInfo);
                        Log.d(TAG, "encodeVideoFrame(), write first sample video data :" + bufferInfo.presentationTimeUs + ",flag=" + bufferInfo.flags);
                        lastWriteFrameTimestampUs = bufferInfo.presentationTimeUs;
                    } else {
//                        while (bufferInfo.presentationTimeUs - lastWriteFrameTimestampUs > 20_000) {
//                            latestFrameBufferInfo.presentationTimeUs = lastWriteFrameTimestampUs + 20_000;
//                            videoMuxer.writeSampleData(videoTrackIndex, latestFrameBuffer, latestFrameBufferInfo);
//
//                            Log.d(TAG, "encodeVideoFrame(), write a sample video data of interval:" + (latestFrameBufferInfo.presentationTimeUs - lastWriteFrameTimestampUs) / 1000);
//                            lastWriteFrameTimestampUs = latestFrameBufferInfo.presentationTimeUs;
//                        }


                        if (bufferInfo.presentationTimeUs - lastWriteFrameTimestampUs > 20_000) {
                            videoMuxer.writeSampleData(videoTrackIndex, curFrameBuffer, bufferInfo);
                            Log.d(TAG, "encodeVideoFrame(), write a sample video data of interval:" + (latestFrameBufferInfo.presentationTimeUs - lastWriteFrameTimestampUs) / 1000);
                            lastWriteFrameTimestampUs = bufferInfo.presentationTimeUs;
                        }
                    }


                    // record last frame data
                    Log.d(TAG, "encodeVideoFrame(), bufferInfo.flags=" + bufferInfo.flags);
                    if (bufferInfo.flags == MediaCodec.BUFFER_FLAG_KEY_FRAME) {
                        latestFrameBuffer = ByteBuffer.allocate(curFrameBuffer.capacity());
                        latestFrameBuffer.put(curFrameBuffer);
                        latestFrameBuffer.flip();

                        latestFrameBufferInfo = new MediaCodec.BufferInfo();
                        latestFrameBufferInfo.presentationTimeUs = bufferInfo.presentationTimeUs;
                        latestFrameBufferInfo.flags = bufferInfo.flags;
                        latestFrameBufferInfo.size = bufferInfo.size;
                    }



//                    {
//                        MediaCodec.BufferInfo tmpBufferInfo = new MediaCodec.BufferInfo();
//
//                        tmpBufferInfo.presentationTimeUs = bufferInfo.presentationTimeUs;
//                        tmpBufferInfo.flags = bufferInfo.flags;
//                        tmpBufferInfo.size = bufferInfo.size;
//                        ByteBuffer tmpFrameData = ByteBuffer.allocate(curFrameBuffer.capacity());
//                        tmpFrameData.put(curFrameBuffer);
//                        tmpFrameData.flip();
//                        videoMuxer.writeSampleData(videoTrackIndex, tmpFrameData, tmpBufferInfo);
//                    }


//                    String logInfo = String.format(Locale.getDefault(),", bufferInfo.flags=%d, bufferInfo.offset=%d, bufferInfo.size=%d, bufferInfo.presentationTimeUs=%d",
//                            bufferInfo.flags, bufferInfo.offset, bufferInfo.size, bufferInfo.presentationTimeUs);
//                    Log.d(TAG, "encodeVideoFrame(), after dequeue output buffer, write a sample video data " + logInfo);

//                    if (bufferInfo.flags != MediaCodec.BUFFER_FLAG_CODEC_CONFIG) {
//                        Log.d(TAG, "encodeVideoFrame(), record latest frame data, presentationTimeUs=" + bufferInfo.presentationTimeUs / 1000);
//                        latestFrameBuffer = ByteBuffer.allocate(curFrameBuffer.capacity());
                        synchronized (lastFrameDataSync) {
//                            Log.d(TAG, "encodeVideoFrame(), lastFrameDataSync got");
                            if (null == latestFrameBuffer && null == latestFrameBufferInfo) {
//                                latestFrameBuffer = curFrameBuffer;

//                                latestFrameBuffer = ByteBuffer.allocate(curFrameBuffer.capacity());
//                                latestFrameBuffer.put(curFrameBuffer);
//                                latestFrameBuffer.flip();
//
//                                latestFrameBufferInfo = new MediaCodec.BufferInfo();
//                                latestFrameBufferInfo.presentationTimeUs = bufferInfo.presentationTimeUs;
//                                latestFrameBufferInfo.flags = bufferInfo.flags;
//                                latestFrameBufferInfo.size = bufferInfo.size;

                            }

//                            Log.d(TAG, "after write to latestFrameBuffer, frame data=" + Arrays.toString(latestFrameBuffer.array()));
//                            Log.d(TAG, "encodeVideoFrame(), record latest frame data, latestFrameBuffer=" + ((Object)latestFrameBuffer).hashCode());
//                             Log.d(TAG, "encodeVideoFrame(), lastFrameDataSync release");
                        }

//                    }




                    videoEncoder.releaseOutputBuffer(outputIndex, false);
//                    break;
                    outputIndex = videoEncoder.dequeueOutputBuffer(bufferInfo, 0);
//                    Log.d(TAG, "encodeVideoFrame(), outputIndex=" + outputIndex);
                    /////////////////////////////////////////////////////////////////////////////
                }
                break;
        }
    }

    MediaCodec.BufferInfo latestFrameBufferInfo = null;
    ByteBuffer latestFrameBuffer = null;
    public static final Object lastFrameDataSync = new Object();
    long lastWriteFrameTimestampUs = 0;

    private void startWriteFrameThread() {
        new Thread(new Runnable() {
            @Override
            public void run() {
//                latestFrameBuffer = null;
//                latestFrameBufferInfo = null;
                Log.d(TAG, "startWriteFrameThread(), entry");
                while (recording) {
                    if (videoMuxerStarted && null != latestFrameBuffer && null != latestFrameBufferInfo) {
//                        if (0 == lastFrameTimestamp || lastFrameTimestamp != latestFrameBufferInfo.presentationTimeUs) {
//                        if (0 == lastFrameTimestamp) {
//                            if (0 == lastFrameTimestamp) {
//                            lastFrameTimestamp = latestFrameBufferInfo.presentationTimeUs;
//                            } else {
//                                lastFrameTimestamp += 20000;
//                            }



//                            synchronized (lastFrameDataSync) {
////                                Log.d(TAG, "startWriteFrameThread(), lastFrameDataSync got");
////                                latestFrameBufferInfo.presentationTimeUs = lastFrameTimestamp;
//                                Log.d(TAG, "startWriteFrameThread(), write a sample data, latestFrameBufferInfo.presentationTimeUs=" + latestFrameBufferInfo.presentationTimeUs);
//                                videoMuxer.writeSampleData(videoTrackIndex, latestFrameBuffer, latestFrameBufferInfo);
//                                lastFrameTimestamp = latestFrameBufferInfo.presentationTimeUs;
//
//                                latestFrameBuffer = null;
//                                latestFrameBufferInfo = null;
////                                Log.d(TAG, "startWriteFrameThread(), lastFrameDataSync release");
//                            }


//                        }
                    }
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Log.d(TAG, "startWriteFrameThread(), exit");
            }
        }).start();
    }
}
