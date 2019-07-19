package com.android.camera;

import android.graphics.Bitmap;
import android.graphics.Matrix;

public class d
{
  private Bitmap a;
  private int b;

  public d(Bitmap paramBitmap)
  {
    this.a = paramBitmap;
    this.b = 0;
  }

  public int a()
  {
    return this.b;
  }

  public void a(int paramInt)
  {
    this.b = paramInt;
  }

  public void a(Bitmap paramBitmap)
  {
    this.a = paramBitmap;
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
      int i = this.a.getWidth() / 2;
      int j = this.a.getHeight() / 2;
      localMatrix.preTranslate(-i, -j);
      localMatrix.postRotate(this.b);
      localMatrix.postTranslate(f() / 2, e() / 2);
    }
    return localMatrix;
  }

  public boolean d()
  {
    return this.b / 90 % 2 != 0;
  }

  public int e()
  {
    if (d())
      return this.a.getWidth();
    return this.a.getHeight();
  }

  public int f()
  {
    if (d())
      return this.a.getHeight();
    return this.a.getWidth();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.android.camera.d
 * JD-Core Version:    0.6.2
 */