package com.mopub.mobileads.resource;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.common.util.Dips;

public class ProgressBarDrawable extends BaseWidgetDrawable
{
  private final Paint a = new Paint();
  private final Paint b;
  private int c;
  private int d;
  private int e;
  private int f;
  private float g;
  private final int h;

  public ProgressBarDrawable(Context paramContext)
  {
    this.a.setColor(-1);
    this.a.setAlpha(128);
    this.a.setStyle(DrawableConstants.ProgressBar.BACKGROUND_STYLE);
    this.a.setAntiAlias(true);
    this.b = new Paint();
    this.b.setColor(DrawableConstants.ProgressBar.PROGRESS_COLOR);
    this.b.setAlpha(255);
    this.b.setStyle(DrawableConstants.ProgressBar.PROGRESS_STYLE);
    this.b.setAntiAlias(true);
    this.h = Dips.dipsToIntPixels(4.0F, paramContext);
  }

  public void draw(Canvas paramCanvas)
  {
    paramCanvas.drawRect(getBounds(), this.a);
    float f1 = this.e / this.c;
    paramCanvas.drawRect(getBounds().left, getBounds().top, f1 * getBounds().right, getBounds().bottom, this.b);
    if ((this.d > 0) && (this.d < this.c))
    {
      float f2 = getBounds().right * this.g;
      paramCanvas.drawRect(f2, getBounds().top, f2 + this.h, getBounds().bottom, this.b);
    }
  }

  @VisibleForTesting
  public void forceCompletion()
  {
    this.e = this.c;
  }

  @Deprecated
  @VisibleForTesting
  public int getCurrentProgress()
  {
    return this.e;
  }

  @Deprecated
  @VisibleForTesting
  public float getSkipRatio()
  {
    return this.g;
  }

  public void reset()
  {
    this.f = 0;
  }

  public void setDurationAndSkipOffset(int paramInt1, int paramInt2)
  {
    this.c = paramInt1;
    this.d = paramInt2;
    this.g = (this.d / this.c);
  }

  public void setProgress(int paramInt)
  {
    if (paramInt >= this.f)
    {
      this.e = paramInt;
      this.f = paramInt;
    }
    while (true)
    {
      invalidateSelf();
      return;
      if (paramInt != 0)
      {
        MoPubLog.SdkLogEvent localSdkLogEvent = MoPubLog.SdkLogEvent.CUSTOM;
        Object[] arrayOfObject1 = new Object[1];
        Object[] arrayOfObject2 = new Object[2];
        arrayOfObject2[0] = Integer.valueOf(this.f);
        arrayOfObject2[1] = Integer.valueOf(paramInt);
        arrayOfObject1[0] = String.format("Progress not monotonically increasing: last = %d, current = %d", arrayOfObject2);
        MoPubLog.log(localSdkLogEvent, arrayOfObject1);
        forceCompletion();
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.mobileads.resource.ProgressBarDrawable
 * JD-Core Version:    0.6.2
 */