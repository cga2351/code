package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class zzag
{
  private static final String CLASS_NAME = zzag.class.getName();
  public static boolean DEBUG;
  private static String TAG = "Volley";

  static
  {
    DEBUG = Log.isLoggable("Volley", 2);
  }

  public static void d(String paramString, Object[] paramArrayOfObject)
  {
    Log.d(TAG, zza(paramString, paramArrayOfObject));
  }

  public static void e(String paramString, Object[] paramArrayOfObject)
  {
    Log.e(TAG, zza(paramString, paramArrayOfObject));
  }

  public static void v(String paramString, Object[] paramArrayOfObject)
  {
    if (DEBUG)
      Log.v(TAG, zza(paramString, paramArrayOfObject));
  }

  private static String zza(String paramString, Object[] paramArrayOfObject)
  {
    int i;
    label20: String str4;
    String str5;
    if (paramArrayOfObject == null)
    {
      StackTraceElement[] arrayOfStackTraceElement = new Throwable().fillInStackTrace().getStackTrace();
      i = 2;
      if (i >= arrayOfStackTraceElement.length)
        break label198;
      if (arrayOfStackTraceElement[i].getClassName().equals(CLASS_NAME))
        break label192;
      String str2 = arrayOfStackTraceElement[i].getClassName();
      String str3 = str2.substring(1 + str2.lastIndexOf('.'));
      str4 = str3.substring(1 + str3.lastIndexOf('$'));
      str5 = arrayOfStackTraceElement[i].getMethodName();
    }
    label192: label198: for (String str1 = 1 + String.valueOf(str4).length() + String.valueOf(str5).length() + str4 + "." + str5; ; str1 = "<unknown>")
    {
      Locale localLocale = Locale.US;
      Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = Long.valueOf(Thread.currentThread().getId());
      arrayOfObject[1] = str1;
      arrayOfObject[2] = paramString;
      return String.format(localLocale, "[%d] %s: %s", arrayOfObject);
      paramString = String.format(Locale.US, paramString, paramArrayOfObject);
      break;
      i++;
      break label20;
    }
  }

  public static void zza(Throwable paramThrowable, String paramString, Object[] paramArrayOfObject)
  {
    Log.e(TAG, zza(paramString, paramArrayOfObject), paramThrowable);
  }

  static final class zza
  {
    public static final boolean zzbl = zzag.DEBUG;
    private final List<zzah> zzbm = new ArrayList();
    private boolean zzbn = false;

    protected final void finalize()
      throws Throwable
    {
      if (!this.zzbn)
      {
        zzc("Request on the loose");
        zzag.e("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
      }
    }

    public final void zza(String paramString, long paramLong)
    {
      try
      {
        if (this.zzbn)
          throw new IllegalStateException("Marker added to finished log");
      }
      finally
      {
      }
      this.zzbm.add(new zzah(paramString, paramLong, SystemClock.elapsedRealtime()));
    }

    public final void zzc(String paramString)
    {
      try
      {
        this.zzbn = true;
        int i = this.zzbm.size();
        long l2;
        if (i == 0)
        {
          l2 = 0L;
          if (l2 > 0L)
            break label86;
        }
        while (true)
        {
          return;
          long l1 = ((zzah)this.zzbm.get(0)).time;
          l2 = ((zzah)this.zzbm.get(-1 + this.zzbm.size())).time - l1;
          break;
          label86: long l3 = ((zzah)this.zzbm.get(0)).time;
          Object[] arrayOfObject1 = new Object[2];
          arrayOfObject1[0] = Long.valueOf(l2);
          arrayOfObject1[1] = paramString;
          zzag.d("(%-4d ms) %s", arrayOfObject1);
          Iterator localIterator = this.zzbm.iterator();
          long l5;
          for (long l4 = l3; localIterator.hasNext(); l4 = l5)
          {
            zzah localzzah = (zzah)localIterator.next();
            l5 = localzzah.time;
            Object[] arrayOfObject2 = new Object[3];
            arrayOfObject2[0] = Long.valueOf(l5 - l4);
            arrayOfObject2[1] = Long.valueOf(localzzah.zzbo);
            arrayOfObject2[2] = localzzah.name;
            zzag.d("(+%-4d) [%2d] %s", arrayOfObject2);
          }
        }
      }
      finally
      {
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzag
 * JD-Core Version:    0.6.2
 */