package com.google.android.gms.common.api.internal;

import java.util.concurrent.locks.Lock;

abstract class zabf
{
  private final zabd zaht;

  protected zabf(zabd paramzabd)
  {
    this.zaht = paramzabd;
  }

  protected abstract void zaan();

  public final void zac(zabe paramzabe)
  {
    zabe.zaa(paramzabe).lock();
    try
    {
      zabd localzabd1 = zabe.zab(paramzabe);
      zabd localzabd2 = this.zaht;
      if (localzabd1 != localzabd2)
        return;
      zaan();
      return;
    }
    finally
    {
      zabe.zaa(paramzabe).unlock();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zabf
 * JD-Core Version:    0.6.2
 */