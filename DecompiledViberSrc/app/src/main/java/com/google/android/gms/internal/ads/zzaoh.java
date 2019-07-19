package com.google.android.gms.internal.ads;

import com.google.ads.a.a;
import com.google.ads.a.b;
import com.google.ads.mediation.a;
import java.util.Date;
import java.util.HashSet;

@zzare
public final class zzaoh
{
  public static int zza(a.a parama)
  {
    switch (zzaoi.zzdhc[parama.ordinal()])
    {
    default:
      return 0;
    case 2:
      return 1;
    case 3:
      return 2;
    case 4:
    }
    return 3;
  }

  public static a zza(zzxx paramzzxx, boolean paramBoolean)
  {
    HashSet localHashSet;
    Date localDate;
    a.b localb;
    if (paramzzxx.zzcgq != null)
    {
      localHashSet = new HashSet(paramzzxx.zzcgq);
      localDate = new Date(paramzzxx.zzcgo);
      switch (paramzzxx.zzcgp)
      {
      default:
        localb = a.b.a;
      case 2:
      case 1:
      }
    }
    while (true)
    {
      return new a(localDate, localb, localHashSet, paramBoolean, paramzzxx.zzmw);
      localHashSet = null;
      break;
      localb = a.b.c;
      continue;
      localb = a.b.b;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzaoh
 * JD-Core Version:    0.6.2
 */