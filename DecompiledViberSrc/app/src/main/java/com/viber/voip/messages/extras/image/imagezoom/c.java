package com.viber.voip.messages.extras.image.imagezoom;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;

public class c
{
  private Bitmap a;
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;

  public c(Bitmap paramBitmap, int paramInt)
  {
    this.b = (paramInt % 360);
    a(paramBitmap);
  }

  private void f()
  {
    Matrix localMatrix = new Matrix();
    int i = this.e / 2;
    int j = this.f / 2;
    localMatrix.preTranslate(-i, -j);
    localMatrix.postRotate(this.b);
    localMatrix.postTranslate(i, i);
    RectF localRectF = new RectF(0.0F, 0.0F, this.e, this.f);
    localMatrix.mapRect(localRectF);
    this.c = ((int)localRectF.width());
    this.d = ((int)localRectF.height());
  }

  public int a()
  {
    return this.b % 360;
  }

  public void a(int paramInt)
  {
    this.b = paramInt;
    f();
  }

  public void a(Bitmap paramBitmap)
  {
    this.a = paramBitmap;
    if (this.a != null)
    {
      this.e = paramBitmap.getWidth();
      this.f = paramBitmap.getHeight();
      f();
    }
  }

  public Bitmap b()
  {
    return this.a;
  }

  public Matrix c()
  {
    Matrix localMatrix = new Matrix();
    if (this.b != 0)
    {
      int i = this.e / 2;
      int j = this.f / 2;
      localMatrix.preTranslate(-i, -j);
      localMatrix.postRotate(this.b);
      localMatrix.postTranslate(this.c / 2, this.d / 2);
    }
    return localMatrix;
  }

  public int d()
  {
    return this.d;
  }

  public int e()
  {
    return this.c;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.extras.image.imagezoom.c
 * JD-Core Version:    0.6.2
 */