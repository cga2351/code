package com.mopub.mobileads.resource;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

public class CloseButtonDrawable extends BaseWidgetDrawable
{
  private final Paint a;
  private final float b;

  public CloseButtonDrawable()
  {
    this(8.0F);
  }

  public CloseButtonDrawable(float paramFloat)
  {
    this.b = (paramFloat / 2.0F);
    this.a = new Paint();
    this.a.setColor(-1);
    this.a.setStrokeWidth(paramFloat);
    this.a.setStrokeCap(DrawableConstants.CloseButton.STROKE_CAP);
  }

  public void draw(Canvas paramCanvas)
  {
    int i = getBounds().width();
    int j = getBounds().height();
    paramCanvas.drawLine(0.0F + this.b, j - this.b, i - this.b, 0.0F + this.b, this.a);
    paramCanvas.drawLine(0.0F + this.b, 0.0F + this.b, i - this.b, j - this.b, this.a);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.mobileads.resource.CloseButtonDrawable
 * JD-Core Version:    0.6.2
 */