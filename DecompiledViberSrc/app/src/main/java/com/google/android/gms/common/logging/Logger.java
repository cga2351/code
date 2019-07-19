package com.google.android.gms.common.logging;

import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.GmsLogger;
import java.util.Locale;

@KeepForSdk
public class Logger
{
  private final String mTag;
  private final String zzei;
  private final GmsLogger zzew;
  private final int zzex;

  private Logger(String paramString1, String paramString2)
  {
    this.zzei = paramString2;
    this.mTag = paramString1;
    this.zzew = new GmsLogger(paramString1);
    for (int i = 2; (7 >= i) && (!Log.isLoggable(this.mTag, i)); i++);
    this.zzex = i;
  }

  @KeepForSdk
  public Logger(String paramString, String[] paramArrayOfString)
  {
  }

  private final String format(String paramString, Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length > 0))
      paramString = String.format(Locale.US, paramString, paramArrayOfObject);
    return this.zzei.concat(paramString);
  }

  @KeepForSdk
  public void d(String paramString, Object[] paramArrayOfObject)
  {
    if (isLoggable(3))
      Log.d(this.mTag, format(paramString, paramArrayOfObject));
  }

  @KeepForSdk
  public void e(String paramString, Throwable paramThrowable, Object[] paramArrayOfObject)
  {
    Log.e(this.mTag, format(paramString, paramArrayOfObject), paramThrowable);
  }

  @KeepForSdk
  public void e(String paramString, Object[] paramArrayOfObject)
  {
    Log.e(this.mTag, format(paramString, paramArrayOfObject));
  }

  @KeepForSdk
  public void i(String paramString, Object[] paramArrayOfObject)
  {
    Log.i(this.mTag, format(paramString, paramArrayOfObject));
  }

  @KeepForSdk
  public boolean isLoggable(int paramInt)
  {
    return this.zzex <= paramInt;
  }

  @KeepForSdk
  public void v(String paramString, Object[] paramArrayOfObject)
  {
    if (isLoggable(2))
      Log.v(this.mTag, format(paramString, paramArrayOfObject));
  }

  @KeepForSdk
  public void w(String paramString, Object[] paramArrayOfObject)
  {
    Log.w(this.mTag, format(paramString, paramArrayOfObject));
  }

  @KeepForSdk
  public void wtf(String paramString, Throwable paramThrowable, Object[] paramArrayOfObject)
  {
    Log.wtf(this.mTag, format(paramString, paramArrayOfObject), paramThrowable);
  }

  @KeepForSdk
  public void wtf(Throwable paramThrowable)
  {
    Log.wtf(this.mTag, paramThrowable);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.logging.Logger
 * JD-Core Version:    0.6.2
 */