package com.google.android.gms.internal.wearable;

public final class zzp
  implements Cloneable
{
  private static final zzq zzhe = new zzq();
  private int mSize;
  private boolean zzhf = false;
  private int[] zzhg;
  private zzq[] zzhh;

  zzp()
  {
    this(10);
  }

  private zzp(int paramInt)
  {
    int i = idealIntArraySize(paramInt);
    this.zzhg = new int[i];
    this.zzhh = new zzq[i];
    this.mSize = 0;
  }

  private static int idealIntArraySize(int paramInt)
  {
    int i = paramInt << 2;
    for (int j = 4; ; j++)
      if (j < 32)
      {
        if (i <= -12 + (1 << j))
          i = -12 + (1 << j);
      }
      else
        return i / 4;
  }

  private final int zzq(int paramInt)
  {
    int i = -1 + this.mSize;
    int j = 0;
    int k = i;
    while (j <= k)
    {
      m = j + k >>> 1;
      int n = this.zzhg[m];
      if (n < paramInt)
      {
        j = m + 1;
      }
      else
      {
        if (n <= paramInt)
          break label69;
        k = m - 1;
      }
    }
    int m = j ^ 0xFFFFFFFF;
    label69: return m;
  }

  public final boolean equals(Object paramObject)
  {
    if (paramObject == this);
    label147: label153: label157: 
    while (true)
    {
      return true;
      if (!(paramObject instanceof zzp))
        return false;
      zzp localzzp = (zzp)paramObject;
      if (this.mSize != localzzp.mSize)
        return false;
      int[] arrayOfInt1 = this.zzhg;
      int[] arrayOfInt2 = localzzp.zzhg;
      int i = this.mSize;
      int j = 0;
      int k;
      label76: int n;
      if (j < i)
        if (arrayOfInt1[j] != arrayOfInt2[j])
        {
          k = 0;
          if (k != 0)
          {
            zzq[] arrayOfzzq1 = this.zzhh;
            zzq[] arrayOfzzq2 = localzzp.zzhh;
            int m = this.mSize;
            n = 0;
            label102: if (n >= m)
              break label153;
            if (arrayOfzzq1[n].equals(arrayOfzzq2[n]))
              break label147;
          }
        }
      for (int i1 = 0; ; i1 = 1)
      {
        if (i1 != 0)
          break label157;
        return false;
        j++;
        break;
        k = 1;
        break label76;
        n++;
        break label102;
      }
    }
  }

  public final int hashCode()
  {
    int i = 17;
    for (int j = 0; j < this.mSize; j++)
      i = 31 * (i * 31 + this.zzhg[j]) + this.zzhh[j].hashCode();
    return i;
  }

  public final boolean isEmpty()
  {
    return this.mSize == 0;
  }

  final int size()
  {
    return this.mSize;
  }

  final void zza(int paramInt, zzq paramzzq)
  {
    int i = zzq(paramInt);
    if (i >= 0)
    {
      this.zzhh[i] = paramzzq;
      return;
    }
    int j = i ^ 0xFFFFFFFF;
    if ((j < this.mSize) && (this.zzhh[j] == zzhe))
    {
      this.zzhg[j] = paramInt;
      this.zzhh[j] = paramzzq;
      return;
    }
    if (this.mSize >= this.zzhg.length)
    {
      int k = idealIntArraySize(1 + this.mSize);
      int[] arrayOfInt = new int[k];
      zzq[] arrayOfzzq = new zzq[k];
      System.arraycopy(this.zzhg, 0, arrayOfInt, 0, this.zzhg.length);
      System.arraycopy(this.zzhh, 0, arrayOfzzq, 0, this.zzhh.length);
      this.zzhg = arrayOfInt;
      this.zzhh = arrayOfzzq;
    }
    if (this.mSize - j != 0)
    {
      System.arraycopy(this.zzhg, j, this.zzhg, j + 1, this.mSize - j);
      System.arraycopy(this.zzhh, j, this.zzhh, j + 1, this.mSize - j);
    }
    this.zzhg[j] = paramInt;
    this.zzhh[j] = paramzzq;
    this.mSize = (1 + this.mSize);
  }

  final zzq zzo(int paramInt)
  {
    int i = zzq(paramInt);
    if ((i < 0) || (this.zzhh[i] == zzhe))
      return null;
    return this.zzhh[i];
  }

  final zzq zzp(int paramInt)
  {
    return this.zzhh[paramInt];
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.wearable.zzp
 * JD-Core Version:    0.6.2
 */