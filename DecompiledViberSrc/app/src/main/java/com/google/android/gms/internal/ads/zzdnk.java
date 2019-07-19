package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzdnk extends zzdmk<Double>
  implements zzdoi<Double>, zzdpv, RandomAccess
{
  private static final zzdnk zzhdw;
  private int size;
  private double[] zzhdx;

  static
  {
    zzdnk localzzdnk = new zzdnk(new double[0], 0);
    zzhdw = localzzdnk;
    localzzdnk.zzavj();
  }

  zzdnk()
  {
    this(new double[10], 0);
  }

  private zzdnk(double[] paramArrayOfDouble, int paramInt)
  {
    this.zzhdx = paramArrayOfDouble;
    this.size = paramInt;
  }

  private final void zzd(int paramInt, double paramDouble)
  {
    zzavk();
    if ((paramInt < 0) || (paramInt > this.size))
      throw new IndexOutOfBoundsException(zzfk(paramInt));
    if (this.size < this.zzhdx.length)
      System.arraycopy(this.zzhdx, paramInt, this.zzhdx, paramInt + 1, this.size - paramInt);
    while (true)
    {
      this.zzhdx[paramInt] = paramDouble;
      this.size = (1 + this.size);
      this.modCount = (1 + this.modCount);
      return;
      double[] arrayOfDouble = new double[1 + 3 * this.size / 2];
      System.arraycopy(this.zzhdx, 0, arrayOfDouble, 0, paramInt);
      System.arraycopy(this.zzhdx, paramInt, arrayOfDouble, paramInt + 1, this.size - paramInt);
      this.zzhdx = arrayOfDouble;
    }
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

  public final boolean addAll(Collection<? extends Double> paramCollection)
  {
    zzavk();
    zzdoc.checkNotNull(paramCollection);
    boolean bool;
    if (!(paramCollection instanceof zzdnk))
      bool = super.addAll(paramCollection);
    zzdnk localzzdnk;
    int i;
    do
    {
      return bool;
      localzzdnk = (zzdnk)paramCollection;
      i = localzzdnk.size;
      bool = false;
    }
    while (i == 0);
    if (2147483647 - this.size < localzzdnk.size)
      throw new OutOfMemoryError();
    int j = this.size + localzzdnk.size;
    if (j > this.zzhdx.length)
      this.zzhdx = Arrays.copyOf(this.zzhdx, j);
    System.arraycopy(localzzdnk.zzhdx, 0, this.zzhdx, this.size, localzzdnk.size);
    this.size = j;
    this.modCount = (1 + this.modCount);
    return true;
  }

  public final boolean equals(Object paramObject)
  {
    boolean bool1;
    if (this == paramObject)
      bool1 = true;
    zzdnk localzzdnk;
    int i;
    int j;
    do
    {
      return bool1;
      if (!(paramObject instanceof zzdnk))
        return super.equals(paramObject);
      localzzdnk = (zzdnk)paramObject;
      i = this.size;
      j = localzzdnk.size;
      bool1 = false;
    }
    while (i != j);
    double[] arrayOfDouble = localzzdnk.zzhdx;
    for (int k = 0; ; k++)
    {
      if (k >= this.size)
        break label102;
      boolean bool2 = Double.doubleToLongBits(this.zzhdx[k]) < Double.doubleToLongBits(arrayOfDouble[k]);
      bool1 = false;
      if (bool2)
        break;
    }
    label102: return true;
  }

  public final int hashCode()
  {
    int i = 1;
    for (int j = 0; j < this.size; j++)
    {
      long l = Double.doubleToLongBits(this.zzhdx[j]);
      i = i * 31 + zzdoc.zzft(l);
    }
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
        if (paramObject.equals(Double.valueOf(this.zzhdx[i])))
        {
          System.arraycopy(this.zzhdx, i + 1, this.zzhdx, i, -1 + (this.size - i));
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
    System.arraycopy(this.zzhdx, paramInt2, this.zzhdx, paramInt1, this.size - paramInt2);
    this.size -= paramInt2 - paramInt1;
    this.modCount = (1 + this.modCount);
  }

  public final int size()
  {
    return this.size;
  }

  public final void zzd(double paramDouble)
  {
    zzd(this.size, paramDouble);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdnk
 * JD-Core Version:    0.6.2
 */