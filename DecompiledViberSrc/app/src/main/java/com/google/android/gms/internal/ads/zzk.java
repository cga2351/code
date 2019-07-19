package com.google.android.gms.internal.ads;

final class zzk
  implements Runnable
{
  private final zzr zzw;
  private final zzy zzx;
  private final Runnable zzy;

  public zzk(zzr paramzzr, zzy paramzzy, Runnable paramRunnable)
  {
    this.zzw = paramzzr;
    this.zzx = paramzzy;
    this.zzy = paramRunnable;
  }

  public final void run()
  {
    this.zzw.isCanceled();
    int i;
    if (this.zzx.zzbi == null)
    {
      i = 1;
      if (i == 0)
        break label79;
      this.zzw.zza(this.zzx.result);
      label38: if (!this.zzx.zzbj)
        break label96;
      this.zzw.zzb("intermediate-response");
    }
    while (true)
    {
      if (this.zzy != null)
        this.zzy.run();
      return;
      i = 0;
      break;
      label79: this.zzw.zzb(this.zzx.zzbi);
      break label38;
      label96: this.zzw.zzc("done");
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzk
 * JD-Core Version:    0.6.2
 */