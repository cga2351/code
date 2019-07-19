package com.viber.voip.pixie;

import java.net.Proxy;

public abstract interface PixieController
{
  public abstract void addReadyListener(PixieReadyListener paramPixieReadyListener);

  public abstract void addRedirect(String paramString1, String paramString2);

  public abstract int getLocalProxyPort();

  public abstract int getPixieMode();

  public abstract int getPixiePort();

  public abstract Proxy getProxy();

  public abstract String getUnblockerInfo();

  public abstract void init();

  public abstract boolean isEnabled();

  public abstract void onAppForeground();

  public abstract void removeReadyListener(PixieReadyListener paramPixieReadyListener);

  public abstract void setPushConfig(String paramString);

  public abstract void startProxy();

  public abstract boolean useLocalProxy();

  public static abstract interface PixieReadyListener
  {
    public abstract void onReady();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.pixie.PixieController
 * JD-Core Version:    0.6.2
 */