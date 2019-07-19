package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.List;

public final class zzdtr<T>
{
  private final List<zzdtt<T>> zzhup;
  private final List<zzdtt<Collection<T>>> zzhuq;

  private zzdtr(int paramInt1, int paramInt2)
  {
    this.zzhup = zzdte.zzhk(paramInt1);
    this.zzhuq = zzdte.zzhk(paramInt2);
  }

  public final zzdtr<T> zzaq(zzdtt<? extends T> paramzzdtt)
  {
    this.zzhup.add(paramzzdtt);
    return this;
  }

  public final zzdtr<T> zzar(zzdtt<? extends Collection<? extends T>> paramzzdtt)
  {
    this.zzhuq.add(paramzzdtt);
    return this;
  }

  public final zzdtp<T> zzbbh()
  {
    return new zzdtp(this.zzhup, this.zzhuq, null);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdtr
 * JD-Core Version:    0.6.2
 */