package com.viber.voip;

import com.viber.dexshared.BillingHost;
import com.viber.dexshared.LoggerFactoryHelper;
import com.viber.dexshared.OpenIabHelper;
import com.viber.voip.billing.OpenIabHelperImpl;
import com.viber.voip.billing.a;
import com.viber.voip.pixie.PixieController;
import com.viber.voip.pixie.PixieControllerNativeImpl;
import com.viber.voip.t.b;
import com.viber.voip.util.http.DefaultOkHttpClientFactory;
import com.viber.voip.util.http.OkHttpClientFactory;

public class bj
  implements ViberFactory
{
  private LoggerFactoryHelper a;
  private BillingHost b;
  private OkHttpClientFactory c;

  public BillingHost getBillingHost()
  {
    if (this.b == null);
    try
    {
      if (this.b == null)
        this.b = new a();
      return this.b;
    }
    finally
    {
    }
  }

  public LoggerFactoryHelper getLoggerFactory()
  {
    if (this.a == null);
    try
    {
      if (this.a == null)
        this.a = new b();
      return this.a;
    }
    finally
    {
    }
  }

  public OkHttpClientFactory getOkHttpClientFactory()
  {
    if (this.c == null);
    try
    {
      if (this.c == null)
        this.c = new DefaultOkHttpClientFactory();
      return this.c;
    }
    finally
    {
    }
  }

  public OpenIabHelper getOpenIabHelper()
  {
    return new OpenIabHelperImpl();
  }

  public PixieController getPixieController()
  {
    return PixieControllerNativeImpl.getInstance();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.bj
 * JD-Core Version:    0.6.2
 */