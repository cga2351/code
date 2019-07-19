package com.google.android.gms.internal.ads;

final class zzpc
{
  public final int[] zzahp;
  public final long[] zzahq;
  public final int[] zzajr;
  public final int zzand;
  public final long[] zzane;
  public final int zzbet;

  public zzpc(long[] paramArrayOfLong1, int[] paramArrayOfInt1, int paramInt, long[] paramArrayOfLong2, int[] paramArrayOfInt2)
  {
    boolean bool2;
    boolean bool3;
    if (paramArrayOfInt1.length == paramArrayOfLong2.length)
    {
      bool2 = bool1;
      zzsk.checkArgument(bool2);
      if (paramArrayOfLong1.length != paramArrayOfLong2.length)
        break label95;
      bool3 = bool1;
      label36: zzsk.checkArgument(bool3);
      if (paramArrayOfInt2.length != paramArrayOfLong2.length)
        break label101;
    }
    while (true)
    {
      zzsk.checkArgument(bool1);
      this.zzahq = paramArrayOfLong1;
      this.zzahp = paramArrayOfInt1;
      this.zzbet = paramInt;
      this.zzane = paramArrayOfLong2;
      this.zzajr = paramArrayOfInt2;
      this.zzand = paramArrayOfLong1.length;
      return;
      bool2 = false;
      break;
      label95: bool3 = false;
      break label36;
      label101: bool1 = false;
    }
  }

  public final int zzej(long paramLong)
  {
    for (int i = zzsy.zza(this.zzane, paramLong, true, false); i >= 0; i--)
      if ((0x1 & this.zzajr[i]) != 0)
        return i;
    return -1;
  }

  public final int zzek(long paramLong)
  {
    for (int i = zzsy.zzb(this.zzane, paramLong, true, false); i < this.zzane.length; i++)
      if ((0x1 & this.zzajr[i]) != 0)
        return i;
    return -1;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzpc
 * JD-Core Version:    0.6.2
 */