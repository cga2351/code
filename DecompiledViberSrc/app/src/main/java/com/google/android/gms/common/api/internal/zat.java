package com.google.android.gms.common.api.internal;

import java.util.concurrent.locks.Lock;

final class zat
  implements Runnable
{
  zat(zas paramzas)
  {
  }

  public final void run()
  {
    zas.zaa(this.zaep).lock();
    try
    {
      zas.zab(this.zaep);
      return;
    }
    finally
    {
      zas.zaa(this.zaep).unlock();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zat
 * JD-Core Version:    0.6.2
 */