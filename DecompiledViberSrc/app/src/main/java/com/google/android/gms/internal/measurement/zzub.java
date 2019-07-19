package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class zzub
{
  private static volatile boolean zzbvc = false;
  private static final Class<?> zzbvd = zzvq();
  private static volatile zzub zzbve;
  static final zzub zzbvf = new zzub(true);
  private final Map<zza, zzuo.zzd<?, ?>> zzbvg;

  zzub()
  {
    this.zzbvg = new HashMap();
  }

  private zzub(boolean paramBoolean)
  {
    this.zzbvg = Collections.emptyMap();
  }

  static zzub zzvp()
  {
    return zzum.zzd(zzub.class);
  }

  private static Class<?> zzvq()
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

  public static zzub zzvr()
  {
    return zzua.zzvo();
  }

  public static zzub zzvs()
  {
    zzub localzzub1 = zzbve;
    if (localzzub1 == null)
      try
      {
        zzub localzzub2 = zzbve;
        if (localzzub2 == null)
        {
          localzzub2 = zzua.zzvp();
          zzbve = localzzub2;
        }
        return localzzub2;
      }
      finally
      {
      }
    return localzzub1;
  }

  public final <ContainingType extends zzvv> zzuo.zzd<ContainingType, ?> zza(ContainingType paramContainingType, int paramInt)
  {
    return (zzuo.zzd)this.zzbvg.get(new zza(paramContainingType, paramInt));
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
 * Qualified Name:     com.google.android.gms.internal.measurement.zzub
 * JD-Core Version:    0.6.2
 */