package com.mopub.common.util;

import android.graphics.Bitmap;

public class ImageUtils
{
  public static Bitmap applyFastGaussianBlurToBitmap(Bitmap paramBitmap, int paramInt)
  {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    int[] arrayOfInt = new int[i * j];
    paramBitmap.getPixels(arrayOfInt, 0, i, 0, 0, i, j);
    int k = paramInt;
    while (k >= 1)
    {
      for (int m = k; m < j - k; m++)
        for (int n = k; n < i - k; n++)
        {
          int i1 = arrayOfInt[(n + i * (m - k) - k)];
          int i2 = arrayOfInt[(k + (n + i * (m - k)))];
          int i3 = arrayOfInt[(n + i * (m - k))];
          int i4 = arrayOfInt[(n + i * (m + k) - k)];
          int i5 = arrayOfInt[(k + (n + i * (m + k)))];
          int i6 = arrayOfInt[(n + i * (m + k))];
          int i7 = arrayOfInt[(n + m * i - k)];
          int i8 = arrayOfInt[(k + (n + m * i))];
          arrayOfInt[(n + m * i)] = (0xFF000000 | 0xFF & (i1 & 0xFF) + (i2 & 0xFF) + (i3 & 0xFF) + (i4 & 0xFF) + (i5 & 0xFF) + (i6 & 0xFF) + (i7 & 0xFF) + (i8 & 0xFF) >> 3 | 0xFF00 & (0xFF00 & i1) + (0xFF00 & i2) + (0xFF00 & i3) + (0xFF00 & i4) + (0xFF00 & i5) + (0xFF00 & i6) + (0xFF00 & i7) + (0xFF00 & i8) >> 3 | 0xFF0000 & (i1 & 0xFF0000) + (i2 & 0xFF0000) + (0xFF0000 & i3) + (0xFF0000 & i4) + (0xFF0000 & i5) + (0xFF0000 & i6) + (0xFF0000 & i7) + (0xFF0000 & i8) >> 3);
        }
      k /= 2;
    }
    paramBitmap.setPixels(arrayOfInt, 0, i, 0, 0, i, j);
    return paramBitmap;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.common.util.ImageUtils
 * JD-Core Version:    0.6.2
 */