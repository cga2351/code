package com.google.android.gms.common.internal;

import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public final class GmsLogger
{
  private static final int zzef = 15;
  private static final String zzeg = null;
  private final String zzeh;
  private final String zzei;

  public GmsLogger(String paramString)
  {
    this(paramString, null);
  }

  public GmsLogger(String paramString1, String paramString2)
  {
    Preconditions.checkNotNull(paramString1, "log tag cannot be null");
    if (paramString1.length() <= 23);
    for (boolean bool = true; ; bool = false)
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = paramString1;
      arrayOfObject[1] = Integer.valueOf(23);
      Preconditions.checkArgument(bool, "tag \"%s\" is longer than the %d character maximum", arrayOfObject);
      this.zzeh = paramString1;
      if ((paramString2 != null) && (paramString2.length() > 0))
        break;
      this.zzei = null;
      return;
    }
    this.zzei = paramString2;
  }

  private final String zza(String paramString, Object[] paramArrayOfObject)
  {
    String str = String.format(paramString, paramArrayOfObject);
    if (this.zzei == null)
      return str;
    return this.zzei.concat(str);
  }

  private final String zzh(String paramString)
  {
    if (this.zzei == null)
      return paramString;
    return this.zzei.concat(paramString);
  }

  @KeepForSdk
  public final boolean canLog(int paramInt)
  {
    return Log.isLoggable(this.zzeh, paramInt);
  }

  @KeepForSdk
  public final boolean canLogPii()
  {
    return false;
  }

  @KeepForSdk
  public final void d(String paramString1, String paramString2)
  {
    if (canLog(3))
      Log.d(paramString1, zzh(paramString2));
  }

  @KeepForSdk
  public final void d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (canLog(3))
      Log.d(paramString1, zzh(paramString2), paramThrowable);
  }

  @KeepForSdk
  public final void e(String paramString1, String paramString2)
  {
    if (canLog(6))
      Log.e(paramString1, zzh(paramString2));
  }

  @KeepForSdk
  public final void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (canLog(6))
      Log.e(paramString1, zzh(paramString2), paramThrowable);
  }

  @KeepForSdk
  public final void efmt(String paramString1, String paramString2, Object[] paramArrayOfObject)
  {
    if (canLog(6))
      Log.e(paramString1, zza(paramString2, paramArrayOfObject));
  }

  @KeepForSdk
  public final void i(String paramString1, String paramString2)
  {
    if (canLog(4))
      Log.i(paramString1, zzh(paramString2));
  }

  @KeepForSdk
  public final void i(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (canLog(4))
      Log.i(paramString1, zzh(paramString2), paramThrowable);
  }

  @KeepForSdk
  public final void pii(String paramString1, String paramString2)
  {
    String str1;
    String str2;
    if (canLogPii())
    {
      str1 = String.valueOf(paramString1);
      str2 = String.valueOf(" PII_LOG");
      if (str2.length() == 0)
        break label47;
    }
    label47: for (String str3 = str1.concat(str2); ; str3 = new String(str1))
    {
      Log.i(str3, zzh(paramString2));
      return;
    }
  }

  @KeepForSdk
  public final void pii(String paramString1, String paramString2, Throwable paramThrowable)
  {
    String str1;
    String str2;
    if (canLogPii())
    {
      str1 = String.valueOf(paramString1);
      str2 = String.valueOf(" PII_LOG");
      if (str2.length() == 0)
        break label50;
    }
    label50: for (String str3 = str1.concat(str2); ; str3 = new String(str1))
    {
      Log.i(str3, zzh(paramString2), paramThrowable);
      return;
    }
  }

  @KeepForSdk
  public final void v(String paramString1, String paramString2)
  {
    if (canLog(2))
      Log.v(paramString1, zzh(paramString2));
  }

  @KeepForSdk
  public final void v(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (canLog(2))
      Log.v(paramString1, zzh(paramString2), paramThrowable);
  }

  @KeepForSdk
  public final void w(String paramString1, String paramString2)
  {
    if (canLog(5))
      Log.w(paramString1, zzh(paramString2));
  }

  @KeepForSdk
  public final void w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (canLog(5))
      Log.w(paramString1, zzh(paramString2), paramThrowable);
  }

  @KeepForSdk
  public final void wfmt(String paramString1, String paramString2, Object[] paramArrayOfObject)
  {
    if (canLog(5))
      Log.w(this.zzeh, zza(paramString2, paramArrayOfObject));
  }

  @KeepForSdk
  public final void wtf(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (canLog(7))
    {
      Log.e(paramString1, zzh(paramString2), paramThrowable);
      Log.wtf(paramString1, zzh(paramString2), paramThrowable);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.GmsLogger
 * JD-Core Version:    0.6.2
 */