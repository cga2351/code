package com.google.android.gms.internal.ads;

public class zzdoq
{
  private static final zzdnn zzhch = zzdnn.zzaxd();
  private zzdmq zzhiu;
  private volatile zzdpj zzhiv;
  private volatile zzdmq zzhiw;

  // ERROR //
  private final zzdpj zzp(zzdpj paramzzdpj)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 30	com/google/android/gms/internal/ads/zzdoq:zzhiv	Lcom/google/android/gms/internal/ads/zzdpj;
    //   4: ifnonnull +14 -> 18
    //   7: aload_0
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 30	com/google/android/gms/internal/ads/zzdoq:zzhiv	Lcom/google/android/gms/internal/ads/zzdpj;
    //   13: ifnull +10 -> 23
    //   16: aload_0
    //   17: monitorexit
    //   18: aload_0
    //   19: getfield 30	com/google/android/gms/internal/ads/zzdoq:zzhiv	Lcom/google/android/gms/internal/ads/zzdpj;
    //   22: areturn
    //   23: aload_0
    //   24: aload_1
    //   25: putfield 30	com/google/android/gms/internal/ads/zzdoq:zzhiv	Lcom/google/android/gms/internal/ads/zzdpj;
    //   28: aload_0
    //   29: getstatic 35	com/google/android/gms/internal/ads/zzdmq:zzhcr	Lcom/google/android/gms/internal/ads/zzdmq;
    //   32: putfield 37	com/google/android/gms/internal/ads/zzdoq:zzhiw	Lcom/google/android/gms/internal/ads/zzdmq;
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
    //   48: putfield 30	com/google/android/gms/internal/ads/zzdoq:zzhiv	Lcom/google/android/gms/internal/ads/zzdpj;
    //   51: aload_0
    //   52: getstatic 35	com/google/android/gms/internal/ads/zzdmq:zzhcr	Lcom/google/android/gms/internal/ads/zzdmq;
    //   55: putfield 37	com/google/android/gms/internal/ads/zzdoq:zzhiw	Lcom/google/android/gms/internal/ads/zzdmq;
    //   58: goto -23 -> 35
    //
    // Exception table:
    //   from	to	target	type
    //   9	18	40	finally
    //   23	35	40	finally
    //   35	37	40	finally
    //   41	43	40	finally
    //   46	58	40	finally
    //   23	35	45	com/google/android/gms/internal/ads/zzdoj
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject)
      return true;
    if (!(paramObject instanceof zzdoq))
      return false;
    zzdoq localzzdoq = (zzdoq)paramObject;
    zzdpj localzzdpj1 = this.zzhiv;
    zzdpj localzzdpj2 = localzzdoq.zzhiv;
    if ((localzzdpj1 == null) && (localzzdpj2 == null))
      return zzavf().equals(localzzdoq.zzavf());
    if ((localzzdpj1 != null) && (localzzdpj2 != null))
      return localzzdpj1.equals(localzzdpj2);
    if (localzzdpj1 != null)
      return localzzdpj1.equals(localzzdoq.zzp(localzzdpj1.zzaxv()));
    return zzp(localzzdpj2.zzaxv()).equals(localzzdpj2);
  }

  public int hashCode()
  {
    return 1;
  }

  public final zzdmq zzavf()
  {
    if (this.zzhiw != null)
      return this.zzhiw;
    try
    {
      if (this.zzhiw != null)
      {
        zzdmq localzzdmq2 = this.zzhiw;
        return localzzdmq2;
      }
    }
    finally
    {
    }
    if (this.zzhiv == null);
    for (this.zzhiw = zzdmq.zzhcr; ; this.zzhiw = this.zzhiv.zzavf())
    {
      zzdmq localzzdmq1 = this.zzhiw;
      return localzzdmq1;
    }
  }

  public final int zzaxj()
  {
    if (this.zzhiw != null)
      return this.zzhiw.size();
    if (this.zzhiv != null)
      return this.zzhiv.zzaxj();
    return 0;
  }

  public final zzdpj zzq(zzdpj paramzzdpj)
  {
    zzdpj localzzdpj = this.zzhiv;
    this.zzhiu = null;
    this.zzhiw = null;
    this.zzhiv = paramzzdpj;
    return localzzdpj;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdoq
 * JD-Core Version:    0.6.2
 */