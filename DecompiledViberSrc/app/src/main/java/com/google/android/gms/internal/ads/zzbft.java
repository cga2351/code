package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@zzare
public final class zzbft
  implements Iterable<zzbfr>
{
  private final List<zzbfr> zzehu = new ArrayList();

  public static boolean zzc(zzbdg paramzzbdg)
  {
    zzbfr localzzbfr = zzd(paramzzbdg);
    if (localzzbfr != null)
    {
      localzzbfr.zzehs.abort();
      return true;
    }
    return false;
  }

  static zzbfr zzd(zzbdg paramzzbdg)
  {
    Iterator localIterator = zzk.zzmc().iterator();
    while (localIterator.hasNext())
    {
      zzbfr localzzbfr = (zzbfr)localIterator.next();
      if (localzzbfr.zzebv == paramzzbdg)
        return localzzbfr;
    }
    return null;
  }

  public final Iterator<zzbfr> iterator()
  {
    return this.zzehu.iterator();
  }

  public final void zza(zzbfr paramzzbfr)
  {
    this.zzehu.add(paramzzbfr);
  }

  public final void zzb(zzbfr paramzzbfr)
  {
    this.zzehu.remove(paramzzbfr);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbft
 * JD-Core Version:    0.6.2
 */