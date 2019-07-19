package com.google.android.gms.internal.ads;

final class zziz
{
  public final int[] zzahp;
  public final long[] zzahq;
  public final int[] zzajr;
  public final int zzand;
  public final long[] zzane;

  zziz(long[] paramArrayOfLong1, int[] paramArrayOfInt1, long[] paramArrayOfLong2, int[] paramArrayOfInt2)
  {
    boolean bool2;
    boolean bool3;
    if (paramArrayOfInt1.length == paramArrayOfLong2.length)
    {
      bool2 = bool1;
      zzkh.checkArgument(bool2);
      if (paramArrayOfLong1.length != paramArrayOfLong2.length)
        break label86;
      bool3 = bool1;
      label34: zzkh.checkArgument(bool3);
      if (paramArrayOfInt2.length != paramArrayOfLong2.length)
        break label92;
    }
    while (true)
    {
      zzkh.checkArgument(bool1);
      this.zzahq = paramArrayOfLong1;
      this.zzahp = paramArrayOfInt1;
      this.zzane = paramArrayOfLong2;
      this.zzajr = paramArrayOfInt2;
      this.zzand = paramArrayOfLong1.length;
      return;
      bool2 = false;
      break;
      label86: bool3 = false;
      break label34;
      label92: bool1 = false;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zziz
 * JD-Core Version:    0.6.2
 */