#pragma once

#include <wchar.h>
//#include
#include <locale.h>
#include <ctype.h>

#include "CvxText.h"

using namespace cv;

//====================================================================
//====================================================================

// 打开字库
CvxText::CvxText(const char *freeType) {
    assert(freeType != NULL);

    // 打开字库文件, 创建一个字体
    if (FT_Init_FreeType(&m_library)) throw "not found ttf";
    if (FT_New_Face(m_library, freeType, 0, &m_face)) throw "not found ttf";

    // 设置字体输出参数
    restoreFont();

    // 设置C语言的字符集环境
    setlocale(LC_ALL, "");

    // 设定为UNICODE，默认也是
    FT_Select_Charmap(m_face, FT_ENCODING_UNICODE);
}

// 释放FreeType资源
CvxText::~CvxText() {
    FT_Done_Face(m_face);
    FT_Done_FreeType(m_library);
}

void CvxText::getFont(int *type, Scalar *size, bool *underline, float *diaphaneity) {
    *type = m_fontType;
    *size = m_fontSize;
    *underline = m_fontUnderline;
    *diaphaneity = m_fontDiaphaneity;
}

void CvxText::setFont(int *type, Scalar *size, bool *underline, float *diaphaneity) {
    // 参数合法性检查

    if (type) {
        if (*type >= 0) m_fontType = *type;
    }
    if (size) {
        m_fontSize.val[0] = fabs(size->val[0]);
        m_fontSize.val[1] = fabs(size->val[1]);
        m_fontSize.val[2] = fabs(size->val[2]);
        m_fontSize.val[3] = fabs(size->val[3]);
    }
    if (underline) {
        m_fontUnderline = *underline;
    }
    if (diaphaneity) {
        m_fontDiaphaneity = *diaphaneity;
    }

    FT_Set_Pixel_Sizes(m_face, (int) m_fontSize.val[0], 0);
}

// 恢复原始的字体设置
void CvxText::restoreFont() {
    m_fontType = 0;            // 字体类型(不支持)

    m_fontSize.val[0] = 20;      // 字体大小
    m_fontSize.val[1] = 0.5;     // 空白字符大小比例
    m_fontSize.val[2] = 0.1;     // 间隔大小比例
    m_fontSize.val[3] = 0;       // 旋转角度(不支持)

    m_fontUnderline = false;   // 下画线(不支持)

    m_fontDiaphaneity = 1.0;   // 色彩比例(可产生透明效果)

    // 设置字符大小
    FT_Set_Pixel_Sizes(m_face, (int) m_fontSize.val[0], 0);
}

// 输出函数(颜色默认为黑色)
int CvxText::putText(Mat img, const char *text, Point pos) {
    if (3 == img.channels()) {
        return putText(img, text, pos, CV_RGB(255, 255, 255));
    } else {
        return putText(img, text, pos, Scalar(255));
    }

}

int CvxText::putText(Mat img, const wchar_t *text, Point pos) {
    return putText(img, text, pos, CV_RGB(255, 255, 255));
}

//


int CvxText::putText(Mat img, const char *text, Point pos, Scalar color) {
    if (img.data == NULL) return -1;
    if (text == NULL) return -1;

    int i(0);

    for (i = 0; text[i] != '\0'; ++i) {
        wchar_t wc = text[i];

        // 解析双字节符号,ndk编译不通过
//        if(!isascii(wc)) mbtowc(&wc, &text[i++], 2);

        // 输出当前的字符
        putWChar(img, wc, pos, color);
    }
    return i;
}

int CvxText::putText(Mat img, const wchar_t *text, Point pos, Scalar color) {
    if (img.data == NULL) return -1;
    if (text == NULL) return -1;

    int i;
    for (i = 0; text[i] != '\0'; ++i) {
        // 输出当前的字符
        putWChar(img, text[i], pos, color);
    }
    return i;
}


// 输出当前字符, 更新m_pos位置
void CvxText::putWChar(Mat img, wchar_t wc, Point &pos, Scalar color) {
    // 根据unicode生成字体的二值位图
    FT_UInt glyph_index = FT_Get_Char_Index(m_face, wc);
    FT_Load_Glyph(m_face, glyph_index, FT_LOAD_DEFAULT);
    FT_Render_Glyph(m_face->glyph, FT_RENDER_MODE_MONO);

    FT_GlyphSlot slot = m_face->glyph;

    // 行列数
    int rows = slot->bitmap.rows;
    int cols = slot->bitmap.width;

    // 图像的高度、宽度
    int nImgHeight = img.rows;
    int nImgWidth = img.cols;

    const int nOrigin = 0;

    for (int i = 0; i < rows; ++i) {
        for (int x = 0; x < cols; ++x) {
            int off = ((nOrigin == 0) ? i : (rows - 1 - i)) * slot->bitmap.pitch + x / 8;

//            if (slot->bitmap.buffer[off] & (0xC0 >> (x % 8))) {
            if ((slot->bitmap.buffer[off] << (x % 8)) & 0x80) {
                int r = (nOrigin == 0) ? pos.y - (rows - 1 - i) : pos.y + i;;
                int c = pos.x + x;

                if (r >= 0 && r < nImgHeight && c >= 0 && c < nImgWidth) {
                    /*switch (img.channels()) {
                        case 1: {
                            img.ptr<uchar>(r)[c] = uchar(
                                    img.ptr<uchar>(r)[c] * (1 - m_fontDiaphaneity) +
                                    color.val[0] * m_fontDiaphaneity);
                            break;
                        }
                        case 3: {
                            Mat_<Vec3b> _I = img;
                            _I(r, c)[0] = uchar(_I(r, c)[0] * (1 - m_fontDiaphaneity) +
                                                color.val[0] * m_fontDiaphaneity);
                            _I(r, c)[1] = uchar(_I(r, c)[1] * (1 - m_fontDiaphaneity) +
                                                color.val[1] * m_fontDiaphaneity);
                            _I(r, c)[2] = uchar(_I(r, c)[2] * (1 - m_fontDiaphaneity) +
                                                color.val[2] * m_fontDiaphaneity);
                            break;
                        }
                     }*/
                    IplImage *image = new IplImage(img);
                    CvScalar scalar = cvGet2D(image, r, c);
                    // 进行色彩融合
                    float p = m_fontDiaphaneity;
                    for (int k = 0; k < 4; ++k) {
                        scalar.val[k] = scalar.val[k] * (1 - p) + color.val[k] * p;
                    }
                    cvSet2D(image, r, c, scalar);
                }
            }
        } // end for
    } // end for

    // 修改下一个字的输出位置
    double space = m_fontSize.val[0] * m_fontSize.val[1];
    double sep = m_fontSize.val[0] * m_fontSize.val[2];

    pos.x += (int) ((cols ? cols : space) + sep);
}

Size CvxText::getTextSize(const wchar_t *text) {
    if (text == NULL) return Size(0,0);
    int width = 0, height = m_fontSize.val[0];

    //
    double space = m_fontSize.val[0] * m_fontSize.val[1];
    double sep = m_fontSize.val[0] * m_fontSize.val[2];

    int i;
    for (i = 0; text[i] != '\0'; ++i) {
        wchar_t wc = text[i];
        // 根据unicode生成字体的二值位图
        FT_UInt glyph_index = FT_Get_Char_Index(m_face, wc);
        FT_Load_Glyph(m_face, glyph_index, FT_LOAD_DEFAULT);
        FT_Render_Glyph(m_face->glyph, FT_RENDER_MODE_MONO);

        FT_GlyphSlot slot = m_face->glyph;
        int cols = slot->bitmap.width;

        width += (int) ((cols ? cols : space) + sep);
    }
    return Size(width, height);
}
