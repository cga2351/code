package com.google.android.gms.internal.ads;

public final class zznl
  implements zznu
{
  private final int length;
  private final long zzack;
  private final int[] zzahp;
  private final long[] zzahq;
  private final long[] zzahr;
  private final long[] zzahs;

  public zznl(int[] paramArrayOfInt, long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3)
  {
    this.zzahp = paramArrayOfInt;
    this.zzahq = paramArrayOfLong1;
    this.zzahr = paramArrayOfLong2;
    this.zzahs = paramArrayOfLong3;
    this.length = paramArrayOfInt.length;
    if (this.length > 0)
    {
      this.zzack = (paramArrayOfLong2[(-1 + this.length)] + paramArrayOfLong3[(-1 + this.length)]);
      return;
    }
    this.zzack = 0L;
  }

  public final long getDurationUs()
  {
    return this.zzack;
  }

  public final long zzdq(long paramLong)
  {
    return this.zzahq[zzsy.zza(this.zzahs, paramLong, true, true)];
  }

  public final boolean zzfc()
  {
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zznl
 * JD-Core Version:    0.6.2
 */