package org.webrtc;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.EnumSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

public class Logging
{
  private static final Logger fallbackLogger = createFallbackLogger();

  @Nullable
  private static Loggable loggable;
  private static Severity loggableSeverity;
  private static volatile boolean loggingEnabled;

  private static Logger createFallbackLogger()
  {
    Logger localLogger = Logger.getLogger("org.webrtc.Logging");
    localLogger.setLevel(Level.ALL);
    return localLogger;
  }

  public static void d(String paramString1, String paramString2)
  {
    log(Severity.LS_INFO, paramString1, paramString2);
  }

  static void deleteInjectedLoggable()
  {
    loggable = null;
  }

  public static void e(String paramString1, String paramString2)
  {
    log(Severity.LS_ERROR, paramString1, paramString2);
  }

  public static void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    log(Severity.LS_ERROR, paramString1, paramString2);
    log(Severity.LS_ERROR, paramString1, paramThrowable.toString());
    log(Severity.LS_ERROR, paramString1, getStackTraceString(paramThrowable));
  }

  public static void enableLogThreads()
  {
    nativeEnableLogThreads();
  }

  public static void enableLogTimeStamps()
  {
    nativeEnableLogTimeStamps();
  }

  public static void enableLogToDebugOutput(Severity paramSeverity)
  {
    try
    {
      if (loggable != null)
        throw new IllegalStateException("Logging to native debug output not supported while Loggable is injected. Delete the Loggable before calling this method.");
    }
    finally
    {
    }
    nativeEnableLogToDebugOutput(paramSeverity.ordinal());
    loggingEnabled = true;
  }

  @Deprecated
  public static void enableTracing(String paramString, EnumSet<TraceLevel> paramEnumSet)
  {
  }

  private static String getStackTraceString(Throwable paramThrowable)
  {
    if (paramThrowable == null)
      return "";
    StringWriter localStringWriter = new StringWriter();
    paramThrowable.printStackTrace(new PrintWriter(localStringWriter));
    return localStringWriter.toString();
  }

  static void injectLoggable(Loggable paramLoggable, Severity paramSeverity)
  {
    if (paramLoggable != null)
    {
      loggable = paramLoggable;
      loggableSeverity = paramSeverity;
    }
  }

  public static void log(Severity paramSeverity, String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null))
      throw new IllegalArgumentException("Logging tag or message may not be null.");
    if (loggable != null)
    {
      if (paramSeverity.ordinal() < loggableSeverity.ordinal())
        return;
      loggable.onLogMessage(paramString2, paramSeverity, paramString1);
      return;
    }
    if (loggingEnabled)
    {
      nativeLog(paramSeverity.ordinal(), paramString1, paramString2);
      return;
    }
    Level localLevel;
    switch (1.$SwitchMap$org$webrtc$Logging$Severity[paramSeverity.ordinal()])
    {
    default:
      localLevel = Level.FINE;
    case 1:
    case 2:
    case 3:
    }
    while (true)
    {
      fallbackLogger.log(localLevel, paramString1 + ": " + paramString2);
      return;
      localLevel = Level.SEVERE;
      continue;
      localLevel = Level.WARNING;
      continue;
      localLevel = Level.INFO;
    }
  }

  private static native void nativeEnableLogThreads();

  private static native void nativeEnableLogTimeStamps();

  private static native void nativeEnableLogToDebugOutput(int paramInt);

  private static native void nativeLog(int paramInt, String paramString1, String paramString2);

  public static void v(String paramString1, String paramString2)
  {
    log(Severity.LS_VERBOSE, paramString1, paramString2);
  }

  public static void w(String paramString1, String paramString2)
  {
    log(Severity.LS_WARNING, paramString1, paramString2);
  }

  public static void w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    log(Severity.LS_WARNING, paramString1, paramString2);
    log(Severity.LS_WARNING, paramString1, paramThrowable.toString());
    log(Severity.LS_WARNING, paramString1, getStackTraceString(paramThrowable));
  }

  public static enum Severity
  {
    static
    {
      LS_INFO = new Severity("LS_INFO", 2);
      LS_WARNING = new Severity("LS_WARNING", 3);
      LS_ERROR = new Severity("LS_ERROR", 4);
      LS_NONE = new Severity("LS_NONE", 5);
      Severity[] arrayOfSeverity = new Severity[6];
      arrayOfSeverity[0] = LS_SENSITIVE;
      arrayOfSeverity[1] = LS_VERBOSE;
      arrayOfSeverity[2] = LS_INFO;
      arrayOfSeverity[3] = LS_WARNING;
      arrayOfSeverity[4] = LS_ERROR;
      arrayOfSeverity[5] = LS_NONE;
    }
  }

  @Deprecated
  public static enum TraceLevel
  {
    public final int level;

    static
    {
      TRACE_ERROR = new TraceLevel("TRACE_ERROR", 3, 4);
      TRACE_CRITICAL = new TraceLevel("TRACE_CRITICAL", 4, 8);
      TRACE_APICALL = new TraceLevel("TRACE_APICALL", 5, 16);
      TRACE_DEFAULT = new TraceLevel("TRACE_DEFAULT", 6, 255);
      TRACE_MODULECALL = new TraceLevel("TRACE_MODULECALL", 7, 32);
      TRACE_MEMORY = new TraceLevel("TRACE_MEMORY", 8, 256);
      TRACE_TIMER = new TraceLevel("TRACE_TIMER", 9, 512);
      TRACE_STREAM = new TraceLevel("TRACE_STREAM", 10, 1024);
      TRACE_DEBUG = new TraceLevel("TRACE_DEBUG", 11, 2048);
      TRACE_INFO = new TraceLevel("TRACE_INFO", 12, 4096);
      TRACE_TERSEINFO = new TraceLevel("TRACE_TERSEINFO", 13, 8192);
      TRACE_ALL = new TraceLevel("TRACE_ALL", 14, 65535);
      TraceLevel[] arrayOfTraceLevel = new TraceLevel[15];
      arrayOfTraceLevel[0] = TRACE_NONE;
      arrayOfTraceLevel[1] = TRACE_STATEINFO;
      arrayOfTraceLevel[2] = TRACE_WARNING;
      arrayOfTraceLevel[3] = TRACE_ERROR;
      arrayOfTraceLevel[4] = TRACE_CRITICAL;
      arrayOfTraceLevel[5] = TRACE_APICALL;
      arrayOfTraceLevel[6] = TRACE_DEFAULT;
      arrayOfTraceLevel[7] = TRACE_MODULECALL;
      arrayOfTraceLevel[8] = TRACE_MEMORY;
      arrayOfTraceLevel[9] = TRACE_TIMER;
      arrayOfTraceLevel[10] = TRACE_STREAM;
      arrayOfTraceLevel[11] = TRACE_DEBUG;
      arrayOfTraceLevel[12] = TRACE_INFO;
      arrayOfTraceLevel[13] = TRACE_TERSEINFO;
      arrayOfTraceLevel[14] = TRACE_ALL;
    }

    private TraceLevel(int paramInt)
    {
      this.level = paramInt;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.Logging
 * JD-Core Version:    0.6.2
 */