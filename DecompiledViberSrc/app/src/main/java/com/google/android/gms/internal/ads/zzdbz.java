package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class zzdbz<P>
{
  private static final Charset UTF_8 = Charset.forName("UTF-8");
  private final Class<P> zzgpd;
  private ConcurrentMap<String, List<zzdca<P>>> zzgpj = new ConcurrentHashMap();
  private zzdca<P> zzgpk;

  private zzdbz(Class<P> paramClass)
  {
    this.zzgpd = paramClass;
  }

  public static <P> zzdbz<P> zza(Class<P> paramClass)
  {
    return new zzdbz(paramClass);
  }

  public final zzdca<P> zza(P paramP, zzdgz.zzb paramzzb)
    throws GeneralSecurityException
  {
    byte[] arrayOfByte;
    switch (zzdbm.zzgpa[paramzzb.zzanw().ordinal()])
    {
    default:
      throw new GeneralSecurityException("unknown output prefix type");
    case 1:
    case 2:
      arrayOfByte = ByteBuffer.allocate(5).put((byte)0).putInt(paramzzb.zzasp()).array();
    case 3:
    case 4:
    }
    while (true)
    {
      zzdca localzzdca = new zzdca(paramP, arrayOfByte, paramzzb.zzaso(), paramzzb.zzanw());
      ArrayList localArrayList1 = new ArrayList();
      localArrayList1.add(localzzdca);
      String str = new String(localzzdca.zzanx(), UTF_8);
      List localList = (List)this.zzgpj.put(str, Collections.unmodifiableList(localArrayList1));
      if (localList != null)
      {
        ArrayList localArrayList2 = new ArrayList();
        localArrayList2.addAll(localList);
        localArrayList2.add(localzzdca);
        this.zzgpj.put(str, Collections.unmodifiableList(localArrayList2));
      }
      return localzzdca;
      arrayOfByte = ByteBuffer.allocate(5).put((byte)1).putInt(paramzzb.zzasp()).array();
      continue;
      arrayOfByte = zzdbl.zzgoz;
    }
  }

  public final void zza(zzdca<P> paramzzdca)
  {
    this.zzgpk = paramzzdca;
  }

  public final Class<P> zzanr()
  {
    return this.zzgpd;
  }

  public final zzdca<P> zzanu()
  {
    return this.zzgpk;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdbz
 * JD-Core Version:    0.6.2
 */