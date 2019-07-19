package com.google.android.gms.internal.ads;

import java.util.Arrays;

public class zzrd
  implements zzrm
{
  private final int length;
  private int zzafx;
  private final zzlh[] zzbju;
  private final zzra zzbky;
  private final int[] zzbkz;
  private final long[] zzbla;

  public zzrd(zzra paramzzra, int[] paramArrayOfInt)
  {
    if (paramArrayOfInt.length > 0);
    for (boolean bool = true; ; bool = false)
    {
      zzsk.checkState(bool);
      this.zzbky = ((zzra)zzsk.checkNotNull(paramzzra));
      this.length = paramArrayOfInt.length;
      this.zzbju = new zzlh[this.length];
      for (int j = 0; j < paramArrayOfInt.length; j++)
        this.zzbju[j] = paramzzra.zzbf(paramArrayOfInt[j]);
    }
    Arrays.sort(this.zzbju, new zzrf(null));
    this.zzbkz = new int[this.length];
    while (i < this.length)
    {
      this.zzbkz[i] = paramzzra.zzh(this.zzbju[i]);
      i++;
    }
    this.zzbla = new long[this.length];
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    zzrd localzzrd;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localzzrd = (zzrd)paramObject;
    }
    while ((this.zzbky == localzzrd.zzbky) && (Arrays.equals(this.zzbkz, localzzrd.zzbkz)));
    return false;
  }

  public int hashCode()
  {
    if (this.zzafx == 0)
      this.zzafx = (31 * System.identityHashCode(this.zzbky) + Arrays.hashCode(this.zzbkz));
    return this.zzafx;
  }

  public final int length()
  {
    return this.zzbkz.length;
  }

  public final zzlh zzbf(int paramInt)
  {
    return this.zzbju[paramInt];
  }

  public final int zzbh(int paramInt)
  {
    return this.zzbkz[0];
  }

  public final zzra zzjr()
  {
    return this.zzbky;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzrd
 * JD-Core Version:    0.6.2
 */