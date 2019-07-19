package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzul extends zzta<Float>
  implements zzuu<Float>, zzwg, RandomAccess
{
  private static final zzul zzbyb;
  private int size;
  private float[] zzbyc;

  static
  {
    zzul localzzul = new zzul();
    zzbyb = localzzul;
    localzzul.zzsw();
  }

  zzul()
  {
    this(new float[10], 0);
  }

  private zzul(float[] paramArrayOfFloat, int paramInt)
  {
    this.zzbyc = paramArrayOfFloat;
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

  private final void zzc(int paramInt, float paramFloat)
  {
    zzua();
    if ((paramInt < 0) || (paramInt > this.size))
      throw new IndexOutOfBoundsException(zzak(paramInt));
    if (this.size < this.zzbyc.length)
      System.arraycopy(this.zzbyc, paramInt, this.zzbyc, paramInt + 1, this.size - paramInt);
    while (true)
    {
      this.zzbyc[paramInt] = paramFloat;
      this.size = (1 + this.size);
      this.modCount = (1 + this.modCount);
      return;
      float[] arrayOfFloat = new float[1 + 3 * this.size / 2];
      System.arraycopy(this.zzbyc, 0, arrayOfFloat, 0, paramInt);
      System.arraycopy(this.zzbyc, paramInt, arrayOfFloat, paramInt + 1, this.size - paramInt);
      this.zzbyc = arrayOfFloat;
    }
  }

  public final boolean addAll(Collection<? extends Float> paramCollection)
  {
    zzua();
    zzuq.checkNotNull(paramCollection);
    boolean bool;
    if (!(paramCollection instanceof zzul))
      bool = super.addAll(paramCollection);
    zzul localzzul;
    int i;
    do
    {
      return bool;
      localzzul = (zzul)paramCollection;
      i = localzzul.size;
      bool = false;
    }
    while (i == 0);
    if (2147483647 - this.size < localzzul.size)
      throw new OutOfMemoryError();
    int j = this.size + localzzul.size;
    if (j > this.zzbyc.length)
      this.zzbyc = Arrays.copyOf(this.zzbyc, j);
    System.arraycopy(localzzul.zzbyc, 0, this.zzbyc, this.size, localzzul.size);
    this.size = j;
    this.modCount = (1 + this.modCount);
    return true;
  }

  public final boolean equals(Object paramObject)
  {
    boolean bool;
    if (this == paramObject)
      bool = true;
    zzul localzzul;
    int i;
    int j;
    do
    {
      return bool;
      if (!(paramObject instanceof zzul))
        return super.equals(paramObject);
      localzzul = (zzul)paramObject;
      i = this.size;
      j = localzzul.size;
      bool = false;
    }
    while (i != j);
    float[] arrayOfFloat = localzzul.zzbyc;
    for (int k = 0; ; k++)
    {
      if (k >= this.size)
        break label105;
      int m = Float.floatToIntBits(this.zzbyc[k]);
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
      i = i * 31 + Float.floatToIntBits(this.zzbyc[j]);
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
        if (paramObject.equals(Float.valueOf(this.zzbyc[i])))
        {
          System.arraycopy(this.zzbyc, i + 1, this.zzbyc, i, -1 + (this.size - i));
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
    System.arraycopy(this.zzbyc, paramInt2, this.zzbyc, paramInt1, this.size - paramInt2);
    this.size -= paramInt2 - paramInt1;
    this.modCount = (1 + this.modCount);
  }

  public final int size()
  {
    return this.size;
  }

  public final void zzc(float paramFloat)
  {
    zzc(this.size, paramFloat);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzul
 * JD-Core Version:    0.6.2
 */