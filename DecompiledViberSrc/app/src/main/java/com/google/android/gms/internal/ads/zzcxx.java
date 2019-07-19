package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.AdSize;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class zzcxx
{
  public static zzyb zza(Context paramContext, List<zzcxm> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      zzcxm localzzcxm = (zzcxm)localIterator.next();
      if (localzzcxm.zzgkq)
        localArrayList.add(AdSize.FLUID);
      else
        localArrayList.add(new AdSize(localzzcxm.width, localzzcxm.height));
    }
    return new zzyb(paramContext, (AdSize[])localArrayList.toArray(new AdSize[localArrayList.size()]));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcxx
 * JD-Core Version:    0.6.2
 */