package com.viber.common.ui.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.drawable.shapes.Shape;
import com.viber.common.d.h;

public class d extends Shape
{
  private final int a;
  private final Path b;

  public d(int paramInt)
  {
    this.a = paramInt;
    this.b = new Path();
  }

  public void draw(Canvas paramCanvas, Paint paramPaint)
  {
    paramPaint.setStyle(Paint.Style.FILL);
    paramPaint.setColor(this.a);
    paramCanvas.drawPath(this.b, paramPaint);
  }

  protected void onResize(float paramFloat1, float paramFloat2)
  {
    super.onResize(paramFloat1, paramFloat2);
    int i = Math.round(Math.max(paramFloat1, paramFloat2));
    h.c(i, i, this.b);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.common.ui.a.d
 * JD-Core Version:    0.6.2
 */