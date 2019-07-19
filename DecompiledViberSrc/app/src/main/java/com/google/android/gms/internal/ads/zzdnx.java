package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzdnx extends zzdmk<Float>
  implements zzdoi<Float>, zzdpv, RandomAccess
{
  private static final zzdnx zzhgz;
  private int size;
  private float[] zzhha;

  static
  {
    zzdnx localzzdnx = new zzdnx(new float[0], 0);
    zzhgz = localzzdnx;
    localzzdnx.zzavj();
  }

  zzdnx()
  {
    this(new float[10], 0);
  }

  private zzdnx(float[] paramArrayOfFloat, int paramInt)
  {
    this.zzhha = paramArrayOfFloat;
    this.size = paramInt;
  }

  private final void zzc(int paramInt, float paramFloat)
  {
    zzavk();
    if ((paramInt < 0) || (paramInt > this.size))
      throw new IndexOutOfBoundsException(zzfk(paramInt));
    if (this.size < this.zzhha.length)
      System.arraycopy(this.zzhha, paramInt, this.zzhha, paramInt + 1, this.size - paramInt);
    while (true)
    {
      this.zzhha[paramInt] = paramFloat;
      this.size = (1 + this.size);
      this.modCount = (1 + this.modCount);
      return;
      float[] arrayOfFloat = new float[1 + 3 * this.size / 2];
      System.arraycopy(this.zzhha, 0, arrayOfFloat, 0, paramInt);
      System.arraycopy(this.zzhha, paramInt, arrayOfFloat, paramInt + 1, this.size - paramInt);
      this.zzhha = arrayOfFloat;
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

  public final boolean addAll(Collection<? extends Float> paramCollection)
  {
    zzavk();
    zzdoc.checkNotNull(paramCollection);
    boolean bool;
    if (!(paramCollection instanceof zzdnx))
      bool = super.addAll(paramCollection);
    zzdnx localzzdnx;
    int i;
    do
    {
      return bool;
      localzzdnx = (zzdnx)paramCollection;
      i = localzzdnx.size;
      bool = false;
    }
    while (i == 0);
    if (2147483647 - this.size < localzzdnx.size)
      throw new OutOfMemoryError();
    int j = this.size + localzzdnx.size;
    if (j > this.zzhha.length)
      this.zzhha = Arrays.copyOf(this.zzhha, j);
    System.arraycopy(localzzdnx.zzhha, 0, this.zzhha, this.size, localzzdnx.size);
    this.size = j;
    this.modCount = (1 + this.modCount);
    return true;
  }

  public final boolean equals(Object paramObject)
  {
    boolean bool;
    if (this == paramObject)
      bool = true;
    zzdnx localzzdnx;
    int i;
    int j;
    do
    {
      return bool;
      if (!(paramObject instanceof zzdnx))
        return super.equals(paramObject);
      localzzdnx = (zzdnx)paramObject;
      i = this.size;
      j = localzzdnx.size;
      bool = false;
    }
    while (i != j);
    float[] arrayOfFloat = localzzdnx.zzhha;
    for (int k = 0; ; k++)
    {
      if (k >= this.size)
        break label105;
      int m = Float.floatToIntBits(this.zzhha[k]);
      int n = Float.floatToIntBits(arrayOfFloat[k]);
      bool = false;
      if (m != n)
        break;
    }
    label105: return true;
  }

  public final int hashCode()
  {
    int i = 1;
    for (int j = 0; j < this.size; j++)
      i = i * 31 + Float.floatToIntBits(this.zzhha[j]);
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
        if (paramObject.equals(Float.valueOf(this.zzhha[i])))
        {
          System.arraycopy(this.zzhha, i + 1, this.zzhha, i, -1 + (this.size - i));
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
    System.arraycopy(this.zzhha, paramInt2, this.zzhha, paramInt1, this.size - paramInt2);
    this.size -= paramInt2 - paramInt1;
    this.modCount = (1 + this.modCount);
  }

  public final int size()
  {
    return this.size;
  }

  public final void zzi(float paramFloat)
  {
    zzc(this.size, paramFloat);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdnx
 * JD-Core Version:    0.6.2
 */