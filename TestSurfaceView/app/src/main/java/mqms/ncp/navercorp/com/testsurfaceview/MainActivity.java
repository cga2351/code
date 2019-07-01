package mqms.ncp.navercorp.com.testsurfaceview;

import android.Manifest;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.YuvImage;
import android.hardware.Camera;
import android.hardware.display.DisplayManager;
import android.hardware.display.VirtualDisplay;
import android.media.MediaRecorder;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjectionManager;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jp.co.cyberagent.android.gpuimage.GPUImage;
import jp.co.cyberagent.android.gpuimage.GPUImageRenderer;
import jp.co.cyberagent.android.gpuimage.GPUImageView;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.sv_1)
    SurfaceView sv1;
    @BindView(R.id.glsv_1)
    GLSurfaceView glsv1;
    @BindView(R.id.btn_1)
    Button btn1;
    @BindView(R.id.btn_2)
    Button btn2;

    Canvas canvas;
    public static Typeface typeface = Typeface.createFromFile("/sdcard/mqms/Courier.ttf");
    SurfaceHolder surfaceHolder;

    Camera camera;
    private MediaRecorder mediaRecorder = null;
    private boolean recording = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 100);
        }

        surfaceHolder = sv1.getHolder();
        surfaceHolder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                Log.d("-yuliang", "surfaceCreated(), entry");
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
                Log.d("-yuliang", "surfaceChanged(), entry");
            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                Log.d("-yuliang", "surfaceDestroyed(), entry");
            }
        });


    }

    public void stopRecordScreen() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (null != mediaRecorder) {
                mediaRecorder.stop();
                mediaRecorder.release();
                mediaRecorder = null;
            }
        }
        recording = false;
    }

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
//            TextureView textureView;
//            textureView.getSurfaceTexture().setOnFrameAvailableListener();
//            mediaRecorder.setInputSurface(sv1.getHolder().getSurface());
//            mediaRecorder.setPreviewDisplay(sv1.getHolder().getSurface());
            mediaRecorder.setVideoSource(MediaRecorder.VideoSource.SURFACE);
//                mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
            mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
//                mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
            mediaRecorder.setOutputFile(recordFilePath);
            mediaRecorder.setVideoEncodingBitRate(5 * width * height);
            mediaRecorder.setVideoEncoder(MediaRecorder.VideoEncoder.DEFAULT);
            mediaRecorder.setVideoSize(width, height);
            mediaRecorder.setVideoFrameRate(30);
            mediaRecorder.setCaptureRate(30);
            try {
                mediaRecorder.prepare();
                Log.d("-mqmsdebug", "startRecordScreen(), start record");
                mediaRecorder.start();
                recording = true;
            } catch (IOException e) {
                e.printStackTrace();
                stopRecordScreen();
                Log.d("-mqmsdebug", "startRecordScreen(), MediaRecorder prepare exception, info:" + e.getMessage());
            }
        }
    }

    private void savePreviewDataToBitmap(byte[] previewData) {
//        byte[] previewData = HookVideoHandle.addedWaterMarkPreviewData.poll();

//                        byte[] rotateData = WaterMarkUtils.rotateYUV420Degree90(previewData, WaterMarkUtils.cameraWidth, WaterMarkUtils.cameraHeight);

        // save to file
        try {
//                            Bitmap bitmap = WaterMarkUtils.yuvToBitmap(previewData, WaterMarkUtils.cameraWidth, WaterMarkUtils.cameraHeight);
//
//                            // rotate 90
//                            Matrix matrix = new Matrix();
//                            matrix.setRotate(90);
//
//                            Bitmap newBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false);

            // save to file
//                            if (null != newBitmap) {
            String saveFileName = "/sdcard/mqms/tmp/testSavePic/testSaveFinalBitmap.jpeg";
            File saveFile = new File(saveFileName);
            if (saveFile.exists()) {
                saveFile.delete();
            }
            saveFile.createNewFile();

//                                if (previewDataFileIndex % 2 == 0) {
            YuvImage yuvImage = new YuvImage(previewData, imageFormat, 1280, 720, null);
            ByteArrayOutputStream tmpJpegData = new ByteArrayOutputStream();
            yuvImage.compressToJpeg(new Rect(0, 0, 1280, 720), 70, tmpJpegData);

            Bitmap tmpBitmap = BitmapFactory.decodeByteArray(tmpJpegData.toByteArray(), 0, tmpJpegData.size());
            // rotate 90, and scale to screen size
            Matrix matrix = new Matrix();
            matrix.postRotate(90);
//            matrix.postScale((float) 1080 / (float) 720, (float) 2220 / 1280);

            Bitmap newBitmap = Bitmap.createBitmap(tmpBitmap, 0, 0, tmpBitmap.getWidth(), tmpBitmap.getHeight(), matrix, false);
            newBitmap.compress(Bitmap.CompressFormat.JPEG, 70, new FileOutputStream(saveFile));
//                                    yuvImage.compressToJpeg(new Rect(0, 0, WaterMarkUtils.cameraWidth, WaterMarkUtils.cameraHeight), 70, new FileOutputStream(saveFile));
//                                } else {
//                                    newBitmap.compress(Bitmap.CompressFormat.JPEG, 70, new FileOutputStream(saveFile));
//                                }

//            previewDataFileIndex++;
//                            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    int textIndex = 0;
    boolean preview = false;
    private static int currentFrameNum = 1;
    private static int previewWidth = 1280;
    private static int previewHeight = 720;
    public static int SCALE_X = 0;
    public static int SCALE_Y = 0;
    public static int waterMarkWidth = 0;
    public static int waterMarkHeight = 0;
    public static int screenWidth = 0;
    public static int screenHeigth = 0;
    public static boolean init = false;
    public static long currentFrameTime = 0;
    public static long firstFrameTime = 0;
    public static int imageFormat = ImageFormat.NV21;

    @OnClick({R.id.btn_1, R.id.btn_2, R.id.btn_3, R.id.btn_4})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_1:
                ///////////////////////////////////////////////////////////////////////////////////
//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        try {
//                            Thread.sleep(6000);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//
//                        if (0 == textIndex) {
//                            Paint backgroundPaint = new Paint();
//                            backgroundPaint.setColor(Color.BLACK);
//                            backgroundPaint.setStyle(Paint.Style.FILL);
//                            Paint textPaint = new Paint();
//                            textPaint.setColor(Color.WHITE);
//                            textPaint.setStyle(Paint.Style.FILL);
//                            textPaint.setAntiAlias(true);
//                            textPaint.setTypeface(typeface);
//                            textPaint.setTextSize(32f);
//
//                            for (int i = 0; i < 1000; i++) {
//                                canvas = surfaceHolder.lockCanvas();
//                                Rect rect = canvas.getClipBounds();
//                                canvas.drawRect(rect, backgroundPaint);
//                                canvas.drawText("draw text:" + textIndex, 100, 100, textPaint);
//                                textIndex++;
//                                try {
//                                    Thread.sleep(10);
//                                } catch (InterruptedException e) {
//                                    e.printStackTrace();
//                                }
//                                surfaceHolder.unlockCanvasAndPost(canvas);
//                                canvas = null;
//                            }
//                            textIndex = 0;
//                        }
//
//                    }
//                }).start();
                ///////////////////////////////////////////////////////////////////////////////////
                if (preview) {
                    Log.d("-mqmsdebug", "onViewClicked(), stop preview");
                    stopRecordScreen();

                    camera.stopPreview();
                    camera.release();
                    preview = false;

                } else {
                    Log.d("-mqmsdebug", "onViewClicked(), start preview");
                    int mCameraId = Camera.CameraInfo.CAMERA_FACING_BACK;
                    camera = Camera.open(mCameraId);
                    Camera.Parameters parameters = camera.getParameters();
//                    parameters.set("orientation", "portrait");
                    parameters.setFocusMode(Camera.Parameters.FOCUS_MODE_CONTINUOUS_PICTURE);
//                    parameters.setPreviewSize(1280, 720);
                    List<Camera.Size> sizes = camera.getParameters().getSupportedPreviewSizes();
                    parameters.setPreviewSize(1280, 720);
                    parameters.setPreviewFormat(imageFormat);
                    camera.setDisplayOrientation(90);
                    camera.setParameters(parameters);
                    currentFrameNum = 1;
                    init = false;

                    WindowManager windowManager = (WindowManager)getSystemService(Context.WINDOW_SERVICE);
                    windowManager = getWindowManager();
                    Display display = windowManager.getDefaultDisplay();
                    DisplayMetrics displayMetrics = new DisplayMetrics();
                    display.getMetrics(displayMetrics);
                    screenHeigth = displayMetrics.heightPixels;
                    screenWidth = displayMetrics.widthPixels;
                    screenHeigth = 640;
                    screenWidth = 360;
                    currentFrameTime = System.currentTimeMillis();
                    firstFrameTime = currentFrameTime;

                    if(previewHeight * screenHeigth > screenWidth * previewWidth) {
                        SCALE_X = Math.round((float)screenWidth / screenHeigth * previewWidth);
                        SCALE_Y = previewWidth;
                    }
                    else if(previewHeight * screenHeigth < screenWidth * previewWidth) {
                        SCALE_Y = Math.round((float)screenHeigth / screenWidth * previewHeight);
                        SCALE_X = previewHeight;
                    }
                    else {
                        SCALE_X = previewHeight;
                        SCALE_Y = previewWidth;
                    }

                    camera.setPreviewCallbackWithBuffer(new Camera.PreviewCallback() {
                        @Override
                        public void onPreviewFrame(byte[] data, Camera camera) {
                            Log.d("-mqmsdebug", "onPreviewFrame(), entry");
                            camera.addCallbackBuffer(data);

                            //////////////////////////////////////////////////////////////////////
                            machiningFrameData(data, currentFrameTime, currentFrameNum);
                            currentFrameNum++;
                            //////////////////////////////////////////////////////////////////////
//                            savePreviewDataToBitmap(data);
                            //////////////////////////////////////////////////////////////////////
                        }
                    });

                    try {
                        camera.setPreviewDisplay(surfaceHolder);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

//                    byte[] previewData = new byte[1280 * 720 * ImageFormat.getBitsPerPixel(imageFormat) / 8];
                    byte[] previewData = new byte[1280 * 720 * ImageFormat.getBitsPerPixel(imageFormat) / 8];
                    camera.addCallbackBuffer(previewData);

                    camera.startPreview();
                    preview = true;

                    GPUImageView gpuImageView;
                    GPUImage gpuImage;
                    GPUImageRenderer gpuImageRenderer;

                    // start record
//                    WindowManager wm = (WindowManager) MainActivity.this.getSystemService(ContextWrapper.WINDOW_SERVICE);
//                    Display display = wm.getDefaultDisplay();
//                    DisplayMetrics displayMetrics = new DisplayMetrics();
//                    display.getRealMetrics(displayMetrics);
//                    startRecordScreen(displayMetrics.widthPixels,
//                            displayMetrics.heightPixels,
//                            displayMetrics.densityDpi,
//                            "/sdcard/mqms/tmp/testRecordSurfaceVideo.mp4",
//                            System.currentTimeMillis() + 1000);
                }
                ///////////////////////////////////////////////////////////////////////////////////
//                if (null == canvas) {
//                    canvas = surfaceHolder.lockCanvas();
//                }
//                Paint backgroundPaint = new Paint();
//                backgroundPaint.setColor(Color.BLACK);
//                backgroundPaint.setStyle(Paint.Style.FILL);
//                Rect rect = canvas.getClipBounds();
//                canvas.drawRect(rect, backgroundPaint);
//
//                Paint textPaint = new Paint();
//                textPaint.setColor(Color.WHITE);
//                textPaint.setStyle(Paint.Style.FILL);
//                textPaint.setAntiAlias(true);
//                textPaint.setTypeface(typeface);
//                textPaint.setTextSize(36f);
//                canvas.drawText("draw text " + textIndex, 100, 100, textPaint);
//                surfaceHolder.unlockCanvasAndPost(canvas);
//                canvas = null;
//                textIndex++;
                ///////////////////////////////////////////////////////////////////////////////////
                break;
            case R.id.btn_2:
                break;
            case R.id.btn_3:
                break;
            case R.id.btn_4:
                break;
        }
    }

    public static void saveYuvData(String filaName, byte[] data) {
        String filePath = "/sdcard/mqms/tmp/testSavePic/" + filaName;
        if (imageFormat == ImageFormat.NV21) {
            filePath += ".nv21";
        } else if (imageFormat == ImageFormat.YV12) {
            filePath += ".yv12";
        }

        File file = new File(filePath);
        if (file.exists()) {
            file.delete();
        }
        try {
            file.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(filePath);
            fileOutputStream.write(data);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void machiningFrameData(byte[] data, long currentFrameTime, int _currentFrameNum) {
//        // original image
        saveYuvData("testSaveOriginalYuvBitmap", data);
//        {
//            try {
//                String saveFileName = "/sdcard/mqms/tmp/testSavePic/testSaveOriginalYuvBitmap.jpeg";
//                File saveFile = new File(saveFileName);
//                if (saveFile.exists()) {
//                    saveFile.delete();
//                }
//                saveFile.createNewFile();
//
//                YuvImage yuvImage = new YuvImage(data, imageFormat, previewWidth, previewHeight, null);
//                ByteArrayOutputStream tmpJpegData = new ByteArrayOutputStream();
//                yuvImage.compressToJpeg(new Rect(0, 0, previewWidth, previewHeight), 70, tmpJpegData);
//
//                Bitmap tmpBitmap = BitmapFactory.decodeByteArray(tmpJpegData.toByteArray(), 0, tmpJpegData.size());
//                // rotate 90, and scale to screen size
//                Matrix matrix = new Matrix();
//                matrix.postRotate(90);
//
//                Bitmap newBitmap = Bitmap.createBitmap(tmpBitmap, 0, 0, tmpBitmap.getWidth(), tmpBitmap.getHeight(), matrix, false);
//                newBitmap.compress(Bitmap.CompressFormat.JPEG, 70, new FileOutputStream(saveFile));
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }



        Bitmap bitmap = tvConvertedToBitmap(currentFrameTime, _currentFrameNum);
        if(bitmap != null) {
            byte[] bytesYUV = getYUVByBitmap(bitmap);
            combine(data, bytesYUV);
            Logger.debug("-mqmsdebug", "machiningFrameData(), after combine()");


//            // watermark
            saveYuvData("testSaveYuvWatermark", bytesYUV);
//            {
//                try {
//                    String saveFileName = "/sdcard/mqms/tmp/testSavePic/testSaveYuvWatermark.jpeg";
//                    File saveFile = new File(saveFileName);
//                    if (saveFile.exists()) {
//                        saveFile.delete();
//                    }
//                    saveFile.createNewFile();
//
//                    YuvImage yuvImage = new YuvImage(bytesYUV, imageFormat, bitmap.getWidth(), bitmap.getHeight(), null);
//                    ByteArrayOutputStream tmpJpegData = new ByteArrayOutputStream();
//                    yuvImage.compressToJpeg(new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), 70, tmpJpegData);
//
//                    Bitmap tmpBitmap = BitmapFactory.decodeByteArray(tmpJpegData.toByteArray(), 0, tmpJpegData.size());
//                    // rotate 90, and scale to screen size
//                    Matrix matrix = new Matrix();
//                    matrix.postRotate(90);
//
//                    Bitmap newBitmap = Bitmap.createBitmap(tmpBitmap, 0, 0, tmpBitmap.getWidth(), tmpBitmap.getHeight(), matrix, false);
//                    newBitmap.compress(Bitmap.CompressFormat.JPEG, 70, new FileOutputStream(saveFile));
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            // combine image
            saveYuvData("testSaveYuvBitmap", data);
//            {
//                try {
//                    String saveFileName = "/sdcard/mqms/tmp/testSavePic/testSaveYuvBitmap.jpeg";
//                    File saveFile = new File(saveFileName);
//                    if (saveFile.exists()) {
//                        saveFile.delete();
//                    }
//                    saveFile.createNewFile();
//
//                    YuvImage yuvImage = new YuvImage(data, imageFormat, previewWidth, previewHeight, null);
//                    ByteArrayOutputStream tmpJpegData = new ByteArrayOutputStream();
//                    yuvImage.compressToJpeg(new Rect(0, 0, previewWidth, previewHeight), 70, tmpJpegData);
//
//                    Bitmap tmpBitmap = BitmapFactory.decodeByteArray(tmpJpegData.toByteArray(), 0, tmpJpegData.size());
//                    // rotate 90, and scale to screen size
//                    Matrix matrix = new Matrix();
//                    matrix.postRotate(90);
//
//                    Bitmap newBitmap = Bitmap.createBitmap(tmpBitmap, 0, 0, tmpBitmap.getWidth(), tmpBitmap.getHeight(), matrix, false);
//                    newBitmap.compress(Bitmap.CompressFormat.JPEG, 70, new FileOutputStream(saveFile));
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
        }
    }

    private static Bitmap tvConvertedToBitmap(long currentFrameTime, int _currentFrameNum) {
        if(previewWidth == 0 || previewHeight == 0) {
            //return null;
            previewWidth = 1280;
            previewHeight = 720;
        }

        if(!init) {
            waterMarkWidth = SCALE_X * 76 / 100;
            waterMarkHeight = SCALE_Y * 10 / 100;
            init = true;
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
        textPaint.setTypeface(typeface);

        String text = String.format("#%04d.%05d#", _currentFrameNum, (currentFrameTime - firstFrameTime) / 10);//以10MS为单位
        setTextSizeForWidth(textPaint, waterMarkWidth, text);

        Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
        float top = fontMetrics.top;
        float bottom = fontMetrics.bottom;
        int baseLineY = (int) (rect.centerY() - top / 2 - bottom / 2);

        canvas.drawText(text, rect.centerX(), baseLineY, textPaint);

        Matrix matrix = new Matrix();
        matrix.postRotate(-90);
        Log.i("machiningFrameData :", waterMarkWidth + "     " + waterMarkHeight);
        Bitmap newBM = Bitmap.createBitmap(bitmap, 0, 0, waterMarkWidth, waterMarkHeight, matrix, false);
        if (!bitmap.isRecycled()) {
            bitmap.recycle();
        }


        try {
            newBM.compress(Bitmap.CompressFormat.JPEG, 90, new FileOutputStream("/sdcard/mqms/tmp/waterMark.jpeg"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        return newBM;
    }

    private static Rect testbounds = new Rect();
    private static void setTextSizeForWidth(Paint paint, float desiredWidth, String text) {
        final float testTextSize = 48f;
        paint.setTextSize(testTextSize);
        paint.getTextBounds(text, 0, text.length(), testbounds);
        float desiredTextSize = testTextSize * desiredWidth / testbounds.width() - 4;
        paint.setTextSize(desiredTextSize);
    }

    private static byte[] getYUVByBitmap(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int size = width * height;
        int pixels[] = new int[size];
        bitmap.getPixels(pixels, 0, width, 0, 0, width, height);
        byte[] data;
//        data = rgb2YCbCr420(pixels, width, height);
//        data = rgb2nv21(pixels, width, height);
        data = rgb2yv12(pixels, width, height);

        if (!bitmap.isRecycled()) {
            bitmap.recycle();
        }

        return data;
    }

    private static byte[] rgb2YCbCr420(int[] argb, int width, int height) {
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

    private static byte[] rgb2yv12(int[] argb, int width, int height) {
        Logger.debug("-mqmsdebug", "rgb2yv12(), 111");
        final int frameSize = width * height;

        byte[] yv12;
//        yv12 = new byte[width * height * 3 / 2];
        yv12 = new byte[width * height + 2 * (int) Math.ceil(width / 2.0) * (int) Math.ceil(height / 2.0)];
//        Logger.debug("-mqmsdebug", "rgb2yv12(), 222, yv12.length=" + yv12.length + ", width=" + width + ", height=" + height);

        int yIndex = 0;
        int uvIndex = frameSize;

        int R, G, B, Y, U, V;
        int index = 0;

        for (int j = 0; j < height; j++) {
            for (int i = 0; i < width; i++) {

                R = (argb[index] & 0xff0000) >> 16;
                G = (argb[index] & 0xff00) >> 8;
                B = (argb[index] & 0xff) >> 0;

                Y = (int)(0.299 * R + 0.587 * G + 0.114 * B);
                U = (int)(-0.1687 * R - 0.3313 * G + 0.5 * B + 128);
                V = (int)(0.5 * R - 0.4187 * G - 0.0813 * B + 128);

                yv12[yIndex++] = (byte) ((Y < 0) ? 0 : ((Y > 255) ? 255 : Y));
                if (j % 2 == 0 && index % 2 == 0) {
                    yv12[uvIndex] = (byte) ((V < 0) ? 0 : ((V > 255) ? 255 : V));
                    yv12[uvIndex + frameSize / 4] = (byte) ((U < 0) ? 0 : ((U > 255) ? 255 : U));
                    uvIndex++;
                }

                index++;

            }

        }

        Logger.debug("-mqmsdebug", "rgb2yv12(), xxx");

        return yv12;
    }

    private static byte[] rgb2nv21(int[] argb, int width, int height) {
        Logger.debug("-mqmsdebug", "rgb2nv21(), 111");
        final int frameSize = width * height;

        byte[] nv21;
//        nv21 = new byte[width * height * 3 / 2];
        nv21 = new byte[width * height + 2 * (int) Math.ceil(width / 2.0) * (int) Math.ceil(height / 2.0)];
//        Logger.debug("-mqmsdebug", "rgb2nv21(), 222, nv21.length=" + nv21.length + ", width=" + width + ", height=" + height);

        int yIndex = 0;
        int uvIndex = frameSize;

        int R, G, B, Y, U, V;
        int index = 0;

//        Logger.debug("-mqmsdebug", "rgb2nv21(), 333");
        for (int j = 0; j < height; j++) {
            for (int i = 0; i < width; i++) {
//                Logger.debug("-mqmsdebug", "rgb2nv21(), 444, calc yuv data");

                R = (argb[index] & 0xff0000) >> 16;
                G = (argb[index] & 0xff00) >> 8;
                B = (argb[index] & 0xff) >> 0;

                Y = (int)(0.299 * R + 0.587 * G + 0.114 * B);
                U = (int)(-0.1687 * R - 0.3313 * G + 0.5 * B + 128);
                V = (int)(0.5 * R - 0.4187 * G - 0.0813 * B + 128);

//                Logger.debug("-mqmsdebug", "rgb2nv21(), 555, set y data");
                nv21[yIndex++] = (byte) ((Y < 0) ? 0 : ((Y > 255) ? 255 : Y));
//                Logger.debug("-mqmsdebug", "rgb2nv21(), 666");
                if (j % 2 == 0 && index % 2 == 0) {
//                    Logger.debug("-mqmsdebug", "rgb2nv21(), 777, set uv data");
                    nv21[uvIndex++] = (byte) ((V < 0) ? 0 : ((V > 255) ? 255 : V));
                    nv21[uvIndex++] = (byte) ((U < 0) ? 0 : ((U > 255) ? 255 : U));
//                    Logger.debug("-mqmsdebug", "rgb2nv21(), 888");
                }

                index++;

//                Logger.debug("-mqmsdebug", "rgb2nv21(), 999");
            }

//            Logger.debug("-mqmsdebug", "rgb2nv21(), 000");
        }

        Logger.debug("-mqmsdebug", "rgb2nv21(), xxx");

        return nv21;
    }

    private static void combine(byte[] initBytes, byte[] waterMarkBytes) {
        combineCal(initBytes, previewWidth, previewHeight, waterMarkBytes,
                waterMarkHeight, waterMarkWidth, (previewWidth - waterMarkHeight) / 2 - previewWidth * 5 / 100,
                (previewHeight - waterMarkWidth) / 2);
    }

    private static void combineCal(byte[] initBytes, int w1, int h1, byte[] waterMarkBytes, int w2, int h2, int off_x, int off_y) {
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
//                nOff = w1 * (off_y / 2 + j) + off_x;
//                System.arraycopy(waterMarkBytes, uv2 + w2 / 2 * j, initBytes, uv1 + nOff, w2);
                nOff = (w1 / 2) * (off_y + j) + off_x;
                System.arraycopy(waterMarkBytes, uv2 + w2 / 2 * j, initBytes, uv1 + nOff, w2 / 2);
            }
        }
        catch (ArrayIndexOutOfBoundsException e) {
            Log.e("Utils combineCal", e.getMessage());
        }
    }
}
