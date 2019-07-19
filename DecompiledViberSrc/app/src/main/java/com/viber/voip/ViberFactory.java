package com.viber.voip;

import com.viber.dexshared.BillingHost;
import com.viber.dexshared.LoggerFactoryHelper;
import com.viber.dexshared.OpenIabHelper;
import com.viber.voip.pixie.PixieController;
import com.viber.voip.util.http.OkHttpClientFactory;

abstract interface ViberFactory
{
  public abstract BillingHost getBillingHost();

  public abstract LoggerFactoryHelper getLoggerFactory();

  public abstract OkHttpClientFactory getOkHttpClientFactory();

  public abstract OpenIabHelper getOpenIabHelper();

  public abstract PixieController getPixieController();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.ViberFactory
 * JD-Core Version:    0.6.2
 */