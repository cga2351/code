package com.viber.voip.ui.call;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RadialGradient;
import android.graphics.Shader.TileMode;
import com.viber.voip.ui.call.a.b;
import com.viber.voip.ui.call.a.e;

public class c
  implements com.viber.voip.ui.call.a.c, e
{
  private int a = WavesView.a - 805306368;
  private float b = 0.93F;
  private final int[] c;
  private final float[] d;
  private float e;
  private float f;
  private float g;
  private b h;
  private b i;
  private Paint j;
  private Paint k;

  public c(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, boolean paramBoolean)
  {
    int[] arrayOfInt = new int[3];
    arrayOfInt[0] = 16777215;
    arrayOfInt[1] = this.a;
    arrayOfInt[2] = 16777215;
    this.c = arrayOfInt;
    float[] arrayOfFloat1 = new float[3];
    arrayOfFloat1[0] = (this.b - 0.14F);
    arrayOfFloat1[1] = this.b;
    arrayOfFloat1[2] = f1;
    this.d = arrayOfFloat1;
    this.e = paramFloat1;
    this.f = paramFloat2;
    if (paramFloat5 + 0.51F > f1);
    while (true)
    {
      float[] arrayOfFloat2 = { 0.0F, 1.0F };
      float[] arrayOfFloat3 = { paramFloat3, paramFloat4 };
      this.g = paramFloat3;
      this.h = new b(paramFloat5, f1, arrayOfFloat2, arrayOfFloat3);
      float[] arrayOfFloat4 = { 0.0F, 1.0F };
      float[] arrayOfFloat5 = { 100.0F, 0.0F };
      this.i = new b(0.096F + paramFloat5, f1, arrayOfFloat4, arrayOfFloat5);
      if (paramBoolean)
      {
        this.h.c = paramFloat3;
        this.i.c = 100.0F;
      }
      this.j = new Paint();
      this.j.setFlags(7);
      this.k = new Paint(this.j);
      this.k.setColor(this.a);
      this.k.setStrokeWidth(2.0F);
      this.k.setStyle(Paint.Style.STROKE);
      return;
      f1 = paramFloat5 + 0.51F;
    }
  }

  public void a(float paramFloat)
  {
    this.h.a(paramFloat);
    this.i.a(paramFloat);
  }

  public void a(Canvas paramCanvas)
  {
    this.j.setAlpha((int)this.i.c);
    this.j.setShader(new RadialGradient(this.e, this.f, this.h.c, this.c, this.d, Shader.TileMode.CLAMP));
    paramCanvas.drawCircle(this.e, this.f, this.h.c, this.j);
  }

  public boolean a()
  {
    return this.h.c > this.g;
  }

  public boolean b()
  {
    return a();
  }

  public void c()
  {
    this.h.c();
    this.i.c();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.call.c
 * JD-Core Version:    0.6.2
 */