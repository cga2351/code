package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.content.res.Resources;
import android.os.StatFs;
import android.util.DisplayMetrics;
import java.io.File;

public final class db
{
  public static int a(Context paramContext)
  {
    try
    {
      int j = (int)(Runtime.getRuntime().maxMemory() / 1024L);
      DisplayMetrics localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
      int k = localDisplayMetrics.widthPixels;
      int m = localDisplayMetrics.heightPixels;
      int n = (int)(localDisplayMetrics.density * (k * m) / 1024.0F);
      int i1 = Math.min(j / 8, n * 3);
      i = i1;
      return Math.max(i, 5120);
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      while (true)
        int i = 5120;
    }
  }

  public static long a(File paramFile)
  {
    try
    {
      StatFs localStatFs = new StatFs(paramFile.getAbsolutePath());
      l = localStatFs.getBlockCount() * localStatFs.getBlockSize() / 50L;
      return Math.max(Math.min(l, 104857600L), 10485760L);
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      while (true)
        long l = 10485760L;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.db
 * JD-Core Version:    0.6.2
 */