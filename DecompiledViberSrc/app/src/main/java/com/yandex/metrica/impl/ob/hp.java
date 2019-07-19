package com.yandex.metrica.impl.ob;

public class hp
{
  public final long e;
  public final float f;
  public final int g;
  public final int h;
  public final long i;
  public final int j;
  public final boolean k;
  public final long l;
  public final boolean m;

  public hp(long paramLong1, float paramFloat, int paramInt1, int paramInt2, long paramLong2, int paramInt3, boolean paramBoolean1, long paramLong3, boolean paramBoolean2)
  {
    this.e = paramLong1;
    this.f = paramFloat;
    this.g = paramInt1;
    this.h = paramInt2;
    this.i = paramLong2;
    this.j = paramInt3;
    this.k = paramBoolean1;
    this.l = paramLong3;
    this.m = paramBoolean2;
  }

  public a a()
  {
    return a.a;
  }

  public String toString()
  {
    return "ForegroundCollectionConfig{updateTimeInterval=" + this.e + ", updateDistanceInterval=" + this.f + ", recordsCountToForceFlush=" + this.g + ", maxBatchSize=" + this.h + ", maxAgeToForceFlush=" + this.i + ", maxRecordsToStoreLocally=" + this.j + ", collectionEnabled=" + this.k + ", lbsUpdateTimeInterval=" + this.l + ", lbsCollectionEnabled=" + this.m + '}';
  }

  public static enum a
  {
    private final String c;

    static
    {
      a[] arrayOfa = new a[2];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
    }

    private a(String paramString)
    {
      this.c = paramString;
    }

    public static a a(String paramString)
    {
      Object localObject1 = a;
      a[] arrayOfa = values();
      int i = arrayOfa.length;
      int j = 0;
      Object localObject2;
      if (j < i)
      {
        localObject2 = arrayOfa[j];
        if (!((a)localObject2).c.equals(paramString))
          break label49;
      }
      while (true)
      {
        j++;
        localObject1 = localObject2;
        break;
        return localObject1;
        label49: localObject2 = localObject1;
      }
    }

    public String toString()
    {
      return this.c;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.hp
 * JD-Core Version:    0.6.2
 */