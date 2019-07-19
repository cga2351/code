package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public final class zzdtp<T>
  implements zzdth<Set<T>>
{
  private static final zzdth<Set<Object>> zzhuo = zzdti.zzar(Collections.emptySet());
  private final List<zzdtt<T>> zzhup;
  private final List<zzdtt<Collection<T>>> zzhuq;

  private zzdtp(List<zzdtt<T>> paramList, List<zzdtt<Collection<T>>> paramList1)
  {
    this.zzhup = paramList;
    this.zzhuq = paramList1;
  }

  public static <T> zzdtr<T> zzao(int paramInt1, int paramInt2)
  {
    return new zzdtr(paramInt1, paramInt2, null);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdtp
 * JD-Core Version:    0.6.2
 */