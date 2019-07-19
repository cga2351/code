package com.viber.dexshared;

import android.content.Context;
import com.viber.common.a.a;
import com.viber.common.a.e.a;

public abstract interface LoggerFactoryHelper
{
  public abstract void finish();

  public abstract void flush();

  public abstract Logger getLogger();

  public abstract Logger getLogger(Logger paramLogger);

  public abstract Logger getLogger(Logger paramLogger, String paramString);

  public abstract Logger getLogger(Class paramClass);

  public abstract Logger getLogger(String paramString);

  public abstract a getLoggerConfig();

  public abstract void init(Context paramContext, a parama);

  public abstract void setLogLevel(e.a parama);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.dexshared.LoggerFactoryHelper
 * JD-Core Version:    0.6.2
 */