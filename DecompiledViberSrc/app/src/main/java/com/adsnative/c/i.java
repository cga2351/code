package com.adsnative.c;

import android.annotation.SuppressLint;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class i
{
  private static final Logger a = Logger.getLogger("com.adsnative");
  private static final a b = new a(null);

  static
  {
    a.setUseParentHandlers(false);
    a.setLevel(Level.ALL);
    b.setLevel(Level.FINE);
    LogManager.getLogManager().addLogger(a);
    a(a, b);
  }

  public static void a(String paramString)
  {
    a(paramString, null);
  }

  public static void a(String paramString, Throwable paramThrowable)
  {
    a.log(Level.FINE, paramString, paramThrowable);
  }

  private static void a(Logger paramLogger, Handler paramHandler)
  {
    Handler[] arrayOfHandler = paramLogger.getHandlers();
    int i = arrayOfHandler.length;
    for (int j = 0; j < i; j++)
      if (arrayOfHandler[j].equals(paramHandler))
        return;
    paramLogger.addHandler(paramHandler);
  }

  public static void b(String paramString)
  {
    b(paramString, null);
  }

  public static void b(String paramString, Throwable paramThrowable)
  {
    a.log(Level.CONFIG, paramString, paramThrowable);
  }

  public static void c(String paramString)
  {
    c(paramString, null);
  }

  public static void c(String paramString, Throwable paramThrowable)
  {
    a.log(Level.INFO, paramString, paramThrowable);
  }

  public static void d(String paramString)
  {
    d(paramString, null);
  }

  public static void d(String paramString, Throwable paramThrowable)
  {
    a.log(Level.WARNING, paramString, paramThrowable);
  }

  public static void e(String paramString)
  {
    e(paramString, null);
  }

  public static void e(String paramString, Throwable paramThrowable)
  {
    a.log(Level.SEVERE, paramString, paramThrowable);
  }

  private static final class a extends Handler
  {
    private static final Map<Level, Integer> a = new HashMap(7);

    static
    {
      a.put(Level.FINEST, Integer.valueOf(2));
      a.put(Level.FINER, Integer.valueOf(2));
      a.put(Level.FINE, Integer.valueOf(2));
      a.put(Level.CONFIG, Integer.valueOf(3));
      a.put(Level.INFO, Integer.valueOf(4));
      a.put(Level.WARNING, Integer.valueOf(5));
      a.put(Level.SEVERE, Integer.valueOf(6));
    }

    public void close()
    {
    }

    public void flush()
    {
    }

    @SuppressLint({"LogTagMismatch"})
    public void publish(LogRecord paramLogRecord)
    {
      if (isLoggable(paramLogRecord))
        if (!a.containsKey(paramLogRecord.getLevel()))
          break label108;
      label108: for (int i = ((Integer)a.get(paramLogRecord.getLevel())).intValue(); ; i = 2)
      {
        String str = paramLogRecord.getMessage() + "\n";
        Throwable localThrowable = paramLogRecord.getThrown();
        if (localThrowable != null)
          str = str + Log.getStackTraceString(localThrowable);
        Log.println(i, "AdsNative", str);
        return;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.adsnative.c.i
 * JD-Core Version:    0.6.2
 */