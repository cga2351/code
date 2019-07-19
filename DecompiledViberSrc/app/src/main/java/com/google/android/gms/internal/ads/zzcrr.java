package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

final class zzcrr
  implements zzcuz<zzcuy<Bundle>>
{
  private final Set<String> zzggk;

  zzcrr(Set<String> paramSet)
  {
    this.zzggk = paramSet;
  }

  public final zzbbi<zzcuy<Bundle>> zzalm()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.zzggk.iterator();
    while (localIterator.hasNext())
      localArrayList.add((String)localIterator.next());
    return zzbas.zzm(new zzcrs(localArrayList));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcrr
 * JD-Core Version:    0.6.2
 */