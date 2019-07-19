package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

final class zzdnr<FieldDescriptorType extends zzdnt<FieldDescriptorType>>
{
  private static final zzdnr zzhej = new zzdnr(true);
  private final zzdqd<FieldDescriptorType, Object> zzheg;
  private boolean zzheh;
  private boolean zzhei = false;

  private zzdnr()
  {
    this.zzheg = zzdqd.zzgy(16);
  }

  private zzdnr(boolean paramBoolean)
  {
    this.zzheg = zzdqd.zzgy(0);
    zzavj();
  }

  static int zza(zzdrh paramzzdrh, int paramInt, Object paramObject)
  {
    int i = zzdnh.zzgd(paramInt);
    if (paramzzdrh == zzdrh.zzhmq)
      zzdoc.zzn((zzdpj)paramObject);
    for (int j = i << 1; ; j = i)
      return j + zzb(paramzzdrh, paramObject);
  }

  private final Object zza(FieldDescriptorType paramFieldDescriptorType)
  {
    Object localObject = this.zzheg.get(paramFieldDescriptorType);
    if ((localObject instanceof zzdom))
      localObject = zzdom.zzaym();
    return localObject;
  }

  static void zza(zzdnh paramzzdnh, zzdrh paramzzdrh, int paramInt, Object paramObject)
    throws IOException
  {
    if (paramzzdrh == zzdrh.zzhmq)
    {
      zzdoc.zzn((zzdpj)paramObject);
      zzdpj localzzdpj = (zzdpj)paramObject;
      paramzzdnh.zzw(paramInt, 3);
      localzzdpj.zzb(paramzzdnh);
      paramzzdnh.zzw(paramInt, 4);
      return;
    }
    paramzzdnh.zzw(paramInt, paramzzdrh.zzbak());
    switch (zzdns.zzhdm[paramzzdrh.ordinal()])
    {
    default:
      return;
    case 1:
      paramzzdnh.zzb(((Double)paramObject).doubleValue());
      return;
    case 2:
      paramzzdnh.zzg(((Float)paramObject).floatValue());
      return;
    case 3:
      paramzzdnh.zzfj(((Long)paramObject).longValue());
      return;
    case 4:
      paramzzdnh.zzfj(((Long)paramObject).longValue());
      return;
    case 5:
      paramzzdnh.zzfz(((Integer)paramObject).intValue());
      return;
    case 6:
      paramzzdnh.zzfl(((Long)paramObject).longValue());
      return;
    case 7:
      paramzzdnh.zzgc(((Integer)paramObject).intValue());
      return;
    case 8:
      paramzzdnh.zzbf(((Boolean)paramObject).booleanValue());
      return;
    case 9:
      ((zzdpj)paramObject).zzb(paramzzdnh);
      return;
    case 10:
      paramzzdnh.zzj((zzdpj)paramObject);
      return;
    case 11:
      if ((paramObject instanceof zzdmq))
      {
        paramzzdnh.zzcz((zzdmq)paramObject);
        return;
      }
      paramzzdnh.zzgw((String)paramObject);
      return;
    case 12:
      if ((paramObject instanceof zzdmq))
      {
        paramzzdnh.zzcz((zzdmq)paramObject);
        return;
      }
      byte[] arrayOfByte = (byte[])paramObject;
      paramzzdnh.zzk(arrayOfByte, 0, arrayOfByte.length);
      return;
    case 13:
      paramzzdnh.zzga(((Integer)paramObject).intValue());
      return;
    case 14:
      paramzzdnh.zzgc(((Integer)paramObject).intValue());
      return;
    case 15:
      paramzzdnh.zzfl(((Long)paramObject).longValue());
      return;
    case 16:
      paramzzdnh.zzgb(((Integer)paramObject).intValue());
      return;
    case 17:
      paramzzdnh.zzfk(((Long)paramObject).longValue());
      return;
    case 18:
    }
    if ((paramObject instanceof zzdod))
    {
      paramzzdnh.zzfz(((zzdod)paramObject).zzac());
      return;
    }
    paramzzdnh.zzfz(((Integer)paramObject).intValue());
  }

  private final void zza(FieldDescriptorType paramFieldDescriptorType, Object paramObject)
  {
    if (paramFieldDescriptorType.zzaxn())
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
        zza(paramFieldDescriptorType.zzaxl(), localObject2);
      }
    }
    zza(paramFieldDescriptorType.zzaxl(), paramObject);
    Object localObject1 = paramObject;
    if ((localObject1 instanceof zzdom))
      this.zzhei = true;
    this.zzheg.zza(paramFieldDescriptorType, localObject1);
  }

  private static void zza(zzdrh paramzzdrh, Object paramObject)
  {
    zzdoc.checkNotNull(paramObject);
    int i = zzdns.zzhek[paramzzdrh.zzbaj().ordinal()];
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
      if (!(paramObject instanceof zzdmq))
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
          boolean bool3 = paramObject instanceof zzdod;
          bool1 = false;
          if (!bool3);
        }
        else
        {
          bool1 = true;
          continue;
          if (!(paramObject instanceof zzdpj))
          {
            boolean bool2 = paramObject instanceof zzdom;
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

  private static Object zzab(Object paramObject)
  {
    if ((paramObject instanceof zzdpq))
      paramObject = ((zzdpq)paramObject).zzazc();
    while (!(paramObject instanceof byte[]))
      return paramObject;
    byte[] arrayOfByte1 = (byte[])paramObject;
    byte[] arrayOfByte2 = new byte[arrayOfByte1.length];
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, arrayOfByte1.length);
    return arrayOfByte2;
  }

  public static <T extends zzdnt<T>> zzdnr<T> zzaxi()
  {
    return zzhej;
  }

  private static int zzb(zzdnt<?> paramzzdnt, Object paramObject)
  {
    int i = 0;
    zzdrh localzzdrh = paramzzdnt.zzaxl();
    int j = paramzzdnt.zzac();
    if (paramzzdnt.zzaxn())
    {
      if (paramzzdnt.zzaxo())
      {
        Iterator localIterator2 = ((List)paramObject).iterator();
        while (localIterator2.hasNext())
          i += zzb(localzzdrh, localIterator2.next());
        i = i + zzdnh.zzgd(j) + zzdnh.zzgl(i);
      }
      while (true)
      {
        return i;
        Iterator localIterator1 = ((List)paramObject).iterator();
        while (localIterator1.hasNext())
          i += zza(localzzdrh, j, localIterator1.next());
      }
    }
    return zza(localzzdrh, j, paramObject);
  }

  private static int zzb(zzdrh paramzzdrh, Object paramObject)
  {
    switch (zzdns.zzhdm[paramzzdrh.ordinal()])
    {
    default:
      throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
    case 1:
      return zzdnh.zzc(((Double)paramObject).doubleValue());
    case 2:
      return zzdnh.zzh(((Float)paramObject).floatValue());
    case 3:
      return zzdnh.zzfm(((Long)paramObject).longValue());
    case 4:
      return zzdnh.zzfn(((Long)paramObject).longValue());
    case 5:
      return zzdnh.zzge(((Integer)paramObject).intValue());
    case 6:
      return zzdnh.zzfp(((Long)paramObject).longValue());
    case 7:
      return zzdnh.zzgh(((Integer)paramObject).intValue());
    case 8:
      return zzdnh.zzbg(((Boolean)paramObject).booleanValue());
    case 9:
      return zzdnh.zzl((zzdpj)paramObject);
    case 12:
      if ((paramObject instanceof zzdmq))
        return zzdnh.zzda((zzdmq)paramObject);
      return zzdnh.zzac((byte[])paramObject);
    case 11:
      if ((paramObject instanceof zzdmq))
        return zzdnh.zzda((zzdmq)paramObject);
      return zzdnh.zzgx((String)paramObject);
    case 13:
      return zzdnh.zzgf(((Integer)paramObject).intValue());
    case 14:
      return zzdnh.zzgi(((Integer)paramObject).intValue());
    case 15:
      return zzdnh.zzfq(((Long)paramObject).longValue());
    case 16:
      return zzdnh.zzgg(((Integer)paramObject).intValue());
    case 17:
      return zzdnh.zzfo(((Long)paramObject).longValue());
    case 10:
      if ((paramObject instanceof zzdom))
        return zzdnh.zza((zzdom)paramObject);
      return zzdnh.zzk((zzdpj)paramObject);
    case 18:
    }
    if ((paramObject instanceof zzdod))
      return zzdnh.zzgj(((zzdod)paramObject).zzac());
    return zzdnh.zzgj(((Integer)paramObject).intValue());
  }

  private static boolean zzb(Map.Entry<FieldDescriptorType, Object> paramEntry)
  {
    zzdnt localzzdnt = (zzdnt)paramEntry.getKey();
    if (localzzdnt.zzaxm() == zzdrm.zzhnk)
    {
      if (localzzdnt.zzaxn())
      {
        Iterator localIterator = ((List)paramEntry.getValue()).iterator();
        do
          if (!localIterator.hasNext())
            break;
        while (((zzdpj)localIterator.next()).isInitialized());
        return false;
      }
      Object localObject = paramEntry.getValue();
      if ((localObject instanceof zzdpj))
      {
        if (!((zzdpj)localObject).isInitialized())
          return false;
      }
      else
      {
        if ((localObject instanceof zzdom))
          return true;
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
      }
    }
    return true;
  }

  private final void zzc(Map.Entry<FieldDescriptorType, Object> paramEntry)
  {
    zzdnt localzzdnt = (zzdnt)paramEntry.getKey();
    Object localObject1 = paramEntry.getValue();
    if ((localObject1 instanceof zzdom))
      localObject1 = zzdom.zzaym();
    if (localzzdnt.zzaxn())
    {
      Object localObject4 = zza(localzzdnt);
      if (localObject4 == null)
        localObject4 = new ArrayList();
      Iterator localIterator = ((List)localObject1).iterator();
      while (localIterator.hasNext())
      {
        Object localObject5 = localIterator.next();
        ((List)localObject4).add(zzab(localObject5));
      }
      this.zzheg.zza(localzzdnt, localObject4);
      return;
    }
    if (localzzdnt.zzaxm() == zzdrm.zzhnk)
    {
      Object localObject2 = zza(localzzdnt);
      if (localObject2 == null)
      {
        this.zzheg.zza(localzzdnt, zzab(localObject1));
        return;
      }
      if ((localObject2 instanceof zzdpq));
      for (Object localObject3 = localzzdnt.zza((zzdpq)localObject2, (zzdpq)localObject1); ; localObject3 = localzzdnt.zza(((zzdpj)localObject2).zzaxt(), (zzdpj)localObject1).zzaya())
      {
        this.zzheg.zza(localzzdnt, localObject3);
        return;
      }
    }
    this.zzheg.zza(localzzdnt, zzab(localObject1));
  }

  private static int zzd(Map.Entry<FieldDescriptorType, Object> paramEntry)
  {
    zzdnt localzzdnt = (zzdnt)paramEntry.getKey();
    Object localObject = paramEntry.getValue();
    if ((localzzdnt.zzaxm() == zzdrm.zzhnk) && (!localzzdnt.zzaxn()) && (!localzzdnt.zzaxo()))
    {
      if ((localObject instanceof zzdom))
        return zzdnh.zzb(((zzdnt)paramEntry.getKey()).zzac(), (zzdom)localObject);
      return zzdnh.zzd(((zzdnt)paramEntry.getKey()).zzac(), (zzdpj)localObject);
    }
    return zzb(localzzdnt, localObject);
  }

  final Iterator<Map.Entry<FieldDescriptorType, Object>> descendingIterator()
  {
    if (this.zzhei)
      return new zzdop(this.zzheg.zzazr().iterator());
    return this.zzheg.zzazr().iterator();
  }

  public final boolean equals(Object paramObject)
  {
    if (this == paramObject)
      return true;
    if (!(paramObject instanceof zzdnr))
      return false;
    zzdnr localzzdnr = (zzdnr)paramObject;
    return this.zzheg.equals(localzzdnr.zzheg);
  }

  public final int hashCode()
  {
    return this.zzheg.hashCode();
  }

  final boolean isEmpty()
  {
    return this.zzheg.isEmpty();
  }

  public final boolean isImmutable()
  {
    return this.zzheh;
  }

  public final boolean isInitialized()
  {
    for (int i = 0; i < this.zzheg.zzazp(); i++)
      if (!zzb(this.zzheg.zzgz(i)))
        return false;
    Iterator localIterator = this.zzheg.zzazq().iterator();
    while (localIterator.hasNext())
      if (!zzb((Map.Entry)localIterator.next()))
        return false;
    return true;
  }

  public final Iterator<Map.Entry<FieldDescriptorType, Object>> iterator()
  {
    if (this.zzhei)
      return new zzdop(this.zzheg.entrySet().iterator());
    return this.zzheg.entrySet().iterator();
  }

  public final void zza(zzdnr<FieldDescriptorType> paramzzdnr)
  {
    for (int i = 0; i < paramzzdnr.zzheg.zzazp(); i++)
      zzc(paramzzdnr.zzheg.zzgz(i));
    Iterator localIterator = paramzzdnr.zzheg.zzazq().iterator();
    while (localIterator.hasNext())
      zzc((Map.Entry)localIterator.next());
  }

  public final void zzavj()
  {
    if (this.zzheh)
      return;
    this.zzheg.zzavj();
    this.zzheh = true;
  }

  public final int zzaxj()
  {
    int i = 0;
    int j = 0;
    while (i < this.zzheg.zzazp())
    {
      Map.Entry localEntry2 = this.zzheg.zzgz(i);
      j += zzb((zzdnt)localEntry2.getKey(), localEntry2.getValue());
      i++;
    }
    Iterator localIterator = this.zzheg.zzazq().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry1 = (Map.Entry)localIterator.next();
      j += zzb((zzdnt)localEntry1.getKey(), localEntry1.getValue());
    }
    return j;
  }

  public final int zzaxk()
  {
    int i = 0;
    int j = 0;
    while (i < this.zzheg.zzazp())
    {
      j += zzd(this.zzheg.zzgz(i));
      i++;
    }
    Iterator localIterator = this.zzheg.zzazq().iterator();
    while (localIterator.hasNext())
      j += zzd((Map.Entry)localIterator.next());
    return j;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdnr
 * JD-Core Version:    0.6.2
 */