package com.google.android.gms.internal.ads;

public final class zzdrs
  implements Cloneable
{
  private static final zzdrt zzhnq = new zzdrt();
  private int mSize;
  private boolean zzhnr = false;
  private int[] zzhns;
  private zzdrt[] zzhnt;

  zzdrs()
  {
    this(10);
  }

  private zzdrs(int paramInt)
  {
    int i = paramInt << 2;
    for (int j = 4; ; j++)
      if (j < 32)
      {
        if (i <= -12 + (1 << j))
          i = -12 + (1 << j);
      }
      else
      {
        int k = i / 4;
        this.zzhns = new int[k];
        this.zzhnt = new zzdrt[k];
        this.mSize = 0;
        return;
      }
  }

  public final boolean equals(Object paramObject)
  {
    if (paramObject == this);
    label147: label153: label157: 
    while (true)
    {
      return true;
      if (!(paramObject instanceof zzdrs))
        return false;
      zzdrs localzzdrs = (zzdrs)paramObject;
      if (this.mSize != localzzdrs.mSize)
        return false;
      int[] arrayOfInt1 = this.zzhns;
      int[] arrayOfInt2 = localzzdrs.zzhns;
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
            zzdrt[] arrayOfzzdrt1 = this.zzhnt;
            zzdrt[] arrayOfzzdrt2 = localzzdrs.zzhnt;
            int m = this.mSize;
            n = 0;
            label102: if (n >= m)
              break label153;
            if (arrayOfzzdrt1[n].equals(arrayOfzzdrt2[n]))
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
      i = 31 * (i * 31 + this.zzhns[j]) + this.zzhnt[j].hashCode();
    return i;
  }

  final int size()
  {
    return this.mSize;
  }

  final zzdrt zzhf(int paramInt)
  {
    return this.zzhnt[paramInt];
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdrs
 * JD-Core Version:    0.6.2
 */