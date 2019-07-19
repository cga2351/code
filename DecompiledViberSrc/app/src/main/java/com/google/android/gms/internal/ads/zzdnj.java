package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class zzdnj
  implements zzdrn
{
  private final zzdnh zzhcx;

  private zzdnj(zzdnh paramzzdnh)
  {
    this.zzhcx = ((zzdnh)zzdoc.zza(paramzzdnh, "output"));
    this.zzhcx.zzhdo = this;
  }

  public static zzdnj zza(zzdnh paramzzdnh)
  {
    if (paramzzdnh.zzhdo != null)
      return paramzzdnh.zzhdo;
    return new zzdnj(paramzzdnh);
  }

  public final void zza(int paramInt, float paramFloat)
    throws IOException
  {
    this.zzhcx.zza(paramInt, paramFloat);
  }

  public final void zza(int paramInt, zzdmq paramzzdmq)
    throws IOException
  {
    this.zzhcx.zza(paramInt, paramzzdmq);
  }

  public final <K, V> void zza(int paramInt, zzdpc<K, V> paramzzdpc, Map<K, V> paramMap)
    throws IOException
  {
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      this.zzhcx.zzw(paramInt, 2);
      this.zzhcx.zzga(zzdpb.zza(paramzzdpc, localEntry.getKey(), localEntry.getValue()));
      zzdpb.zza(this.zzhcx, paramzzdpc, localEntry.getKey(), localEntry.getValue());
    }
  }

  public final void zza(int paramInt, Object paramObject, zzdqa paramzzdqa)
    throws IOException
  {
    this.zzhcx.zza(paramInt, (zzdpj)paramObject, paramzzdqa);
  }

  public final void zza(int paramInt, List<String> paramList)
    throws IOException
  {
    boolean bool = paramList instanceof zzdos;
    int i = 0;
    if (bool)
    {
      zzdos localzzdos = (zzdos)paramList;
      int j = 0;
      if (j < paramList.size())
      {
        Object localObject = localzzdos.zzgq(j);
        if ((localObject instanceof String))
          this.zzhcx.zzf(paramInt, (String)localObject);
        while (true)
        {
          j++;
          break;
          this.zzhcx.zza(paramInt, (zzdmq)localObject);
        }
      }
    }
    else
    {
      while (i < paramList.size())
      {
        this.zzhcx.zzf(paramInt, (String)paramList.get(i));
        i++;
      }
    }
  }

  public final void zza(int paramInt, List<?> paramList, zzdqa paramzzdqa)
    throws IOException
  {
    for (int i = 0; i < paramList.size(); i++)
      zza(paramInt, paramList.get(i), paramzzdqa);
  }

  public final void zza(int paramInt, List<Integer> paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    if (paramBoolean)
    {
      this.zzhcx.zzw(paramInt, 2);
      int j = 0;
      int k = 0;
      while (j < paramList.size())
      {
        k += zzdnh.zzge(((Integer)paramList.get(j)).intValue());
        j++;
      }
      this.zzhcx.zzga(k);
      while (i < paramList.size())
      {
        this.zzhcx.zzfz(((Integer)paramList.get(i)).intValue());
        i++;
      }
    }
    while (i < paramList.size())
    {
      this.zzhcx.zzx(paramInt, ((Integer)paramList.get(i)).intValue());
      i++;
    }
  }

  public final void zzaa(int paramInt1, int paramInt2)
    throws IOException
  {
    this.zzhcx.zzaa(paramInt1, paramInt2);
  }

  public final void zzah(int paramInt1, int paramInt2)
    throws IOException
  {
    this.zzhcx.zzaa(paramInt1, paramInt2);
  }

  public final void zzai(int paramInt1, int paramInt2)
    throws IOException
  {
    this.zzhcx.zzx(paramInt1, paramInt2);
  }

  public final int zzawy()
  {
    return zzdoa.zze.zzhhv;
  }

  public final void zzb(int paramInt, double paramDouble)
    throws IOException
  {
    this.zzhcx.zzb(paramInt, paramDouble);
  }

  public final void zzb(int paramInt, Object paramObject)
    throws IOException
  {
    if ((paramObject instanceof zzdmq))
    {
      this.zzhcx.zzb(paramInt, (zzdmq)paramObject);
      return;
    }
    this.zzhcx.zzb(paramInt, (zzdpj)paramObject);
  }

  public final void zzb(int paramInt, Object paramObject, zzdqa paramzzdqa)
    throws IOException
  {
    zzdnh localzzdnh = this.zzhcx;
    zzdpj localzzdpj = (zzdpj)paramObject;
    localzzdnh.zzw(paramInt, 3);
    paramzzdqa.zza(localzzdpj, localzzdnh.zzhdo);
    localzzdnh.zzw(paramInt, 4);
  }

  public final void zzb(int paramInt, List<zzdmq> paramList)
    throws IOException
  {
    for (int i = 0; i < paramList.size(); i++)
      this.zzhcx.zza(paramInt, (zzdmq)paramList.get(i));
  }

  public final void zzb(int paramInt, List<?> paramList, zzdqa paramzzdqa)
    throws IOException
  {
    for (int i = 0; i < paramList.size(); i++)
      zzb(paramInt, paramList.get(i), paramzzdqa);
  }

  public final void zzb(int paramInt, List<Integer> paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    if (paramBoolean)
    {
      this.zzhcx.zzw(paramInt, 2);
      int j = 0;
      int k = 0;
      while (j < paramList.size())
      {
        k += zzdnh.zzgh(((Integer)paramList.get(j)).intValue());
        j++;
      }
      this.zzhcx.zzga(k);
      while (i < paramList.size())
      {
        this.zzhcx.zzgc(((Integer)paramList.get(i)).intValue());
        i++;
      }
    }
    while (i < paramList.size())
    {
      this.zzhcx.zzaa(paramInt, ((Integer)paramList.get(i)).intValue());
      i++;
    }
  }

  public final void zzc(int paramInt, List<Long> paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    if (paramBoolean)
    {
      this.zzhcx.zzw(paramInt, 2);
      int j = 0;
      int k = 0;
      while (j < paramList.size())
      {
        k += zzdnh.zzfm(((Long)paramList.get(j)).longValue());
        j++;
      }
      this.zzhcx.zzga(k);
      while (i < paramList.size())
      {
        this.zzhcx.zzfj(((Long)paramList.get(i)).longValue());
        i++;
      }
    }
    while (i < paramList.size())
    {
      this.zzhcx.zzh(paramInt, ((Long)paramList.get(i)).longValue());
      i++;
    }
  }

  public final void zzd(int paramInt, List<Long> paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    if (paramBoolean)
    {
      this.zzhcx.zzw(paramInt, 2);
      int j = 0;
      int k = 0;
      while (j < paramList.size())
      {
        k += zzdnh.zzfn(((Long)paramList.get(j)).longValue());
        j++;
      }
      this.zzhcx.zzga(k);
      while (i < paramList.size())
      {
        this.zzhcx.zzfj(((Long)paramList.get(i)).longValue());
        i++;
      }
    }
    while (i < paramList.size())
    {
      this.zzhcx.zzh(paramInt, ((Long)paramList.get(i)).longValue());
      i++;
    }
  }

  public final void zze(int paramInt, List<Long> paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    if (paramBoolean)
    {
      this.zzhcx.zzw(paramInt, 2);
      int j = 0;
      int k = 0;
      while (j < paramList.size())
      {
        k += zzdnh.zzfp(((Long)paramList.get(j)).longValue());
        j++;
      }
      this.zzhcx.zzga(k);
      while (i < paramList.size())
      {
        this.zzhcx.zzfl(((Long)paramList.get(i)).longValue());
        i++;
      }
    }
    while (i < paramList.size())
    {
      this.zzhcx.zzj(paramInt, ((Long)paramList.get(i)).longValue());
      i++;
    }
  }

  public final void zzf(int paramInt, String paramString)
    throws IOException
  {
    this.zzhcx.zzf(paramInt, paramString);
  }

  public final void zzf(int paramInt, List<Float> paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    if (paramBoolean)
    {
      this.zzhcx.zzw(paramInt, 2);
      int j = 0;
      int k = 0;
      while (j < paramList.size())
      {
        k += zzdnh.zzh(((Float)paramList.get(j)).floatValue());
        j++;
      }
      this.zzhcx.zzga(k);
      while (i < paramList.size())
      {
        this.zzhcx.zzg(((Float)paramList.get(i)).floatValue());
        i++;
      }
    }
    while (i < paramList.size())
    {
      this.zzhcx.zza(paramInt, ((Float)paramList.get(i)).floatValue());
      i++;
    }
  }

  public final void zzg(int paramInt, List<Double> paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    if (paramBoolean)
    {
      this.zzhcx.zzw(paramInt, 2);
      int j = 0;
      int k = 0;
      while (j < paramList.size())
      {
        k += zzdnh.zzc(((Double)paramList.get(j)).doubleValue());
        j++;
      }
      this.zzhcx.zzga(k);
      while (i < paramList.size())
      {
        this.zzhcx.zzb(((Double)paramList.get(i)).doubleValue());
        i++;
      }
    }
    while (i < paramList.size())
    {
      this.zzhcx.zzb(paramInt, ((Double)paramList.get(i)).doubleValue());
      i++;
    }
  }

  public final void zzgm(int paramInt)
    throws IOException
  {
    this.zzhcx.zzw(paramInt, 3);
  }

  public final void zzgn(int paramInt)
    throws IOException
  {
    this.zzhcx.zzw(paramInt, 4);
  }

  public final void zzh(int paramInt, long paramLong)
    throws IOException
  {
    this.zzhcx.zzh(paramInt, paramLong);
  }

  public final void zzh(int paramInt, List<Integer> paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    if (paramBoolean)
    {
      this.zzhcx.zzw(paramInt, 2);
      int j = 0;
      int k = 0;
      while (j < paramList.size())
      {
        k += zzdnh.zzgj(((Integer)paramList.get(j)).intValue());
        j++;
      }
      this.zzhcx.zzga(k);
      while (i < paramList.size())
      {
        this.zzhcx.zzfz(((Integer)paramList.get(i)).intValue());
        i++;
      }
    }
    while (i < paramList.size())
    {
      this.zzhcx.zzx(paramInt, ((Integer)paramList.get(i)).intValue());
      i++;
    }
  }

  public final void zzi(int paramInt, long paramLong)
    throws IOException
  {
    this.zzhcx.zzi(paramInt, paramLong);
  }

  public final void zzi(int paramInt, List<Boolean> paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    if (paramBoolean)
    {
      this.zzhcx.zzw(paramInt, 2);
      int j = 0;
      int k = 0;
      while (j < paramList.size())
      {
        k += zzdnh.zzbg(((Boolean)paramList.get(j)).booleanValue());
        j++;
      }
      this.zzhcx.zzga(k);
      while (i < paramList.size())
      {
        this.zzhcx.zzbf(((Boolean)paramList.get(i)).booleanValue());
        i++;
      }
    }
    while (i < paramList.size())
    {
      this.zzhcx.zzi(paramInt, ((Boolean)paramList.get(i)).booleanValue());
      i++;
    }
  }

  public final void zzi(int paramInt, boolean paramBoolean)
    throws IOException
  {
    this.zzhcx.zzi(paramInt, paramBoolean);
  }

  public final void zzj(int paramInt, long paramLong)
    throws IOException
  {
    this.zzhcx.zzj(paramInt, paramLong);
  }

  public final void zzj(int paramInt, List<Integer> paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    if (paramBoolean)
    {
      this.zzhcx.zzw(paramInt, 2);
      int j = 0;
      int k = 0;
      while (j < paramList.size())
      {
        k += zzdnh.zzgf(((Integer)paramList.get(j)).intValue());
        j++;
      }
      this.zzhcx.zzga(k);
      while (i < paramList.size())
      {
        this.zzhcx.zzga(((Integer)paramList.get(i)).intValue());
        i++;
      }
    }
    while (i < paramList.size())
    {
      this.zzhcx.zzy(paramInt, ((Integer)paramList.get(i)).intValue());
      i++;
    }
  }

  public final void zzk(int paramInt, List<Integer> paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    if (paramBoolean)
    {
      this.zzhcx.zzw(paramInt, 2);
      int j = 0;
      int k = 0;
      while (j < paramList.size())
      {
        k += zzdnh.zzgi(((Integer)paramList.get(j)).intValue());
        j++;
      }
      this.zzhcx.zzga(k);
      while (i < paramList.size())
      {
        this.zzhcx.zzgc(((Integer)paramList.get(i)).intValue());
        i++;
      }
    }
    while (i < paramList.size())
    {
      this.zzhcx.zzaa(paramInt, ((Integer)paramList.get(i)).intValue());
      i++;
    }
  }

  public final void zzl(int paramInt, List<Long> paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    if (paramBoolean)
    {
      this.zzhcx.zzw(paramInt, 2);
      int j = 0;
      int k = 0;
      while (j < paramList.size())
      {
        k += zzdnh.zzfq(((Long)paramList.get(j)).longValue());
        j++;
      }
      this.zzhcx.zzga(k);
      while (i < paramList.size())
      {
        this.zzhcx.zzfl(((Long)paramList.get(i)).longValue());
        i++;
      }
    }
    while (i < paramList.size())
    {
      this.zzhcx.zzj(paramInt, ((Long)paramList.get(i)).longValue());
      i++;
    }
  }

  public final void zzm(int paramInt, List<Integer> paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    if (paramBoolean)
    {
      this.zzhcx.zzw(paramInt, 2);
      int j = 0;
      int k = 0;
      while (j < paramList.size())
      {
        k += zzdnh.zzgg(((Integer)paramList.get(j)).intValue());
        j++;
      }
      this.zzhcx.zzga(k);
      while (i < paramList.size())
      {
        this.zzhcx.zzgb(((Integer)paramList.get(i)).intValue());
        i++;
      }
    }
    while (i < paramList.size())
    {
      this.zzhcx.zzz(paramInt, ((Integer)paramList.get(i)).intValue());
      i++;
    }
  }

  public final void zzn(int paramInt, List<Long> paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    if (paramBoolean)
    {
      this.zzhcx.zzw(paramInt, 2);
      int j = 0;
      int k = 0;
      while (j < paramList.size())
      {
        k += zzdnh.zzfo(((Long)paramList.get(j)).longValue());
        j++;
      }
      this.zzhcx.zzga(k);
      while (i < paramList.size())
      {
        this.zzhcx.zzfk(((Long)paramList.get(i)).longValue());
        i++;
      }
    }
    while (i < paramList.size())
    {
      this.zzhcx.zzi(paramInt, ((Long)paramList.get(i)).longValue());
      i++;
    }
  }

  public final void zzp(int paramInt, long paramLong)
    throws IOException
  {
    this.zzhcx.zzh(paramInt, paramLong);
  }

  public final void zzq(int paramInt, long paramLong)
    throws IOException
  {
    this.zzhcx.zzj(paramInt, paramLong);
  }

  public final void zzx(int paramInt1, int paramInt2)
    throws IOException
  {
    this.zzhcx.zzx(paramInt1, paramInt2);
  }

  public final void zzy(int paramInt1, int paramInt2)
    throws IOException
  {
    this.zzhcx.zzy(paramInt1, paramInt2);
  }

  public final void zzz(int paramInt1, int paramInt2)
    throws IOException
  {
    this.zzhcx.zzz(paramInt1, paramInt2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdnj
 * JD-Core Version:    0.6.2
 */