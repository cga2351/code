
cmake_minimum_required(VERSION 3.4.1)

set(MODULE_DIR ${PROJECT_SOURCE_DIR}/../../..)

include_directories(
        ${MODULE_DIR}/src/main/cpp/include
        ${MODULE_DIR}/src/main/cpp/include/opencv
)

add_library(native-lib SHARED native-lib.cpp)

################################################## opencv static lib
add_library(libcpufeatures STATIC IMPORTED )
set_target_properties(libcpufeatures PROPERTIES IMPORTED_LOCATION ${MODULE_DIR}/src/main/jniLibs/${ANDROID_ABI}/libcpufeatures.a)

add_library(libopencv_core STATIC IMPORTED )
set_target_properties(libopencv_core PROPERTIES IMPORTED_LOCATION ${MODULE_DIR}/src/main/jniLibs/${ANDROID_ABI}/libopencv_core.a)

add_library(libopencv_imgproc STATIC IMPORTED )
set_target_properties(libopencv_imgproc PROPERTIES IMPORTED_LOCATION ${MODULE_DIR}/src/main/jniLibs/${ANDROID_ABI}/libopencv_imgproc.a)

add_library(libtbb STATIC IMPORTED )
set_target_properties(libtbb PROPERTIES IMPORTED_LOCATION ${MODULE_DIR}/src/main/jniLibs/${ANDROID_ABI}/libtbb.a)

add_library(libtegra_hal STATIC IMPORTED )
set_target_properties(libtegra_hal PROPERTIES IMPORTED_LOCATION ${MODULE_DIR}/src/main/jniLibs/${ANDROID_ABI}/libtegra_hal.a)



target_link_libraries(
        native-lib
        z

        # opencv static lib
        libopencv_imgproc
        libcpufeatures
        libopencv_core

        libtbb
        libtegra_hal

        log
)