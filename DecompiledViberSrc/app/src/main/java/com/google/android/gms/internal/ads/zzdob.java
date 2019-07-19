package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzdob extends zzdmk<Integer>
  implements zzdog, zzdpv, RandomAccess
{
  private static final zzdob zzhhy;
  private int size;
  private int[] zzhhz;

  static
  {
    zzdob localzzdob = new zzdob(new int[0], 0);
    zzhhy = localzzdob;
    localzzdob.zzavj();
  }

  zzdob()
  {
    this(new int[10], 0);
  }

  private zzdob(int[] paramArrayOfInt, int paramInt)
  {
    this.zzhhz = paramArrayOfInt;
    this.size = paramInt;
  }

  private final void zzaj(int paramInt1, int paramInt2)
  {
    zzavk();
    if ((paramInt1 < 0) || (paramInt1 > this.size))
      throw new IndexOutOfBoundsException(zzfk(paramInt1));
    if (this.size < this.zzhhz.length)
      System.arraycopy(this.zzhhz, paramInt1, this.zzhhz, paramInt1 + 1, this.size - paramInt1);
    while (true)
    {
      this.zzhhz[paramInt1] = paramInt2;
      this.size = (1 + this.size);
      this.modCount = (1 + this.modCount);
      return;
      int[] arrayOfInt = new int[1 + 3 * this.size / 2];
      System.arraycopy(this.zzhhz, 0, arrayOfInt, 0, paramInt1);
      System.arraycopy(this.zzhhz, paramInt1, arrayOfInt, paramInt1 + 1, this.size - paramInt1);
      this.zzhhz = arrayOfInt;
    }
  }

  public static zzdob zzayc()
  {
    return zzhhy;
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

  public final boolean addAll(Collection<? extends Integer> paramCollection)
  {
    zzavk();
    zzdoc.checkNotNull(paramCollection);
    boolean bool;
    if (!(paramCollection instanceof zzdob))
      bool = super.addAll(paramCollection);
    zzdob localzzdob;
    int i;
    do
    {
      return bool;
      localzzdob = (zzdob)paramCollection;
      i = localzzdob.size;
      bool = false;
    }
    while (i == 0);
    if (2147483647 - this.size < localzzdob.size)
      throw new OutOfMemoryError();
    int j = this.size + localzzdob.size;
    if (j > this.zzhhz.length)
      this.zzhhz = Arrays.copyOf(this.zzhhz, j);
    System.arraycopy(localzzdob.zzhhz, 0, this.zzhhz, this.size, localzzdob.size);
    this.size = j;
    this.modCount = (1 + this.modCount);
    return true;
  }

  public final boolean equals(Object paramObject)
  {
    boolean bool;
    if (this == paramObject)
      bool = true;
    zzdob localzzdob;
    int i;
    int j;
    do
    {
      return bool;
      if (!(paramObject instanceof zzdob))
        return super.equals(paramObject);
      localzzdob = (zzdob)paramObject;
      i = this.size;
      j = localzzdob.size;
      bool = false;
    }
    while (i != j);
    int[] arrayOfInt = localzzdob.zzhhz;
    for (int k = 0; ; k++)
    {
      if (k >= this.size)
        break label99;
      int m = this.zzhhz[k];
      int n = arrayOfInt[k];
      bool = false;
      if (m != n)
        break;
    }
    label99: return true;
  }

  public final int getInt(int paramInt)
  {
    zzfj(paramInt);
    return this.zzhhz[paramInt];
  }

  public final int hashCode()
  {
    int i = 1;
    for (int j = 0; j < this.size; j++)
      i = i * 31 + this.zzhhz[j];
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
        if (paramObject.equals(Integer.valueOf(this.zzhhz[i])))
        {
          System.arraycopy(this.zzhhz, i + 1, this.zzhhz, i, -1 + (this.size - i));
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
    System.arraycopy(this.zzhhz, paramInt2, this.zzhhz, paramInt1, this.size - paramInt2);
    this.size -= paramInt2 - paramInt1;
    this.modCount = (1 + this.modCount);
  }

  public final int size()
  {
    return this.size;
  }

  public final zzdog zzgo(int paramInt)
  {
    if (paramInt < this.size)
      throw new IllegalArgumentException();
    return new zzdob(Arrays.copyOf(this.zzhhz, paramInt), this.size);
  }

  public final void zzgp(int paramInt)
  {
    zzaj(this.size, paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdob
 * JD-Core Version:    0.6.2
 */