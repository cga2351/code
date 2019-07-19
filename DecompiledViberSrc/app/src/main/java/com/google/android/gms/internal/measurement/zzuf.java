package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

final class zzuf<FieldDescriptorType extends zzuh<FieldDescriptorType>>
{
  private static final zzuf zzbvl = new zzuf(true);
  private boolean zzbqa;
  private final zzwo<FieldDescriptorType, Object> zzbvj;
  private boolean zzbvk = false;

  private zzuf()
  {
    this.zzbvj = zzwo.zzbw(16);
  }

  private zzuf(boolean paramBoolean)
  {
    this.zzbvj = zzwo.zzbw(0);
    zzsw();
  }

  static int zza(zzxs paramzzxs, int paramInt, Object paramObject)
  {
    int i = zztv.zzbd(paramInt);
    if (paramzzxs == zzxs.zzcds)
      zzuq.zzf((zzvv)paramObject);
    for (int j = i << 1; ; j = i)
      return j + zzb(paramzzxs, paramObject);
  }

  private final Object zza(FieldDescriptorType paramFieldDescriptorType)
  {
    Object localObject = this.zzbvj.get(paramFieldDescriptorType);
    if ((localObject instanceof zzuy))
      localObject = zzuy.zzwz();
    return localObject;
  }

  static void zza(zztv paramzztv, zzxs paramzzxs, int paramInt, Object paramObject)
    throws IOException
  {
    if (paramzzxs == zzxs.zzcds)
    {
      zzuq.zzf((zzvv)paramObject);
      zzvv localzzvv = (zzvv)paramObject;
      paramzztv.zzc(paramInt, 3);
      localzzvv.zzb(paramzztv);
      paramzztv.zzc(paramInt, 4);
      return;
    }
    paramzztv.zzc(paramInt, paramzzxs.zzyw());
    switch (zzug.zzbun[paramzzxs.ordinal()])
    {
    default:
      return;
    case 1:
      paramzztv.zzb(((Double)paramObject).doubleValue());
      return;
    case 2:
      paramzztv.zza(((Float)paramObject).floatValue());
      return;
    case 3:
      paramzztv.zzat(((Long)paramObject).longValue());
      return;
    case 4:
      paramzztv.zzat(((Long)paramObject).longValue());
      return;
    case 5:
      paramzztv.zzaz(((Integer)paramObject).intValue());
      return;
    case 6:
      paramzztv.zzav(((Long)paramObject).longValue());
      return;
    case 7:
      paramzztv.zzbc(((Integer)paramObject).intValue());
      return;
    case 8:
      paramzztv.zzs(((Boolean)paramObject).booleanValue());
      return;
    case 9:
      ((zzvv)paramObject).zzb(paramzztv);
      return;
    case 10:
      paramzztv.zzb((zzvv)paramObject);
      return;
    case 11:
      if ((paramObject instanceof zzte))
      {
        paramzztv.zza((zzte)paramObject);
        return;
      }
      paramzztv.zzgb((String)paramObject);
      return;
    case 12:
      if ((paramObject instanceof zzte))
      {
        paramzztv.zza((zzte)paramObject);
        return;
      }
      byte[] arrayOfByte = (byte[])paramObject;
      paramzztv.zze(arrayOfByte, 0, arrayOfByte.length);
      return;
    case 13:
      paramzztv.zzba(((Integer)paramObject).intValue());
      return;
    case 14:
      paramzztv.zzbc(((Integer)paramObject).intValue());
      return;
    case 15:
      paramzztv.zzav(((Long)paramObject).longValue());
      return;
    case 16:
      paramzztv.zzbb(((Integer)paramObject).intValue());
      return;
    case 17:
      paramzztv.zzau(((Long)paramObject).longValue());
      return;
    case 18:
    }
    if ((paramObject instanceof zzur))
    {
      paramzztv.zzaz(((zzur)paramObject).zzc());
      return;
    }
    paramzztv.zzaz(((Integer)paramObject).intValue());
  }

  private final void zza(FieldDescriptorType paramFieldDescriptorType, Object paramObject)
  {
    if (paramFieldDescriptorType.zzwb())
    {
      if (!(paramObject instanceof List))
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
      localObject1 = new ArrayList();
      ((List)localObject1).addAll((List)paramObject);
      ArrayList localArrayList = (ArrayList)localObject1;
      int i = localArrayList.size();
      int j = 0;
      while (j < i)
      {
        Object localObject2 = localArrayList.get(j);
        j++;
        zza(paramFieldDescriptorType.zzvz(), localObject2);
      }
    }
    zza(paramFieldDescriptorType.zzvz(), paramObject);
    Object localObject1 = paramObject;
    if ((localObject1 instanceof zzuy))
      this.zzbvk = true;
    this.zzbvj.zza(paramFieldDescriptorType, localObject1);
  }

  private static void zza(zzxs paramzzxs, Object paramObject)
  {
    zzuq.checkNotNull(paramObject);
    int i = zzug.zzbvm[paramzzxs.zzyv().ordinal()];
    boolean bool1 = false;
    switch (i)
    {
    default:
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
    case 6:
    case 7:
    case 8:
    case 9:
    }
    while (!bool1)
    {
      throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
      bool1 = paramObject instanceof Integer;
      continue;
      bool1 = paramObject instanceof Long;
      continue;
      bool1 = paramObject instanceof Float;
      continue;
      bool1 = paramObject instanceof Double;
      continue;
      bool1 = paramObject instanceof Boolean;
      continue;
      bool1 = paramObject instanceof String;
      continue;
      if (!(paramObject instanceof zzte))
      {
        boolean bool4 = paramObject instanceof byte[];
        bool1 = false;
        if (!bool4);
      }
      else
      {
        bool1 = true;
        continue;
        if (!(paramObject instanceof Integer))
        {
          boolean bool3 = paramObject instanceof zzur;
          bool1 = false;
          if (!bool3);
        }
        else
        {
          bool1 = true;
          continue;
          if (!(paramObject instanceof zzvv))
          {
            boolean bool2 = paramObject instanceof zzuy;
            bool1 = false;
            if (!bool2);
          }
          else
          {
            bool1 = true;
          }
        }
      }
    }
  }

  private static int zzb(zzuh<?> paramzzuh, Object paramObject)
  {
    int i = 0;
    zzxs localzzxs = paramzzuh.zzvz();
    int j = paramzzuh.zzc();
    if (paramzzuh.zzwb())
    {
      if (paramzzuh.zzwc())
      {
        Iterator localIterator2 = ((List)paramObject).iterator();
        while (localIterator2.hasNext())
          i += zzb(localzzxs, localIterator2.next());
        i = i + zztv.zzbd(j) + zztv.zzbl(i);
      }
      while (true)
      {
        return i;
        Iterator localIterator1 = ((List)paramObject).iterator();
        while (localIterator1.hasNext())
          i += zza(localzzxs, j, localIterator1.next());
      }
    }
    return zza(localzzxs, j, paramObject);
  }

  private static int zzb(zzxs paramzzxs, Object paramObject)
  {
    switch (zzug.zzbun[paramzzxs.ordinal()])
    {
    default:
      throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
    case 1:
      return zztv.zzc(((Double)paramObject).doubleValue());
    case 2:
      return zztv.zzb(((Float)paramObject).floatValue());
    case 3:
      return zztv.zzaw(((Long)paramObject).longValue());
    case 4:
      return zztv.zzax(((Long)paramObject).longValue());
    case 5:
      return zztv.zzbe(((Integer)paramObject).intValue());
    case 6:
      return zztv.zzaz(((Long)paramObject).longValue());
    case 7:
      return zztv.zzbh(((Integer)paramObject).intValue());
    case 8:
      return zztv.zzt(((Boolean)paramObject).booleanValue());
    case 9:
      return zztv.zzd((zzvv)paramObject);
    case 12:
      if ((paramObject instanceof zzte))
        return zztv.zzb((zzte)paramObject);
      return zztv.zzk((byte[])paramObject);
    case 11:
      if ((paramObject instanceof zzte))
        return zztv.zzb((zzte)paramObject);
      return zztv.zzgc((String)paramObject);
    case 13:
      return zztv.zzbf(((Integer)paramObject).intValue());
    case 14:
      return zztv.zzbi(((Integer)paramObject).intValue());
    case 15:
      return zztv.zzba(((Long)paramObject).longValue());
    case 16:
      return zztv.zzbg(((Integer)paramObject).intValue());
    case 17:
      return zztv.zzay(((Long)paramObject).longValue());
    case 10:
      if ((paramObject instanceof zzuy))
        return zztv.zza((zzuy)paramObject);
      return zztv.zzc((zzvv)paramObject);
    case 18:
    }
    if ((paramObject instanceof zzur))
      return zztv.zzbj(((zzur)paramObject).zzc());
    return zztv.zzbj(((Integer)paramObject).intValue());
  }

  private static boolean zzc(Map.Entry<FieldDescriptorType, Object> paramEntry)
  {
    zzuh localzzuh = (zzuh)paramEntry.getKey();
    if (localzzuh.zzwa() == zzxx.zzcem)
    {
      if (localzzuh.zzwb())
      {
        Iterator localIterator = ((List)paramEntry.getValue()).iterator();
        do
          if (!localIterator.hasNext())
            break;
        while (((zzvv)localIterator.next()).isInitialized());
        return false;
      }
      Object localObject = paramEntry.getValue();
      if ((localObject instanceof zzvv))
      {
        if (!((zzvv)localObject).isInitialized())
          return false;
      }
      else
      {
        if ((localObject instanceof zzuy))
          return true;
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
      }
    }
    return true;
  }

  private final void zzd(Map.Entry<FieldDescriptorType, Object> paramEntry)
  {
    zzuh localzzuh = (zzuh)paramEntry.getKey();
    Object localObject1 = paramEntry.getValue();
    if ((localObject1 instanceof zzuy))
      localObject1 = zzuy.zzwz();
    if (localzzuh.zzwb())
    {
      Object localObject4 = zza(localzzuh);
      if (localObject4 == null)
        localObject4 = new ArrayList();
      Iterator localIterator = ((List)localObject1).iterator();
      while (localIterator.hasNext())
      {
        Object localObject5 = localIterator.next();
        ((List)localObject4).add(zzz(localObject5));
      }
      this.zzbvj.zza(localzzuh, localObject4);
      return;
    }
    if (localzzuh.zzwa() == zzxx.zzcem)
    {
      Object localObject2 = zza(localzzuh);
      if (localObject2 == null)
      {
        this.zzbvj.zza(localzzuh, zzz(localObject1));
        return;
      }
      if ((localObject2 instanceof zzwb));
      for (Object localObject3 = localzzuh.zza((zzwb)localObject2, (zzwb)localObject1); ; localObject3 = localzzuh.zza(((zzvv)localObject2).zzwh(), (zzvv)localObject1).zzwo())
      {
        this.zzbvj.zza(localzzuh, localObject3);
        return;
      }
    }
    this.zzbvj.zza(localzzuh, zzz(localObject1));
  }

  private static int zze(Map.Entry<FieldDescriptorType, Object> paramEntry)
  {
    zzuh localzzuh = (zzuh)paramEntry.getKey();
    Object localObject = paramEntry.getValue();
    if ((localzzuh.zzwa() == zzxx.zzcem) && (!localzzuh.zzwb()) && (!localzzuh.zzwc()))
    {
      if ((localObject instanceof zzuy))
        return zztv.zzb(((zzuh)paramEntry.getKey()).zzc(), (zzuy)localObject);
      return zztv.zzd(((zzuh)paramEntry.getKey()).zzc(), (zzvv)localObject);
    }
    return zzb(localzzuh, localObject);
  }

  public static <T extends zzuh<T>> zzuf<T> zzvw()
  {
    return zzbvl;
  }

  private static Object zzz(Object paramObject)
  {
    if ((paramObject instanceof zzwb))
      paramObject = ((zzwb)paramObject).zzxp();
    while (!(paramObject instanceof byte[]))
      return paramObject;
    byte[] arrayOfByte1 = (byte[])paramObject;
    byte[] arrayOfByte2 = new byte[arrayOfByte1.length];
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, arrayOfByte1.length);
    return arrayOfByte2;
  }

  final Iterator<Map.Entry<FieldDescriptorType, Object>> descendingIterator()
  {
    if (this.zzbvk)
      return new zzvb(this.zzbvj.zzye().iterator());
    return this.zzbvj.zzye().iterator();
  }

  public final boolean equals(Object paramObject)
  {
    if (this == paramObject)
      return true;
    if (!(paramObject instanceof zzuf))
      return false;
    zzuf localzzuf = (zzuf)paramObject;
    return this.zzbvj.equals(localzzuf.zzbvj);
  }

  public final int hashCode()
  {
    return this.zzbvj.hashCode();
  }

  final boolean isEmpty()
  {
    return this.zzbvj.isEmpty();
  }

  public final boolean isImmutable()
  {
    return this.zzbqa;
  }

  public final boolean isInitialized()
  {
    for (int i = 0; i < this.zzbvj.zzyc(); i++)
      if (!zzc(this.zzbvj.zzbx(i)))
        return false;
    Iterator localIterator = this.zzbvj.zzyd().iterator();
    while (localIterator.hasNext())
      if (!zzc((Map.Entry)localIterator.next()))
        return false;
    return true;
  }

  public final Iterator<Map.Entry<FieldDescriptorType, Object>> iterator()
  {
    if (this.zzbvk)
      return new zzvb(this.zzbvj.entrySet().iterator());
    return this.zzbvj.entrySet().iterator();
  }

  public final void zza(zzuf<FieldDescriptorType> paramzzuf)
  {
    for (int i = 0; i < paramzzuf.zzbvj.zzyc(); i++)
      zzd(paramzzuf.zzbvj.zzbx(i));
    Iterator localIterator = paramzzuf.zzbvj.zzyd().iterator();
    while (localIterator.hasNext())
      zzd((Map.Entry)localIterator.next());
  }

  public final void zzsw()
  {
    if (this.zzbqa)
      return;
    this.zzbvj.zzsw();
    this.zzbqa = true;
  }

  public final int zzvx()
  {
    int i = 0;
    int j = 0;
    while (i < this.zzbvj.zzyc())
    {
      Map.Entry localEntry2 = this.zzbvj.zzbx(i);
      j += zzb((zzuh)localEntry2.getKey(), localEntry2.getValue());
      i++;
    }
    Iterator localIterator = this.zzbvj.zzyd().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry1 = (Map.Entry)localIterator.next();
      j += zzb((zzuh)localEntry1.getKey(), localEntry1.getValue());
    }
    return j;
  }

  public final int zzvy()
  {
    int i = 0;
    int j = 0;
    while (i < this.zzbvj.zzyc())
    {
      j += zze(this.zzbvj.zzbx(i));
      i++;
    }
    Iterator localIterator = this.zzbvj.zzyd().iterator();
    while (localIterator.hasNext())
      j += zze((Map.Entry)localIterator.next());
    return j;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzuf
 * JD-Core Version:    0.6.2
 */