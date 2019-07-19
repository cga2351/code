package com.google.android.gms.internal.ads;

import android.os.Build.VERSION;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Pattern;

public final class zzkq
{
  public static final int SDK_INT = Build.VERSION.SDK_INT;
  private static final Pattern zzaqx = Pattern.compile("(\\d\\d\\d\\d)\\-(\\d\\d)\\-(\\d\\d)[Tt](\\d\\d):(\\d\\d):(\\d\\d)(\\.(\\d+))?([Zz]|((\\+|\\-)(\\d\\d):(\\d\\d)))?");
  private static final Pattern zzaqy = Pattern.compile("^(-)?P(([0-9]*)Y)?(([0-9]*)M)?(([0-9]*)D)?(T(([0-9]*)H)?(([0-9]*)M)?(([0-9.]*)S)?)?$");

  public static int zza(long[] paramArrayOfLong, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = Arrays.binarySearch(paramArrayOfLong, paramLong);
    if (i < 0)
      i = -(i + 2);
    if (paramBoolean2)
      i = Math.max(0, i);
    return i;
  }

  public static long zza(long paramLong1, long paramLong2, long paramLong3)
  {
    if ((paramLong3 >= 1000000L) && (paramLong3 % 1000000L == 0L))
      return paramLong1 / (paramLong3 / 1000000L);
    if ((paramLong3 < 1000000L) && (1000000L % paramLong3 == 0L))
      return paramLong1 * (1000000L / paramLong3);
    return ()(1000000.0D / paramLong3 * paramLong1);
  }

  public static void zza(long[] paramArrayOfLong, long paramLong1, long paramLong2)
  {
    int i = 0;
    long l2;
    if ((paramLong2 >= 1000000L) && (paramLong2 % 1000000L == 0L))
      l2 = paramLong2 / 1000000L;
    while (i < paramArrayOfLong.length)
    {
      paramArrayOfLong[i] /= l2;
      i++;
      continue;
      long l1;
      if ((paramLong2 < 1000000L) && (1000000L % paramLong2 == 0L))
        l1 = 1000000L / paramLong2;
      while (i < paramArrayOfLong.length)
      {
        paramArrayOfLong[i] = (l1 * paramArrayOfLong[i]);
        i++;
        continue;
        double d = 1000000.0D / paramLong2;
        while (i < paramArrayOfLong.length)
        {
          paramArrayOfLong[i] = (()(d * paramArrayOfLong[i]));
          i++;
        }
      }
    }
  }

  public static boolean zza(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == null)
      return paramObject2 == null;
    return paramObject1.equals(paramObject2);
  }

  public static ExecutorService zzax(String paramString)
  {
    return Executors.newSingleThreadExecutor(new zzkr(paramString));
  }

  public static int zzay(String paramString)
  {
    int i = 0;
    int j = paramString.length();
    if (j <= 4);
    int k;
    for (boolean bool = true; ; bool = false)
    {
      zzkh.checkArgument(bool);
      k = 0;
      while (i < j)
      {
        k = k << 8 | paramString.charAt(i);
        i++;
      }
    }
    return k;
  }

  public static int zzb(int paramInt1, int paramInt2)
  {
    return (-1 + (paramInt2 + 0)) / paramInt2;
  }

  public static int zzb(long[] paramArrayOfLong, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = Arrays.binarySearch(paramArrayOfLong, paramLong);
    if (i < 0)
      i ^= -1;
    return i;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzkq
 * JD-Core Version:    0.6.2
 */