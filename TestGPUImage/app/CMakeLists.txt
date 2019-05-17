
cmake_minimum_required(VERSION 3.4.1)
#set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=gnu++11")

include_directories(
        ${PROJECT_SOURCE_DIR}/src/main/cpp/include
        ${PROJECT_SOURCE_DIR}/src/main/cpp/include/opencv
)

add_library(dxtx
            SHARED
            src/main/cpp/bs.cpp
#            src/main/cpp/CvxText.cpp
        )


#add_library(opencv SHARED IMPORTED )
#set_target_properties(opencv PROPERTIES IMPORTED_LOCATION ${PROJECT_SOURCE_DIR}/src/main/jniLibs/${ANDROID_ABI}/libopencv_java3.so)

add_library(freetype STATIC IMPORTED)
set_target_properties(freetype  PROPERTIES IMPORTED_LOCATION ${CMAKE_SOURCE_DIR}/src/main/jniLibs/${ANDROID_ABI}/libft2.a)


# test cpufeatures lib
#add_library(libndk_compat STATIC IMPORTED )
#set_target_properties(libndk_compat PROPERTIES IMPORTED_LOCATION ${PROJECT_SOURCE_DIR}/src/main/jniLibs/${ANDROID_ABI}/libndk_compat.a)
#
#add_library(libndk_compat_static STATIC IMPORTED )
#set_target_properties(libndk_compat_static PROPERTIES IMPORTED_LOCATION ${PROJECT_SOURCE_DIR}/src/main/jniLibs/${ANDROID_ABI}/libndk_compat_static.a)
#
#add_library(libndk_compat_test_static STATIC IMPORTED )
#set_target_properties(libndk_compat_test_static PROPERTIES IMPORTED_LOCATION ${PROJECT_SOURCE_DIR}/src/main/jniLibs/${ANDROID_ABI}/libndk_compat_test_static.a)
#
#add_library(libndk_compat_test_shared SHARED IMPORTED )
#set_target_properties(libndk_compat_test_shared PROPERTIES IMPORTED_LOCATION ${PROJECT_SOURCE_DIR}/src/main/jniLibs/${ANDROID_ABI}/libndk_compat_test_shared.so)


# opencv static lib
add_library(libcpufeatures STATIC IMPORTED )
set_target_properties(libcpufeatures PROPERTIES IMPORTED_LOCATION ${PROJECT_SOURCE_DIR}/src/main/jniLibs/${ANDROID_ABI}/libcpufeatures.a)

#add_library(libIlmImf STATIC IMPORTED )
#set_target_properties(libIlmImf PROPERTIES IMPORTED_LOCATION ${PROJECT_SOURCE_DIR}/src/main/jniLibs/${ANDROID_ABI}/libIlmImf.a)

#add_library(liblibjasper STATIC IMPORTED )
#set_target_properties(liblibjasper PROPERTIES IMPORTED_LOCATION ${PROJECT_SOURCE_DIR}/src/main/jniLibs/${ANDROID_ABI}/liblibjasper.a)

#add_library(liblibjpeg-turbo STATIC IMPORTED )
#set_target_properties(liblibjpeg-turbo PROPERTIES IMPORTED_LOCATION ${PROJECT_SOURCE_DIR}/src/main/jniLibs/${ANDROID_ABI}/liblibjpeg-turbo.a)

#add_library(liblibpng STATIC IMPORTED )
#set_target_properties(liblibpng PROPERTIES IMPORTED_LOCATION ${PROJECT_SOURCE_DIR}/src/main/jniLibs/${ANDROID_ABI}/liblibpng.a)

#add_library(liblibprotobuf STATIC IMPORTED )
#set_target_properties(liblibprotobuf PROPERTIES IMPORTED_LOCATION ${PROJECT_SOURCE_DIR}/src/main/jniLibs/${ANDROID_ABI}/liblibprotobuf.a)

#add_library(liblibtiff STATIC IMPORTED )
#set_target_properties(liblibtiff PROPERTIES IMPORTED_LOCATION ${PROJECT_SOURCE_DIR}/src/main/jniLibs/${ANDROID_ABI}/liblibtiff.a)

#add_library(liblibwebp STATIC IMPORTED )
#set_target_properties(liblibwebp PROPERTIES IMPORTED_LOCATION ${PROJECT_SOURCE_DIR}/src/main/jniLibs/${ANDROID_ABI}/liblibwebp.a)

#add_library(libopencv_calib3d STATIC IMPORTED )
#set_target_properties(libopencv_calib3d PROPERTIES IMPORTED_LOCATION ${PROJECT_SOURCE_DIR}/src/main/jniLibs/${ANDROID_ABI}/libopencv_calib3d.a)

add_library(libopencv_core STATIC IMPORTED )
set_target_properties(libopencv_core PROPERTIES IMPORTED_LOCATION ${PROJECT_SOURCE_DIR}/src/main/jniLibs/${ANDROID_ABI}/libopencv_core.a)

#add_library(libopencv_dnn STATIC IMPORTED )
#set_target_properties(libopencv_dnn PROPERTIES IMPORTED_LOCATION ${PROJECT_SOURCE_DIR}/src/main/jniLibs/${ANDROID_ABI}/libopencv_dnn.a)

#add_library(libopencv_features2d STATIC IMPORTED )
#set_target_properties(libopencv_features2d PROPERTIES IMPORTED_LOCATION ${PROJECT_SOURCE_DIR}/src/main/jniLibs/${ANDROID_ABI}/libopencv_features2d.a)

#add_library(libopencv_flann STATIC IMPORTED )
#set_target_properties(libopencv_flann PROPERTIES IMPORTED_LOCATION ${PROJECT_SOURCE_DIR}/src/main/jniLibs/${ANDROID_ABI}/libopencv_flann.a)

#add_library(libopencv_highgui STATIC IMPORTED )
#set_target_properties(libopencv_highgui PROPERTIES IMPORTED_LOCATION ${PROJECT_SOURCE_DIR}/src/main/jniLibs/${ANDROID_ABI}/libopencv_highgui.a)

#add_library(libopencv_imgcodecs STATIC IMPORTED )
#set_target_properties(libopencv_imgcodecs PROPERTIES IMPORTED_LOCATION ${PROJECT_SOURCE_DIR}/src/main/jniLibs/${ANDROID_ABI}/libopencv_imgcodecs.a)

add_library(libopencv_imgproc STATIC IMPORTED )
set_target_properties(libopencv_imgproc PROPERTIES IMPORTED_LOCATION ${PROJECT_SOURCE_DIR}/src/main/jniLibs/${ANDROID_ABI}/libopencv_imgproc.a)

#add_library(libopencv_ml STATIC IMPORTED )
#set_target_properties(libopencv_ml PROPERTIES IMPORTED_LOCATION ${PROJECT_SOURCE_DIR}/src/main/jniLibs/${ANDROID_ABI}/libopencv_ml.a)

#add_library(libopencv_objdetect STATIC IMPORTED )
#set_target_properties(libopencv_objdetect PROPERTIES IMPORTED_LOCATION ${PROJECT_SOURCE_DIR}/src/main/jniLibs/${ANDROID_ABI}/libopencv_objdetect.a)

#add_library(libopencv_photo STATIC IMPORTED )
#set_target_properties(libopencv_photo PROPERTIES IMPORTED_LOCATION ${PROJECT_SOURCE_DIR}/src/main/jniLibs/${ANDROID_ABI}/libopencv_photo.a)

#add_library(libopencv_shape STATIC IMPORTED )
#set_target_properties(libopencv_shape PROPERTIES IMPORTED_LOCATION ${PROJECT_SOURCE_DIR}/src/main/jniLibs/${ANDROID_ABI}/libopencv_shape.a)

#add_library(libopencv_stitching STATIC IMPORTED )
#set_target_properties(libopencv_stitching PROPERTIES IMPORTED_LOCATION ${PROJECT_SOURCE_DIR}/src/main/jniLibs/${ANDROID_ABI}/libopencv_stitching.a)

#add_library(libopencv_superres STATIC IMPORTED )
#set_target_properties(libopencv_superres PROPERTIES IMPORTED_LOCATION ${PROJECT_SOURCE_DIR}/src/main/jniLibs/${ANDROID_ABI}/libopencv_superres.a)

#add_library(libopencv_video STATIC IMPORTED )
#set_target_properties(libopencv_video PROPERTIES IMPORTED_LOCATION ${PROJECT_SOURCE_DIR}/src/main/jniLibs/${ANDROID_ABI}/libopencv_video.a)

#add_library(libopencv_videoio STATIC IMPORTED )
#set_target_properties(libopencv_videoio PROPERTIES IMPORTED_LOCATION ${PROJECT_SOURCE_DIR}/src/main/jniLibs/${ANDROID_ABI}/libopencv_videoio.a)

#add_library(libopencv_videostab STATIC IMPORTED )
#set_target_properties(libopencv_videostab PROPERTIES IMPORTED_LOCATION ${PROJECT_SOURCE_DIR}/src/main/jniLibs/${ANDROID_ABI}/libopencv_videostab.a)

#add_library(libquirc STATIC IMPORTED )
#set_target_properties(libquirc PROPERTIES IMPORTED_LOCATION ${PROJECT_SOURCE_DIR}/src/main/jniLibs/${ANDROID_ABI}/libquirc.a)

add_library(libtbb STATIC IMPORTED )
set_target_properties(libtbb PROPERTIES IMPORTED_LOCATION ${PROJECT_SOURCE_DIR}/src/main/jniLibs/${ANDROID_ABI}/libtbb.a)

add_library(libtegra_hal STATIC IMPORTED )
set_target_properties(libtegra_hal PROPERTIES IMPORTED_LOCATION ${PROJECT_SOURCE_DIR}/src/main/jniLibs/${ANDROID_ABI}/libtegra_hal.a)



target_link_libraries(dxtx

#        c++_static
        z

#        stlport_static
#        gnustl
#        opencv

# test cpufeatures lib
#        libndk_compat
#        libndk_compat_static
#        libndk_compat_test_static
#        libndk_compat_test_shared

# opencv static lib

        libopencv_imgproc
        libcpufeatures


#        libIlmImf
#        liblibjasper
#        liblibjpeg-turbo
#        liblibpng
#        liblibprotobuf
#        liblibtiff
#        liblibwebp
#        libopencv_calib3d
        libopencv_core
#        libopencv_dnn
#        libopencv_features2d
#        libopencv_flann
#        libopencv_highgui
#        libopencv_imgcodecs

#        libopencv_ml
#        libopencv_objdetect
#        libopencv_photo
#        libopencv_shape
#        libopencv_stitching
#        libopencv_superres
#        libopencv_video
#        libopencv_videoio
#        libopencv_videostab
#        libquirc
        libtbb
        libtegra_hal

#        freetype

        log
        )
