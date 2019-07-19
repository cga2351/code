package com.facebook.systrace;

import android.os.Build.VERSION;
import android.os.Trace;

public class Systrace
{
  public static final long TRACE_TAG_REACT_APPS;
  public static final long TRACE_TAG_REACT_FRESCO;
  public static final long TRACE_TAG_REACT_JAVA_BRIDGE;
  public static final long TRACE_TAG_REACT_JS_VM_CALLS;
  public static final long TRACE_TAG_REACT_VIEW;

  public static void beginAsyncSection(long paramLong, String paramString, int paramInt)
  {
  }

  public static void beginAsyncSection(long paramLong1, String paramString, int paramInt, long paramLong2)
  {
  }

  public static void beginSection(long paramLong, String paramString)
  {
    if (Build.VERSION.SDK_INT >= 18)
      Trace.beginSection(paramString);
  }

  public static void endAsyncFlow(long paramLong, String paramString, int paramInt)
  {
  }

  public static void endAsyncSection(long paramLong, String paramString, int paramInt)
  {
  }

  public static void endAsyncSection(long paramLong1, String paramString, int paramInt, long paramLong2)
  {
  }

  public static void endSection(long paramLong)
  {
    if (Build.VERSION.SDK_INT >= 18)
      Trace.endSection();
  }

  public static boolean isTracing(long paramLong)
  {
    return false;
  }

  public static void registerListener(TraceListener paramTraceListener)
  {
  }

  public static void startAsyncFlow(long paramLong, String paramString, int paramInt)
  {
  }

  public static void stepAsyncFlow(long paramLong, String paramString, int paramInt)
  {
  }

  public static void traceCounter(long paramLong, String paramString, int paramInt)
  {
  }

  public static void traceInstant(long paramLong, String paramString, EventScope paramEventScope)
  {
  }

  public static void unregisterListener(TraceListener paramTraceListener)
  {
  }

  public static enum EventScope
  {
    private final char mCode;

    static
    {
      PROCESS = new EventScope("PROCESS", 1, 'p');
      GLOBAL = new EventScope("GLOBAL", 2, 'g');
      EventScope[] arrayOfEventScope = new EventScope[3];
      arrayOfEventScope[0] = THREAD;
      arrayOfEventScope[1] = PROCESS;
      arrayOfEventScope[2] = GLOBAL;
    }

    private EventScope(char paramChar)
    {
      this.mCode = paramChar;
    }

    public char getCode()
    {
      return this.mCode;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.systrace.Systrace
 * JD-Core Version:    0.6.2
 */