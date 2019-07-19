package com.google.android.gms.common.internal;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.zzc;

@KeepForSdk
public final class Preconditions
{
  private Preconditions()
  {
    throw new AssertionError("Uninstantiable");
  }

  @KeepForSdk
  public static void checkArgument(boolean paramBoolean)
  {
    if (!paramBoolean)
      throw new IllegalArgumentException();
  }

  @KeepForSdk
  public static void checkArgument(boolean paramBoolean, Object paramObject)
  {
    if (!paramBoolean)
      throw new IllegalArgumentException(String.valueOf(paramObject));
  }

  @KeepForSdk
  public static void checkArgument(boolean paramBoolean, String paramString, Object[] paramArrayOfObject)
  {
    if (!paramBoolean)
      throw new IllegalArgumentException(String.format(paramString, paramArrayOfObject));
  }

  @KeepForSdk
  public static void checkHandlerThread(Handler paramHandler)
  {
    if (Looper.myLooper() != paramHandler.getLooper())
      throw new IllegalStateException("Must be called on the handler thread");
  }

  @KeepForSdk
  public static void checkMainThread(String paramString)
  {
    if (!zzc.isMainThread())
      throw new IllegalStateException(paramString);
  }

  @KeepForSdk
  public static String checkNotEmpty(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      throw new IllegalArgumentException("Given String is empty or null");
    return paramString;
  }

  @KeepForSdk
  public static String checkNotEmpty(String paramString, Object paramObject)
  {
    if (TextUtils.isEmpty(paramString))
      throw new IllegalArgumentException(String.valueOf(paramObject));
    return paramString;
  }

  @KeepForSdk
  public static void checkNotMainThread()
  {
    checkNotMainThread("Must not be called on the main application thread");
  }

  @KeepForSdk
  public static void checkNotMainThread(String paramString)
  {
    if (zzc.isMainThread())
      throw new IllegalStateException(paramString);
  }

  @KeepForSdk
  public static <T> T checkNotNull(T paramT)
  {
    if (paramT == null)
      throw new NullPointerException("null reference");
    return paramT;
  }

  @KeepForSdk
  public static <T> T checkNotNull(T paramT, Object paramObject)
  {
    if (paramT == null)
      throw new NullPointerException(String.valueOf(paramObject));
    return paramT;
  }

  @KeepForSdk
  public static int checkNotZero(int paramInt)
  {
    if (paramInt == 0)
      throw new IllegalArgumentException("Given Integer is zero");
    return paramInt;
  }

  @KeepForSdk
  public static int checkNotZero(int paramInt, Object paramObject)
  {
    if (paramInt == 0)
      throw new IllegalArgumentException(String.valueOf(paramObject));
    return paramInt;
  }

  @KeepForSdk
  public static long checkNotZero(long paramLong)
  {
    if (paramLong == 0L)
      throw new IllegalArgumentException("Given Long is zero");
    return paramLong;
  }

  @KeepForSdk
  public static long checkNotZero(long paramLong, Object paramObject)
  {
    if (paramLong == 0L)
      throw new IllegalArgumentException(String.valueOf(paramObject));
    return paramLong;
  }

  @KeepForSdk
  public static void checkState(boolean paramBoolean)
  {
    if (!paramBoolean)
      throw new IllegalStateException();
  }

  @KeepForSdk
  public static void checkState(boolean paramBoolean, Object paramObject)
  {
    if (!paramBoolean)
      throw new IllegalStateException(String.valueOf(paramObject));
  }

  @KeepForSdk
  public static void checkState(boolean paramBoolean, String paramString, Object[] paramArrayOfObject)
  {
    if (!paramBoolean)
      throw new IllegalStateException(String.format(paramString, paramArrayOfObject));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.Preconditions
 * JD-Core Version:    0.6.2
 */