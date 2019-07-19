package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzvj extends zzta<Long>
  implements zzuu<Long>, zzwg, RandomAccess
{
  private static final zzvj zzcaf;
  private int size;
  private long[] zzcag;

  static
  {
    zzvj localzzvj = new zzvj();
    zzcaf = localzzvj;
    localzzvj.zzsw();
  }

  zzvj()
  {
    this(new long[10], 0);
  }

  private zzvj(long[] paramArrayOfLong, int paramInt)
  {
    this.zzcag = paramArrayOfLong;
    this.size = paramInt;
  }

  private final void zzaj(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.size))
      throw new IndexOutOfBoundsException(zzak(paramInt));
  }

  private final String zzak(int paramInt)
  {
    int i = this.size;
    return 35 + "Index:" + paramInt + ", Size:" + i;
  }

  private final void zzk(int paramInt, long paramLong)
  {
    zzua();
    if ((paramInt < 0) || (paramInt > this.size))
      throw new IndexOutOfBoundsException(zzak(paramInt));
    if (this.size < this.zzcag.length)
      System.arraycopy(this.zzcag, paramInt, this.zzcag, paramInt + 1, this.size - paramInt);
    while (true)
    {
      this.zzcag[paramInt] = paramLong;
      this.size = (1 + this.size);
      this.modCount = (1 + this.modCount);
      return;
      long[] arrayOfLong = new long[1 + 3 * this.size / 2];
      System.arraycopy(this.zzcag, 0, arrayOfLong, 0, paramInt);
      System.arraycopy(this.zzcag, paramInt, arrayOfLong, paramInt + 1, this.size - paramInt);
      this.zzcag = arrayOfLong;
    }
  }

  public final boolean addAll(Collection<? extends Long> paramCollection)
  {
    zzua();
    zzuq.checkNotNull(paramCollection);
    boolean bool;
    if (!(paramCollection instanceof zzvj))
      bool = super.addAll(paramCollection);
    zzvj localzzvj;
    int i;
    do
    {
      return bool;
      localzzvj = (zzvj)paramCollection;
      i = localzzvj.size;
      bool = false;
    }
    while (i == 0);
    if (2147483647 - this.size < localzzvj.size)
      throw new OutOfMemoryError();
    int j = this.size + localzzvj.size;
    if (j > this.zzcag.length)
      this.zzcag = Arrays.copyOf(this.zzcag, j);
    System.arraycopy(localzzvj.zzcag, 0, this.zzcag, this.size, localzzvj.size);
    this.size = j;
    this.modCount = (1 + this.modCount);
    return true;
  }

  public final boolean equals(Object paramObject)
  {
    boolean bool1;
    if (this == paramObject)
      bool1 = true;
    zzvj localzzvj;
    int i;
    int j;
    do
    {
      return bool1;
      if (!(paramObject instanceof zzvj))
        return super.equals(paramObject);
      localzzvj = (zzvj)paramObject;
      i = this.size;
      j = localzzvj.size;
      bool1 = false;
    }
    while (i != j);
    long[] arrayOfLong = localzzvj.zzcag;
    for (int k = 0; ; k++)
    {
      if (k >= this.size)
        break label96;
      boolean bool2 = this.zzcag[k] < arrayOfLong[k];
      bool1 = false;
      if (bool2)
        break;
    }
    label96: return true;
  }

  public final long getLong(int paramInt)
  {
    zzaj(paramInt);
    return this.zzcag[paramInt];
  }

  public final int hashCode()
  {
    int i = 1;
    for (int j = 0; j < this.size; j++)
      i = i * 31 + zzuq.zzbd(this.zzcag[j]);
    return i;
  }

  public final boolean remove(Object paramObject)
  {
    zzua();
    for (int i = 0; ; i++)
    {
      int j = this.size;
      boolean bool = false;
      if (i < j)
      {
        if (paramObject.equals(Long.valueOf(this.zzcag[i])))
        {
          System.arraycopy(this.zzcag, i + 1, this.zzcag, i, -1 + (this.size - i));
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
    zzua();
    if (paramInt2 < paramInt1)
      throw new IndexOutOfBoundsException("toIndex < fromIndex");
    System.arraycopy(this.zzcag, paramInt2, this.zzcag, paramInt1, this.size - paramInt2);
    this.size -= paramInt2 - paramInt1;
    this.modCount = (1 + this.modCount);
  }

  public final int size()
  {
    return this.size;
  }

  public final void zzbe(long paramLong)
  {
    zzk(this.size, paramLong);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzvj
 * JD-Core Version:    0.6.2
 */