package com.adsnative.c;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.util.DisplayMetrics;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.atomic.AtomicLong;

public class o
{
  private static final AtomicLong a = new AtomicLong(1L);

  public static float a(float paramFloat, Context paramContext)
  {
    return 0.5F + paramFloat * (paramContext.getResources().getDisplayMetrics().densityDpi / 160.0F);
  }

  public static int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int i = paramOptions.outHeight;
    int j = paramOptions.outWidth;
    int k = 1;
    if ((i > paramInt2) || (j > paramInt1))
    {
      int m = i / 2;
      int n = j / 2;
      while ((m / k > paramInt2) && (n / k > paramInt1))
        k *= 2;
    }
    return k;
  }

  public static Bitmap a(String paramString)
    throws IOException
  {
    HttpURLConnection localHttpURLConnection1 = (HttpURLConnection)new URL(paramString).openConnection();
    localHttpURLConnection1.connect();
    InputStream localInputStream1 = localHttpURLConnection1.getInputStream();
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeStream(localInputStream1, null, localOptions);
    localInputStream1.close();
    HttpURLConnection localHttpURLConnection2 = (HttpURLConnection)new URL(paramString).openConnection();
    localHttpURLConnection2.connect();
    InputStream localInputStream2 = localHttpURLConnection2.getInputStream();
    localOptions.inSampleSize = a(localOptions, c.a(), c.b() / 2);
    localOptions.inJustDecodeBounds = false;
    return BitmapFactory.decodeStream(localInputStream2, null, localOptions);
  }

  public static Double a(Double paramDouble1, Double paramDouble2)
  {
    Double localDouble = Double.valueOf(0.0D);
    for (int i = 1; (localDouble.doubleValue() < paramDouble1.doubleValue()) && (Math.abs(paramDouble1.doubleValue() - localDouble.doubleValue()) > Math.abs(paramDouble1.doubleValue() - i * paramDouble2.doubleValue())); i++)
      localDouble = Double.valueOf(new BigDecimal(Double.valueOf(i * paramDouble2.doubleValue()).toString()).setScale(2, RoundingMode.HALF_UP).doubleValue());
    return localDouble;
  }

  public static boolean a(int paramInt1, int paramInt2)
  {
    return (paramInt1 & paramInt2) != 0;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.adsnative.c.o
 * JD-Core Version:    0.6.2
 */