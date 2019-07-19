package com.google.android.gms.common.internal;

import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public final class Asserts
{
  private Asserts()
  {
    throw new AssertionError("Uninstantiable");
  }

  @KeepForSdk
  public static void checkMainThread(String paramString)
  {
    if (Looper.getMainLooper().getThread() != Thread.currentThread())
    {
      String str1 = String.valueOf(Thread.currentThread());
      String str2 = String.valueOf(Looper.getMainLooper().getThread());
      Log.e("Asserts", 57 + String.valueOf(str1).length() + String.valueOf(str2).length() + "checkMainThread: current thread " + str1 + " IS NOT the main thread " + str2 + "!");
      throw new IllegalStateException(paramString);
    }
  }

  @KeepForSdk
  public static void checkNotMainThread(String paramString)
  {
    if (Looper.getMainLooper().getThread() == Thread.currentThread())
    {
      String str1 = String.valueOf(Thread.currentThread());
      String str2 = String.valueOf(Looper.getMainLooper().getThread());
      Log.e("Asserts", 56 + String.valueOf(str1).length() + String.valueOf(str2).length() + "checkNotMainThread: current thread " + str1 + " IS the main thread " + str2 + "!");
      throw new IllegalStateException(paramString);
    }
  }

  @KeepForSdk
  public static void checkNotNull(Object paramObject)
  {
    if (paramObject == null)
      throw new IllegalArgumentException("null reference");
  }

  @KeepForSdk
  public static void checkNotNull(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == null)
      throw new IllegalArgumentException(String.valueOf(paramObject2));
  }

  @KeepForSdk
  public static void checkNull(Object paramObject)
  {
    if (paramObject != null)
      throw new IllegalArgumentException("non-null reference");
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
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.Asserts
 * JD-Core Version:    0.6.2
 */