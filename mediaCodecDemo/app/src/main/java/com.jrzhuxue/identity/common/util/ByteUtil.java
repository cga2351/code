package com.jrzhuxue.identity.common.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ImageFormat;
import android.graphics.Rect;
import android.graphics.YuvImage;

import java.io.ByteArrayOutputStream;

/**
 * Created by user on 2016/11/21.
 */
public class ByteUtil {
    static {
        System.loadLibrary("dxtxfirstso");
    }
    //C++ RGB转420sp
    public static native byte[] changeRGB2YUV420sp(int[] data, int width, int height);

    //C++ RGB转420p  420p适用一些手机
    public static native byte[] changeRGB2YUV420p(int[] data, int width, int height);

    //C++ 420p转RGB  420p适用一些手机
    public static native int[] changeYUV420p2RGB(byte[] data, int width, int height);

    //java RGB转420sp
    public static byte[] changeRGB2YUV420sp_(int[] argb, int width, int height) {
        final int frameSize = width * height;

        byte[] yuv420sp = new byte[frameSize * 3 / 2];

        int yIndex = 0;
        int uvIndex = frameSize;

        int a, R, G, B, Y, U, V;
        int index = 0;
        for (int j = 0; j < height; j++) {
            for (int i = 0; i < width; i++) {

//                a = (argb[index] & 0xff000000) >> 24; // a is not used obviously
                R = (argb[index] & 0xff0000) >> 16;
                G = (argb[index] & 0xff00) >> 8;
                B = (argb[index] & 0xff) >> 0;

                // well known RGB to YUV algorithm
                Y = ((66 * R + 129 * G + 25 * B + 128) >> 8) + 16;
                U = ((-38 * R - 74 * G + 112 * B + 128) >> 8) + 128;
                V = ((112 * R - 94 * G - 18 * B + 128) >> 8) + 128;


                // NV21 has a plane of Y and interleaved planes of VU each sampled by a factor of 2
                //    meaning for every 4 Y pixels there are 1 V and 1 U.  Note the sampling is every other
                //    pixel AND every other scanline.
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

    //java RGB转420p
    public static byte[] changeRGB2YUV420p_(int[] argb, int width, int height) {
        int size = width * height * 3 / 2;
        byte[] yuv420p = new byte[size];

        int frameSize = width * height;

        int uIndex = frameSize;
        int vIndex = frameSize * 5 / 4;

        int a, R, G, B, Y, U, V;
        int index = 0;
        for (int j = 0; j < height; j++) {
            for (int i = 0; i < width; i++) {

//                a = (argb[index] & 0xff000000) >> 24; // a is not used obviously
                R = (argb[index] & 0xff0000) >> 16;
                G = (argb[index] & 0xff00) >> 8;
                B = (argb[index] & 0xff) >> 0;

                // well known RGB to YUV algorithm
                Y = ((66 * R + 129 * G + 25 * B + 128) >> 8) + 16;
                U = ((-38 * R - 74 * G + 112 * B + 128) >> 8) + 128;
                V = ((112 * R - 94 * G - 18 * B + 128) >> 8) + 128;


                // NV21 has a plane of Y and interleaved planes of VU each sampled by a factor of 2
                //    meaning for every 4 Y pixels there are 1 V and 1 U.  Note the sampling is every other
                //    pixel AND every other scanline.
                yuv420p[index++] = (byte) (Y < 0 ? 0 : (Y > 255 ? 255 : Y));
                if (j % 2 == 0 && index % 2 == 0) {
                    yuv420p[uIndex++] = (byte) (U < 0 ? 0 : (U > 255 ? 255 : U));
                    yuv420p[vIndex++] = (byte) (V < 0 ? 0 : (V > 255 ? 255 : V));
                }

            }
        }
        return yuv420p;
    }

    //java 420p转RGB
    public static int[] changeYUV420p2RGB_(byte[] yuv, int width, int height) {

        int frameSize = width * height;

        int[] rgb = new int[frameSize];

        int yIndex = 0;
        int uIndex = frameSize;
        int vIndex = frameSize * 5 / 4;

        int a, R, G, B, Y, U, V;
        int index = 0;
        for (int j = 0; j < height; j++) {
            for (int i = 0; i < width; i++) {
                // well known RGB to YUV algorithm
                /*if (vIndex >= yuv.length || uIndex >= yuv.length) {
                    break;
                }*/
                Y = yuv[index] < 0 ? 0x100 + yuv[index] : yuv[index];
                U = yuv[uIndex] < 0 ? 0x100 + yuv[uIndex] : yuv[uIndex];
                V = yuv[vIndex] < 0 ? 0x100 + yuv[vIndex] : yuv[vIndex];

                R = Y + (V - 128) + (((V - 128) * 103) >> 8);
                G = Y - (((U - 128) * 88) >> 8) - (((V - 128) * 183) >> 8);
                B = Y + (U - 128) + (((U - 128) * 198) >> 8);


                R = R > 255 ? 255 : (R < 0 ? 0 : R);
                G = G > 255 ? 255 : (G < 0 ? 0 : G);
                B = B > 255 ? 255 : (B < 0 ? 0 : B);

                rgb[index] = 0xff000000 + (R << 16) + (G << 8) + B;

//                rgb[index] = ((0xff - Y) << 24);

                index++;
                if (i % 2 != 0) {
                    uIndex++;
                    vIndex++;
                }
                if (i == width - 1 && j % 2 == 0) {//每行最后一个,且这行是第一,三,五
                    uIndex -= width / 2;
                    vIndex -= width / 2;
                }

            }
        }
        return rgb;
    }

    public static Bitmap changeYUV420sp2RGB(byte[] yuv, int width, int height) {
        //YUV420sp转RGB数据 5-60ms
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        YuvImage yuvImage = new YuvImage(yuv, ImageFormat.NV21, width, height, null);
        yuvImage.compressToJpeg(new Rect(0, 0, width, height), 100, out);
        byte[] imageBytes = out.toByteArray();
        return BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);
    }

    public static native void render(int[] b1, int[] b2, int width, int height, double r, double len, double weight, double x0, double y0);

    public static native void doubleRipple(int[] b1, int[] b2, int width, int height, double r, double len, double weight, double x0, double y0);

    public static native void changeBitmap(int[] b1, int[] b2, int width, int height, double r, double len, double weight, double x0, double y0, int[] n);

}