package com.dxtx.test.record;

import android.graphics.ImageFormat;
import android.graphics.Point;
import android.hardware.Camera;
import android.media.CamcorderProfile;
import android.util.Log;

import com.dxtx.test.NativeUtils;

import java.util.List;

/**
 * Created by user on 2018/7/19.
 */

public class CameraUtils {

    public static Camera.Parameters setupCameraParams(Camera camera, Point size) {
        //处理预览像素,帧率,颜色格式
        Camera.Parameters p = showSupportPreviewSize(camera, size);

        //设置简单的聚焦,白平衡,闪光灯等等
        p.setFlashMode(Camera.Parameters.FLASH_MODE_AUTO);
        p.setFocusMode(Camera.Parameters.FOCUS_MODE_CONTINUOUS_VIDEO);
        p.setWhiteBalance(Camera.Parameters.WHITE_BALANCE_AUTO);
        p.setSceneMode(Camera.Parameters.SCENE_MODE_AUTO);
        camera.setParameters(p);

        camera.setDisplayOrientation(90); // Portrait mode
        return p;
    }

    static Camera.Parameters showSupportPreviewSize(Camera camera, Point size) {
        //处理预览尺寸
        Camera.Parameters p = camera.getParameters();
        List<Camera.Size> previewSizes = p.getSupportedPreviewSizes();
        if (previewSizes != null) {
            StringBuilder sb = new StringBuilder("SupportedPreviewSizes:[");
            for (Camera.Size s : previewSizes) {
                sb.append(s.width).append("*").append(s.height).append(",");
                if (s.width * s.height == size.x * size.y) {
                    p.setPreviewSize(s.width, s.height);
                    Log.d("px", "resolution size:" + s.width + "*" + s.height);
                }
            }
            Log.d("px", sb.deleteCharAt(sb.length() - 1).toString());
        } else {
            Log.d("px", "SupportedVideoSizes:null");
        }

        //处理预览帧率
        int[] range = {0, 0};
        List<int[]> previewFpsRange = p.getSupportedPreviewFpsRange();
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

        List<Integer> formats = p.getSupportedPreviewFormats();
        Log.d("px", "SupportedPreviewFormats:" + formats);
        if (formats.contains(ImageFormat.NV21))
            p.setPreviewFormat(ImageFormat.NV21);
        else if (formats.contains(ImageFormat.YV12))
            p.setPreviewFormat(ImageFormat.YV12);

        return p;
    }

    /**
     * 根据MediaRecord支持的录像size大小,MediaRecord支持的录像大小,也是MediaCodec支持的
     */
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

    public static int preview2deocode(int previewFormat) {
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


    public static String secondToText(int second) {
        if (second < 10) {
            return " 00:0" + second;
        } else if (second < 60) {
            return " 00:" + second;
        } else {
            return " 01:" + second % 60;
        }
    }
}
