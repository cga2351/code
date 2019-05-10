#include <jni.h>
#include <android/log.h>
#include <opencv2/imgproc.hpp>
#include <opencv2/imgcodecs.hpp>
#include <opencv2/core.hpp>
#include <opencv2/highgui.hpp>
#include "CvxText.h"

//I420: YYYYYYYY UU VV    =>YUV420P
//        YV12: YYYYYYYY VV UU    =>YUV420P
//        NV12: YYYYYYYY UVUV     =>YUV420SP
//        NV21: YYYYYYYY VUVU     =>YUV420SP
using namespace cv;

#define TAG "px"
#define Log(cs, ...) __android_log_print(ANDROID_LOG_DEBUG, TAG, cs, __VA_ARGS__)
#define Lg(...) __android_log_print(ANDROID_LOG_DEBUG,TAG,__VA_ARGS__)

class dxtx {
public:
    static Size size;
    static CvRect rect;
    static Mat bg;
    static int videoDecodeColor, videoEncodeColor;
    static CvxText *textEditor;
};

Size dxtx::size;
CvRect dxtx::rect;
Mat dxtx::bg;
int dxtx::videoDecodeColor = 21, dxtx::videoEncodeColor = 21;
CvxText *dxtx::textEditor;

void printMat(Mat mat) {
    Log(" image 图像行数 = %d", mat.rows);
    Log(" image 图像列数 = %d", mat.cols);
    Log(" image 图像通道数 = %d", mat.channels());
}

/**
 * 把jstring转宽字符
 */
wchar_t *jstring2wchars(JNIEnv *env, jstring jstr) {
    //获取java字符串的长度
    jsize jstr_len = env->GetStringLength(jstr);
    //获取java字符串的jchar指针
    const jchar *pjstr = env->GetStringChars(jstr, 0);

    wchar_t *ws = new wchar_t[jstr_len + 1];
    memset(ws, 0, sizeof(wchar_t) * (jstr_len + 1));
    //转换 以数组的形式把 jchar转换到wchar_t
    for (int i = 0; i < jstr_len; i++)
        memcpy(&ws[i], &pjstr[i], 2);

    env->ReleaseStringChars(jstr, pjstr);
    return ws;
}

//测试给一张图片加文字
extern "C"
JNIEXPORT jstring JNICALL
Java_mqms_ncp_navercorp_com_testgpuimage_NativeUtils_testImg(JNIEnv *env, jclass type, jstring filepath_, jintArray data,
                                 jstring text_) {
    const char *filepath = env->GetStringUTFChars(filepath_, 0);
    Mat mat = imread(filepath, CV_LOAD_IMAGE_COLOR);
    env->ReleaseStringUTFChars(filepath_, filepath);

    //opencv自带直接绘制文字
    const char *text = "2018/06/28 18:00:24";
    int font_face = FONT_HERSHEY_SIMPLEX;
    double font_scale = 0.5;
    int thickness = 1;
    int baseline;
    //获取文本框的长宽
//    Size text_size = getTextSize(text, font_face, font_scale, thickness, &baseline);

    Mat bg = dxtx::bg;
    IplImage idst(mat), ibg(bg);
    cvSetImageROI(&idst, dxtx::rect);
    cvSetImageROI(&ibg, dxtx::rect);
    cvAddWeighted(&idst, 0.8, &ibg, 0.2, 0.0, &idst);
    cvResetImageROI(&idst);

    putText(mat, text, Point(0, 240), font_face, font_scale, Scalar(255, 255, 255),
            thickness, 8, 0);

    // 使用freetype
    CvxText texter("/storage/emulated/0/msyh.ttf");
    Scalar textsize(24, 0.5, 0.1, 0);
    float p = 1.f;
    texter.setFont(NULL, &textsize, NULL, &p);
    wchar_t *text2 = L"我爱北京天安门";
    wchar_t *text3 = jstring2wchars(env, text_);
    texter.putText(mat, text2, Point(0, 160), CV_RGB(255, 255, 255));
    texter.putText(mat, text3, Point(0, dxtx::size.height), CV_RGB(255, 255, 255));

    int size = mat.rows * mat.cols;
    jint *buf = new jint[size];

    //转换成一通道
    for (int i = 0; i < mat.rows * mat.cols; i++) {
        buf[i] = (mat.at<uchar>(i * 3 + 2) << 16) + (mat.at<uchar>(i * 3 + 1) << 8) +
                 mat.at<uchar>(i * 3);
    }
    env->SetIntArrayRegion(data, 0, size, buf);
    return env->NewStringUTF("转换完成");
}

extern "C"
JNIEXPORT void JNICALL
Java_mqms_ncp_navercorp_com_testgpuimage_NativeUtils_drawText(JNIEnv *env, jclass type, jbyteArray data_, jint w,
                                  jint h, jstring text_) {
    Log("NativeUtils_drawText(), entry, %s", "111");
    jbyte *data = env->GetByteArrayElements(data_, NULL);
    const wchar_t *text = jstring2wchars(env, text_);
//    Log("draw text the color used %d,%d",dxtx::videoDecodeColor,dxtx::videoEncodeColor);
    Mat dst;
    Mat yuv(h * 3 / 2, w, CV_8UC1, (uchar *) data);

    //转换为可以处理的bgr格式
    int code = 0;
    if (dxtx::videoDecodeColor == 21) {
        code = CV_YUV420sp2BGR;
    } else if (dxtx::videoDecodeColor == 22) {
        code = CV_YUV2BGR_NV12;
    } else if (dxtx::videoDecodeColor == 19) {
        code = CV_YUV420p2BGR;
    } else if (dxtx::videoDecodeColor == 20) {
        code = CV_YUV2BGR_I420;
    } else {
        char *error;
        sprintf(error, "not support video color format:%d", dxtx::videoDecodeColor);
        throw error;
    }
    cvtColor(yuv, dst, code);

    Log("NativeUtils_drawText(), entry, %s", "222");


//    printMat(dst);
    //旋转图像
//    if (w > h) {
//        rotate(dst, dst, ROTATE_90_CLOCKWISE);
//    }

    Log("NativeUtils_drawText(), entry, %s", "333");

    Size size = dxtx::size;
    CvRect rect = dxtx::rect;

    //背景方案一,带半透明背景的文字遮罩
//    Mat bg = dxtx::bg;
//    IplImage idst(dst), ibg(bg);
//    cvSetImageROI(&idst, rect);
//    cvSetImageROI(&ibg, rect);
//    cvAddWeighted(&idst, 0.8, &ibg, 0.2, 0.0, &idst);
//    cvResetImageROI(&idst);
//    //文字方案一,集成freetype,可以绘制中文
//    dxtx::textEditor->putText(dst, text, Point(0, 24), CV_RGB(255, 255, 255));

    //背景方案二,无透明度的背景填充方法,效率高,但不好看
//    rectangle(dst,rect,Scalar(200,200,200),-1,8,0);

    //文字方案二,opencv自带的字体绘制方式,效率快,但不适用于中文
    /*CvFont font;
    cvInitFont(&font, CV_FONT_HERSHEY_COMPLEX, 0.5, 0.5, 0);
    cvPutText(&idst, text, cvPoint(0, size.height), &font, Scalar(255, 255, 255));*/
    //文字方案三,
//    putText(dst, text, Point(0, size.height), FONT_HERSHEY_SIMPLEX,
//            0.5, Scalar(255, 255, 255),
//            1, 8, 0);

    w = dst.cols;
    h = dst.rows;

    //转换为YV12
    cvtColor(dst, dst, CV_BGR2YUV_YV12);
    Log("NativeUtils_drawText(), entry, %s", "444");

//    printMat(dst);
    if (dxtx::videoEncodeColor == 19) {
        Log("NativeUtils_drawText(), entry, %s", "555");
        env->SetByteArrayRegion(data_, 0, w * h * 3 / 2, (const jbyte *) dst.data);
    } else if (dxtx::videoEncodeColor == 21) {
        Log("NativeUtils_drawText(), entry, %s", "666");
        //因为YV12 和NV21格式不同,需要重组UV分量
        jbyte *out = new jbyte[w * h / 2];
        int ulen = w * h / 4;
        for (int i = 0; i < ulen; i += 1) {
            //从YYYYYYYY UUVV 到YYYYYYYY VUVU
            out[i * 2 + 1] = dst.at<uchar>(w * h + ulen + i);
            out[i * 2] = dst.at<uchar>(w * h + i);
        }

        //返回到原来的数据
        env->SetByteArrayRegion(data_, 0, w * h, (const jbyte *) dst.data);
        env->SetByteArrayRegion(data_, w * h, w * h / 2, out);
    }
    Log("NativeUtils_drawText(), entry, %s", "777");

}

/**
 * 用一个样本文字先确定文字的区域,用于绘制背景蒙层,与文字形成反差
 */
extern "C"
JNIEXPORT void JNICALL
Java_mqms_ncp_navercorp_com_testgpuimage_NativeUtils_fixTextArea(JNIEnv *env, jclass type, jstring text_) {
    //转为为宽字符,确定文字范围
    wchar_t *text = jstring2wchars(env, text_);
    Size size = dxtx::textEditor->getTextSize(text);

    //原始opencv方式确定文字范围
//    const char* text = env->GetStringUTFChars(text_,0);
//    int baseline;
//    Size size = getTextSize(text, CV_FONT_HERSHEY_COMPLEX, 0.6, 1, &baseline);

    Log("text size width ->%d,%d", size.width, size.height);
    //使用freetype后不可用getTextSize测量宽高
    // 确定背景区域
    CvRect rect = cvRect(0, 0, size.width + 10, size.height * 1.5);
    //生成背景mask层
    Mat bg(size.height * 1.5, size.width + 10, CV_8UC3, Scalar(0, 0, 0));

    dxtx::size = size;
    dxtx::rect = rect;
    dxtx::bg = bg;

}

extern "C"
JNIEXPORT void JNICALL
Java_mqms_ncp_navercorp_com_testgpuimage_NativeUtils_release(JNIEnv *env, jclass type) {
    if (&dxtx::bg != NULL) {
        dxtx::bg.release();
        dxtx::bg = NULL;
    }
    if (dxtx::textEditor != NULL) {
        dxtx::textEditor->~CvxText();
    }
}

extern "C"
JNIEXPORT void JNICALL
Java_mqms_ncp_navercorp_com_testgpuimage_NativeUtils_fixColorFormat(JNIEnv *env, jclass type, jint decodeColor,
                                        jint encodeColor) {
    dxtx::videoDecodeColor = decodeColor;
    dxtx::videoEncodeColor = encodeColor;
}

extern "C"
JNIEXPORT void JNICALL
Java_mqms_ncp_navercorp_com_testgpuimage_NativeUtils_fixFontFile(JNIEnv *env, jclass type, jstring ttfPath_) {
    const char *ttfPath = env->GetStringUTFChars(ttfPath_, 0);
    dxtx::textEditor = new CvxText(ttfPath);
    Scalar textsize(24, 0.5, 0.1, 0);
    float p = 1.f;
    dxtx::textEditor->setFont(NULL, &textsize, NULL, &p);
    env->ReleaseStringUTFChars(ttfPath_, ttfPath);
}

