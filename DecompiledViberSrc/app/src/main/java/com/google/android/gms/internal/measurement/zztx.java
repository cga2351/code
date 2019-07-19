package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class zztx
  implements zzxy
{
  private final zztv zzbty;

  private zztx(zztv paramzztv)
  {
    this.zzbty = ((zztv)zzuq.zza(paramzztv, "output"));
    this.zzbty.zzbup = this;
  }

  public static zztx zza(zztv paramzztv)
  {
    if (paramzztv.zzbup != null)
      return paramzztv.zzbup;
    return new zztx(paramzztv);
  }

  public final void zza(int paramInt, double paramDouble)
    throws IOException
  {
    this.zzbty.zza(paramInt, paramDouble);
  }

  public final void zza(int paramInt, float paramFloat)
    throws IOException
  {
    this.zzbty.zza(paramInt, paramFloat);
  }

  public final void zza(int paramInt, long paramLong)
    throws IOException
  {
    this.zzbty.zza(paramInt, paramLong);
  }

  public final void zza(int paramInt, zzte paramzzte)
    throws IOException
  {
    this.zzbty.zza(paramInt, paramzzte);
  }

  public final <K, V> void zza(int paramInt, zzvo<K, V> paramzzvo, Map<K, V> paramMap)
    throws IOException
  {
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      this.zzbty.zzc(paramInt, 2);
      this.zzbty.zzba(zzvn.zza(paramzzvo, localEntry.getKey(), localEntry.getValue()));
      zzvn.zza(this.zzbty, paramzzvo, localEntry.getKey(), localEntry.getValue());
    }
  }

  public final void zza(int paramInt, Object paramObject)
    throws IOException
  {
    if ((paramObject instanceof zzte))
    {
      this.zzbty.zzb(paramInt, (zzte)paramObject);
      return;
    }
    this.zzbty.zzb(paramInt, (zzvv)paramObject);
  }

  public final void zza(int paramInt, Object paramObject, zzwl paramzzwl)
    throws IOException
  {
    this.zzbty.zza(paramInt, (zzvv)paramObject, paramzzwl);
  }

  public final void zza(int paramInt, List<String> paramList)
    throws IOException
  {
    boolean bool = paramList instanceof zzve;
    int i = 0;
    if (bool)
    {
      zzve localzzve = (zzve)paramList;
      int j = 0;
      if (j < paramList.size())
      {
        Object localObject = localzzve.zzbp(j);
        if ((localObject instanceof String))
          this.zzbty.zzb(paramInt, (String)localObject);
        while (true)
        {
          j++;
          break;
          this.zzbty.zza(paramInt, (zzte)localObject);
        }
      }
    }
    else
    {
      while (i < paramList.size())
      {
        this.zzbty.zzb(paramInt, (String)paramList.get(i));
        i++;
      }
    }
  }

  public final void zza(int paramInt, List<?> paramList, zzwl paramzzwl)
    throws IOException
  {
    for (int i = 0; i < paramList.size(); i++)
      zza(paramInt, paramList.get(i), paramzzwl);
  }

  public final void zza(int paramInt, List<Integer> paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    if (paramBoolean)
    {
      this.zzbty.zzc(paramInt, 2);
      int j = 0;
      int k = 0;
      while (j < paramList.size())
      {
        k += zztv.zzbe(((Integer)paramList.get(j)).intValue());
        j++;
      }
      this.zzbty.zzba(k);
      while (i < paramList.size())
      {
        this.zzbty.zzaz(((Integer)paramList.get(i)).intValue());
        i++;
      }
    }
    while (i < paramList.size())
    {
      this.zzbty.zzd(paramInt, ((Integer)paramList.get(i)).intValue());
      i++;
    }
  }

  public final void zzb(int paramInt, long paramLong)
    throws IOException
  {
    this.zzbty.zzb(paramInt, paramLong);
  }

  public final void zzb(int paramInt, Object paramObject, zzwl paramzzwl)
    throws IOException
  {
    zztv localzztv = this.zzbty;
    zzvv localzzvv = (zzvv)paramObject;
    localzztv.zzc(paramInt, 3);
    paramzzwl.zza(localzzvv, localzztv.zzbup);
    localzztv.zzc(paramInt, 4);
  }

  public final void zzb(int paramInt, String paramString)
    throws IOException
  {
    this.zzbty.zzb(paramInt, paramString);
  }

  public final void zzb(int paramInt, List<zzte> paramList)
    throws IOException
  {
    for (int i = 0; i < paramList.size(); i++)
      this.zzbty.zza(paramInt, (zzte)paramList.get(i));
  }

  public final void zzb(int paramInt, List<?> paramList, zzwl paramzzwl)
    throws IOException
  {
    for (int i = 0; i < paramList.size(); i++)
      zzb(paramInt, paramList.get(i), paramzzwl);
  }

  public final void zzb(int paramInt, List<Integer> paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    if (paramBoolean)
    {
      this.zzbty.zzc(paramInt, 2);
      int j = 0;
      int k = 0;
      while (j < paramList.size())
      {
        k += zztv.zzbh(((Integer)paramList.get(j)).intValue());
        j++;
      }
      this.zzbty.zzba(k);
      while (i < paramList.size())
      {
        this.zzbty.zzbc(((Integer)paramList.get(i)).intValue());
        i++;
      }
    }
    while (i < paramList.size())
    {
      this.zzbty.zzg(paramInt, ((Integer)paramList.get(i)).intValue());
      i++;
    }
  }

  public final void zzb(int paramInt, boolean paramBoolean)
    throws IOException
  {
    this.zzbty.zzb(paramInt, paramBoolean);
  }

  public final void zzbm(int paramInt)
    throws IOException
  {
    this.zzbty.zzc(paramInt, 3);
  }

  public final void zzbn(int paramInt)
    throws IOException
  {
    this.zzbty.zzc(paramInt, 4);
  }

  public final void zzc(int paramInt, long paramLong)
    throws IOException
  {
    this.zzbty.zzc(paramInt, paramLong);
  }

  public final void zzc(int paramInt, List<Long> paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    if (paramBoolean)
    {
      this.zzbty.zzc(paramInt, 2);
      int j = 0;
      int k = 0;
      while (j < paramList.size())
      {
        k += zztv.zzaw(((Long)paramList.get(j)).longValue());
        j++;
      }
      this.zzbty.zzba(k);
      while (i < paramList.size())
      {
        this.zzbty.zzat(((Long)paramList.get(i)).longValue());
        i++;
      }
    }
    while (i < paramList.size())
    {
      this.zzbty.zza(paramInt, ((Long)paramList.get(i)).longValue());
      i++;
    }
  }

  public final void zzd(int paramInt1, int paramInt2)
    throws IOException
  {
    this.zzbty.zzd(paramInt1, paramInt2);
  }

  public final void zzd(int paramInt, List<Long> paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    if (paramBoolean)
    {
      this.zzbty.zzc(paramInt, 2);
      int j = 0;
      int k = 0;
      while (j < paramList.size())
      {
        k += zztv.zzax(((Long)paramList.get(j)).longValue());
        j++;
      }
      this.zzbty.zzba(k);
      while (i < paramList.size())
      {
        this.zzbty.zzat(((Long)paramList.get(i)).longValue());
        i++;
      }
    }
    while (i < paramList.size())
    {
      this.zzbty.zza(paramInt, ((Long)paramList.get(i)).longValue());
      i++;
    }
  }

  public final void zze(int paramInt1, int paramInt2)
    throws IOException
  {
    this.zzbty.zze(paramInt1, paramInt2);
  }

  public final void zze(int paramInt, List<Long> paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    if (paramBoolean)
    {
      this.zzbty.zzc(paramInt, 2);
      int j = 0;
      int k = 0;
      while (j < paramList.size())
      {
        k += zztv.zzaz(((Long)paramList.get(j)).longValue());
        j++;
      }
      this.zzbty.zzba(k);
      while (i < paramList.size())
      {
        this.zzbty.zzav(((Long)paramList.get(i)).longValue());
        i++;
      }
    }
    while (i < paramList.size())
    {
      this.zzbty.zzc(paramInt, ((Long)paramList.get(i)).longValue());
      i++;
    }
  }

  public final void zzf(int paramInt1, int paramInt2)
    throws IOException
  {
    this.zzbty.zzf(paramInt1, paramInt2);
  }

  public final void zzf(int paramInt, List<Float> paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    if (paramBoolean)
    {
      this.zzbty.zzc(paramInt, 2);
      int j = 0;
      int k = 0;
      while (j < paramList.size())
      {
        k += zztv.zzb(((Float)paramList.get(j)).floatValue());
        j++;
      }
      this.zzbty.zzba(k);
      while (i < paramList.size())
      {
        this.zzbty.zza(((Float)paramList.get(i)).floatValue());
        i++;
      }
    }
    while (i < paramList.size())
    {
      this.zzbty.zza(paramInt, ((Float)paramList.get(i)).floatValue());
      i++;
    }
  }

  public final void zzg(int paramInt1, int paramInt2)
    throws IOException
  {
    this.zzbty.zzg(paramInt1, paramInt2);
  }

  public final void zzg(int paramInt, List<Double> paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    if (paramBoolean)
    {
      this.zzbty.zzc(paramInt, 2);
      int j = 0;
      int k = 0;
      while (j < paramList.size())
      {
        k += zztv.zzc(((Double)paramList.get(j)).doubleValue());
        j++;
      }
      this.zzbty.zzba(k);
      while (i < paramList.size())
      {
        this.zzbty.zzb(((Double)paramList.get(i)).doubleValue());
        i++;
      }
    }
    while (i < paramList.size())
    {
      this.zzbty.zza(paramInt, ((Double)paramList.get(i)).doubleValue());
      i++;
    }
  }

  public final void zzh(int paramInt, List<Integer> paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    if (paramBoolean)
    {
      this.zzbty.zzc(paramInt, 2);
      int j = 0;
      int k = 0;
      while (j < paramList.size())
      {
        k += zztv.zzbj(((Integer)paramList.get(j)).intValue());
        j++;
      }
      this.zzbty.zzba(k);
      while (i < paramList.size())
      {
        this.zzbty.zzaz(((Integer)paramList.get(i)).intValue());
        i++;
      }
    }
    while (i < paramList.size())
    {
      this.zzbty.zzd(paramInt, ((Integer)paramList.get(i)).intValue());
      i++;
    }
  }

  public final void zzi(int paramInt, long paramLong)
    throws IOException
  {
    this.zzbty.zza(paramInt, paramLong);
  }

  public final void zzi(int paramInt, List<Boolean> paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    if (paramBoolean)
    {
      this.zzbty.zzc(paramInt, 2);
      int j = 0;
      int k = 0;
      while (j < paramList.size())
      {
        k += zztv.zzt(((Boolean)paramList.get(j)).booleanValue());
        j++;
      }
      this.zzbty.zzba(k);
      while (i < paramList.size())
      {
        this.zzbty.zzs(((Boolean)paramList.get(i)).booleanValue());
        i++;
      }
    }
    while (i < paramList.size())
    {
      this.zzbty.zzb(paramInt, ((Boolean)paramList.get(i)).booleanValue());
      i++;
    }
  }

  public final void zzj(int paramInt, long paramLong)
    throws IOException
  {
    this.zzbty.zzc(paramInt, paramLong);
  }

  public final void zzj(int paramInt, List<Integer> paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    if (paramBoolean)
    {
      this.zzbty.zzc(paramInt, 2);
      int j = 0;
      int k = 0;
      while (j < paramList.size())
      {
        k += zztv.zzbf(((Integer)paramList.get(j)).intValue());
        j++;
      }
      this.zzbty.zzba(k);
      while (i < paramList.size())
      {
        this.zzbty.zzba(((Integer)paramList.get(i)).intValue());
        i++;
      }
    }
    while (i < paramList.size())
    {
      this.zzbty.zze(paramInt, ((Integer)paramList.get(i)).intValue());
      i++;
    }
  }

  public final void zzk(int paramInt, List<Integer> paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    if (paramBoolean)
    {
      this.zzbty.zzc(paramInt, 2);
      int j = 0;
      int k = 0;
      while (j < paramList.size())
      {
        k += zztv.zzbi(((Integer)paramList.get(j)).intValue());
        j++;
      }
      this.zzbty.zzba(k);
      while (i < paramList.size())
      {
        this.zzbty.zzbc(((Integer)paramList.get(i)).intValue());
        i++;
      }
    }
    while (i < paramList.size())
    {
      this.zzbty.zzg(paramInt, ((Integer)paramList.get(i)).intValue());
      i++;
    }
  }

  public final void zzl(int paramInt, List<Long> paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    if (paramBoolean)
    {
      this.zzbty.zzc(paramInt, 2);
      int j = 0;
      int k = 0;
      while (j < paramList.size())
      {
        k += zztv.zzba(((Long)paramList.get(j)).longValue());
        j++;
      }
      this.zzbty.zzba(k);
      while (i < paramList.size())
      {
        this.zzbty.zzav(((Long)paramList.get(i)).longValue());
        i++;
      }
    }
    while (i < paramList.size())
    {
      this.zzbty.zzc(paramInt, ((Long)paramList.get(i)).longValue());
      i++;
    }
  }

  public final void zzm(int paramInt, List<Integer> paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    if (paramBoolean)
    {
      this.zzbty.zzc(paramInt, 2);
      int j = 0;
      int k = 0;
      while (j < paramList.size())
      {
        k += zztv.zzbg(((Integer)paramList.get(j)).intValue());
        j++;
      }
      this.zzbty.zzba(k);
      while (i < paramList.size())
      {
        this.zzbty.zzbb(((Integer)paramList.get(i)).intValue());
        i++;
      }
    }
    while (i < paramList.size())
    {
      this.zzbty.zzf(paramInt, ((Integer)paramList.get(i)).intValue());
      i++;
    }
  }

  public final void zzn(int paramInt1, int paramInt2)
    throws IOException
  {
    this.zzbty.zzg(paramInt1, paramInt2);
  }

  public final void zzn(int paramInt, List<Long> paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    if (paramBoolean)
    {
      this.zzbty.zzc(paramInt, 2);
      int j = 0;
      int k = 0;
      while (j < paramList.size())
      {
        k += zztv.zzay(((Long)paramList.get(j)).longValue());
        j++;
      }
      this.zzbty.zzba(k);
      while (i < paramList.size())
      {
        this.zzbty.zzau(((Long)paramList.get(i)).longValue());
        i++;
      }
    }
    while (i < paramList.size())
    {
      this.zzbty.zzb(paramInt, ((Long)paramList.get(i)).longValue());
      i++;
    }
  }

  public final void zzo(int paramInt1, int paramInt2)
    throws IOException
  {
    this.zzbty.zzd(paramInt1, paramInt2);
  }

  public final int zzvm()
  {
    return zzuo.zze.zzbyx;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zztx
 * JD-Core Version:    0.6.2
 */