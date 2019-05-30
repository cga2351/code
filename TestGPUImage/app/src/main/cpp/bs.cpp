#include <jni.h>
#include <android/log.h>
#include <opencv/opencv2/core/hal/interface.h>
#include <opencv/opencv2/core.hpp>
#include <opencv/opencv2/imgproc/types_c.h>
#include <opencv/opencv2/imgproc.hpp>
#include <opencv/opencv2/core/softfloat.hpp>
#include <fenv.h>
//#include "cpu-features.h"
#include "pthread.h"
#include "android/log.h"
#include "opencv/opencv2/core/mat.hpp"
#include "opencv/opencv2/core/matx.hpp"
#include "CvxText.h"


//I420: YYYYYYYY UU VV    =>YUV420P
//        YV12: YYYYYYYY VV UU    =>YUV420P
//        NV12: YYYYYYYY UVUV     =>YUV420SP
//        NV21: YYYYYYYY VUVU     =>YUV420SP
using namespace cv;

#define TAG "px"
#define Log(cs, ...) __android_log_print(ANDROID_LOG_DEBUG, TAG, cs, __VA_ARGS__)
#define Lg(...) __android_log_print(ANDROID_LOG_DEBUG,TAG,__VA_ARGS__)


#define LOGD(...) __android_log_print(ANDROID_LOG_DEBUG, "test_gpu_image", __VA_ARGS__)

#define CAMERA_COLOR_VALUE_NV21     0x11
#define CAMERA_COLOR_VALUE_YV12     0x32315659



class dxtx {
public:
    static Size size;
    static CvRect rect;
    static Mat bg;
    static int videoDecodeColor, videoEncodeColor;
    static CvxText *textEditor;
};

Size dxtx::size;
//CvRect dxtx::rect;
Mat dxtx::bg;
int dxtx::videoDecodeColor = 21, dxtx::videoEncodeColor = 21;
CvxText *dxtx::textEditor;




//void printMat(Mat mat) {
//    Log(" image 图像行数 = %d", mat.rows);
//    Log(" image 图像列数 = %d", mat.cols);
//    Log(" image 图像通道数 = %d", mat.channels());
//}

/**
 * 把jstring转宽字符
 */




//wchar_t *jstring2wchars(JNIEnv *env, jstring jstr) {
//    const cv::softfloat aaa;
//    const cv::softdouble bbb;
//    const cv::softdouble ccc;
//    float ddd;
//    bbb.setExp(5);
//    cvRound(aaa);
//    cos(ccc);
//    cv::cubeRoot(ddd);
////    cv::softdouble eee = bbb * ccc;
//
//
//
//    //获取java字符串的长度
//    jsize jstr_len = env->GetStringLength(jstr);
//    //获取java字符串的jchar指针
//    const jchar *pjstr = env->GetStringChars(jstr, 0);
//
//    wchar_t *ws = new wchar_t[jstr_len + 1];
//    memset(ws, 0, sizeof(wchar_t) * (jstr_len + 1));
//    //转换 以数组的形式把 jchar转换到wchar_t
//    for (int i = 0; i < jstr_len; i++)
//        memcpy(&ws[i], &pjstr[i], 2);
//
//    env->ReleaseStringChars(jstr, pjstr);
//    return ws;
//}


cv::softdouble aa;


//测试给一张图片加文字
extern "C"
JNIEXPORT jstring JNICALL
Java_mqms_ncp_navercorp_com_testgpuimage_NativeUtils_testImg(JNIEnv *env, jclass type, jstring filepath_, jintArray data,
                                 jstring text_) {


//    const char *filepath = env->GetStringUTFChars(filepath_, 0);

//    Mat mat = imread(filepath, CV_LOAD_IMAGE_COLOR);
//    env->ReleaseStringUTFChars(filepath_, filepath);
//
//    //opencv自带直接绘制文字
//    const char *text = "2018/06/28 18:00:24";
//    int font_face = FONT_HERSHEY_SIMPLEX;
//    double font_scale = 0.5;
//    int thickness = 1;
//    int baseline;
//    //获取文本框的长宽
////    Size text_size = getTextSize(text, font_face, font_scale, thickness, &baseline);
//
//
//    Mat bg = dxtx::bg;
//    IplImage idst(mat), ibg(bg);
//    cvSetImageROI(&idst, dxtx::rect);
//    cvSetImageROI(&ibg, dxtx::rect);
//    cvAddWeighted(&idst, 0.8, &ibg, 0.2, 0.0, &idst);
//    cvResetImageROI(&idst);
//
//    putText(mat, text, Point(0, 240), font_face, font_scale, Scalar(255, 255, 255),
//            thickness, 8, 0);
//
//    // 使用freetype
////    CvxText texter("/storage/emulated/0/msyh.ttf");
//    CvxText texter("/sdcard/mqms/Courier.ttf");
//    Scalar textsize(24, 0.5, 0.1, 0);
//    float p = 1.f;
//    texter.setFont(NULL, &textsize, NULL, &p);
//    wchar_t *text2 = L"我爱北京天安门";
//    wchar_t *text3 = jstring2wchars(env, text_);
//    texter.putText(mat, text2, Point(0, 160), CV_RGB(255, 255, 255));
//    texter.putText(mat, text3, Point(0, dxtx::size.height), CV_RGB(255, 255, 255));
//
//    int size = mat.rows * mat.cols;
//    jint *buf = new jint[size];
//
//    //转换成一通道
//    for (int i = 0; i < mat.rows * mat.cols; i++) {
//        buf[i] = (mat.at<unsigned char>(i * 3 + 2) << 16) + (mat.at<unsigned char>(i * 3 + 1) << 8) +
//                 mat.at<unsigned char>(i * 3);
//    }
//    env->SetIntArrayRegion(data, 0, size, buf);

    return env->NewStringUTF("转换完成");
}

extern "C"
JNIEXPORT void JNICALL
Java_mqms_ncp_navercorp_com_testgpuimage_NativeUtils_drawText(JNIEnv *env, jclass type, jbyteArray srcData, jbyteArray frameData, jint srcWidth,
                                  jint srcHeight, jint videoWidth, jint videoHeight, jstring text_) {
//    Log("NativeUtils_drawText(), entry, %s, srcWidth=%d, srcHeight=%d, videoWidth=%d, videoHeight=%d", "111", srcWidth, srcHeight, videoWidth, videoHeight);
    jbyte *data = env->GetByteArrayElements(srcData, NULL);
//    const wchar_t *text = jstring2wchars(env, text_);
//    Log("draw text the color used %d,%d",dxtx::videoDecodeColor,dxtx::videoEncodeColor);
    Mat bgrData;
    Mat originData(srcHeight * 3 / 2, srcWidth, CV_8UC1, (uchar *) data);
//    Mat originData(srcHeight, srcWidth * 3 / 2, CV_8UC1, (uchar *) data);
//    Mat originData(srcHeight * 3, srcWidth / 2, CV_8UC1, (uchar *) data);
//    Mat originData(srcHeight, srcWidth, CV_8UC1, (uchar *) data);

    //转换为可以处理的bgr格式
    int code = 0;
//    Log("NativeUtils_drawText(), entry, dxtx::videoDecodeColor=%d, dxtx::videoEncodeColor=%d", dxtx::videoDecodeColor, dxtx::videoEncodeColor);
    if (dxtx::videoDecodeColor == 21) {
        code = CV_YUV420sp2BGR;
    } else if (dxtx::videoDecodeColor == 22) {
//        code = CV_YUV2BGR_NV12;
        code = CV_YUV2BGR_NV21;
    } else if (dxtx::videoDecodeColor == 19) {
        code = CV_YUV420p2BGR;
    } else if (dxtx::videoDecodeColor == 20) {
        code = CV_YUV2BGR_I420;
    } else {
        char *error;
        sprintf(error, "not support video color format:%d", dxtx::videoDecodeColor);
        throw error;
    }
    cvtColor(originData, bgrData, code);
//    Log("NativeUtils_drawText(), entry, %s", "222");



    // add water mark
    LOGD("NativeUtils_drawText()");
//    //#%04d.%05d#
//    static int count = 0;
//    count++;
//    char textWatermark[64] = {0};
//    sprintf(textWatermark, "#%04d.%05d#", count, count * 100 + count);
//    std::string text = textWatermark;
//    int font_face = cv::FONT_HERSHEY_COMPLEX;
//    double font_scale = 2;
//    int thickness = 2;
//    int baseline;
//    //获取文本框的长宽
//    cv::Size text_size = cv::getTextSize(text, font_face, font_scale, thickness, &baseline);
//
//    //将文本框居中绘制
//    cv::Point origin;
//    origin.x = bgrData.cols / 2 - text_size.width / 2;
//    origin.y = bgrData.rows / 2 + text_size.height / 2;
//    cv::putText(bgrData, text, origin, font_face, font_scale, cv::Scalar(0, 255, 255), thickness, 8, 0);
//    LOGD("NativeUtils_drawText(),text=%s, origin.x=%d, origin.y=%d", text.c_str(), origin.x, origin.y);



//    //opencv自带直接绘制文字
//    static int count = 0;
//    count++;
//    std::string drawText = "draw text count:";
//    drawText += count;
//
////     使用freetype
//    CvxText texter("/sdcard/mqms/Courier.ttf");
//    Scalar textSize(24, 0.5, 0.1, 0);
//    float p = 1.f;
//    texter.setFont(NULL, &textSize, NULL, &p);
//    texter.putText(bgrData, drawText.c_str(), Point(0, 160), CV_RGB(255, 255, 255));

//    //转换成一通道
//    int size = bgrData.rows * bgrData.cols;
//    jint *buf = new jint[size];
//    for (int i = 0; i < bgrData.rows * bgrData.cols; i++) {
//        buf[i] = (bgrData.at<uchar>(i * 3 + 2) << 16) + (bgrData.at<uchar>(i * 3 + 1) << 8) +
//                bgrData.at<uchar>(i * 3);
//    }



//    printMat(bgrData);
    //旋转图像
//    if (srcWidth > srcHeight) {
//        rotate(bgrData, bgrData, ROTATE_90_CLOCKWISE);
//    }

    //裁剪图像
    Mat corpData;
    float scaleWidth = (float)srcWidth / videoWidth;
    float scaleHeight = (float)srcHeight / videoHeight;
//    Log("NativeUtils_drawText(),  %s, scaleWidth=%f, scaleHeight=%f", "111", scaleWidth, scaleHeight);
    Rect rect(0, 0, 0, 0);
    bool needCorp = false;
    if (fabs(scaleWidth - scaleHeight) > 0.00000001f) {
        float scale;
        if (scaleWidth > scaleHeight) {
//            Log("NativeUtils_drawText(),  corp width, %s", "222");
            scale = scaleHeight;
        } else {
//            Log("NativeUtils_drawText(),  corp height, %s", "333");
            scale = scaleWidth;
        }
        int destWidth = videoWidth * scale;
        int destHeight = videoHeight * scale;
        int corpWidth = srcWidth - destWidth;
        int corpHeight = srcHeight - destHeight;

        rect.x = corpWidth / 2;
        rect.y = corpHeight / 2;
        rect.width = destWidth;
        rect.height = destHeight;

        corpData = bgrData(rect);
//        Log("NativeUtils_drawText(),  needCorp, %s, bgrData.cols=%d, bgrData.rows=%d, corpData.cols=%d, corpData.rows=%d", "444",
//            bgrData.cols, bgrData.rows, corpData.cols, corpData.rows);
        needCorp = true;
    }

    //缩放图像
    Mat scaleData;
    if (needCorp) {
        resize(corpData, scaleData, Size(videoWidth, videoHeight));
//        Log("NativeUtils_drawText(),  needCorp, %s, corpData.cols=%d, corpData.rows=%d, scaleData.cols=%d, scaleData.rows=%d", "555",
//                corpData.cols, corpData.rows, scaleData.cols, scaleData.rows);
    } else {
        resize(bgrData, scaleData, Size(videoWidth, videoHeight));
//        Log("NativeUtils_drawText(),  not needCorp, %s, bgrData.cols=%d, bgrData.rows=%d, scaleData.cols=%d, scaleData.rows=%d", "666",
//            bgrData.cols, bgrData.rows, scaleData.cols, scaleData.rows);
    }


//    Log("NativeUtils_drawText(), entry, 333, scaleData.cols=%d, scaleData.rows=%d, corpData.cols=%d, corpData.rows=%d, srcWidth=%d, srcHeight=%d, originData.cols=%d, originData.rows=%d, bgrData.cols=%d, bgrData.rows=%d",
//        scaleData.cols, scaleData.rows, corpData.cols, corpData.rows, srcWidth, srcHeight, originData.cols, originData.rows, bgrData.cols, bgrData.rows);

    srcWidth = bgrData.cols;
    srcHeight = bgrData.rows;

    //转换为YV12
//    Log("NativeUtils_drawText(), entry, %s, scaleData.cols=%d, scaleData.rows=%d", "444",  scaleData.cols, scaleData.rows);
//    cvtColor(bgrData, bgrData, CV_BGR2YUV_YV12);
//    cvtColor(bgrData, bgrData, CV_BGR2YUV_I420);
//    cvtColor(corpData, corpData, CV_BGR2YUV_I420);
    cvtColor(scaleData, scaleData, CV_BGR2YUV_I420);
//    Log("NativeUtils_drawText(), entry, %s, scaleData.cols=%d, scaleData.rows=%d", "555",  scaleData.cols, scaleData.rows);



//    I420: YYYYYYYY UU VV =>YUV420P
//    YV12: YYYYYYYY VV UU =>YUV420P
//    NV12: YYYYYYYY UVUV =>YUV420SP
//    NV21: YYYYYYYY VUVU =>YUV420SP

//     //old convert
//    if (dxtx::videoEncodeColor == 19) {
//        Log("NativeUtils_drawText(), entry, %s", "555");
//        env->SetByteArrayRegion(srcData, 0, srcWidth * srcHeight * 3 / 2, (const jbyte *) bgrData.data);
//    } else if (dxtx::videoEncodeColor == 21) {
//        Log("NativeUtils_drawText(), entry, %s", "666");
//        //因为YV12 和NV21格式不同,需要重组UV分量
//        jbyte *out = new jbyte[srcWidth * srcHeight / 2];
//        int ulen = srcWidth * srcHeight / 4;
//        for (int i = 0; i < ulen; i += 1) {
//            //从YYYYYYYY UUVV 到YYYYYYYY VUVU
//            out[i * 2 + 1] = bgrData.at<uchar>(srcWidth * srcHeight + ulen + i);
//            out[i * 2] = bgrData.at<uchar>(srcWidth * srcHeight + i);
//        }
//
//        //返回到原来的数据
//        env->SetByteArrayRegion(srcData, 0, srcWidth * srcHeight, (const jbyte *) bgrData.data);
//        env->SetByteArrayRegion(srcData, srcWidth * srcHeight, srcWidth * srcHeight / 2, out);
//    }



//        // I420->NV12
//        jbyte *out = new jbyte[videoWidth * videoHeight / 2];
//        int ulen = videoWidth * videoHeight / 4;
//        for (int i = 0; i < ulen; i += 1) {
//            //从YYYYYYYY UUVV 到YYYYYYYY VUVU  I420->NV21
//
//            //从YYYYYYYY VVUU 到YYYYYYYY UVUV  YV12->NV12
////            out[i * 2] = dst.at<uchar>(srcWidth * srcHeight + ulen + i);
////            out[i * 2 + 1] = dst.at<uchar>(srcWidth * srcHeight + i);
//
//            //从YYYYYYYY VVUU 到YYYYYYYY VUVU  YV12->NV21
//
//            //从YYYYYYYY UUVV 到YYYYYYYY UVUV  I420->NV12 ***
//            out[i * 2] = scaleData.at<uchar>(videoWidth * videoHeight + i);
//            out[i * 2 + 1] = scaleData.at<uchar>(videoWidth * videoHeight + ulen + i);
//        }



//        // NV21->NV12
//        srcWidth = originData.cols;
//        srcHeight = originData.rows;
//        jbyte *out = new jbyte[srcWidth * srcHeight / 2];
//        int ulen = srcWidth * srcHeight / 4;
//        for (int i = 0; i < ulen; i += 1) {
//            //从YYYYYYYY VUVU 到YYYYYYYY UVUV  NV21->NV12 ***
//            out[i * 2]      = originData.at<uchar>(srcWidth * srcHeight + i * 2 + 1);
//            out[i * 2 + 1]  = originData.at<uchar>(srcWidth * srcHeight + i * 2);
//        }

        //返回到原来的数据
//        env->SetByteArrayRegion(srcData, 0, srcWidth * srcHeight, (const jbyte *) bgrData.data);
//        env->SetByteArrayRegion(srcData, srcWidth * srcHeight, srcWidth * srcHeight / 2, out);

//    Log("NativeUtils_drawText(), entry, %s, srcDataLen=%d, bgrDataLen=%d", "666", env->GetArrayLength(srcData), bgrData.cols * bgrData.rows * 3 / 2);
//    env->SetByteArrayRegion(srcData, 0, srcWidth * srcHeight * 3 / 2, (const jbyte *) bgrData.data);


//    Log("NativeUtils_drawText(), entry, %s, frameDataLen=%d, corpYuvLen=%d", "666", env->GetArrayLength(frameData), corpData.cols * corpData.rows * 3 / 2);
//    env->SetByteArrayRegion(frameData, 0, corpData.cols * corpData.rows, (const jbyte *) corpData.data);


//    Log("NativeUtils_drawText(), entry, %s, frameDataLen=%d, scaleDataLen=%d", "666", env->GetArrayLength(frameData), scaleData.cols * scaleData.rows * 3 / 2);
    env->SetByteArrayRegion(frameData, 0, scaleData.cols * scaleData.rows, (const jbyte *) scaleData.data);

//        env->SetByteArrayRegion(frameData, 0, videoWidth * videoHeight, (const jbyte *) scaleData.data);
//        env->SetByteArrayRegion(frameData, videoWidth * videoHeight, videoWidth * videoHeight / 2, out);


//    Log("NativeUtils_drawText(), entry, %s", "777");

}

/**
 * 用一个样本文字先确定文字的区域,用于绘制背景蒙层,与文字形成反差
 */
extern "C"
JNIEXPORT void JNICALL
Java_mqms_ncp_navercorp_com_testgpuimage_NativeUtils_fixTextArea(JNIEnv *env, jclass type, jstring text_) {
//    //转为为宽字符,确定文字范围
//    wchar_t *text = jstring2wchars(env, text_);
//    Size size = dxtx::textEditor->getTextSize(text);
//
//    //原始opencv方式确定文字范围
////    const char* text = env->GetStringUTFChars(text_,0);
////    int baseline;
////    Size size = getTextSize(text, CV_FONT_HERSHEY_COMPLEX, 0.6, 1, &baseline);
//
//    Log("text size width ->%d,%d", size.width, size.height);
//    //使用freetype后不可用getTextSize测量宽高
//    // 确定背景区域
//    CvRect rect = cvRect(0, 0, size.width + 10, size.height * 1.5);
//    //生成背景mask层
//    Mat bg(size.height * 1.5, size.width + 10, CV_8UC3, Scalar(0, 0, 0));
//
//    dxtx::size = size;
//    dxtx::rect = rect;
//    dxtx::bg = bg;

}

extern "C"
JNIEXPORT void JNICALL
Java_mqms_ncp_navercorp_com_testgpuimage_NativeUtils_release(JNIEnv *env, jclass type) {
//    if (&dxtx::bg != NULL) {
//        dxtx::bg.release();
//        dxtx::bg = NULL;
//    }
//    if (dxtx::textEditor != NULL) {
//        dxtx::textEditor->~CvxText();
//    }
}

extern "C"
JNIEXPORT void JNICALL
Java_mqms_ncp_navercorp_com_testgpuimage_NativeUtils_fixColorFormat(JNIEnv *env, jclass type, jint decodeColor,
                                        jint encodeColor) {
//    dxtx::videoDecodeColor = decodeColor;
//    dxtx::videoEncodeColor = encodeColor;
}

extern "C"
JNIEXPORT void JNICALL
Java_mqms_ncp_navercorp_com_testgpuimage_NativeUtils_fixFontFile(JNIEnv *env, jclass type, jstring ttfPath_) {
//    const char *ttfPath = env->GetStringUTFChars(ttfPath_, 0);
//    dxtx::textEditor = new CvxText(ttfPath);
//    Scalar textsize(24, 0.5, 0.1, 0);
//    float p = 1.f;
//    dxtx::textEditor->setFont(NULL, &textsize, NULL, &p);
//    env->ReleaseStringUTFChars(ttfPath_, ttfPath);
}

void addWatermark(unsigned char* camSrcData, unsigned char* frameData, int srcWidth, int srcHeight, int videoWidth, int videoHeight, const char* textWatermark, int camColorFormat) {

//    LOGD("-mqmsdebug, NativeUtils_addWatermark(), entry, srcWidth=%d, srcHeight=%d, videoWidth=%d, videoHeight=%d", srcWidth, srcHeight, videoWidth, videoHeight);

    Mat bgrData;
    Mat originData(srcHeight * 3 / 2, srcWidth, CV_8UC1, camSrcData);

    // convert color from NV21/YV12 of camera to bgr color format
    int code = 0;
//    LOGD("-mqmsdebug, NativeUtils_addWatermark(), entry, dxtx::videoDecodeColor=%d, dxtx::videoEncodeColor=%d", dxtx::videoDecodeColor, dxtx::videoEncodeColor);
    if (CAMERA_COLOR_VALUE_NV21 == camColorFormat) {
        code = CV_YUV2BGR_NV21;
    } else if (CAMERA_COLOR_VALUE_YV12 == camColorFormat) {
        code = CV_YUV2BGR_YV12;
    }  else {
        char *error;
        sprintf(error, "not support video color format:%d", camColorFormat);
        throw error;
    }
    cvtColor(originData, bgrData, code);

//    LOGD("-mqmsdebug, NativeUtils_addWatermark(), entry, %s", "222");


    // draw background
//    Mat textImg = Mat(bgrData);
//    Mat textImg = Mat::zeros(Size(500, 500), CV_8UC1);
    Mat textImg = Mat::zeros(Size(500, 500), CV_8UC1);//黑色图像
//    Mat textImg = Mat(Size(500, 500), CV_8UC1, Scalar(128,0,0));
    Mat textROI = bgrData(Rect(100, 100, 500, 500));
    Mat mask(textROI.rows, textROI.cols, textROI.depth(),Scalar(1));

//    Mat textImg = Mat(bgrData);
//    Mat textImaRect = bgrData(Rect(200, 200, 300, 300));
//    cv::rectangle(textImg, Point(0, 0), Point(500, 500), LINE_8);

    char* text = "123456789";
    int font_face = cv::FONT_HERSHEY_COMPLEX;
    double font_scale = 2;
    int thickness = 2;
    int baseline;
    cv::Point origin;
    cv::Size text_size = cv::getTextSize(text, font_face, font_scale, thickness, &baseline);
//    origin.x = bgrData.cols / 2 - text_size.width / 2;
//    origin.y = bgrData.rows / 2 + text_size.height / 2;
    origin.x = 0;
    origin.y = 500;
    cv::putText(textImg, text, origin, font_face, font_scale, cv::Scalar(0, 255, 0), thickness, LINE_8, 0);
    LOGD("NativeUtils_addWatermark()");
    textImg.copyTo(textROI, mask);
//    addWeighted(bgrData, 0.5, textImg, 0.5, 0.0, bgrData);

    // add water mark
#if (0)
    //#%04d.%05d#
//    static int count = 0;
//    count++;
//    char textWatermark[64] = {0};
//    sprintf(textWatermark, "#%04d.%05d#", count, count * 100 + count);
    std::string text = textWatermark;
    int font_face = cv::FONT_HERSHEY_COMPLEX;
    double font_scale = 2;
    int thickness = 2;
    int baseline;
    //获取文本框的长宽
    cv::Size text_size = cv::getTextSize(text, font_face, font_scale, thickness, &baseline);

    //将文本框居中绘制
    cv::Point origin;
    origin.x = bgrData.cols / 2 - text_size.width / 2;
    origin.y = bgrData.rows / 2 + text_size.height / 2;
    cv::putText(bgrData, text, origin, font_face, font_scale, cv::Scalar(0, 255, 255), thickness, 8, 0);
    LOGD("NativeUtils_addWatermark(),text=%s, origin.x=%d, origin.y=%d", text.c_str(), origin.x, origin.y);
#endif


    // corp image
    Mat cropData;
    float scaleWidth = (float)srcWidth / videoWidth;
    float scaleHeight = (float)srcHeight / videoHeight;
    Rect rect(0, 0, 0, 0);
    bool croppedData = false;
    if (fabs(scaleWidth - scaleHeight) > 0.00000001f) {
        // need crop
        float scale;
        if (scaleWidth > scaleHeight) {
            scale = scaleHeight;
        } else {
            scale = scaleWidth;
        }
        int destWidth = videoWidth * scale;
        int destHeight = videoHeight * scale;
        int corpWidth = srcWidth - destWidth;
        int corpHeight = srcHeight - destHeight;

        rect.x = corpWidth / 2;
        rect.y = corpHeight / 2;
        rect.width = destWidth;
        rect.height = destHeight;

        cropData = bgrData(rect);
//        LOGD("-mqmsdebug, NativeUtils_addWatermark(),  croppedData, %s, bgrData.cols=%d, bgrData.rows=%d, cropData.cols=%d, cropData.rows=%d", "444",
//            bgrData.cols, bgrData.rows, cropData.cols, cropData.rows);
        croppedData = true;
    }

    // scale image
    Mat scaleData;
    if (croppedData) {
        resize(cropData, scaleData, Size(videoWidth, videoHeight));
//        LOGD("-mqmsdebug, NativeUtils_addWatermark(),  croppedData, %s, cropData.cols=%d, cropData.rows=%d, scaleData.cols=%d, scaleData.rows=%d", "555",
//                cropData.cols, cropData.rows, scaleData.cols, scaleData.rows);
    } else {
        resize(bgrData, scaleData, Size(videoWidth, videoHeight));
//        LOGD("-mqmsdebug, NativeUtils_addWatermark(),  not croppedData, %s, bgrData.cols=%d, bgrData.rows=%d, scaleData.cols=%d, scaleData.rows=%d", "666",
//            bgrData.cols, bgrData.rows, scaleData.cols, scaleData.rows);
    }


//    LOGD("-mqmsdebug, NativeUtils_addWatermark(), entry, 333, scaleData.cols=%d, scaleData.rows=%d, cropData.cols=%d, cropData.rows=%d, srcWidth=%d, srcHeight=%d, originData.cols=%d, originData.rows=%d, bgrData.cols=%d, bgrData.rows=%d",
//        scaleData.cols, scaleData.rows, cropData.cols, cropData.rows, srcWidth, srcHeight, originData.cols, originData.rows, bgrData.cols, bgrData.rows);

    srcWidth = bgrData.cols;
    srcHeight = bgrData.rows;

    //转换为I420
    cvtColor(scaleData, scaleData, CV_BGR2YUV_I420);
//    LOGD("-mqmsdebug, NativeUtils_addWatermark(), entry, %s, cropData.cols=%d, cropData.rows=%d", "444",  cropData.cols, cropData.rows);

    // original preview data buf
    memcpy(camSrcData, bgrData.data, (size_t)bgrData.cols * bgrData.rows * 3 / 2);

    // video frame data buf
    memcpy(frameData, scaleData.data, (size_t)scaleData.cols * scaleData.rows);

//    env->SetByteArrayRegion(camSrcData, 0, srcWidth * srcHeight * 3 / 2, (const jbyte *) bgrData.data);
//    env->SetByteArrayRegion(frameData, 0, scaleData.cols * scaleData.rows, (const jbyte *) scaleData.data);

//    LOGD("-mqmsdebug, NativeUtils_addWatermark(), entry, %s", "777");

}

extern "C"
JNIEXPORT void JNICALL
Java_mqms_ncp_navercorp_com_testgpuimage_NativeUtils_jni_1addWatermark(JNIEnv *env, jclass type,
                                                                       jbyteArray camSrcData,
                                                                       jbyteArray videoFrameData,
                                                                       jint srcWidth,
                                                                       jint srcHeight,
                                                                       jint videoWidth,
                                                                       jint videoHeight,
                                                                       jstring textWatermark,
                                                                       jint camColorFormat) {
    jbyte *_camSrcData = env->GetByteArrayElements(camSrcData, NULL);
    jbyte *_videoFrameData = env->GetByteArrayElements(videoFrameData, NULL);
    const char *_textWaterMark = env->GetStringUTFChars(textWatermark, 0);

    addWatermark((unsigned char *) _camSrcData, (unsigned char *) _videoFrameData, srcWidth,
                 srcHeight, videoWidth, videoHeight, _textWaterMark, camColorFormat);

    env->ReleaseByteArrayElements(camSrcData, _camSrcData, 0);
    env->ReleaseByteArrayElements(videoFrameData, _videoFrameData, 0);
    env->ReleaseStringUTFChars(textWatermark, _textWaterMark);
}

