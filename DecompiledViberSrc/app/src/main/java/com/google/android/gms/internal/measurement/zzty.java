package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzty extends zzta<Double>
  implements zzuu<Double>, zzwg, RandomAccess
{
  private static final zzty zzbuz;
  private int size;
  private double[] zzbva;

  static
  {
    zzty localzzty = new zzty();
    zzbuz = localzzty;
    localzzty.zzsw();
  }

  zzty()
  {
    this(new double[10], 0);
  }

  private zzty(double[] paramArrayOfDouble, int paramInt)
  {
    this.zzbva = paramArrayOfDouble;
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

  private final void zzc(int paramInt, double paramDouble)
  {
    zzua();
    if ((paramInt < 0) || (paramInt > this.size))
      throw new IndexOutOfBoundsException(zzak(paramInt));
    if (this.size < this.zzbva.length)
      System.arraycopy(this.zzbva, paramInt, this.zzbva, paramInt + 1, this.size - paramInt);
    while (true)
    {
      this.zzbva[paramInt] = paramDouble;
      this.size = (1 + this.size);
      this.modCount = (1 + this.modCount);
      return;
      double[] arrayOfDouble = new double[1 + 3 * this.size / 2];
      System.arraycopy(this.zzbva, 0, arrayOfDouble, 0, paramInt);
      System.arraycopy(this.zzbva, paramInt, arrayOfDouble, paramInt + 1, this.size - paramInt);
      this.zzbva = arrayOfDouble;
    }
  }

  public final boolean addAll(Collection<? extends Double> paramCollection)
  {
    zzua();
    zzuq.checkNotNull(paramCollection);
    boolean bool;
    if (!(paramCollection instanceof zzty))
      bool = super.addAll(paramCollection);
    zzty localzzty;
    int i;
    do
    {
      return bool;
      localzzty = (zzty)paramCollection;
      i = localzzty.size;
      bool = false;
    }
    while (i == 0);
    if (2147483647 - this.size < localzzty.size)
      throw new OutOfMemoryError();
    int j = this.size + localzzty.size;
    if (j > this.zzbva.length)
      this.zzbva = Arrays.copyOf(this.zzbva, j);
    System.arraycopy(localzzty.zzbva, 0, this.zzbva, this.size, localzzty.size);
    this.size = j;
    this.modCount = (1 + this.modCount);
    return true;
  }

  public final boolean equals(Object paramObject)
  {
    boolean bool1;
    if (this == paramObject)
      bool1 = true;
    zzty localzzty;
    int i;
    int j;
    do
    {
      return bool1;
      if (!(paramObject instanceof zzty))
        return super.equals(paramObject);
      localzzty = (zzty)paramObject;
      i = this.size;
      j = localzzty.size;
      bool1 = false;
    }
    while (i != j);
    double[] arrayOfDouble = localzzty.zzbva;
    for (int k = 0; ; k++)
    {
      if (k >= this.size)
        break label102;
      boolean bool2 = Double.doubleToLongBits(this.zzbva[k]) < Double.doubleToLongBits(arrayOfDouble[k]);
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
      long l = Double.doubleToLongBits(this.zzbva[j]);
      i = i * 31 + zzuq.zzbd(l);
    }
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
        if (paramObject.equals(Double.valueOf(this.zzbva[i])))
        {
          System.arraycopy(this.zzbva, i + 1, this.zzbva, i, -1 + (this.size - i));
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
    System.arraycopy(this.zzbva, paramInt2, this.zzbva, paramInt1, this.size - paramInt2);
    this.size -= paramInt2 - paramInt1;
    this.modCount = (1 + this.modCount);
  }

  public final int size()
  {
    return this.size;
  }

  public final void zzd(double paramDouble)
  {
    zzc(this.size, paramDouble);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzty
 * JD-Core Version:    0.6.2
 */