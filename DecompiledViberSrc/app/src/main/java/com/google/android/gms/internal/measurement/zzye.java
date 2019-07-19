package com.google.android.gms.internal.measurement;

public final class zzye
  implements Cloneable
{
  private static final zzyf zzcey = new zzyf();
  private int mSize;
  private boolean zzcez = false;
  private int[] zzcfa;
  private zzyf[] zzcfb;

  zzye()
  {
    this(10);
  }

  private zzye(int paramInt)
  {
    int i = idealIntArraySize(paramInt);
    this.zzcfa = new int[i];
    this.zzcfb = new zzyf[i];
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

  private final int zzcg(int paramInt)
  {
    int i = -1 + this.mSize;
    int j = 0;
    int k = i;
    while (j <= k)
    {
      m = j + k >>> 1;
      int n = this.zzcfa[m];
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
      if (!(paramObject instanceof zzye))
        return false;
      zzye localzzye = (zzye)paramObject;
      if (this.mSize != localzzye.mSize)
        return false;
      int[] arrayOfInt1 = this.zzcfa;
      int[] arrayOfInt2 = localzzye.zzcfa;
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
            zzyf[] arrayOfzzyf1 = this.zzcfb;
            zzyf[] arrayOfzzyf2 = localzzye.zzcfb;
            int m = this.mSize;
            n = 0;
            label102: if (n >= m)
              break label153;
            if (arrayOfzzyf1[n].equals(arrayOfzzyf2[n]))
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
      i = 31 * (i * 31 + this.zzcfa[j]) + this.zzcfb[j].hashCode();
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

  final void zza(int paramInt, zzyf paramzzyf)
  {
    int i = zzcg(paramInt);
    if (i >= 0)
    {
      this.zzcfb[i] = paramzzyf;
      return;
    }
    int j = i ^ 0xFFFFFFFF;
    if ((j < this.mSize) && (this.zzcfb[j] == zzcey))
    {
      this.zzcfa[j] = paramInt;
      this.zzcfb[j] = paramzzyf;
      return;
    }
    if (this.mSize >= this.zzcfa.length)
    {
      int k = idealIntArraySize(1 + this.mSize);
      int[] arrayOfInt = new int[k];
      zzyf[] arrayOfzzyf = new zzyf[k];
      System.arraycopy(this.zzcfa, 0, arrayOfInt, 0, this.zzcfa.length);
      System.arraycopy(this.zzcfb, 0, arrayOfzzyf, 0, this.zzcfb.length);
      this.zzcfa = arrayOfInt;
      this.zzcfb = arrayOfzzyf;
    }
    if (this.mSize - j != 0)
    {
      System.arraycopy(this.zzcfa, j, this.zzcfa, j + 1, this.mSize - j);
      System.arraycopy(this.zzcfb, j, this.zzcfb, j + 1, this.mSize - j);
    }
    this.zzcfa[j] = paramInt;
    this.zzcfb[j] = paramzzyf;
    this.mSize = (1 + this.mSize);
  }

  final zzyf zzce(int paramInt)
  {
    int i = zzcg(paramInt);
    if ((i < 0) || (this.zzcfb[i] == zzcey))
      return null;
    return this.zzcfb[i];
  }

  final zzyf zzcf(int paramInt)
  {
    return this.zzcfb[paramInt];
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzye
 * JD-Core Version:    0.6.2
 */