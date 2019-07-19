package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzdox extends zzdmk<Long>
  implements zzdoi<Long>, zzdpv, RandomAccess
{
  private static final zzdox zzhjd;
  private int size;
  private long[] zzhje;

  static
  {
    zzdox localzzdox = new zzdox(new long[0], 0);
    zzhjd = localzzdox;
    localzzdox.zzavj();
  }

  zzdox()
  {
    this(new long[10], 0);
  }

  private zzdox(long[] paramArrayOfLong, int paramInt)
  {
    this.zzhje = paramArrayOfLong;
    this.size = paramInt;
  }

  private final void zzfj(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.size))
      throw new IndexOutOfBoundsException(zzfk(paramInt));
  }

  private final String zzfk(int paramInt)
  {
    int i = this.size;
    return 35 + "Index:" + paramInt + ", Size:" + i;
  }

  private final void zzr(int paramInt, long paramLong)
  {
    zzavk();
    if ((paramInt < 0) || (paramInt > this.size))
      throw new IndexOutOfBoundsException(zzfk(paramInt));
    if (this.size < this.zzhje.length)
      System.arraycopy(this.zzhje, paramInt, this.zzhje, paramInt + 1, this.size - paramInt);
    while (true)
    {
      this.zzhje[paramInt] = paramLong;
      this.size = (1 + this.size);
      this.modCount = (1 + this.modCount);
      return;
      long[] arrayOfLong = new long[1 + 3 * this.size / 2];
      System.arraycopy(this.zzhje, 0, arrayOfLong, 0, paramInt);
      System.arraycopy(this.zzhje, paramInt, arrayOfLong, paramInt + 1, this.size - paramInt);
      this.zzhje = arrayOfLong;
    }
  }

  public final boolean addAll(Collection<? extends Long> paramCollection)
  {
    zzavk();
    zzdoc.checkNotNull(paramCollection);
    boolean bool;
    if (!(paramCollection instanceof zzdox))
      bool = super.addAll(paramCollection);
    zzdox localzzdox;
    int i;
    do
    {
      return bool;
      localzzdox = (zzdox)paramCollection;
      i = localzzdox.size;
      bool = false;
    }
    while (i == 0);
    if (2147483647 - this.size < localzzdox.size)
      throw new OutOfMemoryError();
    int j = this.size + localzzdox.size;
    if (j > this.zzhje.length)
      this.zzhje = Arrays.copyOf(this.zzhje, j);
    System.arraycopy(localzzdox.zzhje, 0, this.zzhje, this.size, localzzdox.size);
    this.size = j;
    this.modCount = (1 + this.modCount);
    return true;
  }

  public final boolean equals(Object paramObject)
  {
    boolean bool1;
    if (this == paramObject)
      bool1 = true;
    zzdox localzzdox;
    int i;
    int j;
    do
    {
      return bool1;
      if (!(paramObject instanceof zzdox))
        return super.equals(paramObject);
      localzzdox = (zzdox)paramObject;
      i = this.size;
      j = localzzdox.size;
      bool1 = false;
    }
    while (i != j);
    long[] arrayOfLong = localzzdox.zzhje;
    for (int k = 0; ; k++)
    {
      if (k >= this.size)
        break label96;
      boolean bool2 = this.zzhje[k] < arrayOfLong[k];
      bool1 = false;
      if (bool2)
        break;
    }
    label96: return true;
  }

  public final long getLong(int paramInt)
  {
    zzfj(paramInt);
    return this.zzhje[paramInt];
  }

  public final int hashCode()
  {
    int i = 1;
    for (int j = 0; j < this.size; j++)
      i = i * 31 + zzdoc.zzft(this.zzhje[j]);
    return i;
  }

  public final boolean remove(Object paramObject)
  {
    zzavk();
    for (int i = 0; ; i++)
    {
      int j = this.size;
      boolean bool = false;
      if (i < j)
      {
        if (paramObject.equals(Long.valueOf(this.zzhje[i])))
        {
          System.arraycopy(this.zzhje, i + 1, this.zzhje, i, -1 + (this.size - i));
          this.size = (-1 + this.size);
          this.modCount = (1 + this.modCount);
          bool = true;
        }
      }
      else
        return bool;
    }
  }

  protected final void removeRange(int paramInt1, int paramInt2)
  {
    zzavk();
    if (paramInt2 < paramInt1)
      throw new IndexOutOfBoundsException("toIndex < fromIndex");
    System.arraycopy(this.zzhje, paramInt2, this.zzhje, paramInt1, this.size - paramInt2);
    this.size -= paramInt2 - paramInt1;
    this.modCount = (1 + this.modCount);
  }

  public final int size()
  {
    return this.size;
  }

  public final void zzfu(long paramLong)
  {
    zzr(this.size, paramLong);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdox
 * JD-Core Version:    0.6.2
 */