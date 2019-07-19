package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

final class zzwn
{
  private static final Class<?> zzcbp = zzya();
  private static final zzxd<?, ?> zzcbq = zzv(false);
  private static final zzxd<?, ?> zzcbr = zzv(true);
  private static final zzxd<?, ?> zzcbs = new zzxf();

  static <UT, UB> UB zza(int paramInt1, int paramInt2, UB paramUB, zzxd<UT, UB> paramzzxd)
  {
    if (paramUB == null)
      paramUB = paramzzxd.zzyk();
    paramzzxd.zza(paramUB, paramInt1, paramInt2);
    return paramUB;
  }

  static <UT, UB> UB zza(int paramInt, List<Integer> paramList, zzut paramzzut, UB paramUB, zzxd<UT, UB> paramzzxd)
  {
    if (paramzzut == null)
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
        if (paramzzut.zzb(n))
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
          Object localObject2 = zza(paramInt, n, localObject1, paramzzxd);
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
        if (!paramzzut.zzb(i))
        {
          paramUB = zza(paramInt, i, paramUB, paramzzxd);
          localIterator.remove();
        }
      }
      localObject1 = paramUB;
    }
  }

  public static void zza(int paramInt, List<String> paramList, zzxy paramzzxy)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty()))
      paramzzxy.zza(paramInt, paramList);
  }

  public static void zza(int paramInt, List<?> paramList, zzxy paramzzxy, zzwl paramzzwl)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty()))
      paramzzxy.zza(paramInt, paramList, paramzzwl);
  }

  public static void zza(int paramInt, List<Double> paramList, zzxy paramzzxy, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty()))
      paramzzxy.zzg(paramInt, paramList, paramBoolean);
  }

  static <T, FT extends zzuh<FT>> void zza(zzuc<FT> paramzzuc, T paramT1, T paramT2)
  {
    zzuf localzzuf = paramzzuc.zzw(paramT2);
    if (!localzzuf.isEmpty())
      paramzzuc.zzx(paramT1).zza(localzzuf);
  }

  static <T> void zza(zzvq paramzzvq, T paramT1, T paramT2, long paramLong)
  {
    zzxj.zza(paramT1, paramLong, paramzzvq.zzc(zzxj.zzp(paramT1, paramLong), zzxj.zzp(paramT2, paramLong)));
  }

  static <T, UT, UB> void zza(zzxd<UT, UB> paramzzxd, T paramT1, T paramT2)
  {
    paramzzxd.zzf(paramT1, paramzzxd.zzh(paramzzxd.zzal(paramT1), paramzzxd.zzal(paramT2)));
  }

  static int zzaa(List<Long> paramList)
  {
    int i = paramList.size();
    int j = 0;
    if (i == 0);
    while (true)
    {
      return j;
      if (!(paramList instanceof zzvj))
        break;
      zzvj localzzvj = (zzvj)paramList;
      int n = 0;
      while (n < i)
      {
        int i1 = j + zztv.zzay(localzzvj.getLong(n));
        n++;
        j = i1;
      }
    }
    int k = 0;
    int m = 0;
    while (k < i)
    {
      m += zztv.zzay(((Long)paramList.get(k)).longValue());
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
      if (!(paramList instanceof zzup))
        break;
      zzup localzzup = (zzup)paramList;
      int n = 0;
      while (n < i)
      {
        int i1 = j + zztv.zzbj(localzzup.getInt(n));
        n++;
        j = i1;
      }
    }
    int k = 0;
    int m = 0;
    while (k < i)
    {
      m += zztv.zzbj(((Integer)paramList.get(k)).intValue());
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
      if (!(paramList instanceof zzup))
        break;
      zzup localzzup = (zzup)paramList;
      int n = 0;
      while (n < i)
      {
        int i1 = j + zztv.zzbe(localzzup.getInt(n));
        n++;
        j = i1;
      }
    }
    int k = 0;
    int m = 0;
    while (k < i)
    {
      m += zztv.zzbe(((Integer)paramList.get(k)).intValue());
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
      if (!(paramList instanceof zzup))
        break;
      zzup localzzup = (zzup)paramList;
      int n = 0;
      while (n < i)
      {
        int i1 = j + zztv.zzbf(localzzup.getInt(n));
        n++;
        j = i1;
      }
    }
    int k = 0;
    int m = 0;
    while (k < i)
    {
      m += zztv.zzbf(((Integer)paramList.get(k)).intValue());
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
      if (!(paramList instanceof zzup))
        break;
      zzup localzzup = (zzup)paramList;
      int n = 0;
      while (n < i)
      {
        int i1 = j + zztv.zzbg(localzzup.getInt(n));
        n++;
        j = i1;
      }
    }
    int k = 0;
    int m = 0;
    while (k < i)
    {
      m += zztv.zzbg(((Integer)paramList.get(k)).intValue());
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

  public static void zzb(int paramInt, List<zzte> paramList, zzxy paramzzxy)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty()))
      paramzzxy.zzb(paramInt, paramList);
  }

  public static void zzb(int paramInt, List<?> paramList, zzxy paramzzxy, zzwl paramzzwl)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty()))
      paramzzxy.zzb(paramInt, paramList, paramzzwl);
  }

  public static void zzb(int paramInt, List<Float> paramList, zzxy paramzzxy, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty()))
      paramzzxy.zzf(paramInt, paramList, paramBoolean);
  }

  static int zzc(int paramInt, Object paramObject, zzwl paramzzwl)
  {
    if ((paramObject instanceof zzvc))
      return zztv.zza(paramInt, (zzvc)paramObject);
    return zztv.zzb(paramInt, (zzvv)paramObject, paramzzwl);
  }

  static int zzc(int paramInt, List<?> paramList)
  {
    int i = paramList.size();
    if (i == 0)
      return 0;
    int j = i * zztv.zzbd(paramInt);
    if ((paramList instanceof zzve))
    {
      zzve localzzve = (zzve)paramList;
      int n = 0;
      if (n < i)
      {
        Object localObject2 = localzzve.zzbp(n);
        if ((localObject2 instanceof zzte));
        for (int i1 = j + zztv.zzb((zzte)localObject2); ; i1 = j + zztv.zzgc((String)localObject2))
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
      if ((localObject1 instanceof zzte));
      for (int m = j + zztv.zzb((zzte)localObject1); ; m = j + zztv.zzgc((String)localObject1))
      {
        k++;
        j = m;
        break;
      }
    }
    return j;
  }

  static int zzc(int paramInt, List<?> paramList, zzwl paramzzwl)
  {
    int i = paramList.size();
    if (i == 0)
      return 0;
    int j = i * zztv.zzbd(paramInt);
    int k = 0;
    if (k < i)
    {
      Object localObject = paramList.get(k);
      if ((localObject instanceof zzvc));
      for (int m = j + zztv.zza((zzvc)localObject); ; m = j + zztv.zzb((zzvv)localObject, paramzzwl))
      {
        k++;
        j = m;
        break;
      }
    }
    return j;
  }

  public static void zzc(int paramInt, List<Long> paramList, zzxy paramzzxy, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty()))
      paramzzxy.zzc(paramInt, paramList, paramBoolean);
  }

  static int zzd(int paramInt, List<zzte> paramList)
  {
    int i = paramList.size();
    if (i == 0)
      return 0;
    int j = i * zztv.zzbd(paramInt);
    for (int k = 0; k < paramList.size(); k++)
      j += zztv.zzb((zzte)paramList.get(k));
    return j;
  }

  static int zzd(int paramInt, List<zzvv> paramList, zzwl paramzzwl)
  {
    int i = paramList.size();
    if (i == 0)
      return 0;
    int j = 0;
    int k = 0;
    while (j < i)
    {
      k += zztv.zzc(paramInt, (zzvv)paramList.get(j), paramzzwl);
      j++;
    }
    return k;
  }

  public static void zzd(int paramInt, List<Long> paramList, zzxy paramzzxy, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty()))
      paramzzxy.zzd(paramInt, paramList, paramBoolean);
  }

  public static void zze(int paramInt, List<Long> paramList, zzxy paramzzxy, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty()))
      paramzzxy.zzn(paramInt, paramList, paramBoolean);
  }

  static boolean zze(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }

  public static void zzf(int paramInt, List<Long> paramList, zzxy paramzzxy, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty()))
      paramzzxy.zze(paramInt, paramList, paramBoolean);
  }

  public static void zzg(int paramInt, List<Long> paramList, zzxy paramzzxy, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty()))
      paramzzxy.zzl(paramInt, paramList, paramBoolean);
  }

  public static void zzh(int paramInt, List<Integer> paramList, zzxy paramzzxy, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty()))
      paramzzxy.zza(paramInt, paramList, paramBoolean);
  }

  public static void zzi(int paramInt, List<Integer> paramList, zzxy paramzzxy, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty()))
      paramzzxy.zzj(paramInt, paramList, paramBoolean);
  }

  public static void zzj(int paramInt, List<Integer> paramList, zzxy paramzzxy, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty()))
      paramzzxy.zzm(paramInt, paramList, paramBoolean);
  }

  public static void zzj(Class<?> paramClass)
  {
    if ((!zzuo.class.isAssignableFrom(paramClass)) && (zzcbp != null) && (!zzcbp.isAssignableFrom(paramClass)))
      throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
  }

  public static void zzk(int paramInt, List<Integer> paramList, zzxy paramzzxy, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty()))
      paramzzxy.zzb(paramInt, paramList, paramBoolean);
  }

  public static void zzl(int paramInt, List<Integer> paramList, zzxy paramzzxy, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty()))
      paramzzxy.zzk(paramInt, paramList, paramBoolean);
  }

  public static void zzm(int paramInt, List<Integer> paramList, zzxy paramzzxy, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty()))
      paramzzxy.zzh(paramInt, paramList, paramBoolean);
  }

  public static void zzn(int paramInt, List<Boolean> paramList, zzxy paramzzxy, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty()))
      paramzzxy.zzi(paramInt, paramList, paramBoolean);
  }

  static int zzo(int paramInt, List<Long> paramList, boolean paramBoolean)
  {
    if (paramList.size() == 0)
      return 0;
    return zzy(paramList) + paramList.size() * zztv.zzbd(paramInt);
  }

  static int zzp(int paramInt, List<Long> paramList, boolean paramBoolean)
  {
    int i = paramList.size();
    if (i == 0)
      return 0;
    return zzz(paramList) + i * zztv.zzbd(paramInt);
  }

  static int zzq(int paramInt, List<Long> paramList, boolean paramBoolean)
  {
    int i = paramList.size();
    if (i == 0)
      return 0;
    return zzaa(paramList) + i * zztv.zzbd(paramInt);
  }

  static int zzr(int paramInt, List<Integer> paramList, boolean paramBoolean)
  {
    int i = paramList.size();
    if (i == 0)
      return 0;
    return zzab(paramList) + i * zztv.zzbd(paramInt);
  }

  static int zzs(int paramInt, List<Integer> paramList, boolean paramBoolean)
  {
    int i = paramList.size();
    if (i == 0)
      return 0;
    return zzac(paramList) + i * zztv.zzbd(paramInt);
  }

  static int zzt(int paramInt, List<Integer> paramList, boolean paramBoolean)
  {
    int i = paramList.size();
    if (i == 0)
      return 0;
    return zzad(paramList) + i * zztv.zzbd(paramInt);
  }

  static int zzu(int paramInt, List<Integer> paramList, boolean paramBoolean)
  {
    int i = paramList.size();
    if (i == 0)
      return 0;
    return zzae(paramList) + i * zztv.zzbd(paramInt);
  }

  static int zzv(int paramInt, List<?> paramList, boolean paramBoolean)
  {
    int i = paramList.size();
    if (i == 0)
      return 0;
    return i * zztv.zzk(paramInt, 0);
  }

  private static zzxd<?, ?> zzv(boolean paramBoolean)
  {
    try
    {
      Class localClass = zzyb();
      if (localClass == null)
        return null;
      Class[] arrayOfClass = new Class[1];
      arrayOfClass[0] = Boolean.TYPE;
      Constructor localConstructor = localClass.getConstructor(arrayOfClass);
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Boolean.valueOf(paramBoolean);
      zzxd localzzxd = (zzxd)localConstructor.newInstance(arrayOfObject);
      return localzzxd;
    }
    catch (Throwable localThrowable)
    {
    }
    return null;
  }

  static int zzw(int paramInt, List<?> paramList, boolean paramBoolean)
  {
    int i = paramList.size();
    if (i == 0)
      return 0;
    return i * zztv.zzg(paramInt, 0L);
  }

  static int zzx(int paramInt, List<?> paramList, boolean paramBoolean)
  {
    int i = paramList.size();
    if (i == 0)
      return 0;
    return i * zztv.zzc(paramInt, true);
  }

  public static zzxd<?, ?> zzxx()
  {
    return zzcbq;
  }

  public static zzxd<?, ?> zzxy()
  {
    return zzcbr;
  }

  public static zzxd<?, ?> zzxz()
  {
    return zzcbs;
  }

  static int zzy(List<Long> paramList)
  {
    int i = paramList.size();
    int j = 0;
    if (i == 0);
    while (true)
    {
      return j;
      if (!(paramList instanceof zzvj))
        break;
      zzvj localzzvj = (zzvj)paramList;
      int n = 0;
      while (n < i)
      {
        int i1 = j + zztv.zzaw(localzzvj.getLong(n));
        n++;
        j = i1;
      }
    }
    int k = 0;
    int m = 0;
    while (k < i)
    {
      m += zztv.zzaw(((Long)paramList.get(k)).longValue());
      k++;
    }
    return m;
  }

  private static Class<?> zzya()
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

  private static Class<?> zzyb()
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

  static int zzz(List<Long> paramList)
  {
    int i = paramList.size();
    int j = 0;
    if (i == 0);
    while (true)
    {
      return j;
      if (!(paramList instanceof zzvj))
        break;
      zzvj localzzvj = (zzvj)paramList;
      int n = 0;
      while (n < i)
      {
        int i1 = j + zztv.zzax(localzzvj.getLong(n));
        n++;
        j = i1;
      }
    }
    int k = 0;
    int m = 0;
    while (k < i)
    {
      m += zztv.zzax(((Long)paramList.get(k)).longValue());
      k++;
    }
    return m;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzwn
 * JD-Core Version:    0.6.2
 */