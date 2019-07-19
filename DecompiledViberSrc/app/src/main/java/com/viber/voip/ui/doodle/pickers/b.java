package com.viber.voip.ui.doodle.pickers;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import com.viber.common.d.h;

public class b extends Drawable
{
  private int a;
  private float b;
  private int c;
  private Path d;
  private Paint e;
  private int f;
  private Path g;
  private Paint h;

  public b(int paramInt1, int paramInt2, int paramInt3)
  {
    a(paramInt1, paramInt2, paramInt3);
    a();
  }

  b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.f = paramInt4;
    this.g = new Path();
    this.h = new Paint();
    this.h.setAntiAlias(true);
    this.h.setStyle(Paint.Style.STROKE);
    this.h.setStrokeWidth(paramInt4);
    this.h.setColor(paramInt5);
    a(paramInt1, paramInt2, paramInt3);
    a();
  }

  private void a()
  {
    if ((this.g != null) && (this.h != null))
    {
      h.a(this.a - 2 * this.f, this.a - 2 * this.f, this.f, this.f, this.d);
      h.a(this.a - this.f, this.a - this.f, this.f / 2.0F, this.f / 2.0F, this.g);
      return;
    }
    h.c(this.a, this.a, this.d);
  }

  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.a = paramInt1;
    this.b = (paramInt2 / this.a);
    this.c = paramInt3;
    this.d = new Path();
    this.e = new Paint();
    this.e.setAntiAlias(true);
    this.e.setColor(paramInt3);
  }

  void a(int paramInt)
  {
    this.b = (paramInt / this.a);
    invalidateSelf();
  }

  void b(int paramInt)
  {
    this.c = paramInt;
    this.e.setColor(this.c);
    invalidateSelf();
  }

  public void draw(Canvas paramCanvas)
  {
    int i = paramCanvas.save();
    paramCanvas.scale(this.b, this.b, this.a / 2.0F, this.a / 2.0F);
    paramCanvas.drawPath(this.d, this.e);
    if ((this.g != null) && (this.h != null))
      paramCanvas.drawPath(this.g, this.h);
    paramCanvas.restoreToCount(i);
  }

  public int getIntrinsicHeight()
  {
    return this.a;
  }

  public int getIntrinsicWidth()
  {
    return this.a;
  }

  public int getOpacity()
  {
    return -2;
  }

  public void setAlpha(int paramInt)
  {
    this.e.setAlpha(paramInt);
  }

  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.e.setColorFilter(paramColorFilter);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.doodle.pickers.b
 * JD-Core Version:    0.6.2
 */