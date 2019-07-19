package com.esotericsoftware.minlog;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;

public class Log
{
  public static boolean DEBUG = false;
  public static boolean ERROR = false;
  public static boolean INFO = false;
  public static final int LEVEL_DEBUG = 2;
  public static final int LEVEL_ERROR = 5;
  public static final int LEVEL_INFO = 3;
  public static final int LEVEL_NONE = 6;
  public static final int LEVEL_TRACE = 1;
  public static final int LEVEL_WARN = 4;
  public static boolean TRACE;
  public static boolean WARN;
  private static int level;
  private static Logger logger;

  static
  {
    int i = 1;
    level = 3;
    int j;
    int k;
    label28: int m;
    label41: int n;
    if (level <= 5)
    {
      j = i;
      ERROR = j;
      if (level > 4)
        break label87;
      k = i;
      WARN = k;
      if (level > 3)
        break label92;
      m = i;
      INFO = m;
      if (level > 2)
        break label97;
      n = i;
      label55: DEBUG = n;
      if (level > i)
        break label103;
    }
    while (true)
    {
      TRACE = i;
      logger = new Logger();
      return;
      j = 0;
      break;
      label87: k = 0;
      break label28;
      label92: m = 0;
      break label41;
      label97: n = 0;
      break label55;
      label103: i = 0;
    }
  }

  public static void DEBUG()
  {
    set(2);
  }

  public static void ERROR()
  {
    set(5);
  }

  public static void INFO()
  {
    set(3);
  }

  public static void NONE()
  {
    set(6);
  }

  public static void TRACE()
  {
    set(1);
  }

  public static void WARN()
  {
    set(4);
  }

  public static void debug(String paramString)
  {
    if (DEBUG)
      logger.log(2, null, paramString, null);
  }

  public static void debug(String paramString1, String paramString2)
  {
    if (DEBUG)
      logger.log(2, paramString1, paramString2, null);
  }

  public static void debug(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (DEBUG)
      logger.log(2, paramString1, paramString2, paramThrowable);
  }

  public static void debug(String paramString, Throwable paramThrowable)
  {
    if (DEBUG)
      logger.log(2, null, paramString, paramThrowable);
  }

  public static void error(String paramString)
  {
    if (ERROR)
      logger.log(5, null, paramString, null);
  }

  public static void error(String paramString1, String paramString2)
  {
    if (ERROR)
      logger.log(5, paramString1, paramString2, null);
  }

  public static void error(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (ERROR)
      logger.log(5, paramString1, paramString2, paramThrowable);
  }

  public static void error(String paramString, Throwable paramThrowable)
  {
    if (ERROR)
      logger.log(5, null, paramString, paramThrowable);
  }

  public static void info(String paramString)
  {
    if (INFO)
      logger.log(3, null, paramString, null);
  }

  public static void info(String paramString1, String paramString2)
  {
    if (INFO)
      logger.log(3, paramString1, paramString2, null);
  }

  public static void info(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (INFO)
      logger.log(3, paramString1, paramString2, paramThrowable);
  }

  public static void info(String paramString, Throwable paramThrowable)
  {
    if (INFO)
      logger.log(3, null, paramString, paramThrowable);
  }

  public static void set(int paramInt)
  {
    int i = 1;
    level = paramInt;
    int j;
    int k;
    label24: int m;
    label36: int n;
    if (paramInt <= 5)
    {
      j = i;
      ERROR = j;
      if (paramInt > 4)
        break label69;
      k = i;
      WARN = k;
      if (paramInt > 3)
        break label74;
      m = i;
      INFO = m;
      if (paramInt > 2)
        break label80;
      n = i;
      label49: DEBUG = n;
      if (paramInt > i)
        break label86;
    }
    while (true)
    {
      TRACE = i;
      return;
      j = 0;
      break;
      label69: k = 0;
      break label24;
      label74: m = 0;
      break label36;
      label80: n = 0;
      break label49;
      label86: i = 0;
    }
  }

  public static void setLogger(Logger paramLogger)
  {
    logger = paramLogger;
  }

  public static void trace(String paramString)
  {
    if (TRACE)
      logger.log(1, null, paramString, null);
  }

  public static void trace(String paramString1, String paramString2)
  {
    if (TRACE)
      logger.log(1, paramString1, paramString2, null);
  }

  public static void trace(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (TRACE)
      logger.log(1, paramString1, paramString2, paramThrowable);
  }

  public static void trace(String paramString, Throwable paramThrowable)
  {
    if (TRACE)
      logger.log(1, null, paramString, paramThrowable);
  }

  public static void warn(String paramString)
  {
    if (WARN)
      logger.log(4, null, paramString, null);
  }

  public static void warn(String paramString1, String paramString2)
  {
    if (WARN)
      logger.log(4, paramString1, paramString2, null);
  }

  public static void warn(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (WARN)
      logger.log(4, paramString1, paramString2, paramThrowable);
  }

  public static void warn(String paramString, Throwable paramThrowable)
  {
    if (WARN)
      logger.log(4, null, paramString, paramThrowable);
  }

  public static class Logger
  {
    private long firstLogTime = new Date().getTime();

    public void log(int paramInt, String paramString1, String paramString2, Throwable paramThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder(256);
      long l1 = new Date().getTime() - this.firstLogTime;
      long l2 = l1 / 60000L;
      long l3 = l1 / 1000L % 60L;
      if (l2 <= 9L)
        localStringBuilder.append('0');
      localStringBuilder.append(l2);
      localStringBuilder.append(':');
      if (l3 <= 9L)
        localStringBuilder.append('0');
      localStringBuilder.append(l3);
      switch (paramInt)
      {
      default:
      case 5:
      case 4:
      case 3:
      case 2:
      case 1:
      }
      while (true)
      {
        if (paramString1 != null)
        {
          localStringBuilder.append('[');
          localStringBuilder.append(paramString1);
          localStringBuilder.append("] ");
        }
        localStringBuilder.append(paramString2);
        if (paramThrowable != null)
        {
          StringWriter localStringWriter = new StringWriter(256);
          paramThrowable.printStackTrace(new PrintWriter(localStringWriter));
          localStringBuilder.append('\n');
          localStringBuilder.append(localStringWriter.toString().trim());
        }
        print(localStringBuilder.toString());
        return;
        localStringBuilder.append(" ERROR: ");
        continue;
        localStringBuilder.append("  WARN: ");
        continue;
        localStringBuilder.append("  INFO: ");
        continue;
        localStringBuilder.append(" DEBUG: ");
        continue;
        localStringBuilder.append(" TRACE: ");
      }
    }

    protected void print(String paramString)
    {
      System.out.println(paramString);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.esotericsoftware.minlog.Log
 * JD-Core Version:    0.6.2
 */