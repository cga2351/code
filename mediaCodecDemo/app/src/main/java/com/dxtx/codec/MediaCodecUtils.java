package com.dxtx.codec;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaFormat;
import android.os.Build;
import android.util.Log;
import android.util.Range;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MediaCodecUtils {
    private static final String tag = "px";

    /**
     * 根据视频宽高,询问手机中编码器的可选格式,来配置编码器
     *
     * @param width
     * @param height
     * @return
     */
    @TargetApi(Build.VERSION_CODES.M)
    public static Object[] initEncoder(int width, int height) {
        MediaCodec mediaEncode = null;
        MediaCodecInfo codecInfo = null;
        try {
            mediaEncode = MediaCodec.createEncoderByType(MediaFormat.MIMETYPE_VIDEO_AVC);
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
        MediaCodecInfo.CodecCapabilities capabilities = codecInfo.getCapabilitiesForType("video/avc");
        MediaCodecInfo.VideoCapabilities videoCapabilities = capabilities.getVideoCapabilities();
        Log.d(tag, "length-" + capabilities.colorFormats.length + "==" + Arrays.toString(capabilities.colorFormats));

        List<Integer> colorFormats = new ArrayList<>();
        outside:
        for (int i = 0; i < capabilities.colorFormats.length; i++) {
            colorFormats.add(capabilities.colorFormats[i]);
        }
//                case MediaCodecInfo.CodecCapabilities.COLOR_FormatYUV420PackedPlanar:
//                case MediaCodecInfo.CodecCapabilities.COLOR_FormatYUV420PackedSemiPlanar:
//                case MediaCodecInfo.CodecCapabilities.COLOR_TI_FormatYUV420PackedSemiPlanar:
//                case MediaCodecInfo.CodecCapabilities.COLOR_FormatSurface:
        if (colorFormats.contains(MediaCodecInfo.CodecCapabilities.COLOR_FormatYUV420SemiPlanar)) {
            colorFormat = MediaCodecInfo.CodecCapabilities.COLOR_FormatYUV420SemiPlanar;
        } else if (colorFormats.contains(MediaCodecInfo.CodecCapabilities.COLOR_FormatYUV420Planar)) {
            colorFormat = MediaCodecInfo.CodecCapabilities.COLOR_FormatYUV420Planar;
        }
        Log.d(tag, "find codec support color format ->" + colorFormat);
        Log.d(tag, "my width and height:" + width + "*" + height);
        //查找支持的帧率,尺寸等
        Range<Integer> frameRates = videoCapabilities.getSupportedFrameRates();
        Range<Integer> widths = videoCapabilities.getSupportedWidths();
        Range<Integer> heights = videoCapabilities.getSupportedHeights();
        Range<Integer> bitrates = videoCapabilities.getBitrateRange();
        Log.d(tag, "frameRates:" + frameRates);
        Log.d(tag, "widths:" + widths);
        Log.d(tag, "heights:" + heights);
        Log.d(tag, "BitrateRange:" + bitrates);
        Range<Double> achievableFrameRate = videoCapabilities.getAchievableFrameRatesFor(width, height);
        Log.d(tag, "AchievableFrame for " + width + "*" + height + ":" + achievableFrameRate);


        MediaFormat format = MediaFormat.createVideoFormat(MediaFormat.MIMETYPE_VIDEO_AVC, width, height);
        format.setInteger(MediaFormat.KEY_BIT_RATE, 1024 * 1024 * 8);
        format.setFloat(MediaFormat.KEY_FRAME_RATE, achievableFrameRate.getUpper().floatValue());
        format.setInteger(MediaFormat.KEY_COLOR_FORMAT, colorFormat);
        format.setInteger(MediaFormat.KEY_I_FRAME_INTERVAL, 1);

        mediaEncode.configure(format, null, null, MediaCodec.CONFIGURE_FLAG_ENCODE);
//        return new Object[]{mediaEncode, colorFormat};
        return new Object[]{mediaEncode, format};

    }

}