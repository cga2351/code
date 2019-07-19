package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import java.util.Arrays;

public class FadeDrawable extends ArrayDrawable
{

  @VisibleForTesting
  public static final int TRANSITION_NONE = 2;

  @VisibleForTesting
  public static final int TRANSITION_RUNNING = 1;

  @VisibleForTesting
  public static final int TRANSITION_STARTING;

  @VisibleForTesting
  int mAlpha;

  @VisibleForTesting
  int[] mAlphas;

  @VisibleForTesting
  int mDurationMs;

  @VisibleForTesting
  boolean[] mIsLayerOn;
  private final Drawable[] mLayers;

  @VisibleForTesting
  int mPreventInvalidateCount;

  @VisibleForTesting
  int[] mStartAlphas;

  @VisibleForTesting
  long mStartTimeMs;

  @VisibleForTesting
  int mTransitionState;

  public FadeDrawable(Drawable[] paramArrayOfDrawable)
  {
    super(paramArrayOfDrawable);
    if (paramArrayOfDrawable.length >= i);
    while (true)
    {
      Preconditions.checkState(i, "At least one layer required!");
      this.mLayers = paramArrayOfDrawable;
      this.mStartAlphas = new int[paramArrayOfDrawable.length];
      this.mAlphas = new int[paramArrayOfDrawable.length];
      this.mAlpha = 255;
      this.mIsLayerOn = new boolean[paramArrayOfDrawable.length];
      this.mPreventInvalidateCount = 0;
      resetInternal();
      return;
      int j = 0;
    }
  }

  private void drawDrawableWithAlpha(Canvas paramCanvas, Drawable paramDrawable, int paramInt)
  {
    if ((paramDrawable != null) && (paramInt > 0))
    {
      this.mPreventInvalidateCount = (1 + this.mPreventInvalidateCount);
      paramDrawable.mutate().setAlpha(paramInt);
      this.mPreventInvalidateCount = (-1 + this.mPreventInvalidateCount);
      paramDrawable.draw(paramCanvas);
    }
  }

  private void resetInternal()
  {
    this.mTransitionState = 2;
    Arrays.fill(this.mStartAlphas, 0);
    this.mStartAlphas[0] = 255;
    Arrays.fill(this.mAlphas, 0);
    this.mAlphas[0] = 255;
    Arrays.fill(this.mIsLayerOn, false);
    this.mIsLayerOn[0] = true;
  }

  private boolean updateAlphas(float paramFloat)
  {
    int i = 0;
    boolean bool = true;
    if (i < this.mLayers.length)
    {
      if (this.mIsLayerOn[i] != 0);
      for (int j = 1; ; j = -1)
      {
        this.mAlphas[i] = ((int)(this.mStartAlphas[i] + paramFloat * (j * 255)));
        if (this.mAlphas[i] < 0)
          this.mAlphas[i] = 0;
        if (this.mAlphas[i] > 255)
          this.mAlphas[i] = 255;
        if ((this.mIsLayerOn[i] != 0) && (this.mAlphas[i] < 255))
          bool = false;
        if ((this.mIsLayerOn[i] == 0) && (this.mAlphas[i] > 0))
          bool = false;
        i++;
        break;
      }
    }
    return bool;
  }

  public void beginBatchMode()
  {
    this.mPreventInvalidateCount = (1 + this.mPreventInvalidateCount);
  }

  public void draw(Canvas paramCanvas)
  {
    int i = 2;
    int j = 1;
    int k = this.mTransitionState;
    int m = 0;
    switch (k)
    {
    case 2:
    default:
    case 0:
    case 1:
    }
    while (m < this.mLayers.length)
    {
      drawDrawableWithAlpha(paramCanvas, this.mLayers[m], this.mAlphas[m] * this.mAlpha / 255);
      m++;
      continue;
      System.arraycopy(this.mAlphas, 0, this.mStartAlphas, 0, this.mLayers.length);
      this.mStartTimeMs = getCurrentTimeMs();
      float f;
      label120: int i1;
      if (this.mDurationMs == 0)
      {
        f = 1.0F;
        i1 = updateAlphas(f);
        if (i1 == 0)
          break label157;
      }
      label157: for (int i2 = i; ; i2 = j)
      {
        this.mTransitionState = i2;
        j = i1;
        m = 0;
        break;
        f = 0.0F;
        break label120;
      }
      boolean bool;
      label173: int n;
      if (this.mDurationMs > 0)
      {
        bool = j;
        Preconditions.checkState(bool);
        n = updateAlphas((float)(getCurrentTimeMs() - this.mStartTimeMs) / this.mDurationMs);
        if (n == 0)
          break label225;
      }
      while (true)
      {
        this.mTransitionState = i;
        j = n;
        m = 0;
        break;
        bool = false;
        break label173;
        label225: i = j;
      }
    }
    if (j == 0)
      invalidateSelf();
  }

  public void endBatchMode()
  {
    this.mPreventInvalidateCount = (-1 + this.mPreventInvalidateCount);
    invalidateSelf();
  }

  public void fadeInAllLayers()
  {
    this.mTransitionState = 0;
    Arrays.fill(this.mIsLayerOn, true);
    invalidateSelf();
  }

  public void fadeInLayer(int paramInt)
  {
    this.mTransitionState = 0;
    this.mIsLayerOn[paramInt] = true;
    invalidateSelf();
  }

  public void fadeOutAllLayers()
  {
    this.mTransitionState = 0;
    Arrays.fill(this.mIsLayerOn, false);
    invalidateSelf();
  }

  public void fadeOutLayer(int paramInt)
  {
    this.mTransitionState = 0;
    this.mIsLayerOn[paramInt] = false;
    invalidateSelf();
  }

  public void fadeToLayer(int paramInt)
  {
    this.mTransitionState = 0;
    Arrays.fill(this.mIsLayerOn, false);
    this.mIsLayerOn[paramInt] = true;
    invalidateSelf();
  }

  public void fadeUpToLayer(int paramInt)
  {
    this.mTransitionState = 0;
    Arrays.fill(this.mIsLayerOn, 0, paramInt + 1, true);
    Arrays.fill(this.mIsLayerOn, paramInt + 1, this.mLayers.length, false);
    invalidateSelf();
  }

  public void finishTransitionImmediately()
  {
    this.mTransitionState = 2;
    int i = 0;
    if (i < this.mLayers.length)
    {
      int[] arrayOfInt = this.mAlphas;
      if (this.mIsLayerOn[i] != 0);
      for (int j = 255; ; j = 0)
      {
        arrayOfInt[i] = j;
        i++;
        break;
      }
    }
    invalidateSelf();
  }

  public int getAlpha()
  {
    return this.mAlpha;
  }

  protected long getCurrentTimeMs()
  {
    return SystemClock.uptimeMillis();
  }

  public int getTransitionDuration()
  {
    return this.mDurationMs;
  }

  @VisibleForTesting
  public int getTransitionState()
  {
    return this.mTransitionState;
  }

  public void invalidateSelf()
  {
    if (this.mPreventInvalidateCount == 0)
      super.invalidateSelf();
  }

  public boolean isLayerOn(int paramInt)
  {
    return this.mIsLayerOn[paramInt];
  }

  public void reset()
  {
    resetInternal();
    invalidateSelf();
  }

  public void setAlpha(int paramInt)
  {
    if (this.mAlpha != paramInt)
    {
      this.mAlpha = paramInt;
      invalidateSelf();
    }
  }

  public void setTransitionDuration(int paramInt)
  {
    this.mDurationMs = paramInt;
    if (this.mTransitionState == 1)
      this.mTransitionState = 0;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.drawee.drawable.FadeDrawable
 * JD-Core Version:    0.6.2
 */