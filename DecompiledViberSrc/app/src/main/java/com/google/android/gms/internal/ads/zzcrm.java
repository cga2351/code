package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzcrm
  implements zzdth<zzcrj>
{
  private final zzdtt<Executor> zzfgg;
  private final zzdtt<zzbbi<String>> zzgge;

  private zzcrm(zzdtt<zzbbi<String>> paramzzdtt, zzdtt<Executor> paramzzdtt1)
  {
    this.zzgge = paramzzdtt;
    this.zzfgg = paramzzdtt1;
  }

  public static zzcrm zzaj(zzdtt<zzbbi<String>> paramzzdtt, zzdtt<Executor> paramzzdtt1)
  {
    return new zzcrm(paramzzdtt, paramzzdtt1);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcrm
 * JD-Core Version:    0.6.2
 */