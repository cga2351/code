package com.dxtx.codec;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import android.media.MediaMuxer;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.jrzhuxue.identity.common.util.ByteUtil;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by user on 2016/11/14.
 * 视频录制任务,本任务只管加水印,不管增删本地文件,不管数据库
 */
@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
public class VideoCodecTask {

    private MediaExtractor extractor;
    private MediaMuxer muxer;
    private final static String tag = "px";

    private MediaFormat format;

    private int videoMaxInputSize = 0, videoRotation = 0;
    private long videoDuration;
    private int videoDecodeColor = 21, videoEncodeColor = 21;

    private boolean decodeOver = false, encoding = false, mCancel, mDelete;

    //视频流在数据流中的序号
    private int videoTrackIndex = -1;

    private MediaCodec mediaDecode, mediaEncode;
    private ByteBuffer[] decodeInputBuffers, decodeOutputBuffers;

    private ArrayList<Frame> timeDataContainer;//数据块容器

    private MediaCodec.BufferInfo decodeBufferInfo;


    private int srcWidth, srcHeight, dstWidth, dstHeight;

    private SimpleDateFormat videoTimeFormat;

    private int mProgress, mMax;

    private VideoCodecModel mVideo;

    //绘制时间戳的画笔
    private Paint textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Paint backgroundPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private RectF backgroundRect;

    private DecodeRunnable decodeRunnable;
    private EncodeRunnable encodeRunnable;

    public static final int PROGRESS = 0, CANCEL = 1, ERROR = 2, START = 3, COMPLETE = 4;
    private Handler mProgressHandler;

    public VideoCodecTask(VideoCodecModel video) {
        mVideo = video;

        //视频时间戳显示格式
        videoTimeFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

        timeDataContainer = new ArrayList<>();

        //初始化画笔工具
        textPaint.setColor(Color.WHITE);
        textPaint.setTextSize(20);

        backgroundPaint.setColor(0x30000000);
    }

    public void start() {
        if (!new File(mVideo.srcPath).exists()) {
            mProgressHandler.obtainMessage(ERROR, mVideo).sendToTarget();
            return;
        }
        mProgressHandler.obtainMessage(START, mVideo).sendToTarget();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                init(mVideo.srcPath, mVideo.dstPath);
                decodeRunnable = new DecodeRunnable();
                decodeRunnable.start();
                encodeRunnable = new EncodeRunnable();
                encodeRunnable.start();
            }
        };
//        AsyncTaskExecutor.getExecutor().execute(runnable);
        new Thread(runnable).start();
    }

    private void init(String srcPath, String dstPath) {
        MediaMetadataRetriever mmr = new MediaMetadataRetriever();
        mmr.setDataSource(srcPath);
        try {
            srcWidth = Integer.parseInt(mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_VIDEO_WIDTH));
            srcHeight = Integer.parseInt(mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_VIDEO_HEIGHT));
            String frame_rate = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_CAPTURE_FRAMERATE);
            Log.d("px","视频的码率是"+frame_rate);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            extractor = new MediaExtractor();
            extractor.setDataSource(srcPath);

            String mime = null;
            for (int i = 0; i < extractor.getTrackCount(); i++) {
                //获取码流的详细格式/配置信息
                MediaFormat format = extractor.getTrackFormat(i);
                mime = format.getString(MediaFormat.KEY_MIME);
                if (mime.startsWith("video/")) {
                    videoTrackIndex = i;
                    this.format = format;
                } else if (mime.startsWith("audio/")) {
                    continue;
                } else {
                    continue;
                }
            }


            extractor.selectTrack(videoTrackIndex); //选择读取视频数据

            //创建合成器
            srcWidth = format.getInteger(MediaFormat.KEY_WIDTH);
            srcHeight = format.getInteger(MediaFormat.KEY_HEIGHT);
            videoMaxInputSize = format.getInteger(MediaFormat.KEY_MAX_INPUT_SIZE);
            videoDuration = format.getLong(MediaFormat.KEY_DURATION);
            videoRotation = 90;//低版本不支持获取旋转,手动写入了
            if (videoRotation == 90) {
                dstWidth = srcHeight;
                dstHeight = srcWidth;
            } else if (videoRotation == 0) {
                dstWidth = srcWidth;
                dstHeight = srcHeight;
            }

            mMax = (int) (videoDuration / 1000);

            Log.d(tag, "videoWidth=" + srcWidth + ",videoHeight=" + srcHeight + ",videoMaxInputSize=" + videoMaxInputSize + ",videoDuration=" + videoDuration + ",videoRotation=" + videoRotation);

            //写入文件的合成器
            muxer = new MediaMuxer(dstPath, MediaMuxer.OutputFormat.MUXER_OUTPUT_MPEG_4);

            MediaCodec.BufferInfo videoInfo = new MediaCodec.BufferInfo();
            videoInfo.presentationTimeUs = 0;

            initMediaDecode(mime);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 初始化解码器
     */
    private void initMediaDecode(String mime) {
        try {
            //创建解码器
            mediaDecode = MediaCodec.createDecoderByType(mime);
            mediaDecode.configure(format, null, null, 0);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (mediaDecode == null) {
            Log.e(tag, "create mediaDecode failed");
            return;
        }
        mediaDecode.start();
        decodeInputBuffers = mediaDecode.getInputBuffers();
        decodeOutputBuffers = mediaDecode.getOutputBuffers();
        decodeBufferInfo = new MediaCodec.BufferInfo();//用于描述解码得到的byte[]数据的相关信息
    }

    /**
     * 初始化编码器
     */

    private void initMediaEncode() {
        Object[] objects = MediaCodecUtils.initEncoder(dstWidth, dstHeight);
        mediaEncode = (MediaCodec) objects[0];
        MediaFormat format = (MediaFormat) objects[1];
        videoEncodeColor = format.getInteger(MediaFormat.KEY_COLOR_FORMAT);
        if (mediaEncode == null) {
            Log.e(tag, "create mediaEncode failed");
            return;
        }
        mediaEncode.start();
    }


    //抽出每一帧
    private void extract() {
        int inputIndex = mediaDecode.dequeueInputBuffer(-1);//获取可用的inputBuffer -1代表一直等待，0表示不等待 建议-1,避免丢帧
        if (inputIndex < 0) {
            Log.d("px", "=========== code over =======");
            return;
        }

        ByteBuffer inputBuffer = decodeInputBuffers[inputIndex];//拿到inputBuffer
        inputBuffer.clear();

        int length = extractor.readSampleData(inputBuffer, 0);  //读取一帧数据,放到解码队列
        if (length < 0) {
            Log.d("px", "extract Over");
            decodeOver = true;
            return;
        } else {
            MediaCodec.BufferInfo videoInfo = new MediaCodec.BufferInfo();
            videoInfo.offset = 0;
            videoInfo.size = length;
            //获取帧类型，只能识别是否为I帧
            videoInfo.flags = extractor.getSampleFlags();
            videoInfo.presentationTimeUs = extractor.getSampleTime(); //获取时间戳

            //解码视频
            decode(videoInfo, inputIndex);
            extractor.advance(); //移动到下一帧
        }

    }


    private void handleFrameData(byte[] data, MediaCodec.BufferInfo info) {
        //转换Yuv数据成RGB格式的bitmap
        Bitmap image = changeYUV2Bitmap(data);

        //旋转图像
        Bitmap bitmap = rotaingImage(videoRotation, image);
        image.recycle();

        //渲染文字及背景 0-1ms
        Canvas canvas = new Canvas(bitmap);
        if (backgroundRect == null)
            backgroundRect = new RectF(5, 8, 202, 37);//背景范围完全靠猜
        canvas.drawRect(backgroundRect, backgroundPaint);
        canvas.drawText(videoTimeFormat.format(mVideo.videoCreateTime + info.presentationTimeUs / 1000), 10, 30, textPaint);

        //通知进度 0-5ms
        mProgress = (int) (info.presentationTimeUs / 1000);
        mProgressHandler.obtainMessage(PROGRESS, mProgress, mMax, mVideo).sendToTarget();

        synchronized (MediaCodec.class) {//记得加锁
            timeDataContainer.add(new Frame(info, bitmap));
        }
    }

    public Bitmap changeYUV2Bitmap(byte[] data) {
        //YUV420sp转RGB数据 5-60ms
        if (videoDecodeColor == MediaCodecInfo.CodecCapabilities.COLOR_FormatYUV420SemiPlanar)
            return ByteUtil.changeYUV420sp2RGB(data, srcWidth, srcHeight);
        else if (videoDecodeColor == MediaCodecInfo.CodecCapabilities.COLOR_FormatYUV420Planar) {
            int[] rgb = ByteUtil.changeYUV420p2RGB(data, srcWidth, srcHeight);
            Bitmap bitmap = Bitmap.createBitmap(srcWidth, srcHeight, Bitmap.Config.RGB_565);
            bitmap.setPixels(rgb, 0, srcWidth, 0, 0, srcWidth, srcHeight);
            return bitmap;
        } else
            throw new RuntimeException("不支持的手机视频格式");
    }

    /**
     * 获取夹了时间戳的的数据
     *
     * @return
     */
    private Frame getFrameData() {
        if (timeDataContainer.isEmpty()) {
            return null;
        }
        Frame frame;
        synchronized (MediaCodec.class) {//记得加锁
            //从队列中获取数据
            frame = timeDataContainer.remove(0);////取出后将此数据remove掉 既能保证PCM数据块的取出顺序 又能及时释放内存
        }

        frame.data = encodeYUV(dstWidth, dstHeight, frame.bitmap);
        return frame;
    }

    public byte[] encodeYUV(int width, int height, Bitmap scaled) {

        int[] argb = new int[width * height];

        scaled.getPixels(argb, 0, width, 0, 0, width, height);
        byte[] yuv;
        if (videoEncodeColor == 21) {
            //本地把RGB转成YUV
            yuv = ByteUtil.changeRGB2YUV420sp(argb, width, height);
        } else if (videoEncodeColor == 19) {
            yuv = ByteUtil.changeRGB2YUV420p(argb, width, height);
        } else {
            yuv = null;
        }
        scaled.recycle();

        return yuv;
    }

    /*
    * 旋转图片
    * @param angle
    * @param bitmap
    * @return Bitmap
    */
    public Bitmap rotaingImage(int angle, Bitmap bitmap) {
        //旋转图片 动作
        Matrix matrix = new Matrix();
        matrix.postRotate(90);
        // 创建新的图片
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    private void decode(MediaCodec.BufferInfo videoInfo, int inputIndex) {


        mediaDecode.queueInputBuffer(inputIndex, 0, videoInfo.size, videoInfo.presentationTimeUs, videoInfo.flags);//通知MediaDecode解码刚刚传入的数据

        //获取解码得到的byte[]数据 参数BufferInfo上面已介绍 10000同样为等待时间 同上-1代表一直等待，0代表不等待。此处单位为微秒
        //此处建议不要填-1 有些时候并没有数据输出，那么他就会一直卡在这 等待
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        int outputIndex = mediaDecode.dequeueOutputBuffer(bufferInfo, 50000);

        switch (outputIndex) {
            case MediaCodec.INFO_OUTPUT_BUFFERS_CHANGED:
                Log.d(tag, "INFO_OUTPUT_BUFFERS_CHANGED");
                decodeOutputBuffers = mediaDecode.getOutputBuffers();
                break;
            case MediaCodec.INFO_OUTPUT_FORMAT_CHANGED:
                MediaFormat format = mediaDecode.getOutputFormat();
                Log.d(tag, "New format " + format);
                if (format != null && format.containsKey(MediaFormat.KEY_COLOR_FORMAT)) {
                    videoDecodeColor = format.getInteger(MediaFormat.KEY_COLOR_FORMAT);
                    Log.d(tag, "decode extract get videoDecodeColor =" + videoDecodeColor);//解码得到视频颜色格式
                }
                initMediaEncode();//根据颜色格式初始化编码器
                break;
            case MediaCodec.INFO_TRY_AGAIN_LATER:
                Log.d(tag, "dequeueOutputBuffer timed out!");
                break;
            default:


                ByteBuffer outputBuffer;
                byte[] frame;
                while (outputIndex >= 0) {//每次解码完成的数据不一定能一次吐出 所以用while循环，保证解码器吐出所有数据
                    outputBuffer = decodeOutputBuffers[outputIndex];//拿到用于存放PCM数据的Buffer
                    frame = new byte[bufferInfo.size];//BufferInfo内定义了此数据块的大小
                    outputBuffer.get(frame);//将Buffer内的数据取出到字节数组中
                    outputBuffer.clear();//数据取出后一定记得清空此Buffer MediaCodec是循环使用这些Buffer的，不清空下次会得到同样的数据

                    handleFrameData(frame, videoInfo);//自己定义的方法，供编码器所在的线程获取数据,下面会贴出代码

                    mediaDecode.releaseOutputBuffer(outputIndex, false);//此操作一定要做，不然MediaCodec用完所有的Buffer后 将不能向外输出数据
                    outputIndex = mediaDecode.dequeueOutputBuffer(decodeBufferInfo, 50000);//再次获取数据，如果没有数据输出则outputIndex=-1 循环结束
                }
                break;
        }
    }


    /**
     * 编码
     */
    private void encode() {
        //获取解码器所在线程输出的数据
        byte[] chunkTime;
        Frame frame = getFrameData();
        if (frame == null) {
            return;
        }
        chunkTime = frame.data;
        int inputIndex = mediaEncode.dequeueInputBuffer(50000);//同解码器
        if (inputIndex < 0) {
            Log.d("px", "dequeueInputBuffer return inputIndex " + inputIndex + ",then break");
            mediaEncode.signalEndOfInputStream();
        }
        ByteBuffer inputBuffer = mediaEncode.getInputBuffers()[inputIndex];//同解码器
        inputBuffer.clear();//同解码器
        inputBuffer.put(chunkTime);//PCM数据填充给inputBuffer
        inputBuffer.limit(frame.videoInfo.size);

        mediaEncode.queueInputBuffer(inputIndex, 0, chunkTime.length, frame.videoInfo.presentationTimeUs, frame.videoInfo.flags);//通知编码器 编码

        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        int outputIndex = mediaEncode.dequeueOutputBuffer(bufferInfo, 50000);//同解码器
        switch (outputIndex) {
            case MediaCodec.INFO_OUTPUT_BUFFERS_CHANGED:
                Log.d(tag, "INFO_OUTPUT_BUFFERS_CHANGED");
                break;
            case MediaCodec.INFO_OUTPUT_FORMAT_CHANGED:
                MediaFormat outputFormat = mediaEncode.getOutputFormat();
                outputFormat.setInteger(MediaFormat.KEY_ROTATION, videoRotation);
                Log.d(tag, "mediaEncode find New format " + outputFormat);
                //向合成器添加视频轨
                videoTrackIndex = muxer.addTrack(outputFormat);
                muxer.start();
                break;
            case MediaCodec.INFO_TRY_AGAIN_LATER:
                Log.d(tag, "dequeueOutputBuffer timed out!");
                break;
            default:
                ByteBuffer outputBuffer;
                while (outputIndex >= 0) {//同解码器
                    outputBuffer = mediaEncode.getOutputBuffers()[outputIndex];//拿到输出Buffer

                    muxer.writeSampleData(videoTrackIndex, outputBuffer, bufferInfo);
//                    Log.d("px", "writeSampleData:" + bufferInfo.size);

                    mediaEncode.releaseOutputBuffer(outputIndex, false);

                    outputIndex = mediaEncode.dequeueOutputBuffer(bufferInfo, 50000);
                }
                break;
        }
    }

    public void onEnd() {
        if (mCancel) {
            Message msg = mProgressHandler.obtainMessage(CANCEL, mVideo);
            Bundle b = new Bundle();
            b.putBoolean("delete", mDelete);
            msg.setData(b);
            msg.sendToTarget();
        } else {
            mProgressHandler.obtainMessage(COMPLETE, mVideo).sendToTarget();
        }
    }


    private void release() {
        timeDataContainer.clear();//或中途取消,需要清空解码的数据块
        try {
            //全部写完后释放MediaMuxer和MediaExtractor
            extractor.release();
            mediaDecode.release();
            mediaEncode.release();
            muxer.stop();
            muxer.release();

        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

    }

    public void cancel(boolean delete) {
        //主动改变变量,以期望线程自动停止
        mCancel = true;
        mDelete = delete;
        decodeOver = true;
        encoding = false;

        //如果编码线程在wait中,需要唤醒他
        synchronized (encodeRunnable) {
            encodeRunnable.notify();
        }
    }

    public void setProgressHandler(Handler handler) {
        mProgressHandler = handler;
    }

    class Frame {
        MediaCodec.BufferInfo videoInfo;
        byte[] data;
        Bitmap bitmap;

        public Frame(MediaCodec.BufferInfo videoInfo, Bitmap bitmap) {
            this.videoInfo = videoInfo;
            this.bitmap = bitmap;
        }
    }

    /**
     * 解码线程
     */
    private class DecodeRunnable extends Thread {

        @Override
        public void run() {
            decodeOver = false;
            while (!decodeOver) {
                try {
                    extract();
                    synchronized (encodeRunnable) {
                        encodeRunnable.notify();
                    }
                } catch (Exception e) {
                    //抓住删除文件造成的异常
                    Log.e("px", e.toString());
                }

            }
        }

    }

    /**
     * 编码线程
     */
    private class EncodeRunnable extends Thread {

        @Override
        public void run() {
            encoding = true;
            while (encoding) {
                if (timeDataContainer.isEmpty()) {
                    if (decodeOver) {//解码完成,缓存也清空了
                        break;
                    }
                    try {
                        synchronized (encodeRunnable) {
                            wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        encode();
                    } catch (IllegalStateException e) {
                        e.printStackTrace();
                        encoding = false;
                        release();
                        mProgressHandler.obtainMessage(ERROR, mVideo).sendToTarget();
                        mProgressHandler = null;
                        return;
                    }

                }
            }
            release();
            encoding = false;
            onEnd();
            mProgressHandler = null;
        }
    }


}

