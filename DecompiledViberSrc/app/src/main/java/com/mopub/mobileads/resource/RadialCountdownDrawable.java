package com.mopub.mobileads.resource;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Numbers;

public class RadialCountdownDrawable extends BaseWidgetDrawable
{
  private final Paint a;
  private final Paint b;
  private final Paint c;
  private Rect d;
  private int e;
  private int f;
  private float g;

  public RadialCountdownDrawable(Context paramContext)
  {
    int i = Dips.dipsToIntPixels(3.0F, paramContext);
    float f1 = Dips.dipsToFloatPixels(18.0F, paramContext);
    this.a = new Paint();
    this.a.setColor(-1);
    this.a.setAlpha(128);
    this.a.setStyle(DrawableConstants.RadialCountdown.BACKGROUND_STYLE);
    this.a.setStrokeWidth(i);
    this.a.setAntiAlias(true);
    this.b = new Paint();
    this.b.setColor(-1);
    this.b.setAlpha(255);
    this.b.setStyle(DrawableConstants.RadialCountdown.PROGRESS_STYLE);
    this.b.setStrokeWidth(i);
    this.b.setAntiAlias(true);
    this.c = new Paint();
    this.c.setColor(-1);
    this.c.setTextAlign(DrawableConstants.RadialCountdown.TEXT_ALIGN);
    this.c.setTextSize(f1);
    this.c.setAntiAlias(true);
    this.d = new Rect();
  }

  public void draw(Canvas paramCanvas)
  {
    int i = getBounds().centerX();
    int j = getBounds().centerY();
    int k = Math.min(i, j);
    paramCanvas.drawCircle(i, j, k, this.a);
    String str = String.valueOf(this.f);
    a(paramCanvas, this.c, this.d, str);
    paramCanvas.drawArc(new RectF(getBounds()), -90.0F, this.g, false, this.b);
  }

  @Deprecated
  @VisibleForTesting
  public int getInitialCountdownMilliseconds()
  {
    return this.e;
  }

  public void setInitialCountdown(int paramInt)
  {
    this.e = paramInt;
  }

  public void updateCountdownProgress(int paramInt)
  {
    this.f = ((int)Numbers.convertMillisecondsToSecondsRoundedUp(this.e - paramInt));
    this.g = (360.0F * paramInt / this.e);
    invalidateSelf();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.mobileads.resource.RadialCountdownDrawable
 * JD-Core Version:    0.6.2
 */