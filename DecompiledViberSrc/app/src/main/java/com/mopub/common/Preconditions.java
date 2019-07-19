package com.mopub.common;

import android.os.Looper;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import java.util.IllegalFormatException;

public final class Preconditions
{
  public static final String EMPTY_ARGUMENTS = "";

  private static String a(String paramString, Object[] paramArrayOfObject)
  {
    String str1 = String.valueOf(paramString);
    try
    {
      String str2 = String.format(str1, paramArrayOfObject);
      return str2;
    }
    catch (IllegalFormatException localIllegalFormatException)
    {
      MoPubLog.SdkLogEvent localSdkLogEvent = MoPubLog.SdkLogEvent.CUSTOM;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = ("MoPub preconditions had a format exception: " + localIllegalFormatException.getMessage());
      MoPubLog.log(localSdkLogEvent, arrayOfObject);
    }
    return str1;
  }

  private static boolean b(Object paramObject, boolean paramBoolean, String paramString, Object[] paramArrayOfObject)
  {
    if (paramObject != null)
      return true;
    String str = a(paramString, paramArrayOfObject);
    if (paramBoolean)
      throw new NullPointerException(str);
    MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { str });
    return false;
  }

  private static boolean b(boolean paramBoolean, String paramString, Object[] paramArrayOfObject)
  {
    if (Looper.getMainLooper().equals(Looper.myLooper()))
      return true;
    String str = a(paramString, paramArrayOfObject);
    if (paramBoolean)
      throw new IllegalStateException(str);
    MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { str });
    return false;
  }

  private static boolean c(boolean paramBoolean1, boolean paramBoolean2, String paramString, Object[] paramArrayOfObject)
  {
    if (paramBoolean1)
      return true;
    String str = a(paramString, paramArrayOfObject);
    if (paramBoolean2)
      throw new IllegalArgumentException(str);
    MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { str });
    return false;
  }

  public static void checkArgument(boolean paramBoolean)
  {
    c(paramBoolean, true, "Illegal argument.", new Object[] { "" });
  }

  public static void checkArgument(boolean paramBoolean, String paramString)
  {
    c(paramBoolean, true, paramString, new Object[] { "" });
  }

  public static void checkArgument(boolean paramBoolean, String paramString, Object[] paramArrayOfObject)
  {
    c(paramBoolean, true, paramString, paramArrayOfObject);
  }

  public static void checkNotNull(Object paramObject)
  {
    b(paramObject, true, "Object can not be null.", new Object[] { "" });
  }

  public static void checkNotNull(Object paramObject, String paramString)
  {
    b(paramObject, true, paramString, new Object[] { "" });
  }

  public static void checkNotNull(Object paramObject, String paramString, Object[] paramArrayOfObject)
  {
    b(paramObject, true, paramString, paramArrayOfObject);
  }

  public static void checkState(boolean paramBoolean)
  {
    d(paramBoolean, true, "Illegal state.", new Object[] { "" });
  }

  public static void checkState(boolean paramBoolean, String paramString)
  {
    d(paramBoolean, true, paramString, new Object[] { "" });
  }

  public static void checkState(boolean paramBoolean, String paramString, Object[] paramArrayOfObject)
  {
    d(paramBoolean, true, paramString, paramArrayOfObject);
  }

  public static void checkUiThread()
  {
    b(true, "This method must be called from the UI thread.", new Object[] { "" });
  }

  public static void checkUiThread(String paramString)
  {
    b(true, paramString, new Object[] { "" });
  }

  public static void checkUiThread(String paramString, Object[] paramArrayOfObject)
  {
    b(true, paramString, paramArrayOfObject);
  }

  private static boolean d(boolean paramBoolean1, boolean paramBoolean2, String paramString, Object[] paramArrayOfObject)
  {
    if (paramBoolean1)
      return true;
    String str = a(paramString, paramArrayOfObject);
    if (paramBoolean2)
      throw new IllegalStateException(str);
    MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { str });
    return false;
  }

  public static final class NoThrow
  {
    private static volatile boolean a = false;

    public static boolean checkArgument(boolean paramBoolean)
    {
      return Preconditions.a(paramBoolean, a, "Illegal argument", new Object[] { "" });
    }

    public static boolean checkArgument(boolean paramBoolean, String paramString)
    {
      return Preconditions.a(paramBoolean, a, paramString, new Object[] { "" });
    }

    public static boolean checkArgument(boolean paramBoolean, String paramString, Object[] paramArrayOfObject)
    {
      return Preconditions.a(paramBoolean, a, paramString, paramArrayOfObject);
    }

    public static boolean checkNotNull(Object paramObject)
    {
      return Preconditions.a(paramObject, a, "Object can not be null.", new Object[] { "" });
    }

    public static boolean checkNotNull(Object paramObject, String paramString)
    {
      return Preconditions.a(paramObject, a, paramString, new Object[] { "" });
    }

    public static boolean checkNotNull(Object paramObject, String paramString, Object[] paramArrayOfObject)
    {
      return Preconditions.a(paramObject, a, paramString, paramArrayOfObject);
    }

    public static boolean checkState(boolean paramBoolean)
    {
      return Preconditions.b(paramBoolean, a, "Illegal state.", new Object[] { "" });
    }

    public static boolean checkState(boolean paramBoolean, String paramString)
    {
      return Preconditions.b(paramBoolean, a, paramString, new Object[] { "" });
    }

    public static boolean checkState(boolean paramBoolean, String paramString, Object[] paramArrayOfObject)
    {
      return Preconditions.b(paramBoolean, a, paramString, paramArrayOfObject);
    }

    public static boolean checkUiThread()
    {
      return Preconditions.a(a, "This method must be called from the UI thread.", new Object[] { "" });
    }

    public static boolean checkUiThread(String paramString)
    {
      return Preconditions.a(a, paramString, new Object[] { "" });
    }

    public static boolean checkUiThread(String paramString, Object[] paramArrayOfObject)
    {
      return Preconditions.a(false, paramString, paramArrayOfObject);
    }

    public static void setStrictMode(boolean paramBoolean)
    {
      a = paramBoolean;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.common.Preconditions
 * JD-Core Version:    0.6.2
 */