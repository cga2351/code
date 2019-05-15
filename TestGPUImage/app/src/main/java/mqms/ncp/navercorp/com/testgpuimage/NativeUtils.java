package mqms.ncp.navercorp.com.testgpuimage;

/**
 * author : yuliang
 * mail : yuliang@navercorp.com
 * date : 2019/5/10
 * description :
 */
public class NativeUtils {
    static {
        System.loadLibrary("dxtx");//视频水印库
    }

    public static int NV21 =21,NV12=22,YV12=19,I420=20;

    /**
     * 测试接口,ndk里面包含各种加水印的方法
     * @param imagePath
     * @param data
     * @param text
     * @return
     */
    public static native String testImg(String imagePath, int[] data, String text);

    /**
     * 用一段文字预算文字区域的大小,以方便生成背景
     * @param text
     */
    public static native void fixTextArea(String text);

    /**
     * 设置yuv的颜色输入格式和输出,@{link ColorFormat}
     * @param decodeColor
     * @param encodeColor
     */
    public static native void fixColorFormat(int decodeColor, int encodeColor);

    /**
     * 绘制文字
     * @param data yuv数据,来自视频解码.绘制后data数据被修改
     * @param w
     * @param h
     * @param text 需要绘制的文字
     */
    public static native void drawText(byte[] data, byte[] frameData, int srcWidth, int srcHeight, int videoWidth, int videoHeight, String text);

    /**
     * 释放内存
     */
    public static native void release();

    /**
     * 初始化字体文件,ndk内部会初始化字体大小,间距等属性
     * @param ttfPath
     */
    public static native void fixFontFile(String ttfPath);
}