package com.yandex.mobile.ads.impl;

import java.util.concurrent.ThreadFactory;

public final class dc
  implements ThreadFactory
{
  private final String a;

  public dc(String paramString)
  {
    this.a = paramString;
  }

  public final Thread newThread(Runnable paramRunnable)
  {
    return new Thread(paramRunnable, this.a);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.dc
 * JD-Core Version:    0.6.2
 */