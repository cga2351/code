package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzdmo extends zzdmk<Boolean>
  implements zzdoi<Boolean>, zzdpv, RandomAccess
{
  private static final zzdmo zzhcp;
  private int size;
  private boolean[] zzhcq;

  static
  {
    zzdmo localzzdmo = new zzdmo(new boolean[0], 0);
    zzhcp = localzzdmo;
    localzzdmo.zzavj();
  }

  zzdmo()
  {
    this(new boolean[10], 0);
  }

  private zzdmo(boolean[] paramArrayOfBoolean, int paramInt)
  {
    this.zzhcq = paramArrayOfBoolean;
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

  private final void zzh(int paramInt, boolean paramBoolean)
  {
    zzavk();
    if ((paramInt < 0) || (paramInt > this.size))
      throw new IndexOutOfBoundsException(zzfk(paramInt));
    if (this.size < this.zzhcq.length)
      System.arraycopy(this.zzhcq, paramInt, this.zzhcq, paramInt + 1, this.size - paramInt);
    while (true)
    {
      this.zzhcq[paramInt] = paramBoolean;
      this.size = (1 + this.size);
      this.modCount = (1 + this.modCount);
      return;
      boolean[] arrayOfBoolean = new boolean[1 + 3 * this.size / 2];
      System.arraycopy(this.zzhcq, 0, arrayOfBoolean, 0, paramInt);
      System.arraycopy(this.zzhcq, paramInt, arrayOfBoolean, paramInt + 1, this.size - paramInt);
      this.zzhcq = arrayOfBoolean;
    }
  }

  public final boolean addAll(Collection<? extends Boolean> paramCollection)
  {
    zzavk();
    zzdoc.checkNotNull(paramCollection);
    boolean bool;
    if (!(paramCollection instanceof zzdmo))
      bool = super.addAll(paramCollection);
    zzdmo localzzdmo;
    int i;
    do
    {
      return bool;
      localzzdmo = (zzdmo)paramCollection;
      i = localzzdmo.size;
      bool = false;
    }
    while (i == 0);
    if (2147483647 - this.size < localzzdmo.size)
      throw new OutOfMemoryError();
    int j = this.size + localzzdmo.size;
    if (j > this.zzhcq.length)
      this.zzhcq = Arrays.copyOf(this.zzhcq, j);
    System.arraycopy(localzzdmo.zzhcq, 0, this.zzhcq, this.size, localzzdmo.size);
    this.size = j;
    this.modCount = (1 + this.modCount);
    return true;
  }

  public final void addBoolean(boolean paramBoolean)
  {
    zzh(this.size, paramBoolean);
  }

  public final boolean equals(Object paramObject)
  {
    boolean bool;
    if (this == paramObject)
      bool = true;
    zzdmo localzzdmo;
    int i;
    int j;
    do
    {
      return bool;
      if (!(paramObject instanceof zzdmo))
        return super.equals(paramObject);
      localzzdmo = (zzdmo)paramObject;
      i = this.size;
      j = localzzdmo.size;
      bool = false;
    }
    while (i != j);
    boolean[] arrayOfBoolean = localzzdmo.zzhcq;
    for (int k = 0; ; k++)
    {
      if (k >= this.size)
        break label99;
      int m = this.zzhcq[k];
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
      i = i * 31 + zzdoc.zzbh(this.zzhcq[j]);
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
        if (paramObject.equals(Boolean.valueOf(this.zzhcq[i])))
        {
          System.arraycopy(this.zzhcq, i + 1, this.zzhcq, i, -1 + (this.size - i));
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
    System.arraycopy(this.zzhcq, paramInt2, this.zzhcq, paramInt1, this.size - paramInt2);
    this.size -= paramInt2 - paramInt1;
    this.modCount = (1 + this.modCount);
  }

  public final int size()
  {
    return this.size;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdmo
 * JD-Core Version:    0.6.2
 */