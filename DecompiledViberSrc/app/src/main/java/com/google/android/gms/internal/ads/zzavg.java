package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzk;

@zzare
public final class zzavg
  implements zzuc
{
  private final Object lock;
  private String zzchl;
  private final Context zzckp;
  private boolean zzdse;

  public zzavg(Context paramContext, String paramString)
  {
    if (paramContext.getApplicationContext() != null)
      paramContext = paramContext.getApplicationContext();
    this.zzckp = paramContext;
    this.zzchl = paramString;
    this.zzdse = false;
    this.lock = new Object();
  }

  public final String getAdUnitId()
  {
    return this.zzchl;
  }

  public final void zza(zzub paramzzub)
  {
    zzag(paramzzub.zzbtl);
  }

  public final void zzag(boolean paramBoolean)
  {
    if (!zzk.zzme().zzx(this.zzckp))
      return;
    synchronized (this.lock)
    {
      if (this.zzdse == paramBoolean)
        return;
    }
    this.zzdse = paramBoolean;
    if (TextUtils.isEmpty(this.zzchl))
      return;
    if (this.zzdse)
      zzk.zzme().zzd(this.zzckp, this.zzchl);
    while (true)
    {
      return;
      zzk.zzme().zze(this.zzckp, this.zzchl);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzavg
 * JD-Core Version:    0.6.2
 */