package com.viber.common.ui.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.graphics.drawable.shapes.RectShape;

public class c extends RectShape
{
  private final int a;
  private final Path b;
  private float[] c = new float[8];

  public c(int paramInt, float paramFloat)
  {
    this.a = paramInt;
    this.b = new Path();
    for (int i = 0; i < this.c.length; i++)
      this.c[i] = paramFloat;
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
    this.b.reset();
    RectF localRectF = rect();
    this.b.addRoundRect(localRectF, this.c, Path.Direction.CW);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.common.ui.a.c
 * JD-Core Version:    0.6.2
 */