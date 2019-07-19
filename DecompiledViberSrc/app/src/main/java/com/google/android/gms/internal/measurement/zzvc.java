package com.google.android.gms.internal.measurement;

public class zzvc
{
  private static final zzub zzbtm = zzub.zzvr();
  private zzte zzbzw;
  private volatile zzvv zzbzx;
  private volatile zzte zzbzy;

  // ERROR //
  private final zzvv zzh(zzvv paramzzvv)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 30	com/google/android/gms/internal/measurement/zzvc:zzbzx	Lcom/google/android/gms/internal/measurement/zzvv;
    //   4: ifnonnull +14 -> 18
    //   7: aload_0
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 30	com/google/android/gms/internal/measurement/zzvc:zzbzx	Lcom/google/android/gms/internal/measurement/zzvv;
    //   13: ifnull +10 -> 23
    //   16: aload_0
    //   17: monitorexit
    //   18: aload_0
    //   19: getfield 30	com/google/android/gms/internal/measurement/zzvc:zzbzx	Lcom/google/android/gms/internal/measurement/zzvv;
    //   22: areturn
    //   23: aload_0
    //   24: aload_1
    //   25: putfield 30	com/google/android/gms/internal/measurement/zzvc:zzbzx	Lcom/google/android/gms/internal/measurement/zzvv;
    //   28: aload_0
    //   29: getstatic 35	com/google/android/gms/internal/measurement/zzte:zzbts	Lcom/google/android/gms/internal/measurement/zzte;
    //   32: putfield 37	com/google/android/gms/internal/measurement/zzvc:zzbzy	Lcom/google/android/gms/internal/measurement/zzte;
    //   35: aload_0
    //   36: monitorexit
    //   37: goto -19 -> 18
    //   40: astore_2
    //   41: aload_0
    //   42: monitorexit
    //   43: aload_2
    //   44: athrow
    //   45: astore_3
    //   46: aload_0
    //   47: aload_1
    //   48: putfield 30	com/google/android/gms/internal/measurement/zzvc:zzbzx	Lcom/google/android/gms/internal/measurement/zzvv;
    //   51: aload_0
    //   52: getstatic 35	com/google/android/gms/internal/measurement/zzte:zzbts	Lcom/google/android/gms/internal/measurement/zzte;
    //   55: putfield 37	com/google/android/gms/internal/measurement/zzvc:zzbzy	Lcom/google/android/gms/internal/measurement/zzte;
    //   58: goto -23 -> 35
    //
    // Exception table:
    //   from	to	target	type
    //   9	18	40	finally
    //   23	35	40	finally
    //   35	37	40	finally
    //   41	43	40	finally
    //   46	58	40	finally
    //   23	35	45	com/google/android/gms/internal/measurement/zzuv
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject)
      return true;
    if (!(paramObject instanceof zzvc))
      return false;
    zzvc localzzvc = (zzvc)paramObject;
    zzvv localzzvv1 = this.zzbzx;
    zzvv localzzvv2 = localzzvc.zzbzx;
    if ((localzzvv1 == null) && (localzzvv2 == null))
      return zztw().equals(localzzvc.zztw());
    if ((localzzvv1 != null) && (localzzvv2 != null))
      return localzzvv1.equals(localzzvv2);
    if (localzzvv1 != null)
      return localzzvv1.equals(localzzvc.zzh(localzzvv1.zzwj()));
    return zzh(localzzvv2.zzwj()).equals(localzzvv2);
  }

  public int hashCode()
  {
    return 1;
  }

  public final zzvv zzi(zzvv paramzzvv)
  {
    zzvv localzzvv = this.zzbzx;
    this.zzbzw = null;
    this.zzbzy = null;
    this.zzbzx = paramzzvv;
    return localzzvv;
  }

  public final zzte zztw()
  {
    if (this.zzbzy != null)
      return this.zzbzy;
    try
    {
      if (this.zzbzy != null)
      {
        zzte localzzte2 = this.zzbzy;
        return localzzte2;
      }
    }
    finally
    {
    }
    if (this.zzbzx == null);
    for (this.zzbzy = zzte.zzbts; ; this.zzbzy = this.zzbzx.zztw())
    {
      zzte localzzte1 = this.zzbzy;
      return localzzte1;
    }
  }

  public final int zzvx()
  {
    if (this.zzbzy != null)
      return this.zzbzy.size();
    if (this.zzbzx != null)
      return this.zzbzx.zzvx();
    return 0;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzvc
 * JD-Core Version:    0.6.2
 */