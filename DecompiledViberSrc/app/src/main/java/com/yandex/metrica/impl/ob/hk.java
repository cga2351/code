package com.yandex.metrica.impl.ob;

import java.util.List;

public class hk extends hp
{
  public final long a;
  public final long b;
  public final boolean c;
  public final List<hr> d;

  public hk(long paramLong1, float paramFloat, int paramInt1, int paramInt2, long paramLong2, int paramInt3, boolean paramBoolean1, long paramLong3, long paramLong4, long paramLong5, boolean paramBoolean2, boolean paramBoolean3, List<hr> paramList)
  {
    super(paramLong1, paramFloat, paramInt1, paramInt2, paramLong2, paramInt3, paramBoolean1, paramLong5, paramBoolean2);
    this.a = paramLong3;
    this.b = paramLong4;
    this.c = paramBoolean3;
    this.d = paramList;
  }

  public hp.a a()
  {
    return hp.a.b;
  }

  public String toString()
  {
    return "BackgroundCollectionConfig{collectionDuration=" + this.a + ", collectionInterval=" + this.b + ", aggressiveRelaunch=" + this.c + ", collectionIntervalRanges=" + this.d + ", updateTimeInterval=" + this.e + ", updateDistanceInterval=" + this.f + ", recordsCountToForceFlush=" + this.g + ", maxBatchSize=" + this.h + ", maxAgeToForceFlush=" + this.i + ", maxRecordsToStoreLocally=" + this.j + ", collectionEnabled=" + this.k + ", lbsUpdateTimeInterval=" + this.l + ", lbsCollectionEnabled=" + this.m + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.hk
 * JD-Core Version:    0.6.2
 */