package com.facebook.drawee.debug;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.drawee.debug.listener.ImageLoadingTimeListener;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import javax.annotation.Nullable;

public class DebugControllerOverlayDrawable extends Drawable
  implements ImageLoadingTimeListener
{
  private static final float IMAGE_SIZE_THRESHOLD_NOT_OK = 0.5F;
  private static final float IMAGE_SIZE_THRESHOLD_OK = 0.1F;
  private static final int MAX_LINE_WIDTH_EM = 7;
  private static final int MAX_NUMBER_OF_LINES = 7;
  private static final int MAX_TEXT_SIZE_PX = 40;
  private static final int MIN_TEXT_SIZE_PX = 12;
  private static final String NO_CONTROLLER_ID = "none";
  private static final int OUTLINE_COLOR = -26624;
  private static final int OUTLINE_STROKE_WIDTH_PX = 2;

  @VisibleForTesting
  static final int OVERLAY_COLOR_IMAGE_ALMOST_OK = 1728026624;

  @VisibleForTesting
  static final int OVERLAY_COLOR_IMAGE_NOT_OK = 1727284022;

  @VisibleForTesting
  static final int OVERLAY_COLOR_IMAGE_OK = 1716301648;
  private static final int TEXT_COLOR = -1;
  private static final int TEXT_LINE_SPACING_PX = 8;
  private static final int TEXT_PADDING_PX = 10;
  private String mControllerId;
  private int mCurrentTextXPx;
  private int mCurrentTextYPx;
  private long mFinalImageTimeMs;
  private int mFrameCount;
  private int mHeightPx;
  private String mImageFormat;
  private String mImageId;
  private int mImageSizeBytes;
  private int mLineIncrementPx;
  private int mLoopCount;
  private final Matrix mMatrix = new Matrix();
  private final Paint mPaint = new Paint(1);
  private final Rect mRect = new Rect();
  private final RectF mRectF = new RectF();
  private ScalingUtils.ScaleType mScaleType;
  private int mStartTextXPx;
  private int mStartTextYPx;
  private int mTextGravity = 80;
  private int mWidthPx;

  public DebugControllerOverlayDrawable()
  {
    reset();
  }

  private void addDebugText(Canvas paramCanvas, String paramString, @Nullable Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject == null)
      paramCanvas.drawText(paramString, this.mCurrentTextXPx, this.mCurrentTextYPx, this.mPaint);
    while (true)
    {
      this.mCurrentTextYPx += this.mLineIncrementPx;
      return;
      paramCanvas.drawText(String.format(paramString, paramArrayOfObject), this.mCurrentTextXPx, this.mCurrentTextYPx, this.mPaint);
    }
  }

  private void prepareDebugTextParameters(Rect paramRect, int paramInt1, int paramInt2)
  {
    int i = Math.min(40, Math.max(12, Math.min(paramRect.width() / paramInt2, paramRect.height() / paramInt1)));
    this.mPaint.setTextSize(i);
    this.mLineIncrementPx = (i + 8);
    if (this.mTextGravity == 80)
      this.mLineIncrementPx = (-1 * this.mLineIncrementPx);
    this.mStartTextXPx = (10 + paramRect.left);
    if (this.mTextGravity == 80);
    for (int j = -10 + paramRect.bottom; ; j = 12 + (10 + paramRect.top))
    {
      this.mStartTextYPx = j;
      return;
    }
  }

  @VisibleForTesting
  int determineOverlayColor(int paramInt1, int paramInt2, @Nullable ScalingUtils.ScaleType paramScaleType)
  {
    int i = getBounds().width();
    int j = getBounds().height();
    if ((i <= 0) || (j <= 0) || (paramInt1 <= 0) || (paramInt2 <= 0))
      return 1727284022;
    int m;
    int k;
    if (paramScaleType != null)
    {
      Rect localRect = this.mRect;
      this.mRect.top = 0;
      localRect.left = 0;
      this.mRect.right = i;
      this.mRect.bottom = j;
      this.mMatrix.reset();
      paramScaleType.getTransform(this.mMatrix, this.mRect, paramInt1, paramInt2, 0.0F, 0.0F);
      RectF localRectF = this.mRectF;
      this.mRectF.top = 0.0F;
      localRectF.left = 0.0F;
      this.mRectF.right = paramInt1;
      this.mRectF.bottom = paramInt2;
      this.mMatrix.mapRect(this.mRectF);
      int i2 = (int)this.mRectF.width();
      int i3 = (int)this.mRectF.height();
      m = Math.min(i, i2);
      k = Math.min(j, i3);
    }
    while (true)
    {
      float f1 = 0.1F * m;
      float f2 = 0.5F * m;
      float f3 = 0.1F * k;
      float f4 = 0.5F * k;
      int n = Math.abs(paramInt1 - m);
      int i1 = Math.abs(paramInt2 - k);
      if ((n < f1) && (i1 < f3))
        return 1716301648;
      if ((n < f2) && (i1 < f4))
        return 1728026624;
      return 1727284022;
      k = j;
      m = i;
    }
  }

  public void draw(Canvas paramCanvas)
  {
    Rect localRect = getBounds();
    this.mPaint.setStyle(Paint.Style.STROKE);
    this.mPaint.setStrokeWidth(2.0F);
    this.mPaint.setColor(-26624);
    paramCanvas.drawRect(localRect.left, localRect.top, localRect.right, localRect.bottom, this.mPaint);
    this.mPaint.setStyle(Paint.Style.FILL);
    this.mPaint.setColor(determineOverlayColor(this.mWidthPx, this.mHeightPx, this.mScaleType));
    paramCanvas.drawRect(localRect.left, localRect.top, localRect.right, localRect.bottom, this.mPaint);
    this.mPaint.setStyle(Paint.Style.FILL);
    this.mPaint.setStrokeWidth(0.0F);
    this.mPaint.setColor(-1);
    this.mCurrentTextXPx = this.mStartTextXPx;
    this.mCurrentTextYPx = this.mStartTextYPx;
    if (this.mImageId != null)
    {
      Object[] arrayOfObject9 = new Object[2];
      arrayOfObject9[0] = this.mControllerId;
      arrayOfObject9[1] = this.mImageId;
      addDebugText(paramCanvas, "IDs: %s, %s", arrayOfObject9);
    }
    while (true)
    {
      Object[] arrayOfObject2 = new Object[2];
      arrayOfObject2[0] = Integer.valueOf(localRect.width());
      arrayOfObject2[1] = Integer.valueOf(localRect.height());
      addDebugText(paramCanvas, "D: %dx%d", arrayOfObject2);
      Object[] arrayOfObject3 = new Object[2];
      arrayOfObject3[0] = Integer.valueOf(this.mWidthPx);
      arrayOfObject3[1] = Integer.valueOf(this.mHeightPx);
      addDebugText(paramCanvas, "I: %dx%d", arrayOfObject3);
      Object[] arrayOfObject4 = new Object[1];
      arrayOfObject4[0] = Integer.valueOf(this.mImageSizeBytes / 1024);
      addDebugText(paramCanvas, "I: %d KiB", arrayOfObject4);
      if (this.mImageFormat != null)
      {
        Object[] arrayOfObject8 = new Object[1];
        arrayOfObject8[0] = this.mImageFormat;
        addDebugText(paramCanvas, "i format: %s", arrayOfObject8);
      }
      if (this.mFrameCount > 0)
      {
        Object[] arrayOfObject7 = new Object[2];
        arrayOfObject7[0] = Integer.valueOf(this.mFrameCount);
        arrayOfObject7[1] = Integer.valueOf(this.mLoopCount);
        addDebugText(paramCanvas, "anim: f %d, l %d", arrayOfObject7);
      }
      if (this.mScaleType != null)
      {
        Object[] arrayOfObject6 = new Object[1];
        arrayOfObject6[0] = this.mScaleType;
        addDebugText(paramCanvas, "scale: %s", arrayOfObject6);
      }
      if (this.mFinalImageTimeMs >= 0L)
      {
        Object[] arrayOfObject5 = new Object[1];
        arrayOfObject5[0] = Long.valueOf(this.mFinalImageTimeMs);
        addDebugText(paramCanvas, "t: %d ms", arrayOfObject5);
      }
      return;
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = this.mControllerId;
      addDebugText(paramCanvas, "ID: %s", arrayOfObject1);
    }
  }

  public int getOpacity()
  {
    return -3;
  }

  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    prepareDebugTextParameters(paramRect, 7, 7);
  }

  public void onFinalImageSet(long paramLong)
  {
    this.mFinalImageTimeMs = paramLong;
    invalidateSelf();
  }

  public void reset()
  {
    this.mWidthPx = -1;
    this.mHeightPx = -1;
    this.mImageSizeBytes = -1;
    this.mFrameCount = -1;
    this.mLoopCount = -1;
    this.mImageFormat = null;
    setControllerId(null);
    this.mFinalImageTimeMs = -1L;
    invalidateSelf();
  }

  public void setAlpha(int paramInt)
  {
  }

  public void setAnimationInfo(int paramInt1, int paramInt2)
  {
    this.mFrameCount = paramInt1;
    this.mLoopCount = paramInt2;
    invalidateSelf();
  }

  public void setColorFilter(ColorFilter paramColorFilter)
  {
  }

  public void setControllerId(@Nullable String paramString)
  {
    if (paramString != null);
    while (true)
    {
      this.mControllerId = paramString;
      invalidateSelf();
      return;
      paramString = "none";
    }
  }

  public void setDimensions(int paramInt1, int paramInt2)
  {
    this.mWidthPx = paramInt1;
    this.mHeightPx = paramInt2;
    invalidateSelf();
  }

  public void setFinalImageTimeMs(long paramLong)
  {
    this.mFinalImageTimeMs = paramLong;
  }

  public void setImageFormat(@Nullable String paramString)
  {
    this.mImageFormat = paramString;
  }

  public void setImageId(@Nullable String paramString)
  {
    this.mImageId = paramString;
    invalidateSelf();
  }

  public void setImageSize(int paramInt)
  {
    this.mImageSizeBytes = paramInt;
  }

  public void setScaleType(ScalingUtils.ScaleType paramScaleType)
  {
    this.mScaleType = paramScaleType;
  }

  public void setTextGravity(int paramInt)
  {
    this.mTextGravity = paramInt;
    invalidateSelf();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.drawee.debug.DebugControllerOverlayDrawable
 * JD-Core Version:    0.6.2
 */