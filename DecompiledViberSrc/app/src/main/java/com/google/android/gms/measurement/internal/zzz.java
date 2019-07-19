package com.google.android.gms.measurement.internal;

final class zzz
  implements Runnable
{
  zzz(zzy paramzzy, zzct paramzzct)
  {
  }

  public final void run()
  {
    this.zzaho.zzgw();
    if (zzn.isMainThread())
      this.zzaho.zzgs().zzc(this);
    boolean bool;
    do
    {
      return;
      bool = this.zzahp.zzej();
      zzy.zza(this.zzahp, 0L);
    }
    while (!bool);
    this.zzahp.run();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.measurement.internal.zzz
 * JD-Core Version:    0.6.2
 */