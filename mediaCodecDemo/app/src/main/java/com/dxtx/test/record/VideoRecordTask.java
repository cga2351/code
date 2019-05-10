package com.dxtx.test.record;

import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;

import com.dxtx.codec.MediaCodecUtils;
import com.dxtx.test.NativeUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by user on 2018/7/18.
 */
@RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class VideoRecordTask {
    private final static String tag = "px";

    private int videoDecodeColor = 21, videoEncodeColor = 21;
    private MediaCodec mediaEncode;
    private MediaMuxer muxer;
    private MediaFormat encodeFormat;

    private int srcWidth, srcHeight, dstWidth, dstHeight;

    int videoTrackIndex;

    long videoCreateTime;

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    boolean stop;
    MediaCodec.BufferInfo frameInfo = new MediaCodec.BufferInfo();

    public VideoRecordTask(String videoPath, Context context) {
        //首次 释放字体文件
        String ttfPath = context.getExternalCacheDir().getAbsolutePath() + "/msyh.ttf";
        File ttf = new File(ttfPath);
        if (!ttf.exists()) {
            try {
                ttf.createNewFile();
                InputStream in = context.getAssets().open("msyh.ttf");
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
        NativeUtils.fixFontFile(ttfPath);
        String text = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date());
        NativeUtils.fixTextArea(text);

        //写入文件的合成器
        try {
            muxer = new MediaMuxer(videoPath, MediaMuxer.OutputFormat.MUXER_OUTPUT_MPEG_4);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void initMediaEncode() {
        Object[] objects = MediaCodecUtils.initEncoder(dstWidth, dstHeight);
        mediaEncode = (MediaCodec) objects[0];
        encodeFormat = (MediaFormat) objects[1];
        videoEncodeColor = encodeFormat.getInteger(MediaFormat.KEY_COLOR_FORMAT);
    }

    public void setVideoPreviewSizeColor(int w, int h, int videoDecodeColor) {
        this.srcWidth = w;
        this.srcHeight = h;
        this.dstHeight = w;
        this.dstWidth = h;
        initMediaEncode();
        NativeUtils.fixColorFormat(videoDecodeColor, videoEncodeColor);
    }

    public void captureImg(byte[] data, int w, int h) {
        Date date = new Date();
        NativeUtils.drawText(data, w, h, dateFormat.format(date));
        frameInfo.flags = MediaCodec.BUFFER_FLAG_CODEC_CONFIG;
        frameInfo.presentationTimeUs = (date.getTime() - videoCreateTime) * 1000;

        putIn(data, frameInfo);
    }

    public void start() {

        videoCreateTime = System.currentTimeMillis();

        mediaEncode.start();

        Thread thread = new Thread() {
            @Override
            public void run() {
                while (!stop) {
                    encode();
                }
                mediaEncode.release();
                muxer.stop();
                muxer.release();
                NativeUtils.release();
            }
        };
        thread.start();
    }

    public void finishRecord() {
        stop = true;
    }

    void putIn(byte[] data, MediaCodec.BufferInfo videoInfo) {
        if (data == null) {
            Log.d("px", "data ==null ,so end");
            return;
        }
        int inputIndex = mediaEncode.dequeueInputBuffer(50000);//同解码器
        if (inputIndex < 0) {
            Log.d("px", "dequeueInputBuffer return inputIndex " + inputIndex + ",then break");
            mediaEncode.signalEndOfInputStream();
        }
        ByteBuffer inputBuffer = mediaEncode.getInputBuffer(inputIndex);//同解码器
        inputBuffer.clear();//同解码器
        inputBuffer.put(data);//PCM数据填充给inputBuffer
        inputBuffer.limit(videoInfo.size);
        mediaEncode.queueInputBuffer(inputIndex, 0, data.length, videoInfo.presentationTimeUs, videoInfo.flags);//通知编码器 编码
    }

    long lastFrameTime = 0;
    long lastFrameWriteTime = 0;
    /**
     * 编码
     */
    private void encode() {

        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        int outputIndex = mediaEncode.dequeueOutputBuffer(bufferInfo, 50000);//同解码器
        switch (outputIndex) {
            case MediaCodec.INFO_OUTPUT_BUFFERS_CHANGED:
                Log.d(tag, "INFO_OUTPUT_BUFFERS_CHANGED");
                break;
            case MediaCodec.INFO_OUTPUT_FORMAT_CHANGED:
                MediaFormat outputFormat = mediaEncode.getOutputFormat();
                outputFormat.setInteger(MediaFormat.KEY_ROTATION, 90);
                outputFormat.setInteger(MediaFormat.KEY_COLOR_FORMAT, videoEncodeColor);
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
                    outputBuffer = mediaEncode.getOutputBuffer(outputIndex);//拿到输出Buffer

                    long curTime = System.currentTimeMillis();
                    Log.d("-mqmsdebug", "encode(), write a video sample" +
                            ", frame time:" + (bufferInfo.presentationTimeUs / 1000) +
                            ", frame write time:" + (curTime - lastFrameWriteTime));
                    lastFrameTime = bufferInfo.presentationTimeUs;
                    lastFrameWriteTime = curTime;

                    muxer.writeSampleData(videoTrackIndex, outputBuffer, bufferInfo);
                    mediaEncode.releaseOutputBuffer(outputIndex, false);

                    outputIndex = mediaEncode.dequeueOutputBuffer(bufferInfo, 50000);
                }
                break;
        }
    }
}
