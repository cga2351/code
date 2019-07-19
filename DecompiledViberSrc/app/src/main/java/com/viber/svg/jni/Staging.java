package com.viber.svg.jni;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Rect;

public class Staging
{
  private Bitmap bitmap;
  private int[] pixels;

  public Staging(int paramInt1, int paramInt2)
  {
    this.bitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    this.pixels = new int[paramInt1 * paramInt2];
  }

  public int calculateBounds(Rect paramRect1, Rect paramRect2)
  {
    this.bitmap.getPixels(this.pixels, 0, paramRect1.width(), paramRect1.left, paramRect1.top, paramRect1.width(), paramRect1.height());
    int i = paramRect1.width();
    int j = paramRect1.height();
    int k = 0;
    int m = 0;
    int n = 0;
    int i1 = -2147483648;
    int i2 = 2147483647;
    int i3 = -2147483648;
    int i4 = 2147483647;
    while (k < j)
    {
      int i5 = m;
      int i6 = n;
      int i7 = i1;
      int i8 = i2;
      int i9 = i3;
      int i10 = i4;
      int i11 = 0;
      if (i11 < i)
      {
        int[] arrayOfInt = this.pixels;
        int i12 = i5 + 1;
        if ((0xFF000000 & arrayOfInt[i5]) != 0);
        for (int i13 = 1; ; i13 = 0)
        {
          if (i13 != 0)
          {
            i6++;
            if (i11 < i10)
              i10 = i11;
            if (i11 > i9)
              i9 = i11;
            if (k < i8)
              i8 = k;
            if (k > i7)
              i7 = k;
          }
          i11++;
          i5 = i12;
          break;
        }
      }
      k++;
      i4 = i10;
      i3 = i9;
      i2 = i8;
      i1 = i7;
      n = i6;
      m = i5;
    }
    paramRect2.left = (i4 + paramRect1.left);
    paramRect2.top = (i2 + paramRect1.top);
    paramRect2.right = (i3 + paramRect1.left);
    paramRect2.bottom = (i1 + paramRect1.top);
    return n;
  }

  public Bitmap getBitmap()
  {
    return this.bitmap;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.svg.jni.Staging
 * JD-Core Version:    0.6.2
 */