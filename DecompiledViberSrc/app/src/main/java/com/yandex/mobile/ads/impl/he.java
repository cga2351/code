package com.yandex.mobile.ads.impl;

public final class he
{
  private final Object a = new Object();
  private boolean b;

  public final void a(Runnable paramRunnable)
  {
    synchronized (this.a)
    {
      if (this.b)
        return;
      this.b = true;
      paramRunnable.run();
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.he
 * JD-Core Version:    0.6.2
 */