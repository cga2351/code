package com.google.android.gms.internal.ads;

import android.os.Looper;
import java.util.concurrent.ExecutorService;

public final class zzjz
{
  private final ExecutorService zzaqh;
  private zzkb zzaqi;
  private boolean zzaqj;

  public zzjz(String paramString)
  {
    this.zzaqh = zzkq.zzax(paramString);
  }

  public final boolean isLoading()
  {
    return this.zzaqj;
  }

  public final void release()
  {
    if (this.zzaqj)
      zzgb();
    this.zzaqh.shutdown();
  }

  public final void zza(zzkc paramzzkc, zzka paramzzka)
  {
    Looper localLooper = Looper.myLooper();
    boolean bool1;
    if (localLooper != null)
    {
      bool1 = true;
      zzkh.checkState(bool1);
      if (this.zzaqj)
        break label73;
    }
    label73: for (boolean bool2 = true; ; bool2 = false)
    {
      zzkh.checkState(bool2);
      this.zzaqj = true;
      this.zzaqi = new zzkb(this, localLooper, paramzzkc, paramzzka, 0);
      this.zzaqh.submit(this.zzaqi);
      return;
      bool1 = false;
      break;
    }
  }

  public final void zzgb()
  {
    zzkh.checkState(this.zzaqj);
    this.zzaqi.quit();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzjz
 * JD-Core Version:    0.6.2
 */