package com.yandex.mobile.ads.impl;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.widget.ImageView.ScaleType;

public final class pd extends oi<Bitmap>
{
  private static final Object f = new Object();
  private final ok.b<Bitmap> a;
  private final Bitmap.Config b;
  private final int c;
  private final int d;
  private ImageView.ScaleType e;

  public pd(String paramString, ok.b<Bitmap> paramb, int paramInt1, int paramInt2, ImageView.ScaleType paramScaleType, Bitmap.Config paramConfig, ok.a parama)
  {
    super(0, paramString, parama);
    a(new od(1000, 2, 2.0F));
    this.a = paramb;
    this.b = paramConfig;
    this.c = paramInt1;
    this.d = paramInt2;
    this.e = paramScaleType;
  }

  private static int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    double d1 = Math.min(paramInt1 / paramInt3, paramInt2 / paramInt4);
    for (float f1 = 1.0F; f1 * 2.0F <= d1; f1 *= 2.0F);
    return (int)f1;
  }

  private static int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, ImageView.ScaleType paramScaleType)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0))
      paramInt1 = paramInt3;
    double d1;
    do
    {
      do
      {
        do
        {
          do
          {
            return paramInt1;
            if (paramScaleType != ImageView.ScaleType.FIT_XY)
              break;
          }
          while (paramInt1 != 0);
          return paramInt3;
          if (paramInt1 == 0)
            return (int)(paramInt2 / paramInt4 * paramInt3);
        }
        while (paramInt2 == 0);
        d1 = paramInt4 / paramInt3;
        if (paramScaleType != ImageView.ScaleType.CENTER_CROP)
          break;
      }
      while (d1 * paramInt1 >= paramInt2);
      return (int)(paramInt2 / d1);
    }
    while (d1 * paramInt1 <= paramInt2);
    return (int)(paramInt2 / d1);
  }

  protected final ok<Bitmap> a(oh paramoh)
  {
    while (true)
    {
      Bitmap localBitmap;
      synchronized (f)
      {
        try
        {
          byte[] arrayOfByte = paramoh.b;
          BitmapFactory.Options localOptions = new BitmapFactory.Options();
          if ((this.c == 0) && (this.d == 0))
          {
            localOptions.inPreferredConfig = this.b;
            localObject3 = BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length, localOptions);
            if (localObject3 != null)
              break label304;
            ok localok2 = ok.a(new os(paramoh));
            localObject4 = localok2;
            return localObject4;
          }
          localOptions.inJustDecodeBounds = true;
          BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length, localOptions);
          int i = localOptions.outWidth;
          int j = localOptions.outHeight;
          int k = a(this.c, this.d, i, j, this.e);
          int m = a(this.d, this.c, j, i, this.e);
          localOptions.inJustDecodeBounds = false;
          localOptions.inSampleSize = a(i, j, k, m);
          localBitmap = BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length, localOptions);
          if ((localBitmap != null) && ((localBitmap.getWidth() > k) || (localBitmap.getHeight() > m)))
          {
            localObject3 = Bitmap.createScaledBitmap(localBitmap, k, m, true);
            localBitmap.recycle();
            continue;
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          Object[] arrayOfObject = new Object[2];
          arrayOfObject[0] = Integer.valueOf(paramoh.b.length);
          arrayOfObject[1] = b();
          on.c("Caught OOM for %d byte image, url=%s", arrayOfObject);
          ok localok1 = ok.a(new os(localOutOfMemoryError));
          return localok1;
        }
      }
      Object localObject3 = localBitmap;
      continue;
      label304: ok localok3 = ok.a(localObject3, oz.a(paramoh));
      Object localObject4 = localok3;
    }
  }

  public final oi.a o()
  {
    return oi.a.a;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.pd
 * JD-Core Version:    0.6.2
 */