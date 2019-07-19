package com.viber.common.ui.a;

import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.drawable.shapes.Shape;
import com.viber.common.d.a;

public class b extends Shape
{
  private int a = 1;
  private int b;
  private int c;
  private int d;
  private RectF e = new RectF();
  private RectF f = new RectF();
  private float g;
  private float h;

  public b a()
    throws CloneNotSupportedException
  {
    b localb = (b)super.clone();
    localb.e = new RectF(this.e);
    localb.g = this.g;
    localb.a = this.a;
    localb.b = this.b;
    localb.f = new RectF(this.f);
    localb.h = this.h;
    localb.c = this.c;
    localb.d = this.d;
    return localb;
  }

  public void a(int paramInt)
  {
    this.a = paramInt;
  }

  public void b(int paramInt)
  {
    this.b = paramInt;
  }

  public void c(int paramInt)
  {
    this.c = paramInt;
  }

  public void d(int paramInt)
  {
    this.d = paramInt;
  }

  public void draw(Canvas paramCanvas, Paint paramPaint)
  {
    if ((this.a == 1) || (this.a == 3))
    {
      paramPaint.setStyle(Paint.Style.FILL);
      paramPaint.setColor(this.b);
      paramCanvas.drawRoundRect(this.e, this.g, this.g, paramPaint);
    }
    if ((this.a == 2) || (this.a == 3))
    {
      paramPaint.setStyle(Paint.Style.STROKE);
      paramPaint.setStrokeWidth(this.d);
      paramPaint.setColor(this.c);
      paramCanvas.drawRoundRect(this.f, this.h, this.h, paramPaint);
    }
  }

  public void getOutline(Outline paramOutline)
  {
    if (a.g())
    {
      RectF localRectF = this.e;
      paramOutline.setRoundRect((int)Math.ceil(localRectF.left), (int)Math.ceil(localRectF.top), (int)Math.floor(localRectF.right), (int)Math.floor(localRectF.bottom), this.g);
    }
  }

  protected void onResize(float paramFloat1, float paramFloat2)
  {
    this.e.set(0.0F, 0.0F, paramFloat1, paramFloat2);
    this.g = (paramFloat2 / 2.0F);
    float f1 = this.d / 2.0F;
    this.f.set(f1, f1, paramFloat1 - f1, paramFloat2 - f1);
    this.h = (this.g - this.d);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.common.ui.a.b
 * JD-Core Version:    0.6.2
 */