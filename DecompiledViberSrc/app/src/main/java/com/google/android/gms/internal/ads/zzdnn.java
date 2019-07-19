package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class zzdnn
{
  private static volatile boolean zzhdz = false;
  private static final Class<?> zzhea = zzaxc();
  private static volatile zzdnn zzheb;
  static final zzdnn zzhec = new zzdnn(true);
  private final Map<zza, zzdoa.zzd<?, ?>> zzhed;

  zzdnn()
  {
    this.zzhed = new HashMap();
  }

  private zzdnn(boolean paramBoolean)
  {
    this.zzhed = Collections.emptyMap();
  }

  static zzdnn zzaxb()
  {
    return zzdny.zzb(zzdnn.class);
  }

  private static Class<?> zzaxc()
  {
    try
    {
      Class localClass = Class.forName("com.google.protobuf.Extension");
      return localClass;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
    }
    return null;
  }

  public static zzdnn zzaxd()
  {
    return zzdnm.zzaxa();
  }

  public static zzdnn zzaxe()
  {
    zzdnn localzzdnn1 = zzheb;
    if (localzzdnn1 == null)
      try
      {
        zzdnn localzzdnn2 = zzheb;
        if (localzzdnn2 == null)
        {
          localzzdnn2 = zzdnm.zzaxb();
          zzheb = localzzdnn2;
        }
        return localzzdnn2;
      }
      finally
      {
      }
    return localzzdnn1;
  }

  public final <ContainingType extends zzdpj> zzdoa.zzd<ContainingType, ?> zza(ContainingType paramContainingType, int paramInt)
  {
    return (zzdoa.zzd)this.zzhed.get(new zza(paramContainingType, paramInt));
  }

  static final class zza
  {
    private final int number;
    private final Object object;

    zza(Object paramObject, int paramInt)
    {
      this.object = paramObject;
      this.number = paramInt;
    }

    public final boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof zza));
      zza localzza;
      do
      {
        return false;
        localzza = (zza)paramObject;
      }
      while ((this.object != localzza.object) || (this.number != localzza.number));
      return true;
    }

    public final int hashCode()
    {
      return 65535 * System.identityHashCode(this.object) + this.number;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdnn
 * JD-Core Version:    0.6.2
 */