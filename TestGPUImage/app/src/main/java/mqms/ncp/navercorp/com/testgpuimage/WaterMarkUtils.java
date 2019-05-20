package mqms.ncp.navercorp.com.testgpuimage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;

//import com.navercorp.ncp.mqms.mqms_java_hook.Constant;
//import com.navercorp.ncp.mqms.mqms_java_hook.bean.command.StartPlayVideoReq;
//import com.navercorp.ncp.mqms.mqms_java_hook.nativeinterface.NativeHookInterface;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Locale;

import static android.content.Context.WINDOW_SERVICE;

/**
 * Created by xiangning on 2019/2/12.
 */

public class WaterMarkUtils {

    public static long waterMarkStartTimeStamp = 0;
    public static long waterMarkDuration = 0;

    public static long firstFrameTime = 0;
    public static int currentFrameNum = 0;
    public static int videoChatFPS = 0;
    public static int degree = 0;
    public static boolean init = false;
    public static int previewWidth = Constant.previewWidth;
    public static int previewHeight = Constant.previewHeight;
    public static int SCALE_X = 0;
    public static int SCALE_Y = 0;
    public static int waterMarkWidth = 0;
    public static int waterMarkHeight = 0;
    public static int screenWidth = 0;
    public static int screenHeigth = 0;

    public static boolean hasReadRecordTime = false;
    public static boolean isVideoSender = false;
    public static boolean needPlayVideo = false;
    public static boolean startPlayingVideo = false;
    public static boolean addedNewFrameNumber = false;
    public static String playVideoFileFullPath = "";
    public static String recordVideoFileFullPath = "";
    public static MediaCodec.BufferInfo frameInfo = new MediaCodec.BufferInfo();
    public static Typeface typeface = Typeface.createFromFile("/sdcard/mqms/Courier.ttf");


    // for video record
    private static long videoStartTime = 0;
    //    public static boolean recordThreadExit = false;
    private static MediaCodec videoEncoder;
    private static MediaMuxer videoMuxer;
    //    private MediaFormat videoFormat;
//    private int videoEncodeColor;
    private static String videoMediaFormatType = MediaFormat.MIMETYPE_VIDEO_MPEG4;
    private static int videoTrackIndex = 0;

    public static class ScreenSize {

        private Context context;
        private int displayWidth;
        private int displayHeight;

        public int getDisplayWidth() {
            return displayWidth;
        }

        public int getDisplayHeight() {
            return displayHeight;
        }

        public ScreenSize(Context _context) {
            context = _context;
            getScreenShot();
        }

        private void getScreenShot() {
            DisplayMetrics dm = new DisplayMetrics();
            WindowManager wm = (WindowManager) context.getSystemService(WINDOW_SERVICE);
            Display display = wm.getDefaultDisplay();
            display.getRealMetrics(dm);
            Point point = getSize(display);
            displayWidth = point.x;
            displayHeight = point.y;
        }

        @SuppressLint("NewApi")
        @SuppressWarnings("deprecation")
        private Point getSize(Display display) {
            if (Build.VERSION.SDK_INT >= 17) {
                Point outPoint = new Point();
                DisplayMetrics metrics = new DisplayMetrics();
                display.getRealMetrics(metrics);
                outPoint.x = metrics.widthPixels;
                outPoint.y = metrics.heightPixels;
                return outPoint;
            }
            if (Build.VERSION.SDK_INT >= 14) {
                Point outPoint = getRealSize(display);
                if (outPoint != null) {
                    return outPoint;
                }
            }
            Point outPoint = new Point();
            if (Build.VERSION.SDK_INT >= 13) {
                display.getSize(outPoint);
            } else {
                outPoint.x = display.getWidth();
                outPoint.y = display.getHeight();
            }
            return outPoint;
        }

        private Point getRealSize(Display display) {
            Point outPoint = new Point();
            Method mGetRawH;
            try {
                mGetRawH = Display.class.getMethod("getRawHeight");
                Method mGetRawW = Display.class.getMethod("getRawWidth");
                outPoint.x = (Integer) mGetRawW.invoke(display);
                outPoint.y = (Integer) mGetRawH.invoke(display);
                return outPoint;
            } catch (Throwable e) {
                return null;
            }
        }
    }

    public static byte[] rotateYUV420Degree90(byte[] data, int imageWidth, int imageHeight) {
        byte[] yuv = new byte[imageWidth * imageHeight * 3 / 2];
        int i = 0;
        for (int x = 0; x < imageWidth; x++) {
            for (int y = imageHeight - 1; y >= 0; y--) {
                yuv[i] = data[y * imageWidth + x];
                i++;
            }
        }
        i = imageWidth * imageHeight * 3 / 2 - 1;
        for (int x = imageWidth - 1; x > 0; x = x - 2) {
            for (int y = 0; y < imageHeight / 2; y++) {
                yuv[i] = data[(imageWidth * imageHeight) + (y * imageWidth) + x];
                i--;
                yuv[i] = data[(imageWidth * imageHeight) + (y * imageWidth) + (x - 1)];
                i--;
            }
        }
        return yuv;
    }

    public static byte[] rotateYUV420Degree180(byte[] data, int imageWidth, int imageHeight) {
        byte[] yuv = new byte[imageWidth * imageHeight * 3 / 2];
        int i = 0;
        int count = 0;
        for (i = imageWidth * imageHeight - 1; i >= 0; i--) {
            yuv[count] = data[i];
            count++;
        }
        i = imageWidth * imageHeight * 3 / 2 - 1;
        for (i = imageWidth * imageHeight * 3 / 2 - 1; i >= imageWidth
                * imageHeight; i -= 2) {
            yuv[count++] = data[i - 1];
            yuv[count++] = data[i];
        }
        return yuv;
    }

    public static byte[] rotateYUV420Degree270(byte[] data, int imageWidth, int imageHeight) {
        byte[] yuv = new byte[imageWidth * imageHeight * 3 / 2];
        int nWidth = 0, nHeight = 0;
        int wh = 0;
        int uvHeight = 0;
        if (imageWidth != nWidth || imageHeight != nHeight) {
            nWidth = imageWidth;
            nHeight = imageHeight;
            wh = imageWidth * imageHeight;
            uvHeight = imageHeight >> 1;// uvHeight = height / 2
        }

        int k = 0;
        for (int i = 0; i < imageWidth; i++) {
            int nPos = 0;
            for (int j = 0; j < imageHeight; j++) {
                yuv[k] = data[nPos + i];
                k++;
                nPos += imageWidth;
            }
        }
        for (int i = 0; i < imageWidth; i += 2) {
            int nPos = wh;
            for (int j = 0; j < uvHeight; j++) {
                yuv[k] = data[nPos + i];
                yuv[k + 1] = data[nPos + i + 1];
                k += 2;
                nPos += imageWidth;
            }
        }
        return rotateYUV420Degree180(rotateYUV420Degree90(data, imageWidth, imageHeight), imageWidth, imageHeight);
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
        bmp.setPixels(rgba, 0 , width, 0, 0, width, height);
        return bmp;
    }

    public static void machiningFrameData(byte[] data, long currentFrameTime, int _currentFrameNum) {
        Bitmap bitmap = tvConvertedToBitmap(currentFrameTime, _currentFrameNum);
        if(bitmap != null) {
            byte[] bytesYUV = getYUVByBitmap(bitmap);
            combine(data, bytesYUV);
        }
    }


    private static Bitmap tvConvertedToBitmap(long currentFrameTime, int _currentFrameNum) {
        if(previewWidth == 0 || previewHeight == 0) {
            //return null;
            previewWidth = 1280;
            previewHeight = 720;
        }

        if(!init) {
            SCALE_X = WaterMarkUtils.previewHeight;
            SCALE_Y = WaterMarkUtils.previewWidth;

            waterMarkWidth = SCALE_X * 76 / 100;
            waterMarkHeight = SCALE_Y * 10 / 100;
            init = true;
        }

//        Logger.debug("-mqmsdebug", "tvConvertedToBitmap(), SCALE_X=" + SCALE_X + ", SCALE_Y=" + SCALE_Y);
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
        matrix.postRotate(degree);
        Log.i("machiningFrameData :", waterMarkWidth + "     " + waterMarkHeight);
        Bitmap newBM = Bitmap.createBitmap(bitmap, 0, 0, waterMarkWidth, waterMarkHeight, matrix, false);
        if (!bitmap.isRecycled()) {
            bitmap.recycle();
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
        byte[] data = rgb2YCbCr420(pixels, width, height);
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
                nOff = w1 * (off_y / 2 + j) + off_x;
                System.arraycopy(waterMarkBytes, uv2 + w2 / 2 * j, initBytes, uv1 + nOff, w2);
            }
        }
        catch (ArrayIndexOutOfBoundsException e) {
            Log.e("Utils combineCal", e.getMessage());
        }
    }

    public static int[] I420toARGB(byte[] yuv, int width, int height) {
        boolean invertHeight = false;
        if (height < 0) {
            height = -height;
            invertHeight = true;
        }

        boolean invertWidth = false;
        if (width < 0) {
            width = -width;
            invertWidth = true;
        }
        int iterations = width * height;
        int[] rgb = new int[iterations];
        for (int i = 0; i < iterations; i++) {
            int nearest = (i / width) / 2 * (width / 2) + (i % width) / 2;
            int y = yuv[i] & 0x000000ff;
            int u = yuv[iterations + nearest] & 0x000000ff;
            int v = yuv[iterations + iterations / 4 + nearest] & 0x000000ff;
            int b = (int) (y + 1.8556 * (u - 128));
            int g = (int) (y - (0.4681 * (v - 128) + 0.1872 * (u - 128)));
            int r = (int) (y + 1.5748 * (v - 128));

            if (b > 255) {
                b = 255;
            } else if (b < 0) {
                b = 0;
            }
            if (g > 255) {
                g = 255;
            } else if (g < 0) {
                g = 0;
            }
            if (r > 255) {
                r = 255;
            } else if (r < 0) {
                r = 0;
            }
            int targetPosition = i;

            if (invertHeight) {
                targetPosition = ((height - 1) - targetPosition / width) * width + (targetPosition % width);
            }
            if (invertWidth) {
                targetPosition = (targetPosition / width) * width + (width - 1) - (targetPosition % width);
            }
            rgb[targetPosition] = (0xff000000) | (0x00ff0000 & r << 16) | (0x0000ff00 & g << 8) | (0x000000ff & b);
        }
        return rgb;

    }

    public static void addWatermarkAndRecordVideo(byte[] previewData, int previewFormat, long currentFrameTime) {
//        Date date = new Date();
//        byte[] frameData = new byte[previewWidth * previewHeight * 3 / 2];
//        Logger.debug("-mqmsdebug", "addWatermarkAndRecordVideo(), 1");
//        NativeUtils.drawText(previewData, frameData, previewWidth, previewHeight, Constant.v, videoHeight, dateFormat.format(date));

        // add water mark and gen video frame data
        long watermarkTime = (currentFrameTime - firstFrameTime) / 10;    //以10MS为单位
        String textWatermark = String.format(Locale.getDefault(),"#%04d.%05d#", WaterMarkUtils.currentFrameNum, watermarkTime);
        byte[] frameData = new byte[Constant.RECORD_VIDEO_WIDTH * Constant.RECORD_VIDEO_HEIGHT * 3 / 2]; // YUV data size is width * height * 3 / 2

        try {
            NativeUtils.jni_addWatermark(previewData, frameData,
                    previewWidth, previewHeight,
                    Constant.RECORD_VIDEO_WIDTH, Constant.RECORD_VIDEO_HEIGHT,
                    textWatermark,
                    previewFormat);
        } catch (Exception e) {
            e.printStackTrace();
        }

        frameInfo.flags = MediaCodec.BUFFER_FLAG_CODEC_CONFIG;
        frameInfo.presentationTimeUs = (currentFrameTime - firstFrameTime) * 1000;

//        addMediaCodecBuffer(data, frameInfo);
        addMediaCodecBuffer(frameData, frameInfo);
    }

    private static void addMediaCodecBuffer(byte[] data, MediaCodec.BufferInfo videoInfo) {
        if (data == null) {
            Logger.debug("-mqmsdebug", "data ==null ,so end");
            return;
        }

        int inputIndex = videoEncoder.dequeueInputBuffer(50000);
        if (inputIndex < 0) {
            Logger.debug("-mqmsdebug", "dequeueInputBuffer return inputIndex " + inputIndex + ",then break");
//            videoEncoder.signalEndOfInputStream();
            return;
        }
        ByteBuffer inputBuffer = videoEncoder.getInputBuffer(inputIndex);
        inputBuffer.clear();
        inputBuffer.put(data);
        inputBuffer.limit(videoInfo.size);
        videoEncoder.queueInputBuffer(inputIndex, 0, data.length, videoInfo.presentationTimeUs, videoInfo.flags);
    }

    public static void startAddWatermark(StartPlayVideoReq startPlayVideoReq) {
        WaterMarkUtils.waterMarkStartTimeStamp = startPlayVideoReq.getAddWaterMarkTimeStamp();
        WaterMarkUtils.waterMarkDuration = startPlayVideoReq.getDuration();
        WaterMarkUtils.playVideoFileFullPath = startPlayVideoReq.getPlayVideoFullPath();
        WaterMarkUtils.recordVideoFileFullPath = startPlayVideoReq.getRecordVideoFullPath();
        WaterMarkUtils.isVideoSender = true;
        WaterMarkUtils.needPlayVideo = true;
        WaterMarkUtils.startPlayingVideo = false;

        Logger.debug("-mqmsdebug", "startAddWatermark() " +
                ", waterMarkStartTimeStamp = " +  WaterMarkUtils.waterMarkStartTimeStamp +
                ", waterMarkDuration = " +  WaterMarkUtils.waterMarkDuration +
                ", playVideoFileFullPath = " +  WaterMarkUtils.playVideoFileFullPath +
                ", recordVideoFileFullPath = " +  WaterMarkUtils.recordVideoFileFullPath);
    }

    public static String startRecordVideo() {
        String result = Constant.RES_SUCCESS;

        // start record camera data
        result = initMediaEncode();

        // create record video MediaMuxer
        if (result.equals(Constant.RES_SUCCESS)) {
            result = initMediaMuxer();

            if (result.equals(Constant.RES_SUCCESS)) {
                // start media encodeVideoFrame thread
                startVideoEncodeThread();
            }
        }

        return result;
    }

    private static String initMediaMuxer() {
        String result = Constant.RES_SUCCESS;

        try {
//            String playVideoFilePath = startPlayVideoReq.getPlayVideoFullPath();
//            String recordVideoFileFullPath = startPlayVideoReq.getRecordVideoFullPath();
            File recordVideoFile = new File(recordVideoFileFullPath);
            if (recordVideoFile.exists()) {
                recordVideoFile.delete();
            }
            videoMuxer = new MediaMuxer(recordVideoFileFullPath, MediaMuxer.OutputFormat.MUXER_OUTPUT_MPEG_4);
            videoMuxer.setOrientationHint(90);
        } catch (IOException e) {
            result = "create media muxer failed, info:" + e.getMessage();
            Logger.error("-mqmsdebug", "initMediaMuxer(), create media muxer failed");
            e.printStackTrace();
        }

        return result;
    }

    private static void startVideoEncodeThread() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Logger.debug("-mqmsdebug", "startVideoEncodeThread(), entry");
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
//                    Logger.debug("-mqmsdebug", "startVideoEncodeThread(), start playing video");
//                    videoStartTime = System.currentTimeMillis();
                    videoEncoder.start();

                    while (WaterMarkUtils.needPlayVideo) {
                        encodeVideoFrame();
                    }
                    Logger.debug("-mqmsdebug", "startVideoEncodeThread(), stop playing video");
                    videoEncoder.stop();
                    videoEncoder.release();
                    videoMuxer.stop();
                    videoMuxer.release();

                    videoEncoder = null;
                    videoMuxer = null;
//                }
            }
        }).start();
    }

    private static String initMediaEncode() {
        String result = Constant.RES_SUCCESS;

        try {
            videoEncoder = MediaCodec.createEncoderByType(videoMediaFormatType);

            // get supported color format
            int colorFormat = 0;
            MediaCodecInfo.CodecCapabilities capabilities =  videoEncoder.getCodecInfo().getCapabilitiesForType(videoMediaFormatType);
            for (int i = 0; i < capabilities.colorFormats.length; i++) {
                if (capabilities.colorFormats[i] == MediaCodecInfo.CodecCapabilities.COLOR_FormatYUV420Planar) {
                    // 录制视频，media codec的输入数据设置为yuv420p(I420),opencv中处理完成后可以直接转换为该格式
                    colorFormat = MediaCodecInfo.CodecCapabilities.COLOR_FormatYUV420Planar;
                    break;
                }
            }
            if (0 == colorFormat) {
                Logger.error("-mqmsdebug", "media codec do not support yuv420p(I420), need support yuv420sp(NV12)");
            }

            MediaFormat inputMediaFormat = MediaFormat.createVideoFormat(videoMediaFormatType, Constant.RECORD_VIDEO_WIDTH, Constant.RECORD_VIDEO_HEIGHT);
            inputMediaFormat.setInteger(MediaFormat.KEY_BIT_RATE, 6000 * 1024);
            inputMediaFormat.setFloat(MediaFormat.KEY_FRAME_RATE, 30);
            inputMediaFormat.setInteger(MediaFormat.KEY_COLOR_FORMAT, colorFormat);
            inputMediaFormat.setInteger(MediaFormat.KEY_I_FRAME_INTERVAL, 1);

            videoEncoder.configure(inputMediaFormat, null, null, MediaCodec.CONFIGURE_FLAG_ENCODE);
        } catch (IOException e) {
            result = "create media codec failed, info:" + e.getMessage();
            Logger.error("-mqmsdebug", "initMediaEncode(), create media codec failed, info:" + e.getMessage());
            e.printStackTrace();
        }

        return result;
    }

    private static void encodeVideoFrame() {
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        int outputIndex = videoEncoder.dequeueOutputBuffer(bufferInfo, 50000);
        switch (outputIndex) {
            case MediaCodec.INFO_OUTPUT_BUFFERS_CHANGED:
                Logger.debug("-mqmsdebug", "INFO_OUTPUT_BUFFERS_CHANGED");
                break;
            case MediaCodec.INFO_OUTPUT_FORMAT_CHANGED:
                MediaFormat outputFormat = videoEncoder.getOutputFormat();
                videoTrackIndex = videoMuxer.addTrack(outputFormat);
                videoMuxer.start();
                break;
            case MediaCodec.INFO_TRY_AGAIN_LATER:
//                Logger.debug("-mqmsdebug", "dequeueOutputBuffer timed out!");
                break;
            default:
                ByteBuffer outputBuffer;
                while (outputIndex >= 0) {
//                    Logger.debug("-mqmsdebug", "write a sample video data");
                    outputBuffer = videoEncoder.getOutputBuffer(outputIndex);
                    videoMuxer.writeSampleData(videoTrackIndex, outputBuffer, bufferInfo);
                    videoEncoder.releaseOutputBuffer(outputIndex, false);
                    outputIndex = videoEncoder.dequeueOutputBuffer(bufferInfo, 50000);
                }
                break;
        }
    }
}
