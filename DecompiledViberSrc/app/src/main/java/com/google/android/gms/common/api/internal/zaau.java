package com.google.android.gms.common.api.internal;

import java.util.concurrent.locks.Lock;

abstract class zaau
  implements Runnable
{
  private zaau(zaak paramzaak)
  {
  }

  public void run()
  {
    zaak.zac(this.zagi).lock();
    try
    {
      boolean bool = Thread.interrupted();
      if (bool)
        return;
      zaan();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      zaak.zad(this.zagi).zab(localRuntimeException);
      return;
    }
    finally
    {
      zaak.zac(this.zagi).unlock();
    }
  }

  protected abstract void zaan();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zaau
 * JD-Core Version:    0.6.2
 */