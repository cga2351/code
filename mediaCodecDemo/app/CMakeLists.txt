
cmake_minimum_required(VERSION 3.4.1)
set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=gnu++11")

#set(OpenCV_DIR C:/Users/user/Downloads/opencv-3.4.2-android-sdk/OpenCV-android-sdk/sdk/native/jni)
#find_package(OpenCV REQUIRED)
#target_include_directories(
#                            dxtx
#                            PRIVATE
#                            C:/Users/user/Downloads/opencv-3.4.2-android-sdk/OpenCV-android-sdk/sdk/native/jni/include
#                            src/main/jni/include
#                            )
include_directories(
        ${PROJECT_SOURCE_DIR}/src/main/jni/include
        ${PROJECT_SOURCE_DIR}/src/main/jni/include/opencv
)

add_library(dxtx
            SHARED
            src/main/jni/bs.cpp
            src/main/jni/CvxText.cpp)

add_library(lib_opencv SHARED IMPORTED )
set_target_properties(lib_opencv PROPERTIES IMPORTED_LOCATION ${PROJECT_SOURCE_DIR}/src/main/libs/${ANDROID_ABI}/libopencv_java3.so)

add_library(freetype STATIC IMPORTED)
set_target_properties(freetype  PROPERTIES IMPORTED_LOCATION ${CMAKE_SOURCE_DIR}/src/main/libs/${ANDROID_ABI}/libft2.a)

target_link_libraries(dxtx
                        freetype
                        lib_opencv
                        log )
