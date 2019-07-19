package com.mopub.mobileads.resource;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

public abstract class BaseWidgetDrawable extends Drawable
{
  protected void a(Canvas paramCanvas, Paint paramPaint, Rect paramRect, String paramString)
  {
    paramPaint.getTextBounds(paramString, 0, paramString.length(), paramRect);
    float f = (paramPaint.descent() - paramPaint.ascent()) / 2.0F - paramPaint.descent();
    paramCanvas.drawText(paramString, getBounds().centerX(), f + getBounds().centerY(), paramPaint);
  }

  public int getOpacity()
  {
    return 0;
  }

  public void setAlpha(int paramInt)
  {
  }

  public void setColorFilter(ColorFilter paramColorFilter)
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.mobileads.resource.BaseWidgetDrawable
 * JD-Core Version:    0.6.2
 */