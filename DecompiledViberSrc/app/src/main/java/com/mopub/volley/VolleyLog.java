package com.mopub.volley;

import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class VolleyLog
{
  public static boolean DEBUG = Log.isLoggable(TAG, 2);
  public static String TAG = "Volley";
  private static final String a = VolleyLog.class.getName();

  private static String a(String paramString, Object[] paramArrayOfObject)
  {
    StackTraceElement[] arrayOfStackTraceElement;
    int i;
    label20: String str4;
    if (paramArrayOfObject == null)
    {
      arrayOfStackTraceElement = new Throwable().fillInStackTrace().getStackTrace();
      i = 2;
      if (i >= arrayOfStackTraceElement.length)
        break label175;
      if (arrayOfStackTraceElement[i].getClassName().equals(a))
        break label169;
      String str2 = arrayOfStackTraceElement[i].getClassName();
      String str3 = str2.substring(1 + str2.lastIndexOf('.'));
      str4 = str3.substring(1 + str3.lastIndexOf('$'));
    }
    label169: label175: for (String str1 = str4 + "." + arrayOfStackTraceElement[i].getMethodName(); ; str1 = "<unknown>")
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

  public static void d(String paramString, Object[] paramArrayOfObject)
  {
    Log.d(TAG, a(paramString, paramArrayOfObject));
  }

  public static void e(String paramString, Object[] paramArrayOfObject)
  {
    Log.e(TAG, a(paramString, paramArrayOfObject));
  }

  public static void e(Throwable paramThrowable, String paramString, Object[] paramArrayOfObject)
  {
    Log.e(TAG, a(paramString, paramArrayOfObject), paramThrowable);
  }

  public static void setTag(String paramString)
  {
    d("Changing log tag to %s", new Object[] { paramString });
    TAG = paramString;
    DEBUG = Log.isLoggable(TAG, 2);
  }

  public static void v(String paramString, Object[] paramArrayOfObject)
  {
    if (DEBUG)
      Log.v(TAG, a(paramString, paramArrayOfObject));
  }

  public static void wtf(String paramString, Object[] paramArrayOfObject)
  {
    Log.wtf(TAG, a(paramString, paramArrayOfObject));
  }

  public static void wtf(Throwable paramThrowable, String paramString, Object[] paramArrayOfObject)
  {
    Log.wtf(TAG, a(paramString, paramArrayOfObject), paramThrowable);
  }

  static class a
  {
    public static final boolean ENABLED = VolleyLog.DEBUG;
    private final List<a> a = new ArrayList();
    private boolean b = false;

    private long a()
    {
      if (this.a.size() == 0)
        return 0L;
      long l = ((a)this.a.get(0)).time;
      return ((a)this.a.get(-1 + this.a.size())).time - l;
    }

    public void add(String paramString, long paramLong)
    {
      try
      {
        if (this.b)
          throw new IllegalStateException("Marker added to finished log");
      }
      finally
      {
      }
      this.a.add(new a(paramString, paramLong, SystemClock.elapsedRealtime()));
    }

    protected void finalize()
      throws Throwable
    {
      if (!this.b)
      {
        finish("Request on the loose");
        VolleyLog.e("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
      }
    }

    public void finish(String paramString)
    {
      try
      {
        this.b = true;
        long l1 = a();
        if (l1 <= 0L);
        while (true)
        {
          return;
          long l2 = ((a)this.a.get(0)).time;
          Object[] arrayOfObject1 = new Object[2];
          arrayOfObject1[0] = Long.valueOf(l1);
          arrayOfObject1[1] = paramString;
          VolleyLog.d("(%-4d ms) %s", arrayOfObject1);
          Iterator localIterator = this.a.iterator();
          long l4;
          for (long l3 = l2; localIterator.hasNext(); l3 = l4)
          {
            a locala = (a)localIterator.next();
            l4 = locala.time;
            Object[] arrayOfObject2 = new Object[3];
            arrayOfObject2[0] = Long.valueOf(l4 - l3);
            arrayOfObject2[1] = Long.valueOf(locala.thread);
            arrayOfObject2[2] = locala.name;
            VolleyLog.d("(+%-4d) [%2d] %s", arrayOfObject2);
          }
        }
      }
      finally
      {
      }
    }

    private static class a
    {
      public final String name;
      public final long thread;
      public final long time;

      public a(String paramString, long paramLong1, long paramLong2)
      {
        this.name = paramString;
        this.thread = paramLong1;
        this.time = paramLong2;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.volley.VolleyLog
 * JD-Core Version:    0.6.2
 */