package com.facebook.react.views.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PathEffect;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region.Op;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.modules.i18nmanager.I18nUtil;
import com.facebook.react.uimanager.FloatUtil;
import com.facebook.react.uimanager.Spacing;
import com.facebook.yoga.YogaConstants;
import java.util.Arrays;
import java.util.Locale;
import javax.annotation.Nullable;

public class ReactViewBackgroundDrawable extends Drawable
{
  private static final int ALL_BITS_SET = -1;
  private static final int ALL_BITS_UNSET = 0;
  private static final int DEFAULT_BORDER_ALPHA = 255;
  private static final int DEFAULT_BORDER_COLOR = -16777216;
  private static final int DEFAULT_BORDER_RGB;
  private int mAlpha = 255;

  @Nullable
  private Spacing mBorderAlpha;

  @Nullable
  private float[] mBorderCornerRadii;

  @Nullable
  private Spacing mBorderRGB;
  private float mBorderRadius = (0.0F / 0.0F);

  @Nullable
  private BorderStyle mBorderStyle;

  @Nullable
  private Spacing mBorderWidth;

  @Nullable
  private Path mCenterDrawPath;
  private int mColor = 0;
  private final Context mContext;

  @Nullable
  private PointF mInnerBottomLeftCorner;

  @Nullable
  private PointF mInnerBottomRightCorner;

  @Nullable
  private Path mInnerClipPathForBorderRadius;

  @Nullable
  private RectF mInnerClipTempRectForBorderRadius;

  @Nullable
  private PointF mInnerTopLeftCorner;

  @Nullable
  private PointF mInnerTopRightCorner;
  private int mLayoutDirection;
  private boolean mNeedUpdatePathForBorderRadius = false;

  @Nullable
  private Path mOuterClipPathForBorderRadius;

  @Nullable
  private RectF mOuterClipTempRectForBorderRadius;
  private final Paint mPaint = new Paint(1);

  @Nullable
  private PathEffect mPathEffectForBorderStyle;

  @Nullable
  private Path mPathForBorder;

  @Nullable
  private Path mPathForBorderRadiusOutline;

  @Nullable
  private RectF mTempRectForBorderRadiusOutline;

  @Nullable
  private RectF mTempRectForCenterDrawPath;

  public ReactViewBackgroundDrawable(Context paramContext)
  {
    this.mContext = paramContext;
  }

  private static int colorFromAlphaAndRGBComponents(float paramFloat1, float paramFloat2)
  {
    return 0xFFFFFF & (int)paramFloat2 | 0xFF000000 & (int)paramFloat1 << 24;
  }

  private void drawQuadrilateral(Canvas paramCanvas, int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8)
  {
    if (paramInt == 0)
      return;
    if (this.mPathForBorder == null)
      this.mPathForBorder = new Path();
    this.mPaint.setColor(paramInt);
    this.mPathForBorder.reset();
    this.mPathForBorder.moveTo(paramFloat1, paramFloat2);
    this.mPathForBorder.lineTo(paramFloat3, paramFloat4);
    this.mPathForBorder.lineTo(paramFloat5, paramFloat6);
    this.mPathForBorder.lineTo(paramFloat7, paramFloat8);
    this.mPathForBorder.lineTo(paramFloat1, paramFloat2);
    paramCanvas.drawPath(this.mPathForBorder, this.mPaint);
  }

  private void drawRectangularBackgroundWithBorders(Canvas paramCanvas)
  {
    int i = ColorUtil.multiplyColorAlpha(this.mColor, this.mAlpha);
    if (Color.alpha(i) != 0)
    {
      this.mPaint.setColor(i);
      this.mPaint.setStyle(Paint.Style.FILL);
      paramCanvas.drawRect(getBounds(), this.mPaint);
    }
    RectF localRectF = getDirectionAwareBorderInsets();
    int j = Math.round(localRectF.left);
    int k = Math.round(localRectF.top);
    int m = Math.round(localRectF.right);
    int n = Math.round(localRectF.bottom);
    Rect localRect;
    int i1;
    int i2;
    int i3;
    int i4;
    int i16;
    int i17;
    int i18;
    label198: int i20;
    label210: int i21;
    label219: label224: int i5;
    if ((j > 0) || (m > 0) || (k > 0) || (n > 0))
    {
      localRect = getBounds();
      i1 = getBorderColor(0);
      i2 = getBorderColor(1);
      i3 = getBorderColor(2);
      i4 = getBorderColor(3);
      if (Build.VERSION.SDK_INT < 17)
        break label910;
      if (getResolvedLayoutDirection() != 1)
        break label436;
      i16 = 1;
      i17 = getBorderColor(4);
      i18 = getBorderColor(5);
      if (!I18nUtil.getInstance().doLeftAndRightSwapInRTL(this.mContext))
        break label456;
      if (isBorderColorDefined(4))
        break label903;
      if (isBorderColorDefined(5))
        break label896;
      i20 = i3;
      if (i16 == 0)
        break label442;
      i21 = i20;
      if (i16 == 0)
        break label449;
      i5 = i21;
    }
    while (true)
    {
      int i6 = localRect.left;
      int i7 = localRect.top;
      int i8 = fastBorderCompatibleColorOrZero(j, k, m, n, i5, i2, i1, i4);
      label436: label442: label449: label456: int i19;
      label465: label470: boolean bool1;
      boolean bool2;
      boolean bool3;
      if (i8 != 0)
      {
        if (Color.alpha(i8) != 0)
        {
          int i11 = localRect.right;
          int i12 = localRect.bottom;
          this.mPaint.setColor(i8);
          if (j > 0)
          {
            int i15 = i6 + j;
            paramCanvas.drawRect(i6, i7, i15, i12 - n, this.mPaint);
          }
          if (k > 0)
          {
            int i14 = i7 + k;
            paramCanvas.drawRect(j + i6, i7, i11, i14, this.mPaint);
          }
          if (m > 0)
            paramCanvas.drawRect(i11 - m, i7 + k, i11, i12, this.mPaint);
          if (n > 0)
          {
            int i13 = i12 - n;
            paramCanvas.drawRect(i6, i13, i11 - m, i12, this.mPaint);
          }
        }
        return;
        i16 = 0;
        break;
        i21 = i1;
        break label219;
        i1 = i20;
        break label224;
        if (i16 != 0)
        {
          i19 = i18;
          if (i16 == 0)
            break label526;
          bool1 = isBorderColorDefined(4);
          bool2 = isBorderColorDefined(5);
          if (i16 == 0)
            break label533;
          bool3 = bool2;
          label493: if (i16 == 0)
            break label540;
          label498: if (!bool3)
            break label889;
        }
      }
      label526: label533: label540: label889: for (i5 = i19; ; i5 = i1)
      {
        if (bool1)
        {
          i1 = i17;
          break;
          i19 = i17;
          break label465;
          i17 = i18;
          break label470;
          bool3 = bool1;
          break label493;
          bool1 = bool2;
          break label498;
          this.mPaint.setAntiAlias(false);
          int i9 = localRect.width();
          int i10 = localRect.height();
          if (j > 0)
          {
            float f9 = i6;
            float f10 = i7;
            float f11 = i6 + j;
            float f12 = i7 + k;
            float f13 = i6 + j;
            float f14 = i7 + i10 - n;
            float f15 = i6;
            float f16 = i7 + i10;
            drawQuadrilateral(paramCanvas, i5, f9, f10, f11, f12, f13, f14, f15, f16);
          }
          if (k > 0)
            drawQuadrilateral(paramCanvas, i2, i6, i7, i6 + j, i7 + k, i6 + i9 - m, i7 + k, i6 + i9, i7);
          if (m > 0)
          {
            float f1 = i6 + i9;
            float f2 = i7;
            float f3 = i6 + i9;
            float f4 = i7 + i10;
            float f5 = i6 + i9 - m;
            float f6 = i7 + i10 - n;
            float f7 = i6 + i9 - m;
            float f8 = k + i7;
            drawQuadrilateral(paramCanvas, i1, f1, f2, f3, f4, f5, f6, f7, f8);
          }
          if (n > 0)
            drawQuadrilateral(paramCanvas, i4, i6, i7 + i10, i6 + i9, i7 + i10, i6 + i9 - m, i7 + i10 - n, j + i6, i7 + i10 - n);
          this.mPaint.setAntiAlias(true);
          return;
        }
        i1 = i3;
        break;
      }
      label896: i20 = i18;
      break label210;
      label903: i1 = i17;
      break label198;
      label910: i5 = i1;
      i1 = i3;
    }
  }

  private void drawRoundedBackgroundWithBorders(Canvas paramCanvas)
  {
    updatePath();
    paramCanvas.save();
    int i = ColorUtil.multiplyColorAlpha(this.mColor, this.mAlpha);
    if (Color.alpha(i) != 0)
    {
      this.mPaint.setColor(i);
      this.mPaint.setStyle(Paint.Style.FILL);
      paramCanvas.drawPath(this.mInnerClipPathForBorderRadius, this.mPaint);
    }
    RectF localRectF = getDirectionAwareBorderInsets();
    if ((localRectF.top > 0.0F) || (localRectF.bottom > 0.0F) || (localRectF.left > 0.0F) || (localRectF.right > 0.0F))
    {
      float f1 = getFullBorderWidth();
      if ((localRectF.top != f1) || (localRectF.bottom != f1) || (localRectF.left != f1) || (localRectF.right != f1))
        break label221;
      if (f1 > 0.0F)
      {
        int i9 = getBorderColor(8);
        this.mPaint.setColor(ColorUtil.multiplyColorAlpha(i9, this.mAlpha));
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(f1);
        paramCanvas.drawPath(this.mCenterDrawPath, this.mPaint);
      }
    }
    paramCanvas.restore();
    return;
    label221: this.mPaint.setStyle(Paint.Style.FILL);
    paramCanvas.clipPath(this.mOuterClipPathForBorderRadius, Region.Op.INTERSECT);
    paramCanvas.clipPath(this.mInnerClipPathForBorderRadius, Region.Op.DIFFERENCE);
    int j = getBorderColor(0);
    int k = getBorderColor(1);
    int m = getBorderColor(2);
    int n = getBorderColor(3);
    int i3;
    label302: int i4;
    int i5;
    if (Build.VERSION.SDK_INT >= 17)
      if (getResolvedLayoutDirection() == 1)
      {
        i3 = 1;
        i4 = getBorderColor(4);
        i5 = getBorderColor(5);
        if (!I18nUtil.getInstance().doLeftAndRightSwapInRTL(this.mContext))
          break label658;
        if (isBorderColorDefined(4))
          break label775;
      }
    while (true)
    {
      if (!isBorderColorDefined(5));
      for (int i7 = m; ; i7 = i5)
      {
        int i8;
        label358: label363: int i1;
        int i2;
        if (i3 != 0)
        {
          i8 = i7;
          if (i3 == 0)
            break label651;
          i1 = j;
          i2 = i8;
        }
        while (true)
        {
          float f2 = this.mOuterClipTempRectForBorderRadius.left;
          float f3 = this.mOuterClipTempRectForBorderRadius.right;
          float f4 = this.mOuterClipTempRectForBorderRadius.top;
          float f5 = this.mOuterClipTempRectForBorderRadius.bottom;
          if (localRectF.left > 0.0F)
            drawQuadrilateral(paramCanvas, i2, f2, f4, this.mInnerTopLeftCorner.x, this.mInnerTopLeftCorner.y, this.mInnerBottomLeftCorner.x, this.mInnerBottomLeftCorner.y, f2, f5);
          if (localRectF.top > 0.0F)
            drawQuadrilateral(paramCanvas, k, f2, f4, this.mInnerTopLeftCorner.x, this.mInnerTopLeftCorner.y, this.mInnerTopRightCorner.x, this.mInnerTopRightCorner.y, f3, f4);
          if (localRectF.right > 0.0F)
          {
            float f6 = this.mInnerTopRightCorner.x;
            float f7 = this.mInnerTopRightCorner.y;
            float f8 = this.mInnerBottomRightCorner.x;
            float f9 = this.mInnerBottomRightCorner.y;
            drawQuadrilateral(paramCanvas, i1, f3, f4, f6, f7, f8, f9, f3, f5);
          }
          if (localRectF.bottom <= 0.0F)
            break;
          drawQuadrilateral(paramCanvas, n, f2, f5, this.mInnerBottomLeftCorner.x, this.mInnerBottomLeftCorner.y, this.mInnerBottomRightCorner.x, this.mInnerBottomRightCorner.y, f3, f5);
          break;
          i3 = 0;
          break label302;
          i8 = j;
          break label358;
          label651: j = i7;
          break label363;
          label658: int i6;
          label667: label672: boolean bool1;
          boolean bool2;
          boolean bool3;
          if (i3 != 0)
          {
            i6 = i5;
            if (i3 == 0)
              break label736;
            bool1 = isBorderColorDefined(4);
            bool2 = isBorderColorDefined(5);
            if (i3 == 0)
              break label743;
            bool3 = bool2;
            label695: if (i3 == 0)
              break label750;
          }
          label736: label743: label750: for (boolean bool4 = bool1; ; bool4 = bool2)
          {
            if (bool3)
              j = i6;
            if (!bool4)
              break label757;
            i1 = i4;
            i2 = j;
            break;
            i6 = i4;
            break label667;
            i4 = i5;
            break label672;
            bool3 = bool1;
            break label695;
          }
          label757: i1 = m;
          i2 = j;
        }
      }
      label775: j = i4;
    }
  }

  private static int fastBorderCompatibleColorOrZero(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    int i = -1;
    int j;
    int k;
    label19: int n;
    label34: int i2;
    label60: label64: label75: int i4;
    if (paramInt1 > 0)
    {
      j = paramInt5;
      if (paramInt2 <= 0)
        break label106;
      k = paramInt6;
      int m = j & k;
      if (paramInt3 <= 0)
        break label113;
      n = paramInt7;
      int i1 = n & m;
      if (paramInt4 > 0)
        i = paramInt8;
      i2 = i & i1;
      if (paramInt1 <= 0)
        break label120;
      if (paramInt2 <= 0)
        break label126;
      int i3 = paramInt5 | paramInt6;
      if (paramInt3 <= 0)
        break label132;
      i4 = i3 | paramInt7;
      if (paramInt4 <= 0)
        break label138;
    }
    while (true)
    {
      if (i2 != (i4 | paramInt8))
        break label144;
      return i2;
      j = i;
      break;
      label106: k = i;
      break label19;
      label113: n = i;
      break label34;
      label120: paramInt5 = 0;
      break label60;
      label126: paramInt6 = 0;
      break label64;
      label132: paramInt7 = 0;
      break label75;
      label138: paramInt8 = 0;
    }
    label144: return 0;
  }

  private int getBorderColor(int paramInt)
  {
    float f1;
    if (this.mBorderRGB != null)
    {
      f1 = this.mBorderRGB.get(paramInt);
      if (this.mBorderAlpha == null)
        break label43;
    }
    label43: for (float f2 = this.mBorderAlpha.get(paramInt); ; f2 = 255.0F)
    {
      return colorFromAlphaAndRGBComponents(f2, f1);
      f1 = 0.0F;
      break;
    }
  }

  private int getBorderWidth(int paramInt)
  {
    if (this.mBorderWidth == null)
      return 0;
    float f = this.mBorderWidth.get(paramInt);
    if (YogaConstants.isUndefined(f))
      return -1;
    return Math.round(f);
  }

  private static void getEllipseIntersectionWithLine(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6, double paramDouble7, double paramDouble8, PointF paramPointF)
  {
    double d1 = (paramDouble1 + paramDouble3) / 2.0D;
    double d2 = (paramDouble2 + paramDouble4) / 2.0D;
    double d3 = paramDouble5 - d1;
    double d4 = paramDouble6 - d2;
    double d5 = paramDouble7 - d1;
    double d6 = paramDouble8 - d2;
    double d7 = Math.abs(paramDouble3 - paramDouble1) / 2.0D;
    double d8 = Math.abs(paramDouble4 - paramDouble2) / 2.0D;
    double d9 = (d6 - d4) / (d5 - d3);
    double d10 = d4 - d3 * d9;
    double d11 = d8 * d8 + d9 * (d9 * (d7 * d7));
    double d12 = d9 * (d10 * (d7 * (2.0D * d7)));
    double d13 = Math.sqrt(-(d7 * d7 * (d10 * d10 - d8 * d8)) / d11 + Math.pow(d12 / (2.0D * d11), 2.0D));
    double d14 = -d12 / (d11 * 2.0D) - d13;
    double d15 = d10 + d9 * d14;
    double d16 = d1 + d14;
    double d17 = d2 + d15;
    if ((!Double.isNaN(d16)) && (!Double.isNaN(d17)))
    {
      paramPointF.x = ((float)d16);
      paramPointF.y = ((float)d17);
    }
  }

  private boolean isBorderColorDefined(int paramInt)
  {
    float f1 = (0.0F / 0.0F);
    if (this.mBorderRGB != null);
    for (float f2 = this.mBorderRGB.get(paramInt); ; f2 = f1)
    {
      if (this.mBorderAlpha != null)
        f1 = this.mBorderAlpha.get(paramInt);
      if ((YogaConstants.isUndefined(f2)) || (YogaConstants.isUndefined(f1)))
        break;
      return true;
    }
    return false;
  }

  private void setBorderAlpha(int paramInt, float paramFloat)
  {
    if (this.mBorderAlpha == null)
      this.mBorderAlpha = new Spacing(255.0F);
    if (!FloatUtil.floatsEqual(this.mBorderAlpha.getRaw(paramInt), paramFloat))
    {
      this.mBorderAlpha.set(paramInt, paramFloat);
      invalidateSelf();
    }
  }

  private void setBorderRGB(int paramInt, float paramFloat)
  {
    if (this.mBorderRGB == null)
      this.mBorderRGB = new Spacing(0.0F);
    if (!FloatUtil.floatsEqual(this.mBorderRGB.getRaw(paramInt), paramFloat))
    {
      this.mBorderRGB.set(paramInt, paramFloat);
      invalidateSelf();
    }
  }

  private void updatePath()
  {
    if (!this.mNeedUpdatePathForBorderRadius)
      return;
    this.mNeedUpdatePathForBorderRadius = false;
    if (this.mInnerClipPathForBorderRadius == null)
      this.mInnerClipPathForBorderRadius = new Path();
    if (this.mOuterClipPathForBorderRadius == null)
      this.mOuterClipPathForBorderRadius = new Path();
    if (this.mPathForBorderRadiusOutline == null)
      this.mPathForBorderRadiusOutline = new Path();
    if (this.mCenterDrawPath == null)
      this.mCenterDrawPath = new Path();
    if (this.mInnerClipTempRectForBorderRadius == null)
      this.mInnerClipTempRectForBorderRadius = new RectF();
    if (this.mOuterClipTempRectForBorderRadius == null)
      this.mOuterClipTempRectForBorderRadius = new RectF();
    if (this.mTempRectForBorderRadiusOutline == null)
      this.mTempRectForBorderRadiusOutline = new RectF();
    if (this.mTempRectForCenterDrawPath == null)
      this.mTempRectForCenterDrawPath = new RectF();
    this.mInnerClipPathForBorderRadius.reset();
    this.mOuterClipPathForBorderRadius.reset();
    this.mPathForBorderRadiusOutline.reset();
    this.mCenterDrawPath.reset();
    this.mInnerClipTempRectForBorderRadius.set(getBounds());
    this.mOuterClipTempRectForBorderRadius.set(getBounds());
    this.mTempRectForBorderRadiusOutline.set(getBounds());
    this.mTempRectForCenterDrawPath.set(getBounds());
    float f1 = getFullBorderWidth();
    if (f1 > 0.0F)
      this.mTempRectForCenterDrawPath.inset(0.5F * f1, f1 * 0.5F);
    RectF localRectF1 = getDirectionAwareBorderInsets();
    RectF localRectF2 = this.mInnerClipTempRectForBorderRadius;
    localRectF2.top += localRectF1.top;
    RectF localRectF3 = this.mInnerClipTempRectForBorderRadius;
    localRectF3.bottom -= localRectF1.bottom;
    RectF localRectF4 = this.mInnerClipTempRectForBorderRadius;
    localRectF4.left += localRectF1.left;
    RectF localRectF5 = this.mInnerClipTempRectForBorderRadius;
    localRectF5.right -= localRectF1.right;
    float f2 = getFullBorderRadius();
    float f3 = getBorderRadiusOrDefaultTo(f2, BorderRadiusLocation.TOP_LEFT);
    float f4 = getBorderRadiusOrDefaultTo(f2, BorderRadiusLocation.TOP_RIGHT);
    float f5 = getBorderRadiusOrDefaultTo(f2, BorderRadiusLocation.BOTTOM_LEFT);
    float f6 = getBorderRadiusOrDefaultTo(f2, BorderRadiusLocation.BOTTOM_RIGHT);
    int i;
    float f18;
    float f19;
    float f20;
    float f21;
    if (Build.VERSION.SDK_INT >= 17)
      if (getResolvedLayoutDirection() == 1)
      {
        i = 1;
        f18 = getBorderRadius(BorderRadiusLocation.TOP_START);
        f19 = getBorderRadius(BorderRadiusLocation.TOP_END);
        f20 = getBorderRadius(BorderRadiusLocation.BOTTOM_START);
        f21 = getBorderRadius(BorderRadiusLocation.BOTTOM_END);
        if (!I18nUtil.getInstance().doLeftAndRightSwapInRTL(this.mContext))
          break label1543;
        if (!YogaConstants.isUndefined(f18))
          break label1686;
      }
    while (true)
    {
      if (YogaConstants.isUndefined(f19));
      for (float f24 = f4; ; f24 = f19)
      {
        if (YogaConstants.isUndefined(f20));
        for (float f8 = f5; ; f8 = f20)
        {
          if (YogaConstants.isUndefined(f21));
          for (float f25 = f6; ; f25 = f21)
          {
            float f26;
            label514: label519: label528: label533: float f7;
            if (i != 0)
            {
              f26 = f24;
              if (i == 0)
                break label1522;
              if (i == 0)
                break label1529;
              f5 = f25;
              if (i == 0)
                break label1536;
              f7 = f3;
              f3 = f26;
            }
            while (true)
            {
              float f9 = Math.max(f3 - localRectF1.left, 0.0F);
              float f10 = Math.max(f3 - localRectF1.top, 0.0F);
              float f11 = Math.max(f7 - localRectF1.right, 0.0F);
              float f12 = Math.max(f7 - localRectF1.top, 0.0F);
              float f13 = Math.max(f8 - localRectF1.right, 0.0F);
              float f14 = Math.max(f8 - localRectF1.bottom, 0.0F);
              float f15 = Math.max(f5 - localRectF1.left, 0.0F);
              float f16 = Math.max(f5 - localRectF1.bottom, 0.0F);
              this.mInnerClipPathForBorderRadius.addRoundRect(this.mInnerClipTempRectForBorderRadius, new float[] { f9, f10, f11, f12, f13, f14, f15, f16 }, Path.Direction.CW);
              this.mOuterClipPathForBorderRadius.addRoundRect(this.mOuterClipTempRectForBorderRadius, new float[] { f3, f3, f7, f7, f8, f8, f5, f5 }, Path.Direction.CW);
              Spacing localSpacing = this.mBorderWidth;
              float f17 = 0.0F;
              if (localSpacing != null)
                f17 = this.mBorderWidth.get(8) / 2.0F;
              Path localPath1 = this.mPathForBorderRadiusOutline;
              RectF localRectF6 = this.mTempRectForBorderRadiusOutline;
              float[] arrayOfFloat1 = new float[8];
              arrayOfFloat1[0] = (f3 + f17);
              arrayOfFloat1[1] = (f3 + f17);
              arrayOfFloat1[2] = (f7 + f17);
              arrayOfFloat1[3] = (f7 + f17);
              arrayOfFloat1[4] = (f8 + f17);
              arrayOfFloat1[5] = (f8 + f17);
              arrayOfFloat1[6] = (f5 + f17);
              arrayOfFloat1[7] = (f5 + f17);
              localPath1.addRoundRect(localRectF6, arrayOfFloat1, Path.Direction.CW);
              Path localPath2 = this.mCenterDrawPath;
              RectF localRectF7 = this.mTempRectForCenterDrawPath;
              float[] arrayOfFloat2 = new float[8];
              arrayOfFloat2[0] = (f9 + f17);
              arrayOfFloat2[1] = (f10 + f17);
              arrayOfFloat2[2] = (f11 + f17);
              arrayOfFloat2[3] = (f12 + f17);
              arrayOfFloat2[4] = (f13 + f17);
              arrayOfFloat2[5] = (f14 + f17);
              arrayOfFloat2[6] = (f15 + f17);
              arrayOfFloat2[7] = (f17 + f16);
              localPath2.addRoundRect(localRectF7, arrayOfFloat2, Path.Direction.CW);
              if (this.mInnerTopLeftCorner == null)
                this.mInnerTopLeftCorner = new PointF();
              this.mInnerTopLeftCorner.x = this.mInnerClipTempRectForBorderRadius.left;
              this.mInnerTopLeftCorner.y = this.mInnerClipTempRectForBorderRadius.top;
              getEllipseIntersectionWithLine(this.mInnerClipTempRectForBorderRadius.left, this.mInnerClipTempRectForBorderRadius.top, this.mInnerClipTempRectForBorderRadius.left + f9 * 2.0F, this.mInnerClipTempRectForBorderRadius.top + f10 * 2.0F, this.mOuterClipTempRectForBorderRadius.left, this.mOuterClipTempRectForBorderRadius.top, this.mInnerClipTempRectForBorderRadius.left, this.mInnerClipTempRectForBorderRadius.top, this.mInnerTopLeftCorner);
              if (this.mInnerBottomLeftCorner == null)
                this.mInnerBottomLeftCorner = new PointF();
              this.mInnerBottomLeftCorner.x = this.mInnerClipTempRectForBorderRadius.left;
              this.mInnerBottomLeftCorner.y = this.mInnerClipTempRectForBorderRadius.bottom;
              getEllipseIntersectionWithLine(this.mInnerClipTempRectForBorderRadius.left, this.mInnerClipTempRectForBorderRadius.bottom - 2.0F * f16, this.mInnerClipTempRectForBorderRadius.left + 2.0F * f15, this.mInnerClipTempRectForBorderRadius.bottom, this.mOuterClipTempRectForBorderRadius.left, this.mOuterClipTempRectForBorderRadius.bottom, this.mInnerClipTempRectForBorderRadius.left, this.mInnerClipTempRectForBorderRadius.bottom, this.mInnerBottomLeftCorner);
              if (this.mInnerTopRightCorner == null)
                this.mInnerTopRightCorner = new PointF();
              this.mInnerTopRightCorner.x = this.mInnerClipTempRectForBorderRadius.right;
              this.mInnerTopRightCorner.y = this.mInnerClipTempRectForBorderRadius.top;
              getEllipseIntersectionWithLine(this.mInnerClipTempRectForBorderRadius.right - 2.0F * f11, this.mInnerClipTempRectForBorderRadius.top, this.mInnerClipTempRectForBorderRadius.right, this.mInnerClipTempRectForBorderRadius.top + 2.0F * f12, this.mOuterClipTempRectForBorderRadius.right, this.mOuterClipTempRectForBorderRadius.top, this.mInnerClipTempRectForBorderRadius.right, this.mInnerClipTempRectForBorderRadius.top, this.mInnerTopRightCorner);
              if (this.mInnerBottomRightCorner == null)
                this.mInnerBottomRightCorner = new PointF();
              this.mInnerBottomRightCorner.x = this.mInnerClipTempRectForBorderRadius.right;
              this.mInnerBottomRightCorner.y = this.mInnerClipTempRectForBorderRadius.bottom;
              getEllipseIntersectionWithLine(this.mInnerClipTempRectForBorderRadius.right - 2.0F * f13, this.mInnerClipTempRectForBorderRadius.bottom - 2.0F * f14, this.mInnerClipTempRectForBorderRadius.right, this.mInnerClipTempRectForBorderRadius.bottom, this.mOuterClipTempRectForBorderRadius.right, this.mOuterClipTempRectForBorderRadius.bottom, this.mInnerClipTempRectForBorderRadius.right, this.mInnerClipTempRectForBorderRadius.bottom, this.mInnerBottomRightCorner);
              return;
              i = 0;
              break;
              f26 = f3;
              break label514;
              label1522: f3 = f24;
              break label519;
              label1529: f5 = f8;
              break label528;
              label1536: f8 = f25;
              break label533;
              label1543: float f22;
              label1552: label1557: float f23;
              if (i != 0)
              {
                f22 = f19;
                if (i == 0)
                  break label1633;
                if (i == 0)
                  break label1640;
                f23 = f21;
                label1566: if (i == 0)
                  break label1647;
              }
              while (true)
              {
                if (!YogaConstants.isUndefined(f22))
                  f3 = f22;
                if (!YogaConstants.isUndefined(f18))
                  f4 = f18;
                if (!YogaConstants.isUndefined(f23))
                  f5 = f23;
                if (YogaConstants.isUndefined(f20))
                  break label1654;
                f7 = f4;
                f8 = f20;
                break;
                f22 = f18;
                break label1552;
                label1633: f18 = f19;
                break label1557;
                label1640: f23 = f20;
                break label1566;
                label1647: f20 = f21;
              }
              label1654: f7 = f4;
              f8 = f6;
            }
          }
        }
      }
      label1686: f3 = f18;
    }
  }

  private void updatePathEffect()
  {
    if (this.mBorderStyle != null);
    for (PathEffect localPathEffect = BorderStyle.getPathEffect(this.mBorderStyle, getFullBorderWidth()); ; localPathEffect = null)
    {
      this.mPathEffectForBorderStyle = localPathEffect;
      this.mPaint.setPathEffect(this.mPathEffectForBorderStyle);
      return;
    }
  }

  public void draw(Canvas paramCanvas)
  {
    updatePathEffect();
    if (!hasRoundedBorders())
    {
      drawRectangularBackgroundWithBorders(paramCanvas);
      return;
    }
    drawRoundedBackgroundWithBorders(paramCanvas);
  }

  public int getAlpha()
  {
    return this.mAlpha;
  }

  public float getBorderRadius(BorderRadiusLocation paramBorderRadiusLocation)
  {
    return getBorderRadiusOrDefaultTo((0.0F / 0.0F), paramBorderRadiusLocation);
  }

  public float getBorderRadiusOrDefaultTo(float paramFloat, BorderRadiusLocation paramBorderRadiusLocation)
  {
    if (this.mBorderCornerRadii == null);
    float f;
    do
    {
      return paramFloat;
      f = this.mBorderCornerRadii[paramBorderRadiusLocation.ordinal()];
    }
    while (YogaConstants.isUndefined(f));
    return f;
  }

  public float getBorderWidthOrDefaultTo(float paramFloat, int paramInt)
  {
    if (this.mBorderWidth == null);
    float f;
    do
    {
      return paramFloat;
      f = this.mBorderWidth.getRaw(paramInt);
    }
    while (YogaConstants.isUndefined(f));
    return f;
  }

  @VisibleForTesting
  public int getColor()
  {
    return this.mColor;
  }

  public RectF getDirectionAwareBorderInsets()
  {
    int i = 1;
    float f1 = getBorderWidthOrDefaultTo(0.0F, 8);
    float f2 = getBorderWidthOrDefaultTo(f1, i);
    float f3 = getBorderWidthOrDefaultTo(f1, 3);
    float f4 = getBorderWidthOrDefaultTo(f1, 0);
    float f5 = getBorderWidthOrDefaultTo(f1, 2);
    float f6;
    float f7;
    if ((Build.VERSION.SDK_INT >= 17) && (this.mBorderWidth != null))
      if (getResolvedLayoutDirection() == i)
      {
        f6 = this.mBorderWidth.getRaw(4);
        f7 = this.mBorderWidth.getRaw(5);
        if (!I18nUtil.getInstance().doLeftAndRightSwapInRTL(this.mContext))
          break label171;
        if (YogaConstants.isUndefined(f6))
          f6 = f4;
        if (!YogaConstants.isUndefined(f7))
          break label224;
      }
    label129: label164: label171: label179: label217: label224: for (float f9 = f5; ; f9 = f7)
    {
      float f10;
      if (i != 0)
      {
        f10 = f9;
        if (i == 0)
          break label164;
      }
      while (true)
      {
        f4 = f10;
        return new RectF(f4, f2, f6, f3);
        i = 0;
        break;
        f10 = f6;
        break label129;
        f6 = f9;
      }
      float f8;
      if (i != 0)
      {
        f8 = f7;
        if (i == 0)
          break label217;
      }
      while (true)
      {
        if (!YogaConstants.isUndefined(f8))
          f4 = f8;
        if (!YogaConstants.isUndefined(f6))
          break;
        f6 = f5;
        break;
        f8 = f6;
        break label179;
        f6 = f7;
      }
    }
  }

  public float getFullBorderRadius()
  {
    if (YogaConstants.isUndefined(this.mBorderRadius))
      return 0.0F;
    return this.mBorderRadius;
  }

  public float getFullBorderWidth()
  {
    if ((this.mBorderWidth != null) && (!YogaConstants.isUndefined(this.mBorderWidth.getRaw(8))))
      return this.mBorderWidth.getRaw(8);
    return 0.0F;
  }

  public int getOpacity()
  {
    return ColorUtil.getOpacityFromColor(ColorUtil.multiplyColorAlpha(this.mColor, this.mAlpha));
  }

  public void getOutline(Outline paramOutline)
  {
    if (Build.VERSION.SDK_INT < 21)
    {
      super.getOutline(paramOutline);
      return;
    }
    if (((!YogaConstants.isUndefined(this.mBorderRadius)) && (this.mBorderRadius > 0.0F)) || (this.mBorderCornerRadii != null))
    {
      updatePath();
      paramOutline.setConvexPath(this.mPathForBorderRadiusOutline);
      return;
    }
    paramOutline.setRect(getBounds());
  }

  public int getResolvedLayoutDirection()
  {
    return this.mLayoutDirection;
  }

  public boolean hasRoundedBorders()
  {
    if ((!YogaConstants.isUndefined(this.mBorderRadius)) && (this.mBorderRadius > 0.0F))
      return true;
    if (this.mBorderCornerRadii != null)
    {
      float[] arrayOfFloat = this.mBorderCornerRadii;
      int i = arrayOfFloat.length;
      for (int j = 0; ; j++)
      {
        if (j >= i)
          break label69;
        float f = arrayOfFloat[j];
        if ((!YogaConstants.isUndefined(f)) && (f > 0.0F))
          break;
      }
    }
    label69: return false;
  }

  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    this.mNeedUpdatePathForBorderRadius = true;
  }

  public boolean onResolvedLayoutDirectionChanged(int paramInt)
  {
    return false;
  }

  public void setAlpha(int paramInt)
  {
    if (paramInt != this.mAlpha)
    {
      this.mAlpha = paramInt;
      invalidateSelf();
    }
  }

  public void setBorderColor(int paramInt, float paramFloat1, float paramFloat2)
  {
    setBorderRGB(paramInt, paramFloat1);
    setBorderAlpha(paramInt, paramFloat2);
  }

  public void setBorderStyle(@Nullable String paramString)
  {
    if (paramString == null);
    for (BorderStyle localBorderStyle = null; ; localBorderStyle = BorderStyle.valueOf(paramString.toUpperCase(Locale.US)))
    {
      if (this.mBorderStyle != localBorderStyle)
      {
        this.mBorderStyle = localBorderStyle;
        this.mNeedUpdatePathForBorderRadius = true;
        invalidateSelf();
      }
      return;
    }
  }

  public void setBorderWidth(int paramInt, float paramFloat)
  {
    if (this.mBorderWidth == null)
      this.mBorderWidth = new Spacing();
    if (!FloatUtil.floatsEqual(this.mBorderWidth.getRaw(paramInt), paramFloat))
    {
      this.mBorderWidth.set(paramInt, paramFloat);
      switch (paramInt)
      {
      case 6:
      case 7:
      default:
      case 0:
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 8:
      }
    }
    while (true)
    {
      invalidateSelf();
      return;
      this.mNeedUpdatePathForBorderRadius = true;
    }
  }

  public void setColor(int paramInt)
  {
    this.mColor = paramInt;
    invalidateSelf();
  }

  public void setColorFilter(ColorFilter paramColorFilter)
  {
  }

  public void setRadius(float paramFloat)
  {
    if (!FloatUtil.floatsEqual(this.mBorderRadius, paramFloat))
    {
      this.mBorderRadius = paramFloat;
      this.mNeedUpdatePathForBorderRadius = true;
      invalidateSelf();
    }
  }

  public void setRadius(float paramFloat, int paramInt)
  {
    if (this.mBorderCornerRadii == null)
    {
      this.mBorderCornerRadii = new float[8];
      Arrays.fill(this.mBorderCornerRadii, (0.0F / 0.0F));
    }
    if (!FloatUtil.floatsEqual(this.mBorderCornerRadii[paramInt], paramFloat))
    {
      this.mBorderCornerRadii[paramInt] = paramFloat;
      this.mNeedUpdatePathForBorderRadius = true;
      invalidateSelf();
    }
  }

  public boolean setResolvedLayoutDirection(int paramInt)
  {
    if (this.mLayoutDirection != paramInt)
    {
      this.mLayoutDirection = paramInt;
      return onResolvedLayoutDirectionChanged(paramInt);
    }
    return false;
  }

  public static enum BorderRadiusLocation
  {
    static
    {
      BOTTOM_RIGHT = new BorderRadiusLocation("BOTTOM_RIGHT", 2);
      BOTTOM_LEFT = new BorderRadiusLocation("BOTTOM_LEFT", 3);
      TOP_START = new BorderRadiusLocation("TOP_START", 4);
      TOP_END = new BorderRadiusLocation("TOP_END", 5);
      BOTTOM_START = new BorderRadiusLocation("BOTTOM_START", 6);
      BOTTOM_END = new BorderRadiusLocation("BOTTOM_END", 7);
      BorderRadiusLocation[] arrayOfBorderRadiusLocation = new BorderRadiusLocation[8];
      arrayOfBorderRadiusLocation[0] = TOP_LEFT;
      arrayOfBorderRadiusLocation[1] = TOP_RIGHT;
      arrayOfBorderRadiusLocation[2] = BOTTOM_RIGHT;
      arrayOfBorderRadiusLocation[3] = BOTTOM_LEFT;
      arrayOfBorderRadiusLocation[4] = TOP_START;
      arrayOfBorderRadiusLocation[5] = TOP_END;
      arrayOfBorderRadiusLocation[6] = BOTTOM_START;
      arrayOfBorderRadiusLocation[7] = BOTTOM_END;
    }
  }

  private static enum BorderStyle
  {
    static
    {
      DASHED = new BorderStyle("DASHED", 1);
      DOTTED = new BorderStyle("DOTTED", 2);
      BorderStyle[] arrayOfBorderStyle = new BorderStyle[3];
      arrayOfBorderStyle[0] = SOLID;
      arrayOfBorderStyle[1] = DASHED;
      arrayOfBorderStyle[2] = DOTTED;
    }

    @Nullable
    public static PathEffect getPathEffect(BorderStyle paramBorderStyle, float paramFloat)
    {
      switch (ReactViewBackgroundDrawable.1.$SwitchMap$com$facebook$react$views$view$ReactViewBackgroundDrawable$BorderStyle[paramBorderStyle.ordinal()])
      {
      default:
        return null;
      case 1:
        return null;
      case 2:
        float[] arrayOfFloat = new float[4];
        arrayOfFloat[0] = (paramFloat * 3.0F);
        arrayOfFloat[1] = (paramFloat * 3.0F);
        arrayOfFloat[2] = (paramFloat * 3.0F);
        arrayOfFloat[3] = (3.0F * paramFloat);
        return new DashPathEffect(arrayOfFloat, 0.0F);
      case 3:
      }
      return new DashPathEffect(new float[] { paramFloat, paramFloat, paramFloat, paramFloat }, 0.0F);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.views.view.ReactViewBackgroundDrawable
 * JD-Core Version:    0.6.2
 */