package com.google.android.gms.measurement.internal;

final class zzev
  implements Runnable
{
  zzev(zzes paramzzes, zzaj paramzzaj)
  {
  }

  public final void run()
  {
    synchronized (this.zzasu)
    {
      zzes.zza(this.zzasu, false);
      if (!this.zzasu.zzasl.isConnected())
      {
        this.zzasu.zzasl.zzgt().zzjn().zzby("Connected to remote service");
        this.zzasu.zzasl.zza(this.zzasv);
      }
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.measurement.internal.zzev
 * JD-Core Version:    0.6.2
 */