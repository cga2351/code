package com.adjust.sdk;

import android.util.Log;
import java.util.Arrays;
import java.util.Locale;

public class Logger
  implements ILogger
{
  private static String formatErrorMessage = "Error formating log message: %s, with params: %s";
  private boolean isProductionEnvironment = false;
  private LogLevel logLevel;
  private boolean logLevelLocked = false;

  public Logger()
  {
    setLogLevel(LogLevel.INFO, this.isProductionEnvironment);
  }

  public void Assert(String paramString, Object[] paramArrayOfObject)
  {
    if (this.isProductionEnvironment);
    while (this.logLevel.androidLogLevel > 7)
      return;
    try
    {
      Log.println(7, "Adjust", Util.formatString(paramString, paramArrayOfObject));
      return;
    }
    catch (Exception localException)
    {
      String str = formatErrorMessage;
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = paramString;
      arrayOfObject[1] = Arrays.toString(paramArrayOfObject);
      Log.e("Adjust", Util.formatString(str, arrayOfObject));
    }
  }

  public void debug(String paramString, Object[] paramArrayOfObject)
  {
    if (this.isProductionEnvironment);
    while (this.logLevel.androidLogLevel > 3)
      return;
    try
    {
      Log.d("Adjust", Util.formatString(paramString, paramArrayOfObject));
      return;
    }
    catch (Exception localException)
    {
      String str = formatErrorMessage;
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = paramString;
      arrayOfObject[1] = Arrays.toString(paramArrayOfObject);
      Log.e("Adjust", Util.formatString(str, arrayOfObject));
    }
  }

  public void error(String paramString, Object[] paramArrayOfObject)
  {
    if (this.isProductionEnvironment);
    while (this.logLevel.androidLogLevel > 6)
      return;
    try
    {
      Log.e("Adjust", Util.formatString(paramString, paramArrayOfObject));
      return;
    }
    catch (Exception localException)
    {
      String str = formatErrorMessage;
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = paramString;
      arrayOfObject[1] = Arrays.toString(paramArrayOfObject);
      Log.e("Adjust", Util.formatString(str, arrayOfObject));
    }
  }

  public void info(String paramString, Object[] paramArrayOfObject)
  {
    if (this.isProductionEnvironment);
    while (this.logLevel.androidLogLevel > 4)
      return;
    try
    {
      Log.i("Adjust", Util.formatString(paramString, paramArrayOfObject));
      return;
    }
    catch (Exception localException)
    {
      String str = formatErrorMessage;
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = paramString;
      arrayOfObject[1] = Arrays.toString(paramArrayOfObject);
      Log.e("Adjust", Util.formatString(str, arrayOfObject));
    }
  }

  public void lockLogLevel()
  {
    this.logLevelLocked = true;
  }

  public void setLogLevel(LogLevel paramLogLevel, boolean paramBoolean)
  {
    if (this.logLevelLocked)
      return;
    this.logLevel = paramLogLevel;
    this.isProductionEnvironment = paramBoolean;
  }

  public void setLogLevelString(String paramString, boolean paramBoolean)
  {
    if (paramString != null);
    try
    {
      setLogLevel(LogLevel.valueOf(paramString.toUpperCase(Locale.US)), paramBoolean);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      error("Malformed logLevel '%s', falling back to 'info'", new Object[] { paramString });
    }
  }

  public void verbose(String paramString, Object[] paramArrayOfObject)
  {
    if (this.isProductionEnvironment);
    while (this.logLevel.androidLogLevel > 2)
      return;
    try
    {
      Log.v("Adjust", Util.formatString(paramString, paramArrayOfObject));
      return;
    }
    catch (Exception localException)
    {
      String str = formatErrorMessage;
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = paramString;
      arrayOfObject[1] = Arrays.toString(paramArrayOfObject);
      Log.e("Adjust", Util.formatString(str, arrayOfObject));
    }
  }

  public void warn(String paramString, Object[] paramArrayOfObject)
  {
    if (this.isProductionEnvironment);
    while (this.logLevel.androidLogLevel > 5)
      return;
    try
    {
      Log.w("Adjust", Util.formatString(paramString, paramArrayOfObject));
      return;
    }
    catch (Exception localException)
    {
      String str = formatErrorMessage;
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = paramString;
      arrayOfObject[1] = Arrays.toString(paramArrayOfObject);
      Log.e("Adjust", Util.formatString(str, arrayOfObject));
    }
  }

  public void warnInProduction(String paramString, Object[] paramArrayOfObject)
  {
    if (this.logLevel.androidLogLevel <= 5);
    try
    {
      Log.w("Adjust", Util.formatString(paramString, paramArrayOfObject));
      return;
    }
    catch (Exception localException)
    {
      String str = formatErrorMessage;
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = paramString;
      arrayOfObject[1] = Arrays.toString(paramArrayOfObject);
      Log.e("Adjust", Util.formatString(str, arrayOfObject));
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.adjust.sdk.Logger
 * JD-Core Version:    0.6.2
 */