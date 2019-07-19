package com.google.android.gms.internal.ads;

import android.os.ConditionVariable;

final class zzdb
  implements Runnable
{
  zzdb(zzda paramzzda)
  {
  }

  public final void run()
  {
    if (this.zzvi.zzvg != null)
      return;
    synchronized (zzda.zzcf())
    {
      if (this.zzvi.zzvg != null)
        return;
    }
    try
    {
      zzaci localzzaci = zzact.zzcrc;
      boolean bool2 = ((Boolean)zzyr.zzpe().zzd(localzzaci)).booleanValue();
      bool1 = bool2;
      if (!bool1);
    }
    catch (IllegalStateException localIllegalStateException)
    {
      try
      {
        zzda.zzvf = new zzwm(zzda.zza(this.zzvi).zzlj, "ADSHIELD", null);
        this.zzvi.zzvg = Boolean.valueOf(bool1);
        zzda.zzcf().open();
        return;
        localIllegalStateException = localIllegalStateException;
        bool1 = false;
      }
      catch (Throwable localThrowable)
      {
        while (true)
          boolean bool1 = false;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdb
 * JD-Core Version:    0.6.2
 */