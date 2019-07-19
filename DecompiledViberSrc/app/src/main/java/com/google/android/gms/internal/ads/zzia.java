package com.google.android.gms.internal.ads;

public final class zzia
  implements zzio
{
  private final int length;
  private final int[] zzahp;
  private final long[] zzahq;
  private final long[] zzahr;
  private final long[] zzahs;

  public zzia(int[] paramArrayOfInt, long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3)
  {
    this.length = paramArrayOfInt.length;
    this.zzahp = paramArrayOfInt;
    this.zzahq = paramArrayOfLong1;
    this.zzahr = paramArrayOfLong2;
    this.zzahs = paramArrayOfLong3;
  }

  public final long zzdq(long paramLong)
  {
    return this.zzahq[zzkq.zza(this.zzahs, paramLong, true, true)];
  }

  public final boolean zzfc()
  {
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzia
 * JD-Core Version:    0.6.2
 */