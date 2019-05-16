
cmake_minimum_required(VERSION 3.4.1)
set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=gnu++11")

SET(LIBRARY_OUTPUT_PATH "${CMAKE_SOURCE_DIR}/build/output/libs/${ANDROID_ABI}")

add_subdirectory(${CMAKE_SOURCE_DIR}/cpu_features-0.3.0 ${CMAKE_SOURCE_DIR}/build/cpu_features-0.3.0_output/${ANDROID_ABI})


#add_library(test_build
#            SHARED
#            src/main/cpp/main.c)


add_library(test_build_static STATIC src/main/cpp/func.c)
#add_library(test_build_no_param src/main/cpp/func.c)
add_library(test_build SHARED src/main/cpp/func.c)


#target_link_libraries(testBuild
#        log )
