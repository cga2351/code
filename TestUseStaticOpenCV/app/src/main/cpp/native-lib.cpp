#include <jni.h>
#include <string>
#include <opencv/opencv2/core/hal/interface.h>
#include <opencv/opencv2/core.hpp>
#include <opencv/opencv2/imgproc/types_c.h>
#include <opencv/opencv2/imgproc.hpp>
#include <opencv/opencv2/core/softfloat.hpp>
#include "cpu-features.h"
#include "pthread.h"
#include "android/log.h"

using namespace cv;

#define LOG_TAG "Use_Static_OpenCV"

void func();
extern "C" JNIEXPORT jstring JNICALL
Java_mqms_ncp_navercorp_com_testusestaticopencv_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {

    func();

    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}


void func() {

    uint64_t features = android_getCpuFeatures();
    __android_log_print(ANDROID_LOG_DEBUG, LOG_TAG, "func call android_getCpuFeatures() returns:%lld", features);

    cv::softdouble aaa;

    int srcHeight = 10;
    int srcWidth = 20;
    int videoHeight = 20;
    int videoWidth = 40;
    uchar* data = new uchar[10 * 20];

    Mat bgrData;
    Mat originData(srcHeight * 3 / 2, srcWidth, CV_8UC1, (uchar *) data);
    cvtColor(originData, bgrData, CV_YUV2BGR_NV21);


    Mat corpData;
    float scaleWidth = (float)srcWidth / videoWidth;
    float scaleHeight = (float)srcHeight / videoHeight;
    Rect rect(0, 0, 0, 0);
    bool needCorp = false;
    if (fabs(scaleWidth - scaleHeight) > 0.00000001f) {
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

        corpData = bgrData(rect);
        needCorp = true;
    }

    Mat scaleData;
    if (needCorp) {
        resize(corpData, scaleData, Size(videoWidth, videoHeight));
    } else {
        resize(bgrData, scaleData, Size(videoWidth, videoHeight));
    }

    __android_log_print(ANDROID_LOG_DEBUG, LOG_TAG, "NativeUtils_drawText(), entry, %s, scaleData.cols=%d, scaleData.rows=%d", "444",  scaleData.cols, scaleData.rows);
    cvtColor(scaleData, scaleData, CV_BGR2YUV_I420);
    __android_log_print(ANDROID_LOG_DEBUG, LOG_TAG, "NativeUtils_drawText(), entry, %s, scaleData.cols=%d, scaleData.rows=%d", "555",  scaleData.cols, scaleData.rows);




//    Java_mqms_ncp_navercorp_com_testgpuimage_NativeUtils_drawText();
}




