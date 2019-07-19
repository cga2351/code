package org.greenrobot.eventbus;

import android.util.Log;
import java.io.PrintStream;
import java.util.logging.Level;

public abstract interface Logger
{
  public abstract void log(Level paramLevel, String paramString);

  public abstract void log(Level paramLevel, String paramString, Throwable paramThrowable);

  public static class AndroidLogger
    implements Logger
  {
    static final boolean ANDROID_LOG_AVAILABLE;
    private final String tag;

    static
    {
      try
      {
        Class localClass = Class.forName("android.util.Log");
        bool = false;
        if (localClass != null)
          bool = true;
        ANDROID_LOG_AVAILABLE = bool;
        return;
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        while (true)
          boolean bool = false;
      }
    }

    public AndroidLogger(String paramString)
    {
      this.tag = paramString;
    }

    public static boolean isAndroidLogAvailable()
    {
      return ANDROID_LOG_AVAILABLE;
    }

    public void log(Level paramLevel, String paramString)
    {
      if (paramLevel != Level.OFF)
        Log.println(mapLevel(paramLevel), this.tag, paramString);
    }

    public void log(Level paramLevel, String paramString, Throwable paramThrowable)
    {
      if (paramLevel != Level.OFF)
        Log.println(mapLevel(paramLevel), this.tag, paramString + "\n" + Log.getStackTraceString(paramThrowable));
    }

    protected int mapLevel(Level paramLevel)
    {
      int i = paramLevel.intValue();
      if (i < 800)
      {
        if (i < 500)
          return 2;
        return 3;
      }
      if (i < 900)
        return 4;
      if (i < 1000)
        return 5;
      return 6;
    }
  }

  public static class JavaLogger
    implements Logger
  {
    protected final java.util.logging.Logger logger;

    public JavaLogger(String paramString)
    {
      this.logger = java.util.logging.Logger.getLogger(paramString);
    }

    public void log(Level paramLevel, String paramString)
    {
      this.logger.log(paramLevel, paramString);
    }

    public void log(Level paramLevel, String paramString, Throwable paramThrowable)
    {
      this.logger.log(paramLevel, paramString, paramThrowable);
    }
  }

  public static class SystemOutLogger
    implements Logger
  {
    public void log(Level paramLevel, String paramString)
    {
      System.out.println("[" + paramLevel + "] " + paramString);
    }

    public void log(Level paramLevel, String paramString, Throwable paramThrowable)
    {
      System.out.println("[" + paramLevel + "] " + paramString);
      paramThrowable.printStackTrace(System.out);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.greenrobot.eventbus.Logger
 * JD-Core Version:    0.6.2
 */