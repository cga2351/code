package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.measurement.AppMeasurement;

public final class zzas extends zzcs
{
  private long zzade = -1L;
  private char zzalu = '\000';
  private String zzalv;
  private final zzau zzalw = new zzau(this, 6, false, false);
  private final zzau zzalx = new zzau(this, 6, true, false);
  private final zzau zzaly = new zzau(this, 6, false, true);
  private final zzau zzalz = new zzau(this, 5, false, false);
  private final zzau zzama = new zzau(this, 5, true, false);
  private final zzau zzamb = new zzau(this, 5, false, true);
  private final zzau zzamc = new zzau(this, 4, false, false);
  private final zzau zzamd = new zzau(this, 3, false, false);
  private final zzau zzame = new zzau(this, 2, false, false);

  zzas(zzbw paramzzbw)
  {
    super(paramzzbw);
  }

  @VisibleForTesting
  private static String zza(boolean paramBoolean, Object paramObject)
  {
    if (paramObject == null)
      return "";
    if ((paramObject instanceof Integer));
    for (Object localObject = Long.valueOf(((Integer)paramObject).intValue()); ; localObject = paramObject)
    {
      if ((localObject instanceof Long))
      {
        if (!paramBoolean)
          return String.valueOf(localObject);
        if (Math.abs(((Long)localObject).longValue()) < 100L)
          return String.valueOf(localObject);
        if (String.valueOf(localObject).charAt(0) == '-');
        for (String str6 = "-"; ; str6 = "")
        {
          String str7 = String.valueOf(Math.abs(((Long)localObject).longValue()));
          long l1 = Math.round(Math.pow(10.0D, -1 + str7.length()));
          long l2 = Math.round(Math.pow(10.0D, str7.length()) - 1.0D);
          return 43 + String.valueOf(str6).length() + String.valueOf(str6).length() + str6 + l1 + "..." + str6 + l2;
        }
      }
      if ((localObject instanceof Boolean))
        return String.valueOf(localObject);
      if ((localObject instanceof Throwable))
      {
        Throwable localThrowable = (Throwable)localObject;
        String str1;
        StringBuilder localStringBuilder;
        String str2;
        String str3;
        StackTraceElement[] arrayOfStackTraceElement;
        int i;
        if (paramBoolean)
        {
          str1 = localThrowable.getClass().getName();
          localStringBuilder = new StringBuilder(str1);
          str2 = zzbx(AppMeasurement.class.getCanonicalName());
          str3 = zzbx(zzbw.class.getCanonicalName());
          arrayOfStackTraceElement = localThrowable.getStackTrace();
          i = arrayOfStackTraceElement.length;
        }
        for (int j = 0; ; j++)
          if (j < i)
          {
            StackTraceElement localStackTraceElement = arrayOfStackTraceElement[j];
            if (!localStackTraceElement.isNativeMethod())
            {
              String str4 = localStackTraceElement.getClassName();
              if (str4 != null)
              {
                String str5 = zzbx(str4);
                if ((str5.equals(str2)) || (str5.equals(str3)))
                {
                  localStringBuilder.append(": ");
                  localStringBuilder.append(localStackTraceElement);
                }
              }
            }
          }
          else
          {
            return localStringBuilder.toString();
            str1 = localThrowable.toString();
            break;
          }
      }
      if ((localObject instanceof zzav))
        return zzav.zza((zzav)localObject);
      if (paramBoolean)
        return "-";
      return String.valueOf(localObject);
    }
  }

  static String zza(boolean paramBoolean, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    if (paramString == null)
      paramString = "";
    String str1 = zza(paramBoolean, paramObject1);
    String str2 = zza(paramBoolean, paramObject2);
    String str3 = zza(paramBoolean, paramObject3);
    StringBuilder localStringBuilder = new StringBuilder();
    String str4 = "";
    if (!TextUtils.isEmpty(paramString))
    {
      localStringBuilder.append(paramString);
      str4 = ": ";
    }
    if (!TextUtils.isEmpty(str1))
    {
      localStringBuilder.append(str4);
      localStringBuilder.append(str1);
      str4 = ", ";
    }
    if (!TextUtils.isEmpty(str2))
    {
      localStringBuilder.append(str4);
      localStringBuilder.append(str2);
      str4 = ", ";
    }
    if (!TextUtils.isEmpty(str3))
    {
      localStringBuilder.append(str4);
      localStringBuilder.append(str3);
    }
    return localStringBuilder.toString();
  }

  protected static Object zzbw(String paramString)
  {
    if (paramString == null)
      return null;
    return new zzav(paramString);
  }

  private static String zzbx(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      paramString = "";
    int i;
    do
    {
      return paramString;
      i = paramString.lastIndexOf('.');
    }
    while (i == -1);
    return paramString.substring(0, i);
  }

  @VisibleForTesting
  private final String zzjp()
  {
    try
    {
      if (this.zzalv == null)
        if (this.zzada.zzkq() == null)
          break label39;
      label39: for (this.zzalv = this.zzada.zzkq(); ; this.zzalv = zzq.zzhy())
      {
        String str = this.zzalv;
        return str;
      }
    }
    finally
    {
    }
  }

  @VisibleForTesting
  protected final boolean isLoggable(int paramInt)
  {
    return Log.isLoggable(zzjp(), paramInt);
  }

  @VisibleForTesting
  protected final void zza(int paramInt, String paramString)
  {
    Log.println(paramInt, zzjp(), paramString);
  }

  protected final void zza(int paramInt, boolean paramBoolean1, boolean paramBoolean2, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    if ((!paramBoolean1) && (isLoggable(paramInt)))
      zza(paramInt, zza(false, paramString, paramObject1, paramObject2, paramObject3));
    zzbr localzzbr;
    if ((!paramBoolean2) && (paramInt >= 5))
    {
      Preconditions.checkNotNull(paramString);
      localzzbr = this.zzada.zzkl();
      if (localzzbr == null)
        zza(6, "Scheduler not set. Not logging error/warn");
    }
    else
    {
      return;
    }
    if (!localzzbr.isInitialized())
    {
      zza(6, "Scheduler not initialized. Not logging error/warn");
      return;
    }
    int i = 0;
    if (paramInt < 0);
    while (true)
    {
      if (i >= 9)
        i = 8;
      localzzbr.zzc(new zzat(this, i, paramString, paramObject1, paramObject2, paramObject3));
      return;
      i = paramInt;
    }
  }

  protected final boolean zzgy()
  {
    return false;
  }

  public final zzau zzjg()
  {
    return this.zzalw;
  }

  public final zzau zzjh()
  {
    return this.zzalx;
  }

  public final zzau zzji()
  {
    return this.zzaly;
  }

  public final zzau zzjj()
  {
    return this.zzalz;
  }

  public final zzau zzjk()
  {
    return this.zzama;
  }

  public final zzau zzjl()
  {
    return this.zzamb;
  }

  public final zzau zzjm()
  {
    return this.zzamc;
  }

  public final zzau zzjn()
  {
    return this.zzamd;
  }

  public final zzau zzjo()
  {
    return this.zzame;
  }

  public final String zzjq()
  {
    Pair localPair = zzgu().zzanb.zzfm();
    if ((localPair == null) || (localPair == zzbd.zzana))
      return null;
    String str1 = String.valueOf(localPair.second);
    String str2 = (String)localPair.first;
    return 1 + String.valueOf(str1).length() + String.valueOf(str2).length() + str1 + ":" + str2;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.measurement.internal.zzas
 * JD-Core Version:    0.6.2
 */