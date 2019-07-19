package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zztc extends zzta<Boolean>
  implements zzuu<Boolean>, zzwg, RandomAccess
{
  private static final zztc zzbtq;
  private int size;
  private boolean[] zzbtr;

  static
  {
    zztc localzztc = new zztc();
    zzbtq = localzztc;
    localzztc.zzsw();
  }

  zztc()
  {
    this(new boolean[10], 0);
  }

  private zztc(boolean[] paramArrayOfBoolean, int paramInt)
  {
    this.zzbtr = paramArrayOfBoolean;
    this.size = paramInt;
  }

  private final void zza(int paramInt, boolean paramBoolean)
  {
    zzua();
    if ((paramInt < 0) || (paramInt > this.size))
      throw new IndexOutOfBoundsException(zzak(paramInt));
    if (this.size < this.zzbtr.length)
      System.arraycopy(this.zzbtr, paramInt, this.zzbtr, paramInt + 1, this.size - paramInt);
    while (true)
    {
      this.zzbtr[paramInt] = paramBoolean;
      this.size = (1 + this.size);
      this.modCount = (1 + this.modCount);
      return;
      boolean[] arrayOfBoolean = new boolean[1 + 3 * this.size / 2];
      System.arraycopy(this.zzbtr, 0, arrayOfBoolean, 0, paramInt);
      System.arraycopy(this.zzbtr, paramInt, arrayOfBoolean, paramInt + 1, this.size - paramInt);
      this.zzbtr = arrayOfBoolean;
    }
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

  public final boolean addAll(Collection<? extends Boolean> paramCollection)
  {
    zzua();
    zzuq.checkNotNull(paramCollection);
    boolean bool;
    if (!(paramCollection instanceof zztc))
      bool = super.addAll(paramCollection);
    zztc localzztc;
    int i;
    do
    {
      return bool;
      localzztc = (zztc)paramCollection;
      i = localzztc.size;
      bool = false;
    }
    while (i == 0);
    if (2147483647 - this.size < localzztc.size)
      throw new OutOfMemoryError();
    int j = this.size + localzztc.size;
    if (j > this.zzbtr.length)
      this.zzbtr = Arrays.copyOf(this.zzbtr, j);
    System.arraycopy(localzztc.zzbtr, 0, this.zzbtr, this.size, localzztc.size);
    this.size = j;
    this.modCount = (1 + this.modCount);
    return true;
  }

  public final void addBoolean(boolean paramBoolean)
  {
    zza(this.size, paramBoolean);
  }

  public final boolean equals(Object paramObject)
  {
    boolean bool;
    if (this == paramObject)
      bool = true;
    zztc localzztc;
    int i;
    int j;
    do
    {
      return bool;
      if (!(paramObject instanceof zztc))
        return super.equals(paramObject);
      localzztc = (zztc)paramObject;
      i = this.size;
      j = localzztc.size;
      bool = false;
    }
    while (i != j);
    boolean[] arrayOfBoolean = localzztc.zzbtr;
    for (int k = 0; ; k++)
    {
      if (k >= this.size)
        break label99;
      int m = this.zzbtr[k];
      int n = arrayOfBoolean[k];
      bool = false;
      if (m != n)
        break;
    }
    label99: return true;
  }

  public final int hashCode()
  {
    int i = 1;
    for (int j = 0; j < this.size; j++)
      i = i * 31 + zzuq.zzu(this.zzbtr[j]);
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
        if (paramObject.equals(Boolean.valueOf(this.zzbtr[i])))
        {
          System.arraycopy(this.zzbtr, i + 1, this.zzbtr, i, -1 + (this.size - i));
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
    System.arraycopy(this.zzbtr, paramInt2, this.zzbtr, paramInt1, this.size - paramInt2);
    this.size -= paramInt2 - paramInt1;
    this.modCount = (1 + this.modCount);
  }

  public final int size()
  {
    return this.size;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zztc
 * JD-Core Version:    0.6.2
 */