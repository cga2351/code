package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

final class zzdqc
{
  private static final Class<?> zzhkn = zzazn();
  private static final zzdqs<?, ?> zzhko = zzbi(false);
  private static final zzdqs<?, ?> zzhkp = zzbi(true);
  private static final zzdqs<?, ?> zzhkq = new zzdqu();

  static <UT, UB> UB zza(int paramInt1, int paramInt2, UB paramUB, zzdqs<UT, UB> paramzzdqs)
  {
    if (paramUB == null)
      paramUB = paramzzdqs.zzazy();
    paramzzdqs.zza(paramUB, paramInt1, paramInt2);
    return paramUB;
  }

  static <UT, UB> UB zza(int paramInt, List<Integer> paramList, zzdof paramzzdof, UB paramUB, zzdqs<UT, UB> paramzzdqs)
  {
    if (paramzzdof == null)
      return paramUB;
    Object localObject1;
    if ((paramList instanceof RandomAccess))
    {
      int j = paramList.size();
      int k = 0;
      int m = 0;
      localObject1 = paramUB;
      if (k < j)
      {
        int n = ((Integer)paramList.get(k)).intValue();
        int i2;
        Object localObject3;
        if (paramzzdof.zzf(n))
        {
          if (k != m)
            paramList.set(m, Integer.valueOf(n));
          i2 = m + 1;
          localObject3 = localObject1;
        }
        while (true)
        {
          k++;
          localObject1 = localObject3;
          m = i2;
          break;
          Object localObject2 = zza(paramInt, n, localObject1, paramzzdqs);
          int i1 = m;
          localObject3 = localObject2;
          i2 = i1;
        }
      }
      if (m != j)
        paramList.subList(m, j).clear();
    }
    while (true)
    {
      return localObject1;
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        int i = ((Integer)localIterator.next()).intValue();
        if (!paramzzdof.zzf(i))
        {
          paramUB = zza(paramInt, i, paramUB, paramzzdqs);
          localIterator.remove();
        }
      }
      localObject1 = paramUB;
    }
  }

  public static void zza(int paramInt, List<String> paramList, zzdrn paramzzdrn)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty()))
      paramzzdrn.zza(paramInt, paramList);
  }

  public static void zza(int paramInt, List<?> paramList, zzdrn paramzzdrn, zzdqa paramzzdqa)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty()))
      paramzzdrn.zza(paramInt, paramList, paramzzdqa);
  }

  public static void zza(int paramInt, List<Double> paramList, zzdrn paramzzdrn, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty()))
      paramzzdrn.zzg(paramInt, paramList, paramBoolean);
  }

  static <T, FT extends zzdnt<FT>> void zza(zzdno<FT> paramzzdno, T paramT1, T paramT2)
  {
    zzdnr localzzdnr = paramzzdno.zzy(paramT2);
    if (!localzzdnr.isEmpty())
      paramzzdno.zzz(paramT1).zza(localzzdnr);
  }

  static <T> void zza(zzdpe paramzzdpe, T paramT1, T paramT2, long paramLong)
  {
    zzdqy.zza(paramT1, paramLong, paramzzdpe.zzc(zzdqy.zzp(paramT1, paramLong), zzdqy.zzp(paramT2, paramLong)));
  }

  static <T, UT, UB> void zza(zzdqs<UT, UB> paramzzdqs, T paramT1, T paramT2)
  {
    paramzzdqs.zzf(paramT1, paramzzdqs.zzh(paramzzdqs.zzao(paramT1), paramzzdqs.zzao(paramT2)));
  }

  static int zzaa(List<Long> paramList)
  {
    int i = paramList.size();
    int j = 0;
    if (i == 0);
    while (true)
    {
      return j;
      if (!(paramList instanceof zzdox))
        break;
      zzdox localzzdox = (zzdox)paramList;
      int n = 0;
      while (n < i)
      {
        int i1 = j + zzdnh.zzfo(localzzdox.getLong(n));
        n++;
        j = i1;
      }
    }
    int k = 0;
    int m = 0;
    while (k < i)
    {
      m += zzdnh.zzfo(((Long)paramList.get(k)).longValue());
      k++;
    }
    return m;
  }

  static int zzab(List<Integer> paramList)
  {
    int i = paramList.size();
    int j = 0;
    if (i == 0);
    while (true)
    {
      return j;
      if (!(paramList instanceof zzdob))
        break;
      zzdob localzzdob = (zzdob)paramList;
      int n = 0;
      while (n < i)
      {
        int i1 = j + zzdnh.zzgj(localzzdob.getInt(n));
        n++;
        j = i1;
      }
    }
    int k = 0;
    int m = 0;
    while (k < i)
    {
      m += zzdnh.zzgj(((Integer)paramList.get(k)).intValue());
      k++;
    }
    return m;
  }

  static int zzac(List<Integer> paramList)
  {
    int i = paramList.size();
    int j = 0;
    if (i == 0);
    while (true)
    {
      return j;
      if (!(paramList instanceof zzdob))
        break;
      zzdob localzzdob = (zzdob)paramList;
      int n = 0;
      while (n < i)
      {
        int i1 = j + zzdnh.zzge(localzzdob.getInt(n));
        n++;
        j = i1;
      }
    }
    int k = 0;
    int m = 0;
    while (k < i)
    {
      m += zzdnh.zzge(((Integer)paramList.get(k)).intValue());
      k++;
    }
    return m;
  }

  static int zzad(List<Integer> paramList)
  {
    int i = paramList.size();
    int j = 0;
    if (i == 0);
    while (true)
    {
      return j;
      if (!(paramList instanceof zzdob))
        break;
      zzdob localzzdob = (zzdob)paramList;
      int n = 0;
      while (n < i)
      {
        int i1 = j + zzdnh.zzgf(localzzdob.getInt(n));
        n++;
        j = i1;
      }
    }
    int k = 0;
    int m = 0;
    while (k < i)
    {
      m += zzdnh.zzgf(((Integer)paramList.get(k)).intValue());
      k++;
    }
    return m;
  }

  static int zzae(List<Integer> paramList)
  {
    int i = paramList.size();
    int j = 0;
    if (i == 0);
    while (true)
    {
      return j;
      if (!(paramList instanceof zzdob))
        break;
      zzdob localzzdob = (zzdob)paramList;
      int n = 0;
      while (n < i)
      {
        int i1 = j + zzdnh.zzgg(localzzdob.getInt(n));
        n++;
        j = i1;
      }
    }
    int k = 0;
    int m = 0;
    while (k < i)
    {
      m += zzdnh.zzgg(((Integer)paramList.get(k)).intValue());
      k++;
    }
    return m;
  }

  static int zzaf(List<?> paramList)
  {
    return paramList.size() << 2;
  }

  static int zzag(List<?> paramList)
  {
    return paramList.size() << 3;
  }

  static int zzah(List<?> paramList)
  {
    return paramList.size();
  }

  public static zzdqs<?, ?> zzazk()
  {
    return zzhko;
  }

  public static zzdqs<?, ?> zzazl()
  {
    return zzhkp;
  }

  public static zzdqs<?, ?> zzazm()
  {
    return zzhkq;
  }

  private static Class<?> zzazn()
  {
    try
    {
      Class localClass = Class.forName("com.google.protobuf.GeneratedMessage");
      return localClass;
    }
    catch (Throwable localThrowable)
    {
    }
    return null;
  }

  private static Class<?> zzazo()
  {
    try
    {
      Class localClass = Class.forName("com.google.protobuf.UnknownFieldSetSchema");
      return localClass;
    }
    catch (Throwable localThrowable)
    {
    }
    return null;
  }

  public static void zzb(int paramInt, List<zzdmq> paramList, zzdrn paramzzdrn)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty()))
      paramzzdrn.zzb(paramInt, paramList);
  }

  public static void zzb(int paramInt, List<?> paramList, zzdrn paramzzdrn, zzdqa paramzzdqa)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty()))
      paramzzdrn.zzb(paramInt, paramList, paramzzdqa);
  }

  public static void zzb(int paramInt, List<Float> paramList, zzdrn paramzzdrn, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty()))
      paramzzdrn.zzf(paramInt, paramList, paramBoolean);
  }

  private static zzdqs<?, ?> zzbi(boolean paramBoolean)
  {
    try
    {
      Class localClass = zzazo();
      if (localClass == null)
        return null;
      Class[] arrayOfClass = new Class[1];
      arrayOfClass[0] = Boolean.TYPE;
      Constructor localConstructor = localClass.getConstructor(arrayOfClass);
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Boolean.valueOf(paramBoolean);
      zzdqs localzzdqs = (zzdqs)localConstructor.newInstance(arrayOfObject);
      return localzzdqs;
    }
    catch (Throwable localThrowable)
    {
    }
    return null;
  }

  static int zzc(int paramInt, Object paramObject, zzdqa paramzzdqa)
  {
    if ((paramObject instanceof zzdoq))
      return zzdnh.zza(paramInt, (zzdoq)paramObject);
    return zzdnh.zzb(paramInt, (zzdpj)paramObject, paramzzdqa);
  }

  static int zzc(int paramInt, List<?> paramList)
  {
    int i = paramList.size();
    if (i == 0)
      return 0;
    int j = i * zzdnh.zzgd(paramInt);
    if ((paramList instanceof zzdos))
    {
      zzdos localzzdos = (zzdos)paramList;
      int n = 0;
      if (n < i)
      {
        Object localObject2 = localzzdos.zzgq(n);
        if ((localObject2 instanceof zzdmq));
        for (int i1 = j + zzdnh.zzda((zzdmq)localObject2); ; i1 = j + zzdnh.zzgx((String)localObject2))
        {
          n++;
          j = i1;
          break;
        }
      }
      return j;
    }
    int k = 0;
    if (k < i)
    {
      Object localObject1 = paramList.get(k);
      if ((localObject1 instanceof zzdmq));
      for (int m = j + zzdnh.zzda((zzdmq)localObject1); ; m = j + zzdnh.zzgx((String)localObject1))
      {
        k++;
        j = m;
        break;
      }
    }
    return j;
  }

  static int zzc(int paramInt, List<?> paramList, zzdqa paramzzdqa)
  {
    int i = paramList.size();
    if (i == 0)
      return 0;
    int j = i * zzdnh.zzgd(paramInt);
    int k = 0;
    if (k < i)
    {
      Object localObject = paramList.get(k);
      if ((localObject instanceof zzdoq));
      for (int m = j + zzdnh.zza((zzdoq)localObject); ; m = j + zzdnh.zzb((zzdpj)localObject, paramzzdqa))
      {
        k++;
        j = m;
        break;
      }
    }
    return j;
  }

  public static void zzc(int paramInt, List<Long> paramList, zzdrn paramzzdrn, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty()))
      paramzzdrn.zzc(paramInt, paramList, paramBoolean);
  }

  static int zzd(int paramInt, List<zzdmq> paramList)
  {
    int i = paramList.size();
    if (i == 0)
      return 0;
    int j = i * zzdnh.zzgd(paramInt);
    for (int k = 0; k < paramList.size(); k++)
      j += zzdnh.zzda((zzdmq)paramList.get(k));
    return j;
  }

  static int zzd(int paramInt, List<zzdpj> paramList, zzdqa paramzzdqa)
  {
    int i = paramList.size();
    if (i == 0)
      return 0;
    int j = 0;
    int k = 0;
    while (j < i)
    {
      k += zzdnh.zzc(paramInt, (zzdpj)paramList.get(j), paramzzdqa);
      j++;
    }
    return k;
  }

  public static void zzd(int paramInt, List<Long> paramList, zzdrn paramzzdrn, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty()))
      paramzzdrn.zzd(paramInt, paramList, paramBoolean);
  }

  public static void zze(int paramInt, List<Long> paramList, zzdrn paramzzdrn, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty()))
      paramzzdrn.zzn(paramInt, paramList, paramBoolean);
  }

  static boolean zze(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }

  public static void zzf(int paramInt, List<Long> paramList, zzdrn paramzzdrn, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty()))
      paramzzdrn.zze(paramInt, paramList, paramBoolean);
  }

  public static void zzg(int paramInt, List<Long> paramList, zzdrn paramzzdrn, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty()))
      paramzzdrn.zzl(paramInt, paramList, paramBoolean);
  }

  public static void zzh(int paramInt, List<Integer> paramList, zzdrn paramzzdrn, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty()))
      paramzzdrn.zza(paramInt, paramList, paramBoolean);
  }

  public static void zzh(Class<?> paramClass)
  {
    if ((!zzdoa.class.isAssignableFrom(paramClass)) && (zzhkn != null) && (!zzhkn.isAssignableFrom(paramClass)))
      throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
  }

  public static void zzi(int paramInt, List<Integer> paramList, zzdrn paramzzdrn, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty()))
      paramzzdrn.zzj(paramInt, paramList, paramBoolean);
  }

  public static void zzj(int paramInt, List<Integer> paramList, zzdrn paramzzdrn, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty()))
      paramzzdrn.zzm(paramInt, paramList, paramBoolean);
  }

  public static void zzk(int paramInt, List<Integer> paramList, zzdrn paramzzdrn, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty()))
      paramzzdrn.zzb(paramInt, paramList, paramBoolean);
  }

  public static void zzl(int paramInt, List<Integer> paramList, zzdrn paramzzdrn, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty()))
      paramzzdrn.zzk(paramInt, paramList, paramBoolean);
  }

  public static void zzm(int paramInt, List<Integer> paramList, zzdrn paramzzdrn, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty()))
      paramzzdrn.zzh(paramInt, paramList, paramBoolean);
  }

  public static void zzn(int paramInt, List<Boolean> paramList, zzdrn paramzzdrn, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty()))
      paramzzdrn.zzi(paramInt, paramList, paramBoolean);
  }

  static int zzo(int paramInt, List<Long> paramList, boolean paramBoolean)
  {
    if (paramList.size() == 0)
      return 0;
    return zzy(paramList) + paramList.size() * zzdnh.zzgd(paramInt);
  }

  static int zzp(int paramInt, List<Long> paramList, boolean paramBoolean)
  {
    int i = paramList.size();
    if (i == 0)
      return 0;
    return zzz(paramList) + i * zzdnh.zzgd(paramInt);
  }

  static int zzq(int paramInt, List<Long> paramList, boolean paramBoolean)
  {
    int i = paramList.size();
    if (i == 0)
      return 0;
    return zzaa(paramList) + i * zzdnh.zzgd(paramInt);
  }

  static int zzr(int paramInt, List<Integer> paramList, boolean paramBoolean)
  {
    int i = paramList.size();
    if (i == 0)
      return 0;
    return zzab(paramList) + i * zzdnh.zzgd(paramInt);
  }

  static int zzs(int paramInt, List<Integer> paramList, boolean paramBoolean)
  {
    int i = paramList.size();
    if (i == 0)
      return 0;
    return zzac(paramList) + i * zzdnh.zzgd(paramInt);
  }

  static int zzt(int paramInt, List<Integer> paramList, boolean paramBoolean)
  {
    int i = paramList.size();
    if (i == 0)
      return 0;
    return zzad(paramList) + i * zzdnh.zzgd(paramInt);
  }

  static int zzu(int paramInt, List<Integer> paramList, boolean paramBoolean)
  {
    int i = paramList.size();
    if (i == 0)
      return 0;
    return zzae(paramList) + i * zzdnh.zzgd(paramInt);
  }

  static int zzv(int paramInt, List<?> paramList, boolean paramBoolean)
  {
    int i = paramList.size();
    if (i == 0)
      return 0;
    return i * zzdnh.zzae(paramInt, 0);
  }

  static int zzw(int paramInt, List<?> paramList, boolean paramBoolean)
  {
    int i = paramList.size();
    if (i == 0)
      return 0;
    return i * zzdnh.zzn(paramInt, 0L);
  }

  static int zzx(int paramInt, List<?> paramList, boolean paramBoolean)
  {
    int i = paramList.size();
    if (i == 0)
      return 0;
    return i * zzdnh.zzj(paramInt, true);
  }

  static int zzy(List<Long> paramList)
  {
    int i = paramList.size();
    int j = 0;
    if (i == 0);
    while (true)
    {
      return j;
      if (!(paramList instanceof zzdox))
        break;
      zzdox localzzdox = (zzdox)paramList;
      int n = 0;
      while (n < i)
      {
        int i1 = j + zzdnh.zzfm(localzzdox.getLong(n));
        n++;
        j = i1;
      }
    }
    int k = 0;
    int m = 0;
    while (k < i)
    {
      m += zzdnh.zzfm(((Long)paramList.get(k)).longValue());
      k++;
    }
    return m;
  }

  static int zzz(List<Long> paramList)
  {
    int i = paramList.size();
    int j = 0;
    if (i == 0);
    while (true)
    {
      return j;
      if (!(paramList instanceof zzdox))
        break;
      zzdox localzzdox = (zzdox)paramList;
      int n = 0;
      while (n < i)
      {
        int i1 = j + zzdnh.zzfn(localzzdox.getLong(n));
        n++;
        j = i1;
      }
    }
    int k = 0;
    int m = 0;
    while (k < i)
    {
      m += zzdnh.zzfn(((Long)paramList.get(k)).longValue());
      k++;
    }
    return m;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdqc
 * JD-Core Version:    0.6.2
 */