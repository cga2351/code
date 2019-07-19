package com.adjust.sdk;

public abstract interface ILogger
{
  public abstract void Assert(String paramString, Object[] paramArrayOfObject);

  public abstract void debug(String paramString, Object[] paramArrayOfObject);

  public abstract void error(String paramString, Object[] paramArrayOfObject);

  public abstract void info(String paramString, Object[] paramArrayOfObject);

  public abstract void lockLogLevel();

  public abstract void setLogLevel(LogLevel paramLogLevel, boolean paramBoolean);

  public abstract void setLogLevelString(String paramString, boolean paramBoolean);

  public abstract void verbose(String paramString, Object[] paramArrayOfObject);

  public abstract void warn(String paramString, Object[] paramArrayOfObject);

  public abstract void warnInProduction(String paramString, Object[] paramArrayOfObject);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.adjust.sdk.ILogger
 * JD-Core Version:    0.6.2
 */