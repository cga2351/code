package me.zhanghai.android.materialprogressbar;

import android.animation.Animator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.support.annotation.Keep;
import android.util.DisplayMetrics;

public class IndeterminateProgressDrawable extends IndeterminateProgressDrawableBase
{
  private static final float PADDED_INTRINSIC_SIZE_DP = 16.0F;
  private static final float PROGRESS_INTRINSIC_SIZE_DP = 3.2F;
  private static final RectF RECT_BOUND = new RectF(-21.0F, -21.0F, 21.0F, 21.0F);
  private static final RectF RECT_PADDED_BOUND = new RectF(-24.0F, -24.0F, 24.0F, 24.0F);
  private static final RectF RECT_PROGRESS = new RectF(-19.0F, -19.0F, 19.0F, 19.0F);
  private int mPaddedIntrinsicSize;
  private int mProgressIntrinsicSize;
  private RingPathTransform mRingPathTransform = new RingPathTransform(null);
  private RingRotation mRingRotation = new RingRotation(null);

  public IndeterminateProgressDrawable(Context paramContext)
  {
    super(paramContext);
    float f = paramContext.getResources().getDisplayMetrics().density;
    this.mProgressIntrinsicSize = Math.round(3.2F * f);
    this.mPaddedIntrinsicSize = Math.round(f * 16.0F);
    Animator[] arrayOfAnimator = new Animator[2];
    arrayOfAnimator[0] = Animators.createIndeterminate(this.mRingPathTransform);
    arrayOfAnimator[1] = Animators.createIndeterminateRotation(this.mRingRotation);
    this.mAnimators = arrayOfAnimator;
  }

  private void drawRing(Canvas paramCanvas, Paint paramPaint)
  {
    int i = paramCanvas.save();
    paramCanvas.rotate(this.mRingRotation.mRotation);
    float f1 = -90.0F + 360.0F * (this.mRingPathTransform.mTrimPathOffset + this.mRingPathTransform.mTrimPathStart);
    float f2 = 360.0F * (this.mRingPathTransform.mTrimPathEnd - this.mRingPathTransform.mTrimPathStart);
    paramCanvas.drawArc(RECT_PROGRESS, f1, f2, false, paramPaint);
    paramCanvas.restoreToCount(i);
  }

  private int getIntrinsicSize()
  {
    if (this.mUseIntrinsicPadding)
      return this.mPaddedIntrinsicSize;
    return this.mProgressIntrinsicSize;
  }

  public int getIntrinsicHeight()
  {
    return getIntrinsicSize();
  }

  public int getIntrinsicWidth()
  {
    return getIntrinsicSize();
  }

  protected void onDraw(Canvas paramCanvas, int paramInt1, int paramInt2, Paint paramPaint)
  {
    if (this.mUseIntrinsicPadding)
    {
      paramCanvas.scale(paramInt1 / RECT_PADDED_BOUND.width(), paramInt2 / RECT_PADDED_BOUND.height());
      paramCanvas.translate(RECT_PADDED_BOUND.width() / 2.0F, RECT_PADDED_BOUND.height() / 2.0F);
    }
    while (true)
    {
      drawRing(paramCanvas, paramPaint);
      return;
      paramCanvas.scale(paramInt1 / RECT_BOUND.width(), paramInt2 / RECT_BOUND.height());
      paramCanvas.translate(RECT_BOUND.width() / 2.0F, RECT_BOUND.height() / 2.0F);
    }
  }

  protected void onPreparePaint(Paint paramPaint)
  {
    paramPaint.setStyle(Paint.Style.STROKE);
    paramPaint.setStrokeWidth(4.0F);
    paramPaint.setStrokeCap(Paint.Cap.SQUARE);
    paramPaint.setStrokeJoin(Paint.Join.MITER);
  }

  private static class RingPathTransform
  {
    public float mTrimPathEnd;
    public float mTrimPathOffset;
    public float mTrimPathStart;

    @Keep
    public void setTrimPathEnd(float paramFloat)
    {
      this.mTrimPathEnd = paramFloat;
    }

    @Keep
    public void setTrimPathOffset(float paramFloat)
    {
      this.mTrimPathOffset = paramFloat;
    }

    @Keep
    public void setTrimPathStart(float paramFloat)
    {
      this.mTrimPathStart = paramFloat;
    }
  }

  private static class RingRotation
  {
    private float mRotation;

    @Keep
    public void setRotation(float paramFloat)
    {
      this.mRotation = paramFloat;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     me.zhanghai.android.materialprogressbar.IndeterminateProgressDrawable
 * JD-Core Version:    0.6.2
 */