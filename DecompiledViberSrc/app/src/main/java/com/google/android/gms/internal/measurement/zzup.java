package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzup extends zzta<Integer>
  implements zzuu<Integer>, zzwg, RandomAccess
{
  private static final zzup zzbza;
  private int size;
  private int[] zzbzb;

  static
  {
    zzup localzzup = new zzup();
    zzbza = localzzup;
    localzzup.zzsw();
  }

  zzup()
  {
    this(new int[10], 0);
  }

  private zzup(int[] paramArrayOfInt, int paramInt)
  {
    this.zzbzb = paramArrayOfInt;
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

  private final void zzp(int paramInt1, int paramInt2)
  {
    zzua();
    if ((paramInt1 < 0) || (paramInt1 > this.size))
      throw new IndexOutOfBoundsException(zzak(paramInt1));
    if (this.size < this.zzbzb.length)
      System.arraycopy(this.zzbzb, paramInt1, this.zzbzb, paramInt1 + 1, this.size - paramInt1);
    while (true)
    {
      this.zzbzb[paramInt1] = paramInt2;
      this.size = (1 + this.size);
      this.modCount = (1 + this.modCount);
      return;
      int[] arrayOfInt = new int[1 + 3 * this.size / 2];
      System.arraycopy(this.zzbzb, 0, arrayOfInt, 0, paramInt1);
      System.arraycopy(this.zzbzb, paramInt1, arrayOfInt, paramInt1 + 1, this.size - paramInt1);
      this.zzbzb = arrayOfInt;
    }
  }

  public final boolean addAll(Collection<? extends Integer> paramCollection)
  {
    zzua();
    zzuq.checkNotNull(paramCollection);
    boolean bool;
    if (!(paramCollection instanceof zzup))
      bool = super.addAll(paramCollection);
    zzup localzzup;
    int i;
    do
    {
      return bool;
      localzzup = (zzup)paramCollection;
      i = localzzup.size;
      bool = false;
    }
    while (i == 0);
    if (2147483647 - this.size < localzzup.size)
      throw new OutOfMemoryError();
    int j = this.size + localzzup.size;
    if (j > this.zzbzb.length)
      this.zzbzb = Arrays.copyOf(this.zzbzb, j);
    System.arraycopy(localzzup.zzbzb, 0, this.zzbzb, this.size, localzzup.size);
    this.size = j;
    this.modCount = (1 + this.modCount);
    return true;
  }

  public final boolean equals(Object paramObject)
  {
    boolean bool;
    if (this == paramObject)
      bool = true;
    zzup localzzup;
    int i;
    int j;
    do
    {
      return bool;
      if (!(paramObject instanceof zzup))
        return super.equals(paramObject);
      localzzup = (zzup)paramObject;
      i = this.size;
      j = localzzup.size;
      bool = false;
    }
    while (i != j);
    int[] arrayOfInt = localzzup.zzbzb;
    for (int k = 0; ; k++)
    {
      if (k >= this.size)
        break label99;
      int m = this.zzbzb[k];
      int n = arrayOfInt[k];
      bool = false;
      if (m != n)
        break;
    }
    label99: return true;
  }

  public final int getInt(int paramInt)
  {
    zzaj(paramInt);
    return this.zzbzb[paramInt];
  }

  public final int hashCode()
  {
    int i = 1;
    for (int j = 0; j < this.size; j++)
      i = i * 31 + this.zzbzb[j];
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
        if (paramObject.equals(Integer.valueOf(this.zzbzb[i])))
        {
          System.arraycopy(this.zzbzb, i + 1, this.zzbzb, i, -1 + (this.size - i));
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
    System.arraycopy(this.zzbzb, paramInt2, this.zzbzb, paramInt1, this.size - paramInt2);
    this.size -= paramInt2 - paramInt1;
    this.modCount = (1 + this.modCount);
  }

  public final int size()
  {
    return this.size;
  }

  public final void zzbo(int paramInt)
  {
    zzp(this.size, paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzup
 * JD-Core Version:    0.6.2
 */