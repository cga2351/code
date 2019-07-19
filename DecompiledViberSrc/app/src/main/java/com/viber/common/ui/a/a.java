package com.viber.common.ui.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.graphics.drawable.shapes.RectShape;

public class a extends RectShape
{
  private float a;
  private int b;
  private int c;
  private float[] d = new float[8];
  private float[] e = new float[8];
  private RectF f;
  private Path g;

  public a(float paramFloat, int paramInt1, int paramInt2)
  {
    this.a = paramFloat;
    this.b = paramInt1;
    this.c = paramInt2;
    b();
    this.f = new RectF();
    this.g = new Path();
  }

  private void b()
  {
    float f1 = 0.0F;
    float f2 = Math.max(this.a - this.c, 0.0F);
    float f3 = this.a;
    float f4 = this.a;
    float f5 = this.a;
    float f6 = this.a;
    float f8;
    float f7;
    if ((0x1 & this.b) == 0)
    {
      f8 = 0.0F;
      f7 = 0.0F;
    }
    while (true)
    {
      float f10;
      float f9;
      if ((0x2 & this.b) == 0)
      {
        f10 = 0.0F;
        f9 = 0.0F;
      }
      while (true)
      {
        float f12;
        float f11;
        if ((0x8 & this.b) == 0)
        {
          f12 = 0.0F;
          f11 = 0.0F;
        }
        while (true)
        {
          if ((0x4 & this.b) == 0);
          for (float f13 = 0.0F; ; f13 = f6)
          {
            this.d[0] = f7;
            this.d[1] = f7;
            this.e[0] = f8;
            this.e[1] = f8;
            this.d[2] = f9;
            this.d[3] = f9;
            this.e[2] = f10;
            this.e[3] = f10;
            this.d[4] = f11;
            this.d[5] = f11;
            this.e[4] = f12;
            this.e[5] = f12;
            this.d[6] = f13;
            this.d[7] = f13;
            this.e[6] = f1;
            this.e[7] = f1;
            return;
            f1 = f2;
          }
          f11 = f5;
          f12 = f2;
        }
        f9 = f4;
        f10 = f2;
      }
      f7 = f3;
      f8 = f2;
    }
  }

  private void c()
  {
    RectF localRectF = rect();
    this.g.reset();
    this.g.addRoundRect(localRectF, this.d, Path.Direction.CW);
    if (this.c > 0)
    {
      this.f.set(localRectF.left + this.c, localRectF.top + this.c, localRectF.right - this.c, localRectF.bottom - this.c);
      this.g.addRoundRect(this.f, this.e, Path.Direction.CCW);
    }
  }

  public a a()
    throws CloneNotSupportedException
  {
    a locala = (a)super.clone();
    if (this.d != null);
    for (float[] arrayOfFloat = (float[])this.d.clone(); ; arrayOfFloat = null)
    {
      locala.d = arrayOfFloat;
      locala.c = this.c;
      locala.f = new RectF(this.f);
      locala.g = new Path(this.g);
      return locala;
    }
  }

  public void draw(Canvas paramCanvas, Paint paramPaint)
  {
    paramCanvas.drawPath(this.g, paramPaint);
  }

  protected void onResize(float paramFloat1, float paramFloat2)
  {
    super.onResize(paramFloat1, paramFloat2);
    c();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.common.ui.a.a
 * JD-Core Version:    0.6.2
 */