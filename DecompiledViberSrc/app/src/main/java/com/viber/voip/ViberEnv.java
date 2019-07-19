package com.viber.voip;

import com.viber.dexshared.BillingHost;
import com.viber.dexshared.Logger;
import com.viber.dexshared.LoggerFactoryHelper;
import com.viber.dexshared.OpenIabHelper;
import com.viber.voip.pixie.PixieController;
import com.viber.voip.util.http.OkHttpClientFactory;

public class ViberEnv
{
  private static ViberFactory sViberFactory;

  public static BillingHost getBillingHost()
  {
    return sViberFactory.getBillingHost();
  }

  public static Logger getLogger()
  {
    if (sViberFactory != null)
      return sViberFactory.getLoggerFactory().getLogger();
    return new a(null);
  }

  public static Logger getLogger(Logger paramLogger)
  {
    if (sViberFactory != null)
      return sViberFactory.getLoggerFactory().getLogger(paramLogger);
    return new a(null);
  }

  public static Logger getLogger(Logger paramLogger, String paramString)
  {
    if (sViberFactory != null)
      return sViberFactory.getLoggerFactory().getLogger(paramLogger, paramString);
    return new a(null);
  }

  public static Logger getLogger(Class paramClass)
  {
    if (sViberFactory != null)
      return sViberFactory.getLoggerFactory().getLogger(paramClass);
    return new a(null);
  }

  public static Logger getLogger(String paramString)
  {
    if (sViberFactory != null)
      return sViberFactory.getLoggerFactory().getLogger(paramString);
    return new a(null);
  }

  public static LoggerFactoryHelper getLoggerFactory()
  {
    return sViberFactory.getLoggerFactory();
  }

  public static OkHttpClientFactory getOkHttpClientFactory()
  {
    return sViberFactory.getOkHttpClientFactory();
  }

  public static OpenIabHelper getOpenIabHelper()
  {
    return sViberFactory.getOpenIabHelper();
  }

  @Deprecated
  public static PixieController getPixieController()
  {
    return sViberFactory.getPixieController();
  }

  public static void init(ViberFactory paramViberFactory)
  {
    try
    {
      sViberFactory = paramViberFactory;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private static class a
    implements Logger
  {
    public String a()
    {
      return null;
    }

    public void a(String paramString, Object[] paramArrayOfObject)
    {
    }

    public void a(Throwable paramThrowable, String paramString)
    {
    }

    public void a(Throwable paramThrowable, String paramString, Object[] paramArrayOfObject)
    {
    }

    public void b(String paramString, Object[] paramArrayOfObject)
    {
    }

    public void b(Throwable paramThrowable, String paramString, Object[] paramArrayOfObject)
    {
    }

    public void c(String paramString, Object[] paramArrayOfObject)
    {
    }

    public void d(String paramString, Object[] paramArrayOfObject)
    {
    }

    public void e(String paramString, Object[] paramArrayOfObject)
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.ViberEnv
 * JD-Core Version:    0.6.2
 */